package local.tux.app.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.appfuse.model.User;
import org.displaytag.properties.SortOrderEnum;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.web.servlet.ModelAndView;

import local.tux.Constants;
import local.tux.app.web.common.controller.TuxBaseObjectsController;
import local.tux.app.web.table.pagination.ExtendedPaginatedList;

public class SubCatalogController extends TuxBaseObjectsController {

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
		DetachedCriteria criteria = getCriteria();
		if (StringUtils.isBlank(request.getParameter("pid"))!= false){
			criteria.createAlias("catalog", "parent");
			criteria.add(Restrictions.eq("parent.id", new Long(request.getParameter("pid"))));
		}
		lookupManager.getRecordsPage(getCriteria(), paginatedList);
		mav.addObject(KEY_REFERENCE_LIST,paginatedList);
		return mav;
		
	}
	
}
