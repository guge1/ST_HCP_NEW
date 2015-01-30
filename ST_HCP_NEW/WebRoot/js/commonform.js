function doPost(vCommand, vTARGET, vArgument, vFromName, vURL) 
{
	var theForm ;
	if(vFromName==null || vFromName=="")
	{
		theForm = document.forms['form1'];
	}
	else
	{
		 theForm = document.forms[vFromName];
	}
	if (!theForm) 
	{
	    theForm = document.form[0];
	}
    if (!theForm.onsubmit || (theForm.onsubmit() != false)) 
	{
    	//theForm.FORMPKID.value = "";
    	theForm.COMMAND.value = vCommand;
    	theForm.TARGET.value = vTARGET;
    	theForm.ARGUMENT.value = vArgument;
    	if(vURL != null && vURL != "")
    	{
    		theForm.action=vURL;
    	}
    	theForm.target ="SaveArea";
    	
    	theForm.submit();
    	//parentRefresh();
    	return;
	}
	 
}
 function parentRefresh()
{
	try{window.opener.location=window.opener.location;}catch(err){parent.location=parent.location;}
}
function documentkillErrors() {
    return true;
    }

function FormInit(vCommand,vPageID,vPKID,vActionID,vRoleID,vRightType,vStatus,vTable)
{	
	//var vTable="";
	if(vStatus=="0")
 	{
   	 	document.write('window.onerror = documentkillErrors;');
   	}
    document.write('<iframe id="SaveArea" name="SaveArea" style="visibility:hidden" width="0" height="0" frameborder="0" src=""></iframe>');
  	document.write('<input type="hidden" name="__PAGEID" id="__PAGEID" value="' + vPageID + '" />');
  	document.write('<input type="hidden" name="__FORMPKID" id="__FORMPKID" value="' + vPKID + '" />');
  	document.write('<input type="hidden" name="__ACTIONID" id="__ACTIONID" value="' + vActionID + '" />');
  	document.write('<input type="hidden" name="__RIGHTTYPEID" id="__RIGHTTYPEID" value="' + vRightType + '" />');
  	document.write('<input type="hidden" name="__ROLEID" id="__ROLEID" value="' + vRoleID + '" />');
   	document.write('<input type="hidden" name="__COMMAND" id="__COMMAND" value="' + vCommand + '" />');
   	document.write('<input type="hidden" name="__TARGET" id="__TARGET" value="" />');
   	document.write('<input type="hidden" name="__TABLE" id="__TABLE" value="' + vTable + '" />');
   	document.write('<input type="hidden" name="__ARGUMENT" id="__ARGUMENT" value="" />');
   	document.write('<input type="hidden" name="__SQLFORMAJAX" id="__SQLFORMAJAX">');
}

//==================================================================================================
function PageInit(vPageId, vPageFullName, vForm)
{
	var form = "";
	if(vForm == null || vForm == "")
	{
		vForm = "form1";
	}
	
	if(vPageId == null)
	{
		vPageId = "";
	}
	
	if(vPageFullName == null)
	{
		vPageFullName = "";
	}
	
    var content = "pageid=" + vPageId + "&pagefullname=" + vPageFullName + "&__COMMAND=0&optype=2";
	var ajax = new Ajax.Request(
        "/atic/formaction",
        {
            method:"post",      	//表单提交方式
            postBody:content,   	//提交的xml
            setRequestHeader:{"content-Type":"text/xml"}, 	//指定发送的数据为xml文档（非字符串）
            onComplete:function(httpRequest){    			//提交成功回调
            	var vCMD=document.getElementById("__COMMAND").value;
            	onComplete("0",httpRequest.responseText);
            },
            onError:function(x){   //提交失败回调
            	alert("Error="+x.statusText);
            }
        }
	);
}

