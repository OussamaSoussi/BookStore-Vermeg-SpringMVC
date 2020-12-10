package com.vermeg.polytech.DAO;

import java.util.List;

public interface IDAO<O> {
	public O findById(int id);
	public List<O> find();
	public void add(O object);
	public void delete(O object);
	public void update(O object);
}

