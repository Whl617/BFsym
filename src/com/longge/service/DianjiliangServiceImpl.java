package com.longge.service;

import java.util.Date;

import org.springframework.transaction.annotation.Transactional;

import com.longge.dao.DianjiliangDao;
import com.longge.domain.Dianjiliang;
@Transactional
public class DianjiliangServiceImpl implements DianjiliangService{

	private DianjiliangDao dianjiliangDao;
	public DianjiliangDao getDianjiliangDao() {
		return dianjiliangDao;
	}
	public void setDianjiliangDao(DianjiliangDao dianjiliangDao) {
		this.dianjiliangDao = dianjiliangDao;
	}
	@Override
	public boolean isVistor(int aid, String ip, Date date) {
		if(!dianjiliangDao.QueryByAId(aid, ip, date).isEmpty()){
			return true;
		}
		else {
			Dianjiliang dianjiliang=new Dianjiliang();
			dianjiliang.setAid(aid);
			dianjiliang.setIp(ip);
			dianjiliang.setDate(date);
			dianjiliangDao.addDianjiliang(dianjiliang);
			return false;
		}
	}
}
