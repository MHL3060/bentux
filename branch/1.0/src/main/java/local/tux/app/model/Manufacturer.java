package local.tux.app.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.compass.annotations.EnableAll;
import org.compass.annotations.Searchable;
import org.compass.annotations.SearchableAllMetaData;
import org.compass.annotations.SearchableConstant;
import org.compass.annotations.SearchableId;

import local.tux.app.model.common.LookUpBaseObject;

@Entity
@Table(name="manufactureer")

@Searchable(alias = "manufacturer")
@SearchableAllMetaData(enable = EnableAll.TRUE)
@SearchableConstant(name = "type", values = { "manufacturer" })
public class Manufacturer extends LookUpBaseObject{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3581460867980832957L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@SearchableId
	private Long id;
	@Column(name="name",unique=true, nullable=false)
	private String name;
	
	@Column(name="location", nullable=true)
	private String Location;
	
	@OneToMany(mappedBy="manufacturer")
	private Set<BrandName> brandName;
	@Override
	public String getName() {
		return name;
	}

	
	@Override
	public void setName(String name) {
		this.name = name;
		
	}
	
	@Override
	public Long getId() {
		return id;
	}
	@Override
	public void setId(Long id) {
		this.id = (Long)id;
		
	}

	
	public String getLocation() {
		return Location;
	}

	public void setLocation(String location) {
		Location = location;
	}

	
	public Set<BrandName> getBrandName() {
		return brandName;
	}


	public void setBrandName(Set<BrandName> brandName) {
		this.brandName = brandName;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		
		if (getClass() != obj.getClass())
			return false;
		Manufacturer other = (Manufacturer) obj;
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
	public int hashCode() {
		final int prime = 31;
		int result = 2131412;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	

}
