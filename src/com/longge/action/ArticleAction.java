package com.longge.action;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.longge.domain.Article;
import com.longge.service.ArticleService;
import com.opensymphony.xwork2.ActionSupport;
// тЖ╪сндуб
public class ArticleAction extends ActionSupport {
	private String title;
	private String content;
	private ArticleService articleService;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public ArticleService getArticleService() {
		return articleService;
	}
	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		HttpSession session=ServletActionContext.getRequest().getSession();
		Article article=new Article();
		article.setContent(content);
		article.setTitle(title);
		article.setUsername((String)session.getAttribute("username"));
		article.setDate(new Date());
		article.setHadread(0);
		articleService.addArticle(article);
		return SUCCESS;
	}
}
