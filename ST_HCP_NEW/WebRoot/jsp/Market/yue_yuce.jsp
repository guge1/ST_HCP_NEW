<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<jsp:useBean id="Source" scope="page"
	class="system.dao.Impl.PublicSourceDAO" />
	<%
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
		
		
		 String strStatus=request.getAttribute("CASESAVE")==null?"":request.getAttribute("CASESAVE").toString();
		// strStatus="";
%>
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
			src="<%=request.getContextPath()%>/jsp/Market/js/aPublicjs.js"></script>
		<script language="javascript" type="text/javascript"
			src="<%=request.getContextPath()%>/jsp/web/web-HTML/Scripts/jquery-1.3.2.min.js"></script>
		  


		<link
			href="<%=request.getContextPath()%>/jsp/style_dark/styleform.css"
			rel="stylesheet" type="text/css" />
		<link
			href="<%=request.getContextPath()%>/jsp/style_dark/StyleSheet.css"
			rel="stylesheet" type="text/css" />
 
<link rel="stylesheet" href="<%=basePath%>skins/yellow2/css/style.css" type="text/css"></link>
		<style type="text/css">
.tbDragTable  tr {
	height: 36px;
}
}
</style>
	</head>
		<body  style="margin-right:0px;padding:0px;width:100%;height:auto;">
		<form name="form1" method="post" id="form1">
	<div
				style="text-align:center;width:100%;background:#FFFFFF;">
			<div
				style="border:1px solid #F8C069;padding:auto;margin:0px auto;width:981px;text-align:center;height: expression(document.body.clientHeight);overflow: auto;margin:auto;">

				<table style="width: 100%;">
					<tr>
						<td>

							 <table cellpadding="0" cellspacing="0" width="100%" align="center" class="marT">
								  <tr>
								    <td class="common yuce">
								      <h2>资源分配</h2>
								    </td>
								  </tr>
								  </table>
								<table>
									<tr>
										<td>
											<table class="tbDragTable"  id="contentTable" 
												style="width: 500px; margin-top: 0px; margin-left: 0px;">
												<colgroup>
													<col width="60px" />
													<col width="70px" />
													<col width="70px" /> 
													<col width="80px" />
													<col width="90px" />
													<col width="70px" />
													<col width="70px" />
												</colgroup>
												<%=request.getAttribute("filedHtml_1")%>

												<tr>
													<td colspan="8" class="tdFieldInput"
														style="text-align: center">
														
                                      <% if(!"1".equals(strStatus)){ %> 
													<div  style="width:430px;float:right;">	<input type="button" value="销 售 预 测=》"  onclick="save()"> <%}else{ %>  
			                          </div>  <%} %>
													</td>
												</tr>
											</table>
										</td>
										<td style="width: *;text-align:left;">
											<!--<img alt="" src="xiaoshouyuce.bmp" width="600px">
											-->
											 
                       
                                
                                          	<div id="chartdiv_qushi" align="center"
												style="width: 600px; height: 340px; border: 1px solid  #FF7D15; background-color: #F7F3F7;">
												销售预测=》
											</div>
			                       	 
										
										</td>
									</tr>
								</table> 
						</td>
					</tr>
					<tr>
						<td>
							<div
								style="margin-right: : 10px; color: #666666; background-color: #F7F3F7; width: 1380px; padding-top: 3px; font-size: 12px; text-aglin: center;"
								align="center">
								 <table cellpadding="0" cellspacing="0" width="100%" align="center" class="marT">
								  <tr>
								    <td class="common yuce">
								      <h2>预测结果</h2>
								    </td>
								  </tr>
								  </table>
									<table border="0" cellpadding="0" cellspacing="0" 
										style="font-size: 12px;float:left;width:1380px" class="aaaa">
										<tr>
											<td width="1080px">
												<table border="0" cellpadding="0" cellspacing="0" id="contentTable1" 
													style="font-size: 12px;margin-left:10px;"  class="aaaa">
													<%=request.getAttribute("filedHtml")%>
												</table>
											</td>
											<td width="240px">
													<div style="margin-left:10px;margin-top:4px;padding-top:6px;"> 销售总金额:
												<input style="width: 70px" value="" id="allXSYC_NEXT"
													readonly="readonly" style="background-color: ;" />
												<br />
												指标总金额:
												<input style="width: 70px" value="" id="allCOMPANYKPI"
													readonly="readonly" style="background-color: ;" />
												<br /> 
												 销售达成率:
												<input  id="allDACL" value="10"
													readonly="readonly" style="width: 70px;background-color: ; ;"/>
												%
                                             </div>
											</td>
											<td  style="width: 320px">
												 <% if(!"1".equals(strStatus)){ %>
                            
												<a    href="#" 
													onclick="save()" class="newBtn"   > <font color="white">保存</font></a> 
                       	   <%} else{ %>  
                            <%} %>
                                               
												<a    href="#" 
													onclick="window.location.href='<%=basePath %>getMarketInfo_Body.action'"  class="newBtn"   ><font color="white">返回</font></a> 
												 
											</td>
										</tr>
										 
									</table>

 
							</div>
						</td>
					</tr>
				</table>

			</div>
			</div>
		</form>
	</body>
