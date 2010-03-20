package local.tux.app.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.compass.annotations.EnableAll;
import org.compass.annotations.Searchable;
import org.compass.annotations.SearchableAllMetaData;
import org.compass.annotations.SearchableComponent;
import org.compass.annotations.SearchableConstant;
import org.compass.annotations.SearchableId;
import org.compass.annotations.SearchableProperty;
import local.tux.app.model.common.LookUpBaseObject;

@Entity
@Table(name="product")
@Searchable(alias = "product")
@SearchableAllMetaData(enable = EnableAll.TRUE)
@SearchableConstant(name = "type", values = { "sku", "name"  })
public class Product extends LookUpBaseObject {


	private static final long serialVersionUID = 2201584628480385470L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@SearchableId
	private Long id;
	
	@Column(name="name", nullable=false)
	
	@SearchableProperty
	private String name;
	
	@ManyToOne
	@JoinColumn(name="brand_name_id")
	@SearchableComponent
	private BrandName brandName;

	@Column(name="price")
	private Double price;
	
	@Column(name="availability")
	private Integer availability;
	
	@Column(name="description")
	@SearchableProperty
	private String description;
	@OneToMany(cascade=CascadeType.ALL, mappedBy="product" )
	private Set<Image> images;
	
	@Column(name="rating")
	private Long rating;
	
	
	@Column(name="sku")
	private String sku;
	
	@Column(name="barcode")
	private String barcode;
	
	@Column(name="day_life")
	private Long dayLife;
	
	
	@OneToOne(mappedBy="product", targetEntity=FoodProduct.class, optional=true, cascade=CascadeType.ALL)
	@SearchableComponent
	private FoodProduct foodProduct = new FoodProduct();
	
	
	@OneToOne(mappedBy="product", optional=true, cascade=CascadeType.ALL)
	@SearchableComponent
	private EntertainmentService entertainmentService = new EntertainmentService();
	
	
	@OneToOne(mappedBy="product", optional=true, cascade=CascadeType.ALL)
	@SearchableComponent
	private EntertainmentProduct entertainmentProduct = new EntertainmentProduct();
	
	@OneToOne(mappedBy="product", optional=true, cascade=CascadeType.ALL)
	@SearchableComponent
	private CulturalProduct culturalProduct = new CulturalProduct();
	
	@ManyToMany
	@JoinTable(name="catalog_product")
	private Set<Catalog> catalogs;
	
	@Transient
	private Boolean special = Boolean.FALSE;
	
	@Column(name="speical_start")
	private Date specialStart;
	
	@Column(name="special_end")
	private Date specialEnd;
	@Column(name="discount_price")
	private Double discountPrice;
	
	@Column(name="multiple_special_count")
	private Integer multipleSpeicalCount;
	
	@Transient
	private Double discountPercentage;
	
	public Long getId() {
		return id;
	}

	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	
	public Date getSpecialStart() {
		return specialStart;
	}


	public Integer getMultipleSpeicalCount() {
		return multipleSpeicalCount;
	}


	public void setMultipleSpeicalCount(Integer multipleSpeicalCount) {
		this.multipleSpeicalCount = multipleSpeicalCount;
	}


	public void setSpecialStart(Date specialStart) {
		this.specialStart = specialStart;
	}


	public Date getSpecialEnd() {
		return specialEnd;
	}


	public void setSpecialEnd(Date specialEnd) {
		this.specialEnd = specialEnd;
	}


	public BrandName getBrandName() {
		return brandName;
	}


