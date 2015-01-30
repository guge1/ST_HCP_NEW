<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.List,java.util.Map"%>

<jsp:useBean id="Source" scope="page"
	class="system.dao.Impl.PublicSourceDAO" />

<html>
	<title>方案备注</title>
	 
	<head>
		<base target="_self" />
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />

		<script language="javascript" type="text/javascript"
			src="<%=request.getContextPath()%>/jsp/Market/js/aPublicjs.js">
</script>
		<script language="javascript" type="text/javascript"
			src="<%=request.getContextPath()%>/jsp/Market/js/aPublicjs.js">
	
</script>
	<link href="<%=request.getContextPath()%>/jsp/style_dark/styleform.css"
		rel="stylesheet" type="text/css" />
	<link
		href="<%=request.getContextPath()%>/jsp/style_dark/StyleSheet.css"
		rel="stylesheet" type="text/css" />
	<style>
.normal_img {
	border: 0;
	cursor: hand;
	padding-left: 2px;
	position: relative;
	filter: alpha(opacity =       30);
}

.current_img {
	border: 0;
	cursor: hand;
	position: relative;
}

table tr {
	
}

table tr  td {
	border-right: 1 black solid;
}
</style>
 
 <%
 	String caseId =   request.getParameter("caseId")==null?"":request.getParameter("caseId").toString() ; 
 
 %>
	<script type="text/javascript">
function save() {
	document.forms[0].action = "<%=request.getContextPath()%>/saveCase.action?caseId=<%=caseId%>";
	document.forms[0].submit();

}
</script>
	</head>


	<body topmargin="0" leftmargin="0" rightmargin="0" bottommargin="0">
		<form action="" id="form1" method="post">
			<div class="Btntoolbar">
				<table style="width: 100%;">
					<tr>
						<td>
						</td>
					</tr>
					<tr>
						<td style="width: 100%;">
							<div
								style="float: left; text-align: left; margin-left: 0px; padding-left: 0px;">
								&nbsp;&nbsp;方案备注
							</div>
							<div
								style="float: right; text-align: right; _position: absolute; right: 4px; top: 6px; z-index: 20; margin-right: 0px; padding-right: 0px; width: 240px;">

								<input type="submit" name="btnSave1" value="保存" onclick="save()"
									id="Submit1" class="pt_long_button" style="display: ;" />
								<input type="submit" name="btnSave1" value="放弃"
									onclick="javascript:window.close();" id="Submit1"
									class="pt_long_button" style="display: ;" />
							</div>
						</td>
					</tr>
				</table>
			</div>
			<div id="divPageContent"
				style="width: 100%; text-align: center; background-color: #F7F3F7;"
			 >
				<div id="notprint"
					style="background-color: #F7F3F7; height: 20px; color: #333; padding-bottom: 3px; font-size: 12px;">


					<div
						style="color: #666666; background-color: #F7F3F7; width: 100%; padding-top: 3px; font-size: 12px; text-aglin: center;"
						align="center">
						<fieldset class="tdLegendFieldset">
							<legend class="Legend_Style">
								方案备注信息：
							</legend>
							<table border="0" cellpadding="0" cellspacing="0"
								style="font-size: 12px;">
								 
								<tr style="height: 18px;">
								 
									<td>
									<textarea rows="13" cols="55" " onblur="__isQuoteIn(this);stringLengthCheck(this,'400','输入的结果不能超过400个字符！');" style="width;330px"  name="NOTE"><%=request.getAttribute("NOTE")==null?"":request.getAttribute("NOTE").toString() %></textarea>
									</td> 
								</tr>

							</table>
						</fieldset>
					</div>
				</div>
			</div>
			<br> 
		</form>
	</body>
</html> 
