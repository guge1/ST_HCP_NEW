<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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

 %>
<html  >
<head id="Head1">
    <title>历史数据修改 </title>
    <base target="_self" />
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
    
    
<script type="text/javascript" src="<%=request.getContextPath()%>/js/commonform.js"  charset="UTF-8"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/prototype.js" charset="UTF-8"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/sniper.js" charset="UTF-8"></script>
    
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
			<%
 	String intYear_s =   request.getParameter("intYear")==null?"":request.getParameter("intYear").toString() ;
	String intMonth_s =    request.getParameter("intMonth")==null?"":request.getParameter("intMonth").toString();
 
		String strType = request.getParameter("type")==null?"":request.getParameter("type").toString() ;//1 的时候是有效性历史数据
 %>
		<script type="text/javascript">
function save() {
	 if(confirm("确定要保存修改历史数据吗？"))
	{
      document.getElementById('uploading').style.display = "";
		document.forms[0].action = "<%=request.getContextPath()%>/saveEditHostory.action?type=<%=strType%>";
		document.forms[0].submit();
	}
}


</script>
</head>
<body > 
<form name="form1" method="post" action="" id="form1"  style="margin-right:0px;padding:0px;width:100%;">
 
	 <div style="text-align:center;width:100%;background:#FFFFFF;">
       <div id="con_article_1" style="border:1px solid #F8C069;margin:0px auto;width:981px;text-align:center;background:#FFFFFF;" >
    	<div id="uploading"
				style="position: absolute; top: 90px;left:200px; z-index: 22; width: 100%; height: 100%; color: Red;">
				<br>
				<br>
				<br>
				<br>
				<br>
				<img
					src="<%=request.getContextPath()%>/jsp/web/images/statusbar_loading.gif">
				<b>系统正在处理您的请求,请稍等~</b>
			</div>
    <div class="Btntoolbar">
        <table style="width: 100%;">
            <tr>
                <td>
                </td>
            </tr>
            <tr>
                <td style="width: 100%;">
                    <div style="" class="Btntoolbar_left">
                        &nbsp;&nbsp;历史数据修改
                        
                        </div>
                    <div style="" class="Btntoolbar_right">
                        
                        <input type="button" name="btnSave1" value="保存" onclick="save()"
                            id="Submit1"  style="display: ;"   class="pt_vLong_button" /> 
                            <input type="button" value="返回"
													onclick="window.location.href='<%=basePath %>queryCase.action'"  class="pt_Long_button">
                    </div>
                </td>
            </tr>
        </table>
    </div>
     <div id="divPageContent" style="width: 100%;" class="Div_MainContenStyle">
        <table style="width: 100%;">
          
            <tr>
                <td   class="tdBase11Content11">
                    <table class="tbDragTable" style="width: 100%; margin-top: auto; margin-left: auto;   ">
                      <tbody  >
							<%=request.getAttribute("headRow")%></tbody>
									<%=request.getAttribute("filedHtml")%>
                       </table>
                </td>
            </tr>
        </table>
    </div>
    </div>
    </div>
    </form>
</body>
</html>

<script type="text/javascript"> 

  
document.getElementById('uploading').style.display = "none";
function setResult(Marketid) {
   
  //FormSubmint_ZongTi("form1","<%=request.getContextPath()%>/getLineResult.action?Marketid="+Marketid,type);
   var  url="<%=request.getContextPath()%>/getLineResult.action?Marketid_P="+Marketid;
     
	var obj = document.getElementById("form1");
    var content = encodeURI(Form.serialize(obj));
    
    document.getElementById('uploading').style.display = "";
	var ajax = new Ajax.Request( url,
        {
            method:"post",       //表单提交方式 
            postBody:content,   //提交的xml
            setRequestHeader:{"content-Type":"text/xml"}, //指定发送的数据为 xml 文档（非字符串）
            onComplete:function(httpRequest){    //提交成功回调 
            	//var vCMD=document.getElementById("__COMMAND").value;
            	//OnComplete(vCMD,httpRequest.responseText);
              // alert(httpRequest.responseText);
               document.getElementById("TARGET"+Marketid).value  =httpRequest.responseText;
               
               document.getElementById('uploading').style.display = "none";
                return true;
            	 
            },
            onError:function(x){   //提交失败回调
            	alert("Error="+x.statusText);
            } 
        } 
	); 
	return false;
} 

