package local.tux.app.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.appfuse.model.User;
import org.compass.annotations.SearchableId;
import org.compass.annotations.SearchableMetaData;
import org.compass.annotations.SearchableProperty;

import local.tux.app.model.common.TuxBaseObject;

@Entity
@Table(name="share_friend")
public class ShareFriend extends TuxBaseObject{

	/**
	 * 
	 */

	private static final long serialVersionUID = 210951944492171813L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Transient
	private String validation;
	
	@Column(name="name")
	private String name;
	@Column(name="email")
	private String email;
	@Column(name="friend_email")
	private String friendEmail;
	@Column(name="friend_name")
	private String friendName;
	@Column(name="suggestion")
	private String suggestion;
	
	public Long getId() {
		return id;
	}

	
	public void setId(Long id) {
		this.id = id;

	}
	
	public String getValidation() {
		return validation;
	}


	public void setValidation(String validation) {
		this.validation = validation;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getFriendEmail(){
		return friendEmail;
	}
	
	public void setFriendEmail(String friendEmail){
		this.friendEmail = friendEmail;
	}
	public String getFriendName(){
		return friendName;
	}
	
	public void setFriendName(String friendName){
		this.friendName = friendName;
	}
	public String getSuggestion(){
		return suggestion;
	}
	
	public void setSuggestion(String suggestion){
		this.suggestion = suggestion;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 7;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((friendEmail == null) ? 0 : friendEmail.hashCode());
		result = prime * result + ((friendName == null) ? 0 : friendName.hashCode());
		result = prime * result + ((suggestion == null) ? 0 : suggestion.hashCode());

		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		ShareFriend other = (ShareFriend) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (email == null) {	
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (friendEmail == null) {
			if (other.friendEmail != null)
				return false;
		} else if (!friendEmail.equals(other.friendEmail))
			return false;
		if (friendName == null) {
			if (other.friendName != null)
				return false;
		} else if (!friendName.equals(other.friendName))
			return false;
		if (suggestion == null) {
			if (other.suggestion != null)
				return false;
		} else if (!suggestion.equals(other.suggestion))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "ShareFriend [name=" + name + ", email=" + email + ", id=" + id + ", suggestion=" + suggestion
		+ ", friendEmail="+ friendEmail + ", friendName="+ friendName + "]";
	}

	
}
