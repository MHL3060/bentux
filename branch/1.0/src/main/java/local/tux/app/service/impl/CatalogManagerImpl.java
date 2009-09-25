package local.tux.app.service.impl;

import java.util.List;
import java.util.Map;

import org.appfuse.dao.GenericDao;

import local.tux.app.dao.CatalogDao;
import local.tux.app.dao.TuxNameGenericDao;
import local.tux.app.model.Catalog;
import local.tux.app.service.CatalogManager;

public class CatalogManagerImpl extends LookUpNameGenericManagerImpl<Catalog, Long>  implements CatalogManager{



	private CatalogDao catalogDao;

	public CatalogManagerImpl(CatalogDao catalogDao) {
		super(catalogDao);
		this.catalogDao = catalogDao;
	}

	public List<Catalog> getParents() {
		return catalogDao.getParents();
	}

	

	

	
	
}
