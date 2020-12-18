package com.vermeg.polytech.model;

import java.util.*;
import javax.persistence.*;

@Entity
@Table(name="user_order")
public class Order {
	@Id
	@GeneratedValue
	private int id;
	
	@Column(name="order_date")
	private Calendar orderDate;
	
	@Column(name="order_status")
	private String status;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="user") 
	private User user;
	
	@OneToMany(mappedBy="order", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<OrderLine> orderLines;

	public Order(int id, Calendar orderDate, String status, User user) {
		this.id = id;
		this.orderDate = orderDate;
		this.status = status;
		this.user = user;
	}

	public Order(List<OrderLine> orderLines) {
		this.orderLines = orderLines;
	}

	public Order() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Calendar getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Calendar orderDate) {
		this.orderDate = orderDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<OrderLine> getOrderLines() {
		return orderLines;
	}

	public void setOrderLines(List<OrderLine> orderLines) {
		this.orderLines = orderLines;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", orderDate=" + orderDate + ", status=" + status + ", user=" + user
				+ ", orderLines=" + orderLines + "]";
	}
}
