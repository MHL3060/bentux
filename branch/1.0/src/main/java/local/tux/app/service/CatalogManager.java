package local.tux.app.service;

import java.util.List;

import local.tux.app.dao.TuxNameGenericDao;
import local.tux.app.model.Catalog;

public interface CatalogManager extends TuxNameGenericDao<Catalog, Long> {
	
	public List<Catalog> getParents();
	public List<Catalog> getChildren(Catalog parent);
	public List<Catalog> getChildrenByParentId(Long parentId);
}
