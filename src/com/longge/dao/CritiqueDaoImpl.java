package com.longge.dao;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.longge.bean.Page;
import com.longge.domain.Article;
import com.longge.domain.Critique;

public class CritiqueDaoImpl extends HibernateDaoSupport implements CritiqueDao{

	@Override
	public void addCritique(Critique critique) {
		this.getSessionFactory().getCurrentSession().save(critique);	
	}

	@Override
	public int queryCritiqueCount(int Aid) {
		Long long1=(Long)this.getSessionFactory().getCurrentSession().createQuery("select count(*) from Critique where aid = "+Aid).list().get(0);
		return long1.intValue();
	}

	@Override
	public List<Critique> queryByPage(int Aid, Page page) {
		Query<Critique> query =this.getSessionFactory().getCurrentSession().createQuery("select crt from Critique crt where aid="+Aid);
		query.setMaxResults(page.getEveryPage());
		query.setFirstResult(page.getBeginIndex());
		return query.list();
	}

}
