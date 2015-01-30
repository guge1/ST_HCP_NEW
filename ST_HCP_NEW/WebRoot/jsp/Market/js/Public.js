// JScript 文件
var css_App_Themesimages="/ndflow/App_Themes/style_dark/images/";
var com_Public_FunctionPath="/ndflow/Base/wfs/";
var web_images="";
 
var css_files="";
 
var surl=document.location.toString();
var jjj=surl.split('/');
var sj="";
for(var j=0;j<jjj.length;j++){
    sj+=jjj[j]+"/";
    pageUrl+=jjj[j]+"/";
    if(j==4){
        break;
    }
}

var pageUrl="";
var surl=document.location.toString();
var jjj=surl.split('/');
var sj="";
for(var j=0;j<jjj.length;j++){
    sj+=jjj[j]+"/";
    pageUrl+=jjj[j]+"/";
    if(j==4){
        break;
    }
}
document.onkeydown=kdown;  
      function   kdown()  
      {    
          if   (event.keyCode==78 && event.ctrlKey)  
          {  
              return   false;  
          }  
      } 

 /*
  //判断对象是否存在
 function JudgeObjIsExists(objId){
 	if(!objId){return null; }
	if(document.getElementById)
	{
  	    try{
              var obj=document.getElementById("' + objId + '");
 	     }
 	     catch(e)
 	       {
 	          alert('页面没找到 '+objId+' 对象！');
 	          return null; 
 	       }
	    return eval('document.getElementById("' + objId + '")');
	}
	else if(document.layers)
	{
		return eval("document.layers['" + objId +"']");
	}else{
		return eval('document.all.' + objId);
	}
 } 
 */
   //可选项窗口
   function p_OtherSelect(obj,Purl,Ptype)
   { 
        var objs = document.getElementById(obj);
        var returnString = g_OpenReturnModalWindow(Purl+Ptype,450,450);
        if(returnString!="" && returnString!=null)
        {
           objs.value=returnString.split('#')[0];
        }
   }
   //可选项窗口
   function p_DepSelect(obj,obj1,Purl,Ptype)
   {   
    if(Ptype==null || Ptype=="" || Ptype=="TYPE" ){
        Ptype="1";
    }
        var objs = document.getElementById(obj);
        var obj1=document.getElementById(obj1);
        
        var vs=objs.value;
        if(vs!=null && vs!=""){
            Ptype=Ptype+"&vs="+vs;
        }
        var returnString = g_OpenReturnModalWindow(Purl+Ptype,600,494);
        if(returnString!="" && returnString!=null)
        {
           objs.value=returnString.split('#')[1];
           obj1.value=returnString.split('#')[0];
        }
   }
  
 
	
   function wfcScrDisp(ofieldname)
        {
            var objFlag=document.getElementById(ofieldname+"_chk");
            var obj=document.getElementById(ofieldname+"_sp");
            if(objFlag.checked)
            { 
                obj.style.display="inline"; 
              
             }else{   
                obj.style.display="none";  
                
            }  
        }
   
//显示部门层
	function showDepart(id,hid){
	    //id=要显示的层的id 	    
        var pop=document.getElementById(id);            
        var a = document.documentElement.scrollTop; 
	    var b = document.documentElement.scrollLeft; 
        var x=event.clientX;
        var y=event.clientY+20;
        pop.style.left=x+b;
        pop.style.top=y+a;
        pop.style.display=""; 
        var hid=document.getElementById(hid);
        hid.style.display="";                    
    }
