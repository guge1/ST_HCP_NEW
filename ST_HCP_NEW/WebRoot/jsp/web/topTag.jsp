<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<html>
	<head>
		<title>网页选项卡</title>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
		<style type="text/css">
<!--
* {
	margin: 0;
	padding: 0
}

body {
	margin-top: 10px;
	margin-right: auto;
	margin-bottom: 10px;
	margin-left: auto;
	text-align: center;
	height: auto;
	width: auto;
	background-color: #666666;
	font-size: 12px;
	color: #000000;
}

#container {
	text-align: left;
	width: 760px;
	height: 400px;
	background-color: #FFFFFF;
	padding: 20px;
}

#container #title {
	height: 28px;
}

#container #title li {
	float: left;
	list-style-type: none;
	height: 28px;
	line-height: 28px;
	text-align: center;
	margin-right: 1px;
}

#container #title ul {
	background-color: #FFFFFF;
	height: 28px;
}

#container #title a {
	text-decoration: none;
	color: #000000;
	display: block;
	width: auto;
	background: url(tab/images/left_bk2.gif) no-repeat left -29px;
}

#container #title a span {
	display: block;
	background: url(tab/images/right_bk2.gif) no-repeat right -29px;
	padding: 0 15px 0 15px;
}

#container #title #tag1 a:hover {
	text-decoration: none;
	color: #ffffff;
	display: block;
	width: auto;
	background: url(tab/images/left_bk2.gif) no-repeat left -87px;
}

#container #title #tag1 a:hover span {
	display: block;
	background: url(tab/images/right_bk2.gif) no-repeat right -87px;
	padding: 0 15px 0 15px;
}

#container #title #tag2 a:hover {
	text-decoration: none;
	color: #ffffff;
	display: block;
	width: auto;
	background: url(tab/images/left_bk2.gif) no-repeat left 0px;
}

#container #title #tag2 a:hover span {
	display: block;
	background: url(tab/images/right_bk2.gif) no-repeat right 0px;
	padding: 0 15px 0 15px;
}

#container #title #tag3 a:hover {
	text-decoration: none;
	color: #ffffff;
	display: block;
	width: auto;
	background: url(tab/images/left_bk2.gif) no-repeat left -58px;
}

#container #title #tag3 a:hover span {
	display: block;
	background: url(tab/images/right_bk2.gif) no-repeat right -58px;
	padding: 0 15px 0 15px;
}

#container #title #tag4 a:hover {
	text-decoration: none;
	color: #ffffff;
	display: block;
	width: auto;
	background: url(tab/images/left_bk2.gif) no-repeat left -145px;
}

#container #title #tag4 a:hover span {
	display: block;
	background: url(tab/images/right_bk2.gif) no-repeat right -145px;
	padding: 0 15px 0 15px;
}

#container #title #tag5 a:hover {
	text-decoration: none;
	color: #ffffff;
	display: block;
	width: auto;
	background: url(tab/images/left_bk2.gif) no-repeat left -174px;
}

#container #title #tag5 a:hover span {
	display: block;
	background: url(tab/images/right_bk2.gif) no-repeat right -174px;
	padding: 0 15px 0 15px;
}

#container #title .selectli1 {
	text-decoration: none;
	color: #ffffff;
	display: block;
	width: auto;
	background: url(tab/images/left_bk2.gif) no-repeat left -87px;
}

#container #title a .selectspan1 {
	display: block;
	background: url(tab/images/right_bk2.gif) no-repeat right -87px;
	padding: 0 15px 0 15px;
}

#container #title .selectli2 {
	text-decoration: none;
	color: #ffffff;
	display: block;
	width: auto;
	background: url(tab/images/left_bk2.gif) no-repeat left 0px;
}

#container #title a .selectspan2 {
	display: block;
	background: url(tab/images/right_bk2.gif) no-repeat right 0px;
	padding: 0 15px 0 15px;
}

#container #title .selectli3 {
	text-decoration: none;
	color: #ffffff;
	display: block;
	width: auto;
	background: url(tab/images/left_bk2.gif) no-repeat left -58px;
}

#container #title a .selectspan3 {
	display: block;
	background: url(tab/images/right_bk2.gif) no-repeat right -58px;
	padding: 0 15px 0 15px;
}

#container #title .selectli4 {
	text-decoration: none;
	color: #ffffff;
	display: block;
	width: auto;
	background: url(tab/images/left_bk2.gif) no-repeat left -145px;
}

#container #title a .selectspan4 {
	display: block;
	background: url(tab/images/right_bk2.gif) no-repeat right -145px;
	padding: 0 15px 0 15px;
}

#container #title .selectli5 {
	text-decoration: none;
	color: #ffffff;
	display: block;
	width: auto;
	background: url(tab/images/left_bk2.gif) no-repeat left -174px;
}

