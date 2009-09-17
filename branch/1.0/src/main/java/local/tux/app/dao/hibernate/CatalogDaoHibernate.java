package local.tux.app.dao.hibernate;

import local.tux.app.dao.CatalogDao;
import local.tux.app.dao.TuxNameGenericDao;
import local.tux.app.model.Catalog;
import local.tux.app.model.common.LookUpBaseObject;

import org.appfuse.dao.hibernate.GenericDaoHibernate;

public class CatalogDaoHibernate extends GenericDaoHibernate<Catalog, Long> implements CatalogDao{

	public CatalogDaoHibernate() {
		super(Catalog.class);
		// TODO Auto-generated constructor stub
	}

	public Catalog getLookUpBaseObject(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public Catalog save(Catalog object) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
