package local.tux.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import local.tux.app.model.common.TuxBaseObject;
/**
 * 
 * @author Ben Li
 *
 */
@Entity
@Table(name="shopping_item")
public class ShoppingItem extends TuxBaseObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2687711790981503058L;
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	@ManyToOne
	@JoinColumn(name="product_id")
	private Product product;
	@Column(name="quantity")
	private Integer quantity;
	@ManyToOne
	@JoinColumn(name="coupon_id")
	private Coupon couponCode;
	
	@ManyToOne
	@JoinColumn(name="shopping_cart_id")
	private ShoppingCart shoppingCart;
	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;

	}
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Coupon getCouponCode() {
		return couponCode;
	}

	public void setCouponCode(Coupon couponCode) {
		this.couponCode = couponCode;
	}

	
	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}

	public void setShoppingCart(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 41;
		result = prime * result
				+ ((couponCode == null) ? 0 : couponCode.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		result = prime * result
				+ ((quantity == null) ? 0 : quantity.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		
		if (getClass() != obj.getClass())
			return false;
		ShoppingItem other = (ShoppingItem) obj;
		if (couponCode == null) {
			if (other.couponCode != null)
				return false;
		} else if (!couponCode.equals(other.couponCode))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		if (quantity == null) {
			if (other.quantity != null)
				return false;
		} else if (!quantity.equals(other.quantity))
			return false;
		if (shoppingCart == null) {
			if (other.shoppingCart != null)
				return false;
		} else if (!shoppingCart.getId().equals(other.shoppingCart.getId()))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ShoppingItem [couponCode=" + couponCode + ", id=" + id
				+ ", product=" + product + ", quantity=" + quantity + "]";
	}

	
	
}
