// JScript 文件
//可拖动初始化
// 初始化所有可拖拽的元素，依靠 className 来确定是否可拖拽，可拖拽的部分的 id 为该元素 id 加上 _h
//var Drag = {
//    var DragUtil = new Object();
//}   
 //自定义  getElementsByClassName 
 var intPageColCount=2;
 
 var  trheight="46px";
 if (!document.getElementsByClassName) {
	    document.getElementsByClassName = function (cn) {
	    
	        var rx = new RegExp("\\b" + cn + "\\b"),
	        allT = document.getElementsByTagName("*"), allCN = [], i = 0, a;
	        
	        
	        
	        while (a = allT[i++]) {
	            if (a.className&& a.className.indexOf(cn) + 1) {
	                 if(a.className===cn){ allCN[allCN.length] = a; continue;}
	                 rx.test(a.className) ? (allCN[allCN.length] = a) : 0;
	            }
	        }
	        return allCN;
	     }
	}
function setTableColCount(vColCount){
 
    if(((vColCount == null) || (vColCount.length == 0))){iTableColCount=2;return; }
    if(bIsNumber(vColCount,2,4)){
         intPageColCount=parseInt(vColCount,0);
    }else{
      intPageColCount=2;
    }
}

 function bIsNumber(s, minval, maxval)
    {
    var i;
    for (i = 0; i < s.length; i++)
        {
        // Check that current character is number.
        var c = s.charAt(i);
        if (((c < "0") || (c > "9"))) return false;
        }
    if (s < minval | s > maxval)
        return false;
    // All characters are numbers.
    return true;
    }
    
 document.getElementsByClassName = function(){
        var tTagName ="*";
        if(arguments.length > 1){
            tTagName = arguments[1];
        }
        if(arguments.length > 2){
            var pObj = arguments[2]
        }
        else{
            var pObj = document;
         }
        var objArr = pObj.getElementsByTagName(tTagName);
        var tRObj = [];
        for(var i=0; i<objArr.length; i++){
            if(objArr[i].className == arguments[0]){
             tRObj.push(objArr[i]);
            }
        } 
        return tRObj;
   } 
 var DragUtil = new Object();
    var initDrag = function() { 
      var  drgTables=document.getElementsByClassName('dragTableModel');
      for(var n=0;n<drgTables.length;n++)
      { 
             var  drgTable=drgTables[n];
	        var dragRows =  document.getElementsByClassName('drag_row','tr',drgTable) ;// document.getElementsByClassName('drag_row');
	        DragUtil.dragArray = new Array();

	        for(var i = 0 ; i < dragRows.length ; i++)
	        {
		        var dragRow = dragRows[i]; 
		            dragRow.onmouseup=function()
		            { 
		               DragManager.onMouseUp(event,this);
		            }
        		    
		            dragRow.onmouseleave=function()
		            {  
		               DragManager.onMouseOut(event,this);
        		       
		             }
		            dragRow.onmouseenter=function()
		            {
		               DragManager.onMouseOver(event,this);
		             }
		            dragRow.dragout=DataGrid.dragOut;
		            dragRow.dragover=DataGrid.dragOver;
		            dragRow.dragend=DataGrid.dragEnd; 
		            
		            var dragCols= document.getElementsByClassName('drag_row_td','td',dragRow)  ;//只有点击第一列的时候才执行拖动 dragRow.getElementsByTagName('td')[0]
		            for(var t = 0 ; t < dragCols.length ; t++)
		           {
		              var dragCol=dragCols[t]
		                dragCol.style.cursor="move";dragTable 
	                    dragCol.onmousedown=function()
		                {  
		                   DragManager.onMouseDown(event,this);
		                 } 
    		            dragCol.dragstart=DataGrid.dragStart;
    		            dragCol.ondblclick=function()
		                {  
		                   stopEvent(event);
		                } 
		               dragCol.oncontextmenu=function()
		                {  
		                   showMenu(event); return true;
		                } 
		            }
		            var dragCols_no= document.getElementsByClassName('drag_row_td_no','td',dragRow)  ;//其他的不可拖动td
		            for(var t = 0 ; t < dragCols_no.length ; t++)
		           {
		              var dragCol=dragCols_no[t];
    		            dragCol.onmouseover=function()
		                {  
		                   MouseOverFun2(this);
		                }  
		            }
		             
		           var dragTables=document.getElementsByClassName('removableObj','table',dragRow) ;//初始化可拖动的table元素
		           for(var t = 0 ; t < dragTables.length ; t++)
		           {
		                var dragTable = dragTables[t]; 
		                   dragTable.style.cursor="move";
		                  dragTable.style.height=trheight;
    		               dragTable.onmousedown=function()
    		               {
    		                     MouseDownToMove(this);
    		               }
    		               dragTable.onmousemove=function()
    		               {
    		                     MouseMoveToMove(this);
    		               }
    		               dragTable.onmouseup=function()
    		               {
    		                     MouseUpToMove(this);
    		               }
    		               dragTable.onmouseover=function()
    		               {
    		                     MouseOverFun(this);
    		               } 
		            }//可拖动table模板的事件循环循环结束
		             
    		 }//  //table模板行数循环结束 
	    }//table模板数循环结束

    }
    
    var  getLastResult=function() 
    {
    
      var  returnOrder="";　
      var  drgTables=document.getElementsByClassName('dragTableModel','table');
      for(var n=0;n<drgTables.length;n++)
      {//table 循环 
           var  drgTable=drgTables[n];
           //  id   列数  序号  类型  
           returnOrder+=""+drgTable.id+","+drgTable.getAttribute("TABLE_COUNT")+","+n+","+drgTable.getAttribute("TABLE_TYPE")+","+drgTable.getAttribute("TABLE_NUM")+"~";
           var dragRows =  document.getElementsByClassName('drag_row','tr',drgTable) ;
            DragUtil.dragArray = new Array();

            for(var i = 0 ; i < dragRows.length ; i++)
            {//tr循环
	            var dragRow = dragRows[i];
	            //行 类型  序号
                returnOrder+=dragRow.getAttribute("ROW_TYPE")+","+i+"$";//行与列之间
	               var dragCol=dragRow.getElementsByTagName('td')[0];//只有点击第一列的时候才执行拖动
    		       var dragCols_no= document.getElementsByClassName('drag_row_td_no','td',dragRow)  ;//其他的不可拖动td
		           for(var j = 0 ; j< dragCols_no.length ; j++)
		           {//列循环
		               var dragCols=dragCols_no[j];
		               var COLSPAN=dragCols.colSpan;
		             
	                   var dragColTables=document.getElementsByClassName('removableObj','table',dragCols) ;;//初始化可拖动的table元素
	                   for(var t = 0 ; t < dragColTables.length ; t++)
	                   {
	                        var dragColTable = dragColTables[t];
	                        //id  排序  所在的列序号  strCOL_NUM COLSPAN
	                         returnOrder+=""+dragColTable.id+","+t+","+(j)+","+COLSPAN+"?";//列与列质之间用？隔开
	                    }
	               }//列循环结束
	              returnOrder+=";";//行和行之间用;隔开  
		        
            }//行数循环结束
          returnOrder+="#";//模块模块之间 用#隔开  
       }//table 循环 结束    
    　 // alert(returnOrder); 
       document.getElementById("hidResult").value=returnOrder; 
    return returnOrder;
    }


