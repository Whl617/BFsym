package com.longge.action;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.longge.bean.Page;
import com.longge.bean.Result;
import com.longge.domain.Article;
import com.longge.domain.BlogInfo;
import com.longge.service.ArticleService;
import com.longge.service.BlogInfoService;
import com.longge.service.CritiqueService;
import com.longge.service.DianjiliangService;
import com.opensymphony.xwork2.ActionSupport;

import javassist.expr.NewArray;

public class ShowArticleAction extends ActionSupport{
	private ArticleService articleService;
    private int id;
    private DianjiliangService dianjiliangService;
    private CritiqueService critiqueService;
    private int currentPage;
    private BlogInfoService blogInfoService;
    private String username;
	public ArticleService getArticleService() {
		return articleService;
	}

	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String execute() throws Exception {
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		if(username==null||"".equals(username)){
			
		}
		else
		{BlogInfo blogInfo=blogInfoService.getBlogInfo(username);
		if(blogInfo!=null)
		{
			session.setAttribute("blogtitle", blogInfo.getBlogtitle());
			session.setAttribute("idiograph", blogInfo.getIdiograph());
		}
		else{
			session.setAttribute("blogtitle", "");
			session.setAttribute("idiograph", "");
		}
		}
		String ip=request.getRemoteAddr();
		Article article=articleService.showArticle(id);
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
		String stime=sdf.format(new Date());
		Date date=sdf.parse(stime);
		if(!dianjiliangService.isVistor(article.getId(), ip, date)){
			article.setHadread(article.getHadread()+1);
		}
		articleService.addArticle(article);
		Page page=new Page();
		System.out.println("aaa"+currentPage);
		page.setCurrentPage(currentPage);
		page.setEveryPage(5);
		Result result=critiqueService.showCritiqueByPage(id, page);
		page=result.getPage();
		request.setAttribute("article", article);
		request.setAttribute("page", page);
		request.setAttribute("allCri", result.getList());
		request.setAttribute("fixusername", username);
		return SUCCESS;
	}

	public DianjiliangService getDianjiliangService() {
		return dianjiliangService;
	}

	public void setDianjiliangService(DianjiliangService dianjiliangService) {
		this.dianjiliangService = dianjiliangService;
	}

	public CritiqueService getCritiqueService() {
		return critiqueService;
	}

	public void setCritiqueService(CritiqueService critiqueService) {
		this.critiqueService = critiqueService;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public BlogInfoService getBlogInfoService() {
		return blogInfoService;
	}

	public void setBlogInfoService(BlogInfoService blogInfoService) {
		this.blogInfoService = blogInfoService;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
