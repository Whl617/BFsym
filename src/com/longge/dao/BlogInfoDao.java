package com.longge.dao;

import com.longge.domain.BlogInfo;

public interface BlogInfoDao {
	public void save(BlogInfo blogInfo);
	public BlogInfo get(String username);
}
