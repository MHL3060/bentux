package local.tux.app.web.controller;

import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import local.tux.app.model.News;
import local.tux.app.service.LookUpNameGenericManager;

import org.apache.commons.lang.StringUtils;
import org.appfuse.service.UserManager;
import org.appfuse.webapp.controller.BaseFormController;
import org.springframework.validation.BindException;

import org.springframework.web.servlet.ModelAndView;

public class NewsFormController extends BaseFormController{

	private LookUpNameGenericManager<News, Long> newsManager;

	public NewsFormController(){
		setCommandClass(News.class);
		setCommandName("news");
	}
	
	public void setNewsManager(LookUpNameGenericManager<News, Long> newsManager){
		this.newsManager = newsManager;
	}
	public Object formBackingObject(HttpServletRequest request) throws Exception {
		
		if (StringUtils.isBlank(request.getParameter("id"))){
			return new News();
		}else {
			return newsManager.get(new Long(request.getParameter("id")));
		}
	}
	 
	public ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command,
            BindException errors) throws Exception {
		
		log.debug("entering 'onSubmit' method...");
		
		News news = (News)command;
		boolean isNew = (news.getId() == null);
		String success = getSuccessView();
		Locale locale = request.getLocale();
		
		if (request.getParameter("delete") != null) {
			newsManager.remove(news.getId());
			saveMessage(request, getText("news.deleted", locale));
		} else {
			news.setAddedOn(new Date());
			news.setUser(getUserManager().getUserByUsername(request.getRemoteUser()));
			newsManager.save(news);
			String key = (isNew) ? "news.added" : "news.updated";
			saveMessage(request, getText(key, locale));

			if (!isNew) {
				success = "redirect:newsform.html?id=" + news.getId();
			}
		}

		return new ModelAndView(success);
	}
}
