package local.tux.app.web.table.pagination;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.appfuse.dao.UniversalDao;
import org.displaytag.properties.SortOrderEnum;
import org.hibernate.criterion.DetachedCriteria;

public interface PagingLookupDao extends UniversalDao {
     List getAllRecordsPage(Class clazz, int firstResult, int maxResults,
            SortOrderEnum sortDirection, String sortCriterion);
     int getAllRecordsCount(Class clazz);
     
     public List getRecordsPage(DetachedCriteria criteria, int firstResult, int maxResults,
 			SortOrderEnum sortDirection, String sortCriterion);
     public int getRecordsPageCount(DetachedCriteria criteria);
     
     public int getAllRecordsCount(String query);
    
     
     public List<Map<String,String>> getAllRecordsPage(String query, int firstResult,
 			int maxResults, SortOrderEnum sortDirection, String sortCriterion)
 			throws SQLException;
    
     public List getAllRecordsPage(Class clazz, String query, int firstResult,
  			int maxResults, SortOrderEnum sortDirection, String sortCriterion)
  			throws SQLException;
}
