package local.tux.app.dao.hibernate;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import local.tux.app.dao.ProductDao;
import local.tux.app.model.Product;

public class ProductDaoHibernate extends TuxNameGenericDaoHibernate<Product, Long> implements ProductDao{

	public ProductDaoHibernate() {
		super(Product.class);
	}

	@SuppressWarnings("unchecked")
	public List<Product> getProudctByCatalogId(Long catalogId) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Product.class);
		criteria.createAlias("catalogs", "catalog");
		criteria.add(Restrictions.eq("catalog.id", catalogId));
		return getHibernateTemplate().findByCriteria(criteria);
	}


}