//==================================================================================================
//ajax表单提交处理
function FormSubmint(vform,url){
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
    alert(Ajax);
	var ajax = new Ajax.Request( url,
        {
            method:"post",       //表单提交方式 
            postBody:content,   //提交的xml
            setRequestHeader:{"content-Type":"text/xml"}, //指定发送的数据为 xml 文档（非字符串）
            onComplete:function(httpRequest){    //提交成功回调 
            	var vCMD=document.getElementById("__COMMAND").value;
            	OnComplete(vCMD,httpRequest.responseText);
            },
            onError:function(x){   //提交失败回调
            	alert("Error="+x.statusText);
            } 
        } 
	); 
}
function getNode(vNodes, vNodeName) 
{
  	for(var i=0;i< vNodes.childNodes.length;i++)
	  {
	     if( vNodes.childNodes[i].getAttributeNode("name").value==vNodeName){
	       return  vNodes.childNodes[i];//.getElementsByTagName("value").item(0).text
	      }
	   }
	   return  vNodes;
}
function OnComplete(vCMD,vReValue)
{
	var form = document.getElementById('form1');
   	var logicFields = LogicForm.getLogicFields(form);
 	var dom = new ActiveXObject("Microsoft.XMLDOM");
	dom.loadXML(vReValue);//默认节点为根节点,
	var vRootNode = dom.selectSingleNode("/root");
	//判断操作类型
    switch (vCMD){
    	//0：读取XML数据/1：插入/2：修改保存/3：保存并新增/4：打印输出/5:只读浏览/6:读取明细可编辑(包括上下翻页)
		case "0":
         	for(var i=0;i<vRootNode.childNodes.length;i++)
	    	{
	       	    var nameNode = vRootNode.childNodes[i].attributes[0];
	       	    var childNode = vRootNode.childNodes[i].childNodes[0];
	       	    var logicFieldName = nameNode.value;
	            if(typeof(logicFields[logicFieldName]) != 'undefined')
	            {
		            logicFields[logicFieldName].setValue(childNode.text)
	            }
		    }
      		break ;
		case "1":
		case "2":
			var pNode = getNode(vRootNode,"__MESSAGE");
        	var childNode = pNode.childNodes[1];
			var childNode0 = pNode.childNodes[0];
			document.getElementById("__MESSAGE").innerText = childNode.text;
			if(childNode0.text == "1")
			{
				window.close();
			} 
            break;
            /*
        case "2":
	        
        	//取得返回结果信息
           	var pNode;	
           	pNode = getNode(vRootNode,"__FORMPKID");
           	if(vCMD == "1"){
           		document.getElementById("__FORMPKID").value = pNode.getElementsByTagName("value").item(0).text;
           		document.getElementById("__COMMAND").value = "2";
           	}
           	pNode = getNode(vRootNode,"__MESSAGE");
            if(pNode.getAttributeNode("name").value == "__MESSAGE"){
            	if(pNode.getElementsByTagName("code").item(0).text=="0"){
	              	alert("Succee=" + pNode.getElementsByTagName("value").item(0).text);
	           	}else{
	               	alert("Error=" + pNode.getElementsByTagName("value").item(0).text);
	               	pNode = getNode(vRootNode,"__ERRPR");
	               	alert("ErrorMessage="+pNode.getElementsByTagName("value").item(0).text);
	        	}
	      	}
	       	childNodes=null;
            dom=null;
			break;
        	*/
        case "3":
             
            break;
        case "4":
        	var pNode = getNode(vRootNode,"__MESSAGE");
        	var childNode = pNode.childNodes[1];
			alert(childNode.text);
			var childNode0 = pNode.childNodes[0];
			if(childNode0.text == "1")
			{
				removeRows();
			} 
            break;
		default:
             
            break; 
             
     }
}

//删除列表记录，并重新编号（GRIDVIEW）
function removeRows()
{
	var checkNames = document.getElementsByName("chk");
	//删除选中的节点；
	for(var i = checkNames.length - 1; i >= 0; i--)
	{
		if(checkNames[i].checked == true)
		{
			var tr = checkNames[i].parentElement.parentElement;
			tr.parentNode.removeChild(tr);
		}
	}
	//重新设置序号；
	for(var i = 0; i < checkNames.length; i++)
	{
		var tr = checkNames[i].parentElement.parentElement;
		tr.cells[2].innerText = i + 1;
	}
}
//==================================================================================================
//ajax，数据库取值
//ajax表单提交处理；
//params：参数；div：回显的位置
function AjaxGetData(funcParam, position, remindContent){
	var obj = document.getElementById("__FORMAJAX");
	var content = encodeURI(Form.serialize(obj));
	var ajax = new Ajax.Request(
			"/atic/ajaxgetdata",
			{
				method:"post",       //表单提交方式 
				postBody:content,   //提交的xml
				setRequestHeader:{"content-Type":"text/xml"}, //指定发送的数据为 xml 文档（非字符串）
				onComplete:function(httpRequest)
				{    
					//提交成功回调 
					onReturnValue(httpRequest.responseText, funcParam, position, remindContent);
				},
				onError:function(x)
				{   
					//提交失败回调
					alert("Error="+x.statusText);
				} 
			} 
	); 
}

