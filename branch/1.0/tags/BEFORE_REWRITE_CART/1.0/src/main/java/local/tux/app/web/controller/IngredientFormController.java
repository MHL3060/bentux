package local.tux.app.web.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.validation.Errors;
import org.springframework.web.bind.ServletRequestDataBinder;

import local.tux.app.converter.TuxBaseObjectConverter;
import local.tux.app.model.Ingredient;
import local.tux.app.model.FoodProduct;
//import local.tux.app.service.IngredientManager;
import local.tux.app.service.LookUpNameGenericManager;
import local.tux.app.web.common.controller.TuxBaseFormController;
/**
 * don't delete this class.
 * this skeleton will do some magics. such as add/edit/edit a catalog entry.
 * @author Ben Li
 *
 */
public class IngredientFormController extends TuxBaseFormController {
	private LookUpNameGenericManager<FoodProduct, Long> foodProductManager;
	public void setFoodProductManager(LookUpNameGenericManager<FoodProduct, Long> foodProductManager){
		this.foodProductManager = foodProductManager;
	}
	
	public void initBinder(HttpServletRequest request, ServletRequestDataBinder binder){
		super.initBinder(request, binder);
		TuxBaseObjectConverter converter = new TuxBaseObjectConverter(foodProductManager);
		binder.registerCustomEditor(FoodProduct.class, converter);
	}
//	@SuppressWarnings("unchecked")
/*	public Map referenceData(HttpServletRequest request, Object command,
			Errors error) throws Exception {
		Map map = super.referenceData(request, command, error);
		
		//Map model = super.referenceData(request, command, error);
		
		//List<Ingredient> parents = ((IngredientManager)lookUpManager).getParents();
		//model.put("parents", parents);
		//return model;
		
		map.put("foodProducts", foodProductManager.getAll());
		return map;
	}*/
}