#container #title a .selectspan5 {
	display: block;
	background: url(tab/images/right_bk2.gif) no-repeat right -174px;
	padding: 0 15px 0 15px;
}

#container #content ul {
	margin: 10px;
}

#container #content li {
	margin: 5px;
}

#container #content li img {
	margin: 5px;
	display: block;
}

#container #content {
	height: 300px;
	padding: 10px;
}

.content1 {
	border-top-width: 3px;
	border-right-width: 1px;
	border-bottom-width: 1px;
	border-left-width: 1px;
	border-top-style: solid;
	border-right-style: solid;
	border-bottom-style: solid;
	border-left-style: solid;
	border-top-color: #3A81C8;
	border-right-color: #3A81C8;
	border-bottom-color: #3A81C8;
	border-left-color: #3A81C8;
	background-color: #DFEBF7;
}

.content2 {
	border-top-width: 3px;
	border-right-width: 1px;
	border-bottom-width: 1px;
	border-left-width: 1px;
	border-top-style: solid;
	border-right-style: solid;
	border-bottom-style: solid;
	border-left-style: solid;
	border-top-color: #ff950b;
	border-right-color: #ff950b;
	border-bottom-color: #ff950b;
	border-left-color: #ff950b;
	background-color: #FFECD2;
}

.content3 {
	height: 300px;
	padding: 10px;
	border-top-width: 3px;
	border-right-width: 1px;
	border-bottom-width: 1px;
	border-left-width: 1px;
	border-top-style: solid;
	border-right-style: solid;
	border-bottom-style: solid;
	border-left-style: solid;
	border-top-color: #FE74B8;
	border-right-color: #FE74B8;
	border-bottom-color: #FE74B8;
	border-left-color: #FE74B8;
	background-color: #FFECF5;
}

.content4 {
	height: 300px;
	padding: 10px;
	border-top-width: 3px;
	border-right-width: 1px;
	border-bottom-width: 1px;
	border-left-width: 1px;
	border-top-style: solid;
	border-right-style: solid;
	border-bottom-style: solid;
	border-left-style: solid;
	border-top-color: #00988B;
	border-right-color: #00988B;
	border-bottom-color: #00988B;
	border-left-color: #00988B;
	background-color: #E8FFFD;
}

.content5 {
	height: 300px;
	padding: 10px;
	border-top-width: 3px;
	border-right-width: 1px;
	border-bottom-width: 1px;
	border-left-width: 1px;
	border-top-style: solid;
	border-right-style: solid;
	border-bottom-style: solid;
	border-left-style: solid;
	border-top-color: #A8BC1F;
	border-right-color: #A8BC1F;
	border-bottom-color: #A8BC1F;
	border-left-color: #A8BC1F;
	background-color: #F7FAE2;
}

.hidecontent {
	display: none;
}
-->
</style>
		<script language="javascript">
function switchTag(tag, content) {
	for (i = 1; i < 6; i++) {
		if ("tag" + i == tag) {
			document.getElementById(tag).getElementsByTagName("a")[0].className = "selectli"
					+ i;
			document.getElementById(tag).getElementsByTagName("a")[0]
					.getElementsByTagName("span")

			[0].className = "selectspan" + i;
		} else {
			document.getElementById("tag" + i).getElementsByTagName("a")[0].className = "";
			document.getElementById("tag" + i).getElementsByTagName("a")[0]
					.getElementsByTagName("span")

			[0].className = "";
		}
		if ("content" + i == content) {
			document.getElementById(content).className = "";
		} else {
			document.getElementById("content" + i).className = "hidecontent";
		}
		document.getElementById("content").className = content;
	}
}
</script>
	</head>
	<body>
		<div id="container">
			<div id="title">
				<ul>
					<li id="tag1">
						<a class="selectli1"
							onclick="switchTag('tag1','content1');this.blur();" href="/"><span
							class="selectspan1">代表现状信息</span>
						</a>
					</li>
					<li id="tag2">
						<a onclick="switchTag('tag2','content2');this.blur();" href="#"><span>
								医生介绍描述</span>
						</a>
					</li>
					<li id="tag3">
						<a onclick="switchTag('tag3','content3');this.blur();" href="#"><span>
								医院业务计划</span>
						</a>
					</li>
				</ul>
			</div>
			<div class="content1" id="content">
				<div id="content1">
					<p>
				</div>
				<div class="hidecontent" id="content2">
					2、高质量源代码下载。
				</div>
				<div class="hidecontent" id="content3">
					3、源码爱好者每一个都是精品，全心全意服务大家，哈哦！
				</div>

			</div>
		</div>
	</body>
</html>
