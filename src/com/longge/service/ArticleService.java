package com.longge.service;

import java.util.List;

import com.longge.bean.Page;
import com.longge.bean.Result;
import com.longge.domain.Article;

public interface ArticleService {
   public void addArticle(Article article);
   public List<Article> showUserAll(String username);
   public Result showUserAllByPage(String username,Page page);
   public Result showAllByPage(Page page);
   public Article showArticle(int id);
   public int getCritiqueCount(int Aid);
   }
