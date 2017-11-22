package com.longge.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.longge.domain.BlogInfo;
import com.longge.service.BlogInfoService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class GetBlogInfoAction extends ActionSupport {
	private BlogInfoService blogInfoService;

	public BlogInfoService getBlogInfoService() {
		return blogInfoService;
	}

	public void setBlogInfoService(BlogInfoService blogInfoService) {
		this.blogInfoService = blogInfoService;
	}

	@Override
	public String execute() throws Exception {
		HttpSession session=ServletActionContext.getRequest().getSession();
		BlogInfo blogInfo=blogInfoService.getBlogInfo((String)session.getAttribute("username"));
		if(blogInfo!=null)
		{
			session.setAttribute("blogtitle", blogInfo.getBlogtitle());
			session.setAttribute("idiograph", blogInfo.getIdiograph());
		}
		return SUCCESS;
	}
	
}
