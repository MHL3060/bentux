package local.tux.app.dao.hibernate;

import local.tux.app.dao.ShoppingDao;
import local.tux.app.model.Product;

import org.appfuse.dao.hibernate.LookupDaoHibernate;
import org.springframework.security.userdetails.User;

public class ShoppingCartDaoHibernate extends LookupDaoHibernate implements ShoppingDao {

	public void add(User user, Product p) {
		// TODO Auto-generated method stub
		
	}

	public Integer getCartCount(User user) {
		// TODO Auto-generated method stub
		return null;
	}

}
