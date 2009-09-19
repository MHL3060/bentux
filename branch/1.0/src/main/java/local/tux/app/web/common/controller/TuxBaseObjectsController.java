package local.tux.app.web.common.controller;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import local.tux.Constants;
import local.tux.app.model.common.TuxBaseObject;
import local.tux.app.web.table.pagination.ExtendedPaginatedList;
import local.tux.app.web.table.pagination.PaginateListFactory;
import local.tux.app.web.table.pagination.PagingLookupManager;

import org.apache.commons.lang.StringUtils;
import org.appfuse.model.Role;
import org.appfuse.model.User;
import org.appfuse.service.UserManager;
import org.displaytag.properties.SortOrderEnum;
import org.hibernate.criterion.DetachedCriteria;
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
	
	private final String HAS_PERMISSION = "hasPermission";
	private UserManager userManager;
	
	public void setUserManager(UserManager userManager){
		this.userManager = userManager;
	}
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
		ModelAndView mav = new ModelAndView();
		String sortByColumn = request.getParameter("sort") == null ? "id" : request.getParameter("sort");
		SortOrderEnum orderEnum = SortOrderEnum.DESCENDING;
		String direction = request.getParameter("dir");
		if ( direction != null && direction.contains("asc")){
			orderEnum = SortOrderEnum.ASCENDING;
		}
		
		if (StringUtils.isBlank(request.getRemoteUser())) {
			mav.addObject(HAS_PERMISSION, Boolean.FALSE);
		}else {
			User user = userManager.getUserByUsername(request.getRemoteUser());
			mav.addObject(HAS_PERMISSION, hasPermissionToAdd(user));
		}
		ExtendedPaginatedList paginatedList = factory.getPaginatedListFromRequest(request);
		paginatedList.setPageSize(Constants.PAGE_SIZE);
		paginatedList.setSortCriterion(sortByColumn);
		paginatedList.setSortDirection(orderEnum);
		lookupManager.getRecordsPage(getCriteria(), paginatedList);
		mav.addObject(KEY_REFERENCE_LIST,paginatedList);
		return mav;
	}
	/**
	 * you should override this function.
	 * @return
	 */
	public DetachedCriteria getCriteria(){
		DetachedCriteria criteria = DetachedCriteria.forClass(clazz);
		return criteria;
		
	}
	protected Boolean hasPermissionToAdd(User user){
		boolean result = Boolean.FALSE;
		Set<Role> roles = user.getRoles();
		for (Role role : roles){
			for (String name : Constants.EDIT_PERMISSION){
				if (name.equals(role.getName())){
					result = Boolean.TRUE;
					break;
				}
			}
			if (result){
				break;
			}
		}
		return result;
	}

	
}
