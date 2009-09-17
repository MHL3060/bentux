package local.tux.app.dao.hibernate;

import java.io.Serializable;
import java.util.List;

import local.tux.app.dao.TuxNameGenericDao;
import local.tux.app.model.common.LookUpBaseObject;

import org.appfuse.dao.hibernate.GenericDaoHibernate;


public class TuxNameGenericDaoHibernate<T, PK extends Serializable> extends GenericDaoHibernate<T,PK> implements
		TuxNameGenericDao<T, PK>{
	
	Class<T> clazz;
	
	public TuxNameGenericDaoHibernate(Class<T> clazz) {
		super(clazz);
	}

	@SuppressWarnings("unchecked")
	public T getLookUpBaseObject( String name) {
		
		String hql = new StringBuffer("from ").append(clazz.getName()).append(" where name = ? ").toString();
		List<LookUpBaseObject> list = super.getHibernateTemplate().find(hql, name);
		if (list.size() > 0 ){
			return (T) list.get(0);
		}else {
			return null;
		}
	}

}
