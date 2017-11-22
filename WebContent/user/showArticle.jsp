<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="ck" uri="http://ckeditor.com"%> 
<%@taglib uri="/struts-tags" prefix="s"%>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
		<title>我的文章</title>
		<link rel="stylesheet" href="image/style.css" />
		<script src="ckeditor/ckeditor.js"></script>
	</head>

	<body topmargin="0" leftmargin="0" bgcolor="#F3F3F3">
		<div style="margin: 0 auto; width: 80%">
          <jsp:include page="include/MainHeader.jsp"></jsp:include>
        </div>
		<table WIDTH="80%" BORDER="0" CELLPADDING="0" CELLSPACING="0" align="center">
			<tr>
				<td width="722" valign="top">
					<table width="100" border="0" cellpadding="0" cellspacing="0">
						<tr height="30" valign="bottom">
							<td class="title">
								&nbsp;
							</td>
						</tr>
						<tr>
							<td colspan="2" valign="top">
								<table width="100%" cellpadding="4" cellspacing="1">
									<tr>
										<td>
											<table width="1000" cellpadding="6" cellspacing="1"
												bgcolor="#CCCCCC">

												<tr>
													<td bgcolor="#FFFFFF">
														<font class="chinesefont105main">
														<p align="center" style="font-size: 20px;"><s:property value="#request.article.title"/></p>
															<hr size='1' noshade color='#CCCCCC'> <br>
															<div>
													   <s:property value="#request.article.content" escape="false"/>
															</div> 
														</font>
													</td>
												</tr>
													<tr>
													<td ><hr size='1' noshade color='#CCCCCC'></br><font color="gray" style="font-size: large;"><b>评论专区</b></font></td>
													</tr>
													<!-- 显示评论 -->
													<s:iterator value="#request.allCri" id="cri">
													<tr>
											            <td bgcolor="#FFFFFF">
												            <font class="chinesefont105main"> 
												              <p><font color="red"><s:property value="#cri.content" escape="false"/></font></p>
												               <hr size='1' noshade color='#CCCCCC'> <br>
										            <p align="right">作者：<s:property value="#cri.username" escape="false"/></p>
											               </font>
											            </td>
										            </tr>
													</s:iterator>
										<tr>
											<td align="center">
												<s:if test="#request.page.hasPrePage">
													<a href="showarticle.action?currentPage=1&id=<s:property value='#request.article.id'/>">首页</a>
													<a href="showarticle.action?currentPage=${page.currentPage -1 }&id=<s:property value='#request.article.id'/>">上一页</a>
												</s:if>
												<s:else>
													首页
													上一页
												</s:else>
												
												<s:if test="#request.page.hasNextPage">
													<a href="showarticle.action?currentPage=${page.currentPage + 1 }&id=<s:property value='#request.article.id'/>">下一页</a>
													<a href="showarticle.action?currentPage=${page.totalPage }&id=<s:property value='#request.article.id'/>">尾页</a>			
												</s:if>
												<s:else>
													下一页
													尾页
												</s:else>
											</td>
										</tr>
		</table>
		<form action="addcritique.action" method="post">
			<input type="hidden" name="id" value='${requestScope.article.id }'/>
			<hr size='1' noshade color='#CCCCCC'><font color="gray" style="font-size: large;"><b>评论它</b></font>
			<TABLE width="1000" height="300" BORDER="0" CELLPADDING="0" CELLSPACING="0" align="center">
				<tr height="20">
					<td height="24" colspan="2">&nbsp;</td>
				</tr>
				<TR>
					<td valign="top">
					</td>
					<TD COLSPAN="2" align="center" valign="top">
						<table width="1000" style="BORDER-RIGHT:#cccccc 1px solid; BORDER-TOP:#cccccc 1px solid; BORDER-LEFT:#cccccc 1px solid; BORDER-BOTTOM:#cccccc 1px solid; BACKGROUND-COLOR:#f5f5f5"
							CellPadding="0" CellSpacing="0">
	
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
		</form>
											<table id="noCount" runat="server" width="1000"
												cellpadding="6" cellspacing="1" bgcolor="#cccccc">
												<tr bgcolor="#ffffff" height="50">
												<%String username=request.getParameter("username");
			                                      if(username==null||"".equals(username)){
			                                         %>
													<td align="center">
														${sessionScope.username}的博客
													</td>
													
												<%}else{ %>
												      <td align="center">
														${param.username}的博客
													   </td>
													   <%} %>
												</tr>
											</table>
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
</body>
</html>