</script>
<script type="text/javascript"> 
 function setAllVs(Marketid)
  { 
  var  resultVs=0;// 
  var  ACH_ALLVs=0;// 
  var  NTS_ALLVs=0;// 
  var  XSZZ_ALLVs=0;// 
  var  KPI_Count=0;
  //document.getElementById(objName+"YJ").innerHTML="";
  <%
	  String  intYear=  request.getAttribute("intYear")==null?"":  request.getAttribute("intYear").toString();
 
  	%>
  	for(var n=1;n<13;n++)
  	{ 
	  	var ACH= "";// document.getElementsByName("ACH"+Marketid+"<%=intYear%>"+n)[0].value ;
	  	 if(ACH==""||ACH=="NaN"||ACH==null||ACH==NaN)
	  	 { 
	  	   ACH=0;
	  	 }
	  	var RESULT= document.getElementsByName("RESULT"+Marketid+"<%=intYear%>"+n)[0].value ;
	  	 if(RESULT==""||RESULT=="NaN"||RESULT==null||RESULT==NaN)
	  	 { 
	  	   RESULT=0;
	  	 }
	  	 document.getElementsByName("XSYC_NEXT"+Marketid+"<%=intYear%>"+n)[0].value =RESULT;
	  	 
	  	 KPI_Count;
	  	var XSZZ= "";//document.getElementsByName("XSZZ"+Marketid+"<%=intYear%>"+n)[0].value ;
	  	 if(XSZZ==""||XSZZ=="NaN"||XSZZ==null||XSZZ==NaN)
	  	 { 
	  	   XSZZ=0;
	  	 }
	  	// document.getElementsByName("COMPANYKPI"+Marketid+"<%=intYear%>"+n)[0].value=RESULT;
	  	var KPI= "";//document.getElementsByName("COMPANYKPI"+Marketid+"<%=intYear%>"+n)[0].value ;
	  	 if(KPI==""||KPI=="NaN"||KPI==null||KPI==NaN)
	  	 { 
	  	   KPI=0;
	  	 }
	      //resultVs= resultVs+	parseInt(vs);
	    
	        KPI_Count= parseFloat(FloatAdd( parseFloat(KPI_Count),KPI).toFixed(0));
	        
	        ACH_ALLVs= parseFloat(FloatAdd( parseFloat(ACH),ACH_ALLVs).toFixed(1));
	        NTS_ALLVs= parseFloat(FloatAdd( parseFloat(RESULT),NTS_ALLVs).toFixed(0));
	        XSZZ_ALLVs= parseFloat(FloatAdd( parseFloat(XSZZ),XSZZ_ALLVs).toFixed(0));
	     
    }
  	<%
  	   
  %> 
 
    // document.getElementById("ACH_ALL"+Marketid).value=parseFloat(NTS_ALLVs/KPI_Count*100).toFixed(1); //倾向性
     document.getElementById("NTS_ALL"+Marketid).value=parseFloat(NTS_ALLVs).toFixed(0); 
   // document.getElementById("XSZZ_ALL"+Marketid).value=parseFloat(XSZZ_ALLVs).toFixed(0); 
 
 }
 
   <%
  String  quYuDaiBiao=  request.getAttribute("quYuDaiBiao")==null?"":  request.getAttribute("quYuDaiBiao").toString();
  String  quYuDaiBiaos[]=   quYuDaiBiao.split(",");
  if(!"1".equals( strType))
  {
	for (int i = 0; i < quYuDaiBiaos.length; i++) 
	{
  	  String strID = quYuDaiBiaos[i];
  	  if(strID!="")
  	  { 
  	%>
     	setAllVs("<%=strID%>");
  	
  	<%}}}%>
</script>
<script type="text/javascript">
   
 
</script>
