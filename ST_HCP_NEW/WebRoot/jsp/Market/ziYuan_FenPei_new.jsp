<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<jsp:useBean id="Source" scope="page"
	class="system.dao.Impl.PublicSourceDAO" /> 
	 
<html>
<head  >
    <title>资源分配</title>
    <base target="_self" />
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
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
			<style type="text/css">
			.backColor{  background-color:#FF0000;
			
			color: #001a9b;
	/*width: 43%;by oxx 2011-7-12*/
	font-size: 10pt;
	border: #82AAD4 solid;
	border-width: 0px 1px 0px 1px;
	padding: 1px, 0px, 0px;
	text-align: left; /*结束	background-color: #eeeeee;*/
	background-color: #FF0000;
	white-space: normal;
	font: 12px "宋体";
			}
			
			</style>
		<script type="text/javascript">
		function save() {
		 if(confirm("确定要保存当前数据吗？保存后不能修改！"))
	          {
			document.forms[0].action = "<%=request.getContextPath()%>/saveZiYuan_FenPei.action";
			document.forms[0].submit();
			}
		
		}
		
   function setVsByIDOne(id)
   {
   
   }
</script> 
  <% 
  String strStatus=request.getAttribute("CASESAVE")==null?"":request.getAttribute("CASESAVE").toString();
  Integer CASESAVE=  request.getAttribute("CASESAVE")==null?0:Integer.parseInt(  request.getAttribute("CASESAVE").toString() );
  // System.out.println(CASESAVE); 
  // CASESAVE=1; 
  %>
</head>
<body style="margin-top: 0; padding-top: 0;">
    <form name="form1" method="post"  
    id="form1">
    <div class="Btntoolbar">
        <table style="width: 100%;">
            <tr>
                <td>
                </td>
            </tr>
            <tr>
                <td style="width: 100%;">
                    <div style="" class="Btntoolbar_left">
                        &nbsp;&nbsp;资源分配</div>
                    <div style="" class="Btntoolbar_right">
                       <% if(CASESAVE>5){ %>
                       	<input  class="pt_Long_button" type="button" value="下一步"
													onclick="window.location.href='<%=request.getContextPath()%>/queryXingDong_JiHua.action'">
                       <%}else{ %>
                        <input type="button"  value="保存并提交下一步" onclick="save();"   class="pt_vLong_button"
                            id="Submit1"   style="display: ;" /> 
                            <%} %>
                    </div>
                </td>
            </tr>
        </table>
    </div>
     <div id="divPageContent" style="width: 100%;" class="Div_MainContenStyle">
        <table style="width: 100%;">
           
            <tr>
                <td colspan="2" class="tdBase11Content11">
                
                <div  >
                    <table class="tbDragTable" id="contentTable" style="width: 100%; margin-top: 0px; margin-left: 0px;
                        " > <colgroup>
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
                        <col width="70px" />
                        <col width="70px" /> 
                        <col width="*" />
                    </colgroup>
						 <%=request.getAttribute("filedHtml")%>
                      </table>
                      </div>
                </td>
            </tr>
        </table>
    </div>
    </form>
</body>
 <script type="text/javascript">
