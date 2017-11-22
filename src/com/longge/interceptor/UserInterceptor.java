package com.longge.interceptor;


import java.util.Map;

import javax.servlet.http.HttpSession;

import org.aopalliance.intercept.Invocation;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class UserInterceptor extends AbstractInterceptor{

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		ActionContext actionContext=invocation.getInvocationContext();
		Map session=actionContext.getSession();
		String username=(String)session.get("username");
		
		if(username==null||"".equals(username))
		{
			return Action.LOGIN;
		}
		else {
			// 進行下一步操作
			return invocation.invoke();
		}
	}

}
