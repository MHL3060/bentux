package local.tux.app.service;

import java.util.List;

import org.appfuse.model.User;

import local.tux.Constants.Status;
import local.tux.app.model.ShoppingCart;

public interface ShoppingCartManager extends LookUpNameGenericManager<ShoppingCart, Long> {

	//for ajax used.
	public Integer getOpenItemCount(Long userId);
	public boolean addItem(Long userId, Long pid, Integer quantity);
	/**
	 * if the user doesn't have an open cart, it returns null, otherwise, return the shoppingcart object.
	 * @param user
	 * @return
	 */
	public ShoppingCart getOpenCart(User user);
	public Integer getItemCount(Long userId, Status status);
	public Double getSubTotal(ShoppingCart cart);
	public List<ShoppingCart> getShoppingCarts(User user, Status status);
	
}
