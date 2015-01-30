
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
<html>
	<head>

		<title>医药代表业务计划与战术管理</title>
		<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
		<base target="_self">
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">

	</head>
 
		 
			<frameset rows="91,*,24" cols="*" framespacing="0" frameborder="no"
				  border="0">
				<frame src="<%=basePath%>jsp/web/top.jsp" name="topFrame" scrolling="no"
					noresize="noresize" id="topFrame" />
				<frame src="<%=basePath%>jsp/web/tab/body.jsp" name="mainFrame" id="mainFrame"
					scrolling="no" />
				<frame src="<%=basePath%>jsp/web/down.jsp" id="bottomFrame" name="bottomFrame" scrolling="no"
					noresize="noresize" id="bottomFrame" />
			</frameset>
			<noframes>
				<body>
					此浏览器不支持
				</body>
			</noframes>
	 

	<body>	</body>
</html>
