package local.tux.app.dao;

import java.util.List;

import local.tux.Constants.CART_STATUS;
import local.tux.app.model.Product;
import local.tux.app.model.ShoppingCart;

import org.appfuse.model.User;

/**
 * this class is responsible for storing the cart & its items to the database.
 * it will not subtract the quantity from the original product.
 * @author Ben Li
 *
 */
public interface ShoppingCartDao extends TuxNameGenericDao<ShoppingCart, Long> {
	
	public Integer getCartCount(User user, CART_STATUS status);
	public void add(User user, Product p,Integer quantity);
	public List<ShoppingCart> getShoppingCarts(User user, CART_STATUS status);

}
