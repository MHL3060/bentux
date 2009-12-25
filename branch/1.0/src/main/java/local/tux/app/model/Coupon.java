package local.tux.app.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import local.tux.app.model.common.LookUpBaseObject;

@Entity
@Table(name="coupon")
public class Coupon extends LookUpBaseObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2899745542057939560L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(name="start_date")
	private Date startDate;
	@Column(name="end_date")
	private Date endDate;
	@Column(name="name")
	private String name;
	@Column(name="discount_type")
	private Integer discountType;
	@Column(name="discount_value")
	private Double discount_value;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getDiscountType() {
		return discountType;
	}
	public void setDiscountType(Integer discountType) {
		this.discountType = discountType;
	}
	public Double getDiscount_value() {
		return discount_value;
	}
	public void setDiscount_value(Double discountValue) {
		discount_value = discountValue;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 3;
		result = prime * result
				+ ((discountType == null) ? 0 : discountType.hashCode());
		result = prime * result
				+ ((discount_value == null) ? 0 : discount_value.hashCode());
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((startDate == null) ? 0 : startDate.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		
		if (getClass() != obj.getClass())
			return false;
		Coupon other = (Coupon) obj;
		if (discountType == null) {
			if (other.discountType != null)
				return false;
		} else if (!discountType.equals(other.discountType))
			return false;
		if (discount_value == null) {
			if (other.discount_value != null)
				return false;
		} else if (!discount_value.equals(other.discount_value))
			return false;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
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
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Coupon [discountType=" + discountType + ", discount_value="
				+ discount_value + ", endDate=" + endDate + ", id=" + id
				+ ", name=" + name + ", startDate=" + startDate + "]";
	}
	
	
	

}
