<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.List,java.util.Map"%>
<jsp:useBean id="Source" scope="page"
	class="system.dao.Impl.PublicSourceDAO" />
<html>
	<title>指标参数</title>
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
	<head>
		<base target="_self" />
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<script language="javascript" type="text/javascript"
			src="<%=request.getContextPath()%>/jsp/Market/js/aPublicjs.js">
</script>

		<link
			href="<%=request.getContextPath()%>/jsp/style_dark/styleform.css"
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
	filter: alpha(opacity = 30);
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
}
</style>


		<script type="text/javascript">
function save() {
	document.forms[0].action = "<%=request.getContextPath()%>/saveZhiBiao.action";
	document.forms[0].submit();
}
</script>
	</head>

<%

 String   usertype= request.getAttribute("usertype")==null?"": request.getAttribute("usertype").toString();
 String strStatus="display: none;";
  if("1".equals(usertype))
  {//管理员
      strStatus="";
  }
 %>
		
<link rel="stylesheet" href="<%=basePath%>skins/yellow2/css/style.css" type="text/css"></link>
	<body topmargin="0" leftmargin="0" rightmargin="0" bottommargin="0">
		<form action="" id="form1" method="post">
			<div class="Btntoolbar">
				<table style="width: 100%;">
					<tr>
						<td>
						</td>
					</tr>
					<tr>
						<td style="width: 100%; border-right: 0px black solid;">
							<div
								class="Btntoolbar_left">
								&nbsp;&nbsp;指标参数设置
							</div>
							<div   class="Btntoolbar_right">

								<input type="submit" name="btnSave1" value="保存" onclick="save()"
									id="Submit111" class="pt_long_button" style="<%=strStatus %>" />
								<input type="submit" name="btnSave1" value="放弃"
									onclick="javascript:window.close();" class="pt_long_button" />
							</div>
						</td>
					</tr>
				</table>
			</div>
			<div
				style="width: 100%; text-align: center; background-color: #F7F3F7;"
				class="Div_MainContenStyle">
				<div id="notprint"
					style="background-color: #F7F3F7; height: 20px; color: #333; padding-bottom: 3px; font-size: 12px;">
					<div
						style="color: #666666; background-color: #F7F3F7; width: 100%; padding-top: 3px; font-size: 12px; text-aglin: center;"
						align="center">
						 <div class="zhishu"><!--
                         
                          <h1 align="center"><a href="javascript:window.close();"></a>指标参数设置</h1>
						 --><h2 style="font-weight:bold;">输入您的资源</h2>
						 </div>
							<table class="tbDragTable"
								style="width: 100%; margin-top: 0px; margin-left: 0px; background-color: #F7F3F7; height: 360px; ">
								<tr>
									<!--<td width="36px;">
										<img
											src="<%=request.getContextPath()%>/jsp/Market/images/22.jpg" />
									</td>
									 --><td align="left" style="border-right: 0px black solid;">
										<table border="0" cellpadding="0" cellspacing="0" width="100%"
											style="font-size: 12px; text-align: center;font-size:12px;border-right: 0px black solid;">
											<tr style="height: 36px;">
											    <td style="width: 70px;background:#F8B03A;font-size:14px;color: white;font-weight:bold;text-align:center;" rowspan="2">
													结果
												</td>
												<td style="width: 70px" class=" td_style3 ">
													指标
												</td>
												<td style="width: 100px" class=" td_style3 ">
													销售指标达成率 
												</td>
												<td style="width: 70px; " class=" td_style3 ">
													销售金额 
												</td>
												<td style="border-right: 0px black solid;width: 100px; " class=" td_style3 ">
													销售净增长额
													 
												</td>
												<td colspan="5" style="border-right: 0px black solid; width: 200px;;" class=" td_style3 ">

												</td>
												<td colspan="2" 
													style="border-right: 0px black solid; width: 160px;" class=" td_style3 ">已分配率</td>
											</tr>
										 
											
											<tr style="height: 36px;">
												<td>
													权重
												</td>

												<td>
													<input  onkeyup="javascript:checkIsNum(this);stringLengthCheck(this,'4','输入的结果不能超过4个字符！');setPageVsOne(this,'1')" name="ACH" value="50" style="width: 40px;"   >

												</td>
												<td>

													<input  onkeyup="javascript:checkIsNum(this);stringLengthCheck(this,'4','输入的结果不能超过4个字符！');setPageVsOne(this,'1')" name="NTS" value="0" style="width: 40px;"   />

												</td>
												<td style="border-right: 0px black solid;">
													<input  onkeyup="javascript:checkIsNum(this);stringLengthCheck(this,'4','输入的结果不能超过4个字符！');setPageVsOne(this,'1')" name="XSZZ" value="50" style="width: 40px;"  />


												</td>

												<td colspan="5" style="border-right: 0px black solid;">

												</td>
												<td colspan="2" style="border-right: 0px black solid;">
													
													<label id="label1">
														100%
													</label>
												</td>
											</tr>
											<tr style="height: 5px;">

												<td colspan="11" style="border-right: 0px black solid;">

												</td>
											</tr>
											<tr style="height: 36px;">
											 <td style="width: 70px;background:#F8B03A;font-size:14px;color: white;font-weight:bold;text-align:center;" rowspan="2">
													倾向性
												</td>
												<td class=" td_style3 " >
													指标
												</td>
												<td style="border-right: 0px black solid;" class=" td_style3 ">
													倾向性
												</td>
												<td  style="border-right: 0px black solid; " class=" td_style3 ">
													  
												</td> 
												<td colspan="6" style="border-right: 0px black solid;" class=" td_style3 ">

												</td>
												<td colspan="2"
													style="border-right: 0px black solid; width: 160px;" class=" td_style3 ">已分配率</td>
											</tr> 
											<tr style="height: 36px;">
												<td>
													权重
												</td>

												<td  style="border-right: 0px black solid; ">
													<input  onkeyup="javascript:checkIsNum(this);stringLengthCheck(this,'4','输入的结果不能超过4个字符！');setPageVsOne(this,'1')" name="QXX" value="100" style="width: 40px;"   >

												</td>
												<td  style="border-right: 0px black solid; ">

												 
												</td> 

												<td colspan="6" style="border-right: 0px black solid;">

												</td>
												<td colspan="2" style="border-right: 0px black solid;">
													
													<label id="label1">
														100%
													</label>
												</td>
											</tr>
											<tr style="height: 5px;">

												<td colspan="11" style="border-right: 0px black solid;">

												</td>
											</tr>
											<tr style="height: 36px;">
											   <td style="width: 70px;background:#F8B03A;font-size:14px;color: white;font-weight:bold;text-align:center;" rowspan="2">
													潜力
												</td>
												<td class=" td_style3 ">
													指标
												</td>
												<td style="border-right: 0px black solid;" class=" td_style3 ">
													潜力
												</td> 

												<td colspan="7" style="border-right: 0px black solid;" class=" td_style3 ">

												</td>
												<td colspan="2" style="border-right: 0px black solid;" class=" td_style3 ">
                             						已分配率:
												</td>
											</tr> 
											<tr style="height: 36px;">
												<td>
													权重
												</td>
												<td style="border-right: 0px black solid;">
													<input  onkeyup="javascript:checkIsNum(this);stringLengthCheck(this,'4','输入的结果不能超过4个字符！');setPageVsOne(this,'2')" name="SCGM" value="100" style="width: 40px;"   />
												</td>
												
												<td colspan="7" style="border-right: 0px black solid;">

												</td>
												<td colspan="2" style="border-right: 0px black solid;">
													
													<label id="label2">
														100%
													</label>
												</td>
											</tr>
							 	<tr style="height: 5px;">

												<td colspan="11" style="border-right: 0px black solid;">

												</td>
											</tr>
											<tr style="height: 36px;">
											   <td style="width: 70px;background:#F8B03A;font-size:14px;color: white;font-weight:bold;text-align:center;" rowspan="2">
													处方观念 
												</td>
												<td class=" td_style3 ">
													指标
												</td>
												<td   style="border-right: 0px black solid;  " class=" td_style3 ">
													处方观念 
												</td>
												
												<td colspan="7" style="border-right: 0px black solid;" class=" td_style3 ">

												</td>
												<td colspan="2"  style="border-right: 0px black solid; text-align:center;" class=" td_style3 " class=" td_style3 ">已分配率:
												</td>
											</tr>
										 
											<tr style="height: 36px;">
												<td>
													权重
												</td>

												<td  style="border-right: 0px black solid;">
													<input  onkeyup="javascript:checkIsNum(this);stringLengthCheck(this,'4','输入的结果不能超过4个字符！');setPageVsOne(this,'3')" name="XSGN" value="100" style="width: 40px;"  />
												</td>
												 <td colspan="7"  style="border-right: 0px black solid; ">
												</td>
											 
												
												<td  colspan="2" style="border-right: 0px black solid;">
													<label id="label3">
														100%
													</label>
												</td>
											</tr>

										</table>


									</td>
								</tr>
							</table> 
					</div>
				</div>
			</div>
			 
			 <%=request.getAttribute("filedHtml")==null?"":request.getAttribute("filedHtml")
		%>
			
			<br>
		</form>
	</body>
