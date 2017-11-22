package com.longge.dao;

import java.util.List;

import com.longge.bean.Page;
import com.longge.domain.Article;
import com.longge.domain.Critique;

public interface CritiqueDao {

	// �������
	public void addCritique(Critique critique);
	// ���ָ�����µ�������
	 public int queryCritiqueCount(int Aid);
	// ����page��ѯ����
	public List<Critique> queryByPage(int Aid,Page page);
	
}
