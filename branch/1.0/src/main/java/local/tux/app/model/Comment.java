package local.tux.app.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.appfuse.model.User;
import org.compass.annotations.EnableAll;
import org.compass.annotations.Searchable;
import org.compass.annotations.SearchableAllMetaData;
import org.compass.annotations.SearchableConstant;
import org.compass.annotations.SearchableId;

import local.tux.app.model.common.TuxBaseObject;

@Entity
@Table(name="comment")
@Searchable(alias="comment")
@SearchableAllMetaData(enable = EnableAll.TRUE)
@SearchableConstant(name = "type", values = { "comment" })
public class Comment extends TuxBaseObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5000301973216703960L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@SearchableId
	private Long id;
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@Column(name="title", nullable=false)
	private String title;
	@Column(name="content",length=1000)
	private String contentBody;
	@Column(name="added_on")
	private Date addedOn= new Date();
	@ManyToOne
	@JoinColumn(name="product_id")
	private Product product;
	
	@ManyToOne
	@JoinColumn(name="blog_id")
	private News blog;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContentBody() {
		return contentBody;
	}
	public void setContentBody(String contentBody) {
		this.contentBody = contentBody;
	}
	public Date getAddedOn() {
		return addedOn;
	}
	public void setAddedOn(Date addedOn) {
		this.addedOn = addedOn;
	}
	
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
	public News getBlog() {
		return blog;
	}
	public void setBlog(News blog) {
		this.blog = blog;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 29;
		result = prime * result + ((addedOn == null) ? 0 : addedOn.hashCode());
		result = prime * result + ((contentBody == null) ? 0 : contentBody.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (getClass() != obj.getClass())
			return false;
		Comment other = (Comment) obj;
		if (addedOn == null) {
			if (other.addedOn != null)
				return false;
		} else if (!addedOn.equals(other.addedOn))
			return false;
		if (contentBody == null) {
			if (other.contentBody != null)
				return false;
		} else if (!contentBody.equals(other.contentBody))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Comment [addedOn=" + addedOn + ", content=" + contentBody + ", id="
				+ id + ", user=" + user + "]";
	}
	
	

}
