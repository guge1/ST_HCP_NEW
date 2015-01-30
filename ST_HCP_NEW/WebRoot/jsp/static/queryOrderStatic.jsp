<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<html >
<head>
<title>表二：客户优先顺序排序	</title>

		<base target="_self" />
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<script language="javascript" type="text/javascript"
			src="<%=request.getContextPath()%>/jsp/Market/js/WinOpen.js">
</script>

 <%
 	String intYear_s =   request.getParameter("intYear")==null?"":request.getParameter("intYear").toString() ;
	String intMonth_s =    request.getParameter("intMonth")==null?"":request.getParameter("intMonth").toString();
 
		String  strpreInt=request.getParameter("preInt")==null?"3":request.getParameter("preInt").toString();
 %>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
.STYLE2{font-size: 14px;
background-color: white;
background-image:../web/tab/images/tab_14.gif;
  }
  .STYLE1{
       font-size: 14px; 
  }
.STYLE4 {
	font-size: 12px;
	color: #1F4A65;
	font-weight: bold;
}

a:link {
	font-size: 12px;
	color: #06482a;
	text-decoration: none;

}
a:visited {
	font-size: 12px;
	color: #06482a;
	text-decoration: none;
}
a:hover {
	font-size: 12px;
	color: #FF0000;
	text-decoration: underline;
}
a:active {
	font-size: 12px;
	color: #FF0000;
	text-decoration: none;
}
.STYLE7 {font-size: 12}
.caserow{height:18px;font-size: 12px}
-->

.caserow  td
{

   height:26; 
   background-color: #FFFFFF;
}
</style>

<script>
var  highlightcolor='#eafcd5';
//此处clickcolor只能用win系统颜色代码才能成功,如果用#xxxxxx的代码就不行,还没搞清楚为什么:(
var  clickcolor='#51b2f6';
function  changeto(){
source=event.srcElement;
if  (source.tagName=="TR"||source.tagName=="TABLE")
return;
while(source.tagName!="TD")
source=source.parentElement;
source=source.parentElement;
cs  =  source.children;
//alert(cs.length);
if  (cs[1].style.backgroundColor!=highlightcolor&&source.id!="nc"&&cs[1].style.backgroundColor!=clickcolor)
for(i=0;i<cs.length;i++){
	cs[i].style.backgroundColor=highlightcolor;
}
}

function  changeback(){
if  (event.fromElement.contains(event.toElement)||source.contains(event.toElement)||source.id=="nc")
return
if  (event.toElement!=source&&cs[1].style.backgroundColor!=clickcolor)
//source.style.backgroundColor=originalcolor
for(i=0;i<cs.length;i++){
	cs[i].style.backgroundColor="";
}
}

function  clickto(){
source=event.srcElement;
if  (source.tagName=="TR"||source.tagName=="TABLE")
return;
while(source.tagName!="TD")
source=source.parentElement;
source=source.parentElement;
cs  =  source.children;
//alert(cs.length);
if  (cs[1].style.backgroundColor!=clickcolor&&source.id!="nc")
for(i=0;i<cs.length;i++){
	cs[i].style.backgroundColor=clickcolor;
}
else
for(i=0;i<cs.length;i++){
	cs[i].style.backgroundColor="";
}
}
</script>	<link
			href="<%=request.getContextPath()%>/jsp/style_dark/StyleSheet.css"
			rel="stylesheet" type="text/css" />
</head>

