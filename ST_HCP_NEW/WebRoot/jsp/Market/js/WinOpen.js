 

document.onkeydown=kdown;  
      function   kdown()  
      {  
          if   (event.keyCode==78&&event.ctrlKey)  
          {  
              return   false;  
          }  
      } 
var objNewWin;
var w=window.screen.width;
var h=window.screen.height;
 
 
function ObjExist2(id){
 try{ 
    var s=document.getElementById(id);
    if(s){return true;}
    else{return false;}
    }catch(e){ return false; }
   }
//判断对象是否存在
 function ObjExist(objId){
 	if(!objId){return null; }
	if(document.getElementById)
	{
  	    try{
              var obj=document.getElementById(objId );
 	     }
 	     catch(e)
 	       {
 	          alert('页面没找到 '+objId+' 对象！');
 	          return null; 
 	       }finally{} 
	    return eval('document.getElementById("' + objId + '")');
	}
	else if(document.layers)
	{
		return eval("document.layers['" + objId +"']");
	}else{
		return eval('document.all.' + objId);
	}
 } 
 function ExtOn(vObj,vExtObj){
  if(ObjExist(vExtObj) ){
        if(window.document.all(vExtObj).style.display=="none")
	    {
		    vObj.src="../images/up.gif";
		    window.document.all(vExtObj).style.display="";
	    }
	    else
	    {
		    vObj.src="../images/down.gif";
		    window.document.all(vExtObj).style.display="none";
	    }
    }
}
 //------Group-expand-collapse---begin---
function __FieldGroup(vOID) {
 
	if(window.document.all("__Group"+vOID).style.display=="none")
	{
		window.document.all("img"+vOID).src="../images/up.gif";
		window.document.all("__Group"+vOID).style.display="";
	}
	else
	{
		window.document.all("img"+vOID).src="../images/down.gif";
		window.document.all("__Group"+vOID).style.display="none";
	}
	for(var i=1;i<12;i++){
	    if ( ObjExist("img"+i)  &&  (i+'' != vOID )) {
	        window.document.all("img"+i).src="../images/down.gif";
	       // alert(typeof(window.document.all("__Group"+i)) );
	        
	        if(ObjExist("__Group"+i)){
		    window.document.all("__Group"+i).style.display="none";
		    }
	   }
	    
	}
}
//('001','1',2,'1','text','../../Platform/page/ListextPage.aspx?APPID=10001&flag=2',2)
function __ChangeTab(vTabID,vTabType,TabCount,iIndex,divId,vURL,vTitleType){
   
            var src="";
            if(vTitleType==""){vTitleType=="0";}
            document.getElementById( vTabID+"_"+iIndex).style.backgroundImage="url("+Path+"/jsp/Market/bar/tabbg_on"+vTitleType+".gif)";//../../App_Themes/style_dark/images/tab2.gif
            document.getElementById( vTabID+"_"+iIndex).style.fontWeight="bold";
            if(vURL==""){vURL="#";} 
             
             var tag=parseInt(iIndex,10); 
             TabCount=parseInt(TabCount)+10001;
            for(var i=10001;i<TabCount;i++){
                if(tag!=i)
                { 
                      document.getElementById('Tab_'+vTabID+"_"+i).style.display="none";
                      
                      document.getElementById("div_List_"+i).style.display="none";
                     try{
                     }catch(e)
                     {
                    	 
                     }
                     document.getElementById( vTabID+"_"+i).style.backgroundImage="url("+Path+"/jsp/Market/bar/tabbg_off"+vTitleType+".gif)";//../../App_Themes/style_dark/images/tab.gif
                     document.getElementById( vTabID+"_"+i).style.fontWeight="normal";
                }else
                	{
 
                    document.getElementById('Tab_'+vTabID+"_"+i).style.display="";
                    document.getElementById("div_List_"+i).style.display="";
                     try{
                     }catch(e)
                     {
                    	 
                     }
                	}
            }
            if(vTabType=="1"){
                //document.getElementById('__PageTab'+vTabID+"_"+iIndex).src=vURL;
                 document.getElementById('Tab_'+vTabID+"_"+iIndex).style.display="block";
                }else{
                 document.getElementById('Tab_'+vTabID+"_"+iIndex).style.display="block";
               // document.getElementById('__PageTab'+vTabID).style.display="";
              }
             
        }