	public void setBrandName(BrandName brandName) {
		this.brandName = brandName;
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


	public void setImages(Set<Image> images) {
		this.images = images;
	}


	public Long getRating() {
		return rating;
	}


	public void setRating(Long rating) {
		this.rating = rating;
	}

	public Set<Catalog> getCatalogs() {
		return catalogs;
	}


	public void setCatalogs(Set<Catalog> catalog) {
		this.catalogs = catalog;
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
	
	


	public String getSku() {
		return sku;
	}


	public void setSku(String sku) {
		this.sku = sku;
	}


	/**
	 * check if today is within the special price day.
	 * @return
	 */
	public Boolean getSpecial() {
		Date today = new Date();
		if (specialStart != null && today.compareTo(specialStart) >= 0 ){
			if (specialEnd == null || specialEnd.compareTo(today) <= 0){
				return false;
			}
		}
		return false;
	}


	public void setSpecial(Boolean special) {
		this.special = special;
	}


	public Double getDiscountPrice() {
		return discountPrice;
	}


	public void setDiscountPrice(Double discountPrice) {
		this.discountPrice = discountPrice;
	}


	public Double getDiscountPercentage() {
		if (price != null && discountPrice != null && price != 0){ 
			return discountPrice * 1.0 / price;
		}else {
			return new Double(0);
		}
	}

	public void setDiscountPercentage(Double discountPercentage) {
		
	}

	
	
	public Image getFirstImage() {
		
		if (images.size() > 0){
			return images.iterator().next();
		}
		return null;
	}


	public FoodProduct getFoodProduct() {
		return foodProduct;
	}


	public void setFoodProduct(FoodProduct foodProduct) {
		this.foodProduct = foodProduct;
	}


	

	public EntertainmentService getEntertainmentService() {
		return entertainmentService;
	}


	public void setEntertainmentService(EntertainmentService entertainmentService) {
		this.entertainmentService = entertainmentService;
	}


	public EntertainmentProduct getEntertainmentProduct() {
		return entertainmentProduct;
	}


	public void setEntertainmentProduct(EntertainmentProduct entertainmentProduct) {
		this.entertainmentProduct = entertainmentProduct;
	}


	public CulturalProduct getCulturalProduct() {
		return culturalProduct;
	}


	public void setCulturalProduct(CulturalProduct culturalProduct) {
		this.culturalProduct = culturalProduct;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 21344333;
		result = prime * result
				+ ((availability == null) ? 0 : availability.hashCode());
		result = prime * result + ((barcode == null) ? 0 : barcode.hashCode());
		result = prime * result
				+ ((catalogs == null) ? 0 : catalogs.hashCode());
		result = prime * result + ((dayLife == null) ? 0 : dayLife.hashCode());
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime
				* result
				+ ((discountPercentage == null) ? 0 : discountPercentage
						.hashCode());
		result = prime * result
				+ ((discountPrice == null) ? 0 : discountPrice.hashCode());
		
		result = prime
				* result
				+ ((entertainmentProduct == null) ? 0 : entertainmentProduct
						.hashCode());
		result = prime * result
				+ ((foodProduct == null) ? 0 : foodProduct.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((images == null) ? 0 : images.hashCode());
		result = prime * result
				+ ((brandName == null) ? 0 : brandName.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((rating == null) ? 0 : rating.hashCode());
		result = prime * result + ((sku == null) ? 0 : sku.hashCode());
		result = prime * result + ((special == null) ? 0 : special.hashCode());
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
		if (catalogs == null) {
			if (other.catalogs != null)
				return false;
		} else if (!catalogs.equals(other.catalogs))
			return false;
		if (dayLife == null) {
			if (other.dayLife != null)
				return false;
		} else if (!dayLife.equals(other.dayLife))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (discountPercentage == null) {
			if (other.discountPercentage != null)
				return false;
		} else if (!discountPercentage.equals(other.discountPercentage))
			return false;
		if (discountPrice == null) {
			if (other.discountPrice != null)
				return false;
		} else if (!discountPrice.equals(other.discountPrice))
			return false;
		
		if (entertainmentProduct == null) {
			if (other.entertainmentProduct != null)
				return false;
		} else if (!entertainmentProduct.equals(other.entertainmentProduct))
			return false;
		if (foodProduct == null) {
			if (other.foodProduct != null)
				return false;
		} else if (!foodProduct.equals(other.foodProduct))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (images == null) {
			if (other.images != null)
				return false;
		} else if (!images.equals(other.images))
			return false;
		
		if (brandName == null) {
			if (other.brandName != null)
				return false;
		} else if (!brandName.equals(other.brandName))
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
		if (sku == null) {
			if (other.sku != null)
				return false;
		} else if (!sku.equals(other.sku))
			return false;
		if (special == null) {
			if (other.special != null)
				return false;
		} else if (!special.equals(other.special))
			return false;
		return true;
	}

	public Object clone() throws CloneNotSupportedException {
		
		return super.clone();
	}
	

	
}
