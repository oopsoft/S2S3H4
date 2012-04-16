package cn.hiyoru.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
public class AdminAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String execute() {
		username = (String)ActionContext.getContext().getSession()
				.get("username");
		return "admin";
	}
}
