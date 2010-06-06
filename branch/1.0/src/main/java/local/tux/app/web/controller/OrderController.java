package local.tux.app.web.controller;

import java.lang.annotation.Annotation;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import local.tux.Constants.CART_STATUS;
import local.tux.app.model.ShoppingCart;
import local.tux.app.web.table.pagination.ExtendedPaginatedList;
import local.tux.app.web.table.pagination.PaginateListFactory;
import local.tux.app.web.table.pagination.PagingLookupManager;

import org.apache.commons.lang.StringUtils;
import org.appfuse.Constants;
import org.appfuse.model.User;
import org.appfuse.service.UserManager;
import org.displaytag.properties.SortOrderEnum;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;


public class OrderController implements Controller {

	private UserManager userManager;
	private PaginateListFactory factory;
	private int pageSize;
	private PagingLookupManager lookupManager;
	public void setUserManager(UserManager userManager){
		this.userManager = userManager;
	}
	
	public void setPaginatedListFactory(PaginateListFactory factory){
		this.factory = factory;
	}
	
	public void setSize(int size){
		this.pageSize = size;
	}
	
	public void setPagingLookupManager(PagingLookupManager lookupManager){
		this.lookupManager = lookupManager;
	}
	public  ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		
		ModelAndView mav = new ModelAndView();
		
		
		
		String sortByColumn = request.getParameter("sort") == null ? "id" : request.getParameter("sort");
		SortOrderEnum orderEnum = SortOrderEnum.DESCENDING;
		String direction = request.getParameter("dir");
		if ( direction != null && direction.contains("asc")){
			orderEnum = SortOrderEnum.ASCENDING;
		}
		
		
		ExtendedPaginatedList paginatedList = factory.getPaginatedListFromRequest(request);
		paginatedList.setPageSize(pageSize);
		paginatedList.setSortCriterion(sortByColumn);
		paginatedList.setSortDirection(orderEnum);
		lookupManager.getRecordsPage(getCriteria(request), paginatedList);
		
		mav.addObject("orders",paginatedList);
		
		return mav;
		
	}

	private DetachedCriteria getCriteria(HttpServletRequest request) {
		
		DetachedCriteria criteria = DetachedCriteria.forClass(ShoppingCart.class);
		
		String cartOwner = request.getParameter("from");
		String viewOption = request.getParameter("status");
		String currentUser = request.getRemoteUser();
		User user = userManager.getUserByUsername(currentUser);
		
		if (request.isUserInRole(Constants.ADMIN_ROLE)){
			if(StringUtils.isBlank(viewOption) == false){
				criteria.add(Restrictions.eq("status", CART_STATUS.SUBMITTED));
			}
			if (StringUtils.isBlank(cartOwner) ==false ) {
				user = userManager.getUserByUsername(cartOwner);
				criteria.add(Restrictions.eq("user", user));
			}
		}else {
			criteria.add(Restrictions.eq("user", user));
		}
		
		return criteria;
	}

	
}
