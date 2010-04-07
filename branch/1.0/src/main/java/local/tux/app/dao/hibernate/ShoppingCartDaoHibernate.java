package local.tux.app.dao.hibernate;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import local.tux.Constants;
import local.tux.Constants.CART_STATUS;
import local.tux.app.dao.ShoppingCartDao;
import local.tux.app.model.Product;
import local.tux.app.model.ShoppingCart;
import local.tux.app.model.ShoppingItem;

import org.appfuse.dao.hibernate.LookupDaoHibernate;
import org.appfuse.model.User;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class ShoppingCartDaoHibernate extends TuxNameGenericDaoHibernate<ShoppingCart, Long> implements ShoppingCartDao {

	public ShoppingCartDaoHibernate() {
		super(ShoppingCart.class);
	}

	/**
	 * (non-Javadoc)
	 * @see local.tux.app.dao.ShoppingCartDao#getCartCount(org.appfuse.model.User, local.tux.Constants.CART_STATUS)
	 */
	public Integer getCartCount(User user, CART_STATUS status) {
		DetachedCriteria criteria = DetachedCriteria.forClass(ShoppingCart.class);
		criteria.createAlias("shoppingItems", "item");
		criteria.add(Restrictions.eq("user", user))
				.add(Restrictions.eq("status", status));
		
		criteria.setProjection(Projections.sum("item.quantity"));
		
		Number number = (Number)getHibernateTemplate().findByCriteria(criteria).get(0);
		if (number == null){
			return new Integer(0);
		}else {
			return new Integer(number.intValue());
		}
	}
	/**
	 * (non-Javadoc)
	 * @see local.tux.app.dao.ShoppingCartDao#add(org.appfuse.model.User, local.tux.app.model.Product)
	 */
	public void add(User user, Product p, Integer quantity) {
		boolean newItem = true;
		ShoppingCart cart = getOpenShoppingCart(user);
		Set<ShoppingItem> items = cart.getShoppingItems();
		//if the shoppingCart is new. create a baskets.
		if (items == null){
			items = new HashSet<ShoppingItem>();
		}else { //if the shoppingcart is not not new.
			
			// look if there is a similar item exists.
			for (ShoppingItem item : items){
				if (item.getProduct().equals(p)){
					newItem = false;
					item.setQuantity(item.getQuantity() + quantity);
					break;
				}
			}
		}
		//if not exist. add them
		if (newItem){
			ShoppingItem item = new ShoppingItem();
			item.setProduct(p);
			item.setShoppingCart(cart);
			item.setQuantity( quantity);
			items.add(item);
			cart.setShoppingItems(items);
		}
		getHibernateTemplate().save(cart);
		
		
	}
	/**
	 * get the user's OPEN shopping cart 
	 * 
	 * 
	 * @param user
	 * @param status
	 * @return 1) return the Cart if it meets the criteria or,
	 *         2). it will create a new ShoppingCart,
	 *   
	 *  
	 */
	private ShoppingCart getOpenShoppingCart(User user){
		
		List<ShoppingCart> carts = getShoppingCarts(user, CART_STATUS.OPEN);
		if ( !carts.isEmpty()){
			return carts.get(0);
		}else {
			
			ShoppingCart cart = new ShoppingCart();
			cart.setStartDate(new Date());
			cart.setStatus(Constants.CART_STATUS.OPEN);
			cart.setUser(user);
			return cart;
			
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<ShoppingCart> getShoppingCarts(User user, CART_STATUS status){
		
		DetachedCriteria criteria = DetachedCriteria.forClass(ShoppingCart.class);
		criteria.add(Restrictions.eq("user", user))
				.add(Restrictions.eq("status",status));
		
		List<ShoppingCart> carts = getHibernateTemplate().findByCriteria(criteria);
		return carts;
	}

	

}
