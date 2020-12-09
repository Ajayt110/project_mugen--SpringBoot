package com.mugen.blog.db.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name = "user_table")
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Integer id;
	@Column(nullable = false , name = "full_name")
	private String fullName;
	@Column(nullable = false , unique = true , name = "email_id")
	private String email;
	@Column(nullable = false , unique = true , name = "mobile_number")
	private String mobile;
	@Column(nullable = false , name = "acc_pass")
	private String password;
	
	public Users() {
		super();
	}

	public Users(String fullName, String email, String mobile, String password) {
		super();
		this.fullName = fullName;
		this.email = email;
		this.mobile = mobile;
		this.password = password;
	}

	public Users(Integer id, String fullName, String email, String mobile, String password) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.email = email;
		this.mobile = mobile;
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", fullName=" + fullName + ", email=" + email + ", mobile=" + mobile + ", password="
				+ password + "]";
	}
	
	
	
	
}
