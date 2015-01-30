<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String struserName = request.getParameter("userName") == null ? ""
			: request.getParameter("userName").toString();
	String strPKID = request.getParameter("PKID") == null ? ""
			: request.getParameter("PKID").toString();
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
	//清除登陆页面缓存
response.setHeader("Pragma","No-cache"); 
response.setHeader("Cache-Control","no-cache");
response.setHeader("Cache-Control", "no-store");
response.setDateHeader("Expires", 0);
%>
<html>
	<head>
		<title>总体分析</title>
<base target="_self" />	
       <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
       <META HTTP-EQUIV="Pragma" CONTENT="no-cache">
       <META HTTP-EQUIV="Expires" CONTENT="-1">

	   <meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">    
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
		<script language="javascript" type="text/javascript"
			src="<%=request.getContextPath()%>/jsp/Market/js/aPublicjs.js">
</script>
	</head>
	<style>
.normal_img {
	border: 0;
	cursor: hand;
	padding-left: 2px;
	position: relative;
	filter: alpha(opacity =   30);
}

.current_img {
	border: 0;
	cursor: hand;
	position: relative;
}
</style>
	<SCRIPT LANGUAGE="Javascript" SRC="FC/FusionCharts.js"></SCRIPT>
	<SCRIPT ID=clientEventHandlersJS LANGUAGE=javascript>
<!--
 function PrintPage() {
		TotalHTML = window.document.body.outerHTML;
		window.document.body.innerHTML = bodyview.innerHTML;
		myChart_myDiv();
		alert("请在数据加载完成后点击确定")
		window.print();
		window.document.body.innerHTML = TotalHTML;
		myChart_myDiv();
 }
//--></SCRIPT>
	<script type="text/javascript">
function changechartToDis(report_type) {
	var chart = new FusionCharts("FC/" + report_type + ".swf", "ChartId",
			"700", "380");
	chart.setDataURL("date/Column2D.xml");
	chart.render("chartdiv");
	//window.location.href='xmlreport.asp?id=1&chartToDis='+report_type;
}
</script><script type="text/javascript">
function save() {
	document.forms[0].action = "<%=basePath%>saveZonti_FenXi_Tu.action";
	document.forms[0].submit();

}
</script>
	<BODY topmargin=0 leftmargin=0 rightmargin=0 bottommargin=0>

                   <form name="form1" method="post" action="" id="form1">
		<!--<div id="uploading"
			style="position: absolute;right:20px; top: 90px; z-index: 22; width: 100px; height: 26px; color: Red;">
			aaa
		</div>
		-->
		
	 <div id="chartdiv" align="center"
							style="width: 100%; height: auto; border: 1px solid  #FF7D15;">
			<table>
				<tr>
					<td style="width: 720px;margin-left:0px;padding-left:0px;">
                      <iframe    scrolling="no"  src="<%=basePath%>char/PaoPaoChart.action"  style="width:720px;height:720px;"  ></iframe> 
					</td>
                   <td style="width: 120px">
	                   <table style="width: 100%">
	                   <%=request.getAttribute("filedHtml")==null?"":request.getAttribute("filedHtml")%>
	                   </table>
                   </td>
					<td style="display: none;">

						<div id="chartdiv_YouXiaoXIng" align="center"
							style="width: 100%; height: 100%; border: 1px solid  #FF7D15;">


						</div>
					</td>
				</tr>

			</table>

		</div>

		<script type="text/javascript">
 /*var chart = new FusionCharts("FC/FCF_Pie3D.swf", "ChartId", "400", "380");
chart.setDataURL("<%=basePath%>queryXiaoShouJieGuoStatic.action");
chart.render("chartdiv");

var chart_You = new FusionCharts("FC/FCF_Pie3D.swf", "ChartId", "400", "380");
chart_You.setDataURL("<%=basePath%>jsp/static/DATE/Column2D_youXiaoXing.xml");
chart_You.render("chartdiv_YouXiaoXIng"); */
</script>
      </form>
	</body>
</html>
