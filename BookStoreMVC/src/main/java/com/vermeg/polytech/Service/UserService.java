package com.vermeg.polytech.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vermeg.polytech.DAO.IDAO;
import com.vermeg.polytech.model.User;

@Service
public class UserService implements IService<User> {
	@Autowired
	private IDAO<User> userDAO;
	
	public UserService() {}
	public UserService(IDAO<User> userDAO) {
		this.userDAO = userDAO;
	}


	@Transactional
	public List<User> find() {
		return this.userDAO.find();
	}

	@Transactional
	public User findById(int id) {
		return this.userDAO.findById(id);
	}

	@Transactional
	public void add(User user) {
		this.userDAO.add(user);
		
	}

	@Transactional
	public void update(User user) {
		this.userDAO.update(user);
		
	}

	@Transactional
	public void delete(User user) {
		this.userDAO.delete(user);
		
	}
}
