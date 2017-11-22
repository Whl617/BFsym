package com.longge.action;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport; 
import java.io.IOException;   
import java.net.URLEncoder;  
import java.util.Iterator;    
    
  
import org.apache.commons.lang.StringUtils;    
public class FindAllAction extends ActionSupport{


	public String execute() throws Exception {
		HttpServletResponse response=ServletActionContext.getResponse();
		String username=(String)ServletActionContext.getRequest().getSession().getAttribute("username");
		 String realPath = ServletActionContext.getServletContext()     
	                .getRealPath("/img/postImg/")+username;
		File folder = new File(realPath);  
        if(!folder.exists()){  
            return null;  
        }
        List<String> subFileerSet = new ArrayList<String>();
        File[] subFiles = folder.listFiles();  
        if(null != subFiles && 0 < subFiles.length){  
            for(int i=0;i < subFiles.length; i++){  
                File _file = subFiles[i];  
                if(_file.isDirectory()){  
                   continue;
                } else {  
                	System.out.println(_file.getName());
                    subFileerSet.add(_file.getName());  
                }  
            }  
        } 
        String callback =ServletActionContext.getRequest().getParameter("CKEditorFuncNum");  
        PrintWriter out;  
          
        response.setContentType("text/html");  
        response.setCharacterEncoding("utf-8");
        try {  
            out = response.getWriter();  
            out.println("<script>");  
              
            // 定义点击选择js  
            out.println("function choose(obj){");  
            out.println("window.opener.CKEDITOR.tools.callFunction(" + callback  
                    + ",obj);");  
            out.println("window.close();");  
            out.println("}");  
            out.println("</script>");  
              
      
              
            // 如果是文件夹，则显示文件夹并且可以再次触发下级和上级目录  

            // 如果是文件，则点击就选择文件到控件中  
            if(0 < subFileerSet.size()){  
                Iterator<String> subFileerSetIndex = subFileerSet.iterator();  
                while(subFileerSetIndex.hasNext()){  
                    String ftemp = subFileerSetIndex.next();    
                    String fileUrl = "http://localhost:8888/BFsym/img/postImg/"+username+"/" + ftemp;  
                    //fileUrl = StringUtils.replace(fileUrl, "//", "/");  
                      
                    out.print("<div style='width:150px;height:150px;float:left;word-break:break-all;padding:5px;background:#666699;margin:5px;'>");  
                    out.print("<a href='javascript:void(0)' onclick=choose('"+fileUrl+"')><img style='border:none;width:145px;height:145px;' src="+fileUrl+" mce_src="+fileUrl+" title='"+fileUrl+"'/></a>");  
                    out.print("</div>");  
                      

                }  
            }  
              
            out.flush();  
            out.close();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
		return null;
	}
	
	 private static String getDefaultFolderFromFreemarker(File folder){  
	        String path = folder.getPath();  
	        System.out.println(path);
	      path = path.substring(path.indexOf("img\\postImg\\"+ServletActionContext.getRequest().getSession().getAttribute("username")));  
	        return path;  
	    }  
	
}
