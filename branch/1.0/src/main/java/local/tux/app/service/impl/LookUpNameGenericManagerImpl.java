package local.tux.app.service.impl;

import local.tux.app.dao.TuxNameGenericDao;
import local.tux.app.model.common.LookUpBaseObject;
import local.tux.app.service.LookUpNameGenericManager;

import org.appfuse.dao.GenericDao;
import org.appfuse.service.impl.GenericManagerImpl;

public class LookUpNameGenericManagerImpl extends GenericManagerImpl<LookUpBaseObject, Long> implements
		LookUpNameGenericManager {

	public TuxNameGenericDao genericDao ;
	public LookUpNameGenericManagerImpl(
			GenericDao<LookUpBaseObject, Long> genericDao) {
		super(genericDao);
		this.genericDao = (TuxNameGenericDao) this.genericDao;
		
	}

	public LookUpBaseObject getLookUpBaseObject(String name) {
		return genericDao.getLookUpBaseObject(name);
	}

	

}
