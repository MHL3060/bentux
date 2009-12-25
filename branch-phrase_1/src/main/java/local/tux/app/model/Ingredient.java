package local.tux.app.model;




import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.compass.annotations.EnableAll;
import org.compass.annotations.Searchable;
import org.compass.annotations.SearchableAllMetaData;
import org.compass.annotations.SearchableConstant;
import org.compass.annotations.SearchableId;

import local.tux.app.model.common.LookUpBaseObject;

@Entity
@Table(name="ingredient")
@Searchable(alias = "ingredient")
@SearchableAllMetaData(enable = EnableAll.TRUE)
@SearchableConstant(name = "type", values = { "food", "ingredient"  })
public class Ingredient extends LookUpBaseObject {

	//2201584628480385470L
	private static final long serialVersionUID = 2201584628803343470L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@SearchableId
	private Long id;
	
	@Column(name="name", nullable=false)
	private String name;
	
	@Column(name="percentage")
	private Double percentage;
	
	@Column(name="amount_per_serving")
	private Integer amountPerServing;
	
	@Column(name="description")
	private String description;

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="food_product_id")
	private FoodProduct foodProduct;
	
	
	
	public void setId(Long id) {
		this.id = id;
		
	}
	
	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	
	public void setName(String name) {
		this.name = name;
	}
	
	
	public Double getPercentage(){
		return percentage;
	}
	
	
	public void setPercentage(Double percentage){
		this.percentage = percentage;
	}

	
	public Integer getAmountPerServing(){
		return amountPerServing;	
	}
	
	
	public void setAmountPerServing(Integer amountPerServing){
		this.amountPerServing = amountPerServing;		
	}
	
	
	public String getDescription(){
		return description;
	}
	
	public void setDescription(String description){
		this.description = description;	
	}


	public FoodProduct getFoodProduct() {
		return foodProduct;
	}



	public void setFoodProduct(FoodProduct product) {
		this.foodProduct = product;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (getClass() != obj.getClass())
			return false;
		Ingredient other = (Ingredient) obj;
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
		if (percentage == null) {
			if(other.percentage != null)
				return false;
		} else if (!percentage.equals(other.percentage))
			return false;
		if (amountPerServing == null) {
			if(other.amountPerServing != null)
				return false;
		} else if (!amountPerServing.equals(other.amountPerServing))
			return false;
		if (description == null) {
			if(other.description != null) 
				return false;
		} else if (!description.equals(other.description))
			return false;	
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 9999;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((percentage == null) ? 0 : percentage.hashCode());
		result = prime * result + ((amountPerServing == null) ? 0 : amountPerServing.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());

		result = prime;
		return result;
	}


	

	
}