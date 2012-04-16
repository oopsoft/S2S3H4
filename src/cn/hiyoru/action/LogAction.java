package cn.hiyoru.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.hiyoru.model.Person;
import cn.hiyoru.service.PersonService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
// Action设置为prototype，保证线程安全
public class LogAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	@Resource
	PersonService personService;

	private boolean loginMark = false;

	private Person person;

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public boolean getLoginMark() {
		return loginMark;
	}

	public void setLoginMark(boolean loginMark) {
		this.loginMark = loginMark;
	}

	public String login() {
		String username = person.getUsername();
		String password = person.getPassword();
		if (!username.equals("") && username != null && !password.equals("")
				&& password != null) {
			Person person = personService.getByName(username);
			if (person != null) {
				if (person.getPassword().equals(password)) {
					ActionContext.getContext().getSession()
							.put("userid", person.getId());
					ActionContext.getContext().getSession()
							.put("username", person.getUsername());
					this.loginMark = true;
				}
			}
		}
		// System.out.println(loginMark);
		return "login";
	}

}
