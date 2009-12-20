package local.tux.app.dao;

import local.tux.app.model.Product;

import org.appfuse.dao.LookupDao;
import org.springframework.security.userdetails.User;

public interface ShoppingDao extends LookupDao {
	
	public Integer getCartCount(User user);
	public void add(User user, Product p);
	

}
