package local.tux.app.dao.hibernate;

import local.tux.app.model.Image;

public class ImageDaoHibernate extends TuxNameGenericDaoHibernate {
	public ImageDaoHibernate() {
		super(Image.class);
	}
}
