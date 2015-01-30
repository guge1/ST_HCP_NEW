<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html  >
<head id="Head1">
    <title>业务表单 </title>
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
	document.forms[0].action = "<%=request.getContextPath()%>/saveChanChu_MuBiao.action";
	document.forms[0].submit();

}
</script>
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
                        &nbsp;&nbsp;产出目标</div>
                    <div style="" class="Btntoolbar_right">
                        
                        <input type="button" name="btnSave1" value="保存并提交下一步" onclick="save()"
                            id="Submit1"  style="display: ;"   class="pt_vLong_button" /> 
                    </div>
                </td>
            </tr>
        </table>
    </div>
     <div id="divPageContent" style="width: 100%;" class="Div_MainContenStyle">
        <table style="width: 100%;">
          
            <tr>
                <td   class="tdBase11Content11">
                    <table class="tbDragTable" style="width: 100%; margin-top: auto; margin-left: auto;   " id="contentTable" >
                      
									<%=request.getAttribute("filedHtml")%>
                       </table>
                </td>
            </tr>
        </table>
    </div>
    </form>
</body>
</html>
<script type="text/javascript">
try
{
  self.parent.frames["mainFrame_left"].setOnSelectTd('4'); 
  setTableStyle("contentTable","tr0","tr1","tr_on","tr_onclick");
} catch(e){}
</script>
