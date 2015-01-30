<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<jsp:useBean id="Source" scope="page"
	class="system.dao.Impl.PublicSourceDAO" />
	<%
		String  strType=request.getParameter("type")==null?"":request.getParameter("type").toString();
		 String strStatus=request.getAttribute("CASESAVE")==null?"":request.getAttribute("CASESAVE").toString();
		
		String strSaveAction=request.getContextPath()+"/saveYueFen_JianKong.action";
		String strTitle="下月监控";
		 String    strBtnName="保存并进行下一步";
		 if("1".equals(strType))
		 {//下月监控
		     strTitle="后月监控";
		     strBtnName="保存所有数据";
		    strSaveAction=request.getContextPath()+"/saveNextYueFen_JianKong.action";
		 }
		//strStatus="";
  %>
<html>
<head id="Head1">
    <title><%=strTitle %> </title>
    <base target="_self" />
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
     <%= request.getAttribute("stepMessage")==null?"":request.getAttribute("stepMessage").toString()
     %>
   <script language="javascript" type="text/javascript"
			src="<%=request.getContextPath()%>/jsp/Market/js/WinOpen.js">
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
	 if(confirm("确定要保存当前数据吗？保存后不能修改！"))
	 {
	     finishFenPei(true);
	    document.forms[0].action = "<%=strSaveAction%>";
		document.forms[0].submit();
	 } 
}
function saveOrder() {
 
   if(confirm("确定分配完毕吗？保存后不能修改！"))
	 {
	     finishFenPei(true);
	    document.forms[0].action = "<%=strSaveAction%>";
		document.forms[0].submit();
	 } 

}
</script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/skins/yellow2/css/style.css" type="text/css"></link>
	
</head>
<body style="margin-top: 0; padding-top: 0;">
    <form name="form1" method="post" action="SimplePage.aspx?PageID=1089&amp;setPageTemplateID=&amp;setPageTest=1"
    id="form1">
    <div class="Btntoolbar">
        <table style="width: 100%;">
            <tr>
                <td>
                </td>
            </tr>
            <tr>
                <td style="width: 100%;">
                    <div class="Btntoolbar_left">
                        &nbsp;&nbsp;<%=strTitle %></div>
                    <div class="Btntoolbar_right">
                    
                       <% if("1".equals(strStatus)){ %>
                       
                                
                       <% if(!"1".equals(strType)){ %>
                            
                       	<input type="button"  class="pt_Long_button"  value="下一步"
													onclick="window.location.href='<%=request.getContextPath()%>/queryNextYueFen_JianKong.action?type=1'">
                                <%}
                                
                                }else{ %>
                             <input type="button"   value="<%=strBtnName %>" onclick="save();"  class="pt_vLong_button"
                            id="Submit1"   style="display: ;" /> 
                            <%} %>
                    </div>
                </td>
            </tr>
        </table>
    </div>
    <div id="divPageContent" style="width: 100%;" class="Div_MainContenStyle"  style="width: 780px;overflow:auto;">
        <table style="width: 100%;">
            <tr>
                <td colspan="2" class="tdGroupGround">
            </tr>
            <tr>
                <td colspan="2" class="tdBase11Content">
                <div  style="width: 100%;overflow:hidden;" >
                    <table class="tbDragTable" id="contentTable" style="width: 100%; margin-top: 0px; margin-left: 0px;
                        " >
                        
                    <colgroup>
                        <col width="80px" />
                        <col width="50px" />
                        <col width="50px" />
                        <col width="50px" />
                        <col width="50px" />
                        <col width="50px" />
                        <col width="50px" />
                        <col width="50px" />
                        <col width="50px" />
                        <col width="50px" />
                        <col width="50px" />
                        <col width="50px" />
                        <col width="50px" /> 
                        <col width="70px" />
                        <col width="160px" />
                        <col width="*" />
                    </colgroup>
                    
                        
						 	<%=request.getAttribute("filedHtml")%>
                     </table>
                     <br/>
        </div>
                </td>
            </tr>
        </table>
       <div id="Tab_001_0" style="width: 100%; border-bottom-color: Red; background-color: #F7F3F7;
            ">
             <table cellpadding="0" cellspacing="0" width="1300" align="center" class="marT">
								  <tr>
								    <td class="common yuce">
								      <h2>监控结果</h2>
								    </td>
								  </tr>
								  </table>
            
             <table class="tbDragTable" id="contentTable1" style="width: 100%; margin-top: 0px; margin-left: 0px;
                        ">
                      
                    <colgroup>
                        <col width="90px" />
                        <col width="90px" />
                        <col width="90px" />
                        <col width="90px" />
                        <col width="90px" />
                        <col width="90px" />
                        <col width="90px" />
                        <col width="90px" />
                        <col width="90px" />
                        <col width="90px" />
                        <col width="90px" />
                        <col width="90px" />
                        <col width="90px" />
                        <col width="90px" /> 
                    </colgroup>
                    
                    <%=request.getAttribute("JianKongJieGuo")%> 
                    </table> 
        </div>
    </div>
    </form>
