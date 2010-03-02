package local.tux.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import local.tux.app.model.common.TuxBaseObject;

@Entity
@Table(name="subscription")
public class Subscription extends TuxBaseObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 210951944492171813L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Transient
	private String validation;
	
	@Column(name="email")
	private String email;
	
	
	public Long getId() {
		return id;
	}

	
	public void setId(Long id) {
		this.id = id;

	}
	
	public String getValidation() {
		return validation;
	}


	public void setValidation(String validation) {
		this.validation = validation;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 7;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		Subscription other = (Subscription) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Subscription [email=" + email + ", id=" + id + "]";
	}

	
}
