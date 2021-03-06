package com.vermeg.polytech.model;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "book")
public class Book {

	@OneToMany(mappedBy="book", fetch = FetchType.EAGER,  cascade= {CascadeType.ALL})
	private List<OrderLine> orderLine;
	
	@Id
	@GeneratedValue(strategy =  GenerationType.AUTO)
	private int id;
	
	@Column(name="title", unique = true)
	private String title;
	
	@Column(name="authorName")
	private String authorName;
	
	@Column(name="price")
	private double price;
	
	@Column(name="releaseDate")
	private Date releaseDate;

	public Book() {}
	
	public Book(int id, String title, String authorName, double price, Date releaseDate) {
		this.id = id;
		this.title = title;
		this.authorName = authorName;
		this.price = price;
		this.releaseDate = releaseDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	
	@Override
	public String toString() {
		return "Book [orderLine=" + orderLine + ", id=" + id + ", title=" + title + ", authorName=" + authorName
				+ ", price=" + price + ", releaseDate=" + releaseDate + "]";
	}

	public List<OrderLine> getOrderLine() {
		return orderLine;
	}

	public void setOrderLine(List<OrderLine> orderLine) {
		this.orderLine = orderLine;
	}

	public Book(List<OrderLine> orderLine) {
		this.orderLine = orderLine;
	}
	
	
	
	
	
}
