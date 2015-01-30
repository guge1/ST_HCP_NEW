<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
	<head id="Head1">
		<title>业务表单</title>
		<base target="_self" />
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<script type="text/javascript">
var Path = " <%=request.getContextPath()%>";
</script>
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
	document.forms[0].action = "<%=request.getContextPath()%>/saveTouRu_MuBiao.action";
	document.forms[0].submit();

}
</script>
		<style type="text/css">
.tbDragTable tr {
	text-align: center;
	height: 37px;
}

.tbInfo {
	background-color: White;
	font-weight: bold;
	height: 20px;
	font-size: 12px;
}
</style>
	</head>
	<body style="margin-top: 0; padding-top: 0;">
		<form name="form1" method="post" id="form1">
			<div class="Btntoolbar">
				<table style="width: 100%;">
					<tr>
						<td>
						</td>
					</tr>
					<tr>
						<td style="width: 100%;">
							<div style="" class="Btntoolbar_left">
								&nbsp;&nbsp;投入目标
							</div>
							<div style="" class="Btntoolbar_right">

								<input type="button" btnSave1" value="保存并提交下一步"  class="pt_vLong_button"
									onclick="save();" id="Submit1" style="display: ;" />
							</div>
						</td>
					</tr>
				</table>
			</div>
			<div 
				class="Div_MainContenStyle"  style="width: 100%;height:100%;overflow:auto;">
				<table style="width: 100%;">
					<tr id="100060" style="">
						<td colspan="2" class="tdGroupGround">
							<div id="TabContent" style="width: 100%; height: auto;">
								<table cellpadding="0" cellspacing="0" width="100%"
									style="margin-top: 5px;">
									<tr>
										<%=request.getAttribute("userHtml")%>
									</tr>
								</table>
							</div>
							<div style="width: 100%; border-bottom-color: Red; background-color: #F7F3F7; ">
									<%=request.getAttribute("UserInfoHtml")%>
							</div>
						</td>
					</tr>
					<tr>
						<td class="tdBase11Content">
							<table class="tbDragTable"
								style="width: 100%; margin-top: 0px; margin-left: 0px; background-color: White; height: 360px; " id="contentTable">
								<tr>
									<td width="36px;">
										<img
											src="<%=request.getContextPath()%>/jsp/Market/images/22.jpg" />
									</td>
									<td align="left">
										<%=request.getAttribute("filedHtml")%>
									</td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
			<br/>
			</div>
		</form>
	</body>
</html>
<script type="text/javascript">
try
{
  self.parent.frames["mainFrame_left"].setOnSelectTd('5')
  setTableStyle("contentTable","tr0","tr1","tr_on","tr_onclick");;
  <%
  
 String firstMarketid= request.getAttribute("firstMarketid")==null?"10001":request.getAttribute("firstMarketid").toString();
 String countUser= request.getAttribute("countUser")==null?"12":request.getAttribute("countUser").toString();
  %>
  __ChangeTab('001','0',<%=countUser%>,'<%=firstMarketid%>','text','',0);
} catch(e){}
</script>
