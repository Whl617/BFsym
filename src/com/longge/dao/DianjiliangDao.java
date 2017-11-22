package com.longge.dao;

import java.util.Date;
import java.util.List;

import com.longge.domain.Dianjiliang;

public interface DianjiliangDao {

	public List<Dianjiliang> QueryByAId(int AId,String Ip,Date date);
	public void addDianjiliang(Dianjiliang dianjiliang);
}
