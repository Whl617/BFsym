package com.longge.dao;

import java.util.List;

import com.longge.bean.Page;
import com.longge.domain.Article;
import com.longge.domain.Critique;

public interface CritiqueDao {

	// 添加评论
	public void addCritique(Critique critique);
	// 获得指定文章的评论数
	 public int queryCritiqueCount(int Aid);
	// 根据page查询评论
	public List<Critique> queryByPage(int Aid,Page page);
	
}