function onReturnValue(vReValue, vFuncParam, vPosition, vContent)
{
 	var dom = new ActiveXObject("Microsoft.XMLDOM");
	dom.loadXML(vReValue);//默认节点为根节点,
	var vRootNode = dom.selectSingleNode("/root");
	var pNode = getNode(vRootNode,"__MESSAGE");
    var childNode = pNode.childNodes[1];
	var childNode0 = pNode.childNodes[0];
	//执行函数
	vFuncParam(childNode.text, vPosition, vContent);
}

function FormAjaxInit()
{
	document.write('<form id="__FORMAJAX" name="__FORMAJAX" action="">');
	document.write('<input type="hidden" id="__SQLAJAX" name="__SQLAJAX">');
	document.write('</form>');
}
//==================================================================================================
//表单部分隐藏（目前在tbody当中有效）
function ShowTable(imgCtrl,path)
{
      var ImgPlusScr = path + "/images/icon_expandall.gif";      	// pic Plus  +
      var ImgMinusScr = path + "/images/icon_collapseall.gif"	;	    // pic Minus - 
      var TableID = imgCtrl.id.replace("Img","Table");
      var className;
      var objectFullName;
      var tableCtrl;
      objectFullName = "PlaceHolder_tr";
      className = objectFullName.substring(0,objectFullName.indexOf("tr")-1);
      tableCtrl = document.all.item(className.substr(0,className.length)+"_"+TableID);
      if(imgCtrl.src.indexOf("icon_expandall") != -1)
      {
        tableCtrl.style.display ="";
        imgCtrl.src = ImgMinusScr ;
      }
      else
      {
        tableCtrl.style.display ="none";
        imgCtrl.src = ImgPlusScr ;		 
      }
} 
//==================================================================================================
//设置只读
function setReadOnly(id)
{
	var obj = document.getElementById(id);
	//设置input只读
	var txts = obj.getElementsByTagName("input");
	for(var i=0;i< txts.length;i++)
	{
		if(txts[i].type == "text")
		{
		  	txts[i].readOnly = true;
		}
		if(txts[i].type == "checkbox")
		{
			
		}
		if(txts[i].type == "radio")
		{
		  	txts[i].readOnly = true;
		}
		if(txts[i].type == "button")
		{
		  	txts[i].disabled = true;
		}
	}
	//设置textarea只读
	var txtareas = obj.getElementsByTagName("textarea");
	for(var i=0;i< txtareas.length;i++)
	{
		if(txtareas[i].type=="textarea")
		{
			txtareas[i].readOnly = true;
		}
	}
	//设置select只读
	var selects = obj.getElementsByTagName("select");
	for(var i=0;i< selects.length;i++)
	{
		selectReadOnly(selects[i].id);
	}
	//设置radio只读
	var radios = obj.getElementsByTagName("radio");
	
}
//select对象只读
function selectReadOnly(selectedId){
	var obj = document.getElementById(selectedId);
	obj.onmouseover = function()
	{
	     obj.setCapture();
	}
	obj.onmouseout = function()
	{
		obj.releaseCapture();
	}
	obj.onfocus = function()
	{
		obj.blur();
	}
	obj.onbeforeactivate = function()
	{
		return false;
	}
}

