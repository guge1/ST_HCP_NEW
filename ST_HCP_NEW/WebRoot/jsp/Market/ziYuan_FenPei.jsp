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
		if(!checkOver())
		{
		   alert("分配资源超出总资源！不能保存");
		   return;
		}
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
 // System.out.println(strStatus); 
 Integer CASESAVE=  request.getAttribute("CASESAVE")==null?0:Integer.parseInt(  request.getAttribute("CASESAVE").toString() );
  
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
                       	<input type="button" value="下一步"
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
     <div id="divPageContent"  class="Div_MainContenStyle" style="width: 100%;overflow:auto;">
        <table style="width: 890px;">
            <tr>
                <td colspan="2" class="tdGroupGround">
            </tr>
            <tr>
                <td colspan="2" class="tdBase11Content11">
                    <table class="tbDragTable" id="contentTable"  style="width: 100%; margin-top: 0px; margin-left: 0px;
                        ">
						 <%=request.getAttribute("filedHtml")%>
                      </table>
                </td>
            </tr>
        </table>
    </div>
    </form>
</body>
 <script type="text/javascript">


function  setPageVsOne(objName)
{
 var  canshu=0;
  var  resultVs=0;
  var  lastJiaoZhi=0;
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
  	 
  	
  	
  	   //alert(parseFloat(document.getElementById("JZ"+objName+<%=strID%>).getAttribute("canshu")));
         canshu=parseFloat( document.getElementById("JZ"+objName+<%=strID%>).getAttribute("canshu"));//目标价值
   if(canshu==0){canshu=1;}
      document.getElementById("JZ"+objName+<%=strID%>).innerHTML=parseFloat(vs/ canshu ).toFixed(2)+"%";//目标参数值
      lastJiaoZhi+=parseFloat(vs/ canshu ).toFixed(2);
      
      resultVs= resultVs+	parseFloat(vs);///canshu
  try{	}
  	catch(e)
  	{
  	}
  	<%
  	  }
  	}
  %>
 
  canshu=canshu*100;
  if("WHOLE"!=objName&&"LASTRESULT"!=objName)
 {
	var  syu=parseFloat(canshu- parseFloat(resultVs).toFixed(0)).toFixed(0);//j计算剩余的
	  if(syu<0)
	  {
	    document.getElementById(objName+"SY").innerHTML=syu+"";
	    document.getElementById(objName+"SY").className="backColor";
	     
	  }else
	  {
	    document.getElementById(objName+"SY").innerHTML=syu+"";
	     document.getElementById(objName+"SY").className="tdFieldInput";
	  }
	
 } 
  document.getElementById(objName+"YJ").innerHTML=parseFloat(resultVs).toFixed(0)+"";//实际已经分配的
  document.getElementById(objName+"KY").innerHTML=parseFloat(canshu).toFixed(0)+"";//实际k可用的
  //价值计算
  document.getElementById("JZ"+objName+"YJ").innerHTML=parseFloat(resultVs/canshu*100).toFixed(1)+"%";//价值已经分配的
  document.getElementById("JZ"+objName+"SY").innerHTML=parseFloat(100-resultVs/canshu*100).toFixed(1)+"%";//价值已经分配剩余的 
  document.getElementById("JZ"+objName+"KY").innerHTML="100%";//价值已经分配剩余的%
 
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
		if(i>3&&i!=strResource.length-1)
		{
			String strFieldName = strResource[i];
			if(strFieldName.split(",").length>1)
					{
						 strFieldName=strFieldName.split(",")[0];//英文名称 
					}
					%>
			  setPageVsOne('<%=strFieldName%>');
			 <%
	   }
   }
			
%> 


function checkOver()
{

<% 
	for (int i = 0; i < strResource.length; i++) { 
		if(i>3&&i!=strResource.length-1)
		{
			String strFieldName = strResource[i];
			if(strFieldName.split(",").length>1)
					{
						 strFieldName=strFieldName.split(",")[0];//英文名称 
					}
					%>
			  
	             var syu=parseFloat(document.getElementById("<%=strFieldName%>SY").innerHTML);
	              if(syu<0)
	              {
	                 return false; 
	              }
			 <% 
	   }
   }
			
%> 

	                 return true;
}
</script>



 <script type="text/javascript">


//分配后的资源比例 和目标值和
function  setPageVsByIDOne(strID)
{
  var  resultVs=0;//资源比例
  var  lastJiaoZhi=0;
  <% 
	for (int i = 0; i < strResource.length; i++) {
	 if(i>3&&i!=strResource.length-1)
		{
			String strFieldName = strResource[i];
			if(strFieldName.split(",").length>1)
			{
				 strFieldName=strFieldName.split(",")[0];//英文名称 
			}
			
		  if(!( "WHOLE".equals(strFieldName)||"LASTRESULT".equals(strFieldName)))
		  { 
			%> 
		  	 var vs= document.getElementsByName("<%=strFieldName%>"+strID)[0].value ;
		  	 if(vs==""||vs=="NaN"||vs==null||vs==NaN)
		  	 { 
		  	   vs=0;
		  	 } 
		  	 
		  	    var  canshu=parseFloat( document.getElementById("JZ<%=strFieldName%>"+strID).getAttribute("canshu"));//目标价值
              if(canshu==0){canshu=1;}  
      
              resultVs= resultVs+	parseFloat(vs/canshu);
           //  resultVs= resultVs+	parseInt(vs);
		  	<%
  	   }
  	    }
  	}
  %>
      var  ZengTiZiYuanBiLI=parseFloat(resultVs/5).toFixed(2);
		
       document.getElementById("label"+strID).innerHTML=ZengTiZiYuanBiLI ;  //页面显示的最终值值
      document.getElementsByName("LASTRESULT"+strID)[0].value=ZengTiZiYuanBiLI;//隐藏的最终值
          
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
