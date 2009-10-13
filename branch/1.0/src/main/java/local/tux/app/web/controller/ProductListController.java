package local.tux.app.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;

import local.tux.app.model.Catalog;
import local.tux.app.service.LookUpNameGenericManager;
import local.tux.app.web.common.controller.TuxBaseObjectsController;



public class ProductListController extends TuxBaseObjectsController {

	public DetachedCriteria getCriteria(HttpServletRequest request){
		DetachedCriteria criteria = super.getCriteria(request);
		String catalogId = request.getParameter("catalogId");
		if (StringUtils.isBlank(catalogId)== false){
			criteria.createAlias("catalogs", "catalog");
			criteria.add(Restrictions.eq("catalog.id", new Long(catalogId)));
		}
		return criteria;
	}
}
