package local.tux.app.web.table.pagination;

import java.sql.SQLException;

import org.hibernate.criterion.DetachedCriteria;

public interface PagingLookupManager {
    
	public ExtendedPaginatedList getAllRecordsPage(Class clazz, ExtendedPaginatedList paginatedList);
	
	
	
	public ExtendedPaginatedList getRecordsPage(DetachedCriteria criteria, ExtendedPaginatedList paginatedList);
	
}
