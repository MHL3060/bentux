package local.tux.app.service.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import local.tux.app.dao.PagingLookupDao;
import local.tux.app.service.PagingLookupManager;
import local.tux.app.web.paginated.list.ExtendedPaginatedList;

import org.appfuse.service.impl.UniversalManagerImpl;
import org.hibernate.criterion.DetachedCriteria;

public class PagingLookupManagerImpl extends UniversalManagerImpl implements
		PagingLookupManager {
	private PagingLookupDao pagingDao;

	/**
	 * Method that allows setting the DAO to talk to the data store with.
	 * 
	 * @param dao
	 *            the dao implementation
	 */
	public void setLookupDao(PagingLookupDao pagingDao) {
		super.dao = pagingDao;
		this.pagingDao = pagingDao;
	}

	@SuppressWarnings("unchecked")
	public ExtendedPaginatedList getAllRecordsPage(Class clazz,
			ExtendedPaginatedList paginatedList) {
		
		List results = pagingDao.getAllRecordsPage(clazz, paginatedList.getFirstRecordIndex(), 
				paginatedList.getPageSize(), paginatedList.getSortDirection(), 
				paginatedList.getSortCriterion());
		paginatedList.setList(results);
		paginatedList.setTotalNumberOfRows(pagingDao.getAllRecordsCount(clazz));
		return paginatedList;
	}

	@SuppressWarnings("unchecked")
	public ExtendedPaginatedList getRecordsPage(DetachedCriteria criteria,
			ExtendedPaginatedList paginatedList) {
		int pageCount = pagingDao.getRecordsPageCount(criteria);
		List results = pagingDao.getRecordsPage(criteria, paginatedList.getFirstRecordIndex(), 
				paginatedList.getPageSize(), paginatedList.getSortDirection(), 
				paginatedList.getSortCriterion());
		paginatedList.setList(results);
		paginatedList.setTotalNumberOfRows(pageCount);
		return paginatedList;
	}
	
	public PagingLookupDao getPagingDao() {
		return pagingDao;
	}

	public void setPagingDao(PagingLookupDao pagingDao) {
		this.pagingDao = pagingDao;
	}

}


