package local.tux.app.dao;

import java.util.List;

import local.tux.Constants.CART_STATUS;
import local.tux.app.model.Product;
import local.tux.app.model.ShoppingItem;

import org.appfuse.dao.GenericDao;
import org.appfuse.model.User;

public interface ShoppingItemDao extends GenericDao<ShoppingItem, Long> {
	public List<ShoppingItem> getShoppingItem(User user, Product p, CART_STATUS status);

	public List<ShoppingItem> getItemByCartId( Long cartId);

}