function __ResizeIframe(vIframeID,vIndex) {
 //document.body.text
 //alert(vIframeID+""+document.getElementById(vIframeID).contentWindow.document.body.text);
 //alert(vIframeID);
 try{
  if ( ObjExist("__PageTab"+vIframeID+"_"+vIndex)){
        var iframe = document.getElementById("__PageTab"+vIframeID+"_"+vIndex);
        var bHeight=iframe.contentWindow.document.body.scrollHeight;
        var dHeight = iframe.contentWindow.document.documentElement.scrollHeight;
        var height = Math.max(bHeight, dHeight);
        iframe.height = height;
         eval("window.clearInterval(v"+vIframeID+"_"+vIndex +");");
     }
    }catch (ex){;}
    
   
}
/*
function __FieldGroup(vOID) {
 
	if(window.document.all("__Group"+vOID).style.display=="none")
	{
		window.document.all("img"+vOID).src="../images/up.gif";
		window.document.all("__Group"+vOID).style.display="";
	}
	else
	{
		window.document.all("img"+vOID).src="../images/down.gif";
		window.document.all("__Group"+vOID).style.display="none";
	}
	for(var i=1;i<12;i++){
	    if ( ObjExist("img"+i)  &&  (i+'' != vOID )) {
	        window.document.all("img"+i).src="../images/down.gif";
	       // alert(typeof(window.document.all("__Group"+i)) );
	        
	        if(ObjExist("__Group"+i)){
		    window.document.all("__Group"+i).style.display="none";
		    }
	   }
	    
	}
}
*/

 //弹出内容层窗口 
function OpenDivWindow(vTitle,vContent,vWinwidth,vWinHeight){
if(vTitle=="" || vTitle ==null || vTitle=="undefined"){vTitle="标题";}
if(vContent=="" || vContent ==null || vContent ==undefined ){vContent="测试内容";}

	var ScreenWidth = screen.width;
	var ScreenHeight = screen.height-209;
	var vTop=(ScreenHeight-vWinHeight)/2;
	var vLeft=(ScreenWidth-vWinwidth)/2;
	alert(vContent+vLeft+' top='+vTop+'w'+vWinwidth+"h"+ vWinHeight);
	// new DivDialog({Info:"sss",Left:vLeft,Top:vTop,Width:vWinwidth,Height:vWinHeight,Content:"sssqqqq"});
	//var aa=new DivDialog({Info:title='标题',Content:'内容',Width:360,Height:300,Left:100,Top:200,Zindex:(++DivDialog.Zindex)});
	
  new DivDialog({Info:vTitle,Left:vLeft,Top:vTop,Width:vWinwidth,Height:vWinHeight,Content:vContent,Zindex:(++DivDialog.Zindex)});
     // i++;left +=10;
}
function openWin(url, name, width, height, toolbar, statusbar, scrollbar, resizable) {
	var properties = ""
	if (width != null) {
		properties += "width=" + width + ",";
	}
	if (height != null) {
		properties += "height=" + height + ",";
	}
	if (toolbar > 0) {
		properties += "toolbar,";
	}
	if (statusbar > 0) {
		properties += "status,";
	}
	if (scrollbar > 0) {
		properties += "scrollbars,";
	}
	if (resizable > 0) {
		properties += "resizable";
	}
	if (properties != "") {
		window.open(url, name, properties);	
	}
	else {
		window.open(url, name);
	}
}
  function OpenPage(url,width,height){//打开页面设计窗口
            var strResult;
            url+="&closeFlag=1";            
            var ScreenWidth = screen.availWidth
	        var ScreenHeight = screen.availHeight
	        var StartX = (ScreenWidth - width) / 2
	        var StartY = (ScreenHeight - height) / 2
	        strResult =  window.open(url, 'newWindow1', 'left='+ StartX + ', top='+ StartY + ', Width=' + width +', height=' + height + ', resizable=yes, scrollbars=yes, status=yes, toolbar=no, menubar=no, location=no')
            strResult.focus();

		    //strResult = g_OpenWindow(url,width,height);
        }
