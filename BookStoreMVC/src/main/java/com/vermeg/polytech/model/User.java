package com.vermeg.polytech.model;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "User")
public class User {

	@OneToMany(mappedBy="user", fetch = FetchType.EAGER,  cascade= {CascadeType.ALL})
	private List<OrderLine> orderLineList;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
	
	@Column(name="phone")
	private int phone;

	public User() {}

	public User(int id, String name, String email, String password, int phone) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.phone = phone;
	}

	public User(List<OrderLine> orderLineList) {
		this.orderLineList = orderLineList;
	}

	public List<OrderLine> getOrderLineList() {
		return orderLineList;
	}

	public void setOrderLineList(List<OrderLine> orderLineList) {
		this.orderLineList = orderLineList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "User [orderLineList=" + orderLineList + ", id=" + id + ", name=" + name + ", email=" + email
				+ ", password=" + password + ", phone=" + phone + "]";
	}
	
	
}