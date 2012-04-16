package junit.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.support.AbstractXmlApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.hiyoru.model.Person;
import cn.hiyoru.service.PersonService;

public class IntegrationTest {

	@Test
	public void test() {
		AbstractXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				"beans.xml");
		PersonService personService = (PersonService) ctx
				.getBean("personServiceImpl");
		personService.save(new Person("hiyoru", "hiyoru"));
		// personService.updateAfterSave(new Person("hiyoru", "hiyoru"));
		List<Person> persons = personService.list();
		for (Person person : persons) {
			System.out.println(person.getId() + "---" + person.getUsername()
					+ "---" + person.getPassword());
		}

	}

}
