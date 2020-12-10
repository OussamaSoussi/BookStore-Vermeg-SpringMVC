package com.vermeg.polytech.DAO;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vermeg.polytech.model.User;

@Repository
public class UserDAO implements IDAO<User> {
	
	@Autowired
	SessionFactory sessionFactory;
	public UserDAO() {}
	public UserDAO(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public User findById(int id) {
		return (User) sessionFactory.getCurrentSession().get(User.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> find() {
		return this.sessionFactory.getCurrentSession().createQuery("from User").list();
	}

	@Override
	public void add(User object) {
		if (object instanceof User)
			this.sessionFactory.getCurrentSession().save((User)object);
		
	}

	@Override
	public void delete(User object) {
		if (object instanceof User)
			this.sessionFactory.getCurrentSession().delete((User)object);
		
	}

	@Override
	public void update(User object) {
		if (object instanceof User)
			this.sessionFactory.getCurrentSession().update((User)object);
		
	}

}
