<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
 <%@ taglib prefix="ck" uri="http://ckeditor.com"%>
<%@taglib uri="/struts-tags" prefix="s"%>	
<HTML>
	<HEAD>
		<title>添加文章</title>
		<link rel="stylesheet" href="image/style.css">
		<script src="ckeditor/ckeditor.js"></script>
	</HEAD>
	<body leftMargin="0" topMargin="0" MS_POSITIONING="GridLayout">
		<div style="margin: 0 auto; width: 80%;text-align: center;">
          <jsp:include page="include/MainHeader.jsp"></jsp:include>
           <div class="h3">添加文章</div>
        </div>
		<form action="article.action" method="post">
			<TABLE WIDTH="80%" BORDER="0" CELLPADDING="0" CELLSPACING="0" align="center">
				<tr height="20">
					<td height="24" colspan="2">&nbsp;</td>
				</tr>
				<TR>
					<td valign="top">
						
						<br>
		
					</td>
					<TD COLSPAN="2" align="center" valign="top">
						<table width="100%" style="BORDER-RIGHT:#cccccc 1px solid; BORDER-TOP:#cccccc 1px solid; BORDER-LEFT:#cccccc 1px solid; BORDER-BOTTOM:#cccccc 1px solid; BACKGROUND-COLOR:#f5f5f5"
							CellPadding="0" CellSpacing="0">	
							<tr height="20">
								<td>
									&nbsp;&nbsp;&nbsp;标题：
									<div>
										&nbsp;&nbsp;&nbsp;<input type="text" name="title"  Width="600px" Style="inputcss" />
									</div>
								</td>
								<td width=><s:fielderror><s:param>title</s:param></s:fielderror></td>
							</tr>
							<tr>
								<td>
									&nbsp;&nbsp;&nbsp;内容：
									<ck:editor editor="content" basePath="ckeditor" ></ck:editor>
								</td>
								<td width=><s:fielderror><s:param>content</s:param></s:fielderror></td>
							</tr>
							<tr height="20">
								<td>
									<input type="submit"  value="添加" Style="ButtonCss" />
									<input type="button" name="cancelButton" value="取消" onClick="history.back()" Class="ButtonCss">
								</td>
							</tr>
						</table>
					</TD>
				</TR>
			</TABLE>
			<input type="hidden" name="fixusername" value="<%=session.getAttribute("username")%>"/>
		</form>
	</body>
</HTML>

