package com.example.book.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //AUTO INCREMENTS the PRIMARY KEY
	private Integer book_id;
	
	@Column(nullable = false)
	private String name;
	
	private Integer price;
	
	private Integer publish_date;
	
	
	
	public Book() {
		super();
	}

	public Book(Integer book_id, String name, Integer price, Integer publish_date) {
		super();
		this.book_id = book_id;
		this.name = name;
		this.price = price;
		this.publish_date = publish_date;
	}

	public Integer getBook_id() {
		return book_id;
	}

	public void setBook_id(Integer book_id) {
		this.book_id = book_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getPublish_date() {
		return publish_date;
	}

	public void setPublish_date(Integer publish_date) {
		this.publish_date = publish_date;
	}

	@Override
	public String toString() {
		return "book [book_id=" + book_id + ", name=" + name + ", price=" + price + ", publish_date=" + publish_date
				+ "]";
	}


	
}
