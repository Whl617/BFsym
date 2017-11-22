package com.longge.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.http.HttpRequest;

import com.longge.domain.User;
import com.longge.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class RegisterAction extends ActionSupport{
	private String username;
	private String password;
	private String repassword;
    private String nickname;
    private String question;
    private String answer;
    private UserService userService;
    
    
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
	public String getRepassword() {
		return repassword;
	}
	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		User user=new User();
		user.setUsername(username);
		user.setAnswer(answer);
		user.setPassword(password);
		user.setNickname(nickname);
		user.setQuestion(question);
		HttpServletRequest request=ServletActionContext.getRequest();
		if(userService.registerUser(user)){
			request.setAttribute("url", "login.jsp");
			request.setAttribute("info", "×¢²á³É¹¦");
			return SUCCESS;
		}
		else {
			request.setAttribute("url", "register.jsp");
			request.setAttribute("info", "×¢²áÊ§°Ü");
			return ERROR;
		}
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
