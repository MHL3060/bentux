package local.tux.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import local.tux.app.model.common.SubProduct;
import local.tux.app.model.common.TuxBaseObject;

@Entity
@Table(name="entertain_product")
public class EntertainmentProduct extends TuxBaseObject implements SubProduct{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="imdb_link")
	private String imdbLink;

	@OneToOne
	@JoinColumn(name="product_id")
	private Product product;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getImdbLink() {
		return imdbLink;
	}

	public void setImdbLink(String imdbLink) {
		this.imdbLink = imdbLink;
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
		int result = 23;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((imdbLink == null) ? 0 : imdbLink.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		
		if (getClass() != obj.getClass())
			return false;
		EntertainmentProduct other = (EntertainmentProduct) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (imdbLink == null) {
			if (other.imdbLink != null)
				return false;
		} else if (!imdbLink.equals(other.imdbLink))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EntertainmentProduct [id=" + id + ", imdbLink=" + imdbLink
				+ "]";
	}

	public boolean isEmpty() {
		if (imdbLink == null){
			return true;
		}
		return false;
	}

	
	
}
