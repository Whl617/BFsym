<%@ page language="java" contentType="text/html; charset=gb2312"
	pageEncoding="gb2312"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
		<title>�ҵ�ȫ������</title>
		<link rel="stylesheet" href="image/style.css" />
	</head>

	<body topmargin="0" leftmargin="0" bgcolor="#F3F3F3">
		<div style="margin: 0 auto; width: 80%">
          <jsp:include page="include/MainHeader.jsp"></jsp:include>
        </div>
		<table width="80%" border="0" cellpadding="0" cellspacing="0"
			align="center">
			<tr height="30" valign="bottom">
				<td class="title" style="font-size:large;">
					ȫ������
				</td>
			</tr>
			<tr>
			<td>&nbsp;</td>
			</tr>
			<tr>
				<td colspan="2" valign="top">
					<table cellpadding="4" cellspacing="1">
						<tr>
							<td>
								<table width="1000" cellpadding="6" cellspacing="1"
									bgcolor="#CCCCCC">

									<!-- ѭ����� -->
									<s:set name="i" value="-1"></s:set>
									<s:iterator value="#request.all" id="art">
										<tr>
											<td bgcolor="#FFFFFF">
												<font class="chinesefont105main"> <!-- ���±���  --> 
												<a style="font-size: medium;" href="showarticle.action?id=<s:property value='#art.id'/>&fixusername=<%=request.getAttribute("fixusername")%>"><s:property value="#art.title"/></a>
													<hr size='1' noshade color='#CCCCCC' width="100%"> <br>
													<div align='right' class='smalltxt' height='32px'>
														<!-- ����ʱ�� -->
														������:
														<s:date name="#art.date"/>
														<!-- ���������� -->
														|����(<s:property value="#request.critiqueCounts[#i=#i+1]"/>)|���(<s:property value="#art.hadread"/>)
														
													</div> 
												</font>
											</td>
										</tr>
									</s:iterator>
									<tr>
									    <td align="center">
									    <s:if test="#request.page.hasPrePage">
									      <a href="showuserall.action?currentPage=1">��ҳ</a>
									      <a href="showuserall.action?currentPage=${page.currentPage-1}">��һҳ</a>
									    </s:if>
									    <s:else>
									                      ��ҳ
									                     ��һҳ
									    </s:else>
									    
									    <s:if test="#request.page.hasNextPage">
									      <a href="showuserall.action?currentPage=${page.currentPage+1}">��һҳ</a>
									      <a href="showuserall.action?currentPage=${page.totalPage}">βҳ</a>
									    </s:if>
									    <s:else>
									                      ��һҳ
									                      βҳ      
									    </s:else>
									    </td>
									</tr>
								</table>
								<table id="noCount" runat="server" width="1000" cellpadding="6"
									cellspacing="1" bgcolor="#cccccc">
									<tr bgcolor="#ffffff" height="50">
										<%String username=request.getParameter("username");
			                                      if(username==null||"".equals(username)){
			                                         %>
													<td align="center">
														${sessionScope.username}�Ĳ���
													</td>
													
												<%}else{ %>
												      <td align="center">
														${param.username}�Ĳ���
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
	</body>
</html>