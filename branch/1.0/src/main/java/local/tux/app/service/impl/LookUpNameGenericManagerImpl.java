package local.tux.app.service.impl;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import local.tux.Constants;
import local.tux.app.dao.TuxNameGenericDao;
import local.tux.app.model.Catalog;
import local.tux.app.model.common.TuxBaseObject;
import local.tux.app.service.LookUpNameGenericManager;

import org.appfuse.dao.GenericDao;
import org.appfuse.service.impl.GenericManagerImpl;

public class LookUpNameGenericManagerImpl<T, PK extends Serializable> extends GenericManagerImpl<T, PK> implements
		LookUpNameGenericManager<T, PK> {

	public TuxNameGenericDao<T, PK> genericDao ;
	@SuppressWarnings("unchecked")
	public LookUpNameGenericManagerImpl(GenericDao<T, Long> genericDao) {
		super((GenericDao<T, PK>) genericDao);
		this.genericDao = (TuxNameGenericDao) genericDao;
		
	}

	public T getLookUpBaseObject(String name) {
		return (T) genericDao.getLookUpBaseObject(name);
	}

	public List<T> findByNamedQuery(String queryName,
			Map<String, Object> queryParams) {
		
		return  genericDao.findByNamedQuery(queryName, queryParams);
		
	}
	public List<T> getAllDistinct() {
		
		return genericDao.getAllDistinct();
	}

	@SuppressWarnings("unchecked")
	public List<TuxBaseObject> getRelativeObjects(String key, Long value) {
		return genericDao.getRelativeObjects(key, value);
	}
	public List<T> search(String propertyName, String value){
		
		return genericDao.search(propertyName ,value, Constants.AJAX_SIZE);
		
	}

	public int getAllRecordsCount() {
		return genericDao.getAllRecordsCount();
	}

	public List<T> getItemsInInterval(String attribute, Object from, Object to) {
		return genericDao.getItemsInInterval(attribute, from, to);
	}

}
