function   selectObj(obj)
{
	  obj.focus();obj.select();
}

//���� ����С��max������min ���� ����object ��max��min
function checkIntegerMaxMin(obj,max,min ,name){
	if(!isIntegerMaxMin(obj,max,min))
	{
	   alert(name+"��ֵ���벻С��"+min+"�Ҳ�����"+max);
	   obj.focus();obj.select();  
	   return false;
	}
}

//��������� ����С��max������min ���� ����object ��max��min
function checkTatolIntMaxMin(obj,max,min ,name){
	if(!isIntegerMaxMin(obj,max,min))
	{
	   alert(name+"��ֵ���벻С��"+min+"�Ҳ�����"+max);
	   obj.focus();
	   obj.select();  
	   return false;
	}
}



var  countFocus=0;

//�������ж�
function checkIsNum(obj){
	var reg = /^([0-9]+[\.]?[0-9]+|\d+)$/; 
	var vs=obj.value*1;
	if(obj.value!=null){ 
		if(! reg.test(vs)&&countFocus==0) {
			countFocus=1;
			alert("�����ֵӦΪ�����ͣ�"); 
			
			//obj.value=1;
			valiInt(obj)
			//obj.focus();
			countFocus=0;
			obj.select();  
			return false;
		} 
	}
}


// ֻ����������
function valiInt(obj){
	if (event.keyCode == 9 || event.keyCode==37 ||event.keyCode==39) { 
		return;
	}
	// Remove the char out of number
	obj.value = obj.value.replace(/[^\d]/g,"");
	
}

//�������ж�
function checkIsNum_All(obj){
	var reg =/^([0-9]+[\.]?[0-9]+|\d+)$/; 
	var vs=obj.value.replace("-","")*1;
	if(obj.value!=null){ 
		if(! reg.test(vs)) {
			alert("�����ֵӦΪ�����ͣ�"); 
			obj.value=1;
			obj.focus();
			obj.select();  
			return false;
		} 
	}
}

//У���ַ����ȹ������� ����ob,��󳤶�maxLen����Ϣmessage
function stringLengthCheck(ob,maxLen,message){
	if(byteLength(trim(ob.value))>maxLen){
		alert(message);ob.focus();
		return false;
	}
	return true;
}
//�Ƿ����������
function __isQuoteIn(obj)
{
	var s=obj.value;
	var re = /\"|\'|\>/; 
    if(re.test(s))
	{
		
	  alert("��������ݲ��ܰ��������ַ�:"+re);
	  obj.focus();obj.select();  
	}
	return re.test(s);//alert(re.test(s))
}

//***����table�ڵ�input �ǿ�ݷ�ʽ  onkeydown=\"setTabKey(event,this)\";

function setTabKey(e,obj){
	
	var kCode=e.keyCode;
	var table=obj;
	var selectedTd=e.srcElement.parentNode;
	var selectedTr=selectedTd.parentNode;
	//�����»س������        �� 37 �� 38  �� 39 �� 40
	if(kCode==13){
		if(selectedTr.rowIndex+1!=table.rows.length){
			var nextTd=table.rows[selectedTr.rowIndex+1].cells[1];
			if(nextTd.childNodes.length>0){
				nextFocus(nextTd);
			}
		}

	}
	//�����¡�
	else if(kCode==37){
		e.returnValue = false;  
		var nextTd=table.rows[selectedTr.rowIndex].cells[selectedTd.cellIndex-1];
		if(nextTd.childNodes.length>0){
			nextFocus(nextTd);
		}
	}
	//�����¡�
	else if(kCode==38){
		if(selectedTr.rowIndex!=0){
			var nextTd=table.rows[selectedTr.rowIndex-1].cells[selectedTd.cellIndex];
			if(nextTd.childNodes.length>0){
				nextFocus(nextTd);
			}
		}
	}
	//�����¡�
	else if(kCode==39){ 
		e.returnValue = false; 
		if(selectedTd.cellIndex+1!=table.rows[0].cells.length){
			var nextTd=table.rows[selectedTr.rowIndex].cells[selectedTd.cellIndex+1];
			if(nextTd.childNodes.length>0){
				nextFocus(nextTd);
			}
		}
	}
	//�����¡�
	else if(kCode==40){
		if(selectedTr.rowIndex+1!=table.rows.length){
			var nextTd=table.rows[selectedTr.rowIndex+1].cells[selectedTd.cellIndex];
			if(nextTd.childNodes.length>0){
				nextFocus(nextTd);
			}
		}
	}
}


