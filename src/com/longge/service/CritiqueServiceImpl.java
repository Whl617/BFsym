package com.longge.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.longge.bean.Page;
import com.longge.bean.PageUtil;
import com.longge.bean.Result;
import com.longge.dao.CritiqueDao;
import com.longge.domain.Article;
import com.longge.domain.Critique;

@Transactional
public class CritiqueServiceImpl implements CritiqueService{

	private CritiqueDao critiqueDao;
	@Override
	public void addCritique(Critique critique) {
		
		critiqueDao.addCritique(critique);
	}
	public CritiqueDao getCritiqueDao() {
		return critiqueDao;
	}
	public void setCritiqueDao(CritiqueDao critiqueDao) {
		this.critiqueDao = critiqueDao;
	}
	@Override
	public Result showCritiqueByPage(int Aid, Page page) {
		page=PageUtil.createPage(page, critiqueDao.queryCritiqueCount(Aid));
		List<Critique> list=critiqueDao.queryByPage(Aid, page);
		Result result=new Result();
		result.setList(list);
		result.setPage(page);
		return result;
	}

	
}
