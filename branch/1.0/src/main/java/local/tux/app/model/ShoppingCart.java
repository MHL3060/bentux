package local.tux.app.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.appfuse.model.User;

import local.tux.Constants.ShippingType;
import local.tux.Constants.Status;
import local.tux.app.model.common.TuxBaseObject;

@Entity
@Table(name="shopping_cart")
public class ShoppingCart extends TuxBaseObject {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7870730073857034302L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="user_id", nullable=false)
	private User user;
	
	@Column(name="start_date")
	private Date startDate = new Date();
	
	@OneToMany(mappedBy="shoppingCart", targetEntity=ShoppingItem.class, cascade=CascadeType.ALL)
	private Set<ShoppingItem> shoppingItems;
	
	@Enumerated(EnumType.ORDINAL)
	private Status status;

	@Column
	private String trackingCode;
	
	@Column
	private String shippingInstruction;
	
	@Enumerated(EnumType.ORDINAL)
	private ShippingType shippingType;
	
	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
		
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Set<ShoppingItem> getShoppingItems() {
		return shoppingItems;
	}

	public void setShoppingItems(Set<ShoppingItem> shoppingItems) {
		this.shoppingItems = shoppingItems;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	
	public String getTrackingCode() {
		return trackingCode;
	}

	public void setTrackingCode(String trackingCode) {
		this.trackingCode = trackingCode;
	}

	
	public String getShippingInstruction() {
		return shippingInstruction;
	}

	public void setShippingInstruction(String shippingInstruction) {
		this.shippingInstruction = shippingInstruction;
	}

	public ShippingType getShippingType() {
		return shippingType;
	}

	public void setShippingType(ShippingType shippingType) {
		this.shippingType = shippingType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 37;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((shoppingItems == null) ? 0 : shoppingItems.hashCode());
		result = prime * result
				+ ((startDate == null) ? 0 : startDate.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (getClass() != obj.getClass())
			return false;
		ShoppingCart other = (ShoppingCart) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (shoppingItems == null) {
			if (other.shoppingItems != null)
				return false;
		} else if (!shoppingItems.equals(other.shoppingItems))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ShoppingCart [id=" + id + ", items=" + shoppingItems + ", startDate="
				+ startDate + ", status=" + status + ", user=" + user + "]";
	}

	
	public Object clone() throws CloneNotSupportedException {
		
		return super.clone();
	}
	
}