//可拖动的tabel方法
  var   beginMoving=false; 
        var   sourceObj=null; 
        var   objectObj=null; 
        var   objectObj2=null; 
       
   function   MouseDownToMove(obj)
   { 
        obj.style.zIndex=1; 
        obj.mouseDownY=event.clientY; 
        obj.mouseDownX=event.clientX; 
        beginMoving=true; 
        obj.setCapture(); 
        sourceObj=obj; 
        objectObj=null; 
        obj.cssText="margin-top:0px;margin-left:0px;";
   } 
   
 function   MouseMoveToMove(obj){ 
  if(!beginMoving)   return   false; 
        obj.style.top   =   (event.clientY-obj.mouseDownY); 
        obj.style.left   =   (event.clientX-obj.mouseDownX); 
    } 
    function   MouseUpToMove(obj)
    { 
        if(!beginMoving)   return   false; 
        obj.releaseCapture(); 
        obj.style.top=0; 
        obj.style.left=0; 
        obj.style.zIndex=0; 
        beginMoving=false; 
        window.setTimeout("swapFun()",20); 
      } 
               
    function   MouseOverFun(obj) 
    { 
        if(obj==sourceObj)   return   false; 
        objectObj=obj; 
    } 
               
    function   MouseOverFun2(obj) 
    { 
      objectObj2=obj;  
    } 
    
