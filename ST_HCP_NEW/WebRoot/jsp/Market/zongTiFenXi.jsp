<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
	<head id="Head1">
		<title>总体分析</title>
		<base target="_self" />
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<script language="javascript" type="text/javascript"
			src="<%=request.getContextPath()%>/jsp/Market/js/WinOpen.js">
</script>

		<script language="javascript" type="text/javascript"
			src="<%=request.getContextPath()%>/jsp/Market/js/aPublicjs.js">
</script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/commonform.js"  charset="UTF-8"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/prototype.js" charset="UTF-8"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/sniper.js" charset="UTF-8"></script>

		<link
			href="<%=request.getContextPath()%>/jsp/style_dark/styleform.css"
			rel="stylesheet" type="text/css" />
		<link
			href="<%=request.getContextPath()%>/jsp/style_dark/StyleSheet.css"
			rel="stylesheet" type="text/css" />
			
			 
		<script type="text/javascript">
function save() {
    document.getElementById('uploading').style.display = "none";
	document.forms[0].action = "<%=request.getContextPath()%>/saveZongTi_FenXi.action";
	document.forms[0].submit();

}

  function AjaxSave(type) {
  
document.getElementById('uploading').style.display = "";
  FormSubmint_ZongTi("form1","<%=request.getContextPath()%>/saveZongTi_FenXi.action",type);
  /*  var  url="<%=request.getContextPath()%>/saveZongTi_FenXi.action";
    	Ajax(
			{
				url:url,
				onSucess:function(rs){
				 //	 alert(rs);
				  
					g_OpenModalReturnWindow('<%=request.getContextPath()%>/staticZongTiFenXi_Tu.action',880,680);
				}
			}
		); */
  }

//==================================================================================================
//ajax表单提交处理
function FormSubmint_ZongTi(vform,url,type){
	var form = "";
	if(vform == null || vform == "")
	{
		form = "form1";
	}
	else
	{
		form = vform;
	}
	var obj = document.getElementById(form);
    var content = encodeURI(Form.serialize(obj));
    
	var ajax = new Ajax.Request( url,
        {
            method:"post",       //表单提交方式 
            postBody:content,   //提交的xml
            setRequestHeader:{"content-Type":"text/xml"}, //指定发送的数据为 xml 文档（非字符串）
            onComplete:function(httpRequest){    //提交成功回调 
            	//var vCMD=document.getElementById("__COMMAND").value;
            	//OnComplete(vCMD,httpRequest.responseText);
                document.getElementById('uploading').style.display = "none";
                return true;
            	if(type=="1")
            	{
            		//g_OpenModalReturnWindow('<%=request.getContextPath()%>/staticZongTiFenXi_Tu.action',880,680);
                }
            	if(type=="2")
            	{
            		g_OpenModalReturnWindow('<%=request.getContextPath()%>/jsp/static/sell_analysis.jsp',800,560);
                }
            	if(type=="3")
            	{
            		g_OpenModalReturnWindow('<%=request.getContextPath()%>/jsp/static/qianli.jsp',740,560);
                }
            	if(type=="4")
            	{
            		g_OpenModalReturnWindow('<%=request.getContextPath()%>/jsp/static/youXiaoXing_char.jsp',826,580);
                }
            },
            onError:function(x){   //提交失败回调
            	alert("Error="+x.statusText);
            } 
        } 
	); 
	return false;
}
</script>
		<style type="text/css">
.tbDragTable tr {
	text-align: center;
	/*height: 32px;*/
}

.trMoveRow {
	/*height: 30px;*/
}
</style>
<link rel="stylesheet" href="<%=request.getContextPath()%>/skins/yellow2/css/style.css" type="text/css"></link>
	</head>
	<body style="margin-top: 0; padding-top: 0;">
		<form name="form1" method="post" action="" id="form1">
			<div id="uploading"
				style="position: absolute; top: 90px;left:200px; z-index: 22; width: 100%; height: 100%; color: Red;">
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
								&nbsp;&nbsp;总体分析
							</div>
							<div class="Btntoolbar_right">

								<input type="button" name="btnSave1" value="总体分析"
									onclick="javascript:AjaxSave('1');g_OpenModalReturnWindow('<%=request.getContextPath()%>/staticZongTiFenXi_Tu.action',880,680);"
									id="Submit1" class="pt_long_button" style="display: ;" />
								<input type="button" name="btnSave1" value="潜力"
									onclick=" javascript:AjaxSave('3');g_OpenModalReturnWindow('<%=request.getContextPath()%>/jsp/static/qianli.jsp',740,560);"
									class="pt_long_button" style="display: ;" />
								<input type="button" name="btnSave1" value="倾向性"
									onclick="javascript:AjaxSave('2');g_OpenModalReturnWindow('<%=request.getContextPath()%>/jsp/static/qianli.jsp?type=qxx',740,560);"
									id="Submit1" class="pt_long_button" style="display: ;" />
									<input type="button" name="btnSave1" value="处方观念"
									onclick=" javascript:AjaxSave('3');g_OpenModalReturnWindow('<%=request.getContextPath()%>/jsp/static/qianli.jsp?type=xsgn',740,560);"
									class="pt_long_button" style="display: ;" />
								 	<!--<input type="button" name="btnSave1" value="下一步"
									onclick="save();" id="Submit3"    class="pt_vLong_button"
									 />
							-->
							
												<input type="button" value="下一步" class="pt_long_button" 
													onclick="window.location.href='<%=request.getContextPath() %>/queryQianLi_FenXi.action'">
							</div>
						</td>
					</tr>
				</table>
			</div>
			<div id="divPageContent" style="width: 100%;"
				class="Div_MainContenStyle">
				<div id="wmp_form_info"
					style="width: 100%; background-color: #E7F5FD;">
					<div id="wmp_form_error"
						style="display: none; width: 100%; background-color: #E7F5FD; text-align: left; table-layout: fixed; word-break: break-all; overflow: hidden; background: url(../../Base/WFP/img_ico/ico_error.gif) no-repeat left; padding-left: 20px; padding-top: 4px; padding-bottom: 2px;">
						页面错误提示
					</div>
				</div>
				<div id="divContent"
					style="width: 100%;height:100% ;overflow: auto; background-color: White;">
					<table  id="contentTable"
						style="width: 100%; margin-top: 0px; margin-left: 0px;  "  > 
						 
						 <tr>
							 
							<td style="width: *;" valign="top">
								<table  class="tbDragTable"  style="width: 100%;text-align:center; "  onkeydown="setTabKey(event,this)">
								 <colgroup>
									<col width="120px" />
									<col width="70px" /> 
									<col width="70px" />
									<col width="70px" /> 
									<col width="70px" />
									<col width="70px" />
									<col width="70px" /> 
									<col width="70px" />
									<col width="70px" />
									<col width="70px" /> 
									<col width="70px" />
									<col width="70px" />  
									<col width="70px" />  
								</colgroup>
							<%=request.getAttribute("headRow")%>
									<%=request.getAttribute("filedHtml")%>
								</table>
							</td>
						</tr>
					</table>
				</div>
			</div>
		</form>
	</body>


	<script language="javascript">
//setTableStyle("contentTable","tr0","tr1","tr_on","tr_onclick");
document.getElementById('uploading').style.display = "none";
try
{
  self.parent.frames["mainFrame_left"].setOnSelectTd('0'); 
 setTableStyle("contentTable","tr0","tr1","tr_on","tr_onclick");
} catch(e){}
</script>
</html>
