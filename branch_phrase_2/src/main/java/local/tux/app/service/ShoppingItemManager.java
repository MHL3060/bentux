package local.tux.app.service;

import java.util.List;

import local.tux.Constants.CART_STATUS;
import local.tux.app.model.Product;
import local.tux.app.model.ShoppingItem;

import org.appfuse.model.User;
import org.appfuse.service.GenericManager;

public interface ShoppingItemManager extends GenericManager<ShoppingItem, Long> {

	public List<ShoppingItem> getShoppingItem(User user, Product p, CART_STATUS status);
	public boolean removeItemQuantity(Long userid, Long itemId, Integer quantity);
	
	public ShoppingItem save(ShoppingItem toBeSaveItem, ShoppingItem originalItem );
	
	
}