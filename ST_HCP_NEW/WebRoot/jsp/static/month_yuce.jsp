<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<jsp:useBean id="Source" scope="page"
	class="system.dao.Impl.PublicSourceDAO" />
<html>
	<title>预测对照</title>
	<head>
		<base target="_self" />
		<%

  Integer CASESAVE=  request.getAttribute("CASESAVE")==null?0:Integer.parseInt(  request.getAttribute("CASESAVE").toString() );
  //CASESAVE=7;
 %>
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
			href="<%=request.getContextPath()%>/jsp/style_dark/StyleSheet.css"
			rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/skins/yellow2/css/style.css" type="text/css"></link>

		<script type="text/javascript">
function save() {
if(confirm("确定要保存当前数据吗？保存后不能修改！"))
	          {
	document.forms[0].action = "<%=request.getContextPath()%>/saveMonth_YuCe.action";
	document.forms[0].submit();

}
}
</script>
		<style>
.normal_img {
	border: 0;
	cursor: hand;
	padding-left: 2px;
	position: relative;
	filter: alpha(opacity =         30);
}

.current_img {
	border: 0;
	cursor: hand;
	position: relative;
}
</style>
		<script language="Javascript" src="FC/FusionCharts.js">
</script>
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
 
	</head>
	<body topmargin="0" leftmargin="0" rightmargin="0" bottommargin="0">
	<form action="" id="form1" method="post">
		<div class="Btntoolbar">
			<table style="width: 100%;">
				<tr>
					<td>
					</td>
				</tr>
				<tr>
					<td style="width: 100%;">
						<div
							style="float: left; text-align: left; margin-left: 0px; padding-left: 0px;">
							&nbsp;&nbsp;预测对照
						</div>
						<div
							style="float: right; text-align: right; _position: absolute; right: 4px; top: 6px; z-index: 20; margin-right: 0px; padding-right: 0px; width: 240px;">

							 <% if(CASESAVE>7){ %>
                       	<input  class="pt_Long_button" type="button" value="下一步"
													onclick="window.location.href='<%=request.getContextPath()%>/queryXingDong_JiHua.action'">
                       <%}else{ %>
							<input type="button" value="保存并提交下一步" onclick="save();"
								id="Submit1" style="display: ;"   class="pt_vLong_button"/>
								<%} %>
						</div>
					</td>
				</tr>
			</table>
		</div>
		<div id="divPageContent"
			
			class="Div_MainContenStyle" style="width: 800px; text-align: center; background-color: #F7F3F7;overflow:auto;">
			<div id="notprint"
				style="background-color: #F7F3F7;   color: #333; padding-bottom: 3px; font-size: 12px;">

				<div
					style="color: #666666; background-color: #F7F3F7; width: 100%; padding-top: 3px; font-size: 12px; text-aglin: center;"
					align="center">
					<fieldset class="tdLegendFieldset">
						<legend class="Legend_Style">
							销售结果：
						</legend>
						<table border="0" cellpadding="0" cellspacing="0"
							style="font-size: 12px;width:100%">
							<tr>
								<td style="width: 1180px">
									<table border="0" cellpadding="0" cellspacing="0"
										style="font-size: 12px;width:100%;"  id="contentTable" > 
										<%=request.getAttribute("filedHtml")%>
									</table>
								</td>
								<td width="120px">
										<table  border="0" cellpadding="0" cellspacing="0"
										style="font-size: 12px;width:120px;margin-top:12px;"  >
											<tr>
												<td>
													总计&nbsp;&nbsp;
													<div style="display: none;">
														医院销售达成率
													</div>
												</td>
											</tr>
											<tr>
												<td>
													<input style="width: 90px" value="" id="allCountCOMPANYKPI"
														readonly="readonly" style="background-color: #C3CCDB" />
													&nbsp;&nbsp;
													<div style="display: none;">
														<input style="width: 50px; display: none;"
															id="allCOMPANYKPI" value="10" readonly="readonly"
															style="background-color: #C3CCDB" ;"/>
														%
													</div>
												</td>
											</tr>
											<tr>
												<td>
													<input style="width: 90px" value="" id="allCountXSYC"
														readonly="readonly" style="background-color: #C3CCDB" />
													&nbsp;&nbsp;
													<div style="display: none;">
														<input
															style="width: 50px; display: none; background-color: #C3CCDB"
															id="allXSYC" value="10" readonly="readonly" />
														%
													</div>
												</td>
											</tr>
											<tr>
												<td>
													<input style="width: 90px; background-color: #C3CCDB;"
														value="" id="allCountRESULT" readonly="readonly" />
													&nbsp;&nbsp;
													<div style="display: none;">
														<input
															style="width: 50px; display: none; background-color: #C3CCDB"
															id="allRESULT" value="10" readonly="readonly" />
														%
													</div>
												</td>
											</tr>
											<tr>
												<td>
													<input style="width: 90px" value="" id="DACLV_COUNT"
														readonly="readonly" style="background-color: #C3CCDB" />
													% &nbsp;&nbsp;
												</td>
											</tr>

										</table>

									</td>

							</tr> 
						</table>
					</fieldset>
				</div>
			</div>
			<div id="chartdiv_qushi" align="center"
				style="width: 760px; height: 380px; border: 1px solid  #FF7D15; background-color: #F7F3F7; ">
				销售预测
			</div>
		<br>
		</div>
	
</form>
	</body>
