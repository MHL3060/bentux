package local.tux.app.model;

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


@Entity
@DiscriminatorColumn(name="TYPE", discriminatorType=DiscriminatorType.STRING)
@DiscriminatorValue("Users")

public class Users extends org.appfuse.model.User{
	
	private static final long serialVersionUID = -8133304231283520489L;
	@Column(name="firstName2")
	private String firstName2;
	
	@Column(name="lastName2")
	private String lastName2;
	
	public String getFirstName2() {
		return firstName2;
	}

    /**
     * @spring.validator type="required" msgkey="errors.required"
     */
	public void setFirstName2(String firstName2) {
		this.firstName2 = firstName2;
	}
	
	public String getLastName2() {
		return lastName2;
	}

	 /**
     * @spring.validator type="required" msgkey="errors.required"
     */
	public void setLastName2(String lastName2) {
		this.lastName2 = lastName2;
	}
	
	
}