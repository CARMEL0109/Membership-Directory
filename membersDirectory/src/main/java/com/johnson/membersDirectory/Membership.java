package com.johnson.membersDirectory;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Entity
public class Membership {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
//	@Length(min = 3, message = "Your username must have at least 3 characters")
//	@Length(max = 15, message = "Your username cannot have more than 15 characters")
//	@Pattern(regexp = "[^\\s]+", message = "Your username cannot contain spaces")
//	private String username;
//
//	@Length(min = 5, message = "Your password must have at least 5 characters")
//	private String password;

	@NotEmpty(message = "Please provide your first name")
	private String firstName;

	@NotEmpty(message = "Please provide your last name")
	private String lastName;
	
	@Email(message = "Please provide a valid email")
	@NotEmpty(message = "Please provide an email")
	private String email;
	
	private  long phone;
	
	private String gender; 
	
	private String profession;
	
	private String city;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	

//	public Date getBirthday() {
//		return birthday;
//	}
//
//	public void setBirthday(Date birthday) {
//		this.birthday = birthday;
//	}
//
//
//	private Date birthday = new Date();
//	java.text.SimpleDateFormat df = new java.text.SimpleDateFormat("MM/dd");
//	String dateString = df.format(birthday);



	public Membership() {
	    	
	    }

	    	public Membership(String username, String password, String firstName, String lastName, String email, long phone, String gender, String profession, String city) {
	    		
//	    		this.username = username;
//	    		this.password = password;
	    		this.firstName = firstName;
	    		this.lastName = lastName;
	    		this.email = email;
	    		this.phone = phone;
	    		this.gender = gender;
	    		this.profession = profession;
	    		this.city = city;
//	    		this.birthday = birthday;
	    		
	    		
	    	}

			@Override
			public String toString() {
				return "Membership [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
						+ email + ", phone=" + phone + ", gender=" + gender + ", profession=" + profession + ", city="
						+ city + "]";
			}
//			, birthday=" + birthday + "
}


