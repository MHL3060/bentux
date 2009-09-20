package local.tux.app.web.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import local.tux.Constants;
import local.tux.TuxBaseObjectConverter;
import local.tux.app.model.Catalog;
import local.tux.app.model.Manufacturer;
import local.tux.app.model.Product;
import local.tux.app.model.common.LookUpBaseObject;
import local.tux.app.model.common.TuxBaseObject;
import local.tux.app.service.LookUpNameGenericManager;

import org.apache.commons.lang.StringUtils;
import org.appfuse.webapp.controller.BaseFormController;
import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;

public class ProductFormController extends BaseFormController {

	private LookUpNameGenericManager catalogManager;
	private LookUpNameGenericManager manufacturerManager;
	private LookUpNameGenericManager productManager;

	public void setCatalogManager(LookUpNameGenericManager catalogManager){
		this.catalogManager = catalogManager;
	}
	public void setManufacturerManager(LookUpNameGenericManager manufacturerManager){
		this.manufacturerManager = manufacturerManager;
	}
	public void setProductManager(LookUpNameGenericManager productManager){
		this.productManager = productManager;
	}
	
	public void initBinder(HttpServletRequest request, ServletRequestDataBinder binder){
		super.initBinder(request, binder);
		
		TuxBaseObjectConverter catalogConverter = new TuxBaseObjectConverter(catalogManager);
		binder.registerCustomEditor(Catalog.class, catalogConverter);
		binder.registerCustomEditor(Manufacturer.class, new TuxBaseObjectConverter(manufacturerManager));
	}

	@SuppressWarnings("unchecked")
	protected Map referenceData(HttpServletRequest request){
		Map models = new HashMap(); 
		models.put("catalogs", catalogManager.getAll());
		models.put("manufacturers", manufacturerManager.getAll());
		models.put("units", Constants.WEIGHT_UNIT);
		return models;
	}
	
	protected Object formBackingObject(HttpServletRequest request) throws Exception{
		String id = request.getParameter("id");
		if (!StringUtils.isBlank(id)){
			return productManager.get(new Long(id));
		}
		return new Product();
	}

	
	public ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, 
			Object command, BindException errors) throws Exception{

	
		Product product = (Product)command;
		String className = command.getClass().getSimpleName();
		boolean isNew = (product.getId() == null);
		Locale locale = request.getLocale();
		String successView = getSuccessView();
		try {
			if (request.getParameter(Constants.DELETE_OBJECT) != null){
				productManager.remove(product.getId());
				saveMessage(request, getText(className+".deleted", locale));
			}else {
				productManager.save(product);
				String key = (isNew) ? className+ ".added" : className + ".updated";
				saveMessage(request, getText(key, locale));
			}
			if (!isNew) {
                successView = "redirect:productform.html?id=" + product.getId();
            }
		}catch (Exception e){
			saveError(request, getText("object.exists",locale));
			log.error(e);
		}
		return new ModelAndView(successView);
	}
}
