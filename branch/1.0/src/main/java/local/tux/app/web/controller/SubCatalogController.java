package local.tux.app.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.appfuse.model.User;
import org.displaytag.properties.SortOrderEnum;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.web.servlet.ModelAndView;

import local.tux.Constants;
import local.tux.app.model.Catalog;
import local.tux.app.service.CatalogManager;
import local.tux.app.web.common.controller.TuxBaseObjectsController;
import local.tux.app.web.table.pagination.ExtendedPaginatedList;

public class SubCatalogController extends TuxBaseObjectsController {

	
	private CatalogManager catalogManager;

	public void setCatalogManager(CatalogManager catalogManager){
		this.catalogManager = catalogManager;
	}
	
	public DetachedCriteria getCriteria(HttpServletRequest request){
		DetachedCriteria criteria = super.getCriteria(request);
		if (StringUtils.isBlank(request.getParameter("pid"))== false){
			Catalog parent = new Catalog();
			parent.setId(new Long(request.getParameter("pid")));
			criteria.add(Restrictions.eq("parent", parent));
		}
		criteria.addOrder(Order.asc("name"));
		return criteria;
	}
	
	public  ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		
		ModelAndView mv = super.handleRequest(request, response);
		
		mv.addObject("catalogs", catalogManager.getparents());
		return mv;
	}
}