//可拖动的tabel方法结束           
function   swapFun() 
    { 
            if(sourceObj!=null   &&   objectObj!=null) 
            {
               objectObj.insertAdjacentElement("beforeBegin",sourceObj); 
             }
            else { 
               if(sourceObj!=null   &&   objectObj2!=null)
                {  objectObj2.insertAdjacentElement("beforeEnd",sourceObj);} 
                sourceObj=null; 
                objectObj=null; 
                objectObj2=null; 
            }
    } 


//右键菜单
function showMenu(event){
  
	var menu = new Menu();
	menu.setEvent(event);
	var param = [];
	param.push(event);
	param.push(event.srcElement.parentNode);
	param.push("10000"); 
	
	menu.setParam(param);
	//以下为菜单的权限控制  false 为可用 ,true为不可用
	var addPost=false;
	 
	//menu.addItem("显示标题",函数,"图标",true/false为可用或可用);
	menu.addItem("复制行",copyRow,"dragImages/icon016a2.gif",addPost);
	menu.addItem("添加整行",addRows_0,"dragImages/icon016a8.gif",addPost);
	menu.addItem("添加正常行",addRows_All,"dragImages/icon016a8.gif",addPost);
	try{
	    if(intPageColCount==3){
	    menu.addItem("添加2/1行",addRows_2_1_1,"dragImages/icon016a8.gif",addPost);
	    menu.addItem("添加1/2行",addRows_1_2_1,"dragImages/icon016a8.gif",addPost);
	    }
	    if(intPageColCount==4){
        //-------------
        menu.addItem("-");
        menu.addItem("添加2/1/1行",addRows_2_1_1,"dragImages/icon016a8.gif",addPost);
	    menu.addItem("添加1/2/1行",addRows_1_2_1,"dragImages/icon016a8.gif",addPost);
        menu.addItem("添加1/3行",addRows_1_3,"dragImages/icon016a8.gif",addPost);
        menu.addItem("添加3/1行",addRows_3_1,"dragImages/icon016a8.gif",addPost);
        menu.addItem("添加2/2行",addRows_2_2,"dragImages/icon016a8.gif",addPost);
         }
        
     }catch(e){;}
	menu.addItem("-");
	menu.addItem("删除行",delRows,"dragImages/icon016a1.gif",addPost);
 
 
	menu.show();
	 return true;
}
 var n=1000;
 
