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
    <title>潜力设置 </title>
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
		<script type="text/javascript">
function save() {
	document.forms[0].action = "<%=request.getContextPath()%>/saveMarketSize.action";
	document.forms[0].submit();

}
</script>
</head>
<body >
   <form name="form1" method="post" action="" id="form1"  style="margin-right:0px;padding:0px;width:100%;">
 
	 <div style="text-align:center;width:100%;background:#FFFFFF;">
       <div id="con_article_1" style="border:1px solid #F8C069;margin:0px auto;width:981px;text-align:center;background:#FFFFFF;" >
    <div class="Btntoolbar">
        <table style="width: 100%;">
            <tr>
                <td>
                </td>
            </tr>
            <tr>
                <td style="width: 100%;">
                    <div style="" class="Btntoolbar_left">
                        &nbsp;&nbsp;潜力设置</div>
                    <div style="" class="Btntoolbar_right">
                        
                        <input type="button" name="btnSave1" value="保存" onclick="save()"
                            id="Submit1"  style="display: ;"   class="pt_vLong_button" />      <input type="button" value="返回"
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
									<%=request.getAttribute("headRow")==null?"":request.getAttribute("headRow").toString()%>
									<%=request.getAttribute("filedHtml")==null?"":request.getAttribute("filedHtml").toString()%>
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
 
</script>
