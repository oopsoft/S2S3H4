package cn.hiyoru.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import cn.hiyoru.model.Person;
import cn.hiyoru.service.PersonService;

@Controller
@Scope("prototype")
public class PersonAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	@Resource
	PersonService personService;

	List<Person> persons;

	public List<Person> getPersons() {
		return persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

	public String execute() {

		persons = personService.list();
		return "list";

	}

}
