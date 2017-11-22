package com.longge.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.longge.bean.Page;
import com.longge.bean.Result;
import com.longge.domain.Article;
import com.longge.service.ArticleService;
import com.opensymphony.xwork2.ActionSupport;

public class ShowAllArticleAction extends ActionSupport{
	private ArticleService articleService;
	private int currentPage;
	@Override
	public String execute() throws Exception {
	    Page page=new Page();
	    page.setCurrentPage(currentPage);
	    page.setEveryPage(10);
	    Result result=articleService.showAllByPage(page);
		List<Article> all=result.getList();
		List critiqueCounts=new ArrayList<>();
		for(Article article:all)
		{
			critiqueCounts.add(articleService.getCritiqueCount(article.getId()));
		}
		page=result.getPage();
		HttpServletRequest request=ServletActionContext.getRequest();
		request.setAttribute("all", all);
		request.setAttribute("page", page);
		request.setAttribute("critiqueCounts", critiqueCounts);
		return SUCCESS;
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