//==================================================================================================
	

	///////////////////////////////////////////////  
	//   功能：合并表格
	//   参数：tb－－需要合并的表格ID
	//   参数：colLength－－需要对前几列进行合并，比如，
	//   想合并前两列，后面的数据列忽略合并，colLength应为2
	//   缺省表示对全部列合并
	///////////////////////////////////////////////  
	function uniteTableRow(tb, rules, resetid, beginRow, endRow, beginCol, endCol, offset) 
	{
		if(offset == null || offset == "")
		{
			offset = "0;0";
		}
		var offsets = offset.split(";");
		if(offsets.length < 2) return;
		var rowOffSet = Number(offsets[0]);
		var colOffSet = Number(offsets[1]);
		
	    if(beginCol > endCol || beginRow > endRow) return;
		//是否要检测table是否规整（即无合并行和列）
	    if(rules == "1")
	    {
	    	//检查表格是否规整  
	    	if (!checkTable(tb)) return;
	    }
	    
	    var i = 0;
	    var j = 0;
	    var rowCount = tb.rows.length; //   行数  
	    //var colCount = tb.rows[0].cells.length; //   列数  
	    var obj1 = null;
	    var obj2 = null;
	    
		//判断是否需要对单元格重新设置ID
	  	if(resetid == "1")
	  	{
		  	//为每个单元格重新设置ID
	        for (i = 0; i < rowCount; i++) {
		    	var colCount = tb.rows[i].cells.length; //   列数  
		        for (j = 0; j < colCount; j++) {
		            tb.rows[i].cells[j].id = "tb__" + i.toString() + "_" + j.toString();
		        }
		    }
	  	}

	  	if(beginRow == null || beginRow == "" || beginRow == "-1")
	  	{
		  	beginRow = 0;
	  	}
	  	if(endRow == null || endRow == ""  || endRow == "-1")
	  	{
		  	endRow = rowCount - 1;
	  	}
	  	if(beginCol == null || beginCol == "" || beginCol == "-1")
	  	{
	  		beginCol = 0;
	  	}
	  	if(endCol == null || endCol == "" || endCol == "-1")
	  	{
	  		endCol = colCount - 1;
	  	}
	  	
	  	beginRow += rowOffSet;
	  	endRow += rowOffSet;
	  	beginCol += colOffSet;
	  	endCol += colOffSet;
	  		
	    //   逐列检查合并  
	    for (i = beginCol; i <= endCol; i++) {
	        if (i > endCol) return;
	        obj1 = document.getElementById("tb__0_" + i.toString());
	        for (j = 1; j < rowCount; j++) {
	            obj2 = document.getElementById("tb__" + j.toString() + "_" + i.toString());
	            if (obj1.innerText == obj2.innerText) {
	            	//避免单元格合并与节点的合并出现交错的情况
	            	if(i == beginCol)
	            	{
	            		obj1.rowSpan++;
	                	obj2.parentNode.removeChild(obj2);
	            	}
	            	else if(obj2 == obj2.parentNode.children[0])
	            	{
	            		
	            		obj1.rowSpan++;
	                	obj2.parentNode.removeChild(obj2);
	            	}
	            	else
	            	{
	            		obj1 = document.getElementById("tb__" + j.toString() + "_" + i.toString());
	            	}
	            } else {
	                obj1 = document.getElementById("tb__" + j.toString() + "_" + i.toString());
	            }
	        }
	    }
	}
	
	///////////////////////////////////////////////  
	//   功能：合并表格
	//   参数：tb－－需要合并的表格ID
	//   参数：beginCol－－需要进行合并的开始列
	//   参数：endCol－－需要进行合并的结束列列
	//   参数：value－－对beginCol值为value的行进行行合并
	///////////////////////////////////////////////  
	function uniteTableCol(tb, rules, resetid, unitetype, value, beginRow, endRow, beginCol, endCol, offset)
	{
		if(offset == null || offset == "")
		{
			offset = "0;0";
		}
		var offsets = offset.split(";");
		if(offsets.length < 2) return;
		var rowOffSet = Number(offsets[0]);
		var colOffSet = Number(offsets[1]);
		
		if(beginCol > endCol || beginRow > endRow) return;
		//是否要检测table是否规整（即无合并行和列）
	    if(rules == "1")
	    {
	    	//检查表格是否规整  
	    	if (!checkTable(tb)) return;
	    }
	    
		var i = 0;
	    var j = 0;
	    var rowCount = tb.rows.length; //   行数  
	    var colCount = tb.rows[i].cells.length; //   列数  
	    var obj1 = null;
	    var obj2 = null;
	  	//判断是否需要对单元格重新设置ID
	  	if(resetid == "1")
	  	{
		  	//为每个单元格重新设置ID
	        for (i = 0; i < rowCount; i++) {
		    	colCount = tb.rows[i].cells.length; //   列数  
		        for (j = 0; j < colCount; j++) {
		            tb.rows[i].cells[j].id = "tb__" + i.toString() + "_" + j.toString();
		        }
		    }
	  	}
	  	
	  	if(beginRow == null || beginRow == "" || beginRow == "-1")
	  	{
		  	beginRow = 0;
	  	}
	  	if(endRow == null || endRow == ""  || endRow == "-1")
	  	{
		  	endRow = rowCount - 1;
	  	}
	  	if(beginCol == null || beginCol == "" || beginCol == "-1")
	  	{
	  		beginCol = 0;
	  	}
	  	if(endCol == null || endCol == "" || endCol == "-1")
	  	{
	  		endCol = colCount - 1;
	  	}
	  	
	  	beginRow += rowOffSet;
	  	endRow += rowOffSet;
	  	beginCol += colOffSet;
	  	endCol += colOffSet;

	  	if (unitetype == null || unitetype == "1")
	  	{
	  		unitetype = "1";
	  	}
		
	  	if (unitetype == "1")
	  	{
		    //逐行检查合并  
		    for (i = beginRow; i <= endRow; i++){
		        //if (i == colLength) return;
		        obj1 = document.getElementById("tb__" + i.toString() + "_" + beginCol.toString());
		        if(obj1 != null)
		        //if(obj1.parentNode.cells.length == tb.rows[0].cells.length)
		        {
		        	if(obj1.innerText == value)
		            {
		                for (j = beginCol + 1; j <= endCol; j ++) {
		                    obj2 = document.getElementById("tb__" + i.toString() + "_" + j.toString());
		                    //不用判断，直接合并，用于
		                    obj1.colSpan ++;
		                    obj2.parentNode.removeChild(obj2);
		                    obj1.style.width = Number(obj1.style.width.replace('px','')) + Number(obj2.style.width.replace('px',''));
		                }
		        	}
		        }
		    }
	  	}
	  	else if (unitetype == "2")
		{
		  	//逐行检查合并  
		    for (i = beginRow; i <= endRow; i++) {
		        obj1 = document.getElementById("tb__" + i.toString() + "_" + beginCol.toString());
		        if(obj1 == null)
		        {
			        break;
		        }
		        for (j = beginCol + 1; j <= endCol; j++) {
		            obj2 = document.getElementById("tb__" + i.toString() + "_" + j.toString());
		            if(obj2 == null)
		            {
			            break;
		            }
		            if (obj1.innerText == obj2.innerText) {
		            	//避免单元格合并与节点的合并出现交错的情况
		            	if(obj1.rowSpan == obj2.rowSpan && obj1.parentNode == obj2.parentNode)
		            	{
		            		obj1.colSpan ++;
		                	obj2.parentNode.removeChild(obj2);
		                	obj1.style.width = Number(obj1.style.width.replace('px','')) + Number(obj2.style.width.replace('px',''));
		            	}
		            	else
		            	{
		            		obj1 = obj2;//document.getElementById("tb__" + j.toString() + "_" + i.toString());
		            	}
		            } else {
		            	obj1 = obj2;//document.getElementById("tb__" + j.toString() + "_" + i.toString());
		            }
		        }
		    }
	  	}
	}
	
	/////////////////////////////////////////
	//   功能：检查表格是否规整
	//   参数：tb－－需要检查的表格ID
	/////////////////////////////////////////
	function checkTable(tb) {
		if (tb.rows.length == 0) return false;
	    if (tb.rows[0].cells.length == 0) return false;
	    for (var i = 0; i < tb.rows.length; i++) {
	        if (tb.rows[0].cells.length != tb.rows[i].cells.length) return false;
	    }
	    return true;
	}
	
	//给规整的表格，增加单元格ID
	function setTableTd(tb)
	{
		var rowCount = tb.rows.length; //   行数  
	    var obj1 = null;
	    var obj2 = null;
	    //   为每个单元格命名  
	    for (i = 0; i < rowCount; i++) {
	    	var colCount = tb.rows[i].cells.length; //   列数  
	        for (j = 0; j < colCount; j++) {
	            tb.rows[i].cells[j].id = "tb__" + i.toString() + "_" + j.toString();
	        }
	    }
	}
	
	/////////////////////////////////////////
	//   功能：对于指定范围内的TD，设置ID值
	//   参数：tb－－需要检查的表格ID
	/////////////////////////////////////////
	function setTdId(tb, beginRow, endRow, beginCol, endCol) {
		var rowCount = tb.rows.length;
		var colCount = tb.rows[0].cells.length;

		if(beginRow == null || beginRow == "")
		{
			beginRow = 0;
		}
		if(endRow == null || endRow == "")
		{
			endRow = rowCount - 1;
		}
		if(beginCol == null || beginCol == "")
		{
			beginCol = 0;
		}
		if(endCol == null || endCol == "")
		{
			endCol = colCount - 1;
		}
		
		//清空所有td的id值
		for (var i = 0; i < rowCount; i++) {
	    	colCount = tb.rows[i].cells.length; //   列数  
	        for (var j = 0; j < colCount; j++) {
	            tb.rows[i].cells[j].id = "";
	        }
	    }

	  	//为指定范围的每个单元格重新设置ID
        for (var i = beginRow; i < endRow; i++) {
	    	colCount = tb.rows[i].cells.length; //   列数  
	        for (var j = beginCol; j < endCol; j++) {
	            tb.rows[i].cells[j].id = "tb__" + i.toString() + "_" + j.toString();
	        }
	    }
	    
	}

	function setCenter(tb) {
		if (tb.rows.length == 0) return false;
	    if (tb.rows[0].cells.length == 0) return false;
	    for (var i = 0; i < tb.rows.length; i++) {
	        var row = tb.rows[i];
	        for(var j = 0; j < row.cells.length; j ++)
	        {
		        alert(tb.rows[i].cells[j].innerText);
		        //tb.rows[i].cells[j].style.textAlign = "right";
	        }
	    }
	    return true;
	}
	
