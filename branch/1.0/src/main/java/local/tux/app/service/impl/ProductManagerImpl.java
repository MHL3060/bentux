package local.tux.app.service.impl;

import java.util.List;

import local.tux.app.dao.ProductDao;
import local.tux.app.model.BrandName;
import local.tux.app.model.Product;
import local.tux.app.service.ProductManager;

public class ProductManagerImpl extends LookUpNameGenericManagerImpl<Product, Long> implements ProductManager {

	private ProductDao productDao;
	public ProductManagerImpl(ProductDao productDao) {
		super(productDao);
		this.productDao = productDao;
	}
	public List<Product> getProductByCatalogId(Long catalogId) {
		return productDao.getProudctByCatalogId(catalogId);
	}
	
	

}
