package local.tux.app.util;

import local.tux.app.model.SideBanner;
import local.tux.app.service.LookUpNameGenericManager;
import local.tux.app.service.ShoppingCartManager;

public class CommonPageUtil {

	private ShoppingCartManager shoppingCartManager;
	private LookUpNameGenericManager<SideBanner, Long> sideBannerManager;
	public void setShoppingCartManager(ShoppingCartManager shoppingCartManager){
		this.shoppingCartManager = shoppingCartManager;
	}
	public void setSideBannerManager(LookUpNameGenericManager<SideBanner, Long> sideBannerManager){
		this.sideBannerManager = sideBannerManager;
	}
	
	public ShoppingCartManager getShoppingCartManager() {
		return shoppingCartManager;
	}
	public LookUpNameGenericManager<SideBanner, Long> getSideBannerManager() {
		return sideBannerManager;
	}
	
	
}
