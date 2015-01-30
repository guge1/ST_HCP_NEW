<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
	<head id="Head1">
		<title>销售预测</title>
		<base target="_self" />
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
		<script language="javascript" type="text/javascript"
			src="<%=request.getContextPath()%>/jsp/Market/js/WinOpen.js">
</script>
		<script type="text/javascript"
			src="<%=request.getContextPath()%>/jsp/static/FC/FusionCharts.js">
</script>
		<script language="javascript" type="text/javascript"
			src="<%=request.getContextPath()%>/jsp/Market/js/aPublicjs.js">
</script>


		<link
			href="<%=request.getContextPath()%>/jsp/style_dark/styleform.css"
			rel="stylesheet" type="text/css" />
		<link
			href="<%=request.getContextPath()%>/jsp/style_dark/StyleSheet.css"
			rel="stylesheet" type="text/css" />

		<script type="text/javascript">
function save() {
	document.forms[0].action = "<%=request.getContextPath()%>/saveYue_YuCe.action";
	document.forms[0].submit();

}
</script>
		<style type="text/css">
.tbDragTable  tr {
	height: 30px;
}
</style>
	</head>
	<body style="margin-top: 0; padding-top: 0;">
		<form name="form1" method="post" id="form1">

			<div
				style="width: 100%; height: expression(document.body.clientHeight);overflow: auto;">

				<table style="width: 100%;">
					<tr>
						<td>

							<fieldset class="tdLegendFieldset" style="">
								<legend class="Legend_Style">
									资源分配
								</legend>
								<table>
									<tr>
										 
										<td style="width: 800px;">
											<!--<img alt="" src="xiaoshouyuce.bmp" width="600px">
											-->
											<div id="chartdiv_qushi" align="center"
												style="width: 600px; height: 340px; border: 1px solid  #FF7D15; background-color: #F7F3F7;">
												销售预测
											</div>
										</td>
									</tr>
								</table>
							</fieldset>
						</td>
					</tr>
					 
				</table>

			</div>
		</form>
	</body>
</html>
<script type="text/javascript">
function loadData() {
	var chart = new FusionCharts( "<%=request.getContextPath()%>/jsp/static/FC/FCF_MSLine.swf", "ChartId", "600", "320");
	chart.setDataURL("<%=request.getContextPath()%>/jsp/static/DATE/yue_yuce.xml");
	chart.render("chartdiv_qushi");
}
	var chart = new FusionCharts( "<%=request.getContextPath()%>/jsp/static/FC/FCF_MSLine.swf", "ChartId", "600", "320");
	chart.render("chartdiv_qushi");
</script>

<script type="text/javascript">


function  setPageVsOne(objName)
{
 
 var  resultVs=0;
  //document.getElementById(objName+"YJ").innerHTML="";
  <%
  String  quYuDaiBiao=  request.getAttribute("quYuDaiBiao")==null?"":  request.getAttribute("quYuDaiBiao").toString();
  String  quYuDaiBiaos[]=   quYuDaiBiao.split(",");
	for (int i = 0; i < quYuDaiBiaos.length; i++) 
	{
  	  String strID = quYuDaiBiaos[i];
  	  if(strID!="")
  	  { 
  	%>
  	var vs= document.getElementsByName(objName+<%=strID%>)[0].value ;
  	 if(vs==""||vs=="NaN"||vs==null||vs==NaN)
  	 { 
  	   vs=0;
  	 }
  	 
      resultVs= resultVs+	parseInt(vs);
  	
  	<%
  	  }
  	}
  %>
 
  document.getElementById("all"+objName).value=resultVs; 
}

 
			 // setPageVsOne('XSYC');
			  setPageVsOne('NTS');
 

</script>