</body>
</html>
 <script type="text/javascript">
function  getXingDongJiHua(obj,id)
{
 var returnVs=[];
    returnVs =  g_OpenModalReturnWindow_return('<%=request.getContextPath()%>/getXingDongJiHuaList.action',720,620);
 if(returnVs!=null)
 {
  obj.value=returnVs["codeID"]; 
  document.getElementById(id).value=returnVs["id"];
  }
}
</script>

 <script type="text/javascript">

function  setPageVsOne(strID,type)
{
  var  resultVs=0;
  var  lastJiaoZhi=0;
  var  result=[];
  //document.getElementById(objName+"YJ").innerHTML="";
  <%
  String strResource[] = Source.strYue_JianKong;
	for (int i = 0; i < strResource.length; i++) {
		 
			String strFieldName = strResource[i];
			if(strFieldName.split(",").length>1)
			{
				 strFieldName=strFieldName.split(",")[0];//英文名称 
			}
	%> 
	 var bl= document.getElementsByName("<%=strFieldName%>_LV"+strID)[0].value ;
 	 if(bl==""||bl=="NaN"||bl==null||bl==NaN)
 	 { 
 	   bl=0;
 	 }
 	   var ziyuan=parseInt(document.getElementById("ZIYUAN_<%=strFieldName%>").value);//资源
  	 if(ziyuan==""||ziyuan=="NaN"||ziyuan==null||ziyuan==NaN)
  	 { //资源
  	   ziyuan=0;
  	 }	
  
  	
  	 
  	  
  	   
  	if(type==1)
  	{
  	    document.getElementsByName("<%=strFieldName%>"+strID)[0].value=parseFloat( ziyuan*bl/100 ).toFixed(1);
  	    // alert(document.getElementsByName("<%=strFieldName%>"+strID)[0].value);
  	} else
  	{
	  	 var vs= document.getElementsByName("<%=strFieldName%>"+strID)[0].value ;
	  	  if(vs==""||vs=="NaN"||vs==null||vs==NaN)
	  	 { 
	  	   vs=0;
	  	 }
	  	 ///888888888888888888888888888888888
  	   // document.getElementsByName("<%=strFieldName%>_LV"+strID)[0].value= parseFloat(( vs /ziyuan)*100 ).toFixed(2);
  	}
   var bl= document.getElementsByName("<%=strFieldName%>_LV"+strID )[0].value ;
 	 if(bl==""||bl=="NaN"||bl==null||bl==NaN)
 	 { 
 	   bl=0;
 	 }
 	  var vs= document.getElementsByName("<%=strFieldName%>"+strID)[0].value ;
	  	  if(vs==""||vs=="NaN"||vs==null||vs==NaN)
	  	 { 
	  	   vs=0;
	  	 }
        resultVs= FloatAdd( parseFloat(resultVs),parseFloat( bl ).toFixed(2));
     
          document.getElementById("<%=strFieldName%>"+strID+"VS").innerHTML=parseFloat(vs).toFixed(1)+"";//实际已经分配的比例
  	    //document.getElementsByName("<%=strFieldName%>"+strID+"BL")[0].value= parseFloat(( vs /ziyuan)*100 ).toFixed(2);
    // resultVs= resultVs+	parseInt(vs);
  	<%
  	  
  	}
  %>
  document.getElementById(strID+"FP").innerHTML=parseFloat(resultVs/5).toFixed(1)+"%";//分配后的资源比例
  document.getElementById("PXHD"+strID+"").value=parseFloat(resultVs/5).toFixed(1)+"";//分配后的资源比例
  //价值计算 
 
}

 