function nextFocus(nextTd){
	if(nextTd.childNodes){
		var children=nextTd.childNodes;
		for (var i=0;i<children.length ;i++ )
		{
		//toUpperCase
		//toLowerCase
			if(children[i].nodeName.toLowerCase()=="input"||children[i].nodeName.toLowerCase()=="textarea"){
				if (children[i].nodeName.toLowerCase()=="input"&&children[i].type.toLowerCase()=="text")
				{ 
					children[i].focus();
					children[i].select(); 
					 
				}else if(children[i].nodeName.toLowerCase()=="textarea"){
					children[i].focus(); 
					children[i].select(); 
				}
			}
		}
	}
}



//setTableStyle("�������","�����б���","ż���б���","��꾭������","����󱳾�");var obj=event.srcElement;
function setTableStyle(o,a,b,c,d){
  var t=document.getElementById(o).getElementsByTagName("tr");
  for(var i=0;i<t.length;i++){
     if(i==0){continue;}
      t[i].className=(t[i].sectionRowIndex%2==0)?a:b;
      t[i].onclick=function(){
	        if(this.x!="1"){
	        this.x="1";//��������ֱ���ñ���ɫ�жϣ�FF��ȡ���ı�����RGBֵ�������ж�
	        //this.className=d;
	        }else{
	        this.x="0";
	      //  this.className=(this.sectionRowIndex%2==0)?a:b;
	        }
      }
      t[i].onmouseover=function(){
        // if(this.className!=d)this.className=c;
      }
      t[i].onmouseout=function(){
        //if(this.className!=d)this.className=(this.sectionRowIndex%2==0)?a:b;
      }
      
        if(i%2==0)
      	{
      	  var tds=  t[i].getElementsByTagName("td");
      	  for(var j=0;j<tds.length-1;j++)
      	  {
      		  
      		   tds[j].style.borderRight="1px dashed #f8c069";
      	  }
      	}
        else
      		{
      		 var tds=  t[i].getElementsByTagName("td");
	        	  for(var j=0;j<tds.length;j++)
	        	  {
	        		  
	        		   tds[j].style.borderRight="0px solid #f8c069";
	        	  }
      		
      		}
  }
}


// �ı�����ɫ
function chkRow(obj){
  var r = obj.parentElement.parentElement;
  if(obj.checked){ r.className="tr_onclick";}
    else {  
       r.className=(r.sectionRowIndex%2==0)?"tr0":"tr1";
     } 
}
  
// �ı�����ɫ
function SetRadioCheck(){
	var checkNames=document.getElementsByName("chk");
		 
	  for(var j=0; j<checkNames.length; j++){
		 var r =checkNames[j].parentElement.parentElement; 
	    if( checkNames[j].checked)
	    {
	    	r.className="tr_onclick";
	    }else{
           r.className=(r.sectionRowIndex%2==0)?"tr0":"tr1";
	    }
	  }
		 
}
//ѡ���� ���Ҹı�����ɫ
function SetGVCheck(){
var checkNames=document.getElementsByName("chk");
	 if(document.getElementById("GridViewCheckAll").checked==true){
		for(var i=0; i<checkNames.length;i++){
			if(checkNames[i].checked){
				checkNames[i].checked=false;
				
			}else{
			checkNames[i].checked=true;
			}
          chkRow(checkNames[i]);
		}//for
	    }else
	    {//if
		  for(var j=0; j<checkNames.length; j++){
		     checkNames[j].checked=false;
	        chkRow(checkNames[j]);
	       
		  }
	}//if
}
//ȫѡ
function selectAll(){
var checkNames=document.getElementsByName("chk"); 
	for(var i=0; i<checkNames.length;i++){
		if(checkNames[i].checked){
			 //checkNames[i].checked=false;
			
		}else{
		    checkNames[i].checked=true;
		}
     // chkRow(checkNames[i]);
	}//for
	 
}
//��ѡ
function selectAll_no(){
var checkNames=document.getElementsByName("chk"); 
	for(var i=0; i<checkNames.length;i++){
		if(checkNames[i].checked){
			checkNames[i].checked=false;
			
		}else{
		    checkNames[i].checked=true;
		}
     // chkRow(checkNames[i]);
	}//for
	 
}
//��������
function addMenu(){
  if(!getSelects()) return;
    var primaryKey=grid.getCheckLine();
    // alert(primaryKey);
    var x1=Math.round((screen.availWidth - x)/2); 
	var y1=Math.round((screen.availHeight - y)/2);	
	var x=680,y=500;	
 
	var url="<%=request.getContextPath()%>/repastForm/dealOrder.so?type=3&PKID="+primaryKey;	
	//var win=window.open(url,'','toolbar=0,location=0,directories=0,status=1,menubar=0,scrollbars=1,resizable=1,left='+x1+',top='+y1+',width='+x+',height='+y);
	var ReturnValue = window.showModalDialog(url, 'newWindow', 'dialogWidth:' + x + 'px;dialogHeight:' + y + 'px;dialogTop:'+y1+';help:no;unadorned:no;resizable:no;status:no;center:yes');
	return ReturnValue;
	//win.focus();  
}

