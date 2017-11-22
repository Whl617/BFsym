package com.longge.service;

import org.springframework.transaction.annotation.Transactional;

import com.longge.dao.BlogInfoDao;
import com.longge.domain.BlogInfo;
@Transactional
public class BlogInfoServiceImpl implements BlogInfoService{
    private BlogInfoDao blogInfoDao;
	@Override
	public void setBlogInfo(BlogInfo blogInfo) {
		// TODO Auto-generated method stub
		blogInfoDao.save(blogInfo);
	}

	@Override
	public BlogInfo getBlogInfo(String username) {
		// TODO Auto-generated method stub
		return blogInfoDao.get(username);
	}

	public BlogInfoDao getBlogInfoDao() {
		return blogInfoDao;
	}

	public void setBlogInfoDao(BlogInfoDao blogInfoDao) {
		this.blogInfoDao = blogInfoDao;
	}

}
