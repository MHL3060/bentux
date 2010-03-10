package local.tux.app.service.impl;

import java.util.List;

import local.tux.Constants.Status;
import local.tux.app.dao.ShoppingItemDao;
import local.tux.app.model.Product;
import local.tux.app.model.ShoppingItem;
import local.tux.app.service.LookUpNameGenericManager;
import local.tux.app.service.ShoppingItemManager;

import org.appfuse.model.User;
import org.appfuse.service.impl.GenericManagerImpl;

public class ShoppingItemManagerImpl extends
		GenericManagerImpl<ShoppingItem, Long> implements ShoppingItemManager {

	private ShoppingItemDao shoppingItemDao;
	private LookUpNameGenericManager<Product, Long> productManager;

	public ShoppingItemManagerImpl(ShoppingItemDao shoppingItemDao) {
		super(shoppingItemDao);
		this.shoppingItemDao = shoppingItemDao;
	
	}
	public void setProductManager(LookUpNameGenericManager<Product, Long> productManager){
		this.productManager = productManager;
	}
	
	public List<ShoppingItem> getShoppingItem(User user, Product p,
			Status status) {
		
		return shoppingItemDao.getShoppingItem(user, p, status);
	}
	
	public boolean removeItemQuantity(Long userId, Long itemId, Integer quantity){
		
		ShoppingItem item = get(itemId);
		//are you the legitimate user?
		if (item.getShoppingCart().getUser().getId().equals(userId)){
			Product p = item.getProduct();
			
			if (item.getQuantity() > quantity) {
				item.setQuantity(item.getQuantity() - quantity);
				p.setAvailability(p.getAvailability() + quantity);
				save(item);
				return true;
			}else if (item.getQuantity() - quantity == 0){
				remove(itemId);
				p.setAvailability(p.getAvailability() + quantity);
				productManager.save(p);
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
	}
	public void remove(Long id){
		ShoppingItem item = get(id);
		Product p = item.getProduct();
		Integer item_count = item.getQuantity();
		p.setAvailability(p.getAvailability() + item_count);
		super.remove(id);
		productManager.save(p);
		
	}
	public ShoppingItem save(ShoppingItem toBeSaveItem, ShoppingItem originalItem ){
		
		
		Product p = toBeSaveItem.getProduct();
		Integer itemCount = toBeSaveItem.getQuantity();
		//do update
		if (toBeSaveItem.getId() != null && originalItem != null){
			int quantityDiff = itemCount - originalItem.getQuantity();
			p.setAvailability(p.getAvailability() - quantityDiff);
		}else {
			p.setAvailability(p.getAvailability() - itemCount);
		}
		productManager.save(p);
		return super.save(toBeSaveItem);
	
	}
	public ShoppingItem save(ShoppingItem toBeSaveItem ) {
		return save(toBeSaveItem, null);
	}
	
}
