package local.tux.app.web.controller;

import org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import local.tux.app.web.common.controller.LookUpTableController;
import local.tux.app.web.common.controller.TuxBaseObjectsController;

public class SpecialController extends TuxBaseObjectsController {

	
	public DetachedCriteria getCriteria(){
		DetachedCriteria criteria = super.getCriteria();
		criteria.add(Restrictions.isNotNull("discountPrice"));
		return criteria;
		
	}
}
