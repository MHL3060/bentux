package local.tux.app.dao.hibernate;

import java.util.List;

import local.tux.app.dao.TuxNameGenericDao;
import local.tux.app.model.common.LookUpBaseObject;

import org.appfuse.dao.hibernate.GenericDaoHibernate;

public class TuxNameGenericDaoHibernate extends GenericDaoHibernate<LookUpBaseObject,Long> implements
		TuxNameGenericDao{

	public TuxNameGenericDaoHibernate(Class persistentClass) {
		super(persistentClass);
		
	}

	Class<LookUpBaseObject> clazz;
	
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
