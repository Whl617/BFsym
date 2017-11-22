package com.longge.dao;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.longge.bean.Page;
import com.longge.domain.Article;

public class ArticleDaoImpl extends HibernateDaoSupport implements ArticleDao{

	@Override
	public void add(Article article) {
		// TODO Auto-generated method stub
		this.getSessionFactory().getCurrentSession().saveOrUpdate(article);
	}

	@Override
	public List<Article> queryUserAll(String username) {
		return this.getSessionFactory().getCurrentSession().createQuery("select art from Article art where art.username ='"+username+"'").list();
	}

	@Override
	public int queryUserAllCount(String username) {
		Long long1=(Long)this.getSessionFactory().getCurrentSession().createQuery("select count(*) from Article where username = '"+username+"'").list().get(0);
		return long1.intValue();
		
	}

	@Override
	public List<Article> queryByPage(String username, Page page) {
		Query<Article> query =this.getSessionFactory().getCurrentSession().createQuery("select art from Article art where username='"+username+"' order by art.date desc");
		query.setMaxResults(page.getEveryPage());
		query.setFirstResult(page.getBeginIndex());
		return query.list();
	}

	@Override
	public int queryAllCount() {
		Long long1=(Long)this.getSessionFactory().getCurrentSession().createQuery("select count(*) from Article").list().get(0);
		return long1.intValue();
	}

	@Override
	public List<Article> queryAllByPage(Page page) {
		Query<Article> query =this.getSessionFactory().getCurrentSession().createQuery("select art from Article art order by art.date desc");
		query.setMaxResults(page.getEveryPage());
		query.setFirstResult(page.getBeginIndex());
		return query.list();
	}

	@Override
	public Article queryById(int id) {
		return this.getSessionFactory().getCurrentSession().get(Article.class, id);	
	}

}
