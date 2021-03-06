package com.vermeg.polytech.Service;

import java.util.List;

public interface IService <T> {
	public List<T> find();
	public T findById(int id);
	public void add (T object);
	public void update(T object);
	public void delete(T object);
}