</html>
<script type="text/javascript">


var  count=0;//目标值计算次数
var countNum=0;
    var KPI_COUNT=0;
    var RESULT_COUNT=0;
function  setPageVsOne(objName)
{
 
 var  resultVs=0;//销售预估
 var  JieGuo=0;//销售金额
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
	      //resultVs= resultVs+	parseInt(vs);
	      
	        resultVs= parseFloat(FloatAdd( parseFloat(vs),resultVs).toFixed(1));
	       
	  	var JieGuovs= parseFloat(vs*parseFloat(document.getElementsByName("allBiLI_<%=strID%>")[0].value )).toFixed(1);
	  	// document.getElementsByName("RESULT<%=strID%>")[0].value =JieGuovs;
	  	 if(JieGuovs==""||JieGuovs=="NaN"||JieGuovs==null||JieGuovs==NaN)
	  	 { 
	  	   JieGuovs=0;
	  	 }
	      JieGuo= JieGuo+	parseInt(JieGuovs);
	  	
	  	 //价值计算 
	  if(count==0)
	  {//第一次执行后就不再执行了
	
	      var targetVs=parseInt(document.getElementById("target_<%=strID%>").value);
	      countNum =parseFloat(parseFloat(countNum)+targetVs).toFixed(1); 
	         
	      var RESULT=parseFloat(document.getElementById("RESULT<%=strID%>").value).toFixed(1);
	      var COMPANYKPI=parseFloat(document.getElementById("COMPANYKPI<%=strID%>").value).toFixed(1);
	      var SALESUM=parseFloat(document.getElementById("SALESUM<%=strID%>").value).toFixed(1);
	         
	      document.getElementById("DACL<%=strID%>").value=parseFloat(RESULT/COMPANYKPI*100).toFixed(1);//-SALESUM
		      KPI_COUNT=FloatAdd( KPI_COUNT,	COMPANYKPI);
		        RESULT_COUNT=FloatAdd( RESULT_COUNT,	RESULT);
		      
	  }
  	<%
  	  }
  	}
  %>
 
    document.getElementById("allCount"+objName).value=resultVs; 
  
  //  document.getElementById("all"+objName).value=parseFloat(resultVs/countNum*100).toFixed(1); //销售总额达成率
  //  document.getElementById("allCountRESULT").value=JieGuo; 
   // document.getElementById("allRESULT").value=parseFloat(JieGuo/countNum*100).toFixed(1); //销售总额达成率
    
}

 

   <% 
   
  String Month_YuCe[] = Source.strMonth_YuCe;
	for (int i = 0; i < Month_YuCe.length; i++) {
		if(i>-1)
		{
			String strFieldName = Month_YuCe[i];
			if(strFieldName.split(",").length>1)
			{
				 strFieldName=strFieldName.split(",")[0];//英文名称 
			}
	%> 
  	 //setPageVsOne('<%=strFieldName%>');
  	//count=1;
  	<%
  	  }
  	}
  %> 
 	  setPageVsOne('COMPANYKPI');	count=1;
 	  setPageVsOne('XSYC');	count=1;
 	  setPageVsOne('RESULT');	count=1;
   document.getElementById("DACLV_COUNT").value=parseFloat(RESULT_COUNT/KPI_COUNT*100).toFixed(1);

</script>
 <script type="text/javascript" >
function getParam()
{
 var RESULT="";
 var COMPANYKPI="";
  var  param="";
  <% 
	for (int i = 0; i < quYuDaiBiaos.length; i++) 
	{
  	  String strID = quYuDaiBiaos[i];
  	  if(strID!="")
  	  { 
  	%>
	  
	        RESULT=parseFloat(document.getElementById("RESULT<%=strID%>").value).toFixed(0);
	        COMPANYKPI=parseFloat(document.getElementById("COMPANYKPI<%=strID%>").value).toFixed(0);
	      var     SALESUM=parseFloat(document.getElementById("SALESUM<%=strID%>").value).toFixed(1);
	        SALESUM="0";
		      param+="&RESULT<%=strID%>="+RESULT+"&COMPANYKPI<%=strID%>="+COMPANYKPI+"&SALESUM<%=strID%>="+SALESUM;
  	<%
  	  }
  	}
  %>
 return param;
 
}
</script>
	<script type="text/javascript">
 
		  var chart = new FusionCharts("<%=request.getContextPath()%>/jsp/static/FC/FCF_Column3D.swf", "ChartId", "700", "380");
		  
    var  param=getParam();
		 chart.setDataURL(escape ("<%=request.getContextPath()%>/queryDaChengLv.action?aa=1"+param));	
		 chart.render("chartdiv_qushi");
</script>
<script type="text/javascript">
try
{
  self.parent.frames["mainFrame_left"].setOnSelectTd('8'); 
  setTableStyle("contentTable","tr0","tr1","tr_on","tr_onclick");
} catch(e){}
</script>
<script type="text/javascript">

<%
 if(CASESAVE>7)
   {//管理员 有单独的地方维护 每个代表的标准答案 
%>
	var Objbuttons=document.getElementsByTagName("input") ; 
	 for(i=0;i<Objbuttons.length;i++){ 
	 
	    if(Objbuttons[i].type=="" ||  Objbuttons[i].type=="text" ){ 
	      Objbuttons[i].disabled=true; 
	      Objbuttons[i].backgroundcolor="#C3CCDB";
	      }
	     }
<%
}
%>

</script>