</html>
 
 <script type="text/javascript">

var  count=0;
function  setPageVsOne(selectObj,type)
{
  var  resultVs=0;
  var  names =["QXX"];
  var obj= document.getElementById("label1");
  var message="";
  if(type=="1")
  {
     names =["QXX"];
     obj= document.getElementById("label1");
     message="结果总权重和不能超过100%";
  }
  if(type=="2")
  {
     names =["SCGM"];
     obj= document.getElementById("label2");
     message="潜力总权重和不能超过100%";
  }
  if(type=="3")
  {
     names =["XSGN" ];
     obj= document.getElementById("label3");
     message="有效性总权重和不能超过100%";
  }
  for (var i=0;i<names.length;i++)
  {
    var  name=names[i];
  	var vs= document.getElementsByName(name)[0].value ;	 if(vs==""||vs=="NaN"||vs==null||vs==NaN)
  	 { 
  	   vs=0;
  	 }
  	 
      resultVs= resultVs+	parseInt(vs);
  } 
	 if(resultVs>100&&selectObj!=null)
	 { 
	   count++;
	   if(count>2){count=0;return false;}
	   alert(message);
	   selectObj.focus();
	   selectObj.select(); 
	   return  false;
	 }
	// obj.innerHTML=resultVs+"%";
	 
 
}
 
 // setPageVsOne(document.getElementsByName("ACH")[0],"1");
 // setPageVsOne(document.getElementsByName("SCGM")[0],"2");
 // setPageVsOne(document.getElementsByName("XSJQ")[0],"3");
 

</script>
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

