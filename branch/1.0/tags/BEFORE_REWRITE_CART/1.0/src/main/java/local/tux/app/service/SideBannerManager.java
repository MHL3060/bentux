package local.tux.app.service;



import java.util.List;

import local.tux.app.model.SideBanner;

public interface SideBannerManager extends
		LookUpNameGenericManager<SideBanner, Long> {

	
	public List<SideBanner> getSideBannerByPage(String page);
}
