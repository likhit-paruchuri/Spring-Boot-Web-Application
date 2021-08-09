package com.example.demolib1;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="bookdata")
public class Book {
	@Id
	 @GeneratedValue(strategy=GenerationType.AUTO,generator="native")
	 @GenericGenerator(name = "native",strategy = "native")
	@Column(name="bookid")
	private int bookid;
	@Column(name="bookname")
	private String bookname;
	@Column(name="email")
	private String email;
	
	public Book() {
		
	}
	public Book(int bookid, String email, String bookname) {
		this.bookid=bookid;
		this.email=email;
		this.bookname=bookname;
	}
	
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
