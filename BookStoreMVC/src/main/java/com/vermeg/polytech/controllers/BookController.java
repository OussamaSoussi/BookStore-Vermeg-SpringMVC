package com.vermeg.polytech.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vermeg.polytech.Service.BookService;
import com.vermeg.polytech.Service.IService;
import com.vermeg.polytech.model.Book;

@CrossOrigin(origins = "http://localhost:4200", allowedHeaders="*")
@RestController
@RequestMapping("/book")
public class BookController {

	@Autowired
	private IService<Book> bookService;
	
	public BookController() {}
	public BookController(IService<Book> bookService) {
		this.bookService = bookService;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/all", produces = "application/json")
	public List<Book> find() {
		return this.bookService.find();
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/add")
	public void add(@RequestBody Book book) {
		this.bookService.add(book);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/update")
	public void update(@RequestBody Book book) {
		this.bookService.update(book);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/delete")
	public void delete(@RequestBody Book book) {
		this.bookService.delete(book);
	}
	
	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET, produces = "application/json")
	public Book getBook(@PathVariable int id) {
		return bookService.findById(id);
	}
	
//	@RequestMapping(value = "calculate", method = RequestMethod.GET)
//	public double calculate(@RequestParam int id, @RequestParam int qte ) {
//		System.out.println(((BookService) bookService).calculate(getBook(id).getPrice(), qte));
//		return ((BookService) bookService).calculate(getBook(id).getPrice(), qte);
//	}
	
	@RequestMapping(value="/total-price/{id}", method = RequestMethod.GET, produces = "application/json")
	public double getTotalPriceOfOrder(@PathVariable int id) {
		return ((BookService) this.bookService).getTotalPriceOfOrder(id);
	}
	
}
