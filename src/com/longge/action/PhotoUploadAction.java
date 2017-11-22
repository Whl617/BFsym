package com.longge.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Request;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class PhotoUploadAction extends ActionSupport {
    private File myFile;
    private String myFileContentType;
    private String myFileFileName;
	public File getMyFile() {
		return myFile;
	}
	public void setMyFile(File myFile) {
		this.myFile = myFile;
	}
	public String getMyFileContentType() {
		return myFileContentType;
	}
	public void setMyFileContentType(String myFileContentType) {
		this.myFileContentType = myFileContentType;
	}
	public String getMyFileFileName() {
		return myFileFileName;
	}
	public void setMyFileFileName(String myFileFileName) {
		this.myFileFileName = myFileFileName;
	}
	@Override
	public String execute() throws Exception {
		// 创建输入流 
		InputStream  is = new FileInputStream(myFile);
		HttpSession session=ServletActionContext.getRequest().getSession();
		String username=(String)session.getAttribute("username");
		String filePath=ServletActionContext.getServletContext().getRealPath("/user/photo/"+username);
		File file=new File(filePath);
		if(!file.isDirectory())
			file.mkdir();
		File toFile=new File(filePath,this.getMyFileFileName());
		OutputStream os=new FileOutputStream(toFile);
		byte[] buffer=new byte[1024];
		int length=0;
		while((length=is.read(buffer))>0)
		{
			os.write(buffer,0,length);
		}
		is.close();
		os.close();
		System.out.println(ServletActionContext.getRequest().getParameter("fixusername"));
		ServletActionContext.getRequest().setAttribute("fixusername",ServletActionContext.getRequest().getParameter("fixusername") );
		return SUCCESS;
	}
	
}
