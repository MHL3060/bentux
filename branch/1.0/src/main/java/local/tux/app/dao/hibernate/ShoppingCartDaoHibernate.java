package local.tux.app.dao.hibernate;

import java.util.Date;
import java.util.List;
import java.util.Set;

import local.tux.Constants;
import local.tux.app.dao.ShoppingDao;
import local.tux.app.model.Product;
import local.tux.app.model.ShoppingCart;
import local.tux.app.model.ShoppingItem;

import org.appfuse.dao.hibernate.LookupDaoHibernate;
import org.appfuse.model.User;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class ShoppingCartDaoHibernate extends LookupDaoHibernate implements ShoppingDao {

	public Integer getCartCount(User user) {
		DetachedCriteria criteria = DetachedCriteria.forClass(ShoppingCart.class);
		criteria.createAlias("status", "status");
		criteria.add(Restrictions.eq("user", user))
				.add(Restrictions.eq("status",Constants.Status.OPEN));
		
		criteria.setProjection(Projections.rowCount());
		
		return getHibernateTemplate().findByCriteria(criteria).indexOf(0);
	}

	public void add(User user, Product p) {
		boolean productFoundInCart = false;
		ShoppingCart cart = getOpenShoppingCart(user);
		Set<ShoppingItem> items = cart.getItems();
		for (ShoppingItem item : items){
			if (item.getProduct().equals(p)){
				productFoundInCart = true;
				item.setQuantity(item.getQuantity() + 1);
				break;
			}
		}
		if (productFoundInCart == false){
			ShoppingItem item = new ShoppingItem();
			item.setProduct(p);
			item.setQuantity(new Long(1));
		}
		getHibernateTemplate().saveOrUpdate(cart);
		
		
	}
	@SuppressWarnings("unchecked")
	public ShoppingCart getOpenShoppingCart(User user){
		DetachedCriteria criteria = DetachedCriteria.forClass(ShoppingCart.class);
		criteria.createAlias("status", "status");
		criteria.add(Restrictions.eq("user", user))
				.add(Restrictions.eq("status",Constants.Status.OPEN));
		
		List<ShoppingCart> carts = getHibernateTemplate().findByCriteria(criteria);
		if ( !carts.isEmpty()){
			return carts.get(0);
		}else {
			ShoppingCart cart = new ShoppingCart();
			cart.setStartDate(new Date());
			cart.setStatus(Constants.Status.OPEN);
			cart.setUser(user);
			return cart;
		}
		
	}

}
