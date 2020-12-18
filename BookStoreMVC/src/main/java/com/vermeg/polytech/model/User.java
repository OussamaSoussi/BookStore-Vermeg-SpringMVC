package com.vermeg.polytech.model;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "User")
public class User {

	@OneToMany(mappedBy="user", fetch = FetchType.EAGER,  cascade= {CascadeType.ALL})
	private List<Order> orderList;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="email", unique = true)
	private String email;
	
	@Column(name="password")
	private String password;
	
	@Enumerated(EnumType.STRING)
    @Column(name = "type")
	private Role type;

	public User() {}

	public User(int id, String name, String email, String password, Role type) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.type = type;
		
	}

	public Role getType() {
		return type;
	}

	public void setType(Role type) {
		this.type = type;
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

	@Override
	public String toString() {
		return "User [orderList=" + orderList + ", id=" + id + ", name=" + name + ", email=" + email + ", password="
				+ password + ", type=" + type + "]";
	}


	
}
