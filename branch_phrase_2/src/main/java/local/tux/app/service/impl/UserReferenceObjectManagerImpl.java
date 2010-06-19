package local.tux.app.service.impl;

import java.io.Serializable;
import java.util.List;

import org.appfuse.dao.GenericDao;
import org.appfuse.model.User;

import local.tux.app.dao.TuxNameGenericDao;
import local.tux.app.dao.UserReferencObjectDao;
import local.tux.app.model.UserReference;
import local.tux.app.service.UserReferenceObjectManager;

public class UserReferenceObjectManagerImpl<UserReference, PK extends Serializable> extends
		LookUpNameGenericManagerImpl<UserReference, PK> implements
		UserReferenceObjectManager<UserReference, PK> {

	private UserReferencObjectDao<UserReference, PK> genericDao;
	@SuppressWarnings("unchecked")
	public UserReferenceObjectManagerImpl(UserReferencObjectDao<UserReference, PK> genericDao) {
		super((TuxNameGenericDao)genericDao);
		this.genericDao = genericDao;
	}

	public List<UserReference> getObjectsByUser(User user) {
		return genericDao.getObjectsByUser(user);
	}

}
