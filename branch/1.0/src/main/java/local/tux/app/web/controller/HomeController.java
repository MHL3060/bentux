package local.tux.app.web.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.appfuse.model.User;
import org.displaytag.pagination.PaginatedList;
import org.springframework.web.servlet.ModelAndView;

import local.tux.app.web.common.controller.TuxBaseObjectsController;

public class HomeController extends TuxBaseObjectsController {
	
	public HomeController(){
		pageSize = 5;
	}
	public  ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		setSize(5);
		ModelAndView mav = super.handleRequest(request, response);
		Map map =mav.getModel();
		PaginatedList list = (PaginatedList) map.get(super.KEY_REFERENCE_LIST);
		mav.addObject(KEY_REFERENCE_LIST, list.getList());
		return mav;
	}
}
