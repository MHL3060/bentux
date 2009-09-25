package local.tux.app.dao;

import java.util.List;

import local.tux.app.model.Catalog;
import local.tux.app.model.common.LookUpBaseObject;

import org.appfuse.dao.GenericDao;

public interface CatalogDao extends GenericDao<Catalog, Long> {

	/**
	 * use this method to get a list of parents
	 * the definition of the parent is the parent field is not null
	 * @param name
	 * @return
	 */
	public List<Catalog> getParents();
}
