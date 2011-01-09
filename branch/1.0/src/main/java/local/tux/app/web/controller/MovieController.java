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
import org.hibernate.criterion.Order;

import local.tux.Constants;
import local.tux.app.web.common.controller.TuxBaseObjectsController;
import local.tux.app.model.Catalog;
import local.tux.app.model.EntertainmentService;
import local.tux.app.service.CatalogManager;
import local.tux.app.service.LookUpNameGenericManager;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


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
		
		/*DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		
		Date startDate = (Date)format.parse("2005-01-01 00:00:00");
		Date endDate = (Date)format.parse("2005-03-03 00:00:00");
		
		example of Between
		crit.add(Expression.between ("investementDate", new Date(startDate.getTime()),new Date(endDate.getTime()))); //
		
		/*example of le and ge*/
		/*
		List list = getSession().createCriteria(Department.class).
              add(Restrictions.ge(deptDate,startDate)).
              add(Restrictions.le(deptDate,endDate)).
              list();
		*/
		
		/* The current Date*/
        Date cur_date = new Date();
        
        /* This approach has will resolve the issue if today's date matches the showTo (show end date), make sure it will still list the movie out */
		Calendar cal = Calendar.getInstance();;       
		cal.add(Calendar.DATE, -1);

		
		DetachedCriteria criteria = super.getCriteria(request);
		Long catalogId = new Long(Constants.CATALOG_ENTERTAIN_SERIVCE);
	
		Catalog p = catalogManager.get(catalogId);
		

	    criteria.createAlias("entertainmentService","entertainmentService");

		criteria.add( Restrictions.le("entertainmentService.showFrom", cur_date ) ); 
		criteria.add( Restrictions.ge("entertainmentService.showTo", cal.getTime() ) ); 

		/* Please refer to the catalog id for movie service */
		/* i.e. The second layer id for the movie service */
		criteria.add(Restrictions.eq("catalog.id", new Long(137)));
	    criteria.addOrder(Order.desc("entertainmentService.id") );

		return criteria;
     }
}		 

