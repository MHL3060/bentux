package local.tux.app.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import local.tux.app.web.common.controller.TuxBaseObjectsController;

public class CatalogController extends TuxBaseObjectsController {
	
	public DetachedCriteria getCriteria(HttpServletRequest request){
		DetachedCriteria criteria = super.getCriteria(request);
		criteria.add(Restrictions.isNull("parent"));
		return criteria;
	}

}
