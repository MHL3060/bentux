package local.tux.app.service;

import java.util.List;

import org.appfuse.service.GenericManager;

import local.tux.app.dao.TuxNameGenericDao;
import local.tux.app.model.BrandName;
import local.tux.app.model.Catalog;

public interface CatalogManager extends LookUpNameGenericManager<Catalog, Long> {
	
	public List<Catalog> getMostTopLevel();
	public List<Catalog> getChildren(Catalog parent);
	public List<Catalog> getChildrenByParentId(Long parentId);
	public Object getAllChildren();
	
	public List<Catalog> getparents();
	public List<BrandName> getDistinctBrandName(Long catalogId);
}
