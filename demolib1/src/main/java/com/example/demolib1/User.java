package com.example.demolib1;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;





@Entity
@Table(name="userdata")
public class User {
	
	@Id
	 @GeneratedValue(strategy=GenerationType.AUTO,generator="native")
	 @GenericGenerator(name = "native",strategy = "native")
	@Column(name="id")
	private int id;
	@Column(name="email")
	private String email;
	@Column(name="pass")
	private String pass;
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public User() {
		
	}
	public User(int id, String email, String pass) {
		this.id=id;
		this.email=email;
		this.pass=pass;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return pass;
	}
	public void setPassword(String pass) {
		this.pass = pass;
	}

}
