package com.jdbc_prepared_statement_crud_operation.dto;

import java.time.LocalDate;
import java.util.Objects;

public class StudentDto {
	private int id;
	private String name;
	private LocalDate dob;
	private Long phone;
	private String email;
	private String gender;
	
	public StudentDto() {
		super();
	}
	public StudentDto(int id, String name, LocalDate dob, Long phone, String email, String gender ) {
		this.id = id;
		this.name = name;
		this.dob = dob;
		this.phone = phone;
		this.email = email;
		this.gender = gender;
	}
	public StudentDto( String name, LocalDate dob, Long phone, String email, String gender ) {
		this.name = name;
		this.dob = dob;
		this.phone = phone;
		this.email = email;
		this.gender = gender;
	}
	
	//getter for id 
	public int getId() {
		return id;
	}
	
	//setter for id
	public void setId(int id) {
		this.id = id;
	}
	
	// getter for name
	public String getName() {
		return name;
	}
	//setter for name
	public void setName(String name) {
		this.name = name;
	}
	
	//getter for  dob
	public LocalDate getDob() {
		return dob;
	}
	
	//setter for dob
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	
	//getter for email 
	public String getEmail() {
		return email;
	} 
	//setter for email
	public void setEmail() {
		this.email = email;
	}
	//getter for phone
	public Long getPhone() {
		return phone;
	}
	//setter for phone 
	public void setPhone(Long phone) {
		this.phone = phone;
	}
	
	
	//getter for gender
	public String getGender() {
		return gender;
	}
	//setter for gender
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	@Override
	public String toString() {
		return "Student [id="+ id +", name="+ name +", email=" +email +", phone=" +phone+", dob="+dob+", gender="+gender+"]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(dob, email, gender, id, name, phone);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentDto other = (StudentDto) obj;
		return Objects.equals(dob, other.dob) && Objects.equals(email, other.email)
				&& Objects.equals(gender, other.gender) && id == other.id && Objects.equals(name, other.name)
				&& Objects.equals(phone, other.phone);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
}
