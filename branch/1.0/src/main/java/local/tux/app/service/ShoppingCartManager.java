package local.tux.app.service;

import local.tux.Constants.Status;
import local.tux.app.model.ShoppingCart;

public interface ShoppingCartManager extends LookUpNameGenericManager<ShoppingCart, Long> {

	//for ajax used.
	public Integer getOpenItemCount(Long userId);
	public boolean addItem(Long userId, Long pid, Integer quantity);
	
	public Integer getItemCount(Long userId, Status status);
	
}
