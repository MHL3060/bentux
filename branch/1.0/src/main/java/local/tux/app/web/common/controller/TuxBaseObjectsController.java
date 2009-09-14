package local.tux.app.web.common.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import local.tux.Constants;
import local.tux.app.model.common.TuxBaseObject;
import local.tux.app.web.table.pagination.ExtendedPaginatedList;
import local.tux.app.web.table.pagination.PaginateListFactory;
import local.tux.app.web.table.pagination.PagingLookupManager;

import org.displaytag.properties.SortOrderEnum;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 * general controller to handle display all request.
 * @author Ben Li
 *
 */
public class TuxBaseObjectsController implements Controller {

	protected String KEY_REFERENCE_LIST = "tuxBaseObjectList";
	protected PaginateListFactory factory;
	protected  PagingLookupManager lookupManager;
	protected Class<TuxBaseObject> clazz;
	
	public void setPaginatedListFactory(PaginateListFactory factory){
		this.factory = factory;
	}
	public void setPagingLookupManager(PagingLookupManager lookupManager){
		this.lookupManager = lookupManager;
	}
	public void setPojo(Class<TuxBaseObject> clazz){
		this.clazz = clazz;
	}
	public PaginateListFactory getPaginateListFactory() {
        return factory;
    }
	
	/**
	 * the key for the default list is tuxBaseObjectList.
	 * 
	 */
	public  ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		
		String sortByColumn = request.getParameter("sort") == null ? "id" : request.getParameter("sort");
		SortOrderEnum orderEnum = SortOrderEnum.DESCENDING;
		String direction = request.getParameter("dir");
		if ( direction != null && direction.contains("asc")){
			orderEnum = SortOrderEnum.ASCENDING;
		}
		
		ExtendedPaginatedList paginatedList = factory.getPaginatedListFromRequest(request);
		paginatedList.setPageSize(Constants.PAGE_SIZE);
		paginatedList.setSortCriterion(sortByColumn);
		paginatedList.setSortDirection(orderEnum);
		lookupManager.getAllRecordsPage(clazz, paginatedList);
		ModelAndView mav = new ModelAndView().addObject(KEY_REFERENCE_LIST,paginatedList);
		return mav;
	}

	
}
