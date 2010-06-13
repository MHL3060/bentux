package local.tux.app.dao.hibernate;

import java.util.List;

import local.tux.Constants.CART_STATUS;
import local.tux.app.dao.ShoppingItemDao;
import local.tux.app.model.Product;
import local.tux.app.model.ShoppingItem;

import org.appfuse.dao.hibernate.GenericDaoHibernate;
import org.appfuse.model.User;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

public class ShoppingItemDaoHibernate extends
		GenericDaoHibernate<ShoppingItem, Long> implements ShoppingItemDao {

	public ShoppingItemDaoHibernate() {
		super(ShoppingItem.class);
	}

	@SuppressWarnings("unchecked")
	public List<ShoppingItem> getShoppingItem(User user, Product p, CART_STATUS status) {
		DetachedCriteria criteria = DetachedCriteria.forClass(ShoppingItem.class);
		criteria.createAlias("shoppingCart", "cart");
		criteria.add(Restrictions.eq("product", p))
				.add(Restrictions.eq("cart.user", user))
				.add(Restrictions.eq("cart.status", status));
		return getHibernateTemplate().findByCriteria(criteria);
	}

	public List<ShoppingItem> getItemByCartId( Long cartId) {
		DetachedCriteria criteria = DetachedCriteria.forClass(ShoppingItem.class);
		criteria.createAlias("shoppingCart", "cart");
		criteria.add(Restrictions.eq("cart.id", cartId));
		
		return getHibernateTemplate().findByCriteria(criteria); 
		
		
	}

}
