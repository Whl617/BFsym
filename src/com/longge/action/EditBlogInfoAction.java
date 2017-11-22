package com.longge.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.longge.domain.BlogInfo;
import com.longge.service.BlogInfoService;
import com.opensymphony.xwork2.ActionSupport;

public class EditBlogInfoAction extends ActionSupport{

	private String blogtitle;
	private String idiograph;
	private BlogInfoService blogInfoService;
	
	public String getBlogtitle() {
		return blogtitle;
	}


	public void setBlogtitle(String blogtitle) {
		this.blogtitle = blogtitle;
	}


	public String getIdiograph() {
		return idiograph;
	}


	public void setIdiograph(String idiograph) {
		this.idiograph = idiograph;
	}

	public BlogInfoService getBlogInfoService() {
		return blogInfoService;
	}


	public void setBlogInfoService(BlogInfoService blogInfoService) {
		this.blogInfoService = blogInfoService;
	}

	@Override 
	public String execute() throws Exception {
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		BlogInfo blogInfo=new BlogInfo();
		blogInfo.setUsername((String)session.getAttribute("username"));
		blogInfo.setBlogtitle(blogtitle);
		blogInfo.setIdiograph(idiograph);
		blogInfoService.setBlogInfo(blogInfo);
		request.setAttribute("fixusername", (String)session.getAttribute("username"));
		return SUCCESS;
	}

}
