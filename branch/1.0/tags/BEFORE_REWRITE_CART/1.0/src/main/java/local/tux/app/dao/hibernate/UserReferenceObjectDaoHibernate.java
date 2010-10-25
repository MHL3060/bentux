package local.tux.app.dao.hibernate;

import java.io.Serializable;
import java.util.List;

import org.appfuse.model.User;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import local.tux.app.dao.UserReferencObjectDao;
/**
 * this class is mainly for convenience. 
 * 
 * @author benli
 *
 * @param <T>
 * @param <PK>
 */
public class UserReferenceObjectDaoHibernate<T, PK extends Serializable> extends TuxNameGenericDaoHibernate<T, PK> implements UserReferencObjectDao<T, PK> {

	Class<T> clazz;
	public UserReferenceObjectDaoHibernate(Class<T> clazz) {
		super(clazz);
		this.clazz = clazz;
	}

	@SuppressWarnings("unchecked")
	public List<T> getObjectsByUser(User user) {
		DetachedCriteria criteria = DetachedCriteria.forClass(clazz);
		criteria.add(Restrictions.eq("user", user));
		return getHibernateTemplate().findByCriteria(criteria);
		
	}

	

}
