package local.tux.app.dao;


import java.io.Serializable;
import java.util.List;

import local.tux.app.model.common.TuxBaseObject;



import org.appfuse.dao.GenericDao;
import org.hibernate.criterion.DetachedCriteria;

public interface TuxNameGenericDao<T, PK extends Serializable> extends GenericDao<T, PK>{

	/**
	 * use this method to get the lookup table object by its name.
	 * @param name
	 * @return
	 */
	public T getLookUpBaseObject( String name); 
	public List<TuxBaseObject>  getRelativeObjects(String key, Long object);
	public List<T> search(String propertyName, String value, int fetchSize);
	public List<T> getBaseObject(DetachedCriteria criteria);
	public int getAllRecordsCount();
	
}
