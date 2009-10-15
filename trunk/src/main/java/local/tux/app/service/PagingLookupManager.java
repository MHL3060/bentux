package local.tux.app.service;

import java.sql.SQLException;

import local.tux.app.web.paginated.list.ExtendedPaginatedList;

import org.hibernate.criterion.DetachedCriteria;

public interface PagingLookupManager {
    
	@SuppressWarnings("unchecked")
	public ExtendedPaginatedList getAllRecordsPage(Class clazz, ExtendedPaginatedList paginatedList);
	public ExtendedPaginatedList getRecordsPage(DetachedCriteria criteria, ExtendedPaginatedList paginatedList);
	
}
