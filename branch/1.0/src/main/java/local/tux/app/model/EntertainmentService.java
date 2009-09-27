package local.tux.app.model;

import java.sql.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import local.tux.app.model.common.TuxBaseObject;
import java.util.Set;

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
import java.util.Set;

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
@Table(name="entertain_service")
public class EntertainmentService extends TuxBaseObject{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2485728020816587730L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@Column(name="show_from")
	private Date showFrom;
	
	@Column(name="show_to")
	private Date showTo;
	
	@Column(name="address")
	private String address;
	
	@Column(name="show_time")
	private String showTime;
	
	@Column(name="show_duration")
	private Double showDuration;

	@Column(name="show_type")
	private String showType;
	
	@Column(name="show_description")
	private String showDescription;
		
	@OneToOne
	@JoinColumn(name="product_id")
	private Product product;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Date getShowFrom() {
		return showFrom;
	}

	public void setShowFrom(Date showFrom) {
		this.showFrom = showFrom;
	}

	public Date getShowTo() {
		return showTo;
	}

	public void setShowTo(Date showTo) {
		this.showTo = showTo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getShowTime() {
		return showTime;
	}

	public void setShowTime(String showTime) {
		this.showTime = showTime;
	}

	public Double getShowDuration() {
		return showDuration;
	}

	public void setShowDuration(Double showDuration) {
		this.showDuration = showDuration;
	}

	public String getShowType(){
		return showType;
	}
	
	public void setShowType(String showType){
		this.showType = showType;
	}
	
	public String getShowDescription(){
		return showDescription;
	}
	
	public void setShowDescription(String showDescription){
		this.showDescription = showDescription;
	}
	
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 3243;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((showDuration == null) ? 0 : showDuration.hashCode());
		result = prime * result
				+ ((showFrom == null) ? 0 : showFrom.hashCode());
		result = prime * result
				+ ((showTime == null) ? 0 : showTime.hashCode());
		result = prime * result + ((showTo == null) ? 0 : showTo.hashCode());
		result = prime * result + ((showType == null) ? 0 : showType.hashCode());
		result = prime * result + ((showDescription == null) ? 0 : showDescription.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (getClass() != obj.getClass())
			return false;
		EntertainmentService other = (EntertainmentService) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (showDuration == null) {
			if (other.showDuration != null)
				return false;
		} else if (!showDuration.equals(other.showDuration))
			return false;
		if (showFrom == null) {
			if (other.showFrom != null)
				return false;
		} else if (!showFrom.equals(other.showFrom))
			return false;
		if (showTime == null) {
			if (other.showTime != null)
				return false;
		} else if (!showTime.equals(other.showTime))
			return false;
		if (showTo == null) {
			if (other.showTo != null)
				return false;
		} else if (!showTo.equals(other.showTo))
			return false;
		if (showType == null) {
			if (other.showType != null)
				return false;
		} else if (!showType.equals(other.showType))
			return false;
		if (showDescription == null) {
			if (other.showDescription != null)
				return false;
		} else if(!showDescription.equals(other.showDescription))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "id = " + id;
	}
	
	
	
}