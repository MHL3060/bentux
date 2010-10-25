package local.tux.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.compass.annotations.EnableAll;
import org.compass.annotations.Searchable;
import org.compass.annotations.SearchableAllMetaData;
import org.compass.annotations.SearchableConstant;
import org.compass.annotations.SearchableId;

import local.tux.app.model.common.SubProduct;
import local.tux.app.model.common.TuxBaseObject;

@Entity
@Table(name="food_product")
@Searchable(alias = "foodProduct")
@SearchableAllMetaData(enable = EnableAll.TRUE)
@SearchableConstant(name = "type", values = { "food"  })
public class FoodProduct extends TuxBaseObject implements SubProduct {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1954975479806395472L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@SearchableId
	private Long id;
	
	@Column(name="weight")
	private Double weight;
	
	@Column(name="weight_unit")
	private String weightUnit;
	
	@Column(name="width")
	private Double width;
	
	@Column(name="height")
	private Double height;
	
	@Column(name="depth")
	private Double depth;
	
	@Column(name="volume_unit")
	private String volumeUnit;
	
	@OneToOne
	@JoinColumn(name="product_id")
	private Product product;
	@Override
	public Long getId() {
		return id;
	}
	
	@Column(name="day_life")
	private Long dayLife;
	
	@OneToOne(mappedBy="foodProduct")
	private Ingredient ingredient;
	
	@Override
	public void setId(Long id) {
		this.id = id;
		
	}

	
	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public String getWeightUnit() {
		return weightUnit;
	}

	public void setWeightUnit(String weightUnit) {
		this.weightUnit = weightUnit;
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

	public String getVolumeUnit() {
		return volumeUnit;
	}

	public void setVolumeUnit(String volumeUnit) {
		this.volumeUnit = volumeUnit;
	}

	
	

	public Long getDayLife() {
		return dayLife;
	}

	
	public void setDayLife(Long dayLife) {
		this.dayLife = dayLife;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 312311;
		result = prime * result + ((depth == null) ? 0 : depth.hashCode());
		result = prime * result + ((height == null) ? 0 : height.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((volumeUnit == null) ? 0 : volumeUnit.hashCode());
		result = prime * result + ((weight == null) ? 0 : weight.hashCode());
		result = prime * result
				+ ((weightUnit == null) ? 0 : weightUnit.hashCode());
		result = prime * result + ((width == null) ? 0 : width.hashCode());
		return result;
	}

	
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	
	public Ingredient getIngredient() {
		return ingredient;
	}


	public void setIngredient(Ingredient ingredient) {
		this.ingredient = ingredient;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		
		if (getClass() != obj.getClass())
			return false;
		FoodProduct other = (FoodProduct) obj;
		if (depth == null) {
			if (other.depth != null)
				return false;
		} else if (!depth.equals(other.depth))
			return false;
		if (height == null) {
			if (other.height != null)
				return false;
		} else if (!height.equals(other.height))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (volumeUnit == null) {
			if (other.volumeUnit != null)
				return false;
		} else if (!volumeUnit.equals(other.volumeUnit))
			return false;
		if (weight == null) {
			if (other.weight != null)
				return false;
		} else if (!weight.equals(other.weight))
			return false;
		if (weightUnit == null) {
			if (other.weightUnit != null)
				return false;
		} else if (!weightUnit.equals(other.weightUnit))
			return false;
		if (width == null) {
			if (other.width != null)
				return false;
		} else if (!width.equals(other.width))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "[ id : " + id + " ]";
	}

	@Transient
	public boolean isEmpty() {
		if (width == null && dayLife == null && 
				depth == null &&  weightUnit == null && 
				volumeUnit == null && height == null && weight == null){
			return true;
		}
		return false;
	}
	
	
}
