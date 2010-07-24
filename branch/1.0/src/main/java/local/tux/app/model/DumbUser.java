package local.tux.app.model;
import org.appfuse.model.User;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import local.tux.app.model.common.TuxBaseObject;


@Entity
@Table(name="dumb_user")
public class DumbUser extends TuxBaseObject{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	private static final long serialVersionUID = -8133304231283520489L;
	@Column(name="idiot_firstName")
	private String idiotFirstName;
	
	
	
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

	@Column(name="idiot_lastName")
	private String idiotLastName;

	public String getIdiotFirstName() {
		return idiotFirstName;
	}

	public void setIdiotFirstName(String idiotFirstName) {
		this.idiotFirstName = idiotFirstName;
	}

	public String getIdiotLastName() {
		return idiotLastName;
	}

	public void setIdiotLastName(String idiotLastName) {
		this.idiotLastName = idiotLastName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 11;
		result = prime * result
				+ ((idiotFirstName == null) ? 0 : idiotFirstName.hashCode());
		result = prime * result
				+ ((idiotLastName == null) ? 0 : idiotLastName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (getClass() != obj.getClass())
			return false;
		DumbUser other = (DumbUser) obj;
		if (idiotFirstName == null) {
			if (other.idiotFirstName != null)
				return false;
		} else if (!idiotFirstName.equals(other.idiotFirstName))
			return false;
		if (idiotLastName == null) {
			if (other.idiotLastName != null)
				return false;
		} else if (!idiotLastName.equals(other.idiotLastName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DumbUser [idiotFirstName=" + idiotFirstName
				+ ", idiotLastName=" + idiotLastName + "]";
	}	
}