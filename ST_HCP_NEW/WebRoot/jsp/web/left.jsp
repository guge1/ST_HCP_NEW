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
%>
 
<html>
	<head>

		<title>医院管理实战模拟</title> 
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
	      <base target="rightFrame" />
	    <script type="text/javascript">
function setTab(name,curnum,n){
    for(var i=1 ; i<=n ; i++)
    { 
	    var menu=document.getElementById(name+i);
		//var con=document.getElementById("con_"+name+"_"+i);
		menu.className = (i == curnum ? "active":"");
	//con.className = i == curnum ? 'dis':'undis'
	}
}
</script>   <style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
.STYLE_2 {color:#FCAE18; font-size: 12px; }
 
.STYLE2 {color: gray; font-size: 12px; }
 a {   TEXT-DECORATION: none;/*underline*/}
.STYLE2  a{color: gray; font-size: 12px; }
-->
</style>
    <script type="text/JavaScript">
<!--
        function MM_preloadImages() { //v3.0
            var d = document; if (d.images) {
                if (!d.MM_p) d.MM_p = new Array();
                var i, j = d.MM_p.length, a = MM_preloadImages.arguments; for (i = 0; i < a.length; i++)
                    if (a[i].indexOf("#") != 0) { d.MM_p[j] = new Image; d.MM_p[j++].src = a[i]; }
            }
        }

        function MM_swapImgRestore() { //v3.0
            var i, x, a = document.MM_sr; for (i = 0; a && i < a.length && (x = a[i]) && x.oSrc; i++) x.src = x.oSrc;
        }

        function MM_findObj(n, d) { //v4.01
            var p, i, x; if (!d) d = document; if ((p = n.indexOf("?")) > 0 && parent.frames.length) {
                d = parent.frames[n.substring(p + 1)].document; n = n.substring(0, p);
            }
            if (!(x = d[n]) && d.all) x = d.all[n]; for (i = 0; !x && i < d.forms.length; i++) x = d.forms[i][n];
            for (i = 0; !x && d.layers && i < d.layers.length; i++) x = MM_findObj(n, d.layers[i].document);
            if (!x && d.getElementById) x = d.getElementById(n); return x;
        }

        function MM_swapImage() { //v3.0
            var i, j = 0, x, a = MM_swapImage.arguments; document.MM_sr = new Array; for (i = 0; i < (a.length - 2); i += 3)
                if ((x = MM_findObj(a[i])) != null) { document.MM_sr[j++] = x; if (!x.oSrc) x.oSrc = x.src; x.src = a[i + 2]; }
        }
//-->

function setUrl(url) {
	window.parent.document.getElementById("rightFrame").src = url;
}
    </script>
<link rel="stylesheet" href="<%=basePath%>skins/yellow2/css/style.css" type="text/css"></link>
</head>
<body 
    style="overflow: hidden;background-color: White;">
    <div class="guanli common">
         <h2><span>管理选项</span></h2>
         <ul>
            <li><a href="<%=basePath%>queryZongTi_FenXi.action" id="news1" onclick="setTab('news',1,11)" class="active"><span style="cursor: hand;">总体分析</span></a></li>
            <li><a href="<%=basePath%>queryQianLi_FenXi.action" id="news2" onclick="setTab('news',2,11)"><span style="cursor: hand;">潜力分析</span></a></li>
            <li><a href="<%=basePath%>queryJieGuo_FenXi.action" id="news3" onclick="setTab('news',3,11)"><span style="cursor: hand;">倾向性分析</span></a></li>
            
            <li><a href="<%=basePath%>queryYouXiaoXing_FenXi.action" id="news4" onclick="setTab('news',4,11)"><span style="cursor: hand;">处方观念分析</span></a></li>
            <li><a href="<%=basePath%>queryChanChu_MuBiao.action" id="news5" onclick="setTab('news',5,11)"><span style="cursor: hand;">产出目标</span></a></li>
            <li><a href="<%=basePath%>queryTouRu_MuBiao.action" id="news6" onclick="setTab('news',6,11)"><span style="cursor: hand;">目标投入</span></a></li>
            <li><a href="<%=basePath%>queryZiYuan_FenPei.action" id="news7" onclick="setTab('news',7,11)"><span style="cursor: hand;">资源分配</span></a></li>
            <li><a href="<%=basePath%>queryXingDong_JiHua.action" id="news8" onclick="setTab('news',8,11)"><span style="cursor: hand;">行动计划</span></a></li>
            <li><a href="<%=basePath%>queryMonth_YuCe.action" id="news9" onclick="setTab('news',9,11)"><span style="cursor: hand;">预测对照</span></a></li>
            <li><a href="<%=basePath%>queryYueFen_JianKong.action" id="news10" onclick="setTab('news',10,11)"><span style="cursor: hand;">下月监控</span></a></li>
            <li><a href="<%=basePath%>queryNextYueFen_JianKong.action?type=1" id="news11" onclick="setTab('news',11,11)"><span style="cursor: hand;">后月监控</span></a></li>
         </ul>
      </div> 
    <div style="overflow: hidden;display:none;">
        <table width="177" height="100%" border="0" cellpadding="0" cellspacing="0">
            <tr>
                <td valign="top">
                    <table width="100%" border="0" cellspacing="0" cellpadding="0" style="table-layout: fixed">
                        <tr>
                            <td height="26" background="<%=basePath%>jsp/web/images/main_21.gif">
                                &nbsp;
                            </td>
                        </tr>
                        <tr style="display: none;">
                            <td height="80" style="background-image: url(<%=basePath%>jsp/web/images/main_23.gif); background-repeat: repeat-x;">
                                <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
                                    <tr>
                                        <td height="45">
                                            <div align="center">
                                                <a href="<%=basePath%>queryZongTi_FenXi.action" target="rightFrame">
                                                    <img src="<%=basePath%>jsp/web/images/main_26.gif" name="Image1" width="40" height="40" border="0" id="Image1"
                                                        onmouseover="MM_swapImage('Image1','','<%=basePath%>jsp/web/images/main_26_1.gif',1)" onmouseout="MM_swapImgRestore()" /></a></div>
                                        </td>
                                        <td>
                                            <div align="center">
                                                <a href="<%=basePath%>queryCase.action" target="rightFrame">
                                                    <img src="<%=basePath%>jsp/web/images/main_28.gif" name="Image2" width="40" height="40" border="0" id="Image2"
                                                        onmouseover="MM_swapImage('Image2','','<%=basePath%>jsp/web/images/main_29_1.gif',1)" onmouseout="MM_swapImgRestore()" /></a></div>
                                        </td>
                                        <td>
                                            <div align="center">
                                                <a href="<%=basePath%>queryZongTi_FenXi.action" target="rightFrame">
                                                    <img src="<%=basePath%>jsp/web/images/main_31.gif" name="Image3" width="40" height="40" border="0" id="Image3"
                                                        onmouseover="MM_swapImage('Image3','','<%=basePath%>jsp/web/images/main_31_1.gif',1)" onmouseout="MM_swapImgRestore()" /></a></div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td height="25">
                                            <div align="center" class="STYLE2">
                                                <a href="<%=basePath%>queryZongTi_FenXi.action" target="rightFrame">实战模拟</a></div>
                                        </td>
                                        <td>
                                            <div align="center" class="STYLE2">
                                                <a href="<%=basePath%>queryCase.action" target="rightFrame">典型案例</a></div>
                                        </td>
                                        <td>
                                            <div align="center" class="STYLE2">
                                                <a href="<%=basePath%>queryZongTi_FenXi.action" target="rightFrame">基础数据</a></div>
                                        </td>
                                    </tr>
                                </table>
                            </td>
                        </tr>
                        <tr>
                            <td style="line-height: 4px; background: url(<%=basePath%>jsp/web/images/main_38.gif)">
                                &nbsp;
                            </td>
                        </tr>
                        <tr>
                            <td style="height: 100%;">
                                <div style="  overflow: auto; overflow-x: hidden;
                                    height:expression(document.body.clientHeight-10);  ">
                                    <table width="130" border="0" align="center" cellpadding="0" cellspacing="0">
                                        <tr  >
                                            <td width="21" height="35">
                                                <div align="center">
                                                    <img id="img_1" src="<%=basePath%>jsp/web/images/left_2.gif" width="31" height="31"></div>
                                            </td>
                                            <td width="89" height="35" id="td_1">
                                                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                                    <tr>
                                                        <td height="23" class="onMouseTd" >
                                                          <span class="STYLE2">&nbsp;<a href="<%=basePath%>queryZongTi_FenXi.action" target="rightFrame">总体分析</a></span><!--
                                                       
                                                            <span id="span_1" class="STYLE2">&nbsp;总体分析</span>
                                                        --></td>
                                                    </tr>
                                                </table>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td width="21" height="35">
                                                <div align="center">
                                                    <img  id="img_3"  src="<%=basePath%>jsp/web/images/left_2.gif" width="31" height="31"></div>
                                            </td>
                                            <td height="35">
                                                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                                    <tr>
                                                        <td height="23"  class="onMouseTd" >
                                                            <span class="STYLE2">&nbsp;<a href="<%=basePath%>queryQianLi_FenXi.action" target="rightFrame">潜力分析</a></span>
                                                        </td>
                                                    </tr>
                                                </table>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td width="21" height="35">
                                                <div align="center">
                                                    <img id="img_2"  src="<%=basePath%>jsp/web/images/left_2.gif" width="31" height="31"></div>
                                            </td>
                                            <td height="35">
                                                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                                    <tr>
                                                        <td height="23"  class="onMouseTd" >
                                                            <span class="STYLE2">&nbsp;<a href="<%=basePath%>queryJieGuo_FenXi.action" target="rightFrame">倾向性分析</a></span>
                                                        </td>
                                                    </tr>
                                                </table>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td width="21" height="35">
                                                <div align="center">
                                                    <img  id="img_4"  src="<%=basePath%>jsp/web/images/left_2.gif" width="31" height="31"></div>
                                            </td>
                                            <td height="35">
                                                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                                    <tr>
                                                        <td height="23" class="onMouseTd" >
                                                            <span class="STYLE2">&nbsp;<a href="<%=basePath%>queryYouXiaoXing_FenXi.action" target="rightFrame">处方观念分析</a></span>
                                                        </td>
                                                    </tr>
                                                </table>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td width="21" height="35">
                                                <div align="center">
                                                    <img  id="img_5"  src="<%=basePath%>jsp/web/images/left_2.gif" width="31" height="31"></div>
                                            </td>
                                            <td height="35">
                                                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                                    <tr>
                                                        <td height="23"  class="onMouseTd" >
                                                            <span class="STYLE2">&nbsp;<a href="<%=basePath%>queryChanChu_MuBiao.action" target="rightFrame">产出目标</a></span>
                                                        </td>
                                                    </tr>
                                                </table>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td width="21" height="35">
                                                <div align="center">
                                                    <img  id="img_6"  src="<%=basePath%>jsp/web/images/left_2.gif" width="31" height="31"></div>
                                            </td>
                                            <td height="35">
                                                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                                    <tr>
                                                        <td height="23"  class="onMouseTd" >
                                                            <span class="STYLE2">&nbsp;<a href="<%=basePath%>queryTouRu_MuBiao.action" target="rightFrame">投入目标</a></span>
                                                        </td>
                                                    </tr>
                                                </table>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td width="21" height="35">
                                                <div align="center">
                                                    <img  id="img_7"  src="<%=basePath%>jsp/web/images/left_2.gif" width="31" height="31"></div>
                                            </td>
                                            <td height="35">
                                                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                                    <tr>
                                                        <td height="23"  class="onMouseTd" >
                                                            <span class="STYLE2">&nbsp;<a href="<%=basePath%>queryZiYuan_FenPei.action" target="rightFrame">资源分配</a></span>
                                                        </td>
                                                    </tr>
                                                </table>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td width="21" height="35">
                                                <div align="center">
                                                    <img  id="img_8"  src="<%=basePath%>jsp/web/images/left_2.gif" width="31" height="31"></div>
                                            </td>
                                            <td height="35">
                                                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                                    <tr>
                                                        <td height="23"  class="onMouseTd" >
                                                            <span class="STYLE2">&nbsp;<a href="<%=basePath%>queryXingDong_JiHua.action" target="rightFrame">行动计划</a></span>
                                                        </td>
                                                    </tr>
                                                </table>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td width="21" height="35">
                                                <div align="center">
                                                    <img  id="img_9"  src="<%=basePath%>jsp/web/images/left_2.gif" width="31" height="31"></div>
                                            </td>
                                            <td height="35">
                                                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                                    <tr>
                                                        <td height="23"  class="onMouseTd" >
                                                            <span class="STYLE2">&nbsp;<a href="<%=basePath%>queryMonth_YuCe.action" target="rightFrame">预测对照</a></span>
                                                        </td>
                                                    </tr>
                                                </table>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td width="21" height="35">
                                                <div align="center">
                                                    <img  id="img_10"  src="<%=basePath%>jsp/web/images/left_2.gif" width="31" height="31"></div>
                                            </td>
                                            <td height="35">
                                                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                                    <tr>
                                                        <td height="23"  class="onMouseTd" >
                                                            <span class="STYLE2">&nbsp;<a href="<%=basePath%>queryYueFen_JianKong.action" target="rightFrame">下月监控</a></span>
                                                        </td>
                                                    </tr>
                                                </table>
                                            </td>
                                        </tr>
                                        <tr style="display: ;">
                                            <td width="21" height="35">
                                                <div align="center">
                                                    <img id="img_11"  src="<%=basePath%>jsp/web/images/left_2.gif" width="31" height="31"></div>
                                            </td>
                                            <td height="35">
                                                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                                    <tr>
                                                        <td height="23"  class="onMouseTd" >
                                                            <span class="STYLE2">&nbsp;<a href="<%=basePath%>queryNextYueFen_JianKong.action?type=1" target="rightFrame">后月监控</a></span>
                                                        </td>
                                                    </tr>
                                                </table>
                                            </td>
                                        </tr>
                                    </table>
                                </div>
                            </td>
                        </tr>
                    </table>
                </td>
            </tr>
        </table>
    </div> 
	</body>
</html>
<script type="text/javascript">
<%
String[] strLeftUrl=Source.strLeftUrl;
 int SaveStepID= request.getAttribute("intStepID")==null||request.getAttribute("intStepID")==""?1:Integer.parseInt(request.getAttribute("intStepID").toString())  ;
 String strID="";
 SaveStepID=0;
	for (int i = 1; i < SaveStepID+1; i++) 
	{  
      strID= String.valueOf(i);
      
   %>
   var strLeftUrl="<%=strLeftUrl[i]%>";
     document.getElementById("img_<%=i %>").src="<%=basePath%>jsp/web/images/left_2.gif";
     var  tdObj=document.getElementById("td_<%=i %>");
     tdObj.style.cursor="hand";
      tdObj.onmouseover=function()
      {
        this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#adb9c2';
      }
      tdObj.onmouseout=function()
      {
        this.style.backgroundImage='url()';this.style.borderStyle='none'
      }
      tdObj.onclick=function()
      {
        setUrl(strLeftUrl);
      } 
      document.getElementById("span_<%=i %>").className="STYLE_2";
   <% 
 
 }  
 %>
</script>

<script type="text/javascript">
  document.getElementsByClassName = function(){
        var tTagName ="*";
        if(arguments.length > 1){
            tTagName = arguments[1];
        }
        if(arguments.length > 2){
            var pObj = arguments[2]
        }
        else{
            var pObj = document;
         }
        var objArr = pObj.getElementsByTagName(tTagName);
        var tRObj = [];
        for(var i=0; i<objArr.length; i++){
            if(objArr[i].className == arguments[0]){
             tRObj.push(objArr[i]);
            }
        } 
        return tRObj;
   } 
function resetOnSelectTd()
{
	var  objTd=	 document.getElementsByClassName("onMouseTd");
	for (var i = 0; i < objTd.length; i++) 
	{
		var  obj= objTd[i]; 
		obj.style.cursor="hand";
         obj.onmouseover=function()
         {
            this.style.borderStyle='solid';
            this.style.borderWidth='1';
            if(this.borderColor!='#ff0000')
            {
              this.borderColor='#adb9c2'; 
            }
         }
         obj.onmouseout=function()
         {
            this.style.backgroundImage='url()';
            if(this.borderColor!='#ff0000')
            {
              this.borderColor='#adb9c2'; 
              this.style.borderStyle='none' 
            }
         }
         obj.onclick=function()
         { 
            setClickTd(this);
         }
    }
} 	
function setClickTd(clickObj)
{
	var  objTd=	 document.getElementsByClassName("onMouseTd");
	for (var i = 0; i < objTd.length; i++) 
	{
		var  obj= objTd[i]; 
		 
         if(clickObj==obj)
         {
            obj.style.borderStyle='solid';
            obj.style.borderWidth='1';
            obj.borderColor='#ff0000'; 
         }else
         {
           obj.style.backgroundImage='url()';
           obj.style.borderStyle='none' 
           obj.borderColor='#adb9c2'; 
         }
    }
} 	

function setOnSelectTd(flag)
{
 flag=parseInt(flag)+1;
setTab('news',flag,11);

return;
	var  objTd=	 document.getElementsByClassName("onMouseTd");
	for (var i = 0; i < objTd.length; i++) 
	{
		var  obj= objTd[i];  
         if(i==flag)
         {
            obj.style.borderStyle='solid';
            obj.style.borderWidth='1';
            obj.borderColor='#ff0000'; 
         }else
         {
           obj.style.backgroundImage='url()';
           obj.style.borderStyle='none' 
           obj.borderColor='#adb9c2'; 
         }
    }
} 	
function setOnSelectTd_old(flag)
{
	setTab('news',flag,11);
} 	
function setTdStatus(flag)
{
	var  objTd=	 document.getElementsByClassName("onMouseTd");
	for (var i = 0; i < objTd.length; i++) 
	{
		var  obj= objTd[i]; 
		var span=objTd[i].childNodes[0];
	   alert(	span.item[0]);
		//span.className="STYLE_2";
		// alert(span.innerHTML);
          // span.style.borderColor='red'; 
         if(i<=flag)
         {
         span.className="STYLE_2"; 
         }else
         {
         span.className="STYLE2"; 
         }
    }
} 	
//resetOnSelectTd();	
setOnSelectTd('0');	 
//setTdStatus(2);
</script>
