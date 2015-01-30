<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.List,java.util.Map"%>

<jsp:useBean id="Source" scope="page"
	class="system.dao.Impl.PublicSourceDAO" />

<html>
	<title>医院信息--“资源”</title>
	 <%
	String strPrjName="/TPS";
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
	<head>
		<base target="_self" />
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
		<script language="javascript" type="text/javascript"
			src="<%=request.getContextPath()%>/jsp/Market/js/aPublicjs.js">
	
</script>
	<link href="<%=request.getContextPath()%>/jsp/style_dark/styleform.css"
		rel="stylesheet" type="text/css" />
	<link
		href="<%=request.getContextPath()%>/jsp/style_dark/StyleSheet.css"
		rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="<%=basePath%>skins/yellow2/css/style.css" type="text/css"></link>
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
	border-right: 0 black solid;
	background:#fdf5d0;border-right:1px dashed #f8c069;
}
</style>
	<%!public String NullToStr(Object obj) {
		if (obj != null) {
			return obj.toString().trim();
		} else {
			return "";
		}
	}%>

	<script type="text/javascript">
function save() {
	document.forms[0].action = "<%=request.getContextPath()%>/saveSource.action";
	document.forms[0].submit();

}
</script>
	</head>
<%

 String   usertype= request.getAttribute("usertype")==null?"": request.getAttribute("usertype").toString();
 System.out.println(usertype);
 String strStatus="display: none;";
 String strReadStatus="display: none;";
  if("1".equals(usertype))
  {//管理员
      strStatus="";
      strReadStatus="  readonly=\"readonly\" style=\"background-color: #C3CCDB\"  ";
  }
 %>

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
								&nbsp;&nbsp;最大可用资源
							</div>
							<div
								style="float: right; text-align: right; _position: absolute; right: 4px; top: 6px; z-index: 20; margin-right: 0px; padding-right: 0px; width: 240px;">

								<input type="submit" name="btnSave1" value="保存" onclick="save()"
									id="Submit1" class="pt_long_button" style="<%=strStatus %>" />
								<input type="submit" name="btnSave1" value="放弃"
									onclick="javascript:window.close();" id="Submit1"
									class="pt_long_button" style="display: ;" />
							</div>
						</td>
					</tr>
				</table>
			</div>
				<div id="divPageContent"
				style="width: 100%; text-align: center; background-color: ;"
				class="Div_MainContenStyle">
				<div id="notprint"
					style="background-color:  height: 20px; color: #333; padding-bottom: 3px; font-size: 12px;">



					<div
						style="color: #666666; background-color: #F7F3F7; width: 100%; padding-top: 3px; font-size: 12px; text-aglin: center;"
						align="center">
					 
							<table border="0" cellpadding="0" cellspacing="0" width="100%"
								style="font-size: 12px;text-align:center;">
								<tr style="height: 26px;">
									<td style="height: 51px;width: 145px;background:#F8B03A;font-size:14px;color: white;font-weight:bold;text-align:center;">
										类型
									</td> 				
									
									<td style="width: 80px">
										日常拜访
									</td>
									<td style="width: 80px">
										 科室会
									</td>
									<td style="width: 80px">
										 圆桌会
									</td>
									<td style="width: 80px">
										院内会
									</td>
									<td style="width: 80px;border-right: 0px black solid; ">
										日常促销费用
									</td>
									 
								</tr>
							 <tr
									style="height: 6px; background-color: #FFF; border: 0px #F7F3F7 solid;">
									<td colspan="6"></td>
								</tr>
								<%  if("1".equals(usertype))
                                    {//管理员 有单独的地方维护 每个代表的标准答案 %>
                                    
								<tr style="height: 26px;">
									<td style="height: 51px;width: 145px;background:#F8B03A;font-size:14px;color: white;font-weight:bold;text-align:center;">
									
										可用数量
									</td>

									<td style="background:#FFFFFF;">
										<input style="width: 45px;" onkeyup="javascript:checkIsNum(this);stringLengthCheck(this,'4','输入的结果不能超过4个字符！');"  name="XF" id="XF" value=" 60" />天
									</td>
									<td style="background:#FFFFFF;">
										<input style="width: 45px;" onkeyup="javascript:checkIsNum(this);stringLengthCheck(this,'4','输入的结果不能超过4个字符！');"  name="KNH" id="KNH" value="8" />次
									</td>
									<td style="background:#FFFFFF;">
										<input style="width: 45px;" onkeyup="javascript:checkIsNum(this);stringLengthCheck(this,'4','输入的结果不能超过4个字符！');"  name="HD" id="HD" value="6" />个
									</td>
									<td style="background:#FFFFFF;">
										<input style="width: 45px;" onkeyup="javascript:checkIsNum(this);stringLengthCheck(this,'4','输入的结果不能超过4个字符！');"  name="XSTGF" id="XSTGF" value="10" />次
									</td>
									<td  style="background:#FFFFFF;"> 
										<input style="width: 45px;" onkeyup="javascript:checkIsNum(this);stringLengthCheck(this,'8','输入的结果不能超过8个字符！');"  name="SCBTGF" id="SCBTGF" value="3000" />元/月
									</td>
                                 </tr>
							 
							 <tr
									style="height: 6px; background-color: #FFF; border: 0px #F7F3F7 solid;">
									<td colspan="6"></td>
								</tr>
								<tr style="height: 26px;">
									<td style="height: 51px;width: 145px;background:#F8B03A;font-size:14px;color: white;font-weight:bold;text-align:center;">
									
										对预测结果影响权重
									</td>
<td>
										<input style="width: 45px;" onkeyup="javascript:checkIsNum(this);stringLengthCheck(this,'4','输入的结果不能超过4个字符！');"  name="XF_LV" id="XF_LV" value="30" /> 
									</td>
									<td>
										<input style="width: 45px;" onkeyup="javascript:checkIsNum(this);stringLengthCheck(this,'4','输入的结果不能超过4个字符！');"  name="KNH_LV" id="KNH_LV" value="20" />
									</td>
									<td>
										<input style="width: 45px;" onkeyup="javascript:checkIsNum(this);stringLengthCheck(this,'4','输入的结果不能超过4个字符！');"  name="HD_LV" id="HD_LV" value="25" />
									</td>
									<td>
										<input style="width: 45px;" onkeyup="javascript:checkIsNum(this);stringLengthCheck(this,'4','输入的结果不能超过4个字符！');"  name="XSTGF_LV" id="XSTGF_LV" value="5" />
									</td>
									<td  style="   border-right: 0px black solid;">
										<input style="width: 45px;" onkeyup="javascript:checkIsNum(this);stringLengthCheck(this,'4','输入的结果不能超过4个字符！');"  name="SCBTGF_LV" id="SCBTGF_LV" value="20" />
									</td>

									 </tr>
								 <%} %>
								 
							 <tr
									style="height: 6px; background-color: #FFF; border: 0px #F7F3F7 solid;">
									<td colspan="6"></td>
								</tr>
								<tr style="height: 26px;">
									<td style="height: 51px;width: 145px;background:#F8B03A;font-size:14px;color: white;font-weight:bold;text-align:center;">
									
										最大可用资源
									</td>

									<td style="background:#FFFFFF;">
										60
									</td>
									<td style="background:#FFFFFF;">
										8
									</td>
									<td style="background:#FFFFFF;">
										6
									</td>
									<td style="background:#FFFFFF;">
										10
									</td>
									<td   style="background:#FFFFFF;">
										15000
									</td>
 
								 

								</tr>

							</table> 
					</div>
				</div>
			</div>
			<br>
			 <%=request.getAttribute("filedHtml")==null?"":request.getAttribute("filedHtml")
		%></form>
	</body>
</html>
<script type="text/javascript">

<%
 if(!"1".equals(usertype))
   {//管理员 有单独的地方维护 每个代表的标准答案 
%>
	var Objbuttons=document.getElementsByTagName("input") ; 
	 for(i=0;i<Objbuttons.length;i++){ 
	 
	    if(Objbuttons[i].type=="" ||  Objbuttons[i].type=="text" ){ 
	      Objbuttons[i].disabled=true; 
	      Objbuttons[i].backgroundcolor="#C3CCDB";
	      }
	     }
<%
}
%>

</script>