//==================================================================================================

function updatePageStatus(uri, inteval, userid, username, tablename, tableid)
{
	try
	{
		var url = "/atic/CommonExecSql";
		var insertsql = "insert into PAGEOPENEDRECORD(PAGEURI, OPENEDDATE, REFRESHINTERVAL, OPENERID, OPENERNAME, OPENEDTABLE, OPENEDID)" 
				+ " values ('" + uri + "',sysdate,'" + inteval + "','" + userid + "','" + username + "', upper('" + tablename + "'), '" + tableid + "')";
		var updatesql = "update PAGEOPENEDRECORD set PAGEURI = '" + uri + "', OPENEDDATE = sysdate, REFRESHINTERVAL = '" + inteval + "', OPENERID = '" + userid + "', OPENERNAME = '" + username + "' " 
				+ " where OPENEDTABLE = upper('" + tablename + "') and OPENEDID = '" + tableid + "'";
		//全部基于返回单条记录
		//optype：0、查询；1、新增；2、修改；3、删除；4、修改或新增；
		var param = "optype=4&insertsql=" + encodeURIComponent(insertsql) + "&updatesql=" + encodeURIComponent(updatesql);
		//返回xml数据格式
		ajaxRequest(url,param,function(response){
			var vReValue = response.responseText;
			/*
			var dom = new ActiveXObject("Microsoft.XMLDOM");
			dom.loadXML(vReValue);//默认节点为根节点
			var vRootNode = dom.selectSingleNode("/root");
			var pNode = getNode(vRootNode,"__MESSAGE");
		    var childNode = pNode.childNodes[1];
			var childNode0 = pNode.childNodes[0];
			*/
		});	
	}
	catch(e)
	{
	}
}

