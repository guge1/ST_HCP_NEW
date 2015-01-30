<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.List,java.util.Map"%>

<jsp:useBean id="Source" scope="page"
	class="system.dao.Impl.PublicSourceDAO" />

<html>
	<title>设置行动计划</title>
	 
	<head>
		<base target="_self" />
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
		 <META HTTP-EQUIV="Pragma" CONTENT="no-cache">
       <META HTTP-EQUIV="Expires" CONTENT="-1">
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
								&nbsp;&nbsp;
							</div>
							<div
								style="float: right; text-align: right; _position: absolute; right: 4px; top: 6px; z-index: 20; margin-right: 0px; padding-right: 0px; width: 240px;">

								<input type="button"  value="设置" onclick="returnSelectVs()"
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
				style="width: 100%; text-align: center; background-color: #F7F3F7; overflow:hidden;"
				class="Div_MainContenStyle">
				<div id="notprint"
					style="background-color: #F7F3F7; height: 20px; color: #333; padding-bottom: 3px; font-size: 12px;">



					<div
						style="color: #666666; background-color: #F7F3F7; width: 700px; padding-top: 3px; font-size: 12px; text-aglin: center;"
						align="center">
						<fieldset class="tdLegendFieldset">
							<legend class="Legend_Style">
								选择行动计划
							</legend>
							<table border="1" cellpadding="0" cellspacing="0" id="tdContent"
								style="font-size: 12px;width:100%;">
								 
									<%=request.getAttribute("filedHtml")%>

							</table>
						</fieldset>
					</div>
				</div>
			</div>
			<br> 
			<input type="hidden"  id="dicID" />
			<input type="hidden"  id="dicCodeID" />
		</form>
	</body>
</html>
<script type="text/javascript">
  ///////////////////////////////////////////////  
              //   功能：合并表格  
              //   参数：tb－－需要合并的表格ID  
              //   参数：colLength－－需要对前几列进行合并，比如，  
              //   想合并前两列，后面的数据列忽略合并，colLength应为2  
              //   缺省表示对全部列合并  
              //   data:   2005.11.6  
              ///////////////////////////////////////////////  
              function uniteTable(tb,colLength){  
              //   检查表格是否规整  
              if   (!checkTable(tb)) return;  
              var   i=0;  
              var   j=0;  
              var   rowCount=tb.rows.length; //   行数  
              var   colCount=tb.rows[0].cells.length; //   列数  
              var   obj1=null;  
              var   obj2=null;  
              //   为每个单元格命名  
              for(i=0;i<rowCount;i++){  
                  for   (j=0;j<colCount;j++){  
                    tb.rows[i].cells[j].id="tb__"   +   i.toString()   +   "_"   +   j.toString();  
                  }  
              }  
              //   逐列检查合并  
              for (i=1;i<colCount;i++){  
                  if (i==colLength)   return;  
                      obj1=document.getElementById("tb__0_"+i.toString())  
                      for (j=1;j<rowCount;j++){  
                          obj2=document.getElementById("tb__"+j.toString()+"_"+i.toString());  
                          if (obj1.innerText   ==   obj2.innerText){  
                              obj1.rowSpan++;  
                              obj2.parentNode.removeChild(obj2);  
                          }else{  
                              obj1=document.getElementById("tb__"+j.toString()+"_"+i.toString());  
                          }  
                      }  
                  }  
              }  
               
              /////////////////////////////////////////  
              //   功能：检查表格是否规整  
              //   参数：tb－－需要检查的表格ID  
              //   data:   2005.11.6  
              /////////////////////////////////////////  
              function checkTable(tb){  
                  if (tb.rows.length==0)   return false;  
                      if (tb.rows[0].cells.length==0)   return false;  
                      for(var   i=0;i<tb.rows.length;i++){  
                           if(tb.rows[0].cells.length != tb.rows[i].cells.length) return false;  
                      }  
                  return true;  
              }  
 
  uniteTable(document.getElementById("tdContent"),3);
</script>
<script type="text/javascript">

  var  returnVs=[];
 function SetGVCheck(id,codeID)
 {
    returnVs["id"]=id;
	returnVs["codeID"]=codeID;
	document.getElementById("dicID").value=id;
	document.getElementById("dicCodeID").value=codeID;
	
 
 }
  function returnSelectVs()
  { 
    window.returnValue= returnVs;
    window.close();
  
  }
</script>