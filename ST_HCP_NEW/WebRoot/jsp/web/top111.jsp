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

		<title>医药代表业务计划与战术管理</title>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
		<base href="<%=basePath%>jsp/web/top.jsp">
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link href="<%=basePath%>jsp/style_dark/topTab.css" rel="stylesheet"
			type="text/css" />
		<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}

.STYLE1 {
	color: #43860c;
	font-size: 12px;
}
-->
</style>



		<style type="text/css">
<!--
* {
	margin: 0;
	padding: 0
}

body {
	
}
-->
</style>
		<script language="javascript">
function setUrl(url) {
	window.parent.document.getElementById("mainFrame").src = url;
}
function loginOut(url) {
	if (!confirm("确实要退出系统吗？"))
		return;
	window.parent.document.location.href = url;
}
function switchTag(tag, url) {
	for (i = 1; i < 4; i++) {
		if ("tag" + i == tag) {
			document.getElementById(tag).getElementsByTagName("a")[0].className = "selectli"
					+ i;
			document.getElementById(tag).getElementsByTagName("a")[0]
					.getElementsByTagName("span")[0].className = "selectspan"
					+ i;
			setUrl(url);
		} else {
			document.getElementById("tag" + i).getElementsByTagName("a")[0].className = "";
			document.getElementById("tag" + i).getElementsByTagName("a")[0]
					.getElementsByTagName("span")[0].className = "";
		}
		/*	if ("content" + i == content) {
				 document.getElementById(content).className = "";
			} else {
				 document.getElementById("content" + i).className = "hidecontent";
			}*/
		//document.getElementById("content").className = content;
	}
}
var thisURL = document.URL;
var thisHREF = document.location.href;
</script>

	</head>
	<body>
		<table width="100%" border="0" cellspacing="0" cellpadding="0"
			style="table-layout: fixed; height: 91px;">
			<tr>
				<td height="91" style="line-height: 91px;">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td width="597" height="91" background="images/top.gif">
								&nbsp;
							</td>
							<td height="91" background="images/top_right.gif" valign="bottom"
								width="">
								&nbsp;
							</td>
							<td height="91" background="images/top_right.gif" valign="bottom"
								style="width: 421px;">

								<table>
									<tr>
										<td valign="top" colspan="2">
											<div
												style="float: right; text-align: right; _position: 1absolute; right: 8px; top: 1px; z-index: 200; margin-right: 0px; padding-right: 0px; 
												width: 412px; color: Red;">
												 <span id="span3" class="STYLE1" style="color: Red">时间：
												</span><span class="STYLE1" id="Span2">2011年10月9日 21:54:04
													星期日</span><span class="STYLE1" id="Span3"  >&nbsp;<a href="javasCript:void(0);"
									onclick="setUrl('<%=basePath%>queryCase.action')">【系统设置】</a>&nbsp;
								</span><span class="STYLE1" id="Span3"  >&nbsp;<a href="#"
									onclick="loginOut('<%=basePath%>userExit.action')">【退出】</a>&nbsp;
								</span>
											</div>
											<script type="text/javascript">
											setInterval(
													"document.getElementById('Span2').innerHTML=new Date().toLocaleString()+' 星期'+'日一二三四五六'.charAt(new Date().getDay());",
													1000);
											</script>

										</td>
									</tr>
									<tr>
									<td  style="width: 40px;"></td>
										<td style="width: 381px;">
											<div id="container">
												<div id="title">
													<ul>
														<li id="tag1">
															<a class="selectli1"
																onclick="switchTag('tag1','<%=basePath%>jsp/web/tab/body.jsp');this.blur();"
																href="#"><span class="selectspan1"
																stle="width:100%;">代表现状信息</span> </a>
														</li>
														<li id="tag2">
															<a
																onclick="switchTag('tag2','<%=basePath%>getMarketInfo_Body.action');this.blur();"
																href="#"><span stle="width:100%;">覆盖医生描述</span> </a>
														</li>
														<li id="tag3">
															<a
																onclick="switchTag('tag3','<%=basePath%>jsp/web/center.jsp');this.blur();"
																href="#"><span stle="width:100%;">医院行动计划</span> </a>
														</li>
													</ul>
												</div>
											</div>
										</td>
									</tr>

								</table>
							</td> 
						</tr>
					</table>
				</td>
			</tr>
		</table>
		<map name="Map" id="Map">
			<area shape="rect" coords="3,1,49,22" href="#" />
			<area shape="rect" coords="52,2,95,21" href="#" />
			<area shape="rect" coords="102,2,144,21" href="#" />
			<area shape="rect" coords="150,1,197,22" href="#" />
			<area shape="rect" coords="210,2,304,20" href="#" />
			<area shape="rect" coords="314,1,361,23" href="#" />
		</map>
	</body>
</html>

