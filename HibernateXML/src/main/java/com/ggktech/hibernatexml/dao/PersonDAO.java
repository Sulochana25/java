package com.ggktech.hibernatexml.dao;


import java.util.List;

import com.ggktech.hibernatexml.model.Person;



public interface PersonDAO {

	public void save(Person p);
	
	public List<Person> list();
	
}
