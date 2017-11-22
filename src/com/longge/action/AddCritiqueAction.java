package com.longge.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.longge.domain.Critique;
import com.longge.service.CritiqueService;
import com.opensymphony.xwork2.ActionSupport;

public class AddCritiqueAction extends ActionSupport{

	private CritiqueService critiqueService;
    private int id;
    private String content;
	public CritiqueService getCritiqueService() {
		return critiqueService;
	}

	public void setCritiqueService(CritiqueService critiqueService) {
		this.critiqueService = critiqueService;
	}

	@Override
	public String execute() throws Exception {
		HttpSession session=ServletActionContext.getRequest().getSession();
		String username=(String)session.getAttribute("username");
		if(username==null||username=="")username="ÄäÃû";
		Critique critique=new Critique();
		critique.setAid(id);
		critique.setContent(content);
		critique.setUsername(username);
		critiqueService.addCritique(critique);
		return SUCCESS;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
