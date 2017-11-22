package com.longge.service;

import com.longge.domain.BlogInfo;

public interface BlogInfoService {
	public void setBlogInfo(BlogInfo blogInfo);
    public BlogInfo getBlogInfo(String username);
}
