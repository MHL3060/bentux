package local.tux.app.web.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import local.tux.Constants;
import local.tux.TuxBaseObjectConverter;
import local.tux.app.model.BrandName;
import local.tux.app.model.Catalog;
import local.tux.app.model.EntertainmentProduct;
import local.tux.app.model.EntertainmentService;
import local.tux.app.model.FoodProduct;
import local.tux.app.model.Manufacturer;
import local.tux.app.model.Product;
import local.tux.app.model.common.LookUpBaseObject;
import local.tux.app.model.common.TuxBaseObject;
import local.tux.app.service.CatalogManager;
import local.tux.app.service.LookUpNameGenericManager;

import org.apache.commons.lang.StringUtils;
import org.appfuse.webapp.controller.BaseFormController;
import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;

public class ProductFormController extends BaseFormController {

	private CatalogManager catalogManager;
	private LookUpNameGenericManager manufacturerManager;
	private LookUpNameGenericManager productManager;

	private LookUpNameGenericManager<BrandName, Long> brandNameManager;
	private LookUpNameGenericManager ingredientManager;
	
	public void setBrandNameManager(LookUpNameGenericManager<BrandName, Long> brandNameManager){
		this.brandNameManager = brandNameManager;
	}
	
	public void setCatalogManager(CatalogManager catalogManager){
		this.catalogManager = catalogManager;
	}
	public void setManufacturerManager(LookUpNameGenericManager manufacturerManager){
		this.manufacturerManager = manufacturerManager;
	}
	public void setProductManager(LookUpNameGenericManager productManager){
		this.productManager = productManager;
	}
	@SuppressWarnings("unchecked")
	public void setIngredientManager(LookUpNameGenericManager ingredientManager){
		this.ingredientManager = ingredientManager;
	}
	public void initBinder(HttpServletRequest request, ServletRequestDataBinder binder){
		super.initBinder(request, binder);
		
		TuxBaseObjectConverter brandNameConverter = new TuxBaseObjectConverter(brandNameManager);
		binder.registerCustomEditor(BrandName.class, brandNameConverter);
		TuxBaseObjectConverter catalogConverter = new TuxBaseObjectConverter(catalogManager);
		binder.registerCustomEditor(Catalog.class, catalogConverter);
		binder.registerCustomEditor(Manufacturer.class, new TuxBaseObjectConverter(manufacturerManager));
	}

	@SuppressWarnings("unchecked")
	protected Map referenceData(HttpServletRequest request){
		Map models = new HashMap(); 
		models.put("catalogParents", catalogManager.getParents());
		models.put("catalogs", catalogManager.getAllChildren());
		models.put("manufacturers", manufacturerManager.getAll());
		models.put("units", Constants.WEIGHT_UNIT);
		models.put("brandNames", brandNameManager.getAll());
		models.put("foodProduct", Constants.CATALOG_FOOD_PRODUCT);
		models.put("entertainProduct", Constants.CATALOG_ENTERTAIN_PRODUCT);
		models.put("entertainService", Constants.CATALOG_ENTERTAIN_SERIVCE);
		models.put("ingredients", ingredientManager.getAll());
		
		return models;
	}
	
	protected Object formBackingObject(HttpServletRequest request) throws Exception{
		String id = request.getParameter("id");
		if (!StringUtils.isBlank(id)){
			Product product =  (Product) productManager.get(new Long(id));
			if (product.getFoodProduct() == null){
				product.setFoodProduct(new FoodProduct());
			}
			if (product.getEntertainmentProduct() == null){
				product.setEntertainmentProduct(new EntertainmentProduct());
			}
			if (product.getEntertainmentService() == null){
				product.setEntertainmentService(new EntertainmentService());
			}
			return product;
		}
		return new Product();
	}

	
	@SuppressWarnings("unchecked")
	public ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, 
			Object command, BindException errors) throws Exception{

	
		Product product = (Product)command;
		removeUslessProduct(product);
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

	private void removeUslessProduct(Product product) {
		Catalog catalog = product.getCatalogs().iterator().next().getParent();
		if (catalog.getId() == Constants.CATALOG_ENTERTAIN_PRODUCT){
			product.setFoodProduct(null);
			product.setEntertainmentService(null);
		}else if (catalog.getId() == Constants.CATALOG_ENTERTAIN_SERIVCE){
			product.setFoodProduct(null);
			product.setEntertainmentProduct(null);
		}else if (catalog.getId() == Constants.CATALOG_FOOD_PRODUCT){
			product.setEntertainmentProduct(null);
			product.setEntertainmentService(null);
		}
	}
}
