package local.tux.app.model;


import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import local.tux.app.model.common.LookUpBaseObject;

@Entity
@Table(name="product")
public class Product extends LookUpBaseObject {


	private static final long serialVersionUID = 2201584628480385470L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(name="name", nullable=false)
	private String name;
	@ManyToOne
	@JoinColumn(name="manufacture")
	private Manufacturer manufactueer;
	@ManyToOne
	@JoinColumn(name="catalog")
	private Catalog catalogy;
	@Column(name="price")
	private Double price;
	@Column(name="availability")
	private Integer availability;
	@Column(name="description")
	private String description;
	@OneToMany(cascade=CascadeType.ALL, mappedBy="product" )
	private Set<Image> images;
	
	@Column(name="rating")
	private Long rating;
	@Column(name="width")
	private Double width;
	@Column(name="height")
	private Double height;
	@Column(name="depth")
	private Double depth;
	@Column(name="barcode")
	private String barcode;
	@Column(name="day_life")
	private Long dayLife;
	
	
	public Long getId() {
		return id;
	}

	
	public void setId(Serializable id) {
		
	}
	
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Manufacturer getManufactueer() {
		return manufactueer;
	}


	public void setManufactueer(Manufacturer manufactueer) {
		this.manufactueer = manufactueer;
	}


	public Catalog getCatalogy() {
		return catalogy;
	}


	public void setCatalogy(Catalog catalogy) {
		this.catalogy = catalogy;
	}


	public Double getPrice() {
		return price;
	}


	public void setPrice(Double price) {
		this.price = price;
	}


	public Integer getAvailability() {
		return availability;
	}


	public void setAvailability(Integer availability) {
		this.availability = availability;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Set<Image> getImages() {
		return images;
	}


	public void setImagesLocation(Set<Image> images) {
		this.images = images;
	}


	public Long getRating() {
		return rating;
	}


	public void setRating(Long rating) {
		this.rating = rating;
	}


	public Double getWidth() {
		return width;
	}


	public void setWidth(Double width) {
		this.width = width;
	}


	public Double getHeight() {
		return height;
	}


	public void setHeight(Double height) {
		this.height = height;
	}


	public Double getDepth() {
		return depth;
	}


	public void setDepth(Double depth) {
		this.depth = depth;
	}


	public String getBarcode() {
		return barcode;
	}


	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}


	public Long getDayLife() {
		return dayLife;
	}


	public void setDayLife(Long dayLife) {
		this.dayLife = dayLife;
	}


	public void setId(Long id) {
		this.id = id;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 435334;
		result = prime * result
				+ ((availability == null) ? 0 : availability.hashCode());
		result = prime * result + ((barcode == null) ? 0 : barcode.hashCode());
		result = prime * result
				+ ((catalogy == null) ? 0 : catalogy.hashCode());
		result = prime * result + ((dayLife == null) ? 0 : dayLife.hashCode());
		result = prime * result + ((depth == null) ? 0 : depth.hashCode());
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((height == null) ? 0 : height.hashCode());
		result = prime * result + ((images == null) ? 0 : images.hashCode());
		result = prime * result
				+ ((manufactueer == null) ? 0 : manufactueer.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((rating == null) ? 0 : rating.hashCode());
		result = prime * result + ((width == null) ? 0 : width.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (availability == null) {
			if (other.availability != null)
				return false;
		} else if (!availability.equals(other.availability))
			return false;
		if (barcode == null) {
			if (other.barcode != null)
				return false;
		} else if (!barcode.equals(other.barcode))
			return false;
		if (catalogy == null) {
			if (other.catalogy != null)
				return false;
		} else if (!catalogy.equals(other.catalogy))
			return false;
		if (dayLife == null) {
			if (other.dayLife != null)
				return false;
		} else if (!dayLife.equals(other.dayLife))
			return false;
		if (depth == null) {
			if (other.depth != null)
				return false;
		} else if (!depth.equals(other.depth))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (height == null) {
			if (other.height != null)
				return false;
		} else if (!height.equals(other.height))
			return false;
		if (images == null) {
			if (other.images != null)
				return false;
		} else if (!images.equals(other.images))
			return false;
		if (manufactueer == null) {
			if (other.manufactueer != null)
				return false;
		} else if (!manufactueer.equals(other.manufactueer))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (rating == null) {
			if (other.rating != null)
				return false;
		} else if (!rating.equals(other.rating))
			return false;
		if (width == null) {
			if (other.width != null)
				return false;
		} else if (!width.equals(other.width))
			return false;
		return true;
	}


	
}
