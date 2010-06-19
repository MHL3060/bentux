package local.tux.app.web.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.appfuse.model.User;
import org.displaytag.pagination.PaginatedList;
import org.springframework.web.servlet.ModelAndView;

import local.tux.Constants;
import local.tux.app.model.News;
import local.tux.app.service.LookUpNameGenericManager;
import local.tux.app.web.common.controller.TuxBaseObjectsController;

public class HomeController extends TuxBaseObjectsController {
	
	private LookUpNameGenericManager<News, Long> newsManager;
	public HomeController(){
		pageSize = 5;
	}
	public void setNewsManager(LookUpNameGenericManager<News, Long> newsManager){
		this.newsManager = newsManager;
	}
	public  ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		
		Calendar reference = Calendar.getInstance();
		Date today = reference.getTime();
		reference.add(Calendar.DATE, Constants.NEWS_BACK_TO);
		
		Date from = reference.getTime();
		
		setSize(Constants.NEWS_DISPLAY_ITEM);
		ModelAndView mav = super.handleRequest(request, response);
		Map map =mav.getModel();
		
		PaginatedList list = (PaginatedList) map.get(super.KEY_REFERENCE_LIST);
		mav.addObject(KEY_REFERENCE_LIST, list.getList());
		mav.addObject("latestNews", newsManager.getItemsInInterval("addedOn", from, today));
		return mav;
	}
}
