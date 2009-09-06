package local.tux.app.dao.hibernate;

import local.tux.app.model.Catalogy;

public class CatalogyDaoHibernate extends TuxNameGenericDaoHibernate {

	public CatalogyDaoHibernate() {
		super(Catalogy.class);
	}

}
