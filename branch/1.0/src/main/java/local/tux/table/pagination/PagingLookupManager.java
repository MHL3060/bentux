package local.tux.table.pagination;

import java.sql.SQLException;

import org.hibernate.criterion.DetachedCriteria;

public interface PagingLookupManager {
    
	public ExtendedPaginatedList getAllRecordsPage(Class clazz, ExtendedPaginatedList paginatedList);
	public ExtendedPaginatedList getAllRecordsPage(String query, 
			ExtendedPaginatedList paginatedList) throws SQLException;
	
	public ExtendedPaginatedList getAllRecordsPage(Class type, String query, 
			ExtendedPaginatedList paginatedList) throws SQLException;
	public ExtendedPaginatedList getRecordsPage(DetachedCriteria criteria, ExtendedPaginatedList paginatedList);
	
}
