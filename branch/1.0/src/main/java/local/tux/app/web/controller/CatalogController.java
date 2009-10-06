package local.tux.app.web.controller;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import local.tux.app.web.common.controller.TuxBaseObjectsController;

public class CatalogController extends TuxBaseObjectsController {
	
	public DetachedCriteria getCriteria(){
		DetachedCriteria criteria = super.getCriteria();
		criteria.add(Restrictions.isNull("parent"));
		return criteria;
	}

}
