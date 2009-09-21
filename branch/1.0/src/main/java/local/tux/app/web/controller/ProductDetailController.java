package local.tux.app.web.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.ModelAndView;


import local.tux.app.model.Product;
import local.tux.app.service.LookUpNameGenericManager;
import local.tux.app.web.common.controller.TuxBaseObjectsController;

/**
 * 
 * @author Ben Li
 *
 */
public class ProductDetailController extends TuxBaseObjectsController {

	private LookUpNameGenericManager<Product, Long> productManager;
	public void setProductManager(LookUpNameGenericManager<Product, Long> productManager){
		this.productManager = productManager;
	}
	public  ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		
		//request.
		Product product = null;
		ModelAndView mav = new ModelAndView();
		String id = request.getParameter("id");
		if (StringUtils.isBlank(id)== false){
			if (productManager.exists(new Long(id))){
				product = productManager.get(new Long(id));
				mav.addObject("product", product);
			}
		}
		return mav;
	}
}
