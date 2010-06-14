package local.tux.app.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;

import local.tux.Constants;
import local.tux.EnumPropertyConverter;
import local.tux.Constants.CART_STATUS;
import local.tux.app.model.ShoppingCart;
import local.tux.app.model.common.ValuePair;
import local.tux.app.model.common.LookUpBaseObject;
import local.tux.app.web.common.controller.TuxBaseFormController;

public class CartFormController extends TuxBaseFormController {

	public Map referenceData(HttpServletRequest request, Object command,
			Errors error) throws Exception {
		
		Map result = new HashMap();
		result.put("statuses",CART_STATUS.values());
		return result;
	}
	
	
	public void initBinder(HttpServletRequest request, ServletRequestDataBinder binder){
		super.initBinder(request, binder);
		EnumPropertyConverter converter = new EnumPropertyConverter(CART_STATUS.values());
		binder.registerCustomEditor(Constants.CART_STATUS.class, converter);
		
	}
	
	
	public ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, 
			Object command, BindException error) throws Exception {
		
		ShoppingCart cart = (ShoppingCart) command;
		
		ShoppingCart persistCart = (ShoppingCart) lookUpManager.get(cart.getId());
		persistCart.setStatus(cart.getStatus());
		lookUpManager.save(persistCart);
		return new ModelAndView(getSuccessView());
	}
	
	private ValuePair[] convert(CART_STATUS[] status){
		ValuePair[] valuePairs = new ValuePair[status.length];
		int i = 0;
		for(CART_STATUS s : status){
			ValuePair v = new ValuePair();
			v.setId(new Long(s.ordinal()));
			v.setName(s.name());
			valuePairs[i] = v;
			i++;
		}
		return valuePairs;
		
	}
	
}