//计算列
function  setPageVsOne(objName)
{
  var  resultVs=0;
  var  resultVs_BL=0;
  var  lastJiaoZhi=0;
  var  whole=0;
 
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
  	
	 	var LASTRESULT= document.getElementsByName("LASTRESULT"+<%=strID%>)[0].value ;
	 	 if(LASTRESULT==""||LASTRESULT=="NaN"||LASTRESULT==null||LASTRESULT==NaN)
	 	 { 
	 	   LASTRESULT=0;
	 	 }
	 	
			 	 
	 	var vs= document.getElementsByName(objName+<%=strID%>)[0].value ;
	 	 if(vs==""||vs=="NaN"||vs==null||vs==NaN)
	 	 { 
	 	   vs=0;
	 	 }
 	 
  	 
        var PRAM= document.getElementsByName(objName+"PRAM")[0].value ;
	  	 if(PRAM==""||PRAM=="NaN"||PRAM==null||PRAM==NaN)
	  	 { 
	  	   PRAM=0;
	  	 }
	  	 var lv= document.getElementsByName(objName+"_LV"+<%=strID%>)[0].value ;
	 	 if(lv==""||lv=="NaN"||lv==null||lv==NaN)
	 	 { 
	 	   lv=0;
	 	 } 
		 whole=FloatAdd( parseFloat(whole),parseFloat( LASTRESULT ).toFixed(2)); 
		 resultVs_BL=FloatAdd( parseFloat(resultVs_BL),parseFloat( lv ).toFixed(1)); 
		 resultVs=FloatAdd( parseFloat(resultVs),parseFloat( vs ).toFixed(1)); 
          
         //888888888888888888888888888888888
         //document.getElementById(objName+"_LV"+"<%=strID%>").value=parseFloat(vs/PRAM*100).toFixed(1)+"";//实际已经分配的比例
         
          document.getElementById(objName+""+"<%=strID%>VS").innerHTML=parseFloat(vs).toFixed(1);//实际已经分配的比例
      
  try{	}
  	catch(e)
  	{
  	}
  	<%
  	  }
  	}
  %>
 
 
  document.getElementById("whole").innerHTML=parseFloat(whole).toFixed(1)+"%";//整体的的
  document.getElementById("YF_"+objName).innerHTML=parseFloat(resultVs_BL).toFixed(1)+"%";//实际已经分配的
  document.getElementById("DF_"+objName+"").innerHTML=parseFloat(100-resultVs_BL).toFixed(1)+"%";//实际k可用的
  document.getElementById("SY_"+objName+"").innerHTML=parseFloat(100-resultVs_BL).toFixed(1)+"%";//剩余的
 
 
  document.getElementById("YFS_"+objName).innerHTML=parseFloat(resultVs).toFixed(0)+"";//实际已经分配的
  document.getElementById("DFS_"+objName+"").innerHTML=parseFloat(PRAM-resultVs).toFixed(0)+"";//实际k可用的
  document.getElementById("SYS_"+objName+"").innerHTML=parseFloat(PRAM-resultVs).toFixed(0)+"";//剩余的
  //价值计算
  
 
}
//计算列
function  setPageVsOne_BL(objName)
{
 
  var  resultVs=0;
  var  resultVs_BL=0;
  var  lastJiaoZhi=0;
  var  DFS=0;
  var  whole=0;
  //document.getElementById(objName+"YJ").innerHTML="";
  <%
 
	for (int i = 0; i < quYuDaiBiaos.length; i++) 
	{
  	  String strID = quYuDaiBiaos[i];
   
  	  if(strID!="")
  	  { 
  	%>
  	   
			 	  
  	var LASTRESULT= document.getElementsByName("LASTRESULT"+<%=strID%>)[0].value ;
	 	 if(LASTRESULT==""||LASTRESULT=="NaN"||LASTRESULT==null||LASTRESULT==NaN)
	 	 { 
	 	   LASTRESULT=0;
	 	 }
 	var bl= document.getElementsByName(objName+"_LV"+<%=strID%>)[0].value ;
 	 if(bl==""||bl=="NaN"||bl==null||bl==NaN)
 	 {  
 	   bl=0;
 	 }
  	 
        var PRAM= document.getElementsByName(objName+"PRAM")[0].value ;
	  	 if(PRAM==""||PRAM=="NaN"||PRAM==null||PRAM==NaN)
	  	 { 
	  	   PRAM=0;
	  	 }
         document.getElementsByName(objName+<%=strID%>)[0].value=parseFloat(PRAM*bl/100).toFixed(1);
         var vs= document.getElementsByName(objName+<%=strID%>)[0].value ;
 	 if(vs==""||vs=="NaN"||vs==null||vs==NaN)
 	 { 
 	   vs=0;
 	 }
      
		 resultVs_BL=FloatAdd( parseFloat(resultVs_BL),parseFloat( bl/100 ).toFixed(2)); 
		 whole=FloatAdd( parseFloat(whole),parseFloat( LASTRESULT ).toFixed(2)); 
		   resultVs=FloatAdd( parseFloat(resultVs),parseFloat( vs ).toFixed(1)); 
          document.getElementById(objName+""+"<%=strID%>VS").innerHTML=parseFloat(vs).toFixed(1);//实际已经分配的比例
  try{	}
  	catch(e)
  	{
  	}
  	<%
  	  }
  	}
  %>
  
 
  document.getElementById("whole").innerHTML=parseFloat(whole).toFixed(2)+"%";//整体的的
  document.getElementById("YF_"+objName).innerHTML=parseFloat(resultVs_BL*100).toFixed(1)+"%";//实际已经分配的
  document.getElementById("DF_"+objName+"").innerHTML=parseFloat(100-resultVs_BL*100).toFixed(1)+"%";//实际k可用的
  document.getElementById("SY_"+objName+"").innerHTML=parseFloat(100-resultVs_BL*100).toFixed(1)+"%";//剩余的
 
 
  document.getElementById("YFS_"+objName).innerHTML=parseFloat(resultVs).toFixed(0)+"";//实际已经分配的
  document.getElementById("DFS_"+objName+"").innerHTML=parseFloat(PRAM-resultVs).toFixed(0)+"";//实际k可用的
  document.getElementById("SYS_"+objName+"").innerHTML=parseFloat(PRAM-resultVs).toFixed(0)+"";//剩余的
  //价值计算
  
 
}

//设置有效价值
function  setJiaZhi(vs,objName)
{
	var vs=parseInt( obj.value);//document.getElementsByName(objName+)[0].value ;
  	 if(vs==""||vs=="NaN"||vs==null||vs==NaN)
  	 { 
  	   vs=0;
  	 }
  	// document.getElementById("").value=
      resultVs= resultVs+	parseInt(vs);
}

