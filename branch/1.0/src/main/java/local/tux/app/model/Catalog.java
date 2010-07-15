package local.tux.app.model;


import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.compass.annotations.EnableAll;
import org.compass.annotations.Searchable;
import org.compass.annotations.SearchableAllMetaData;
import org.compass.annotations.SearchableConstant;
import org.compass.annotations.SearchableId;
import org.compass.annotations.SearchableMetaData;
import org.compass.annotations.SearchableProperty;


import local.tux.Constants;
import local.tux.app.model.common.LookUpBaseObject;

@Entity
@Table(name="catalog")
@Searchable(alias="catalog")
@SearchableAllMetaData(enable = EnableAll.TRUE)
@SearchableConstant(name = "type", values = { "catalog" })
public class Catalog extends LookUpBaseObject {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@SearchableId
	private Long id;
	
	@Column(name="name", nullable=false )
	@SearchableProperty(name = "name")
    @SearchableMetaData(name = "name")
	private String name;
	
	@Column(name="description", length=500)
	@SearchableProperty(name = "description")
    @SearchableMetaData(name = "description")
	private String description;
	
	@ManyToOne
	@JoinColumn(name="image_id")
	private Image image;

	@ManyToMany(mappedBy="catalogs")
	private Set<Product> products;
	
	@ManyToOne
	@JoinColumn(name="parent")
	private Catalog parent;

	@Column(name="display_order")
	private Long displayOrder;
	public String getName() {
		return name;
	}
	
	@OneToMany(mappedBy="parent", fetch=FetchType.LAZY)
	private Set<Catalog> children;
	
	@Override
	public void setName(String name) {
		this.name = name;

	}

	@Transient
	public String getHtmlDisplayName(){
		String s ="" ;
		Catalog next = parent;
		int level = 0;
		while (next != null && level < Constants.MAX_CATALOG_LEVEL){
			level++;
			String name = next.getName();
			if (s != ""){
				s = name +" -> "+ s;
			}else {
				s = name;
			}
			next = next.getParent();
		}
		return s;
	}
	@Transient
	public String getHtmlOptionName(){
		String s = getHtmlDisplayName();
		
		if (s == ""){
			return name;
		}else {
			return s + " -> " + name;
		
		}
	}
	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;

	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	
	public Catalog getParent() {
		return parent;
	}


	public void setParent(Catalog parent) {
		this.parent = parent;
	}


	public Long getDisplayOrder() {
		return displayOrder;
	}


	public void setDisplayOrder(Long displayOrder) {
		this.displayOrder = displayOrder;
	}


	
	public Set<Catalog> getChildren() {
		return children;
	}

	public void setChildren(Set<Catalog> children) {
		this.children = children;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (getClass() != obj.getClass())
			return false;
		Catalog other = (Catalog) obj;
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

	
	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}
	
	

	public Set<Product> getProducts() {
		return products;
	}


	public void setProducts(Set<Product> products) {
		this.products = products;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 99919;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

}
