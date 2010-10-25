package local.tux.app.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.ModelAndView;

import local.tux.app.model.News;
import local.tux.app.service.LookUpNameGenericManager;
import local.tux.app.web.common.controller.TuxBaseObjectsController;

public class NewsController extends TuxBaseObjectsController {

	private LookUpNameGenericManager<News, Long> newsManager;
	public void setNewsManager(LookUpNameGenericManager<News, Long> newsManager){
		this.newsManager = newsManager;
	}
	public  ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		
		ModelAndView mav = new ModelAndView();
		if (StringUtils.isBlank(request.getParameter("id"))) {
			mav = super.handleRequest(request, response);
			
		}else {
			News news = newsManager.get(new Long(request.getParameter("id")));
			mav.addObject("news", news);
		}
		return mav;
	}
}
