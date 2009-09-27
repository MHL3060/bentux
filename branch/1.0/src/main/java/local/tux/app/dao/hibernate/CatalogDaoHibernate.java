package local.tux.app.dao.hibernate;

import java.util.List;

import local.tux.app.dao.CatalogDao;
import local.tux.app.dao.TuxNameGenericDao;
import local.tux.app.model.Catalog;
import local.tux.app.model.common.LookUpBaseObject;

import org.appfuse.dao.hibernate.GenericDaoHibernate;
import org.hibernate.criterion.DetachedCriteria;

public class CatalogDaoHibernate extends TuxNameGenericDaoHibernate<Catalog, Long> implements CatalogDao{

	public CatalogDaoHibernate() {
		super(Catalog.class);
		
	}

	public List<Catalog> getParents(){
		return getHibernateTemplate().find("from Catalog where parent is null " );
	}

	public List<Catalog> getChildren(Long id) {
		return getHibernateTemplate().find("from Catalog where parent is ?", id);
	}


	
}
