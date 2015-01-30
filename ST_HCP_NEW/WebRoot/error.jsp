<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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

<%@ taglib uri="/tags/web-sys" prefix="sys"%> 
<html>
  <head>
    <title>error</title>
<link rel="stylesheet" type="text/css" href="<sys:ui css='skin.css'/>">
<script language="javascript" src="<sys:ui js='calendar.js'/>"></script>
<script language="javascript" src="<sys:ui js='sotowerfunction.js'/>"></script>
  </head>
  
  <body>
    This is Error page. <br>
    <img src="<%=basePath %>/jCuckoo/pieChartAction.action">
    
  </body>
</html>
