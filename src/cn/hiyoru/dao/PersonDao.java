package cn.hiyoru.dao;

import java.util.List;

import cn.hiyoru.model.Person;

public interface PersonDao {

	public void save(Person person);

	public void delete(int... ids);

	public void update(Person person);

	public Person get(int id);
	
	public Person getByName(String name);

	public List<Person> list();
}
