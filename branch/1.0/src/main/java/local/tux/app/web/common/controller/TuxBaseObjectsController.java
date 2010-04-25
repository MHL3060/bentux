package local.tux.app.web.common.controller;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import local.tux.Constants;
import local.tux.Constants.CART_STATUS;
import local.tux.app.model.ShoppingCart;
import local.tux.app.model.common.TuxBaseObject;
import local.tux.app.service.ShoppingCartManager;
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
	protected String CART_ITEM_COUNT = "cart_item_count";
	protected String CART_SUBTOTAL = "cart_sub_total";
	
	protected String USER = "user";
	protected PaginateListFactory factory;
	protected  PagingLookupManager lookupManager;
	protected Class<TuxBaseObject> clazz;
	protected int pageSize = Constants.PAGE_SIZE;
	protected final String HAS_PERMISSION = "hasPermission";
	protected UserManager userManager;
	protected ShoppingCartManager shoppingCartManager;
	
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
	public void setSize(int size){
		this.pageSize = size;
	}
	
	public void setShoppingCartManager(ShoppingCartManager shoppingCartManager){
		this.shoppingCartManager = shoppingCartManager;
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
			mav.addObject(USER, user);
			mav.addObject(CART_ITEM_COUNT, shoppingCartManager.getOpenItemCount(user.getId()));
			
			mav.addObject(CART_SUBTOTAL, shoppingCartManager.getSubTotal(shoppingCartManager.getOpenCart(user)));
		}
		ExtendedPaginatedList paginatedList = factory.getPaginatedListFromRequest(request);
		paginatedList.setPageSize(pageSize);
		paginatedList.setSortCriterion(sortByColumn);
		paginatedList.setSortDirection(orderEnum);
		lookupManager.getRecordsPage(getCriteria(request), paginatedList);
		//((local.tux.app.model.Product)paginatedList.getList().get(0)).getImages().;
		mav.addObject(KEY_REFERENCE_LIST,paginatedList);
		
		return mav;
	}
	/**
	 * you should override this function.
	 * @return
	 */
	public DetachedCriteria getCriteria(HttpServletRequest request){
		DetachedCriteria criteria = DetachedCriteria.forClass(clazz);
		return criteria;
		
	}
	protected Boolean hasPermissionToAdd(User user){
		boolean result = Boolean.FALSE;
		if (user != null){
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
		}
		return result;
	}
	
	
}
