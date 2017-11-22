package com.longge.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.longge.bean.Page;
import com.longge.bean.PageUtil;
import com.longge.bean.Result;
import com.longge.dao.ArticleDao;
import com.longge.dao.CritiqueDao;
import com.longge.domain.Article;

@Transactional
public class ArticleServiceImpl implements ArticleService {
    private ArticleDao articleDao;
    private CritiqueDao critiqueDao;
    public ArticleDao getArticleDao() {
		return articleDao;
	}
	public void setArticleDao(ArticleDao articleDao) {
		this.articleDao = articleDao;
	}
	@Override
	public void addArticle(Article article) {
		articleDao.add(article);

	}
	@Override
	public List<Article> showUserAll(String username) {
		return articleDao.queryUserAll(username);
	}
	public CritiqueDao getCritiqueDao() {
		return critiqueDao;
	}
	public void setCritiqueDao(CritiqueDao critiqueDao) {
		this.critiqueDao = critiqueDao;
	}
	@Override
	public Result showUserAllByPage(String username, Page page) {
		page=PageUtil.createPage(page, articleDao.queryUserAllCount(username));
		List<Article> list=articleDao.queryByPage(username, page);
		Result result=new Result();
		result.setList(list);
		result.setPage(page);
		return result;
	}
	@Override
	public Result showAllByPage(Page page) {
		page=PageUtil.createPage(page, articleDao.queryAllCount());
		List<Article> list=articleDao.queryAllByPage(page);
		Result result=new Result();
		result.setList(list);
		result.setPage(page);
		return result;
	}
	@Override
	public Article showArticle(int id) {
	return articleDao.queryById(id);
	}
	@Override
	public int getCritiqueCount(int Aid) {
		return critiqueDao.queryCritiqueCount(Aid);
	}
	

}