//ѡ����  ���ҽ�ֵ������̨
function saveGVCheck(actionurl,tagIDs){
	var checkNames=document.getElementsByName("chk");
		 var  isAdd=false;
		 var  strIDs=""; 
		  for(var j=0; j<checkNames.length; j++){
	        if(checkNames[j].checked){
	          isAdd=true;
	          if(tagIDs)
	          {//ȡ����������
	        	  var tagIDss=tagIDs.split(",");
	              strIDs+=checkNames[j].value;
		          for(var i=0;i<tagIDss.length;i++)
		          {
		        	  strIDs+="~ "+ document.getElementById(tagIDss[i]+"_"+ checkNames[j].value).value ;
		          }
	        	  strIDs+=",";
	          }else{
	           strIDs+=checkNames[j].value+",";
	          }
	        }
		  }
		  if(isAdd)
		  {
			  strIDs=strIDs.substring(0, strIDs.length - 1); 
			 //  debugger; 
			  if(actionurl)
			  {
			  document.forms[0].action =actionurl+"&PKID="+strIDs;  
			  document.forms[0].submit();  
				return  true;//" self.location=self.location";
			  }else
			  {
				  return strIDs;
			  }
		  }else{
			  alert("������ѡ��һ����¼!");
			  return false;
		  }
}
//����id�� �� id  ������
function returnCheck(name){
	var checkNames=document.getElementsByName("chk");
		 var  isAdd=false;
		 var  returnVs=[];
		 var  strIDs=""; 
		 var  strNames=""; 
		  for(var j=0; j<checkNames.length; j++){
	        if(checkNames[j].checked){
	          isAdd=true;
	          strIDs+=checkNames[j].value+",";
	         
	          strNames+= document.getElementById(name+"_"+ checkNames[j].value).innerHTML+",";
	        }
		  }
	 
		  if(isAdd)
		  {
			  strIDs=strIDs.substring(0, strIDs.length - 1); 
			  strNames=strNames.substring(0, strNames.length - 1); 
			  returnVs["id"]=strIDs;
			  returnVs["name"]=strNames;
			  window.returnValue= returnVs;
			  
				self.close();
				return  true;//" self.location=self.location";
		  }else{
			  alert("������ѡ��һ����¼!");
			  return false;
		  }
}


//����ʱ��
function setTime(id){
	var today=new Date();
	var year=today.getYear();
	var month=today.getMonth()+1;
	var day=today.getDate();
	var hours = today.getHours();
	var minutes = today.getMinutes();
	var seconds = today.getSeconds();
	
	var timeText = year+"-"+month+"-"+day+" "+hours+":"+minutes+":"+seconds;
	document.getElementById(id).value=timeText;
	//return timeText; 
}
//��������
function setDate(id){
	var today=new Date();
	var year=today.getYear();
	var month=today.getMonth()+1;
	var day=today.getDate();
	var hours = today.getHours();
	var minutes = today.getMinutes();
	var seconds = today.getSeconds();
	
	var timeText = year+"-"+month+"-"+day;
	document.getElementById(id).value=timeText;
	//return timeText; 
}



function trim(){
	if(arguments.length<1)
		return null;
	if(typeof(arguments[0])=="string")
		return arguments[0].replace(/(^\s*)|(\s*$)/g, "");
	else
		return "";
}
function ltrim(){
	if(arguments.length<1)
		return null;
	if(typeof(arguments[0])=="string")
		return arguments[0].replace(/(^\s*)/g, "");
	else
		return "";
}

