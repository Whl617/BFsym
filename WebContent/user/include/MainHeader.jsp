<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" >
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery.js"></script>
<script src="js/bootstrap.min.js"></script>
</head>
<body>
<img src="image/timg.jpg" height="120px" width="100%"/>
    <ul class="nav nav-tabs" >
    <%
			   String username=(String)session.getAttribute("username");
			   String fixusername=(String)request.getAttribute("fixusername");
			   if(fixusername==null)fixusername=(String)request.getParameter("fixusername");
			   if(username==null||"".equals(username)){			
     %>
	      <li ><a href="../showall.action">博客网首页</a></li>
	      <li ><a href="showuserall.action?username=${param.username}">他的首页</a></li>
	      <li ><a href="showphoto.action">他的相册</a></li>
	      <% }else if(username.equals(fixusername)){%>
	      <li ><a href="../showall.action">博客网首页</a></li>
	      <li ><a href="showuserall.action?username=${param.username}&fixusername=<%=username%>">用户首页</a></li>
	      <li ><a href="editbloginfo.jsp?username=${param.username}&fixusername=<%=username%>">个性化设置</a></li>
	      <li ><a href="addArticle.jsp?username=${param.username}&fixusername=<%=username%>">写日志</a></li>
	      <li ><a href="showphoto.action?username=${param.username}&fixusername=<%=username%>">相册</a></li>
	      <%}else if(!username.equals(fixusername)){ %>
	      <li ><a href="../showall.action">博客网首页</a></li>
	      <li ><a href="showuserall.action?username=${param.username }">他的首页</a></li>
	      <li ><a href="showphoto.action?username=${param.username }">他的相册</a></li>
	      <li ><a href="showuserall.action?fixusername=<%=username%>">返回我的博客</a></li>
	      <%} %>
	</ul>
<div style="text-align: right;">
	<div class="h1"><p class="btn btn-default"><b>${sessionScope.blogtitle}:</b><span class="panel panel-default" style="font-size: small;">${sessionScope.idiograph}</span></p></div>
</div>

</body>
</html>