<%String strResource[] = Source.strZiYuan_FenPei;

	for (int i = 0; i < strResource.length; i++) {
	 
			String strFieldName = strResource[i];
			if(strFieldName.split(",").length>1)
					{
						 strFieldName=strFieldName.split(",")[0];//英文名称 
					}
					%>
			  setPageVsOne('<%=strFieldName%>');
			 <%
	    
   }
			
%> 
</script>



 <script type="text/javascript">


//分配后的资源比例 和目标值和
function  setPageVsByIDOne_BL(strID)
{
  var  resultVs=0;//资源比例
  var  lastJiaoZhi=0;
  <% 
	for (int i = 0; i < strResource.length; i++) {
	  
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
		  	 
		  	  var PRAM= document.getElementsByName("<%=strFieldName%>PRAM")[0].value ;
	  	 if(PRAM==""||PRAM=="NaN"||PRAM==null||PRAM==NaN)
	  	 { 
	  	   PRAM=1;
	  	 }
		    var bl= document.getElementsByName("<%=strFieldName%>_LV"+strID)[0].value ;
		 	 if(bl==""||bl=="NaN"||bl==null||bl==NaN)
		 	 { 
		 	   bl=0;
		 	 }
		   resultVs=FloatAdd( parseFloat(resultVs),parseFloat( bl ).toFixed(1)); 
          document.getElementById("<%=strFieldName%>"+strID+"VS").innerHTML=parseFloat(vs).toFixed(1)+"";//实际已经分配的比例
           //  resultVs= resultVs+	parseInt(vs);
		  	<%
  	    }
  %>
      var  ZengTiZiYuanBiLI=parseFloat(resultVs/5).toFixed(2);
     //  document.getElementById("whole"+strID).innerHTML=ZengTiZiYuanBiLI +"%";  //页面显示的最终值值
      document.getElementById(strID+"FP").innerHTML=ZengTiZiYuanBiLI+"%";//隐藏的最终值
      document.getElementById("PXHD"+strID+"").value=ZengTiZiYuanBiLI+"";//隐藏的最终值
     
      aa();
          
}

//分配后的资源比例 和目标值和
function  setPageVsByIDOne(strID)
{
  var  resultVs=0;//资源比例
  var  lastJiaoZhi=0;
  <% 
	for (int i = 0; i < strResource.length; i++) {
	  
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
		  	  var lv= document.getElementsByName("<%=strFieldName%>_LV"+strID)[0].value ;
		  	 if(lv==""||lv=="NaN"||lv==null||lv==NaN)
		  	 { 
		  	   lv=0;
		  	 } 
		  	  var PRAM= document.getElementsByName("<%=strFieldName%>PRAM")[0].value ;
	  	 if(PRAM==""||PRAM=="NaN"||PRAM==null||PRAM==NaN)
	  	 { 
	  	   PRAM=1;
	  	 }
		    
		   resultVs=FloatAdd( parseFloat(resultVs),parseFloat( lv ).toFixed(1)); 
           //  resultVs= resultVs+	parseInt(vs);
		  	<%
  	    }
  %>
 
      var  ZengTiZiYuanBiLI=parseFloat(resultVs/5).toFixed(2);
		
     // document.getElementById("whole_"+strID).innerHTML=ZengTiZiYuanBiLI +"%";  //页面显示的最终值值
      document.getElementById(""+strID+"FP").innerHTML=ZengTiZiYuanBiLI+"%";//隐藏的最终值
          aa();
}
 
<%  
	for (int i = 0; i < quYuDaiBiaos.length; i++) 
	{
	  String strID = quYuDaiBiaos[i];
  	  if(strID!="")
  	  {  
			%>
			  setPageVsByIDOne('<%=strID%>');try{}catch(e){}
			
  	<%
	}
	}
			
%> 
function aa()
{
 var  last=0;
<%  
	for (int i = 0; i < quYuDaiBiaos.length; i++) 
	{
	  String strID = quYuDaiBiaos[i];
  	  if(strID!="")
  	  {  
			%>
			   var LASTBL= document.getElementById("<%=strID%>FP").innerHTML.replace("%","") ;
			 	 if(LASTBL==""||LASTBL=="NaN"||LASTBL==null||LASTBL==NaN)
			 	 { 
			 	   LASTBL=0;
			 	 }
		        last=FloatAdd( parseFloat(last),parseFloat( LASTBL ).toFixed(2)); 
  	<%
	}
	}
			
%> 

     document.getElementById("last").innerHTML=parseFloat(last).toFixed(2)+"%";//整体的的
}
aa();
</script>
</html>
<script type="text/javascript">
try
{
  self.parent.frames["mainFrame_left"].setOnSelectTd('6'); 
  setTableStyle("contentTable","tr0","tr1","tr_on","tr_onclick");
} catch(e){}
</script>
<script type="text/javascript">

<%
 if(CASESAVE>5)
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

