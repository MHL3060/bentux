package local.tux.app.web.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import local.tux.Constants;
import local.tux.app.web.common.controller.TuxBaseObjectsController;
import local.tux.app.model.Catalog;
import local.tux.app.model.EntertainmentService;
import local.tux.app.service.CatalogManager;
import local.tux.app.service.LookUpNameGenericManager;

public class MovieController extends ProductListController {
	
	private CatalogManager catalogManager;
	private LookUpNameGenericManager<EntertainmentService, Long> entertainmentServiceManager;
	
	public void setCatalogManager(CatalogManager catalogManager){
		this.catalogManager = catalogManager;
	}
	
	public void setEntertainmentServiceManager(LookUpNameGenericManager<EntertainmentService, Long> entertainmentServiceManager){
		this.entertainmentServiceManager = entertainmentServiceManager;
	}
	
	@SuppressWarnings("unchecked")
	public DetachedCriteria getCriteria(HttpServletRequest request){	
		
		
		/*Calendar cal = new GregorianCalendar();
 
		int month = cal.get(Calendar.MONTH);
		
		*/
		DetachedCriteria criteria = super.getCriteria(request);
		Long catalogId = new Long(Constants.CATALOG_ENTERTAIN_SERIVCE);
	
		Catalog p = catalogManager.get(catalogId);

		criteria.add(Restrictions.eq("catalog.id", Constants.MOVIE_CATALOG));
		
		return criteria;
     }
}		 

