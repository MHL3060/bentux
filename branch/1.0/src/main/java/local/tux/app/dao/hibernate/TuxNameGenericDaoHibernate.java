package local.tux.app.dao.hibernate;

import java.io.Serializable;
import java.util.List;

import local.tux.app.dao.TuxNameGenericDao;
import local.tux.app.model.common.LookUpBaseObject;

import org.appfuse.dao.hibernate.GenericDaoHibernate;

public abstract class TuxNameGenericDaoHibernate extends GenericDaoHibernate<LookUpBaseObject,Long> implements
		TuxNameGenericDao{
	
	Class<LookUpBaseObject> clazz;
	public TuxNameGenericDaoHibernate(Class<LookUpBaseObject> persistentClass) {
		super(persistentClass);
		this.clazz = persistentClass;
	}


	@SuppressWarnings("unchecked")
	public LookUpBaseObject getLookUpBaseObject( String name) {
		
		String hql = new StringBuffer("from ").append(clazz.getName()).append(" where name = ? ").toString();
		List<LookUpBaseObject> list = super.getHibernateTemplate().find(hql, name);
		if (list.size() > 0 ){
			return list.get(0);
		}else {
			return null;
		}
	}

}