</html>
<script type="text/javascript">

function save() {

	 if(confirm("确定要保存当前数据吗？保存后不能修改！"))
	 {
	  try{ 
	  
		  setResult();
		  setPageNameVsOne('XSYC_NEXT');
		  setPageNameVsOne('COMPANYKPI'); 
		 }catch(e){}
		   
		document.forms[0].action = "<%=request.getContextPath()%>/saveYue_YuCe.action";
		document.forms[0].submit();
	}

}
function loadData() {
 
	var chart = new FusionCharts( "<%=request.getContextPath()%>/jsp/static/FC/FCF_MSLine.swf", "ChartId", "600", "320");
	chart.setDataURL("<%=request.getContextPath()%>/queryXiaoShouYuGu.action?type=1");
	chart.render("chartdiv_qushi");
}

 

	var chart = new FusionCharts( "<%=request.getContextPath()%>/jsp/static/FC/FCF_MSLine.swf", "ChartId", "600", "320");
	//chart.setDataURL("<%=request.getContextPath()%>/queryXiaoShouYuGu.action?type=1");
	  chart.setDataURL("<%=basePath%>jsp/static/DATE/MSColumn3D_xiaoshou.xml");
	  chart.render("chartdiv_qushi");
</script>


<script type="text/javascript">
  <% 
  
  String  quYuDaiBiao=  request.getAttribute("quYuDaiBiao")==null?"":  request.getAttribute("quYuDaiBiao").toString();
  String  quYuDaiBiaos[]=   quYuDaiBiao.split(",");
  String strResource[] = Source.strYue_YuCe;
	for (int i = 0; i < strResource.length; i++) {
		if(i>-1)
		{
			String strFieldName = strResource[i];
			if(strFieldName.split(",").length>1)
			{
				 strFieldName=strFieldName.split(",")[0];//英文名称 
			}
	%> 
  	setBili('<%=strFieldName%>');
  	
  	<%
  	  }
  	}
  %>
  
  ////已经分配   待分配分配 
  function  setBili(strFieldName)
  {
  
  var  resultVs=0;
	  <% 
		for (int i = 0; i < quYuDaiBiaos.length; i++) 
		{
		  String strID = quYuDaiBiaos[i];
	  	  if(strID!="")
	  	  { 
		%>
				 var vs= document.getElementsByName(strFieldName+"<%=strID%>")[0].value ;
			  	 if(vs==""||vs=="NaN"||vs==null||vs==NaN)
			  	 { 
			  	   vs=0;
			  	 }
				 var PRAM= document.getElementsByName(strFieldName+"PRAM")[0].value ;
			  	 if(PRAM==""||PRAM=="NaN"||PRAM==null||PRAM==NaN)
			  	 { 
			  	   PRAM=0;
			  	 }
		        resultVs= resultVs+	parseInt(vs)/PRAM;
	  	<%
		}
	  }
				
	%> 
	var ziyuan=parseInt(document.getElementById("ZIYUAN_"+strFieldName).value);//资源
	if(ziyuan==0){ziyuan=1;}
	if(resultVs==0){resultVs=1/100000;}
	//var   YF=parseFloat(resultVs/ziyuan*100).toFixed(1);
	var   YF=parseFloat(resultVs*100).toFixed(1);
  document.getElementById("YF_"+strFieldName).innerHTML=YF+"%";//已经分配 
  document.getElementById("DF_"+strFieldName).innerHTML=parseFloat((100-YF)).toFixed(1)+"%";//待分配分配 
 try{ 
  setPageNameVsOne('XSYC_NEXT');
  setPageNameVsOne('COMPANYKPI'); 
 }catch(e){}
  }
</script>


<script type="text/javascript">

