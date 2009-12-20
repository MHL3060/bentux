package local.tux.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import local.tux.app.model.common.LookUpBaseObject;

@Entity
@Table(name="status")
public class Status extends LookUpBaseObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="name", length=20)
	private String name;
	@Column(name="description", length=100)
	private String descriptioin;
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescriptioin() {
		return descriptioin;
	}

	public void setDescriptioin(String descriptioin) {
		this.descriptioin = descriptioin;
	}

	
	public Long getId() {
		return id;
	}
	public void setId(Long id){
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 29;
		result = prime * result
				+ ((descriptioin == null) ? 0 : descriptioin.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (getClass() != obj.getClass())
			return false;
		Status other = (Status) obj;
		if (descriptioin == null) {
			if (other.descriptioin != null)
				return false;
		} else if (!descriptioin.equals(other.descriptioin))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Status [descriptioin=" + descriptioin + ", id=" + id
				+ ", name=" + name + "]";
	}

	
	

}
