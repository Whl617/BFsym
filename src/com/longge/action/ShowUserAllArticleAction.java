package com.longge.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.longge.bean.Page;
import com.longge.bean.Result;
import com.longge.domain.Article;
import com.longge.domain.BlogInfo;
import com.longge.service.ArticleService;
import com.longge.service.BlogInfoService;
import com.opensymphony.xwork2.ActionSupport;

public class ShowUserAllArticleAction extends ActionSupport{

	private ArticleService articleService;
	private int currentPage;
	 private BlogInfoService blogInfoService;
	@Override
	public String execute() throws Exception {
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session=ServletActionContext.getRequest().getSession();
		String username=(String)session.getAttribute("username");
		String fixusername=(String)request.getParameter("fixusername");
		if((String)request.getParameter("username")!=null&&!"".equals((String)request.getParameter("username")))
				username=(String)request.getParameter("username");
		if((String)request.getParameter("username")==null||"".equals((String)request.getParameter("username")))
		{
			if(username==null||"".equals(username)){
				return LOGIN;
			}
		}
		BlogInfo blogInfo=blogInfoService.getBlogInfo(username);
		if(blogInfo!=null)
		{
			session.setAttribute("blogtitle", blogInfo.getBlogtitle());
			session.setAttribute("idiograph", blogInfo.getIdiograph());
		}
	    Page page=new Page();
	    page.setCurrentPage(currentPage);
	    page.setEveryPage(5);
	    Result result=articleService.showUserAllByPage(username, page);
		List<Article> all=result.getList();
		List critiqueCounts=new ArrayList<>();
		for(Article article:all)
		{
			critiqueCounts.add(articleService.getCritiqueCount(article.getId()));
		}
		page=result.getPage();
		request.setAttribute("all", all);
		request.setAttribute("page", page);
		request.setAttribute("critiqueCounts", critiqueCounts);
		request.setAttribute("fixusername", fixusername);
		return SUCCESS;
	}
	public BlogInfoService getBlogInfoService() {
		return blogInfoService;
	}
	public void setBlogInfoService(BlogInfoService blogInfoService) {
		this.blogInfoService = blogInfoService;
	}
	public ArticleService getArticleService() {
		return articleService;
	}
	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	

}
