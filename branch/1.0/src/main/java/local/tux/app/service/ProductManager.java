package local.tux.app.service;

import java.util.List;

import local.tux.app.model.Product;


public interface ProductManager extends LookUpNameGenericManager<Product, Long> {

	
	public List<Product> getProductByCatalogId(Long catalogId);
	
	public List<Product> getProductByCatalogIdAndBrandName(Long catalogId, Long brandNameId);
}
