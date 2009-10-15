package local.tux.app.dao.hibernate;

import java.io.Serializable;
import java.util.List;

import local.tux.app.dao.TuxNameGenericDao;
import local.tux.app.model.common.LookUpBaseObject;
import local.tux.app.model.common.TuxBaseObject;

import org.apache.commons.lang.StringUtils;
import org.appfuse.dao.hibernate.GenericDaoHibernate;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;


public class TuxNameGenericDaoHibernate<T, PK extends Serializable> extends GenericDaoHibernate<T,PK> implements
		TuxNameGenericDao<T, PK>{
	
	Class<T> clazz;
	
	public TuxNameGenericDaoHibernate(Class<T> clazz) {
		super(clazz);
		this.clazz = clazz;
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
	@SuppressWarnings("unchecked")
	public List<TuxBaseObject> getRelativeObjects(String key, Long id){
		Session session = getSession();
		
		List list =  session.createCriteria(clazz).add(Restrictions.eq(key, id)).list();
		session.disconnect();
		return list;
	}

	public List<T> search(String propertyName, String value, int fetchSize) {
		Session session = getSession();
		String cleanValue = StringUtils.trimToEmpty(value);
		if (cleanValue.startsWith("%") || cleanValue.endsWith("%")){
			
		}else {
			cleanValue = "%"+ cleanValue + "%";
		}
		List list =  session.createCriteria(clazz).add(Restrictions.ilike(propertyName, cleanValue))
												.setFetchSize(fetchSize).list();
		session.disconnect();
		return list;
	}
	public int getAllRecordsCount() {
		int count = 0;
		DetachedCriteria criteria = DetachedCriteria.forClass(clazz);
		criteria.setProjection(Projections.rowCount());
		List results = getHibernateTemplate().findByCriteria(criteria);
		if (results.size() > 0){
			count = ((Integer) results.get(0)).intValue();
		}
		return count;
	}

	@SuppressWarnings("unchecked")
	public List<T> getBaseObject(DetachedCriteria criteria) {
		return getHibernateTemplate().findByCriteria(criteria);
	}

}
