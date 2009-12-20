package local.tux.app.service;

import local.tux.app.model.ShoppingCart;

public interface ShoppingManager extends LookUpNameGenericManager<ShoppingCart, Long> {

	
	public Integer getItemCount(Long userId);
	public void addItem(Long userId, Long pid);
	
}
