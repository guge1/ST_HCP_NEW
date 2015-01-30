<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	 
		String  struserName=request.getParameter("userName")==null?"":request.getParameter("userName").toString();
	
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
    <title>销售处方观念分析</title>
    <base target="_self" />
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
    <script language="javascript" type="text/javascript" src="js/WinOpen.js"></script>
    <link href="<%=basePath%>jsp/style_dark/styleform.css" rel="stylesheet" type="text/css" />
    <link href="<%=basePath%>jsp/style_dark/StyleSheet.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=basePath%>jsp/Market/js/AjaxX.js"></script></head>
<form>
<div id="divPageContent" class="Div_MainContenStyle" style="width: 100%; height: 100%;">
    <div id="chart">
        <object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,0,0"
            width="800px" height="540px" id="bxt" align="">
            <param name="movie" id="movie" value="FC/radar.swf">
            <param name="quality" value="high">
            <param name="scale" value="noscale">
            <param name="salign" value="LT">
            <param name="bgcolor" value="#FFFFFF">
        </object>
    </div>
</div>
<script>
    function showChart(chtype) {
        var xmlUrl = '<?xml version="1.0" encoding="gb2312"?> '
			+ ' <graph title="销售有效分析图" displaytitle="true" linepoint="false" defaultrow="1" newline="true" graphtitle="value" markposition="top" xName="日期" yName="生产总值" >'
			+ '<Row title="张海鑫" grptype="curve">'
			+ '<column title="3号" value="20" lineTitle="上海股价" endLine="6号"></column>'
			+ '<column title="6号" value="40" lineTitle="上海股价" endLine="9号"></column>'
			+ '<column title="9号" value="60" lineTitle="上海股价" endLine="12号"></column>'
			+ '<column title="12号" value="80" lineTitle="上海股价" endLine="15号"></column>'
			+ '<column title="15号" value="96" lineTitle="上海股价" endLine="18号"></column>'
			+ '<column title="18号" value="70" lineTitle="上海股价" endLine="21号"></column> </Row>'
			+ '<Row title="王胜理" grptype="curve">'
			+ '<column title="3号" value="30" lineTitle="南京股价" endLine="6号"></column>'
			+ '<column title="6号" value="60" lineTitle="南京股价" endLine="9号"></column>'
			+ '<column title="9号" value="90" lineTitle="南京股价" endLine="12号"></column>'
			+ '<column title="12号" value="70" lineTitle="南京股价" endLine="15号"></column>'
			+ '<column title="15号" value="80" lineTitle="南京股价" endLine="18号"></column>'
			+ '<column title="18号" value="90" lineTitle="南京股价" endLine="21号"></column> </Row>'
			+ '<Row title="刘文娟" grptype="curve">'
			+ '<column title="3号" value="40" lineTitle="北京股价" endLine="6号"></column>'
			+ '<column title="6号" value="80" lineTitle="北京股价" endLine="9号"></column>'
			+ '<column title="9号" value="50" lineTitle="北京股价" endLine="12号"></column>'
			+ '<column title="12号" value="70" lineTitle="北京股价" endLine="15号"></column>'
			+ '<column title="15号" value="94" lineTitle="北京股价" endLine="18号"></column>'
			+ '<column title="18号" value="40" lineTitle="北京股价" endLine="21号"></column> </Row>'
			+ '<Row title="邓建" grptype="curve">'
			+ '<column title="3号" value="50" lineTitle="西安股价" endLine="6号"></column>'
			+ '<column title="6号" value="88" lineTitle="西安股价" endLine="9号"></column>'
			+ '<column title="9号" value="80" lineTitle="西安股价" endLine="12号"></column>'
			+ '<column title="12号" value="90" lineTitle="西安股价" endLine="15号"></column>'
			+ '<column title="15号" value="50" lineTitle="西安股价" endLine="18号"></column>'
			+ '<column title="18号" value="66" lineTitle="西安股价" endLine="21号"></column> </Row>'
			+ '<Row title="刘瑞华" grptype="column">'
			+ '<column title="3号" value="60" lineTitle="济南股价" endLine="6号"></column>'
			+ '<column title="6号" value="77" lineTitle="济南股价" endLine="9号"></column>'
			+ '<column title="9号" value="80" lineTitle="济南股价" endLine="12号"></column>'
			+ '<column title="12号" value="40" lineTitle="济南股价" endLine="15号"></column>'
			+ '<column title="15号" value="88" lineTitle="济南股价" endLine="18号"></column>'
			+ '<column title="18号" value="60" lineTitle="济南股价" endLine="21号"></column> </Row>'
			+ '<Row title="何文琪" grptype="column">'
			+ '<column title="3号" value="60" lineTitle="济南股价" endLine="6号"></column>'
			+ '<column title="6号" value="90" lineTitle="济南股价" endLine="9号"></column>'
			+ '<column title="9号" value="90" lineTitle="济南股价" endLine="12号"></column>'
			+ '<column title="12号" value="40" lineTitle="济南股价" endLine="15号"></column>'
			+ '<column title="15号" value="70" lineTitle="济南股价" endLine="18号"></column>'
			+ '<column title="18号" value="60" lineTitle="济南股价" endLine="21号"></column> </Row></graph>';
   
      xmlUrl='<?xml version="1.0" encoding="gb2312"?>   <graph title="销售有效分析图" displaytitle="true" linepoint="false" defaultrow="1" newline="true" graphtitle="value" markposition="top" xName="日期" yName="生产总值" ><Row title="张海鑫" grptype="curve">  <column title="3号" value="2" lineTitle="上海股价0" endLine="6号"></column>  <column title="6号" value="43" lineTitle="上海股价0" endLine="9号"></column>  <column title="9号" value="12" lineTitle="上海股价0" endLine="12号"></column>  <column title="12号" value="2" lineTitle="上海股价0" endLine="15号"></column>  <column title="15号" value="12" lineTitle="上海股价0" endLine="18号"></column>  <column title="18号" value="12" lineTitle="上海股价0" endLine="21号"></column>  </Row><Row title="王胜理" grptype="curve">  <column title="3号" value="25" lineTitle="上海股价1" endLine="6号"></column>  <column title="6号" value="26" lineTitle="上海股价1" endLine="9号"></column>  <column title="9号" value="30" lineTitle="上海股价1" endLine="12号"></column>  <column title="12号" value="27" lineTitle="上海股价1" endLine="15号"></column>  <column title="15号" value="28" lineTitle="上海股价1" endLine="18号"></column>  <column title="18号" value="29" lineTitle="上海股价1" endLine="21号"></column>  </Row><Row title="刘文娟" grptype="curve">  <column title="3号" value="35" lineTitle="上海股价2" endLine="6号"></column>  <column title="6号" value="36" lineTitle="上海股价2" endLine="9号"></column>  <column title="9号" value="40" lineTitle="上海股价2" endLine="12号"></column>  <column title="12号" value="37" lineTitle="上海股价2" endLine="15号"></column>  <column title="15号" value="38" lineTitle="上海股价2" endLine="18号"></column>  <column title="18号" value="39" lineTitle="上海股价2" endLine="21号"></column>  </Row><Row title="邓建" grptype="curve">  <column title="3号" value="44" lineTitle="上海股价3" endLine="6号"></column>  <column title="6号" value="45" lineTitle="上海股价3" endLine="9号"></column>  <column title="9号" value="49" lineTitle="上海股价3" endLine="12号"></column>  <column title="12号" value="46" lineTitle="上海股价3" endLine="15号"></column>  <column title="15号" value="47" lineTitle="上海股价3" endLine="18号"></column>  <column title="18号" value="48" lineTitle="上海股价3" endLine="21号"></column>  </Row><Row title="刘瑞华" grptype="curve">  <column title="3号" value="53" lineTitle="上海股价4" endLine="6号"></column>  <column title="6号" value="54" lineTitle="上海股价4" endLine="9号"></column>  <column title="9号" value="58" lineTitle="上海股价4" endLine="12号"></column>  <column title="12号" value="55" lineTitle="上海股价4" endLine="15号"></column>  <column title="15号" value="56" lineTitle="上海股价4" endLine="18号"></column>  <column title="18号" value="57" lineTitle="上海股价4" endLine="21号"></column>  </Row><Row title="何文琪" grptype="curve">  <column title="3号" value="64" lineTitle="上海股价5" endLine="6号"></column>  <column title="6号" value="65" lineTitle="上海股价5" endLine="9号"></column>  <column title="9号" value="69" lineTitle="上海股价5" endLine="12号"></column>  <column title="12号" value="66" lineTitle="上海股价5" endLine="15号"></column>  <column title="15号" value="67" lineTitle="上海股价5" endLine="18号"></column>  <column title="18号" value="68" lineTitle="上海股价5" endLine="21号"></column>  </Row></graph>';
      xmlUrl='<%=request.getAttribute("filedHtml")%>';
       var  url="<%=basePath%>staticYouXiaoXing_FenXi.action";
    	Ajax(
			{
				url:url,
				onSucess:function(rs){
				 //	 alert(rs);
				 	xmlUrl=rs;
					 //self.opener.location=self.opener.location;
					//window.close();
					//self.close();
					
					 var  tempType = chtype;
                    xmlUrl_type = xmlUrl + "|" + tempType
                    document.bxt.SetVariable("_root.xmlUrl", xmlUrl_type);
                      xmlUrl = "no"
					
				}
			}
		); 
     
    }
</script>
</form>
</BODY>
</html>
<script>
    var id = setTimeout("showChart('radar')", 1000);
    
</script>
