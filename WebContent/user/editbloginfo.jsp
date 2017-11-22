<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>个性化设置</title>
<link rel="stylesheet" href="image/style.css" />
<style type="text/css">
<!--
.STYLE1 {
	color: #0000FF;
	font-weight: bold;
}
-->
</style>
</head>

<body topmargin="0" leftmargin="0" bgcolor="#f3f3f3">
		<div style="margin: 0 auto; width: 80%">
          <jsp:include page="include/MainHeader.jsp"></jsp:include>
        </div>
		<div style="margin:0 auto;margin-top:5%;width: 80%;">
	
           <form action="editBlogInfo.action" method="post" class="form-inline">
           
              <fieldset>
                <legend style="text-align: center;"><b>个性化设置</b></legend>
                 <div style="margin-left:40%;">
                    <div class="form-group has-warning">
                      <label>博客标题</label>
                      <input type="text" class="form-control" name="blogtitle"/>
                    <label class="control-label" for="inputWarning"><s:fielderror><s:param>blogtitle</s:param></s:fielderror></label>
                    </div></br></br>
                    <div class="form-group has-warning">
                      <label>个性签名</label>
                      <input type="text" class="form-control" name="idiograph"/>
                    <label class="control-label" for="inputWarning"><s:fielderror><s:param>idiograph</s:param></s:fielderror></label>
                    </div></br></br>
                    </div>
                    <div style="text-align: center;">
                    <div class="form-group" >
                      <input type="submit" class="btn btn-default" value="提交"/>
                      <input type="reset" class="btn btn-default" value="重置"/>
                      <input type="hidden" name="fixusername" value="<%=session.getAttribute("username")%>"/>
                    </div>
                    </div>
              </fieldset>
          </form>
        </div>
	</body>
</html>