//显示层(居中显示)
    function showDiv(id,hid){
        var pop=document.getElementById(id);  
        pop.style.display=""; 
	    var w = document.documentElement.offsetWidth; 
	    var h = document.documentElement.offsetHeight;
	     
	    var dw=pop.offsetWidth;
	    var dh=pop.offsetHeight;
        pop.style.left=(w-dw)/2;
        pop.style.top=(h-dh)/2;
        var hid=document.getElementById(hid);
        hid.style.display="";
    }
    //把获取到的值赋给相应的文件框 
    
    ///拖动层
    //id=拖动的层的id
        var flag = false;
        var dx = 0;
        var dy = 0;
        var dv;
        function DragStart(id){        
            flag = true;
            dv=document.getElementById(id);
            var x=event.x+document.body.scrollLeft;
            var y=event.y+document.body.scrollTop;
            dx=x-dv.style.pixelLeft;
            dy=y-dv.style.pixelTop;
            document.onmousemove = moveDiv;
        }
        function DragEnd(){
            flag = false;
            document.onmousemove = null;
        }
        function moveDiv(){
            if(flag){
                dv.style.left = event.x+document.body.scrollLeft-dx;
                dv.style.top = event.y+document.body.scrollTop-dy;		
            }
        }
        

        
        function Delete()
        {
            eval(_doPostBack);
                
        }
        
    
    
    //取用户id,用户名，用户所在部门
    //id 存放id的文本框id
    //name 存放姓名的文本框id
    //department 存放部门的文本框id
    function GetUser(id,name,department,type){
        var vs=document.getElementById(id).value;
         
        if(type=="1")//dan选
        {
            var str=window.showModalDialog(pageUrl+'web/wfs/SelectUser.aspx?type=1&vs='+vs);
        }else//多
        {
            var str=window.showModalDialog(pageUrl+'web/wfs/SelectUser.aspx?type=0&vs='+vs);
        
        }    
            var strName="";
            var strId="";
            var strDepart="";
             if(str!=null){
                var strs=str.split('~');                
                for(var i=0;i<strs.length-1;i++){                
                    var st=strs[i].split(',');
                        strName+=st[0]+",";
                        strId+=st[3]+",";
                        strDepart=st[2]+",";
                }
                switch(arguments.length){
                    case 2:
                        document.getElementById(id).value=strId.substring(0,strId.length-1);
                        document.getElementById(name).value=strName.substring(0,strName.length-1);
                    break;
                    case 3:
                        document.getElementById(id).value=strId.substring(0,strId.length-1);
                        document.getElementById(name).value=strName.substring(0,strName.length-1);
                        document.getElementById(department).value=strDepart.substring(0,strDepart.length-1);
                    break;
                     case 4:
                        document.getElementById(id).value=strId.substring(0,strId.length-1);
                        document.getElementById(name).value=strName.substring(0,strName.length-1);
                          break;
                }                
                
            }  
            
        }
     
      function GetUserLots(id,name,department,type){
        var vs=document.getElementById(id).value;
         
        if(type=="1")//dan选
        {
            var str=window.showModalDialog('/ndflow/web/LotsUserSelect/SelectUser.aspx?type=1&vs='+vs);
        }else//多
        {
            var str=window.showModalDialog('/ndflow/web/LotsUserSelect/SelectUser.aspx?type=0&vs='+vs);
        
        }    
            var strName="";
            var strId="";
            var strDepart="";
             if(str!=null){
                var strs=str.split('~');                
                for(var i=0;i<strs.length;i++){                
                    var st=strs[i].split(',');
//                        strName+=st[0]+",";
//                        strId+=st[3]+",";
//                        strDepart=st[2]+",";
                        strName+=st[1]+",";
                        strId+=st[0]+",";
                } 
                switch(arguments.length){
                    case 2:
                        document.getElementById(id).value=strId.substring(0,strId.length-1);
                        document.getElementById(name).value=strName.substring(0,strName.length-1);
                    break;
                    case 3:
                        document.getElementById(id).value=strId.substring(0,strId.length-1);
                        document.getElementById(name).value=strName.substring(0,strName.length-1);
                        document.getElementById(department).value=strDepart.substring(0,strDepart.length-1);
                    break;
                     case 4:
                        document.getElementById(id).value=strId.substring(0,strId.length-1);
                        document.getElementById(name).value=strName.substring(0,strName.length-1);
                          break;
                }                
                
            }  
            
        }
     
        
    //=======检查此用户是否已存在========
        function CheckIsSingle(name,id){
            var p="name="+escape(document.getElementById(name).value)+"&id="+id;
            var xmlhttp;
            try{
                xmlhttp=new XMLHttpRequest();
            }catch(e){
                xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
            }
            xmlhttp.onreadystatechange = function(){
                if (xmlhttp.readyState == 4) {
                    if (xmlhttp.status == 200) {
                         var data=xmlhttp.responseText; 
                         if(data=="0"){                                                                                
                         }else{
                            alert("此用户已存在");
                            document.getElementById("txtLOGINNAME").select();
                            document.getElementById("txtLOGINNAME").focus();
                         }
                    }
                }
            }
            xmlhttp.open("post", "/ndflow/web/wfs/CheckIsSingle.ashx", true);
            xmlhttp.setRequestHeader('Content-type','application/x-www-form-urlencoded');
            xmlhttp.send(p);
        }
