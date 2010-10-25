package local.tux.app.dao;

import java.util.List;

import local.tux.app.model.Product;

public interface ProductDao extends TuxNameGenericDao<Product, Long>{

	public List<Product> getProudctByCatalogId(Long catalogId);

}
