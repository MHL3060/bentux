package local.tux.app.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.compass.annotations.EnableAll;
import org.compass.annotations.Searchable;
import org.compass.annotations.SearchableAllMetaData;
import org.compass.annotations.SearchableConstant;
import org.compass.annotations.SearchableId;

import local.tux.app.model.common.LookUpBaseObject;

@Entity
@Table(name="image")

@Searchable(alias = "image")
@SearchableAllMetaData(enable = EnableAll.TRUE)
@SearchableConstant(name = "type", values = { "image" })

public class Image extends LookUpBaseObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -786409637999701144L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@SearchableId
	private Long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="path")
	private String path;
	@Column(name="thumbPath")
	private String thumbPath;
	
	@ManyToOne
	@JoinColumn(name="product_id")
	private Product product;
	
	@Column(name="front_image")
	private Boolean imagefrontPage = Boolean.FALSE;
	
	@Transient
	private byte[] file;
	
	public Long getId() {
		return id;
	}

	
	public void setId(Long id) {
		this.id = (Long)id;

	}

	
	public String getName() {
		return name;
	}

	
	public void setName(String name) {
		this.name = name;
		
	}
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getThumbPath() {
		return thumbPath;
	}

	public void setThumbPath(String thumbPath) {
		this.thumbPath = thumbPath;
	}

	
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	

	public Boolean getImagefrontPage() {
		return imagefrontPage;
	}


	public void setImagefrontPage(Boolean imagefrontPage) {
		this.imagefrontPage = imagefrontPage;
	}


	public byte[] getFile() {
		return file;
	}

	public void setFile(byte[] file) {
		this.file = file;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 564;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((path == null) ? 0 : path.hashCode());
		result = prime * result
				+ ((thumbPath == null) ? 0 : thumbPath.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (getClass() != obj.getClass())
			return false;
		Image other = (Image) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (path == null) {
			if (other.path != null)
				return false;
		} else if (!path.equals(other.path))
			return false;
		if (thumbPath == null) {
			if (other.thumbPath != null)
				return false;
		} else if (!thumbPath.equals(other.thumbPath))
			return false;
		return true;
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

	

	
}
