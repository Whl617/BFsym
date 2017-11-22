package com.longge.dao;

import java.util.List;

import com.longge.bean.Page;
import com.longge.domain.Article;
import com.mchange.v2.async.StrandedTaskReporting;

public interface ArticleDao {
   public void add(Article article);
   public List<Article> queryUserAll(String username);
   public int queryUserAllCount(String username);
   public List<Article> queryByPage(String username,Page page);
   public int queryAllCount();
   public List<Article> queryAllByPage(Page page);
   public Article queryById(int id);
}
