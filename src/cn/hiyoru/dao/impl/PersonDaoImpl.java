package cn.hiyoru.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import cn.hiyoru.dao.PersonDao;
import cn.hiyoru.model.Person;

@Repository
public class PersonDaoImpl implements PersonDao {

	@Resource
	SessionFactory sessionFactory;

	public void save(Person person) {
		sessionFactory.getCurrentSession().persist(person);
	}

	public void delete(int... ids) {
		for (int id : ids) {
			sessionFactory.getCurrentSession().delete(
					sessionFactory.getCurrentSession().load(Person.class, id));
		}
	}

	public void update(Person person) {
		sessionFactory.getCurrentSession().merge(person);
	}

	public Person get(int id) {
		return (Person) sessionFactory.getCurrentSession()
				.get(Person.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Person> list() {
		return sessionFactory.getCurrentSession().createQuery("from Person")
				.list();
	}

	@SuppressWarnings("unchecked")
	public Person getByName(String name) {

		List<Person> list = (List<Person>) sessionFactory
				.getCurrentSession()
				.createQuery("from Person person where person.username = :name")
				.setString("name", name).list();
		if (list.size() > 0) {
			return list.get(0);
		} else
			return null;
	}

}