// JScript 文件
//==========================================================================
//
//  代码描述：打开一个新的没有状态栏、工具栏、菜单栏、定位栏，
//            不能改变大小，且位置居中的新窗口
//  
//  传入参数：pageURL - 传递链接
//            innerWidth - 传递需要打开新窗口的宽度
//            innerHeight - 传递需要打开新窗口的高度
//  
//  返回参数：无
//
//==========================================================================
function OpenMaxWindow(pageURL)
{	
	var ScreenWidth = screen.width;
	var ScreenHeight = screen.height-29;
	var dt=new Date();
	var winName=dt.getMinutes()+dt.getSeconds();
	 // var ww=	window.showModelessDialog(pageURL, winName, 'dialogWidth:' + ScreenWidth + 'px;dialogHeight:' + ScreenHeight + 'px;dialogLeft:0px;dialogTop:0px;resizable:yes;help:yes;unadorned:yes;resizable:yes;status:yes;unadorned:yes;dialogHide:yes')
    var ww=	window.open(pageURL, winName, ' Width=' + ScreenWidth +', height=' + ScreenHeight + ', left=0, top=0, resizable=yes, scrollbars=no, status=yes, toolbar=yes, menubar=yes, location=yes');
    ww.resizeTo(ScreenWidth,ScreenHeight);
    window.location=window.location;
    return;
}

function openWindow(url, pWidth, pHeight, winName) {
	if(!url) return false;
	var winWidth = window.screen.availWidth; 
	var winHeight = window.screen.availHeight;
	if(!pWidth) pWidth = winWidth;
	if(!pHeight) pHeight = winHeight;
	var pleft = (winWidth - pWidth) / 2;
	if(pleft < 1) {
		pleft = 0;
		pWidth = winWidth;
	}
	var ptop = (winHeight - pHeight) / 2;
	if(ptop < 1) {
		ptop = 1;
		pHeight = winHeight;
	}
	var varOption = "dependent,toolbar=no,location=no,status=no,menubar=no,resizable=no,scrollbars=yes,"
				+ "width=" + pWidth + "px,height=" + pHeight + "px,left=" + pleft + "px,top=" + ptop + "px;";
	if(winName == null) winName = "newWindow"; 
	var getValue = window.open(url, winName, varOption);
	
}


