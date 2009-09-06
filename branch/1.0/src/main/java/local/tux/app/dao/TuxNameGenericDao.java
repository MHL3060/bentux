package local.tux.app.dao;


import local.tux.app.model.common.LookUpBaseObject;


import org.appfuse.dao.GenericDao;

public interface TuxNameGenericDao extends GenericDao<LookUpBaseObject, Long>{

	/**
	 * use this method to get the lookup table object by its name.
	 * @param name
	 * @return
	 */
	public LookUpBaseObject getLookUpBaseObject( String name); 
	
}
