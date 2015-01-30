<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String struserName = request.getParameter("userName") == null ? ""
			: request.getParameter("userName").toString();
%>
<html>
	<head id="Head1">
		<title><%=struserName%>有效性</title>
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
	document.forms[0].action = "<%=request.getContextPath()%>/saveYueFen_JianKong.action";
	document.forms[0].submit();

}
</script>
<style type="text/css">
.tbDragTable tr{

height:26px;
}

</style>
	</head>
	<body style="margin-top: 0; padding-top: 0;">
		<form name="form1" method="post"
			action="SimplePage.aspx?PageID=1089&amp;setPageTemplateID=&amp;setPageTest=1"
			id="form1">

			<div id="divPageContent" style="width: 100%;"
				 >

				<div id="Tab_001_0"
					style="width: 100%; border-bottom-color: Red; background-color: #F7F3F7; ">
					<fieldset class="tdLegendFieldset"
						style="margin-left: 10px; margin-right: 10px;  ">
						<legend class="Legend_Style" style=""><%=struserName%>有效性
						</legend>
						<table class="tbDragTable" id="Table1"
							style="width: 100%; margin-top: 0px; margin-left: 0px; ">

							<colgroup>
								<col width="50%" />
								<col width="12%" /> 
								<col width="12%" /> 
								<col width="12%" /> 
								<col width="12%" /> 
							</colgroup>
							<%=request.getAttribute("filedHtml")%>
							<!--<tr id="Tr3" class="tableHead">
								<td id="Td2">

								</td>
								<td>
									Dec-09
								</td>
								<td>
									Jan-10
								</td>
								<td>
									Feb-10
								</td>
								<td>
									Mar-10
								</td>
							</tr>
							<tr style="height: 20px;">
								<td style="background-color: white;">
									实际拜访天数 （Day in field）
								</td>
								<td class="tdFieldInput" style="background-color: white;">
									18
								</td>
								<td class="tdFieldInput" id="Td27"
									style="background-color: white;">
									14
								</td>
								<td class="tdFieldInput" id="Td29"
									style="background-color: white;">
									16
								</td>
								<td class="tdFieldInput" id="Td31"
									style="background-color: white;">
									17
								</td>
							</tr>
							<tr style="height: 20px;">
								<td style="background-color: white;">
									月拜访次数 （Monthly call rate）
								</td>
								<td class="tdFieldInput" style="background-color: white;">
									140
								</td>
								<td class="tdFieldInput" id="Td35"
									style="background-color: white;">
									80
								</td>
								<td class="tdFieldInput" id="Td36"
									style="background-color: white;">
									120
								</td>
								<td class="tdFieldInput" id="Td37"
									style="background-color: white;">
									130
								</td>

							</tr>
							<tr style="height: 20px;">
								<td style="background-color: white;">
									A，B级覆盖率（A，B coverage rate）
								</td>
								<td class="tdFieldInput" style="background-color: white;">
									75%
								</td>
								<td class="tdFieldInput" id="Td51"
									style="background-color: white;">
									60%
								</td>
								<td class="tdFieldInput" id="Td52"
									style="background-color: white;">
									78%
								</td>
								<td class="tdFieldInput" id="Td53"
									style="background-color: white;">
									80%
								</td>
							</tr>

							<tr style="height: 20px;">
								<td style="background-color: white;">
									A，B级拜访频率（A，B call frequency）
								</td>
								<td class="tdFieldInput" style="background-color: white;">
									70%
								</td>
								<td class="tdFieldInput" id="Td61"
									style="background-color: white;">
									50%
								</td>
								<td class="tdFieldInput" id="Td62"
									style="background-color: white;">
									65%
								</td>
								<td class="tdFieldInput" id="Td63"
									style="background-color: white;">
									75%
								</td>

							</tr>
							<tr style="height: 20px;">
								<td style="background-color: white;">
									销售技巧（selling skills）
								</td>
								<td class="tdFieldInput" style="background-color: white;">
									70
								</td>
								<td class="tdFieldInput" id="Td66"
									style="background-color: white;">
									70
								</td>
								<td class="tdFieldInput" id="Td67"
									style="background-color: white;">
									70
								</td>
								<td class="tdFieldInput" id="Td68"
									style="background-color: white;">
									70
								</td>
							</tr>
							<tr style="height: 20px;">
								<td style="background-color: white;">
									产品知识（product knowledge）
								</td>
								<td class="tdFieldInput" style="background-color: white;">
									70
								</td>
								<td class="tdFieldInput" id="Td71"
									style="background-color: white;">
									70
								</td>
								<td class="tdFieldInput" id="Td72"
									style="background-color: white;">
									70
								</td>
								<td class="tdFieldInput" id="Td73"
									style="background-color: white;">
									70
								</td>

							</tr>
							<tr style="height: 20px;">
								<td style="background-color: white;">
									拜访计划（Call plan)( 4/day）
								</td>
								<td class="tdFieldInput" style="background-color: white;">
									2
								</td>
								<td class="tdFieldInput" id="Td66"
									style="background-color: white;">
									2
								</td>
								<td class="tdFieldInput" id="Td67"
									style="background-color: white;">
									2
								</td>
								<td class="tdFieldInput" id="Td68"
									style="background-color: white;">
									2
								</td>
							</tr>
							<tr style="height: 20px;">
								<td style="background-color: white;">
									推广活动（Activity）（4/Monthly）
								</td>
								<td class="tdFieldInput" style="background-color: white;">
									4
								</td>
								<td class="tdFieldInput" id="Td66"
									style="background-color: white;">
									4
								</td>
								<td class="tdFieldInput" id="Td67"
									style="background-color: white;">
									4
								</td>
								<td class="tdFieldInput" id="Td68"
									style="background-color: white;">
									4
								</td>
							</tr>

						--></table>
					</fieldset>
				</div>
			</div>
		</form>
	</body>
</html>
<script type="text/javascript">
function getXingDongJiHua(obj) {
	var returnVs = [];
	returnVs = g_OpenModalReturnWindow_return(
			'<%=request.getContextPath()%>/getXingDongJiHuaList.action', 720,
			620);
	if (returnVs != null) {
		obj.value = returnVs["codeID"];
	}
}
</script>
