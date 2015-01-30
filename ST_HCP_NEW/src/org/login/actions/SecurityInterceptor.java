package org.login.actions;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import nMarket.vo.Users;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class SecurityInterceptor extends AbstractInterceptor{
  
	private static final long serialVersionUID = 1L;

	public String intercept(ActionInvocation invocation) throws Exception { 
		ActionContext context = ActionContext.getContext();
		Map session = context.getSession();
		Users userBean = (Users) session.get("userInfo");
		if(userBean!=null){
			HttpServletRequest request = ServletActionContext.getRequest();
			String url = request.getRequestURI();
			if(url.endsWith("userLogin.action")){ 
				session.clear();
				return invocation.invoke();
			}
		}else{
			HttpServletRequest request = ServletActionContext.getRequest();
			String url = request.getRequestURI();
			if(url.endsWith("userLogin.action")){ 
				session.clear();
				return invocation.invoke();
			}
			if(!url.endsWith("userExit.action")){
				request.setAttribute("interceptMsg", "请重新登录系统");
				return "login";
			}
		}
		return invocation.invoke();
	}

}
