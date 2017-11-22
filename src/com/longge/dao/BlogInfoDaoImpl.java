package com.longge.dao;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.longge.domain.BlogInfo;

public class BlogInfoDaoImpl extends HibernateDaoSupport implements BlogInfoDao{

	@Override
	public void save(BlogInfo blogInfo) {
		this.getSessionFactory().getCurrentSession().saveOrUpdate(blogInfo);
	}

	@Override
	public BlogInfo get(String username) {
		
		return this.getSessionFactory().getCurrentSession().get(BlogInfo.class, username);
	}

}
