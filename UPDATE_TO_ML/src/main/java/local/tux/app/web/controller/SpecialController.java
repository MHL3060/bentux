package local.tux.app.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import local.tux.app.web.common.controller.TuxBaseFormController;
import local.tux.app.web.common.controller.TuxBaseObjectsController;

public class SpecialController extends TuxBaseObjectsController {

	
	public DetachedCriteria getCriteria(HttpServletRequest request){
		DetachedCriteria criteria = super.getCriteria(request);
		criteria.add(Restrictions.isNotNull("discountPrice"));
		return criteria;
		
	}
}