function checkIsNull(obj,message)
{
	obj.value=  rtrim(obj.value);
	if(obj.value==null||obj.value=="")
	{
		alert(message);
	}
}

//�ַ�ȥ�����ҿո���
function rtrim(){
	if(arguments.length<1)
		return null;
	if(typeof(arguments[0])=="string")
		return arguments[0].replace(/(\s*$)/g, "");
	else
		return "";
}
//����У�麯��  �Ƿ������� 
function __isNum(s)
{
	var re = /^[0-9]+$/;
	return re.test(s);
}
//�Ƿ���Float
function __isFloat(s)
{
	if (__isNum(s)) return true;
	var re = /^[+|-]{0,1}\d*\.?\d+$/;
	return re.test(s);
}
//�Ƿ��ǿ�ѧ������Float
function __isEFloat(s)
{
    var re = /^[+|-]{0,1}\d*\.[\.\d+]{0,1}\e[-|+]{0,1}\d+$/;
    return re.test(s);
}

//���� ����С��max������min ���� ����object ��max��min
function isIntegerMaxMin(ob,max,min){
	var value=parseInt(ob.value);
	return ((value==ob.value)&&(value<=max)&&(value>=min));
}

//�Ƿ�������  ����  ����
function isInteger(ob,type){
	//var value=parseInt(ob.value);
	//return (value==ob.value);
	if(type=="positive")
	return /^\+?\d+$/g.test(ob.value);
	else if (type=="negative")
	return /^-\d+$/g.test(ob.value);
	else
	return /^(?:-?|\+?)\d+$/g.test(ob.value);
}
//�ж϶����ֵ�Ƿ������� ����  ����
function checkNum(eSrc)
{
	var value = eSrc.value;
	return __isNum(value);

}
//�ж϶����ֵ�Ƿ���С������  ���� ����
function checkFloat(eSrc)
{
	var value = eSrc.value;
	return __isFloat(value);
}
//�ж϶����ֵ�Ƿ��ǿ�ѧ��������  ���� ����
function checkEFloat(eSrc)
{
	var value = eSrc.value;
	return __isEFloat(value);
}
//�ַ��Ƿ�
function __isNumChar(ch)
{
	return (ch >= '0' && ch <= '9');
}
//�Ƿ��ǿո�ת�е�
function __isBlankChar(ch)
{
	//ȥ����'\v';20020522   
	return (ch == ' ' || ch == '\f' || ch == '\n' || ch == '\r' || ch=='\t');
}
//����ַ����ĳ���   һ������ռ2���ֽ�
function byteLength(str)
{
	var re=/[\u4E00-\u9FA5]/g;
	if(re.test(str))
    return str.length+str.match(re).length;
	else return str.length;

}
//У���ַ����ȹ������� ����ob,��󳤶�maxLen����Ϣmessage
function stringLengthCheck(ob,maxLen,message){
	if(byteLength(trim(ob.value))>maxLen){
		alert(message);ob.focus();
		return false;
	}
	return true;
}

//����ַ����ĳ���   һ������ռ2���ֽ�
function byteLength(str)
{
	var re=/[\u4E00-\u9FA5]/g;
	if(re.test(str))
    return str.length+str.match(re).length;
	else return str.length;

}


