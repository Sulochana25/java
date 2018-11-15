package com.ggktech.hibernatexml.main;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ggktech.hibernatexml.dao.PersonDAO;
import com.ggktech.hibernatexml.model.Person;

public class SpringHibernateMain {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		PersonDAO personDAO = context.getBean(PersonDAO.class);
		Person person = new Person();
		person.setName("SomeName");
		person.setCountry("India");
		personDAO.save(person);
		System.out.println("Person::" + person);
		List<Person> list = personDAO.list();

		for (Person p : list) {
			System.out.println("Person List::" + p);
		}
		context.close();
	}
}
