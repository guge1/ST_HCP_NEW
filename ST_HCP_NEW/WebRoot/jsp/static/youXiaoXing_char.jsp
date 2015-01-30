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
%>
<html>
	<head>
		<title>销售有效性分析</title>
<base target="_self">
<%
response.addHeader("Pragma", "no-cache");
response.addHeader("Cache-Control", "no-store");
%>

		<script language="javascript" type="text/javascript"
			src="<%=basePath%>/jsp/Market/js/WinOpen.js"></script>
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
</script>
	<BODY topmargin=0 leftmargin=0 rightmargin=0 bottommargin=0>

		<!--<div id="uploading"
			style="position: absolute;right:20px; top: 90px; z-index: 22; width: 100px; height: 26px; color: Red;">
			aaa
		</div>
		-->
		<div>
			<table>
				<tr>
					<td>

						<div id="chartdiv" align="center"
							style="width: 100%; height: 100%; border: 1px solid  #FF7D15;">
							<iframe    scrolling="no"  src="<%=basePath%>/char/CreateSpiderChart_Mark.action?PKID=<%=strPKID %>"  style="width:820px;height:540px;"  ></iframe> 
						</div>
					</td>

					<td style="display: none;">

						<div id="chartdiv_YouXiaoXIng" align="center"
							style="width: 100%; height: 100%; border: 1px solid  #FF7D15;">


						</div>
					</td>
				</tr>

			</table>
			<%if("".equals(strPKID )){  %>
			<div id="chartdiv" align="center" style="width:700px; ">
<table style="width: 100%; height: 40px;text-align: center;">
				<colgroup> 
				<col width="140px" />
					<col width="110px" />
					<col width="110px" />
					<col width="110px" />
					<col width="110px" />
					<col width="110px" />
					<col width="110px" />
					
				<col width="20px" />
				</colgroup>
				<tr class="tableHead">
					<td>
						&nbsp;&nbsp;
					</td>
					<td style="text-align: center; cursor: hand;">
						<input style="width: 80px; height: auto" type="button" value="刘文娟 "
							onclick="javascript:g_OpenModalReturnWindow('<%=basePath %>jsp/static/youXiaoXing_char.jsp?PKID=10003&userName=刘文娟',826,600);" />
					</td>
					<td style="text-align: center; cursor: hand;">
					 
						<input style="width: 80px; height: auto" type="button" value="刘瑞华 "
							onclick="javascript:g_OpenModalReturnWindow('<%=basePath %>jsp/static/youXiaoXing_char.jsp?PKID=10005&userName=刘瑞华',826,600);" />
					</td>
					<td style="text-align: center; cursor: hand;">
					 
						<input style="width: 80px; height: auto" type="button" value=" 王胜理"
							onclick="javascript:g_OpenModalReturnWindow('<%=basePath %>jsp/static/youXiaoXing_char.jsp?PKID=10002&userName=王胜理',826,600);" />
					</td>
					<td style="text-align: center; cursor: hand;">
						 
						<input style="width: 80px; height: auto" type="button" value="张海鑫 "
							onclick="javascript:g_OpenModalReturnWindow('<%=basePath %>jsp/static/youXiaoXing_char.jsp?PKID=10001&userName=张海鑫',826,600);" />
					</td>
					<td style="text-align: center; cursor: hand;">
					 
						<input style="width: 80px; height: auto" type="button" value="邓  建 "
							onclick="javascript:g_OpenModalReturnWindow('<%=basePath %>jsp/static/youXiaoXing_char.jsp?PKID=10004&userName=邓    建',826,600);" />
					</td>
					<td style="text-align: center; cursor: hand;">
						 
						<input style="width: 80px; height: auto" type="button" value=" 何文琪"
							onclick="javascript:g_OpenModalReturnWindow('<%=basePath %>jsp/static/youXiaoXing_char.jsp?PKID=10006&userName=何文琪',826,600);" />
					</td>
					<td></td>
				</tr>
			</table>
			</div>
			<%} %>
		</div>

		<script type="text/javascript">
 /*var chart = new FusionCharts("FC/FCF_Pie3D.swf", "ChartId", "400", "380");
chart.setDataURL("<%=basePath%>queryXiaoShouJieGuoStatic.action");
chart.render("chartdiv");

var chart_You = new FusionCharts("FC/FCF_Pie3D.swf", "ChartId", "400", "380");
chart_You.setDataURL("<%=basePath%>jsp/static/DATE/Column2D_youXiaoXing.xml");
chart_You.render("chartdiv_YouXiaoXIng"); */
</script>
	</body>
</html>