<body>
<%

 String   usertype= request.getAttribute("usertype")==null?"": request.getAttribute("usertype").toString();
 String strStatus="display: none;";
  if("1".equals(usertype))
  {//管理员
      strStatus="";
  }
 %>
  <form name="form1" method="post" action="" id="form1"  style="margin-right:0px;padding:0px;width:100%;">
 
	 <div style="text-align:center;width:100%;background:#FFFFFF;">
       <div id="con_article_1" style="border:1px solid #F8C069;margin:0px auto;width:981px;text-align:center;background:#FFFFFF;" >
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="30"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="15" height="30"><img src="<%=request.getContextPath()%>/jsp/web/tab/images/tab_03.gif" width="15" height="30" /></td>
        <td width="*" background="<%=request.getContextPath()%>/jsp/web/tab/images/tab_05.gif"><img src="<%=request.getContextPath()%>/jsp/web/tab/images/311.gif" width="16" height="16" /> <span class="STYLE4">表二：客户优先顺序排序	</span></td>
        <td width="*" background="<%=request.getContextPath()%>/jsp/web/tab/images/tab_05.gif"><table border="0" align="right" cellpadding="0" cellspacing="0">
            <tr>
              <td width="60"><table width="87%" border="0" cellpadding="0" cellspacing="0">
	                  <tr>
	                    <td class="STYLE1"><div align="center"><!--
	                        <input type="checkbox" name="checkbox62" value="checkbox" />
	                    --></div></td>
	                    <td class="STYLE1"><!--<div align="center">全选</div>--></td>
	                  </tr>
	              </table>
              </td>
           
               <td class="STYLE1"><div align="center">
					 <select name="preInt" onchange="searchCase()">
					        <option value="3" <%=("3".equals(strpreInt))?"selected=\"selected\"":"" %> >第一轮</option>
					        <option value="0" <%=("0".equals(strpreInt))?"selected=\"selected\"":"" %> >第二轮</option>
					        <option value="1" <%=("1".equals(strpreInt))?"selected=\"selected\"":"" %> >第三轮</option>
					        <option value="2" <%=("2".equals(strpreInt))?"selected=\"selected\"":"" %> >第四轮</option>
					    </select>
					</div>
					</td>
              <td width="80">
                <table width="100%" border="0" cellpadding="0" cellspacing="0">
                  <tr>
                    <td class="STYLE1"><input type="button" value="返回" onclick="javascript:window.location.href='<%=request.getContextPath()%>/jsp/static/userStatic.jsp';"
									class="pt_Long_button"  />
							</td>
                  </tr>
              </table>
              </td>
              
            <!--  <td width="60"><table width="90%" border="0" cellpadding="0" cellspacing="0">
                  <tr>
                    <td class="STYLE1"><div align="center"><img src="<%=request.getContextPath()%>/jsp/web/tab/images/114.gif" width="14" height="14" /></div></td>
                    <td class="STYLE1"><div align="center">修改</div></td>
                  </tr>
              </table></td>
              <td width="52"><table width="88%" border="0" cellpadding="0" cellspacing="0">
                  <tr>
                    <td class="STYLE1"><div align="center"><img src="<%=request.getContextPath()%>/jsp/web/tab/images/083.gif" width="14" height="14" /></div></td>
                    <td class="STYLE1"><div align="center">删除</div></td>
                  </tr>
              </table></td>
              --> 
            </tr>
        </table></td>
        <td width="14"><img src="<%=request.getContextPath()%>/jsp/web/tab/images/tab_07.gif" width="14" height="30" /></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td>
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="9" background="<%=request.getContextPath()%>/jsp/web/tab/images/tab_12.gif">&nbsp;</td>
        <td bgcolor="#f3ffe3">
        <div style="height: expression(document.body.clientHeight-43); overflow: auto;width: 960px;"> 
	        <table width="1200px" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#c0de98" onmouseover="changeto()"  onmouseout="changeback()">
	         
	          <%=request.getAttribute("PageContent")%>
	          
	        </table></div></td>
        <td width="9" background="<%=request.getContextPath()%>/jsp/web/tab/images/tab_16.gif">&nbsp;</td>
      </tr>
    </table>
    
    
    </td>
  </tr> 
  <tr >
    <td height="29"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="15" height="29"><img src="<%=request.getContextPath()%>/jsp/web/tab/images/tab_20.gif" width="15" height="29" /></td>
        <td background="<%=request.getContextPath()%>/jsp/web/tab/images/tab_21.gif">
         <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr><td></td> 
            <td width="25%" height="29" nowrap="nowrap"><span class="STYLE1">&nbsp;<!--共120条纪录，当前第1/10页，每页10条纪录--></span></td>
            <td width="75%" valign="top" class="STYLE1"><div align="right"><!--
              <table width="352" height="20" border="0" cellpadding="0" cellspacing="0">
                <tr><td></td>
                  <td width="62" height="22" valign="middle"><div align="right"><img src="images/first.gif" width="37" height="15" /></div></td>
                  <td width="50" height="22" valign="middle"><div align="right"><img src="images/back.gif" width="43" height="15" /></div></td>
                  <td width="54" height="22" valign="middle"><div align="right"><img src="images/next.gif" width="43" height="15" /></div></td>
                  <td width="49" height="22" valign="middle"><div align="right"><img src="images/last.gif" width="37" height="15" /></div></td>
                  <td width="59" height="22" valign="middle"><div align="right">转到第</div></td>
                  <td width="25" height="22" valign="middle"><span class="STYLE7">
                    <input name="textfield" type="text" class="STYLE1" style="height:10px; width:25px;" size="5" />
                  </span></td>
                  <td width="23" height="22" valign="middle">页</td>
                  <td width="30" height="22" valign="middle"><img src="images/go.gif" width="37" height="15" /></td>
                </tr>
              </table>
            --></div></td>
          </tr>
        </table> </td>
        <td width="14"><img src="<%=request.getContextPath()%>/jsp/web/tab/images/tab_22.gif" width="14" height="29" /></td>
      </tr>
    </table></td>
  </tr>
 </table>
 </div>
 </div>
 </form>
