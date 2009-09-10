package local.tux.table.pagination;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;


import org.apache.commons.collections.map.CaseInsensitiveMap;
import org.displaytag.pagination.PaginatedList;
import org.displaytag.properties.SortOrderEnum;

public class PaginatedResultSet implements PaginatedList {
	private final int rows;
	private final int pageSize;
	private final int pageNumber;
	private final boolean ascending;
	private final String sortCriterion;
	private final List list = new ArrayList();
	private SimpleDateFormat sdf = new SimpleDateFormat();
	/**
	 * Creates a new instance of PaginatedResultSet 
	 **/
	public PaginatedResultSet(Connection conn, ResultSet rs, int rows, int pageSize, int pageNumber,
			boolean ascending, String sortCriterion) throws SQLException {
		this.rows = rows;
		this.pageSize = pageSize;
		this.pageNumber = pageNumber;
		this.ascending = ascending;
		this.sortCriterion = sortCriterion;

		ResultSetMetaData meta = rs.getMetaData();
		

		while (rs.next()) {
			Map map = new CaseInsensitiveMap();
			int n = meta.getColumnCount();
			for (int i = 1; i <= n; i++) {
				String name = meta.getColumnName(i);
				Object value = rs.getObject(i);
				String str = ObjectToString(value, conn);
				map.put(name, str);
			}
			list.add(map);
		}
	}

	public int getFullListSize() {
		return rows;
	}

	public List getList() {
		return list;
	}

	public int getObjectsPerPage() {
		return pageSize;
	}

	public int getPageNumber() {
		return pageNumber + 1;
	}

	public String getSearchId() {
		return null;
	}

	public String getSortCriterion() {
		return sortCriterion;
	}

	public SortOrderEnum getSortDirection() {
		return ascending ? SortOrderEnum.ASCENDING : SortOrderEnum.DESCENDING;
	}

	private String ObjectToString(Object value, Connection con) throws SQLException {
		if (value != null) {
			//if (value instanceof Date) {
				return value.toString();
			//}

			
		} else {
			return null;
		}
	}
}

