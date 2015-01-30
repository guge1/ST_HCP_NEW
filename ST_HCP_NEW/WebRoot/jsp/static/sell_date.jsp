<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
response.setHeader("Pragma","No-Cache");
response.setHeader("Cache-Control","No-Cache");
response.setDateHeader("Expires", 0);
	String struserName = request.getParameter("userName") == null ? ""
			: request.getParameter("userName").toString();
		String  strPKID=request.getParameter("PKID")==null?"":request.getParameter("PKID").toString();
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
	<title>销售数据</title>
	<base target="_self" />
	<META HTTP-EQUIV='pragma' CONTENT='no-cache'> 
	<META HTTP-EQUIV='Cache-Control' CONTENT='no-cache, must-revalidate'>
	<META HTTP-EQUIV='expires' CONTENT='0'>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<script language="javascript" type="text/javascript"
		src="<%=basePath%>jsp/Market/js/WinOpen.js">
</script>
	<link href="<%=basePath%>jsp/style_dark/styleform.css" rel="stylesheet"
		type="text/css" />
	<link href="<%=basePath%>jsp/style_dark/StyleSheet.css"
		rel="stylesheet" type="text/css" />
		<script language="Javascript" src="<%=basePath%>jsp/static/FC/FusionCharts.js">
</script>
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
	
	<script id="clientEventHandlersJS" language="javascript">
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
//--></script>
	<body topmargin="0" leftmargin="0" rightmargin="0" bottommargin="0">
		<div id="divPageContent" class="Div_MainContenStyle"
			style="width: 100%; height: 100%;">
			<div id="userdivInfo" align="center"
				style="width: 760px;   display:none;">
				<fieldset class="tdLegendFieldset" >
						<legend class="Legend_Style" style="font-size-16px; font-weight: 16px;"><%=struserName%>销售区
						</legend>
					<table class="myTable" style="width: 100%; height: 38px;">

						<tr style="height: 26px;">
							<td>
								<span style="font-size: 12px; font-weight: bold;">全年的销售达成（单位：万元）：</span><span
									style="font-size: 12px;"><%=request.getAttribute("NTS_ALL")==null?"":request.getAttribute("NTS_ALL").toString() %></span>
							</td>

							<td>
								<span style="font-size: 12px; font-weight: bold;">全年的销售指标达成率：</span><span
									style="font-size: 12px;"><%=request.getAttribute("ACH_ALL")==null?"":request.getAttribute("ACH_ALL").toString() %>%</span>
							</td>

							<td>
								<span style="font-size: 12px; font-weight: bold;">全年的销售净增长额（单位：万元）：
								</span><span style="font-size: 12px;"><%=request.getAttribute("XSZZ_ALL")==null?"":request.getAttribute("XSZZ_ALL").toString() %></span>
							</td>
 
						</tr>
					</table>
				</fieldset>
			</div>
			<div id="chartdiv_qushi" align="center"
				style="width: 760px; height: 380px; border: 1px solid  #FF7D15;">
				医院销售趋势
			</div> 
			<div id="chartdiv_shichang" align="center"
				style="width: 760px; height: 380px; border: 1px solid  #FF7D15；display:none;">
				市场份额（地区）
			</div> 
		</div>
		<script type="text/javascript">

<%if ("".equals(strPKID)) {%>
     
        var chart = new FusionCharts("<%=basePath%>jsp/static/FC/FCF_MSLine.swf", "ChartId", "700", "380");
       // chart.setDataURL("<%=basePath%>queryXiaoShouShuJu.action?FiledName=NTS");
            chart.setDataURL("<%=basePath%>jsp/static/DATE/MSColumn3D_xiaoshou.xml");
        chart.render("chartdiv_qushi");


        var chart_shichang = new FusionCharts("<%=basePath%>jsp/static/FC/FCF_MSLine.swf", "ChartId", "700", "380");
        chart_shichang.setDataURL("<%=basePath%>jsp/static/DATE/MSColumn3D_shichang.xml");
        chart_shichang.render("chartdiv_shichang");
     
     <%} else {%>
     
        var chart = new FusionCharts("<%=basePath%>jsp/static/FC/FCF_MSLine.swf", "ChartId", "700", "380");
        //chart.setDataURL("<%=basePath%>queryXiaoShouShuJu.action?PKID=<%=strPKID%>&?FiledName=NTS");
    
        chart.render("chartdiv_qushi");


        /*var chart_shichang = new FusionCharts("<%=basePath%>jsp/static/FC/FCF_MSLine.swf", "ChartId", "700", "380");
        chart_shichang.setDataURL("<%=basePath%>jsp/static/DATE/MSColumn3D_xiaoshou.xml");
        chart_shichang.render("chartdiv_shichang");*/
        document.getElementById("chartdiv_shichang").style.display="none";
        document.getElementById("userdivInfo").style.display="";
     
     <%}%>
    </script>
	</body>
</html>
