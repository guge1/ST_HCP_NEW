<%@ page language="java" import="java.util.*"  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
	<head >
		<title>倾向性分析</title>
		<base target="_self" />
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
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
	document.forms[0].action = "<%=request.getContextPath()%>/saveJieGuo_FenXi.action";
	document.forms[0].submit();

}
</script>
	</head>
	<body style="margin-top: 0; padding-top: 0;">
		<form name="form1" method="post" id="form1">
			<div id="uploading"
				style="position: absolute; top: 90px; z-index: 22; width: 100%; height: 100%; color: Red;">
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
							<div class="Btntoolbar_left">
								&nbsp;&nbsp;倾向性分析
							</div>
							<div class="Btntoolbar_right">

								
								<input type="button" name="btnSave1" value="总体分析"
									onclick="javascript:g_OpenModalReturnWindow('<%=request.getContextPath()%>/staticZongTiFenXi_Tu.action',880,680);"
									id="Submit1" class="pt_long_button" style="display: ;" />
							<input type="button" name="btnSave1" value="潜力"
									onclick="javascript:g_OpenModalReturnWindow('<%=request.getContextPath()%>/jsp/static/qianli.jsp',740,560);"
									class="pt_long_button" style="display: ;" />
								<input type="button" name="btnSave1" value="倾向性"
									onclick="javascript:g_OpenModalReturnWindow('<%=request.getContextPath()%>/jsp/static/qianli.jsp?type=qxx',740,560);"
									id="Submit1" class="pt_long_button" style="display: ;" />
								
								<input type="button" name="btnSave1" value="处方观念"
									onclick="javascript:g_OpenModalReturnWindow('<%=request.getContextPath()%>/jsp/static/qianli.jsp?type=xsgn',740,560);"
									id="Submit2" class="pt_long_button"  />
								<input type="button" name="btnSave1" value="保存并提交下一步"   class="pt_vLong_button"
									onclick="save();" id="Submit1" style="display: ;" />
							</div>
						</td>
					</tr>
				</table>
			</div>
			<div id="divContent" class="Div_MainContenStyle"
				style="width: 100%; background-color: White;  ">
				<table style="width: 100%; height: 100%;" >
					<%=request.getAttribute("filedHtml")%>
				</table>
			</div>
			<br />
			<br />
		</form>
	</body>
</html>
<script language="javascript">
//setTableStyle("contentTable","tr0","tr1","tr_on","tr_onclick");
document.getElementById('uploading').style.display = "none";
try
{
  self.parent.frames["mainFrame_left"].setOnSelectTd('2'); 
} catch(e){}
</script>