<% 
  String  quYuDaiBiao=  (request.getAttribute("quYuDaiBiao")==null?"":  request.getAttribute("quYuDaiBiao").toString());
 
  String  quYuDaiBiaos[]=   quYuDaiBiao.split(",");
	for (int i = 0; i < quYuDaiBiaos.length; i++) 
	{
	  String strID = quYuDaiBiaos[i];
  	  if(strID!="")
  	  { 
			%>
			  setPageVsOne('<%=strID%>','');
  
  	<%
	}
	}
			
%> 

</script>

 <script type="text/javascript">
  <% 
	for (int i = 0; i < strResource.length; i++) {
		 
			String strFieldName = strResource[i];
			if(strFieldName.split(",").length>1)
			{
				 strFieldName=strFieldName.split(",")[0];//英文名称 
			}
	%> 
  	setBili('<%=strFieldName%>','');
  	<%
  	  
  	}
  %>
  
  
  function  setBili(strFieldName,type)
  {
   var  resultVs=0;
   var  resultVs_Lv=0;
  var  whole=0;
  var  last=0;
	  <% 
		for (int i = 0; i < quYuDaiBiaos.length; i++) 
		{
		  String strID = quYuDaiBiaos[i];
	  	  if(!"".equals(strID))
	  	  { 
				%>
				var LASTRESULT= document.getElementsByName("LASTRESULT"+<%=strID%>)[0].value ;
			 	 if(LASTRESULT==""||LASTRESULT=="NaN"||LASTRESULT==null||LASTRESULT==NaN)
			 	 { 
			 	   LASTRESULT=0;
			 	 }
			 	 var LASTBL= document.getElementById("<%=strID%>FP").innerHTML.replace("%","") ;
			 	 if(LASTBL==""||LASTBL=="NaN"||LASTBL==null||LASTBL==NaN)
			 	 { 
			 	   LASTBL=0;
			 	 }
			 	
				 var vs= document.getElementsByName( strFieldName+"<%=strID%>")[0].value ;
		  	 if(vs==""||vs=="NaN"||vs==null||vs==NaN)
		  	 { 
		  	   vs=0;
		  	 }
		  	  var bl= document.getElementsByName(strFieldName+"_LV<%=strID%>")[0].value ;
 	
		 	 if(bl==""||bl=="NaN"||bl==null||bl==NaN)
		 	 { 
		 	   bl=0;
		 	 }
		     resultVs=FloatAdd( parseFloat(resultVs),parseFloat( vs ).toFixed(1)); 
		     resultVs_Lv=FloatAdd( parseFloat(resultVs_Lv),parseFloat( bl ).toFixed(2)); 
		 whole=FloatAdd( parseFloat(whole),parseFloat( LASTRESULT ).toFixed(2)); 
		 last=FloatAdd( parseFloat(last),parseFloat( LASTBL ).toFixed(2)); 
	  	<%
		}
		}
				
	%> 
	 
	if(strFieldName!="WHOLE")
	{
           document.getElementById("last").innerHTML=parseFloat(last).toFixed(1)+"%";//整体的的
           document.getElementById("whole").innerHTML=parseFloat(whole).toFixed(1)+"%";//整体的的
		var ziyuan=parseInt(document.getElementById("ZIYUAN_"+strFieldName).value);//资源
		  document.getElementById("YF_"+strFieldName).innerHTML=resultVs_Lv+"%";//已经分配 
		  document.getElementById("YFS_"+strFieldName).innerHTML=resultVs+"";//已经分配 
		  document.getElementById("DF_"+strFieldName).innerHTML=parseFloat((100-resultVs_Lv)).toFixed(1)+"%";//待分配分配 
		  document.getElementById("DFS_"+strFieldName).innerHTML=parseFloat((ziyuan-resultVs)).toFixed(1)+"";//待分配分配 
    }else
    {
    
      document.getElementById("last").innerHTML=parseFloat(last).toFixed(1)+"%";//整体的的
      document.getElementById("whole").innerHTML=parseFloat(whole).toFixed(1)+"%";//整体的的
		var ziyuan=parseInt(document.getElementById("ZIYUAN_"+strFieldName).value);//资源
          document.getElementById("YF_"+strFieldName).innerHTML=resultVs_Lv+"%";//已经分配 
		  document.getElementById("YFS_"+strFieldName).innerHTML=resultVs+"";//已经分配 
		  document.getElementById("DF_"+strFieldName).innerHTML=parseFloat((100-resultVs_Lv)).toFixed(1)+"%";//待分配分配 
		  document.getElementById("DFS_"+strFieldName).innerHTML=parseFloat((ziyuan-resultVs)).toFixed(1)+"";//待分配分配 
    
    }
	 
  }
  
  </script>

 <script type="text/javascript">
 
   
  function  finishFenPei(isShow)
  {
    var  resultVs=0;
    var KPI_COUNT=0;
	  <% 
		for (int i = 0; i < quYuDaiBiaos.length; i++) 
		{
		  String strID = quYuDaiBiaos[i];
	  	  if(!"".equals(strID))
	  	  { 
				%>
			 
			var AddItsm=["XF", "KNH","HD","XSTGF","SCBTGF"];
			 var countResult=0;
			 var countBill=0;
			 for (var n=0;n<AddItsm.length;n++)
			 {
			    var itsm=AddItsm[n];
		        var biaozhun    =document.getElementsByName(itsm+"<%=strID%>_BIAOZHUN")[0].value ;//标准值
		       
		        var lv    =document.getElementsByName(itsm+"_LV")[0].value ;// 权重
			    var nowVs=  document.getElementById(itsm+"<%=strID%>").value;
			   
			   var bili=0;
			   var  resultVs_1=0; 


                var bili_1=0;
			    var bili_2=0;
			    var nowPra=  document.getElementById(itsm+"PRAM").value;
			    if(nowPra!=0) 
                { 
                	 bili_1=biaozhun/ nowPra; 
                	 bili_2=nowVs/ nowPra; 
                }
			    var bili=0;
			    var  resultVs_1=0;
                 countBill=FloatAdd(countBill,bili_1-bili_2);
			     
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
	               	     
	               		 resultVs_1=Math.abs((1+0.07)*lv/100);
	               	 }
                }
             
			           <% if("10001".equals(strID))
	  	      { %>
	  	       if(itsm=="KNH"){}
	  	      //alert(  itsm+ "biaozhun:"+biaozhun+" ");
	  	       // alert(  itsm+ "nowVs:"+nowVs+" ");
	  	          //  alert(countResult+"aaa");
			  <%}%>
			     countResult=FloatAdd(countResult,resultVs_1);
			 }
		                <% if("10003".equals(strID))
	  	      { %>
	  	            // alert(countResult+"bb");
			  <%}%>
		     var JISHU = parseFloat( document.getElementById("JISHU_<%=strID%>").innerHTML).toFixed(1)
		     var TARGET= document.getElementById("preResult<%=strID%>").getAttribute("preResult") ;  
		     var KPI= document.getElementById("KPI_<%=strID%>").innerHTML;  
		       
		    // var DACLV=parseFloat( 1+(LASTRESULT*0.9/100 )+(CountXingDongYX*0.1 )) ;
		     //document.getElementById("JISHU_<%=strID%>").innerHTML=parseFloat(TARGET*DACLV).toFixed(1);
		     var   RESULT=parseFloat(TARGET*(countResult*0.09+1)).toFixed(1);
		           document.getElementById("JISHU_<%=strID%>").innerHTML=RESULT;
		     if(RESULT==0){RESULT=1000000000;}
		    if(isShow)
		    {
		           document.getElementById("DACLV_<%=strID%>").innerHTML=parseFloat(RESULT/KPI *100).toFixed(1)+"%";//-Math.abs(countBill/5*100)
			  
		           document.getElementById("RESULT<%=strID%>").value=RESULT;
		           }
		     resultVs=FloatAdd( resultVs,	RESULT);;
		     KPI_COUNT=FloatAdd( KPI_COUNT,	KPI);
	  	<%
		}
		}
				
	%> 
	
  document.getElementById("Last_All").innerHTML=parseFloat(resultVs).toFixed(1);
  document.getElementById("DACLV_COUNT").innerHTML=parseFloat(resultVs/KPI_COUNT*100).toFixed(1)+"%";
  }
 
 
</script>
<script type="text/javascript">
try
{

  self.parent.frames["mainFrame_left"].setOnSelectTd('9');
  setTableStyle("contentTable","tr0","tr1","tr_on","tr_onclick"); 
    <% if("1".equals(strStatus)){ %>
  finishFenPei(true);
    
    document.getElementById("doOver").style.display="none";
  <%}%>
<%

 if("1".equals(strType))
		 {//下月监控
%>
  self.parent.frames["mainFrame_left"].setOnSelectTd('10');
  <%

}
%> 
} catch(e){}
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
	      }
	     }
<%
}
%>

</script>