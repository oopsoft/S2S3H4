package cn.hiyoru.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class AuthInterceptor implements Interceptor {
	
	private static final long serialVersionUID = 1L;

	public void destroy() {

	}

	public void init() {

	}

	public String intercept(ActionInvocation actionInvocation) throws Exception {
		
		Object object = ActionContext.getContext().getSession().get("username");
		if(object!=null){
			actionInvocation.invoke();
			return "admin";
		}
		
		ActionContext.getContext().put("errorMessage", "你没有权限执行当前操作");

		return "error";
	}

}