//==================================================================================================
	
/* innerhtml.js   
* Copyright Ma Bingyao <andot@ujn.edu.cn>   
* Version: 1.9   
* LastModified: 2006-06-04   
* This library is free.  You can redistribute it and/or modify it.   
* http://www.coolcode.cn/?p=117   
*/

var global_html_pool = [];
var global_script_pool = [];
var global_script_src_pool = [];
var global_lock_pool = [];
var innerhtml_lock = null;
var document_buffer = "";

function set_innerHTML(obj_id, html, time) {
    if (innerhtml_lock == null) {
        innerhtml_lock = obj_id;
    } else if (typeof(time) == "undefined") {
        global_lock_pool[obj_id + "_html"] = html;
        window.setTimeout("set_innerHTML('" + obj_id + "', global_lock_pool['" + obj_id + "_html']);", 10);
        return;
    } else if (innerhtml_lock != obj_id) {
        global_lock_pool[obj_id + "_html"] = html;
        window.setTimeout("set_innerHTML('" + obj_id + "', global_lock_pool['" + obj_id + "_html'], " + time + ");", 10);
        return;
    }

    function get_script_id() {
        return "script_" + (new Date()).getTime().toString(36) + Math.floor(Math.random() * 100000000).toString(36);
    }

    document_buffer = "";

    document.write = function(str) {
        document_buffer += str;
    }
    document.writeln = function(str) {
        document_buffer += str + "\n";
    }

    global_html_pool = [];

    var scripts = [];
    html = html.split(/<\/script>/i);
    for (var i = 0; i < html.length; i++) {
        global_html_pool[i] = html[i].replace(/<script[\s\S]*$/ig, "");
        scripts[i] = {
            text: '',
            src: ''
        };
        scripts[i].text = html[i].substr(global_html_pool[i].length);
        scripts[i].src = scripts[i].text.substr(0, scripts[i].text.indexOf('>') + 1);
        scripts[i].src = scripts[i].src.match(/src\s*=\s*(\"([^\"]*)\"|\'([^\']*)\'|([^\s]*)[\s>])/i);
        if (scripts[i].src) {
            if (scripts[i].src[2]) {
                scripts[i].src = scripts[i].src[2];
            } else if (scripts[i].src[3]) {
                scripts[i].src = scripts[i].src[3];
            } else if (scripts[i].src[4]) {
                scripts[i].src = scripts[i].src[4];
            } else {
                scripts[i].src = "";
            }
            scripts[i].text = "";
        } else {
            scripts[i].src = "";
            scripts[i].text = scripts[i].text.substr(scripts[i].text.indexOf('>') + 1);
            scripts[i].text = scripts[i].text.replace(/^\s*<\!--\s*/g, "");
        }
    }

    var s;
    if (typeof(time) == "undefined") {
        s = 0;
    } else {
        s = time;
    }

    var script, add_script, remove_script;

    for (var i = 0; i < scripts.length; i++) {
        var add_html = "document_buffer += global_html_pool[" + i + "];\n";
        add_html += "document.getElementById('" + obj_id + "').innerHTML = document_buffer;\n";
        script = document.createElement("script");
        if (scripts[i].src) {
            script.src = scripts[i].src;
            if (typeof(global_script_src_pool[script.src]) == "undefined") {
                global_script_src_pool[script.src] = true;
                s += 2000;
            } else {
                s += 10;
            }
        } else {
            script.text = scripts[i].text;
            s += 10;
        }
        script.defer = true;
        script.type = "text/javascript";
        script.id = get_script_id();
        global_script_pool[script.id] = script;
        add_script = add_html;
        add_script += "document.getElementsByTagName('head').item(0)";
        add_script += ".appendChild(global_script_pool['" + script.id + "']);\n";
        window.setTimeout(add_script, s);
        remove_script = "document.getElementsByTagName('head').item(0)";
        remove_script += ".removeChild(document.getElementById('" + script.id + "'));\n";
        remove_script += "delete global_script_pool['" + script.id + "'];\n";
        window.setTimeout(remove_script, s + 10000);
    }

    var end_script = "if (document_buffer.match(/<\\/script>/i)) {\n";
    end_script += "set_innerHTML('" + obj_id + "', document_buffer, " + s + ");\n";
    end_script += "}\n";
    end_script += "else {\n";
    end_script += "document.getElementById('" + obj_id + "').innerHTML = document_buffer;\n";
    end_script += "innerhtml_lock = null;\n";
    end_script += "}";
    window.setTimeout(end_script, s);
}

function set_innerHTML2(obj_id, html, time) {
    if (innerhtml_lock == null) {
        innerhtml_lock = obj_id;
    } else if (typeof(time) == "undefined") {
        global_lock_pool[obj_id + "_html"] = html;
        window.setTimeout("set_innerHTML('" + obj_id + "', global_lock_pool['" + obj_id + "_html']);", 10);
        return;
    } else if (innerhtml_lock != obj_id) {
        global_lock_pool[obj_id + "_html"] = html;
        window.setTimeout("set_innerHTML('" + obj_id + "', global_lock_pool['" + obj_id + "_html'], " + time + ");", 10);
        return;
    }

    function get_script_id() {
        return "script_" + (new Date()).getTime().toString(36) + Math.floor(Math.random() * 100000000).toString(36);
    }

    document_buffer = "";

    document.write = function(str) {
        document_buffer += str;
    }
    document.writeln = function(str) {
        document_buffer += str + "\n";
    }

    global_html_pool = [];

    var scripts = [];
    html = html.split(/<\/script>/i);
    for (var i = 0; i < html.length; i++) {
        global_html_pool[i] = html[i].replace(/<script[\s\S]*$/ig, "");
        scripts[i] = {
            text: '',
            src: ''
        };
        scripts[i].text = html[i].substr(global_html_pool[i].length);
        scripts[i].src = scripts[i].text.substr(0, scripts[i].text.indexOf('>') + 1);
        scripts[i].src = scripts[i].src.match(/src\s*=\s*(\"([^\"]*)\"|\'([^\']*)\'|([^\s]*)[\s>])/i);
        if (scripts[i].src) {
            if (scripts[i].src[2]) {
                scripts[i].src = scripts[i].src[2];
            } else if (scripts[i].src[3]) {
                scripts[i].src = scripts[i].src[3];
            } else if (scripts[i].src[4]) {
                scripts[i].src = scripts[i].src[4];
            } else {
                scripts[i].src = "";
            }
            scripts[i].text = "";
        } else {
            scripts[i].src = "";
            scripts[i].text = scripts[i].text.substr(scripts[i].text.indexOf('>') + 1);
            scripts[i].text = scripts[i].text.replace(/^\s*<\!--\s*/g, "");
        }
    }

    var s;
    if (typeof(time) == "undefined") {
        s = 0;
    } else {
        s = time;
    }

    var script, add_script, remove_script;

    for (var i = 0; i < scripts.length; i++) {
        var add_html = "document_buffer += global_html_pool[" + i + "];\n";
        add_html += "document.getElementById('" + obj_id + "').innerHTML = document_buffer;\n";
        script = document.createElement("script");
        if (scripts[i].src) {
            script.src = scripts[i].src;
            if (typeof(global_script_src_pool[script.src]) == "undefined") {
                global_script_src_pool[script.src] = true;
                s += 2000;
            } else {
                s += 10;
            }
        } else {
            script.text = scripts[i].text;
            s += 10;
        }
        script.defer = true;
        script.type = "text/javascript";
        script.id = get_script_id();
        global_script_pool[script.id] = script;
        add_script = add_html;
        add_script += "document.getElementsByTagName('head').item(0)";
        add_script += ".appendChild(global_script_pool['" + script.id + "']);\n";
        window.setTimeout(add_script, s);
        remove_script = "document.getElementsByTagName('head').item(0)";
        remove_script += ".removeChild(document.getElementById('" + script.id + "'));\n";
        remove_script += "delete global_script_pool['" + script.id + "'];\n";
        window.setTimeout(remove_script, s + 10000);
    }

    var end_script = "if (document_buffer.match(/<\\/script>/i)) {\n";
    end_script += "set_innerHTML('" + obj_id + "', document_buffer, " + s + ");\n";
    end_script += "}\n";
    end_script += "else {\n";
    end_script += "document.getElementById('" + obj_id + "').innerHTML = document_buffer;\n";
    end_script += "innerhtml_lock = null;\n";
    end_script += "}";
    //window.setTimeout(end_script, s);
}