// aid  数据库里的id
// nid  参数控件的id，如txtCode
function execAjax(aid,nid){ 
    var code=document.getElementById(nid).value;
    var xmlhttp;
    try{
        xmlhttp=new XMLHttpRequest();
    }catch(e){
        xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.onreadystatechange = function(){
        if (xmlhttp.readyState == 4) {
            if (xmlhttp.status == 200) {
                
                 var data=xmlhttp.responseText;
                if(data==""){
                    return;
                }
                 var ss=data.split('●');                         
                 var sType=ss[1].split('~');
                 var sValue=ss[0].split(',');
                 for(var i=0;i<sType.length;i++){
                    var s=sType[i].split(',');
                    switch(s[1]){
                        case "10372"://文本框
                        case "10385"://下拉框
                        case ""://文本框
                            if(s[2]=="10424"){
                                try{
                                    document.getElementById(s[0]).value=sValue[i].split('|')[0]==undefined?"":sValue[i].split('|')[0];
                                    document.getElementById(s[0]+"_CN").value=sValue[i].split('|')[1]==undefined?"":sValue[i].split('|')[1];
                                }catch(ee){
                                    document.getElementById(s[0]).value="";
                                    document.getElementById(s[0]+"_CN").value="";
                                }
                            }else{   
                                try{
                                    document.getElementById(s[0]).value=sValue[i]==undefined?"":sValue[i];
                                }catch(ex2){
                                    document.getElementById(s[0]).value="";
                                }
                            }                                
                            break;
                        case "10377"://单选
                            break;
                        case "10378"://多选
                            break;
                        default:
                            break;
                    }  
                 }  
                                       
            }
        }
    }
    var url=pageUrl+"web/wfs/ExecAjax.ashx?id="+aid+"&para="+code;
    xmlhttp.open("post", url, true);
    xmlhttp.setRequestHeader('Content-type','application/x-www-form-urlencoded');
    xmlhttp.send(null);
}
 /*  js参数替换特殊字符*/
function encodeURL(str){
	return encodeURI(str).replace(/=/g,"%3D").replace(/\+/g,"%2B").replace(/\?/g,"%3F").replace(/\&/g,"%26");
}

function htmlEncode(str) {
	return str.replace(/&/g,"&amp;").replace(/\"/g,"&quot;").replace(/</g,"&lt;").replace(/>/g,"&gt;").replace(/ /g,"&nbsp;");
}

function htmlDecode(str) {
	return str.replace(/\&quot;/g,"\"").replace(/\&lt;/g,"<").replace(/\&gt;/g,">").replace(/\&nbsp;/g," ").replace(/\&amp;/g,"&");
}

 /*  js参数替换特殊字符*/
 
 
 function getEvent(evt){
	return window.event||evt;
}

function stopEvent(evt){//阻止一切事件执行,包括浏览器默认的事件
	evt = getEvent(evt);
	if(!evt){
		return;
	}
	}
	
	//-----------------------通用表单页面 方法及样式----开始---------------------------------------------
	
	   
//鼠标单击标签
   function   onChildMenuClick(obj){ 
           if (obj==null) return;
            obj.className="divtabCurrent";  
            for(var i=1;i<11;i++){
                if(obj.id!="_ChildMenuItem_"+i){
                    if (document.getElementById("_ChildMenuItem_"+i)==null) continue;
                    document.getElementById("_ChildMenuItem_"+i).className="divtab";
                    document.getElementById("_ChildMenuItem_"+i).style.fontWeight="normal";
                }else
                {
	             	var DivTag=document.getElementById("DivTag_"+i);
                    if (DivTag==null) continue;
                    ShowMoreDetailInfo( "Fieldset_"+i,"divDispalyContent_"+i,"ImgShouMore_"+i,true);//展开相应的区域
                    DivTag.scrollIntoView(true);
                }
            } 
     }
   
//鼠标移到标签
     function  onChildMenuMouseOver(obj){
       	    if(obj.className=="divtab"){
		    obj.className="divtabHover";
	    }
     }

//鼠标移出标签
 function onChildMenuMouseOut(obj)
 {
   if(obj==null)return;
   if(obj.className=="divtabHover"){
		obj.className="divtab";
	}
 }
 
   
 //收缩或展开内容
 function ShowMoreDetailInfo(id,divid,imgid,IsShow)
        {   
           var  obj=document.getElementById(id)
           var divobj=document.getElementById(divid);
           var imgCtrl=document.getElementById(imgid);
           if(obj==null)return;	   
           if(divobj==null)return;
           if(imgCtrl==null)return;
           var ImgMinusScr =pageUrl+"images/icon_collapseall.gif"	;
           var ImgPlusScr =pageUrl+"images/icon_expandall.gif"	;	
           if(divobj.style.display=="none")//显示
            {
               obj.title="点击收缩详细信息";
               divobj.style.display="";
               //收缩或展开内容时改变图标   
                 imgCtrl.src = ImgMinusScr ;
            }
          else
            {
                //收缩或展开内容时改变图标;      
               divobj.style.display="none";
               imgCtrl.src = ImgPlusScr ;	
               obj.title="点击展开详细信息";
            }
            if(IsShow==false)//影藏
            {  
               divobj.style.display="none";
               imgCtrl.src = ImgPlusScr ;	
               obj.title="点击展开详细信息";
            }
             if(IsShow==true)//显示
            {  
               obj.title="点击收缩详细信息";
               divobj.style.display="";
               //收缩或展开内容时改变图标   
                 imgCtrl.src = ImgMinusScr ;
            }
        } 
       //收缩或影藏全部
       var isShouAll=false;
        function ShowAllOrHiddenAll(obj)
         {
            if(isShouAll){
             isShouAll=false;
             obj.innerHTML="<img src=\""+pageUrl+"images/TemplateImg/down.gif\" width=\"14px\" height=\"15px\"><b><span>展开全部</span>";
            }else
            {
               isShouAll=true;
               obj.innerHTML="<img src=\""+pageUrl+"images/TemplateImg/up.gif\" width=\"14px\" height=\"15px\"><b><span>收缩全部</span>";
            }
            for(var i=1;i<11;i++){
              
	             	var DivTag=document.getElementById("DivTag_"+i);
                    if (DivTag==null) continue;
                    DivTag.scrollIntoView(true);
                    ShowMoreDetailInfo( "Fieldset_"+i,"divDispalyContent_"+i,"ImgShouMore_"+i,isShouAll);//展开相应的区域
            } 
           BackToTop();//跳转到第一个
         }  
     
       //刷新父页面
        function onloadReloadFatherPage()
         {
               try{  
                        window.opener.location=window.opener.location;
                   
                  } 
                 catch(err)
                 {
                      parent.location=parent.location;
                 }
         }
          
    //返回顶部
        function BackToTop()
        {  
           if( document.getElementById("content_pane")==null)return;	   
           document.getElementById("content_pane").scrollTop="0" ;
         
        }
        
        
	//-----------------------通用表单页面 方法及样式----开始---------------------------------------------
	
	
	//-----------------------电子流工作平台列表方法----开始---------------------------------------------
	var __ThemeImagesPath="/ndflow/images/"; 
	var __CommonImagesPath="/ndflow/images/"; 
 
    __ThemeImagesPath=pageUrl+"images/";
    __CommonImagesPath=pageUrl+"images/";

	/******************************************/
/*					工具栏有关JS脚本							*/
/*         		*/
/******************************************/

//图像引用变量，在控制按钮样式时用
var img_left="";
var img_left_on="url("+__ThemeImagesPath+"tb_btn_left_on.gif)";
var img_left_down="url("+__ThemeImagesPath+"tb_btn_left_down.gif)";
var img_right="";
var img_right_on="url("+__ThemeImagesPath+"tb_btn_right_on.gif)";
var img_right_down="url("+__ThemeImagesPath+"tb_btn_right_down.gif)";
var img_middle="";
var img_middle_on="url("+__ThemeImagesPath+"tb_btn_middle_on.gif)";
var img_middle_down="url("+__ThemeImagesPath+"tb_btn_middle_down.gif)";
//鼠标进入区域
function doHover(o){
	if (o==null) return false;
	var btnx=o.getElementsByTagName("td");
	if (btnx[0]!=null) btnx[0].style.backgroundImage=img_left_on;
	if (btnx[1]!=null) {
		btnx[1].style.backgroundImage=img_middle_on;
		btnx[1].style.color="black";
	}
	if (btnx[2]!=null) {
		btnx[2].style.backgroundImage=img_middle_on;
		btnx[2].style.color="black";
	}
	if (btnx[3]!=null) btnx[3].style.backgroundImage=img_right_on;
	else btnx[2].style.backgroundImage=img_right_on;
}

//鼠标退出区域
function doOut(o){
	if (o==null) return false;
	var btnx=o.getElementsByTagName("td");
	if (btnx[0]!=null) btnx[0].style.backgroundImage=img_left;
	if (btnx[1]!=null) {
		btnx[1].style.backgroundImage=img_middle;
		btnx[1].style.color="black";
	}
	if (btnx[2]!=null) {
		btnx[2].style.backgroundImage=img_middle;
		btnx[2].style.color="black";
	}
	if (btnx[3]!=null) btnx[3].style.backgroundImage=img_right;
	else btnx[2].style.backgroundImage=img_right;
}

//鼠标按下
function doDown(o){
	if (o==null) return false;
	var btnx=o.getElementsByTagName("td");
	if (btnx[0]!=null) btnx[0].style.backgroundImage=img_left_down;
	if (btnx[1]!=null) {
		btnx[1].style.backgroundImage=img_middle_down;
		btnx[1].style.color="white";
	}
	if (btnx[2]!=null) {
		btnx[2].style.backgroundImage=img_middle_down;
		btnx[2].style.color="white";
	}
	if (btnx[3]!=null) btnx[3].style.backgroundImage=img_right_down;
	else btnx[2].style.backgroundImage=img_right_down;
}

//鼠标移动到分类下拉菜单栏中
function ddiOver(o){
	o.style.border='1px outset buttonface';
}

//鼠标移出分类下拉菜单栏
function ddiOut(o){
	o.style.border='1px solid buttonface';
}

//分类下拉菜单栏中按下鼠标
function ddiDown(o){
	o.style.border='1px inset buttonface';
}

function SetHidVs(vs){
	 document.getElementById("hidSearchType").value=vs;
}

//切换显示视图搜索区
function toggleShowVSP(){
	var vsp=document.getElementById("viewSearchPane");
	if (vsp==null) return;
	if (vsp.style.display=="none") vsp.style.display="block";
	else vsp.style.display="none";
}

//切换视图搜索区解面锁定选项。
function toggleVSPLockState(o){
	var img=null;
	if (o!=undefined || o!=null) img=o;
	else img=document.getElementById("vspLockImg");
	if (img==null) return;
	if (img.src.indexOf("icon_lock.gif")>0){
		img.title="单击以隐藏视图搜索区";
		img.src=__CommonImagesPath+"icon_rndcancel.gif";
		setViewSearchPaneShow(true);
		var vsp=document.getElementById("viewSearchPane");
		if (vsp!=null) vsp.style.display="block";
	}
	else{
		img.title="单击以锁定视图搜索区";
		img.src=__CommonImagesPath+"icon_lock.gif";
		setViewSearchPaneShow(false);
		var vsp=document.getElementById("viewSearchPane");
		if (vsp!=null) vsp.style.display="none";
		var tdvsp=document.getElementById("td_btn_viewsearchpane");
		if (tdvsp!=null) tdvsp.style.display="block";
	}
}

//设置是否现实视图搜索区
function setViewSearchPaneShow(bl){
	var cookieName="vspshow";
	if (bl) {
		delCookie(cookieName);
		return;
	}
	var dtx=new Date();
	dtx.setFullYear(dtx.getFullYear()+1);
	//setCookie(cookieName,"0",dtx);		//__FramePath
}


	//-----------------------电子流工作平台列表方法--------结束-----------------------------------------


 /*
消除错误提示
 <script language="JavaScript">
<!-- Hide
function killErrors() {
return true;
}
window.onerror = killErrors;
// -->
</script>
 --------------------------
//鼠标移过图片变清晰效果,使用方法 onmouseover="nereidFade(this,100,3,5)" style="FILTER: alpha(opacity=55)" onmouseout="nereidFade(this,50,3,5)" 
var nereidFadeObjects = new Object();
var nereidFadeTimers = new Object();
function nereidFade(object, destOp, rate, delta){
    if (!document.all)return
    if (object != "[object]"){  //do this so I can take a string too
        setTimeout("nereidFade("+object+","+destOp+","+rate+","+delta+")",0);
        return;
    }
    clearTimeout(nereidFadeTimers[object.sourceIndex]);
    diff = destOp-object.filters.alpha.opacity;
    direction = 1;
    if (object.filters.alpha.opacity > destOp){
        direction = -1;
    }
    delta=Math.min(direction*diff,delta);
    object.filters.alpha.opacity+=direction*delta;
    if (object.filters.alpha.opacity != destOp){
        nereidFadeObjects[object.sourceIndex]=object;
        nereidFadeTimers[object.sourceIndex]=setTimeout("nereidFade(nereidFadeObjects["+object.sourceIndex+"],"+destOp+","+rate+","+delta+")",rate);
    }
}
 */