//弹出模式窗口且返回执行方法
function showModalReturnVS(ExtCuteUrl,Winwidth,WinHeight){
      if(Winwidth==""){Winwidth=580;}
    if(WinHeight==""){WinHeight=520;} 
	var ScreenWidth = screen.availWidth;
	var ScreenHeight = screen.availHeight;
	var StartX = (ScreenWidth - Winwidth) / 2;
	var StartY = (ScreenHeight - WinHeight) / 2;
	var dt=new Date();
	var winName=dt.getMinutes()+dt.getSeconds(); 
	var ReturnValue="";
    ReturnValue=window.showModalDialog(ExtCuteUrl, null, 'dialogWidth:' + Winwidth + 'px;dialogHeight:' + WinHeight + 'px;dialogTop:'+StartY+';help:no;unadorned:no;resizable:yes;status:no;center:yes;scroll:no;');
  //ReturnValue 为true 是操作成功
     var vs="";
     vs=ReturnValue;
      while(vs!=undefined&&vs!=null&&vs!="") //   从新打开
      {
         vs=eval(vs);
      }
     document.location=document.location;
}
function g_OpenWindow(pageURL, innerWidth, innerHeight)
{	
	var ScreenWidth = screen.availWidth;
	var ScreenHeight = screen.availHeight;
	var StartX = (ScreenWidth - innerWidth) / 2;
	var StartY = (ScreenHeight - innerHeight) / 2;
	var dt=new Date();
	var winName=dt.getMinutes()+dt.getSeconds();
    return	window.open(pageURL, winName, 'left='+ StartX + ', top='+ StartY + ', Width=' + innerWidth +', height=' + innerHeight + ', resizable=1, scrollbars=yes, status=no, toolbar=no, menubar=no, location=no');
}
 function PagePreview(vURL,vPKName,vW,vh)
 {// onclick="PagePreview('../../Base/WFP/ComGridViewList.aspx','GridviewID','','');"
           var strPKID;
		    var strResult;
		    var count=0;
             var selected='';
             var checkNames=document.getElementsByName("chk");
             for(var i=0; i<checkNames.length; i++) {
 	            if(checkNames[i].checked==true) {
 	    	            selected=checkNames[i].value;
 	    	            count++;
 	            }	
             }
         if 	(count<1){ alert("你必须选择记录！"); return "";}
          //  strURL="../../Base/WFP/ComGridViewList.aspx";
          if(vURL.indexOf('?')>0){
                vURL=vURL+"&"+vPKName+"="+selected;
          }else{
                vURL=vURL+"?"+vPKName+"="+selected;
          }
		    strResult = g_OpenReturnWindow(vURL,660,520);				
		    return false;				
}
function  setPageDesign(obj){
//  <input type="button" id="btnSetPage" name="btnSetPage" class="pt_small_button" value="设计" onclick ="javascript:setPageDesign(this);" />
    var strHref=window.location.href;
    if(strHref.toLowerCase().indexOf('&setpagestatus=2')>-1){
        //obj.setAttribute("value","设计");
        strHref=strHref.replace("&setpagestatus=2","");
        window.location.href=strHref;
        
    }else{
        //obj.setAttribute("value","复原");
        if(strHref.indexOf("?")<0){
        strHref=strHref+"?" ;
        }
        strHref=strHref+"&setpagestatus=2" ;
        window.location.href=strHref;
    }
}
function g_OpenWindowNo(pageURL, innerWidth, innerHeight)
{	
	var ScreenWidth = screen.availWidth;
	var ScreenHeight = screen.availHeight;
	var StartX = (ScreenWidth - innerWidth) / 2;
	var StartY = (ScreenHeight - innerHeight) / 2;
	var dt=new Date();
	var winName=dt.getMinutes()+dt.getSeconds();
	var vs="";
    vs=window.open(pageURL, winName, 'left='+ StartX + ', top='+ StartY + ', Width=' + innerWidth +', height=' + innerHeight + ', resizable=yes, scrollbars=no, status=no, toolbar=no, menubar=no, location=no');
    
     return vs;
}
function g_OpenWinPicture(pageURL,vFiedName)
{	var innerWidth=800;
    var  innerHeight=480;
	var ScreenWidth = screen.availWidth;
	var ScreenHeight = screen.availHeight;
	var StartX = (ScreenWidth - innerWidth) / 2;
	var StartY = (ScreenHeight - innerHeight) / 2;
	var dt=new Date();
	var winName=dt.getMinutes()+dt.getSeconds();
	var str="";
      str=window.showModalDialog(pageURL, winName, 'left='+ StartX + ', top='+ StartY + ', Width=800, height=' + innerHeight + ', resizable=yes, scrollbars=no, status=yes, toolbar=no, menubar=no, location=no');
     if(str!=null && str!=""){
       document.getElementById(vFiedName).value=str;
      }
}

function g_OpenPrintWindow(pageURL)
{	
	var ScreenWidth = screen.availWidth
	var ScreenHeight = screen.availHeight
	var StartX = (ScreenWidth- 525) / 2
	var StartY = (ScreenHeight-740 ) / 2
	var win = window.open(pageURL, 'newWindows', '   resizable=yes, scrollbars=yes, status=yes, toolbar=no, menubar=no, location=no')
	win.focus();
	return false
}
//==========================================================================
//
//  代码描述：打开一个新的没有状态栏、工具栏、菜单栏、定位栏，
//            不能改变大小，且位置居中的新窗口
//       
//  
//  传入参数：pageURL - 传递链接
//            innerWidth - 传递需要打开新窗口的宽度
//            innerHeight - 传递需要打开新窗口的高度
//  
//  返回参数：返回的数值
//==========================================================================
function g_OpenReturnWindow(pageURL, innerWidth, innerHeight)
{	
	var ScreenWidth = screen.availWidth
	var ScreenHeight = screen.availHeight
	var StartX = (ScreenWidth - innerWidth) / 2
	var StartY = (ScreenHeight - innerHeight) / 2
	var now = new Date(); 
    var winHand =now.getMinutes()+ now.getTime() +"";
	var win = window.open(pageURL, 'newWindow'+winHand, 'left='+ StartX + ', top='+ StartY + ', Width=' + innerWidth +', height=' + innerHeight + ', resizable=yes, scrollbars=yes, status=yes, toolbar=no, menubar=no, location=no')
	win.focus();
	return false
}

