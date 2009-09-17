package local.tux.app.dao;


import java.io.Serializable;

import local.tux.app.model.common.LookUpBaseObject;


import org.appfuse.dao.GenericDao;

public interface TuxNameGenericDao<T, PK extends Serializable> extends GenericDao<T, PK>{

	/**
	 * use this method to get the lookup table object by its name.
	 * @param name
	 * @return
	 */
	public T getLookUpBaseObject( String name); 
	
}
