<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link href="css/bootstrap.min.css" rel="stylesheet"/>
<script src="https://code.jquery.com/jquery.js"></script>
<script src="js/bootstrap.min.js"></script>
<title>用户登陆</title>
<link rel="stylesheet" href="image/style.css"/>
<style type="text/css">
<!--
.STYLE1 {
	color: #0066FF;
	font-weight: bold;
}
-->
</style>
</head>

<body onLoad="document.forms[0]['username'].focus()" topmargin="0" leftmargin="0" bgcolor="#f3f3f3">
<div style="margin: 0 auto; width: 80%">
<jsp:include page="include/MainHeader.jsp"></jsp:include>
</div>
<div style="text-align:center;margin:0 auto;margin-top:10%;width: 80%;">
<form action="login.action" method="post" class="form-inline">
 <fieldset>
   <legend ><b>用户登录</b></legend>
   <div class="form-group">
     <label>登录账户</label>
     <input type="text" class="form-control" name="username"/>
   </div></br></br>
    <div class="form-group">
     <label>账户密码</label>
     <input type="password" class="form-control" name="password"/>
   </div></br></br>
    <div class="form-group">
     <input type="submit" class="btn btn-default" value="登录"/>
   </div>
 
 </fieldset>
</form>
</div>>
</div>
</body>
</html>
