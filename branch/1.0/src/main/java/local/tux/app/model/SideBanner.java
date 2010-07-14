package local.tux.app.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

import local.tux.app.model.common.TuxBaseObject;


@Entity
@Table(name="side_banner")
@PrimaryKeyJoinColumn(name="id")
public class SideBanner extends Image {

	/**
	 * 
	 */
	public SideBanner(){
		super();
	}
	private static final long serialVersionUID = 8710189179214571710L;
	
	@Column(name="url")
	private String url;
	@Column(name="is_enable")
	private Boolean enable;
	@Column(name="display_order")
	private Integer displayOrder;
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Boolean getEnable() {
		return enable;
	}

	public void setEnable(Boolean enable) {
		this.enable = enable;
	}
	
	

	public Integer getDisplayOrder() {
		return displayOrder;
	}

	public void setDisplayOrder(Integer displayOrder) {
		this.displayOrder = displayOrder;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((enable == null) ? 0 : enable.hashCode());
		result = prime * result + ((url == null) ? 0 : url.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		SideBanner other = (SideBanner) obj;
		if (enable == null) {
			if (other.enable != null)
				return false;
		} else if (!enable.equals(other.enable))
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SiderBanner [enable=" + enable + ", url=" + url + "]";
	}

	
	
	
}
