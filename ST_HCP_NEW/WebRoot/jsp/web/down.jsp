<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
		String strPrjName="/ST_HCP_NEW";
		String path = request.getContextPath();
		String basePath = request.getScheme() + "://" + request.getServerName()   ;
		if(!"".equals( request.getServerPort()))
		{
		   basePath+=  ":" + request.getServerPort() ;
		}
		if(strPrjName.equals(path))
		{
		   basePath+= path + "/";
		}else
		{
			 basePath+= "/";
		}
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>

		<title>区域管理实战模拟</title>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
		<base href="_self">
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		
		
<link rel="stylesheet" href="<%=basePath%>skins/yellow/css/style.css" type="text/css"></link>
 
	</head>

	<body>
	<form action="">
			<div class="footer"
				style="height: 23px; background: #897260; width: 960px; margin: 0 auto; margin-top: 0px; line-height: 23px; color: #FFFFFF; padding-left: 10px; padding-right: 10px;">
				<span class="l" style="height: 23px;">版本2012V1.0</span><span class="r">如有疑问请与技术人员联系？</span>
			</div>
			<!--
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td height="24" background="<%=basePath%>/jsp/web/images/main_47.gif">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td width="29" height="24">
								<img src="<%=basePath%>/jsp/web/images/main_45.gif" width="29" height="24" />
							</td>
							<td>
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td width="369">
											<span class="STYLE1">版本 2011V1.0 </span>
										</td>
										<td width="814" class="STYLE1">
											&nbsp;
										</td>
										<td width="185" nowrap="nowrap" class="STYLE1">
											<div align="center">
												<img src="<%=basePath%>/jsp/web/images/main_51.gif" width="12" height="12" />
												如有疑问请与技术人员联系
											</div>
										</td>
									</tr>
								</table>
							</td>
							<td width="14">
								<img src="<%=basePath%>/jsp/web/images/main_49.gif" width="14" height="24" />
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	-->
	</form>
	</body>
</html> 
