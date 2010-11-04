package local.tux.app.web.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import local.tux.Constants;
import local.tux.app.converter.TuxBaseObjectConverter;
import local.tux.app.model.BrandName;
import local.tux.app.model.Catalog;
import local.tux.app.model.EntertainmentProduct;
import local.tux.app.model.EntertainmentService;
import local.tux.app.model.FoodProduct;
import local.tux.app.model.CulturalProduct;
import local.tux.app.model.MiscellaneousProduct;
import local.tux.app.model.Manufacturer;
import local.tux.app.model.Product;
import local.tux.app.model.common.LookUpBaseObject;
import local.tux.app.model.common.TuxBaseObject;
import local.tux.app.service.CatalogManager;
import local.tux.app.service.LookUpNameGenericManager;

import org.apache.commons.lang.StringUtils;
import org.appfuse.webapp.controller.BaseFormController;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;

public class ProductFormController extends BaseFormController {

	private CatalogManager catalogManager;
	private LookUpNameGenericManager manufacturerManager;
	private LookUpNameGenericManager productManager;

	private LookUpNameGenericManager<BrandName, Long> brandNameManager;
	private LookUpNameGenericManager ingredientManager;
	private LookUpNameGenericManager<FoodProduct, Long> foodProductManager;
	private LookUpNameGenericManager<EntertainmentProduct, Long> entertainmentproductManager;
	private LookUpNameGenericManager<EntertainmentService, Long> entertainmentServiceManager;
	private LookUpNameGenericManager<CulturalProduct, Long> culturalProductManager;
	private LookUpNameGenericManager<MiscellaneousProduct, Long> miscellaneousProductManager;
	
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
	public void setFoodProductManager(LookUpNameGenericManager<FoodProduct, Long> foodProductManager){
		this.foodProductManager = foodProductManager;
	}
	public void setEntertainmentProductManager(LookUpNameGenericManager<EntertainmentProduct, Long> entertainmentproductManager){
		this.entertainmentproductManager = entertainmentproductManager;
	}
	public void setEntertainmentServiceManager(LookUpNameGenericManager<EntertainmentService, Long> entertainmentServiceManager){
		this.entertainmentServiceManager = entertainmentServiceManager;
	}
	public void setCulturalProductManager(LookUpNameGenericManager<CulturalProduct, Long> cuturalProductManager){
		this.culturalProductManager = culturalProductManager;
	}
	public void setMiscellaneousProductManager(LookUpNameGenericManager<MiscellaneousProduct, Long> miscellaneousProductManager){
		this.miscellaneousProductManager = miscellaneousProductManager;
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
	protected Map referenceData(HttpServletRequest request, Object command, Errors errors){
		Map models = new HashMap(); 
		int[] multipleCount = new int[Constants.MULTIPLE_COUNT ];
		for (int i = 0; i < multipleCount.length; i++){
			multipleCount[i] = i;
		}
		models.put("multipleCount", multipleCount);
		models.put("catalogParents", catalogManager.getMostTopLevel());
		models.put("catalogs", catalogManager.getAllChildren());
		models.put("manufacturers", manufacturerManager.getAll());
		models.put("units", Constants.WEIGHT_UNIT);
		models.put("brandNames", brandNameManager.getAll());
		models.put("foodProduct", Constants.CATALOG_FOOD_PRODUCT);
		models.put("entertainProduct", Constants.CATALOG_ENTERTAIN_PRODUCT);
		models.put("entertainService", Constants.CATALOG_ENTERTAIN_SERIVCE);
		models.put("culturalProduct", Constants.CATALOG_CULTURAL_PRODUCT);
		models.put("miscellaneousProduct", Constants.CATALOG_MISCELLANEOUS_PRODUCT);
		models.put("ingredients", ingredientManager.getAll());

		
		if (command != null ){
			Product p = (Product) command;
			if (p.getCatalogs() != null && p.getCatalogs().size() > 0){
				Catalog pc = p.getCatalogs().iterator().next().getParent();
				models.put("parentCatalog", pc);
				models.put("grandParentCatalog", pc.getParent());
			}
		}
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
			if (product.getCulturalProduct() == null){
				product.setCulturalProduct(new CulturalProduct());
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
			if (request.getParameter(Constants.DELETE_ACTION) != null){
				productManager.remove(product.getId());
				saveMessage(request, getText(className+".deleted", locale));
			}else {
				//productManager.save(product);
				saveProduct(product);
				String key = (isNew) ? className+ ".added" : className + ".updated";
				saveMessage(request, getText(key, locale));
			}
			if (!isNew) {
                successView = "redirect:productform.html?id=" + product.getId();
            }
		}catch (Exception e){
			
			saveError(request, getText("object.exists",locale));
			e.printStackTrace();
			log.error(e.toString());
		}
		return new ModelAndView(successView);
	}

	private void saveProduct(Product product) {
		
		product = (Product) productManager.save(product);
		
		
		if (product.getFoodProduct() != null && product.getFoodProduct().isEmpty() == false){
			product.getFoodProduct().setProduct(product);
			foodProductManager.save(product.getFoodProduct());
		}else if (product.getEntertainmentProduct() != null && product.getEntertainmentProduct().isEmpty() == false){
			product.getEntertainmentProduct().setProduct(product);
			entertainmentproductManager.save(product.getEntertainmentProduct());
		}else if (product.getEntertainmentService() != null && product.getEntertainmentService().isEmpty() == false){
			product.getEntertainmentService().setProduct(product);
			entertainmentServiceManager.save(product.getEntertainmentService());
		}else if (product.getCulturalProduct() != null && product.getCulturalProduct().isEmpty() == false){
			product.getCulturalProduct().setProduct(product);
			culturalProductManager.save(product.getCulturalProduct());
		}else{
			productManager.save(product);
		}
	}

	private void removeUslessProduct(Product product) {
		Catalog child = product.getCatalogs().iterator().next();
		Catalog grandParent = child.getParent().getParent();
		//Catalog catalog = product.getCatalogs().iterator().next().getParent();
		if (grandParent.getId() == Constants.CATALOG_ENTERTAIN_PRODUCT){
			product.setFoodProduct(null);
			product.setEntertainmentService(null);
			product.setCulturalProduct(null);
			//product.setMiscellaneousProduct(null);
		}else if (grandParent.getId() == Constants.CATALOG_ENTERTAIN_SERIVCE){
			product.setFoodProduct(null);
			product.setEntertainmentProduct(null);
			product.setCulturalProduct(null);
			//product.setMiscellaneousProduct(null);
		}else if (grandParent.getId() == Constants.CATALOG_FOOD_PRODUCT){
			product.setEntertainmentProduct(null);
			product.setEntertainmentService(null);
			product.setCulturalProduct(null);
			//product.setMiscellaneousProduct(null);
		}else if(grandParent.getId() == Constants.CATALOG_CULTURAL_PRODUCT){
			product.setEntertainmentService(null);
			product.setEntertainmentProduct(null);
			product.setFoodProduct(null);
		//	product.setMiscellaneousProduct(null);
		}else if(grandParent.getId() == Constants.CATALOG_MISCELLANEOUS_PRODUCT){
			product.setEntertainmentService(null);
			product.setEntertainmentProduct(null);
			product.setFoodProduct(null);
			product.setCulturalProduct(null);
		}
	}
}
