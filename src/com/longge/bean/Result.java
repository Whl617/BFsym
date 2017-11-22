package com.longge.bean;

import java.util.List;

import com.longge.domain.Article;

public class Result {

	private Page page;
	private List list;
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
}
