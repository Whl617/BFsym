<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>博客注册</title>
<link rel="stylesheet" href="image/style.css"/>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link href="css/bootstrap.min.css" rel="stylesheet"/>
<script src="https://code.jquery.com/jquery.js"></script>
<script src="js/bootstrap.min.js"></script>
<link rel="stylesheet" href="image/style.css"/>
</head>
<body topmargin="0" leftmargin="0" bgcolor="#f3f3f3">
<div style="margin: 0 auto; width: 80%">
<jsp:include page="include/MainHeader.jsp"></jsp:include>
</div>
    <div style="margin:0 auto;margin-top:5%;width: 80%;">
	<form class="form-inline" action="register.action" method="post">
		<fieldset>
         <legend style="text-align: center;"><b>新博客注册</b></legend>
         <div style="margin-left:40%;">
   <div class="form-group has-warning">
     <label >新的账户</label>
     <input type="text" class="form-control" name="username"/>
     <label class="control-label" for="inputWarning"><s:fielderror><s:param>username</s:param></s:fielderror></label>
   </div></br></br>
   <div class="form-group has-warning">
     <label>新的密码</label>
     <input type="password" class="form-control" name="password"/>
     <label class="control-label" for="inputWarning"><s:fielderror><s:param>password</s:param></s:fielderror></label>
   </div></br></br>
    <div class="form-group has-warning">
     <label>确认密码</label>
     <input type="password" class="form-control" name="repassword"/>
     <label class="control-label" for="inputWarning"><s:fielderror><s:param>repassword</s:param></s:fielderror></label>
   </div></br></br>
   <div class="form-group has-warning">
     <label>新的昵称</label>
     <input type="text" class="form-control" name="nickname"/>
     <label class="control-label" for="inputWarning"><s:fielderror><s:param>nickname</s:param></s:fielderror></label>
   </div></br></br>
   <div class="form-group has-warning">
     <label>密码问题</label>
     <select name="question" style="width:60%;" >
		<option value="你的生日">你的生日</option>
		<option value="你的家乡">你的家乡</option>
		<option value="你最喜欢的食物">你最喜欢的食物</option>
	 </select>
     <label class="control-label" for="inputWarning"><s:fielderror><s:param>question</s:param></s:fielderror></label>
   </div></br></br>
   <div class="form-group has-warning">
     <label>密码答案</label>
     <input type="text" class="form-control" name="answer"/>
     <label class="control-label" for="inputWarning"><s:fielderror><s:param>answer</s:param></s:fielderror></label>
   </div></br></br>
   </div>
   <div style="text-align: center;">
   <div class="form-group">
     <input type="submit" class="btn btn-default" value="登录"/>
     <input type="reset" class="btn btn-default" value="重置"/>
   </div>
   </div>
      </fieldset>
      </form>
</div>
</body>
</html>