<script language="JavaScript">

function  editMarketSize()
{ 	   
    
	document.forms[0].action = "<%=request.getContextPath()%>/editMarketSize.action";
	document.forms[0].submit();
} 
function  editBiaoZhun()
{ 	   
    
	document.forms[0].action = "<%=request.getContextPath()%>/editBiaoZhun.action";
	document.forms[0].submit();
} 
function  editHistory(type)
{ 	   
    var  intYear=document.form1.YYYY.value  ;
    var  intMonth =document.form1.MM.value  ;
	document.forms[0].action = "<%=request.getContextPath()%>/editHostory.action?intYear="+intYear+"&intMonth="+intMonth+"&type="+type;
	document.forms[0].submit();
} 

function  editCase(url)
{ 	  
	g_OpenModalReturnWindow(url,480,360);
	searchCase();
} 
function  deleteCase(url)
{ 
	document.forms[0].action = url;
	document.forms[0].submit();
}  

function  insertCase()
{
    var  intYear=document.form1.YYYY.value  ;
    var  intMonth =document.form1.MM.value  ;
	document.forms[0].action = "<%=request.getContextPath()%>/insertCase.action?intYear="+intYear+"&intMonth="+intMonth;
	document.forms[0].submit();
}
function  searchCase()
{
    var  preInt=document.form1.preInt.value  ;
	document.forms[0].action = "<%=request.getContextPath()%>/queryOrderStatic.action?preInt="+preInt;
	document.forms[0].submit();
}
 
 function  updateCase(url)
{ 
	document.forms[0].action = url;
	document.forms[0].submit();
}
    
   var Nowdate=new Date(); 
  
   Nowdate.setMonth(Nowdate.getMonth() + 1);
    Nowdate= new Date(Nowdate.getFullYear(),Nowdate.getMonth(),1); 

   

   var y = Nowdate.getFullYear();
    var x = Nowdate.getMonth() + 1;
    y=2011,x=1;
   function  loadSet() 
   {
    strYYYY = document.form1.YYYY.outerHTML;
    strMM = document.form1.MM.outerHTML;
   // strDD = document.form1.DD.outerHTML;
    MonHead = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];
    //先给年下拉框赋内容
   
    var str = strYYYY.substring(0, strYYYY.length - 9);
    for (var i =  (y + 1); i >(y - 5); i--) //以今年为准，前30年，后30年
    {
        str += "<option value='" + i + "'> " + i + " 年" + "</option>\r\n";
    }
    document.form1.YYYY.outerHTML = str + "</select>";
    //赋月份的下拉框
    //var str = strMM.substring(0, strMM.length - 9);
    //for (var i = 1; i < 13; i++) {
      //  str += "<option value='" + i + "'> " + i + " 月" + "</option>\r\n";
    //}
    
   // document.form1.MM.outerHTML = str + "</select>"; 
    if("<%=intYear_s%>"!="")
    {
      y="<%=intYear_s%>";
    }
    if("<%=intMonth_s%>"!="")
    {
      x="<%=intMonth_s%>";
    }
    document.form1.YYYY.value = y;
    document.form1.MM.value = x;
    var n = MonHead[new Date().getMonth()];
    if (new Date().getMonth() == 1 && IsPinYear(y)) n++;
   //writeDay(n); //赋日期下拉框 
}
function YYYYMM(str) //年发生变化时日期发生变化(主要是判断闰平年)
{
   
}
function MMDD(str) //月发生变化时日期联动
{
   
}
 
function IsPinYear(year) //判断是否闰平年
{
    return (0 == year % 4 && (year % 100 != 0 || year % 400 == 0))
} 
//loadSet();
 </script>
</body>
</html>

