package local.tux.app.service.impl;

import java.io.Serializable;

import local.tux.app.dao.TuxNameGenericDao;
import local.tux.app.service.LookUpNameGenericManager;

import org.appfuse.dao.GenericDao;
import org.appfuse.service.impl.GenericManagerImpl;

public class LookUpNameGenericManagerImpl<T, PK extends Serializable> extends GenericManagerImpl<T, PK> implements
		LookUpNameGenericManager<T, PK> {

	public TuxNameGenericDao<T, PK> genericDao ;
	@SuppressWarnings("unchecked")
	public LookUpNameGenericManagerImpl(GenericDao<T, Long> genericDao) {
		super((GenericDao<T, PK>) genericDao);
		this.genericDao = (TuxNameGenericDao) this.genericDao;
		
	}

	public T getLookUpBaseObject(String name) {
		return (T) genericDao.getLookUpBaseObject(name);
	}

	

}
