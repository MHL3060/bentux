package local.tux.app.service.impl;


import org.appfuse.dao.GenericDao;

import local.tux.app.model.ShoppingCart;
import local.tux.app.service.ShoppingManager;

public class ShoppingManagerImpl extends
		LookUpNameGenericManagerImpl<ShoppingCart, Long>   implements ShoppingManager {

	public ShoppingManagerImpl(GenericDao<ShoppingCart, Long> genericDao) {
		super(genericDao);
		// TODO Auto-generated constructor stub
	}

	public void addItem(Long userId, Long pid) {
		// TODO Auto-generated method stub
		
	}

	public Integer getItemCount(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}
}
