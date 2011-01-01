package local.tux.app.dao;

import java.util.List;

import local.tux.app.model.Product;

public interface ProductDao extends TuxNameGenericDao<Product, Long>{

	public List<Product> getProudctByCatalogId(Long catalogId);

	public List<Product> getProductByCatalogIdAndBrandName(Long catalogId,
			Long brandNameId);

}