//==========================================================================
//
//  代码描述：打开一个新的没有状态栏、滚动条、工具栏、菜单栏、定位栏，
//            不能改变大小，且位置居中的新窗口
//       
//  
//  传入参数：pageURL - 传递链接
//            innerWidth - 传递需要打开新窗口的宽度
//            innerHeight - 传递需要打开新窗口的高度
//  
//  返回参数：返回的数值
//==========================================================================
function g_OpenReturnWindowNos(pageURL, innerWidth, innerHeight)
{	
	var ScreenWidth = screen.availWidth
	var ScreenHeight = screen.availHeight
	var StartX = (ScreenWidth - innerWidth) / 2
	var StartY = (ScreenHeight - innerHeight) / 2
	var win = window.open(pageURL, 'newWindows', 'left='+ StartX + ', top='+ StartY + ', Width=' + innerWidth +', height=' + innerHeight + ', resizable=yes, scrollbars=no, status=no, toolbar=no, menubar=no, location=no')
	win.focus();
	return false
}
//==========================================================================
//
//  代码描述：打开一个新的没有状态栏、工具栏、菜单栏、定位栏，
//            不能改变大小，且位置居中的新窗口
//       
//  
//  传入参数：pageURL - 传递链接
//            innerWidth - 传递需要打开新窗口的宽度
//            innerHeight - 传递需要打开新窗口的高度
//            winName - 窗口名称
//  
//  返回参数：返回的数值
//==========================================================================
function g_OpenReturnWindowName(pageURL, innerWidth, innerHeight,winName)
{	
	var ScreenWidth = screen.availWidth
	var ScreenHeight = screen.availHeight
	var StartX = (ScreenWidth - innerWidth) / 1.5
	var StartY = (ScreenHeight - innerHeight) / 1.5
	var win = window.open(pageURL, winName, 'left='+ StartX + ', top='+ StartY + ', Width=' + innerWidth +', height=' + innerHeight + ', resizable=yes, scrollbars=yes, status=yes, toolbar=no, menubar=no, location=no')
	win.focus();
	return false
}
//==========================================================================================
//
// 代码描述：打开模式窗口函数，打开一个模式窗口不包含菜单、状态条、工具条、定位栏
//
// 传入参数：pageURL - 传递链接
//            innerWidth - 传递需要打开新窗口的宽度
//            innerHeight - 传递需要打开新窗口的高度
// 返回参数：无
//
//==========================================================================================
function g_OpenModalWindow(pageURL, innerWidth, innerHeight)
{
	window.showModalDialog(pageURL, null, 'dialogWidth:' + innerWidth + 'px;dialogHeight:' + innerHeight + 'px;help:no;unadorned:no;resizable:yes;status:yes')
}

//==========================================================================================
//
// 代码描述：打开模式窗口函数，打开一个模式窗口不包含菜单、状态条、工具条、定位栏，并且返回参数
//
// 传入参数：pageURL - 传递链接
//            innerWidth - 传递需要打开新窗口的宽度
//            innerHeight - 传递需要打开新窗口的高度
// 返回参数：无
//
//==========================================================================================
function g_OpenModalReturnWindow(pageURL, innerWidth, innerHeight)
{
	var ScreenWidth = screen.availWidth
	var ScreenHeight = screen.availHeight
	var StartX = (ScreenWidth - innerWidth) / 2;
	
	var StartY = (ScreenHeight - innerHeight) / 2;
	var winName= Math.random() ;
	var ReturnValue = window.showModalDialog(pageURL, winName, 'dialogWidth:' + innerWidth + 'px;dialogHeight:' + innerHeight + 'px;dialogLeft:'+StartX+';dialogTop:'+StartY+';help:no;unadorned:no;resizable:yes;status:yes;center:yes;scroll:no;edge:sunken;');
	//return ReturnValue;
}
//==========================================================================================
//
// 代码描述：打开模式窗口函数，打开一个模式窗口不包含菜单、状态条、工具条、定位栏，并且返回参数
//
// 传入参数：pageURL - 传递链接
//            innerWidth - 传递需要打开新窗口的宽度
//            innerHeight - 传递需要打开新窗口的高度
// 返回参数：无
//
//==========================================================================================
function g_OpenModalReturnWindow_return(pageURL, innerWidth, innerHeight)
{
	var ScreenWidth = screen.availWidth
	var ScreenHeight = screen.availHeight
	var StartX = (ScreenWidth - innerWidth) / 2
	var StartY = (ScreenHeight - innerHeight) / 2
	var ReturnValue = window.showModalDialog(pageURL, 'newWindow', 'dialogWidth:' + innerWidth + 'px;dialogHeight:' + innerHeight + 'px;dialogLeft:'+StartX+';dialogTop:'+StartY+';help:no;unadorned:no;resizable:yes;status:yes;center:yes;scroll:no;edge:sunken;');
	 return ReturnValue;
}

