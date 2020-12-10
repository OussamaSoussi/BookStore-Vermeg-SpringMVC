package com.vermeg.polytech.model;

import javax.persistence.*;

@Entity
@Table(name = "oderLine")
public class OrderLine {
	
	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn(name = "book_id")
	private Book book;

	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
		
		@Column(name="quantity")
		private int quantity;
		
		public OrderLine() {}

		public OrderLine(int id, int quantity) {
			this.id = id;
			this.quantity = quantity;
		}

		public OrderLine(Book book, User user) {
			this.book = book;
			this.user = user;
		}

		public Book getBook() {
			return book;
		}

		public void setBook(Book book) {
			this.book = book;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public int getQuantity() {
			return quantity;
		}

		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}

		@Override
		public String toString() {
			return "OrderLine [book=" + book + ", user=" + user + ", id=" + id + ", quantity=" + quantity + "]";
		}
		
		
		
		
}
