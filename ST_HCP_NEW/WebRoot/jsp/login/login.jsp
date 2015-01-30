
<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>医药代表业务计划与战术管理</title>
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

<link rel="stylesheet" href="<%=basePath %>skins/yellow/css/longin.css" type="text/css"></link>



<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	overflow:hidden;
}
.STYLE3 {color: #528311; font-size: 12px; }
.STYLE4 {
	color: #42870a;
	font-size: 12px;

}
#name{
  height:18px; width:130px; border:solid 1px #cadcb2; font-size:12px; color:#81b432; 
}
-->

</style>
<script type="text/javascript">
//当回车按下时,/=47,*=42,+=43
function keypress(form0)
{
	if(event.keyCode==13||event.keyCode==42)	//回车,*
	{
		form_Submit();
	}
}
function form_Submit()
{ 
  if(document.getElementsByName("name")[0].value=="")
  {
    alert("用户名不能为空!");
    return false;
  }
  if(document.getElementsByName("password")[0].value=="")
  {
    alert("用户密码不能为空!");
    return false;
  }
       document.forms[0].action ="<%=basePath %>logon.action";  
	   document.forms[0].submit();   
 }
function resetName()
{ 
 document.getElementsByName("name")[0].value="";
 document.getElementsByName("password")[0].value="";
 }
</script>
</head>

<body onkeydown="keypress(this);" style="overflow: hidden;">
 <s:form action="logon.action" method="post" id="form1">
  
<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
  <tr height="33px">
    <td bgcolor="#e5f6cf"  class="login_top" >&nbsp;</td>
  </tr>
   
   <tr>
        <td  >
        <table width="100%" border="0" cellspacing="0" cellpadding="0" style="text-align:center;">
          <tr> 
            <td   >
	              <table   border="0" cellspacing="0" cellpadding="0" class="login_body">
		             <tr>
				        <td  >
				        <table width="100%" border="0" cellspacing="0" cellpadding="0" >
				          <tr>
				            <td width="698" height="95" >&nbsp;</td>
				            <td width="261" class="login_back">
					            <table width="100%" border="0" cellspacing="0" cellpadding="0">
					              <tr>
					                <td width="61" height="30"><div align="center"><span class="login_font">用户名：</span></div></td>
					                <td width="200" height="30"><input type="text" name="name"   style="height:25px; width:140px; border:solid 1px #FDAF17; font-size:12px; color:#E78F08;"></td>
					              </tr>
					              <tr>
					                <td height="30"><div align="center"><span class="login_font">密&nbsp;&nbsp;码：</span></div></td>
					                <td height="30"><input type="password" name="password"   style="height:25px; width:140px; border:solid 1px #FDAF17; font-size:12px; color:#E78F08;"><!--
					                <div class="login_btn"></div>
					                
					                --></td>
					              </tr> 
					              <tr>
					                <td height="30">&nbsp;</td>
					                <td height="30"  > <input type="button"  class="loginButton"   onclick="form_Submit()"   value="登录" /><span style="width:48px;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span><input type="button"   class="loginResetButton"  onclick="resetName()"  value="重置"  /></td>
					              </tr>
					            </table>
				            </td>
				            <td width="49" background="">&nbsp;</td>
				          </tr>
				          <tr>
				          
				          <td height="50px"> &nbsp;&nbsp;</td>
				          </tr>
				        </table></td>
				      </tr>
	            </table>
            </td> 
          </tr>
        </table></td>
      </tr>
  
	   <tr >
        <td height="247" valign="top"><br><br></td>
		</tr>
      
    </table> 
<!--<table width="100%" height="0" border="0" cellpadding="0" cellspacing="0">
  <tr class="login_top">
    <td bgcolor="#e5f6cf">&nbsp;</td>
  </tr>
  <tr>
    <td height="608" background="<%=basePath %>jsp/login/images/login_03.gif">
    <table width="862" border="0" align="center" cellpadding="0" cellspacing="0"  background="<%=basePath %>jsp/login/images/login2.gif">
 
      <tr>
        <td height="266"  >&nbsp;</td>
      </tr>
      <tr>
        <td height="95"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="424" height="95" >&nbsp;</td>
            <td width="183" background="<%=basePath %>jsp/login/images/login_07.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="21%" height="30"><div align="center"><span class="STYLE3">用户</span></div></td>
                <td width="79%" height="30"><input type="text" name="name"   style="height:18px; width:130px; border:solid 1px #cadcb2; font-size:12px; color:#81b432;"></td>
              </tr>
              <tr>
                <td height="30"><div align="center"><span class="STYLE3">密码</span></div></td>
                <td height="30"><input type="password" name="password"   style="height:18px; width:130px; border:solid 1px #cadcb2; font-size:12px; color:#81b432;"></td>
              </tr>
              <tr>
                <td height="30">&nbsp;</td>
                <td height="30"  > <input type="button"  class="loginButton"   onclick="form_Submit()"    /><span style="width:48px;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span><input type="button"   class="loginResetButton"  onclick="resetName()"    /></td>
              </tr>
            </table></td>
            <td width="255" background="">&nbsp;</td>
          </tr>
        </table></td>
      </tr>
	   <tr >
        <td height="247" valign="top"><br><br></td>
		</tr>
      <tr style="display:none;">
        <td height="247" valign="top" background="<%=basePath %>jsp/login/images/login_09.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="22%" height="30">&nbsp;</td>
            <td width="56%">&nbsp;</td>
            <td width="22%">&nbsp;</td>
          </tr>
          <tr>
            <td>&nbsp;</td>
            <td height="30"><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="44%" height="20">&nbsp;</td>
                <td width="56%" class="STYLE4"> </td>
              </tr>
            </table></td>
            <td>&nbsp;</td>
          </tr>
        </table></td>
      </tr>
    </table> </td>
  </tr>
  <tr>
    <td bgcolor="#a2d962">&nbsp;</td>
  </tr>
</table>

--><map name="Map"><area shape="rect" coords="3,3,36,19" href="#"><area shape="rect" coords="40,3,78,18" href="#"></map>
    </s:form>
</body>
</html>