var  countLastFPNum=0;
var  countNum=0;
var KPICount=0;
var ResultCount=0;
var  count=0;//目标值计算次数
var allDACL="";
//分配后的资源比例 和目标值和
function  setPageVsOne(strID,isShow)
{
  var  resultVs=0;//资源比例
  var  resultVs_Count=0;//计算资源比例
  var  lastJiaoZhi=0;
  var countBill=0;
  <% 
	for (int i = 0; i < strResource.length; i++) {
		if(i>-1)
		{
			String strFieldName = strResource[i];
			if(strFieldName.split(",").length>1)
			{
				 strFieldName=strFieldName.split(",")[0];//英文名称 
			}
	%> 
  	

  	 var vs= document.getElementsByName("<%=strFieldName%>"+strID)[0].value ;
  
  	 if(vs==""||vs=="NaN"||vs==null||vs==NaN)
  	 { 
  	   vs=0;
  	 }	  
	 var ziyuan=parseInt(document.getElementById("ZIYUAN_<%=strFieldName%>").value);//资源
  	 if(ziyuan==""||ziyuan=="NaN"||ziyuan==null||ziyuan==NaN)
  	 { //资源
  	   ziyuan=10000;
  	 }	    
  	 
  	 var lv= document.getElementsByName("ZIYUAN_<%=strFieldName%>QZ")[0].value ;//资源权重
  
  	 if(lv==""||lv=="NaN"||lv==null||lv==NaN)
  	 { 
  	   lv=0;
  	 }	 
  	  
      var biaozhun    =document.getElementsByName("<%=strFieldName.replace("_LV", "")%>_BIAOZHUN"+strID)[0].value ;//标准值
  	  if(biaozhun==""||biaozhun=="NaN"||biaozhun==null||biaozhun==NaN)
  	 { 
  	   biaozhun=0;
  	 }	 
  	  var PRAM= document.getElementsByName("<%=strFieldName%>PRAM")[0].value ;
	  	 if(PRAM==""||PRAM=="NaN"||PRAM==null||PRAM==NaN)
	  	 { 
	  	   PRAM=0;
	  	 }
     //resultVs= FloatAdd( parseFloat(resultVs),parseFloat( (parseInt(vs)/ziyuan)*100 ).toFixed(1));
     resultVs= FloatAdd( parseFloat(resultVs ),parseFloat(  vs /PRAM ).toFixed(1)) ;
     var resultVs_1=0; 
     
	   var nowVs=vs;// ziyuan*vs/100 ;//总资源/百分比
	   
         var bili_1=0;
	    var bili_2=0; 
		var nowPra=  document.getElementById("<%=strFieldName%>PRAM").value;
	    if(nowPra!=0) 
          { 
          	 bili_1=biaozhun/ nowPra; 
          	 bili_2=nowVs/ nowPra; 
           } 
         countBill=FloatAdd(countBill,bili_1-bili_2);
	    var bili=0;  
	    if(biaozhun!=0) 
           {
           
           	 bili=0;
           	 bili=(nowVs)/biaozhun;
           	 bili=bili>2?2:bili;
              resultVs_1= Math.abs(bili*lv/100); 
       
           }else
           {
           
           	 if(nowVs==0)
           	 {
           		 resultVs_1=Math.abs(lv/100);

           	 }else
           	 {
           	     
           		 resultVs_1=Math.abs((1+0.05)*lv/100);
           	 }
         }
             
       	 
         resultVs_Count= FloatAdd( parseFloat(resultVs_Count),parseFloat(resultVs_1 ));
       
	//var ziyuanQz=parseInt(document.getElementById("ZIYUAN_"+strFieldName+"").value);//资源
     
  	<%
  	  }
  	}
  %>
   if(resultVs==0&&!resultVs)
	   {
	     resultVs=1/10000;
	   } 
      var  ZengTiZiYuanBiLI=resultVs_Count;//parseFloat(resultVs).toFixed(1);
       if(strID=="10012")
			       	 {
				            //alert(ZengTiZiYuanBiLI);
				     }
       document.getElementById(strID+"FP").innerHTML=parseFloat(resultVs*100/5).toFixed(1)+"%";//分配后的资源比例
       document.getElementById("PXHD"+strID).value=parseFloat(resultVs*100/5).toFixed(1);//分配后的资源比例
       document.getElementById("LASTRESULT"+strID).value=parseFloat(resultVs*100/5).toFixed(1)+"";//分配后的资源比例
	  //价值计算 
	  var targetVs=parseInt(document.getElementById("target_"+strID).value);
	   if(targetVs==0)
	   {
	      targetVs=1/10000;
	   }
	  if(count==0)
	  {//第一次执行后就不再执行了
	       countNum =parseFloat(parseFloat(countNum)+targetVs).toFixed(1); 
	    
	  }  
	     var XSYC_NEXT=parseFloat(targetVs*(1+parseFloat(ZengTiZiYuanBiLI*0.07))).toFixed(1);
	  	<%if(!"1".equals(strStatus)){ %>
			 

			<%}else{%>
			   
	    var XSYC_NEXT=parseFloat(document.getElementById("XSYC_NEXT"+strID).value).toFixed(1);
			<%}%>
       
        countLastFPNum= parseFloat(FloatAdd( parseFloat(countLastFPNum),resultVs).toFixed(1));
        
	     var COMPANYKPI=parseFloat(document.getElementById("COMPANYKPI"+strID).value).toFixed(1);
	     if(COMPANYKPI==0){COMPANYKPI=10000000000000;}
	     var DACL=parseFloat(XSYC_NEXT/COMPANYKPI*100).toFixed(1);//-Math.abs(countBill/5*100)
	     
	        allDACL=FloatAdd(allDACL, DACL);
		if(isShow){
		 document.getElementsByName("XSYC_NEXT"+strID)[0].value=XSYC_NEXT;
		  document.getElementById("DACL"+strID).value=DACL;
		}else
		{
		  document.getElementById("DACL"+strID).value=DACL;
		}
}

 
function setResult(){
<%  

	for (int i = 0; i < quYuDaiBiaos.length; i++) 
	{
	  String strID = quYuDaiBiaos[i];
  	  if(strID!="")
  	  { 
			%>
			<%if(!"1".equals(strStatus)){ %>
			
			<%}else{%>
			  
			<%}%>
			
			try{  
			setPageVsOne('<%=strID%>',true);
			}catch(e){}
  	<%
	}
	}
			
%> 
}
setResult();
count=1;//目标值计算完成
</script>

