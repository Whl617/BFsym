package com.longge.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.longge.domain.Article;
import com.longge.domain.Dianjiliang;

public class DianjiliangDaoImpl extends HibernateDaoSupport implements DianjiliangDao{

	@Override
	public List<Dianjiliang> QueryByAId(int AId, String Ip, Date date) {
		Query<Dianjiliang> query =this.getSessionFactory().getCurrentSession().createQuery("select djl from Dianjiliang djl where aid=? and ip=? and date=?");
		query.setParameter(0, AId);
		query.setParameter(1, Ip);
		query.setParameter(2, date);
		return query.list();
	}

	@Override
	public void addDianjiliang(Dianjiliang dianjiliang) {
		this.getSessionFactory().getCurrentSession().save(dianjiliang);
		
	}

}
