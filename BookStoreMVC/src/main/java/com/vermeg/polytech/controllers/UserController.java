package com.vermeg.polytech.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vermeg.polytech.Service.IService;
import com.vermeg.polytech.model.User;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private IService<User> userService;
	
	public UserController() {}
	public UserController(IService<User> userService) {
		this.userService = userService;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/all", produces = "application/json")
	public List<User> find() {
		return this.userService.find();
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/add")
	public void add(@RequestBody User user) {
		this.userService.add(user);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/update")
	public void update(@RequestBody User user) {
		this.userService.update(user);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/delete")
	public void delete(@RequestBody User user) {
		this.userService.delete(user);
	}
	
	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET, produces = "application/json")
	public User getBook(@PathVariable int id) {
		return userService.findById(id);
	}
}
