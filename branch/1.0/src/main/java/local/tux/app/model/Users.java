package local.tux.app.model;
import org.appfuse.model.User;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.DiscriminatorType;
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
import local.tux.app.web.controller.SignUpController;

@Entity
@Table(name="app_user")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE", discriminatorType=DiscriminatorType.STRING,length=100)
@DiscriminatorValue("app_user")

public class Users extends org.appfuse.model.User{
	  
	
	private static final long serialVersionUID = -8133304231283520489L;
	@Column(name="firstName2")
	private String firstName2;
	
	@Column(name="lastName2")
	private String lastName2;
	
	//@Column(name="phoneNumber2")
	//private String phoneNumber2;

	
	public String getFirstName2() {
		return firstName2;
	}

	public void setFirstName2(String firstName2) {
		this.firstName2 = firstName2;
	}
	
	public String getLastName2() {
		return lastName2;
	}

	public void setLastName2(String lastName2) {
		this.lastName2 = lastName2;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		
		if (getClass() != obj.getClass())
			return false;
		Users other = (Users) obj;
		if (firstName2 == null) {
			if (other.firstName2 != null)
				return false;
		} else if (!firstName2.equals(other.firstName2))
			return false;
		if (lastName2 == null) {
			if (other.lastName2 != null)
				return false;
		} else if (!lastName2.equals(other.lastName2))
			return false;
		return true;
	}

	@Transient
	public boolean isEmpty() {
		if (firstName2 == null && lastName2 == null){
			return true;
		}
		return false;
	}
	
	
}