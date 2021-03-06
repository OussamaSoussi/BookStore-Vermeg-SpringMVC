package com.vermeg.polytech.DAO;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vermeg.polytech.model.Book;

@Repository
public class BookDAO implements IDAO<Book> {

	@Autowired
	SessionFactory sessionFactory;
	public BookDAO() {}
	public BookDAO(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public Book findById(int id) {
		return (Book) sessionFactory.getCurrentSession().get(Book.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Book> find() {
		return this.sessionFactory.getCurrentSession().createQuery("from Book").list();
	}

	@Override
	public void add(Book object) {
		if (object instanceof Book)
			this.sessionFactory.getCurrentSession().save((Book)object);
		
	}

	@Override
	public void delete(Book object) {
		if (object instanceof Book)
			this.sessionFactory.getCurrentSession().delete((Book)object);
	}

	@Override
	public void update(Book object) {
		if (object instanceof Book)
			this.sessionFactory.getCurrentSession().update((Book)object);
		
	}

}
