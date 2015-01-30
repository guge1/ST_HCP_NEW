<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String strPrjName = "/ST_HCP_NEW";
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName();
	if (!"".equals(request.getServerPort())) {
		basePath += ":" + request.getServerPort();
	}
	if (strPrjName.equals(path)) {
		basePath += path + "/";
	} else {
		basePath += "/";
	}
%>
<html>
	<head>
		<base target="_self" />
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />

		<style type="text/css">
.myDiv{
 cursor:hand; display:block;height:51px; background:url(anniu.jpg) no-repeat left top; line-height:32px; padding-left:10px; text-decoration:none; letter-spacing:2px;
  
 }
 
.myDiv span{
text-align: center;
 display:block;height:51px;line-height:51px; background:url(anniu2.jpg) no-repeat right top; padding-right:1px;color:#000000;font-size:14px;font-weight:bold;
 }
</style>
	</head>
	<body style="margin: 0px; padding: 0px; width: 100%;">

		<div style="text-align: center; width: 100%; background: #FFFFFF;">
		 
<div  style="border:1px solid #F8C069;padding:auto;margin:0px auto;width:981px;text-align:center;height: expression(document.body.clientHeight);overflow: auto;overflow-x:hidden;margin:auto;">
<br/>
<br/>
<table border="0" style="width:720px" align="center">
	<colgroup>
	<col width="360px" />
	<col width="360px" />
	</colgroup>
 
	<tr>
		<td>
		    <div class="myDiv"  onclick="action('<%=basePath%>queryDclStatic.action')" ><span>表一：各轮达成率</span></div>
		 </td> 
	
	
		<td>
		    <div class="myDiv"  onclick="action('<%=basePath%>queryOrderStatic.action')" ><span>表二：客户优先顺序排序</span></div>
		 </td>
		
		 
		 </tr>
 
	<tr style="padding-top: 10px;">
		<td>
		    <div class="myDiv"  onclick="action('<%=basePath%>queryYouStatic.action')" ><span>表三：优先顺序前6名的客户资源分配及达成</span></div>
		 </td>
		<td>
		    <div class="myDiv"  onclick="action('<%=basePath%>querySingleStatic.action')" ><span>表四：单个客户资源分配分析（数量）</span></div>
		 </td>
		 
		 </tr>
	
</table>

 
				 </div>
				 </div>
				 
	</body>
	<script type="text/javascript">
	</script>
	<script type="text/javascript">

function action(url){
	 
	window.location.href=url;
}
</script>
</html>

