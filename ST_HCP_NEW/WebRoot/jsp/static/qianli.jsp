<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
		 
		String  struserName=request.getParameter("userName")==null?"":request.getParameter("userName").toString();
		String  strPKID=request.getParameter("PKID")==null?"":request.getParameter("PKID").toString();
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
		
		
	 	String strType =  request.getParameter("type")==null?"":request.getParameter("type") .toString() ;
	 	String strTitle="潜力",strFiledName="HZGM";
		if( "xsgn".equals(strType))
		{
			strTitle="处方观念";
			strFiledName="XSGN";
		}
		if( "qxx".equals(strType))
		{
			strTitle="倾向性";
			strFiledName="QXX";
		}
		
 	%>
<html> 
<head>
<title><%=strTitle %>分析图</title>

</head>
<style> 
 .normal_img{
 border:0;
 cursor:hand;
 padding-left:2px;
 position:relative;
 filter:alpha(opacity=30);
 }
 .current_img{
 border:0;
 cursor:hand;
 position:relative;
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
function changechartToDis(report_type){
 var chart = new FusionCharts("FC/"+report_type+".swf", "ChartId", "700", "380");
		 chart.setDataURL("date/Column2D.xml");		 
		 chart.render("chartdiv");
	//window.location.href='xmlreport.asp?id=1&chartToDis='+report_type;
}
</script>
<BODY topmargin=0 leftmargin=0 rightmargin=0 bottommargin=0>
<div id=notprint style="background:#ffffff;height:20px;color:#333;padding-left:50px;padding-bottom:3px;font-size:12px;">
</div>
<div id="chartdiv" align="center" style="width:700px;height:380px;border: 1px  solid  red;">Charts. </div>
 <script type="text/javascript">
		 var chart = new FusionCharts("<%=basePath%>jsp/static/FC/FCF_Column3D.swf", "ChartId", "700", "380");
		 chart.setDataURL("<%=basePath%>queryQianLiStatic.action?type=<%=strType%>");		 
		 chart.render("chartdiv");
		</script> 
</body>
</html>