<script type="text/javascript">
//计算总额
var  allCount=[];
function  setPageNameVsOne(objName)
{
 
 var  resultVs=0;
  //document.getElementById(objName+"YJ").innerHTML="";
  <%
	for (int i = 0; i < quYuDaiBiaos.length; i++) 
	{
  	  String strID = quYuDaiBiaos[i];
  	  if(strID!="")
  	  { 
  	%>
  	var vs= document.getElementsByName(objName+"<%=strID%>")[0].value ;//defaultValue
  	//vs=$("#"+objName+"<%=strID%>").val()
  	 if(vs==""||vs=="NaN"||vs==null||vs==NaN)
  	 { 
  	   vs=0;
  	 } 
  	 if(objName+<%=strID%>=="XSYC_NEXT10003")
  	 {
  	  //debugger;
  	 }
      //resultVs= resultVs+	parseFloat(vs);
  	resultVs=FloatAdd(resultVs,vs);
  //	alert(objName+<%=strID%>+":"+vs);
  	<%
  	  }
  	}
  %> 
     if(resultVs==0){resultVs=1/100000;; } 
   document.getElementById("all"+objName).value=parseFloat(resultVs).toFixed(1); //销售总额
   allCount[objName]=resultVs;
   if(countNum==0){countNum=1;} 
   if(objName=="DACL")
   {
      var  resultVs_next=parseFloat(allCount["XSYC_NEXT"]);
      var  COMPANYKPI=parseFloat(allCount["COMPANYKPI"]);if(COMPANYKPI==0){COMPANYKPI=10000000000000;}
      // parseFloat(allDACL/5).toFixed(1);// 
       document.getElementById("allDACL").value= parseFloat(resultVs_next/COMPANYKPI*100).toFixed(1); //区域销售达成率:
   }else
   {
   
   }
   //document.getElementById("YP").innerHTML=countLastFPNum+"%";
  //loadData();
} 

function  setPageNameVs()
{
   <%    
   
  String Month_YuCe[] = Source.strYue_YuCe_1;
	for (int i = 0; i < Month_YuCe.length; i++) {
		if(i>-1)
		{
			String strFieldName = Month_YuCe[i];
			if(strFieldName.split(",").length>1)
			{
				 strFieldName=strFieldName.split(",")[0];//英文名称 
			}
	%> 
  	setPageNameVsOne('<%=strFieldName%>');
  	
  	<%
  	  }
  	}
  %>
}
 setPageNameVs();

</script>
<script type="text/javascript">

<%

   if("1".equals(strStatus))
   {//管理员 有单独的地方维护 每个代表的标准答案 
%>
	var Objbuttons=document.getElementsByTagName("input") ; 
	 for(i=0;i<Objbuttons.length;i++){ 
	 
	    if(Objbuttons[i].type=="" ||  Objbuttons[i].type=="text" ){ 
	      Objbuttons[i].disabled=true; 
	      Objbuttons[i].backgroundcolor="#C3CCDB";
	      //Objbuttons[i].readonly=false;
	      }
	     }
	<%
	}
	%>

  setTableStyle("contentTable","tr0","tr1","tr_on","tr_onclick");
  setTableStyle("contentTable1","tr0","tr1","tr_on","tr_onclick");
</script>
