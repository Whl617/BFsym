package com.longge.action;

import java.io.File;  
import java.io.FileInputStream;  
import java.io.FileOutputStream;  
import java.io.InputStream;  
import java.io.OutputStream;  
import java.io.PrintWriter;  
  
import javax.servlet.http.HttpServletResponse;  
  
import org.apache.struts2.ServletActionContext;  
  
import com.opensymphony.xwork2.ActionSupport;  
  
public class CkeditorUpload extends ActionSupport {  
  
    private File upload;  
    private String uploadContentType;  
    private String uploadFileName;  
  
  
    public File getUpload() {  
        return upload;  
    }  
  
    public void setUpload(File upload) {  
          
        this.upload = upload;  
    }  
  
    public String getUploadContentType() {  
        return uploadContentType;  
    }  
  
    public void setUploadContentType(String uploadContentType) {  
        this.uploadContentType = uploadContentType;  
    }  
  
    public String getUploadFileName() {  
        return uploadFileName;  
    }  
  
    public void setUploadFileName(String uploadFileName) {  
        this.uploadFileName = uploadFileName;  
    }  
  
    public String execute() throws Exception {  
         System.out.println("进入了");
        HttpServletResponse response = ServletActionContext.getResponse();  
        response.setCharacterEncoding("utf-8");  
        PrintWriter out = response.getWriter();  
  
        // CKEditor提交的很重要的一个参数  
        String callback = ServletActionContext.getRequest().getParameter("CKEditorFuncNum");   
          
        String expandedName = "";  //文件扩展名  
        if (uploadContentType.equals("image/pjpeg") || uploadContentType.equals("image/jpeg")) {  
            //IE6上传jpg图片的headimageContentType是image/pjpeg，而IE9以及火狐上传的jpg图片是image/jpeg  
            expandedName = ".jpg";  
        }else if(uploadContentType.equals("image/png") || uploadContentType.equals("image/x-png")){  
            //IE6上传的png图片的headimageContentType是"image/x-png"  
            expandedName = ".png";  
        }else if(uploadContentType.equals("image/gif")){  
            expandedName = ".gif";  
        }else if(uploadContentType.equals("image/bmp")){  
            expandedName = ".bmp";  
        }else{  
            out.println("<script type=\"text/javascript\">");    
            out.println("window.parent.CKEDITOR.tools.callFunction(" + callback + ",''," + "'文件格式不正确（必须为.jpg/.gif/.bmp/.png文件）');");   
            out.println("</script>");  
            return null;  
        }  
          
        if(upload.length() > 600*1024){  
            out.println("<script type=\"text/javascript\">");    
            out.println("window.parent.CKEDITOR.tools.callFunction(" + callback + ",''," + "'文件大小不得大于600k');");   
            out.println("</script>");  
            return null;  
        }  
          
        String username=(String)ServletActionContext.getRequest().getSession().getAttribute("username");
        InputStream is = new FileInputStream(upload);  
        String uploadPath = ServletActionContext.getServletContext()     
                .getRealPath("/img/postImg/")+username;  
        File file=new File(uploadPath);
        if(!file.exists())file.mkdirs();
        String filename=java.util.UUID.randomUUID().toString()+expandedName;
        File toFile = new File(uploadPath, filename);  
        OutputStream os = new FileOutputStream(toFile);     
        byte[] buffer = new byte[1024];     
        int length = 0;  
        while ((length = is.read(buffer)) > 0) {     
            os.write(buffer, 0, length);     
        }     
        is.close();  
        os.close();  
          
        // 返回“图像”选项卡并显示图片  
        out.println("<script type=\"text/javascript\">");    
        out.println("window.parent.CKEDITOR.tools.callFunction(" + callback + ",'" + "http://localhost:8888/BFsym/img/postImg/"+username+"/" + filename + "','')");    
        out.println("</script>");  
          
        return null;  
    }  
}  
