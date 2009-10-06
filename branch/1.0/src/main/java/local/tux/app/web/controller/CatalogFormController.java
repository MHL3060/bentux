package local.tux.app.web.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.validation.Errors;
import org.springframework.web.bind.ServletRequestDataBinder;

import local.tux.TuxBaseObjectConverter;
import local.tux.app.model.Catalog;
import local.tux.app.model.Image;
import local.tux.app.model.Manufacturer;
import local.tux.app.service.CatalogManager;
import local.tux.app.service.LookUpNameGenericManager;
import local.tux.app.web.common.controller.LookUpTableController;
/**
 * don't delete this class.
 * this skeleton will do some magics. such as add/edit/edit a catalog entry.
 * @author Ben Li
 *
 */
public class CatalogFormController extends LookUpTableController {
	
	private LookUpNameGenericManager<Image, Long> imageManager;

	public void setImageManager(LookUpNameGenericManager<Image, Long> imageManager){
		this.imageManager = imageManager;
	}
	public void initBinder(HttpServletRequest request, ServletRequestDataBinder binder){
		super.initBinder(request, binder);
		TuxBaseObjectConverter catalogConverter = new TuxBaseObjectConverter(lookUpManager);
		binder.registerCustomEditor(Catalog.class, catalogConverter);
		TuxBaseObjectConverter imageConverter = new TuxBaseObjectConverter(imageManager);
		binder.registerCustomEditor(Image.class, imageConverter);
	}

	@SuppressWarnings("unchecked")
	public Map referenceData(HttpServletRequest request, Object command,
			Errors error) throws Exception {
		Map model = super.referenceData(request, command, error);
		
		List<Catalog> parents = ((CatalogManager)lookUpManager).getParents();
		model.put("parents", parents);
		return model;
	}
}