//window.open参数
function WinOpenCenter(openfile,dw,x,y){
 	var x1=Math.round((w - x)/2);
	var y1=Math.round((h - y - 75)/2);				
	var win=window.open(openfile,dw,'toolbar=0,location=0,directories=0,status=1,menubar=0,scrollbars=1,resizable=1,left='+x1+',top='+y1+',width='+x+',height='+y);
	win.focus();
}
//==========================================================================================
//
// 代码描述：返回returnValue
//
// 传入参数：
// 返回参数：页面返回值
//
//==========================================================================================
function g_ReturnValue()
{
	var ReturnValue = window.returnValue;
	window.close ();
	return ReturnValue;
}

//==========================================================================================
//
// 代码描述：打开模式窗口函数，打开一个模式窗口不包含菜单、状态条、工具条、定位栏
//
// 传入参数：pageURL - 传递链接
//            innerWidth - 传递需要打开新窗口的宽度
//            innerHeight - 传递需要打开新窗口的高度
// 返回参数：无
//
//==========================================================================================
function g_OpenReturnModalWindow(pageURL, innerWidth, innerHeight)
{
	var ScreenWidth = screen.availWidth
	var ScreenHeight = screen.availHeight
	var StartX = (ScreenWidth - innerWidth) / 2
	var StartY = (ScreenHeight - innerHeight) / 2
	var ReturnValue = window.showModalDialog(pageURL, 'newWindows', 'dialogWidth:' + innerWidth + 'px;dialogHeight:' + innerHeight + 'px;dialogTop:'+StartY+';help:no;unadorned:no;resizable:yes;status:no;center:yes;scroll:no;');
	return ReturnValue;
}
//==========================================================================================
//
// 代码描述：关闭窗口 
// 返回参数：bool
//
//==========================================================================================
function pwincolse()
{  
   window.opener.location=window.opener.location;
   window.close(); 
   return false;
}



  //==========================================================================
//
//  代码描述：打开一个新的没有状态栏、工具栏、菜单栏、定位栏，并且刷新父窗口
//            不能改变大小，且位置居中的新窗口
//       
//  
//  传入参数：pageURL - 传递链接
//            innerWidth - 传递需要打开新窗口的宽度
//            innerHeight - 传递需要打开新窗口的高度
//  
//  返回参数：返回的数值
//==
 function  OpenWindowShowModalDialog(pageURL, innerWidth, innerHeight)
{	
	var ScreenWidth = screen.availWidth;
	var ScreenHeight = screen.availHeight;
	var StartX = (ScreenWidth - innerWidth) / 2;
	var StartY = (ScreenHeight - innerHeight) / 2;
	var dt=new Date();
	var winName=dt.getMinutes()+dt.getSeconds();
	var returnVs= window.showModalDialog(pageURL, 'newWindow', 'dialogWidth:' + innerWidth + 'px;dialogHeight:' + innerHeight + 'px;dialogLeft:'+StartX+';dialogTop:'+StartY+';help:no;unadorned:no;resizable:yes;status:no;center:yes;scroll:no;');
    return returnVs;
}
//==========================================================================
//
//  代码描述：打开一个新的没有状态栏、工具栏、菜单栏、定位栏，
//            不能改变大小，且位置居中的新窗口
//       
//  
//  传入参数：pageURL - 传递链接
//            innerWidth - 传递需要打开新窗口的宽度
//            innerHeight - 传递需要打开新窗口的高度
//  
//  返回参数：返回的数值
//==========================================================================
function g_O(pageURL, innerWidth, innerHeight)
{	
    var content="<iframe id='frrm' frameborder='0'  width='";
    content+=innerWidth;
    content+="' height='";
    content+=innerHeight;
    content+="'></iframe>"    
    document.getElementById("dPop").innerHTML=content;	
    document.getElementById("frrm").src=pageURL;	
}




