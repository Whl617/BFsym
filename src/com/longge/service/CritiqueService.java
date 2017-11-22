package com.longge.service;

import com.longge.bean.Page;
import com.longge.bean.Result;
import com.longge.domain.Critique;

public interface CritiqueService {

	public void addCritique(Critique critique);
	
	public Result showCritiqueByPage(int Aid,Page page);
}