function  addRows_All(param)
   {//添加 正常单列行
      var  obj=param[1];
      addRows(obj,'99999')
   }

 
  function  addRows_0(param)
   {//添加正常行
      var  obj=param[1];
      addRows(obj,'10000')
   }
  function  addRows_1_2_1(param)
   {//添加添加1/2行
      var  obj=param[1];
      addRows(obj,'10001')
   }
  function  addRows_2_1_1(param)
   {//添加2/1行
      var  obj=param[1];
      addRows(obj,'10002')
   }
  function  addRows_3(param)
   {//添加 
      var  obj=param[1];
      addRows(obj,'10003')
   }
    
 function  addRows_1_3(param)
   {//添加1,3 单列行
      var  obj=param[1];
      addRows(obj,'10004')
   }
    function  addRows_3_1(param)
   {//添加3,1单列行
      var  obj=param[1];
      addRows(obj,'10005')
   }
    function  addRows_2_2(param)
   {//添加2,2单列行
      var  obj=param[1];
      addRows(obj,'10006')
   }
   
   
   function  addRows(obj,type)
   { 
        n++; 
	    var oTable=obj.parentNode;
          
        var   selectRow=  obj.rowIndex ;
	    var tmpLength=2;//myFormTable.rows.length;
	    tmpLength=tmpLength-1;
	    var intLength=3;//  myFormTable.rows(tmpLength).cells.length;
	    if(intPageColCount==2){
	        intLength=3;
	    }
	   if(intPageColCount==3){
	        intLength=4;
	    }
	     if(intPageColCount==4){
	        intLength=5;
	    }
	    var oRow= oTable.insertRow(selectRow+1);
	    oRow.style.height="25"
	    oRow.id="TR"+n;
		 oRow.className="drag_row";
		 oRow.setAttribute("ROW_TYPE",type);
	    for(var inti=0;inti<intLength;inti++){
		    oCell=oRow.insertCell();
		     var tmpString= "<table></table>"; //myFormTable.rows(tmpLength).cells(inti).innerHTML;
		     if(inti==0)
		     {
		       tmpString=' ';//<input type="radio" name="chkRow" />
		        
		        oCell.className="drag_row_td";
		        oCell.style.cursor="move"; 
		         oCell.style.height=trheight;
                oCell.onmousedown=function()
                {  
                   DragManager.onMouseDown(event,this);
                 } 
                oCell.dragstart=DataGrid.dragStart;
                oCell.ondblclick=function()
                {  
                   stopEvent(event);
                } 
               oCell.oncontextmenu=function()
                {  
                   showMenu(event); return true;
                } 
		     }else
		     {
		      if(inti==1&&type==10000)
		         {//3或4列
		           inti=intLength-1;
		           oCell.colSpan =intLength;
		         }
		         if(inti==1&&type==10002)
		         {//2、1列
		           inti++;
		           oCell.colSpan ="2";
		         }
		         if(inti==2&&type==10001)
		         {//s1、2列
		           inti++;
		           oCell.colSpan ="2";
		         }
		         if(inti==2&&type==10004)
		         {//s1、3列
		           inti++;
		           oCell.colSpan ="3";
		         }
		         if(inti==1&&type==10005)
		         {//s3、1列
		           inti++;
		           oCell.colSpan ="3";
		         }
		         if((inti==1||inti==3) &&type==10006)
		         {//s2、2列
		           inti++;
		           oCell.colSpan ="2";
		         }
		          oCell.className="drag_row_td_no";
		          oCell.onmouseover= function(){  MouseOverFun2(this);}
		          
		     }
		    oCell.innerHTML=tmpString;	
	    }  
	     return true;
    }
    //复制行
      function  copyRow(param)
       { 
      
        var  Event=param[0];
        var selectRow=0;
        var selectedTr=param[1];
            selectRow=  selectedTr.rowIndex ;
        // alert(selectRow);
         
         var oTable=selectedTr.parentNode; 
      if(!selectedTr)
      {
        alert("请选择要复制的行！");
        return;
      }
		var intLength=  selectedTr.cells.length;
		var oRow= oTable.insertRow(selectRow+1);
		oRow.style.height="25"
		oRow.id="TR"+n;
		 oRow.className="drag_row";
		for(var inti=0;inti<intLength;inti++){
			oCell=oRow.insertCell();
			 var tmpString="<table></table>";//  selectedTr.cells(inti).innerHTML;
			 if(inti==0)
			 {
			   tmpString=' ';//<input type="radio" name="chkRow" />
		        oCell.className="drag_row_td";
		        oCell.style.cursor="move"; oCell.style.height=trheight;
                oCell.onmousedown=function()
                {  
                   DragManager.onMouseDown(event,this);
                 } 
                oCell.dragstart=DataGrid.dragStart;
                oCell.ondblclick=function()
                {  
                   stopEvent(event);
                } 
               oCell.oncontextmenu=function()
                {  
                   showMenu(event); return true;
                } 
			 }else{
			 
			  oCell.onmouseover= selectedTr.cells(inti).onmouseover;
			  }
			   oCell.colSpan =selectedTr.cells(inti).colSpan;
			oCell.innerHTML=tmpString;	
		}
         // DataGrid.moveRow(oRow,selectRow+1);
       }
      
       
    //删除行
   function  delRows(param)
   {
        var selectRow=0;
        var selectedTr=param[1];
            selectRow=  selectedTr.rowIndex ; 
         var oTable=selectedTr.parentNode;  
          
          var dragColTables=document.getElementsByClassName('removableObj','table',selectedTr) ;;//初始化可拖动的table元素
           if( dragColTables.length  >0)
           {
              alert("删除的行存在字段,不能被删除");return ;
           }
          oTable.deleteRow(selectRow);
          return true;
    } 
       
 function attchKeydown(event)
{
	var keycode = event.keyCode;
	if(keycode == 13)
	{
		//toQuery();
	}
}