package local.tux.app.web.table.pagination;

import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import local.tux.Constants;
import local.tux.HibernateUtil;


import org.apache.commons.collections.map.ListOrderedMap;
import org.apache.commons.dbutils.BeanProcessor;
import org.apache.commons.dbutils.DbUtils;
import org.appfuse.dao.hibernate.UniversalDaoHibernate;
import org.displaytag.properties.SortOrderEnum;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.impl.CriteriaImpl;
import org.springframework.orm.hibernate3.HibernateTemplate;


public class PagingLookupDaoHibernate extends UniversalDaoHibernate implements
		PagingLookupDao {

	private SimpleDateFormat sdf = new SimpleDateFormat(Constants.DATE_PATTERN + " HH:mm:ss ");
	private DataSource ds = null;

	@SuppressWarnings("unchecked")
	public int getAllRecordsCount(Class clazz) {
		int count = 0;
		DetachedCriteria criteria = DetachedCriteria.forClass(clazz);
		criteria.setProjection(Projections.rowCount());
		List results = getHibernateTemplate().findByCriteria(criteria);
		if (results.size() > 0){
			count = ((Integer) results.get(0)).intValue();
		}
		return count;
	}

	@SuppressWarnings("unchecked")
	public List getAllRecordsPage(Class clazz, int firstResult, int maxResults,
			SortOrderEnum sortDirection, String sortCriterion) {
		DetachedCriteria criteria = DetachedCriteria.forClass(clazz);
		if (sortCriterion != null) {
			if (sortDirection.equals(SortOrderEnum.ASCENDING)) {
				criteria.addOrder(Order.asc(sortCriterion));
			}
			if (sortDirection.equals(SortOrderEnum.DESCENDING)) {
				criteria.addOrder(Order.desc(sortCriterion));
			}
		}
		List results = getHibernateTemplate().findByCriteria(criteria,
				firstResult, maxResults);
		return results;
	}

	@SuppressWarnings("unchecked")
	public List getAllRecordsPage(Class clazz, String query, int firstResult,
			int maxResults, SortOrderEnum sortDirection, String sortCriterion)
			throws SQLException {
		//String sql = query.toLowerCase();
		//query = addRownum(query);
		String sql = "select * from (select rownum r, javaOracleQuery.* from (" + query + ") javaOracleQuery) where r between ? and ?";
		BeanProcessor bp = new DbProcess();
		
		Connection connection = ds.getConnection();
		PreparedStatement prepare = connection.prepareStatement(sql);
		prepare.setInt(1, firstResult);
		prepare.setInt(2, maxResults + firstResult);
		ResultSet rs = prepare.executeQuery();
		List list = bp.toBeanList(rs, clazz);
		rs.close();
		prepare.close();
		connection.close();
		return list;
	}

	@SuppressWarnings("unchecked")
	public List getRecordsPage(DetachedCriteria criteria, int firstResult,
			int maxResults, SortOrderEnum sortDirection, String sortCriterion) {
		
		if (sortCriterion != null) {
			if (sortDirection.equals(SortOrderEnum.ASCENDING)) {
				criteria.addOrder(Order.asc(sortCriterion));
			}
			if (sortDirection.equals(SortOrderEnum.DESCENDING)) {
				criteria.addOrder(Order.desc(sortCriterion));
			}
		}
		
		List results = getHibernateTemplate().findByCriteria(criteria,
				firstResult, maxResults);
		return results;
	}

	public int getRecordsPageCount(final DetachedCriteria criteria) {
		int count = 0;
		Session session = getSession();
		ScrollableResults sResult = null;
		Criteria ci ;
		//try the optimal way first.
		try {
			DetachedCriteria clone = HibernateUtil.copy(criteria);
			clone.setProjection(Projections.rowCount());
			ci = clone.getExecutableCriteria(session);
			sResult = ci.scroll();
			if (sResult.next()){
				count = sResult.getInteger(0);
			}
		//the optimal way doesn't work. use the inefficient way
		}catch (Exception e){
			ci = (CriteriaImpl) criteria.getExecutableCriteria(session);
			sResult = ci.scroll();
			if (sResult.last()){
				count =  sResult.getRowNumber() + 1;
			}
		}
		if (sResult != null){
			sResult.close();
		}
		session.disconnect();
		return count;
	}
	
	private class DbProcess extends BeanProcessor {
		@SuppressWarnings("unchecked")
		protected int[] mapColumnsToProperties(ResultSetMetaData rsmd,
	            PropertyDescriptor[] props) throws SQLException {

	        int cols = rsmd.getColumnCount();
	        int columnToProperty[] = new int[cols + 1];
	        Arrays.fill(columnToProperty, PROPERTY_NOT_FOUND);

	        for (int col = 1; col <= cols; col++) {
	            String columnName = rsmd.getColumnName(col);
	            if (columnName.equalsIgnoreCase("r")==false){
		            for (int i = 0; i < props.length; i++) {
		                if (columnName.equalsIgnoreCase(props[i].getName())) {
		                    columnToProperty[col] = i;
		                    break;
		                }
		            }
	            }
	        }

	        return columnToProperty;
	    }
	}
}

