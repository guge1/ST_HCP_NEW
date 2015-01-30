<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html><style> 
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
		 chart.setDataURL("DATE/Column2D_qianli.xml");		 
		 chart.render("chartdiv");
	//window.location.href='xmlreport.asp?id=1&chartToDis='+report_type;
}
</script>
<BODY topmargin=0 leftmargin=0 rightmargin=0 bottommargin=0>
<center>
<div id=notprint style="background:#ffffff;height:20px;color:#333;padding-left:50px;padding-bottom:3px;font-size:12px;">
			 <div style="float:left;padding-top:3px;color:#666666;">统计图类型：</div><div style="float:left;">
										<img title="3D垂直柱型" onclick="changechartToDis('FCF_Column3D')" src="icon/chart_bar.gif" 
							class='current_img' >
							<img title="2D垂直柱型" onclick="changechartToDis('FCF_Column2D')" src="icon/chart_x_bar.gif" 
							class='normal_img' >
							<img title="2D横向柱型" onclick="changechartToDis('FCF_Bar2D')" src="icon/chart_y_bar.gif" 
							class='normal_img' >
							<img title="医院型" onclick="changechartToDis('FCF_Area2D')" src="icon/chart_curve.gif" 
							class='normal_img' >
							<img title="线型" onclick="changechartToDis('FCF_Line')" src="icon/chart_line.gif" 
							class='normal_img' >
							<img title="3D饼形图" onclick="changechartToDis('FCF_Pie3D')" src="icon/chart_y_stack.gif" border="0px"
							class='normal_img' >
							<img title="2D饼形图" onclick="changechartToDis('FCF_Pie2D')" src="icon/chart_y_stack.gif" border="0px"
							class='normal_img' >
							<img title="圆环图" onclick="changechartToDis('FCF_Doughnut2D')" src="icon/chart_y_stack.gif" border="0px"
							class='normal_img' >
				</div>
	 <div style="float:left;padding-left:20px;color:#666666;padding-top:3px;">操作：</div>
	<div style="float:left;color:#999;padding-top:4px;">
	<a href="javascript:window.location.reload();"><img src='../Include/imagesV10/lrefresh.gif' border=0 alt="刷新" title="刷新"></a>
	</div>
</div>
<div id="chartdiv" align="center" style="width:700px;height:380px;">Charts. </div>
 <script type="text/javascript">
		 var chart = new FusionCharts("FC/FCF_Column3D.swf", "ChartId", "700", "380");
		 chart.setDataURL("DATE/Column2D_qianli.xml");		 
		 chart.render("chartdiv");
		</script> 
</body>
</html>
