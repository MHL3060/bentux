package local.tux.app.web.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.validation.Errors;
import org.springframework.web.bind.ServletRequestDataBinder;

import local.tux.app.converter.TuxBaseObjectConverter;
import local.tux.app.model.Manufacturer;
import local.tux.app.service.LookUpNameGenericManager;
import local.tux.app.web.common.controller.TuxBaseFormController;


public class BrandNameFormController extends TuxBaseFormController {
	
	private LookUpNameGenericManager<Manufacturer, Long> manufacturerManager;
	public void setManufacturerManager(LookUpNameGenericManager<Manufacturer, Long> manufacturerManager){
		this.manufacturerManager = manufacturerManager;
	}
	
	public void initBinder(HttpServletRequest request, ServletRequestDataBinder binder){
		super.initBinder(request, binder);
		TuxBaseObjectConverter converter = new TuxBaseObjectConverter(manufacturerManager);
		binder.registerCustomEditor(Manufacturer.class, converter);
	}
	
	@SuppressWarnings("unchecked")
	public Map referenceData(HttpServletRequest request, Object command,
			Errors error) throws Exception {
		Map map = super.referenceData(request, command, error);
		map.put("manufacturers", manufacturerManager.getAll());
		return map;
	}
}
