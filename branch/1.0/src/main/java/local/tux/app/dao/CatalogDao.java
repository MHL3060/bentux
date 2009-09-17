package local.tux.app.dao;

import local.tux.app.model.Catalog;
import local.tux.app.model.common.LookUpBaseObject;

import org.appfuse.dao.GenericDao;

public interface CatalogDao extends GenericDao<Catalog, Long> {

	/**
	 * use this method to get the lookup table object by its name.
	 * @param name
	 * @return
	 */
	public Catalog getLookUpBaseObject( String name); 
}
