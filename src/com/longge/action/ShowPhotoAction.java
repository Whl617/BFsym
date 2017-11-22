package com.longge.action;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class ShowPhotoAction extends ActionSupport{

	@Override
	public String execute() throws Exception {
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		String username=(String)session.getAttribute("username");
		String fixusername=(String)request.getParameter("fixusername");
		if(fixusername==null)fixusername=(String)request.getAttribute("fixusername");
		if((String)request.getParameter("username")!=null&&!"".equals((String)request.getParameter("username")))
			username=(String)request.getParameter("username");
		String filePath=ServletActionContext.getServletContext().getRealPath("/user/photo/"+username);
		File photo=new File(filePath);
		String[] strings=photo.list();
		request.setAttribute("photos", strings);
		request.setAttribute("fixusername", fixusername);
		return super.execute();
	}
	
	

}
