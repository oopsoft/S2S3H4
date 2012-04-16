package cn.hiyoru.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.hiyoru.dao.PersonDao;
import cn.hiyoru.model.Person;
import cn.hiyoru.service.PersonService;

@Service
@Transactional
public class PersonServiceImpl implements PersonService {

	@Resource
	PersonDao personDao;

	public void updateAfterSave(Person person) {
		personDao.save(person);
		person.setPassword("changed...");
		personDao.update(person);
	}

	public void save(Person person) {
		personDao.save(person);
	}

	public void delete(int... ids) {
		personDao.delete(ids);
	}

	public void update(Person person) {
		personDao.update(person);
	}

	// @Transactional(propagation = Propagation.NOT_SUPPORTED)
	// Spring3与Hibernate4的
	// 整合有Bug，当事务传播属性为SUPPORTED/NOT_SUPPORTED/NEVER时获取不到Session
	// 暂时的解决办法是将所有需要事务的地方设置为REQURIED，或者使用OpenSessionInView
	public Person get(int id) {
		return personDao.get(id);
	}

	// @Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<Person> list() {
		return personDao.list();
	}

	public Person getByName(String name) {
		return personDao.getByName(name);
	}

}
