package com.tweetalert.dao;

import java.io.Serializable;
import java.util.List;

import com.tweetalert.util.DaoException;



public interface GenericDAO<T, ID extends Serializable>{
	
	public List<T> listALL() throws DaoException;
	
	public T create(T entity) throws DaoException;
	
	public T update(T entity) throws DaoException;
	
	public T findById(ID id) throws DaoException;
	
	public boolean delete(T entity) throws DaoException;
	
	public T getLastById() throws DaoException;;

}
