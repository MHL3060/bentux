package local.tux.app.service.impl;

import java.util.List;
import java.util.Set;

import org.appfuse.model.User;
import org.appfuse.service.GenericManager;
import org.appfuse.service.UserManager;

import local.tux.Constants.Status;
import local.tux.app.dao.ShoppingCartDao;
import local.tux.app.model.Product;
import local.tux.app.model.ShoppingCart;
import local.tux.app.model.ShoppingItem;
import local.tux.app.service.ShoppingCartManager;

public class ShoppingCartManagerImpl extends
		LookUpNameGenericManagerImpl<ShoppingCart, Long>   implements ShoppingCartManager {

	private ShoppingCartDao shoppingCartDao;
	private UserManager userManager;
	private GenericManager<Product, Long> productManager;

	public void setUserManager(UserManager userManager){
		this.userManager = userManager;
	}
	public void setProductManager(GenericManager<Product, Long> productManager){
		this.productManager = productManager;
	}
	public ShoppingCartManagerImpl(ShoppingCartDao shoppingCartDao) {
		super(shoppingCartDao);
		this.shoppingCartDao = shoppingCartDao;
	}
	

	public boolean addItem(Long userId, String username, Long pid, Integer quantity) {
		User user = userManager.getUser(userId.toString());
		if (user.getUsername().equals(username)){
			Product p = productManager.get(pid);
			if (p.getAvailability() != null && p.getAvailability() - quantity >= 0){
				shoppingCartDao.add(user, p, quantity);
				p.setAvailability(p.getAvailability() - quantity );
				productManager.save(p);
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
	}
	
	public Integer getOpenItemCount(Long userId) {
		
		User user = userManager.getUser(userId.toString());
		return shoppingCartDao.getCartCount(user, Status.OPEN);
	}
	public Integer getItemCount(Long userId, Status status) {
		User user = userManager.getUser(userId.toString());
		return shoppingCartDao.getCartCount(user, status);
	}
	public List<ShoppingCart> getShoppingCarts(User user, Status status) {
		return shoppingCartDao.getShoppingCarts(user, status);
	}
	public ShoppingCart getOpenCart(User user) {
		List<ShoppingCart> carts = getShoppingCarts(user, Status.OPEN);
		if (carts.size() == 0){
			return null;
		}else {
			return carts.get(0);
		}
	}
	public Double getSubTotal(ShoppingCart cart){
		double subTotal = 0;
		if (cart != null){
			Set<ShoppingItem> items = cart.getShoppingItems();
			if ( items != null && items.size() > 0){
				for (ShoppingItem item : items){
					Double price = item.getProduct().getPrice();
					if (item.getProduct().getSpecial() == Boolean.TRUE){
						price = item.getProduct().getDiscountPrice();
					}
					subTotal += item.getQuantity() * price;
				}
				return new Double(subTotal);
			}
			
		}
		return new Double(0);
		
		
	}
	
}
