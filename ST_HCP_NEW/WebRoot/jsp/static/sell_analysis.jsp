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
 	%>
<html> 
<title>倾向性分析图</title>

		<script language="javascript" type="text/javascript"
			src="<%=basePath%>/jsp/Market/js/WinOpen.js"></script>
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
 
<BODY topmargin=0 leftmargin=0 rightmargin=0 bottommargin=0>
<center>
<div id=notprint style="background:#ffffff;height:20px;color:#333;padding-left:50px;padding-bottom:3px;font-size:12px;">
			 
	 <div style="float:left;padding-left:20px;color:#666666;padding-top:3px;"></div>
	<div style="float:left;color:#999;padding-top:4px;">
	 
	</div>
</div>
<div id="chartdiv" align="center" style="width:700px;height:380px; border: 1px  solid  red">Charts. </div>
<div id="chartdiv" align="center" style="width:700px; ">
<table style="width: 100%; height: 40px;text-align: center;">
				<colgroup> 
				<col width="20px" />
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
							onclick="javascript:g_OpenModalReturnWindow('<%=basePath %>getMarketInfo_1.action?PKID=10003&userName=刘文娟',826,600);" />
					</td>
					<td style="text-align: center; cursor: hand;">
					 
						<input style="width: 80px; height: auto" type="button" value="刘瑞华 "
							onclick="javascript:g_OpenModalReturnWindow('<%=basePath %>getMarketInfo_1.action?PKID=10005&userName=刘瑞华',826,600);" />
					</td>
					<td style="text-align: center; cursor: hand;">
					 
						<input style="width: 80px; height: auto" type="button" value=" 王胜理"
							onclick="javascript:g_OpenModalReturnWindow('<%=basePath %>getMarketInfo_1.action?PKID=10002&userName=王胜理',826,600);" />
					</td>
					<td style="text-align: center; cursor: hand;">
						 
						<input style="width: 80px; height: auto" type="button" value="张海鑫 "
							onclick="javascript:g_OpenModalReturnWindow('<%=basePath %>getMarketInfo_1.action?PKID=10001&userName=张海鑫',826,600);" />
					</td>
					<td style="text-align: center; cursor: hand;">
					 
						<input style="width: 80px; height: auto" type="button" value="邓  建 "
							onclick="javascript:g_OpenModalReturnWindow('<%=basePath %>getMarketInfo_1.action?PKID=10004&userName=邓    建',826,600);" />
					</td>
					<td style="text-align: center; cursor: hand;">
						 
						<input style="width: 80px; height: auto" type="button" value=" 何文琪"
							onclick="javascript:g_OpenModalReturnWindow('<%=basePath %>getMarketInfo_1.action?PKID=10006&userName=何文琪',826,600);" />
					</td>
					<td></td>
				</tr>
			</table>
			</div>
 <script type="text/javascript">
		 var chart = new FusionCharts("FC/FCF_MSColumn3DLineDY.swf", "ChartId", "700", "380");
		 chart.setDataURL("<%=basePath%>querySell_analysis.action");		 
		 chart.render("chartdiv");
		</script> 
</body>
</html>
