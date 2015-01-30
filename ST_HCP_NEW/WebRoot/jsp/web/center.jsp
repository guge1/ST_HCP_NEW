
<%@ page contentType="text/html; charset=GBK"%>
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
<html   >
	<head>

		<title>TPS区域管理实战模拟系统</title>
		<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	overflow: hidden;
}
-->
</style>
	</head>

	 <body style="margin-right:0px;padding:0px;width:100%;">
	
	
	 
	 <div style="text-align:center;width:100%;background:#FFFFFF;">
	<div
				style="width:981px;height: expression(document.body.clientHeight);overflow: auto;
				margin:auto;text-align:center;">
	
		<table width="981px" height="100%" border="0" cellpadding="0"
			cellspacing="0" style="table-layout: fixed">
			<tr><!--
			background="<%=basePath%>jsp/web/images/main_40.gif"
				--><td  style="width: 3px;border-right: solid 1px #F8B03A;">
					&nbsp;
				</td>
				<td width="177" style="border-right: solid 1px #F8B03A;">
					<iframe name="mainFrame_left" height="100%" width="177" border="0"
						frameborder="0" src="<%=basePath%>queryLeft.action"
						style="overflow: auto; overflow-x: hidden; overflow-y: visible;"
						scrolling="no">
						浏览器不支持嵌入式框架，或被配置为不显示嵌入式框架。
					</iframe>
				</td>
				<td>
					<iframe name="rightFrame" src="<%=basePath%>queryZongTi_FenXi.action" height="100%"
						width="100%" border="0" frameborder="0" scrolling="no">
						浏览器不支持嵌入式框架，或被配置为不显示嵌入式框架。
					</iframe>
				</td>
				<td    style="width: 1px;background:#F8B03A">
					&nbsp;
				</td>
			</tr>
		</table>
		</div>
		</div>
		</body>
	 </html>
