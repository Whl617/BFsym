<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>	
<%@taglib uri="/struts-tags" prefix="s"%>
<HTML>
	<HEAD>
		<title>相册</title>
		<meta name="vs_targetSchema" content="http://schemas.microsoft.com/intellisense/ie5">
		<script type="text/javascript">
		    var GB_ROOT_DIR = "./greybox/";
		</script>
		<script type="text/javascript" src="greybox/AJS.js"></script>
		<script type="text/javascript" src="greybox/AJS_fx.js"></script>
		<script type="text/javascript" src="greybox/gb_scripts.js"></script>
		<link href="greybox/gb_styles.css" rel="stylesheet" type="text/css" />
		<link rel="stylesheet" href="image/style.css">
	</HEAD>
	<body leftMargin="0" topMargin="0" MS_POSITIONING="GridLayout">
		<div style="margin: 0 auto; width: 80%">
          <jsp:include page="include/MainHeader.jsp"></jsp:include>
        </div>
		<form action="photoupload.action" method="post" enctype="multipart/form-data">
			<TABLE WIDTH="80%" BORDER="0" CELLPADDING="0" CELLSPACING="0" align="center">
				<tr height="20">
					<td height="24" colspan="2">&nbsp;</td>
				</tr>
				<tr>
				    <table cellspacing="5" align="center">
				     <tr>
				        <s:iterator value="#request.photos" id="photo" status="stu">
				        <td>
				        <%if(request.getParameter("username")==null||request.getParameter("username").equals("")){ 
				        System.out.println("aaaa");%>
				        <a href='photo/${sessionScope.username}/<s:property value="photo"/>' title="我的相册" rel="gb_imageset[photos]">
						    <img style="border: solid 3px gray" src='photo/${sessionScope.username}/<s:property value="photo"/>' width="100" height="120">
					    </a>
					    <%}else{ %>
					     <a href='photo/${param.username}/<s:property value="photo"/>' title="我的相册" rel="gb_imageset[photos]">
						    <img style="border: solid 3px gray" src='photo/${param.username}/<s:property value="photo"/>' width="100" height="120">
					    </a>
					    <%} %>
				        </td>
				        <s:if test="(#stu.index+1)%6==0">
				         </tr>
				         <tr>
				         </s:if>
				        </s:iterator>
				    </tr>
				    </table>
				</tr>
				<%if(request.getAttribute("fixusername")!=null){ %>
				<TR>
					<TD>
						<div align="center">
						<s:fielderror></s:fielderror>
						<input type="file" name="myFile">
						<input type="submit" value="上传图片"> 
						<input type="hidden" name="fixusername" value="<%=request.getAttribute("fixusername")%>"> 
						</div>
					</TD>
				</TR>	
				<%} %>
			</TABLE>
		</form>
	</body>
</HTML>

