package local.tux.app.model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import local.tux.app.model.common.TuxBaseObject;

import org.appfuse.model.Address;
import org.appfuse.model.User;


@Entity
@Table(name="shipping_address")
public class ShippingAddress extends TuxBaseObject {

	private static final long serialVersionUID = -7932943991220437344L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@OneToOne
	@JoinColumn(name="user_id")
	private User user;
	
	
	@Embedded
	private Address address = new Address();

	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 5;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (getClass() != obj.getClass())
			return false;
		ShippingAddress other = (ShippingAddress) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
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
		return "ShippingAddress [address=" + address + ", id=" + id + ", user="
				+ user + "]";
	}
	

}
