package com.longge.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;

import org.apache.struts2.ServletActionContext;

import com.longge.domain.BlogInfo;
import com.longge.domain.User;
import com.longge.service.BlogInfoService;
import com.longge.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{

	private String username;
	private String password;
	private UserService userService;
	private BlogInfoService blogInfoService;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
 
	
	
	@Override
	public String execute() throws Exception {
		User user=new User();
		user.setUsername(username);
		user.setPassword(password);
		HttpServletRequest request=ServletActionContext.getRequest();
		if(userService.loginUser(user)){
			request.setAttribute("url", "user/showuserall.action?fixusername="+username+"&username="+username);
			request.setAttribute("info", "µÇÂ½³É¹¦");
			BlogInfo blogInfo=blogInfoService.getBlogInfo(username);
			HttpSession session=request.getSession();
			session.setAttribute("username",username);
			if(blogInfo!=null){
				session.setAttribute("blogtitle", blogInfo.getBlogtitle());
				session.setAttribute("idiograph", blogInfo.getIdiograph());
			}
			else{
				session.setAttribute("blogtitle","");
				session.setAttribute("idiograph", "");
			}
			request.setAttribute("fixusername", username);
			return SUCCESS;
		}
		else {
			request.setAttribute("url", "login.jsp");
			request.setAttribute("info", "µÇÂ¼Ê§°Ü");
			return ERROR;
		}
	}
	public BlogInfoService getBlogInfoService() {
		return blogInfoService;
	}
	public void setBlogInfoService(BlogInfoService blogInfoService) {
		this.blogInfoService = blogInfoService;
	}
      
}