//��ѧ���� ��ʽ������(��ȡС����������)   ���� ����ֵvalue��С��λ
function __formatNum(value,scale){
	var f = parseFloat(value);
	if(scale<0)scale=0;
	return f.toFixed(scale);
}
//��ѧ���� ��ʽ������   ���� ����ֵvalue��С��λ
function __setScale( value , scale )
{
	if( isNaN( value ) || isNaN( scale ) || parseInt( scale ) < 0 )
		return new String( value ) ;

	var strValue = new String( value ) ;
	var fValue = parseFloat( value ) ;
	var iScale = parseInt( scale ) ;
	
	if( iScale == 0 )
		return new String( ( fValue < 0.0 ? "-" : "" ) + Math.round( Math.abs( fValue ) ) ) ;
		
	if( fValue == parseInt( strValue ) )  //����Ĳ���û��С������
	{	
		strValue = new String( parseInt( strValue ) ) + "." ;

		for( var i = 0 ; i < iScale ; i ++ )
			strValue += "0" ;
	}
	else 
	{
		var fDecimal = Math.abs( fValue - parseInt( strValue ) ) ;
		fDecimal = Math.round( fDecimal * Math.pow( 10 , iScale ) ) ;
		var strDecimal = new String( fDecimal ) ;
		//������ new String( Math.round( 0.07 * Math.pow( 10 , 2 ) ) ) == "7" but not "07" �����������Ҫ�����²��㴦��
		if( strDecimal.length < iScale ) 
		{
			var iDecimalLength = strDecimal.length ;
			
			for( var i = 0 ; i < iScale - iDecimalLength ; i ++ )
				strDecimal = "0" + strDecimal ;
	
			strValue = new String( parseInt( strValue ) ) + "." + strDecimal ;
		}
		//������ new String( Math.round( 0.995 * Math.pow( 10 , 2 ) ) ) == "100" �����������Ҫ�����²��㴦��
		else if( strDecimal.length > iScale ) 
		{
			strValue = new String( parseInt( strValue ) + 1 ) ;			
			
			strValue += "." ;
			for( var i = 0 ; i < iScale ; i ++ )
				strValue += "0" ;
		}
		else
			strValue = new String( parseInt( strValue ) ) + "." + strDecimal ;
	}
	
	return strValue ;
}



//�������ӷ�����
function FloatAdd(arg1,arg2){
  var r1,r2,m;
  try{r1=arg1.toString().split(".")[1].length}catch(e){r1=0}
  try{r2=arg2.toString().split(".")[1].length}catch(e){r2=0}
  m=Math.pow(10,Math.max(r1,r2));
  return (arg1*m+arg2*m)/m;
}

//��������������
function FloatSub(arg1,arg2){
  var r1,r2,m,n;
  try{r1=arg1.toString().split(".")[1].length}catch(e){r1=0}
  try{r2=arg2.toString().split(".")[1].length}catch(e){r2=0}
  m=Math.pow(10,Math.max(r1,r2));
  //��̬���ƾ��ȳ���
 // n=(r1&gt;=r2)?r1:r2;
  return ((arg1*m-arg2*m)/m).toFixed(n);
}

//�������˷�����
function FloatMul(arg1,arg2)
{
  var m=0,s1=arg1.toString(),s2=arg2.toString();
  try{m+=s1.split(".")[1].length}catch(e){}
  try{m+=s2.split(".")[1].length}catch(e){}
  return Number(s1.replace(".",""))*Number(s2.replace(".",""))/Math.pow(10,m);
}


 //��������������
function FloatDiv(arg1,arg2){
  var t1=0,t2=0,r1,r2;
  try{t1=arg1.toString().split(".")[1].length}catch(e){}
  try{t2=arg2.toString().split(".")[1].length}catch(e){}
  with(Math){
  r1=Number(arg1.toString().replace(".",""));
  r2=Number(arg2.toString().replace(".",""));
  return (r1/r2)*pow(10,t2-t1);
  }
}



/**********************������Ա����*******************************/
var xmlHttp ;
function createXMLHttp() {
	if (window.XMLHttpRequest) {
		xmlHttp = new XMLHttpRequest();
	} else {
		xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");	
	}
}

function showPerson(id) {
	createXMLHttp();
	xmlHttp.open("POST","workflowForm/showPerson.so?organId="+id);
	xmlHttp.onreadystatechange = showplusCallback;
	xmlHttp.send();
}
function showplusCallback() {
	if (xmlHttp.readyState == 4) {
		if (xmlHttp.status == 200) {
			var text = xmlHttp.responseText;
			var allPerson = text.split("|");
			var select = document.getElementsByName("searchApplypersonid")[0];
			select.options.length = 1;
			for (var i = 0; i < allPerson.length;i++) {
				var person = allPerson[i].split(":");
				var option = document.createElement("option");
				option.setAttribute("value",person[0]);
				var textNode = document.createTextNode(person[1]);
				option.appendChild(textNode);
			 
				if(person[0]=='<%=applydepartid%>')
				{
					alert("<%=applydepartid%>");
					option.selected=selected;
				}
				select.appendChild(option);
			}
		}else{
			alert("ִ�й����г��ִ���" + xmlHttp.status);
		} 
	}
}
//showPerson(document.getElementsByName("searchApplydepartid")[0].value);//������Ա��ֵ
/**********************������Ա����*******************************/
