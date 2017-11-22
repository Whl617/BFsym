package com.longge.bean;
//枫叶信息辅助类
public class PageUtil {
	// 生成Page类
	public static Page createPage(int everyPage,int totalCount,int currentPage)
	{
		int totalPage=getTotalPage(everyPage, totalCount);
		int beginIndex=getBeginIndex(everyPage, currentPage);
		boolean hasPrePage=getHasPrePage(currentPage);
		boolean hasNextPage=getHasNextPage(totalPage, currentPage);
		return new Page(everyPage, totalCount, totalPage, currentPage, beginIndex, hasNextPage, hasPrePage);
	}
	public static Page createPage(Page page,int totalCount)
	{
		int currentPage=getCurrentPage(page.getCurrentPage());
		int everyPage=getEveryPage(page.getEveryPage());
		int totalPage=getTotalPage(page.getEveryPage(), totalCount);
		int beginIndex=getBeginIndex(page.getEveryPage(), currentPage);
		boolean hasPrePage=getHasPrePage(currentPage);
		boolean hasNextPage=getHasNextPage(totalPage, currentPage);
		return new Page(everyPage, totalCount, totalPage, currentPage, beginIndex, hasNextPage, hasPrePage);
	}
	// 设置每页显示记录数
	public static int getEveryPage(int everyPage)
	{
		return everyPage == 0 ? 10 : everyPage;
	}
	// 设置当前页
	public static int getCurrentPage(int currentPage)
	{
		return currentPage == 0 ? 1 : currentPage;
	}
	// 设置总页数
	public static int getTotalPage(int everyPage,int totalCount)
	{
		int totalPage=0;
		if(totalCount%everyPage==0)
			totalPage = totalCount / everyPage ;
		else 
			totalPage=totalCount/everyPage+1;
	    return totalPage;
	}
	//设置起始点
	public static int getBeginIndex(int everyPage,int currentPage)
	{
		return everyPage*(currentPage-1);
	}
	//设置是否有上一页
	public static boolean getHasPrePage(int currentPage)
	{
		return currentPage == 1 ? false : true;
	}
	//设置是否有下一页
	public static boolean getHasNextPage(int totalPage,int currentPage)
	{
		return currentPage == totalPage || totalPage==0 ? false : true;
	}
}
 