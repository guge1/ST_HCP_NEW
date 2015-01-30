<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
 
 <%@page import="nMarket.vo.Users"  %> 

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
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

		<title>医院管理实战模拟系统</title>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
		<base href="<%=basePath%>jsp/web/top.jsp"/>
		<meta http-equiv="pragma" content="no-cache"/>
		<meta http-equiv="cache-control" content="no-cache"/>
		<meta http-equiv="expires" content="0"/>
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3"/>
		<meta http-equiv="description" content="This is my page"/>
		<link href="<%=basePath%>jsp/style_dark/topTab.css" rel="stylesheet"
			type="text/css" />
		 
<link rel="stylesheet" href="<%=basePath%>skins/yellow/css/style.css" type="text/css"></link>
		<script language="javascript">
function setUrl(url) {
	window.parent.document.getElementById("mainFrame").src = url;
}
function loginOut(url) {
	if (!confirm("确实要退出系统吗？"))
		{return;}
	window.parent.document.location.href = url;
}
function switchTag(tag, url) {

			setUrl(url);
			return;
	 
} 
</script>

	</head>
	<body style="margin-right:0px;padding:0px;width:100%;" >

	 <div style="text-align:center;width:100%;background:#FFFFFF;">
    <div style="margin:0px auto;width:981px;text-align:center;background:#FFFFFF;">
		<div class="header">
			<p>
				医院管理 情景模拟实战系统
			</p>
			<a href=""><img src="<%=basePath%>skins/yellow/images/logo.jpg" />
			</a>
		</div>

		<div class="content">
			<div class="article2"   >
				<div class="button" id="contentDiv">
						<a class="selectli1 menu_click"
							onclick="switchTag('tag1','<%=basePath%>jsp/web/tab/body.jsp');Topclick('contentDiv','menu_td' ,this )"
							href="#">代表现状信息
						</a>

						<a  class="selectli1 menu_td"
							onclick="switchTag('tag2','<%=basePath%>getMarketInfo_Body.action');Topclick('contentDiv','menu_td' ,this )"
							href="#">覆盖医生描述 </a>

						<a class="selectli1 menu_td"
							onclick="switchTag('tag3','<%=basePath%>jsp/web/center.jsp');Topclick('contentDiv','menu_td' ,this )"
							href="#">医院行动计划</a>
					</div>

			</div>
			<div class="time">
				<p>
					<span id="span3" class="STYLE1" style="color: Red">时间：
												</span><span class="STYLE1" id="Span2">2011年10月9日 星期一  21:54:04
													</span><span class="STYLE1" id="Span3"  >&nbsp;<a href="javasCript:void(0);"
									onclick="setUrl('<%=basePath%>queryCase.action')">【系统设置】</a>&nbsp;
								</span>
								  <%
								  Users user =(Users) session.getAttribute("userInfo");
								  String   userid= request.getAttribute("userid")==null?"": request.getAttribute("userid").toString();
								  String   usertype= request.getAttribute("usertype")==null?"": request.getAttribute("usertype").toString();
								  
				  if("1".equals(user.getUsertype()+"")||"10001".equals(user.getId()+""))
				  {//管理员
				      %> 
								<span class="STYLE1" id="Span3"  >&nbsp;<a href="javasCript:void(0);"
									onclick="setUrl('<%=basePath%>jsp/static/userStatic.jsp')">【统计报表】</a>&nbsp;
								</span>
								<%} %>
								<span class="STYLE1" id="Span3"  >&nbsp;<a href="#"
									onclick="loginOut('<%=basePath%>userExit.action')">【退出】</a>&nbsp;
								</span>
				</p>
			</div>
		</div>
		
    </div>
		
    </div>
		   
		
		<script type="text/javascript">
		    setInterval("document.getElementById('Span2').innerHTML=new Date().toLocaleString()",1000);
		</script>
	</body>
</html>
 <script type="text/javascript">
 
 function setTopStyle(tableID,tdDefault,tdOnover,tdOnclick ){
 
         var tds= document.getElementById(tableID).getElementsByTagName("a");
	   	  for(var j=0;j<tds.length;j++)
	   	  { 
	   		  
		   		tds[j].onmouseover=function(){
		            if(this.className!=tdOnclick)this.className=tdOnover;
		         }
		   		tds[j].onmouseout=function(){
			   		 
		            if(this.className!=tdOnclick)this.className=tdDefault;
		         }
		   		tds[j].style.cursor="hand";
		   		 
		   		   
	   	  } 
 }
 function Topclick(tableID,tdDefault ,obj ){
 
         var tds= document.getElementById(tableID).getElementsByTagName("a");
	   	  for(var j=0;j<tds.length;j++)
	   	  { 
	   		  
		   	 
		   	 tds[j].className=tdDefault;
		   	 
		   		   
	   	  } 
	   	  obj.className="menu_click";
 }
 setTopStyle("contentDiv","menu_td","menu_selected","menu_click");
 
</script>
