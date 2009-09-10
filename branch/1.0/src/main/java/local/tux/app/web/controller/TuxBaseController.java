package local.tux.app.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import local.tux.app.model.common.TuxBaseObject;
import local.tux.table.pagination.ExtendedPaginatedList;
import local.tux.table.pagination.PaginateListFactory;
import local.tux.table.pagination.PagingLookupManager;

import org.displaytag.properties.SortOrderEnum;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 * general controller to handle display all request.
 * @author Ben Li
 *
 */
public class TuxBaseController implements Controller {

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
	/**
	 * the key for the default list is tuxBaseObjectList.
	 * 
	 */
	public  ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		
		String sortByColumn = request.getParameter("sort") == null ? "startDateTime" : request.getParameter("sort");
		SortOrderEnum orderEnum = SortOrderEnum.DESCENDING;
		String direction = request.getParameter("dir");
		if ( direction != null && direction.contains("asc")){
			orderEnum = SortOrderEnum.ASCENDING;
		}
		
		ExtendedPaginatedList paginatedList = factory.getPaginatedListFromRequest(request);
		paginatedList.setPageSize(1000);
		paginatedList.setSortCriterion(sortByColumn);
		paginatedList.setSortDirection(orderEnum);
		lookupManager.getAllRecordsPage(clazz, paginatedList);
		ModelAndView mav = new ModelAndView().addObject(KEY_REFERENCE_LIST,paginatedList);
		return mav;
	}

	
}
