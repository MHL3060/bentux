package local.tux.app.dao.hibernate;


import java.math.BigDecimal;
import java.util.List;



import local.tux.app.dao.PagingLookupDao;


import org.appfuse.dao.hibernate.UniversalDaoHibernate;
import org.displaytag.properties.SortOrderEnum;
import org.hibernate.SQLQuery;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.impl.CriteriaImpl;
import org.springframework.orm.hibernate3.HibernateTemplate;


public class PagingLookupDaoHibernate extends UniversalDaoHibernate implements
		PagingLookupDao {



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

	public int getAllRecordsCount(String query) {
		HibernateTemplate hibernateTemplate = getHibernateTemplate();
		SQLQuery sqlQuery = hibernateTemplate.getSessionFactory().openSession()
				.createSQLQuery("select count(*) from (" + query + ")");
		return ((BigDecimal) sqlQuery.list().get(0)).intValue();
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
		
		Session session = getSession();
		CriteriaImpl ci = (CriteriaImpl) criteria.getExecutableCriteria(session);
		int count = 0;
		ScrollableResults sResult = ci.scroll();
		if (sResult.last()){
			count =  sResult.getRowNumber() + 1;
		}
		sResult.close();
		session.disconnect();
		return count;
	}
}

