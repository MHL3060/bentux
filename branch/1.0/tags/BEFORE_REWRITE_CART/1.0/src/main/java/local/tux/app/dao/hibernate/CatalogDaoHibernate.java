package local.tux.app.dao.hibernate;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import local.tux.app.dao.CatalogDao;
import local.tux.app.model.Catalog;

public class CatalogDaoHibernate extends TuxNameGenericDaoHibernate<Catalog, Long> implements CatalogDao{

	public CatalogDaoHibernate() {
		super(Catalog.class);
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Catalog> getMostTopLevel(){
		return getHibernateTemplate().find("from Catalog where parent is null " );
	}

	@SuppressWarnings("unchecked")
	public List<Catalog> getChildren(Long id) {
		return getHibernateTemplate().find("from Catalog where parent is ?", id);
	}

	@SuppressWarnings("unchecked")
	public List<Catalog> getAllChidlren() {
		return getHibernateTemplate().find("from Catalog where parent is not null");
	}

	@SuppressWarnings("unchecked")
	public List<Catalog> getParents() {
		return getHibernateTemplate().find("from Catalog where parent is null order by id desc");
	}


	
}