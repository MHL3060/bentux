package local.tux.app.service.impl;


import java.util.List;


import local.tux.app.dao.CatalogDao;
import local.tux.app.model.Catalog;
import local.tux.app.service.CatalogManager;

public class CatalogManagerImpl extends LookUpNameGenericManagerImpl<Catalog, Long>  implements CatalogManager{



	private CatalogDao catalogDao;

	public CatalogManagerImpl(CatalogDao catalogDao) {
		super(catalogDao);
		this.catalogDao = catalogDao;
	}
	
	public List<Catalog> getMostTopLevel() {
		return catalogDao.getMostTopLevel();
	}

	public List<Catalog> getChildren(Catalog parent) {
		return getChildrenByParentId(parent.getId());
	}
	public List<Catalog> getChildrenByParentId(Long parentId){
		return catalogDao.getChildren(parentId);
	}

	public Object getAllChildren() {
		return catalogDao.getAllChidlren();
	}

}