// JScript 文件
//==========================================================================
//
//  代码描述：打开一个新的消息提示框，
//            不能改变大小，且位置在右下角的新窗口
//  
//  传入参数：pageURL - 传递链接
//            innerWidth - 传递需要打开新窗口的宽度
//            innerHeight - 传递需要打开新窗口的高度
//  
//  返回参数：无
//
//==========================================================================
function g_OpenWindowByMsg(pageURL, innerWidth, innerHeight)
{	
	var ScreenWidth = screen.availWidth;
	var ScreenHeight = screen.availHeight;
	var StartX = ScreenWidth - innerWidth-10;
	var StartY = ScreenHeight - innerHeight-30;
	//var dt=new Date();
	//var winName=dt.getMinutes()+dt.getSeconds();
	var winName="msg";
    var winMsg = window.open(pageURL, winName, 'left='+ StartX + ', top='+ StartY + ', Width=' + innerWidth +', height=' + innerHeight + ', resizable=yes, scrollbars=no, status=no, toolbar=no, menubar=no, location=no');
    winMsg.focus();
}
function OnFKMultipleWin( vURL,vFKID,PKID,vFieldEName,vFieldID,vFieldValue,  vURelation,vOrgGrade ,vObjList,vPRList,vReMList,vP1,vIsMultiple){ //取得自定义SQL语句外联
        //vURL=WFK/selectAllByTreeList.aspx?pkId=10030&checkType=0&praListValue=1122   
          var str=window.showModalDialog(vURL+"?PKID="+vFKID+"&fieldid="+vFieldID+"&fieldvalue="+vFieldValue+"&USERRELATION="+vURelation+"&ORGGRADE="+vOrgGrade+"&OBJLIST="+vObjList+"&PERSONROLELIST="+vPRList+"&ReMList="+vReMList+"&checkType=" +vIsMultiple);
             if(str!=null){
                var strVS=str.split('#')
                document.getElementById(vFieldEName).value=strVS[1];
                document.getElementById(vFieldEName+"_CN").value=strVS[0];
            }    
        } 
 
        
function OnFKWin(vURL,vPageID, vPKID,vFieldEName,vFieldID,vFieldValue,vClassID,vIsMultiple){ //取得自定义SQL语句外联
          var str=window.showModalDialog(vURL+"?pageid="+vPageID+"&PKID="+vPKID+"&fieldid="+vFieldID+"&fieldvalue="+vFieldValue+"&classid="+vClassID+"&IsMultiple=" +vIsMultiple);
             if(str!=null){
                var strVS=str.split('#')
                document.getElementById(vFieldEName).value=strVS[1];
                document.getElementById(vFieldEName+"_CN").value=strVS[0];
            }    
        }  
       /* 
function addListener(element,e,fn){ element.addEventListener?element.addEventListener(e,fn,false):element.attachEvent("on" + e,fn)};
function removeListener(element,e,fn){ element.removeEventListener?element.removeEventListener(e,fn,false):element.detachEvent("on" + e,fn)};


��ӡ
function printDOC() {
	var hkey_root,hkey_path,hkey_key;
	hkey_root="HKEY_CURRENT_USER";
	hkey_path="\\Software\\Microsoft\\Internet Explorer\\PageSetup\\";
	try{
	  var RegWsh = new ActiveXObject("WScript.Shell") ;
	  hkey_key="header" ;
	  RegWsh.RegWrite(hkey_root+hkey_path+hkey_key,"") ;
	  hkey_key="footer" ;
	  RegWsh.RegWrite(hkey_root+hkey_path+hkey_key,"") ;
	  }
	 catch(e){}
	window.print();
}
 
function printBtn() {
	document.all.WEB_PVX.printing.Print(true);
 window.print();
}
function privewDOC() {
	var hkey_root,hkey_path,hkey_key;
	hkey_root="HKEY_CURRENT_USER";
	hkey_path="\\Software\\Microsoft\\Internet Explorer\\PageSetup\\";
	try{
	  var RegWsh = new ActiveXObject("WScript.Shell") ;
	  hkey_key="header" ;
	  RegWsh.RegWrite(hkey_root+hkey_path+hkey_key,"") ;
	  hkey_key="footer" ;
	  RegWsh.RegWrite(hkey_root+hkey_path+hkey_key,"") ;
	  }
	 catch(e){}
	var obj = document.all.WebBrowser;
 	obj.ExecWB(7,1);
}
*/