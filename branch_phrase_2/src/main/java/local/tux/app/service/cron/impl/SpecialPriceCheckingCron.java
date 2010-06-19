package local.tux.app.service.cron.impl;

import local.tux.app.model.Product;
import local.tux.app.service.LookUpNameGenericManager;
import local.tux.app.service.cron.TuxCronTask;
/**
 * this crontask is check for the product on special has expired or not.
 * if a product on special has expired, it updates the product's specical price to null.
 * this crontask should run once a day and should run at midnight.
 * @author Ben Li
 *
 */
public class SpecialPriceCheckingCron implements TuxCronTask {

	private LookUpNameGenericManager<Product, Long> productManager;
	public void setProductManager(LookUpNameGenericManager<Product, Long> productManager){
		this.productManager = productManager;
	}
	public void execute() throws Exception {
		

	}

}
