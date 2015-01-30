var isIE=/MSIE/.test(navigator.userAgent);
var isMoz=!isIE && navigator.product=='Gecko';
var __BLOCKED='请设置浏览将本站设置为可信站点，或设置弹出窗口阻止程序总是允许本站弹出窗口。\r\n或尝试按住 KEY 键进行点击。';
var POPUP_BLOCKED		= __BLOCKED.replace(/KEY/,'Shift');
var DIALOG_BLOCKED	= __BLOCKED.replace(/KEY/,'Ctrl+Alt');

if(isMoz){
	Event.prototype.__defineSetter__("returnValue", function(b){
		if(!b) this.preventDefault();
		return b;
	});
	Event.prototype.__defineSetter__("cancelBubble", function(b){
		if(b) this.stopPropagation();
		return b;
	});
	Event.prototype.__defineGetter__("srcElement", function(){
		var node=this.target;
		while (node.nodeType!=1) node=node.parentNode;
		return node;
	});
	Event.prototype.__defineGetter__("fromElement", function(){
		var node;
		if(this.type=="mouseover") node=this.relatedTarget;
		else if(this.type=="mouseout") node=this.target;
		if(!node) return;
		while(node.nodeType!=1) node=node.parentNode;
		return node;
	});
	Event.prototype.__defineGetter__("toElement", function(){
		var node;
		if(this.type=="mouseout") node=this.relatedTarget;
		else if(this.type=="mouseover") node=this.target;
		if(!node) return;
		while (node.nodeType!=1) node=node.parentNode;
		return node;
	});
	Event.prototype.__defineGetter__("offsetX", function(){
		return this.layerX;
	});
	Event.prototype.__defineGetter__("offsetY", function(){
		return this.layerY;
	});
	HTMLElement.prototype.insertAdjacentElement=function(where,parsedNode){
		switch(where){
			case "beforeBegin":	this.parentNode.insertBefore(parsedNode,this);	break;
			case "afterBegin":	this.insertBefore(parsedNode,this.firstChild);	break;
			case "beforeEnd":	this.appendChild(parsedNode);	break;
			case "afterEnd":
				if(this.nextSibling)this.parentNode.insertBefore(parsedNode,this.nextSibling);
				else	this.parentNode.appendChild(parsedNode); break;
	  }
	}
}

Number.prototype.round = function(x){
	if(typeof(x) != "number")	x=2;
	var a = this.toString().split(".");
	if(a.length==1 || x>=a[1].length){
		return this;
	}else{
		a[1] = Math.round(parseInt(a[1].substr(0, x+1),10)/10);
		if(a[1]>0 && a[1].toString().length > x){
			return Number(a[0]) + 1;
		}else{
			a[1]="0".repeat(x-a[1].toString().length)+a[1].toString(); return Number(a.join("."));
		}
	}
}
Number.prototype.formatCurrency=function(){return Currency.format(this);}
String.prototype.trim = function(){return this.replace(/^\s+|\s+$/g, "");}
String.prototype.ltrim = function(){return this.replace(/^\s+/g, "");}
String.prototype.rtrim = function(){return this.replace(/\s+$/g, "");}
String.prototype.format = function(){
	if(arguments.length==0)return this; var reg=/{(\d+)?}/g,args=arguments;
	return this.replace(reg,function($0,$1){return args[parseInt($1)];});
}
String.prototype.formatArray = function(arr){
	if(arr.length==0)return this; var reg=/{(\d+)?}/g,args=arr;
	return this.replace(reg,function($0,$1){return args[parseInt($1)];});
}
String.prototype.repeat = function(r,sp){r=r||0;if(r==0)return '';sp=sp||'';var z=this;while(--r>0)z+=sp+this;return z;}
String.prototype.formatCurrency = function(){return Currency.format(this);}
String.prototype.unFormatCurrency = function(){return this.replace(/\,/g,"");}
String.prototype.toNumber = function(){var v=this.replace(/\,/g,"");v=/\./g.test(v)?parseFloat(v):parseInt(v,10);return isNaN(v)?0:v;}
String.prototype.toDate=function(){
	try{
		var a =this.split(" "),b =a[0].split("-");
		if(a.length==1){return new Date(b[0],b[1]-1,b[2]);}else{var c=a[1].split(":");return new Date(b[0],b[1]-1,b[2],c[0],c[1]);}
	}catch(e){ return null;}
}
String.prototype.toDbString = function(){return this.replace(/([A-Z])/g,'_$1').toUpperCase();}
String.prototype.toJString = function(){return this.toLowerCase().replace(/_\w/g,function(a){return a.substr(1,1).toUpperCase()})}
String.prototype.uncapitalize = function(){
	if(this==null || this=="") return this; else return this.substring(0,1).toLowerCase() + this.substr(1);
}

Array.prototype.distinct = function() {   
   var ret = [], resultArr = [], returnArr = [];
   var a = {};   
   for(var i=0; i<this.length; i++) {
    if(typeof a[this[i]] == "undefined") { a[this[i]] = false;  } else{ a[this[i]] = true;}
   }     
   for(var i in a){returnArr[returnArr.length] = i;}
   return  returnArr;
}

Array.prototype.mergeSort = function(s, e, b){
	if (s == null) s = 0;
	if (e == null) e = this.length - 1;
	if (b == null) b = new Array(this.length);
	if (s >= e) return;
	var m = (s + e) >> 1;
	this.mergeSort(s, m, b);
	this.mergeSort(m + 1, e, b);
	for (var i = s, j = s, k = m + 1; i <= e; ++i){
	    b[i] = this[(k > e || j <= m && this[j] < this[k]) ? j++ : k++];
	}
	for (var i = s; i <= e; ++i) this[i] = b[i];
}

Date.prototype.toChar=function(pattern){
	pattern=(pattern||"yyyy-MM-dd").toLowerCase();	var o={};
	o.yyyy=this.getFullYear();o.yy=this.getYear();o.m=this.getMonth()+1;o.mm=o.m<10?"0"+o.m:o.m;o.d=this.getDate();o.dd=o.d<10?"0"+o.d:o.d
	o.h=o.hh=this.getHours();o.hh=o.h>9?o.h:"0"+o.h;o.n=this.getMinutes();o.nn=o.n>9?o.n:"0"+o.n;o.s=this.getSeconds();o.ss=o.s>9?o.s:"0"+o.s;
	var a="yyyy,mm,dd,hh,nn,ss,yy,m,d,h,n,s".split(",");
	for(var i=0;i<a.length;i++){pattern=pattern.replace(a[i],o[a[i]]);} return pattern;
}

var Currency={
	split:function(v){
		v = String(v); var pattern = /^(.*\s)?([-+]?\d+)(\d{3}\b)/;
		return v == (v=v.replace(pattern, "$1$2,$3"))?v:Currency.split(v);
	},
	format: function(v){
		v=v+""; if(isNaN(v)) return v;
		var v = v.replace(/\,/g,""); if(!/^[\+|\-]{0,1}\d+(\.\d+){0,1}$/.test(v)) return v;
		var arr = v.split("."); v = Currency.split(arr[0]);
		if(arr.length==1) return v + '.00';
		else return v + "." + arr[1] + (arr[1].length==1?'0':'');
	},
	unFormat:function(v){
		return v.unFormatCurrency();
	},
	focus:function(o){
		var r=document.selection.createRange(); r.moveStart("character", -99999);
		var idx=Currency.unFormat(r.text).length; o.value=Currency.unFormat(o.value);
		r=o.createTextRange(); r.moveStart("character",idx); r.collapse(); r.select();
	},
	blur:function(o){o.value=Currency.format(o.value);}
}
var Num={
	focus:function(o){}, blur:function(o){},
	press: function(o,ev){
		var k=ev.keyCode||ev.which;
		var r=document.selection.createRange(); r.moveStart("character", -99999);
		var l=r.text.length, v=o.value; v=v.substr(0,l)+String.fromCharCode(k)+v.substr(l) ;
		var p = (/Currency/i.test(o.getAttribute('className'))||o.getAttribute('datascale'))?/^[+-]{0,1}\d+(\.\d*){0,1}$/:/^[+-]{0,1}\d+$/; 
		if(!p.test(v)) ev.returnValue=false;
	}
}


var Cal={}

var Dom={
	selectNodes: function(node,nodeName,attrName,compare,single){
		var nnCompare=function(){return true}, z=[];
		if(!attrName) compare = function(){return true};
		nodeName=nodeName||'*';
		if(nodeName.constructor==RegExp){
			var pattern=nodeName; nnCompare=function(o){return pattern.test(o.tagName)}; nodeName=false;
		}else{
			nodeName=nodeName.toUpperCase();
		}
		if(compare==null) return [];
		if(compare.constructor!=Function){
			var v=compare;
			if(compare.constructor==RegExp)compare=function(item){return v.test(item.getAttribute(attrName))}
			else compare=function(x){return v==x.getAttribute(attrName)};
		}
		var xs=(node.constructor&&node.constructor.toString()==Array)?node:Dom.getAllChildren(node,nodeName);
		if(single)for(i=0;i<xs.length;i++){if(nnCompare(xs[i])&&compare(xs[i]))return [xs[i]]}
		for(i=0;i<xs.length;i++){if(nnCompare(xs[i])&&compare(xs[i])){z.push(xs[i]);}}
		return z;
	},
	selectSingleNode: function(node,nodeName,attrName,compare){
		var nodes=this.selectNodes(node,nodeName,attrName,compare,true);if(nodes.length==0)return null;return nodes[0];
	},
	parentNode: function(node,nodeName,attrName,compare){
		nodeName=(nodeName||"*").toUpperCase();
		if(!attrName)compare=function(){return true};if(compare==null)return null;
		if(compare.constructor!=Function){
			var v=compare;
			if(compare.constructor==RegExp)	compare=function(pNode){return v.test(pNode.getAttribute(attrName))};
			else compare=function(x){return v==x.getAttribute(attrName)};
		}
		var z=node.parentNode; if(z==document.body) return z;
		if(!z||z.nodeName=='#document-fragment') return document.body;
		if((nodeName=="*"||z.tagName==nodeName) &&compare(z)) return z; else return this.parentNode(z,nodeName,attrName,compare);
	},
	siblingNode: function(node,nodeName,attrName,compare){
		var x=node.nextSibling;while(x&&x.nodeName=='#text'){x=x.nextSibling}
		return x==null?null:this.selectSingleNode([x],nodeName,attrName,compare);
	},
	youngerNode: function(node,nodeName,attrName,compare){
		return this.selectSingleNode(node.parentNode,nodeName,attrName,compare);
	},
	getAllChildren:function(A,B){
		return B?A.getElementsByTagName(B):(A.all?A.all:A.getElementsByTagName("*"))
	},
	copyAttributes: function (node,pattern,prefix,keepNull){
		prefix=prefix?prefix:"";var o={};
		if(!pattern || pattern=="*"){
			for (var i = 0; i <node.attributes.length; i++){
				var att = node.attributes[i], name = att.nodeName;
				if(name.indexOf(prefix) == 0){
					var tn = name.substr(prefix.length), v = att.nodeValue; if(v!=null) o[tn] = v; else if(!keepNull) o[tn]="";
				}
			}
		}else{
			var ns = pattern.split(",");
			for(var i = 0;i<ns.length;i++){
				var name = ns[i],v = node.getAttribute(prefix + name); if(v!=null) o[name] = v; else if(!keepNull) o[name]="";
			}
		}
		return o;
	},
	getZIndex: function(o){
		while(!o.style.zIndex && o.parentNode){o = o.parentNode;if(o == document.body) return 1;}
		return o.style.zIndex;
	},
	prompt: function(tips,value,title,features){
		tips=tips||"请输入"; value=value||"";title=title||"请输入";
		return window.showModalDialog("/commons/prompt.htm",{tips:tips,value:value,title:title},
																	 features||"dialogHeight:529px;dialogWidth:660px;resizable:yes;scroll:no;status:no;help:no;");
	},
	popPage: function(node,w,h){
		var action=node.getAttribute('action'); w=w||(screen.availWidth>900?900:800); h=h||(screen.availHeight>800?800:550);
		var tips=node.getAttribute('confirm'); if(tips)tips=tips.replace(/\\r/g, '\r');
		if(tips && !window.confirm(tips)) return false;
		action=action||(node.tagName=='A'?node.href:'about:blank');
		var target=node.getAttribute('target')||'_blank';
		var operWin = window.dialogArguments?(window.dialogArguments.document||window.dialogArguments[2]).parentWindow:window;
		try{
			var win = operWin.open(action,target,'toolbar=no,resizable=yes,status=no,scrollbars=yes,width={0}px,height={1}px,left={2}px'.format(w,h,screen.width/2-400));
			if(!win){window.alert(POPUP_BLOCKED);return false;}
			try{win.focus();}catch(ex){}
		}catch(e){
			window.alert(POPUP_BLOCKED);
		}
		if(target=='_blank' || event.shiftKey) return false;
	},
	loadPage: function(node,target,handler){
		try{
			var action = node.getAttribute('action');
			var tips=node.getAttribute('confirm'); if(tips)tips=tips.replace(/\\r/g, '\r');
			var once = node.getAttribute('once');
			if(tips && !confirm(tips)) return false;
			if(once){ if(node.onceLock){ window.alert('页面处理中，请耐心等待..'); return false;} node.onceLock=true;}
			action += (/\?\w+=/.test(action)? '&':'?') + 'tstmp=' + new Date().getTime();
			target=target?target:node.getAttribute('target'); target=target?target:'_self';
			if(action) window.open(action,target);
			var s = '';
			if(/a|button|div|span/i.test(node.tagName)){
				s = node.innerText||node.innerHTML;
			}else if(/input/i.test(node.tagName)){
				s = node.value;
			}
			var msg = '<img src="/styles/site/wait.gif" width="23" height="23" align="absmiddle"/> 页面加载中(' + s + ')，请稍候..';
			if(target=='_self'){Page.mask(msg);}else{try{window.eval('parent.'+target).Page.mask(msg);}catch(e){}}
			if(handler && handler.constructor==Function)handler(node);
			return true;
		}catch(e){
			return false;
		}
	},
	deleteRow:function(el){
		var row=Dom.parentNode(el,'tr'), tips=el.getAttribute('confirm');	if(!tips||window.confirm(tips))	row.removeNode(true);
	},
	getPropertyNames:function(o){
		var ps=[];for(var k in o){ps.push(k);};return ps;
	},
	objectToString: function(o){
		var ps=[];for(var k in o){ps.push(k + ' = '+o[k]);};return ps;
	}
};

var Desktop={
	debug:true,
	hint:function(s,o){
		var rect= top.$("hintRect"); if(rect){
			rect.contentWindow.document.getElementById("hintDiv").innerText = s;
			var w,h,l,t;
			if(o&&o==top){w="100%";h="100%";l="0px";t="0px"}
			this.open(rect,event,w,h,l,t);
		}
	},
	open:function(o,event,w,h,l,t){
		var r = top.$("hintRect");	if(!r) return false; w=w?w:top.document.body.offsetWidth; h=h?h:"46px";
		r.style.width= w;		r.style.height= h;	r.style.left= l?l:(top.document.body.offsetWidth - w) + "px";	r.style.top= t?t:"0px";
		r.style.display="block";
	},
	close:function(r,event){r.style.display="none";},
	showClock:function(o){
		//return false;
		var clock = top.$("clock"), jsClock= top.$("jsClock");
		if(clock){
			var p = Position.cumulativeOffset(o);
			clock.style.left = p[0] + o.offsetWidth - 120;	clock.style.top = p[1] - 100;
			jsClock.style.display = clock.style.display;
			clock.style.display = clock.style.display=="none"?"block":"none";
		}
	}
}


var Cookie={
	setCookie: function(cookieName,cookieValue,expireTime){
		var expires="";
		if(expireTime){
			var date = new Date();
			date.setTime(date.getTime() + expireTime * 86400000);
			expires="; expires=" +date.toGMTString();
		}
		document.cookie=cookieName +"=" +escape(cookieValue) +expires +"; path=/;";
	},
	getCookie: function(cookieName){
		cookieName += "=";
		var a=document.cookie.split(';');
		for(var i=0;i<a.length;i++){
			var pair=a[i].ltrim();
			if(pair.indexOf(cookieName) == 0) return unescape(pair.substring(cookieName.length, pair.length));
		}
		return null;
	}
};

var FrameSet={
	toggleLoader: function(button){
		if(top==window || !top.$ || !top.$("presentation")) return false;
		var root=top.$("presentation").contentWindow.$("root"), content=top.$("presentation").contentWindow.$("content");
		if(root.rows=="40,*"){root.rows="0,*"; content.cols="0,*"; if(button)button.className="absmiddle page normalize";	}
		else{root.rows="40,*"; content.cols="170,*"; if(button)button.className="absmiddle page maximize";	}
	},
	toggleFixer: function(button){
		var table = Dom.selectSingleNode(document,"table","id","page");
		if(table) table.style.tableLayout = table.style.tableLayout=="fixed"?"":"fixed";
	}
};

var Page={
	pwd: function(node){//pwd
		var s=window.location.href, catWin = top.$("catalog").contentWindow;
		var a=Dom.selectNodes(catWin.document,"div","id","member");
		var pf= window.location.protocol+"//" +window.location.host +(window.location.port?(":"+window.location.port):"");
		var y=[], z={};
		for(var i=0;i<a.length;i++){
			var u=pf + a[i].getAttribute("action");
			if(u.indexOf(s)==0){
				y.push(u); z[u]=a[i];
			}
		}
		if(y.length==0) return;
		y.sort(); catWin.Cat.activate(z[y[y.length-1]],true);
	},
	print: function(button){//print

	},
	ln: function(button){//link node

	},
	contextmenu: function(event){
		var el = event.srcElement;
		if(el.tagName=="BODY"){
			return false;
		}
		return true;
	},
	initPage: function(){
		if(top==window && $("pageScaler"))$("pageScaler").style.display="none";
		var msgTd = Dom.selectSingleNode(document,"TD","id","pageMessages");
		if(msgTd && msgTd.innerText.trim()) msgTd.style.display = "block";
		if(top.$ &&top.$("presentation") &&$("pageScaler")){
			$("pageScaler").className="absmiddle page "+(top.$("presentation").contentWindow.$("root").rows=="50,*"?"maximize":"normalize")
		}
	},
	mask: function(s,placeHolder,zIndex){
		var m = Page.cover || (Page.cover=document.createElement("IFRAME"));
		var cssText = "position:absolute;z-Index:{0};filter:alpha(opacity=65);border:none;".format(zIndex?zIndex:10);
		if(placeHolder){
			var p = Position.cumulativeOffset(placeHolder);
			cssText += "width:" + placeHolder.offsetWidth + "px;height:" + (placeHolder.offsetHeight||50) + "px;left:" + p[0] + "px;top:" + p[1] + "px;"
		}else{
			cssText += "width:100%;height:" + document.body.scrollHeight + "px;left:0px;top:0px;"
		}
		var body=document.body; if(!body) return false;
		m.style.cssText=cssText; body.appendChild(m); 
		var doc= m.contentWindow.document;
		var txt='<body style="background-color:#FFFFF8;font-weight:bold;border:none;padding-top:{0}px;">{1}</body>';
		doc.open();doc.write(txt.format(body.scrollTop,s));doc.close();
		var cleanMe = function (){ m=null; window.detachEvent("onunload",cleanMe); }
		window.attachEvent("onunload",cleanMe);
	},
	unMask:function(){
		if(Page.cover) Page.cover.style.display="none";
	}
};

var Section={
	toggle: function(button){
		var contentNode = $("section[" + button.getAttribute("section") + "]");
		var isHidden= contentNode.style.display=="none";
		contentNode.style.display=isHidden?"":"none";
		button.className= "absmiddle section " + (isHidden?"hideContent":"showContent");
	},
	collapse: function(button){
		var section = Dom.parentNode(button,"table","id","section");
		var box = Dom.selectSingleNode(section, "div", "id", "sectionBox");
		var isScroll=button.isScroll;
		if(!isScroll && parseInt(box.offsetHeight,10)>246){
			box.style.height = "270px"; box.style.overflowY = "auto";
		}else{
			box.style.height = ""; box.style.overflowY = "visible";
		}
		button.className = "absmiddle section " + (isScroll?"boxScroll":"boxSpread");
		button.isScroll = !isScroll;
	}
};

var Row={
	onmouseover: function(){
		this._obgColor=this.style.backgroundColor;
		this.style.backgroundColor="#E2E4F4";
		event.cancelBubble = true;
	},
	onmouseout: function(){
		this.style.backgroundColor=this._obgColor;
		event.cancelBubble = true;
	},
	bind: function(table){
		var rows = table.rows;
		for(var i=0;i<rows.length;i++){Object.extend(rows[i],this);};
	},
	bindNodes: function(rows){
		for(var i=0;i<rows.length;i++){Object.extend(rows[i],this);};
	}
};

function LogicField(field){
	Object.extend(this,	
		Dom.copyAttributes(field,"name,label,type,value,maxlength,required,requiredtips,datatype,dataprecision,datascale,range,pattern,message,disabled")
	);
	this.fields	= [field];	this.messages=[];
	this.filters	= {
		validateRequired:function(f){
			if(f.disabled || !f.required || /^(0|false)$/i.test(f.required)) return true;
			var m=[];
			for(var i=0;i<f.fields.length;i++){
				var x=f.fields[i],g=/^(radio|checkbox)$/i.test(x.type);if(g&&x.checked)return true;else if(!g&&x.value.trim()!=""){return true;}
			}
			f.messages.push(f.requiredtips ||"请" + (/^(text|dbstring|number|currency)$/i.test(f.datatype)? "填写":"选择") +"“"+f.label+"”(必填项)。");
		},
		validateData:function(f){
			var v=f.value,lbl=f.label; if(f.disabled || !f.required&&v.trim()=="")return true;
			switch(f.datatype.toLowerCase()){
				case "number":
					var precision=f.dataprecision?f.dataprecision:10, scale=f.datascale?f.datascale:0; v=v.unFormatCurrency();
					var p = /^-{0,1}\d+(\.\d+){0,1}$/.test(v);	if(!p) f.messages.push("“{0}”必须是一个数字，“{1}”是无效或不完整的输入".format(lbl,v));
					var re;
					if(scale>0)re=new RegExp("^-{0,1}\\d{1,"+(precision-scale)+"}(\\.\\d{1,"+scale+"}){0,1}$"); else re=new RegExp("^-{0,1}\\d{1,"+(precision)+"}$");
					if(!re.test(v)){
						if(scale>0) f.messages.push("请检查“{0}”的格式（整数部分最多 {1} 位，小数部分最多 {2} 位）".format(lbl,(precision-scale),scale));
						else f.messages.push("请检查“{0}”的格式（最多 {1} 位）".format(lbl,precision));
					}
					if(f.range){
						var re=/^([\[\(])(-{0,1}\d+(\.\d+){0,1})\,(-{0,1}\d+(\.\d+){0,1})([\]\)])$/;
						var b = f.range.match(re),message='';
						if(b[1]=='['&&b[6]==']'&&parseFloat(b[2])==parseFloat(b[4])){
							message=lbl+'必须等于 '+b[2];
						}else {
							message+=(b[1]=="[")?(lbl+"必须 ≥ "+b[2]):(lbl+"必须 > "+b[2]);message+=(b[6]=="]"?(" 并且 ≤ " +b[4]):(" 并且 < "+b[4]));
						} 
						if(b[1]=="["&&parseFloat(v)<parseFloat(b[2]))f.messages.push(message);if(b[1]=="("&&parseFloat(v)<=parseFloat(b[2]))	f.messages.push(message);
						if(b[6]=="]"&&parseFloat(v)>parseFloat(b[4]))f.messages.push(message);if(b[6]==")"&&parseFloat(v)>=parseFloat(b[4]))	f.messages.push(message);
					};
					break;
				case "dbstring":
					var msg = "“{0}”必须是半角的英文字母、数字或下划线"; if(!/^\w+$/.test(v))f.messages.push(msg.format(lbl));
					break;
				case "idcard":
					var msg = "“{0}”必须是半角的英文字母、数字或下划线"; if(!/^\d{17}(\d|x)$|^\d{15}$/i.test(v))f.messages.push(msg.format(lbl));
					break;
				case "postcode":
					var msg = "“{0}”域的输入无效"; if(!/^\d{6}$/.test(v))f.messages.push(msg.format(lbl));
					break;
				default:
					if(f.pattern){
						if(!(new RegExp(f.pattern).test(v)))f.messages.push(f.message?f.message:("“"+lbl+"”域的输入无效"));
					}
			}
		}
	};
}

LogicField.getOption = function(o){
	return o.options[o.selectedIndex];
}

LogicField.getOptionAttribute = function(o,n){
	return o.options[o.selectedIndex].getAttribute(n)||'';
}

LogicField.prototype.report	= function(){
	if(this.messages.length==0) return true;
	window.alert(this.messages.join("\r\n")); try{this.focus();}catch(e){};	return false;
}
LogicField.prototype.addField=function(field){this.fields.push(field);}
LogicField.prototype.validate=function(ignoreError){
	for(var k in this.filters){this.filters[k](this);if(!ignoreError && this.messages.length>0){return this.report();}}
	return this.report();
}
LogicField.prototype.getValue=function(){
	return this.getValues().join(",");
}
LogicField.prototype.getValues=function(){
	var arr=[];this.fields.each(function(field){
		var ft=field.type, ptn=/^(radio|checkbox)$/i;
		if(!field.disabled &&(ptn.test(ft)&&field.checked||!(ptn.test(ft)))){
			arr.push(/^(number|currency)$/i.test(field.datatype)?field.value.unFormatCurrency():field.value);
		}
	});
	return arr;
}
LogicField.prototype.getAttribute=function(attr,idx){idx=idx||0; return this.fields[idx].getAttribute(attr);};
LogicField.prototype.setValue=function(v){
	var arr=[];this.fields.each(function(field){
		if(field.disabled) return false; var ft=field.type;
		var ptnRadio=/^(radio)$/i, ptnCheckbox=/^(checkbox)$/i;
		if(ptnRadio.test(ft)){if(v==field.value)field.checked=true;}
		else if(ptnCheckbox.test(ft)){for(var i=0;i<v.length;i++){if(v[i]==field.value){field.checked=true;break;}}}
		else field.value=v;
		field.fireEvent("onchange");
	});
}
LogicField.prototype.getSelector=function(){
	var selector=LogicForm.getSelectorForm(this.fields[0]); return (selector==document.body)?false:selector;
}
LogicField.prototype.getGroup=function(){
	var g=Dom.parentNode(this.fields[0],"SPAN","id","sniperGroup"); return (g==document.body)?false:g;
}
LogicField.prototype.getEdge = function(){
	var id = this.fields[0].id, rect = Dom.parentNode(this.fields[0], '*', 'id' , 'area#' + id);
	if(rect == document.body) return false;
	return Dom.selectSingleNode(rect, '*', 'id', 'edge#' + id);
}
LogicField.prototype.setRequired=function(z){
	if((!!this.required)==z) return false;
	this.fields.each(function(field){field.required=z});
	var selector= this.getGroup() || this.getSelector() || this.getEdge() || this.fields[this.fields.length-1];
	if(z){
		var span=document.createElement("span");span.className="required";
		span.innerHTML="*";	selector.insertAdjacentElement("afterEnd",span);
	}else{
		var span=Dom.siblingNode(selector,'span','className','required'); if(span) span.removeNode(true);
	}
}
LogicField.prototype.focus=function(){
	try{if(this.datatype.indexOf("date")){this.fields[0].fireEvent("onclick");}}catch(e){};
	var focusSelector=function(o){
		var tb=o.getSelector()|| o.getEdge();
		if(tb)var btn=Dom.selectSingleNode(tb,'input','className','selectorBtn');if(btn)btn.focus();
	};
	try{
		if(this.focusField){
			this.focusField.focus(); 
		}else if(this.fields.length>0){
			var field=Dom.selectSingleNode(this.fields,"*","disabled",function(o){return !o.disabled && !o.readOnly;});
			if(field){field.focus();}else{focusSelector(this);} 
		}
	}catch(e){focusSelector(this);}
}
LogicField.prototype.setVisible=function(z){
	//if((this.visible!=undefined)==z) return false;
	var selector=this.getSelector()|| this.fields[0];
	var optional=Dom.parentNode(selector,"*","optional",function(x){return x.getAttribute("optional")!=null});
	if(optional==document.body){if(Desktop.debug)alert("可选参数错误 ["+ this.name +"]");return false;	}
	this.fields.each(function(field){field.style.display=z?"":"none";});
	optional.style.display = z?"":"none";
}
LogicField.prototype.setDisabled=function(z,func){
	//if((this.disabled!=undefined)==z ) return false;
	if(func&&!func(this)) return false;
	var selector=this.getSelector(), fields = selector?Dom.selectNodes(selector,/(input|textarea|select)/i):this.fields;
	fields.each(function(field){field.disabled=z;}); //?FIX
}
LogicField.prototype.setReadOnly=function(z,func){
	if(func&&!func(this)) return false; this.fields.each(function(field){field.readOnly=z;});
}

var LogicFields={
	populate:function(logicFields){
		var map = {};for(var k in logicFields){map[k] = logicFields[k].getValue();};return map;
	}
}

var LogicForm={
	debug:false,
	getField:function(form,n){
		var nodes=form.elements[n];return nodes?(nodes.length?nodes[0]:nodes):null;
	},
	getFields:function(form,n){
		var nodes=form.elements,arr=[],ns=n?n.split(','):false;
		if(ns){
			for(var i=0;i<ns.length;i++){var k=ns[i],x=nodes[k];if(x){if(x.length){for(var j=0;j<x.length;j++){arr.push(x[j])}}else{arr.push(x)}}}
		}else{
			for(var i=0;i<nodes.length;i++){var x=nodes[i];if(x.name&&x.type)arr.push(x)}
		}
		return arr;
	},
	getNamedFields:function(form){
		var compare = function(field){return /(input|button|textarea|select)/i.test(field.tagName) && field.getAttribute("name");}
		var nodes = (form.tagName||'')=='FORM'?LogicForm.getFields(form):Dom.selectNodes(form,"*","name",compare);
		for(var i=1;i<arguments.length;i++){ if(arguments[i]) nodes =Dom.selectNodes(nodes,"*","name",arguments[i]); }
		return nodes;
	},
	getLogicFields:function(form,compare){//取得逻辑域
		var fields=this.getNamedFields(form,compare);
		var logicFields = {}, fm={};
		for(var i=0;i<fields.length;i++){
			var k=fields[i].name;
			if(logicFields[k]){
				logicFields[k].addField(fields[i]);
				if(logicFields[k].disabled && !fields[i].disabled){ 
					Object.extend(logicFields[k],Dom.copyAttributes(fields[i],"value,required,requiredtips,datatype,dataprecision,datascale,range,pattern,message,disabled"));
				}
			}else{
				var f = logicFields[k]=new LogicField(fields[i]);
				if(fields[i].getAttribute('focusField')){fm[f.name]=fields[i].getAttribute('focusField');}
			}
		}
		for(var k in fm){logicFields[k].focusField=logicFields[fm[k]]};
		return logicFields;
	},
	fastLogicFields:function(m){//fastGet
		if((m.form.tagName||'')!='FORM') return LogicForm.getLogicFields(m.form,m.compare);
		var logicFields={},ns=m.name.split(','),arr=[],fm={};
		for(var j=0;j<ns.length;j++){
			var k=ns[j],fs=LogicForm.getFields(m.form,k);
			for(var i=0;i<fs.length;i++){
				if(i==0){
					var f = logicFields[k]=new LogicField(fs[i]);
					if(fs[i].getAttribute('focusField')){fm[f.name]=fs[i].getAttribute('focusField');}
				}else{
					logicFields[k].addField(fs[i]);
					if(logicFields[k].disabled && !fs[i].disabled) 
						Object.extend(logicFields[k],Dom.copyAttributes(fs[i],"value,required,requiredtips,datatype,dataprecision,datascale,range,pattern,message,disabled"));
				}
			}
		}
		for(var k in fm){logicFields[k].focusField=logicFields[fm[k]]};
		return logicFields;
	},
	filters:{
		fieldsFilter:function(form,compare){
			var logicFields=LogicForm.getLogicFields(form,compare);
			for(var k in logicFields){if(!logicFields[k].validate())return false;}
			return true;
		}
	},
	resetFilters: function(){
		for(var k in filters){if(k!='validateOrder'){delete filters[k];}}LogicForm.validateOrder='fieldsFilter';
	},
	pushFilter:function(k,filter,isAppend,tips){
		if(!LogicForm.filters[k]) if(isAppend){LogicForm.validateOrder.reverse().push(k);LogicForm.validateOrder.reverse();}else{LogicForm.validateOrder.push(k)};
		filter.tips=tips; LogicForm.filters[k]=filter;
	},
	appendFilter:function(k,filter){
		LogicForm.pushFilter(k,filter,true);
	},
	fillFields:function(form,map,indx,prefix,noChangeEvent){
		var fields = form.tagName?Dom.selectNodes(form,/input|select|textarea/i):form;
		indx=indx?indx:'name'; prefix=prefix?prefix:'';
		for(var k in map){
			var field=Dom.selectSingleNode(fields,false,indx,prefix+k);if(field){field.value=map[k];if(!noChangeEvent)field.fireEvent("onchange")}
		}
	},
	simpleCheckChange:function(form){
		for(var i=0;i<form.elements.length;i++){
			var element=form.elements[i],type=element.type;
			if(/^(text|hidden|textarea|button)$/.test(type) && element.value!=element.defaultValue){
				return true;
			}else if(/^(radio|checkbox)$/.test(type) && element.checked!=element.defaultChecked){
				return true;
			}else if(/^select\-/.test(type)){
				for(var j=1;j<element.options.length;j++){if(element.options[j].selected!=element.options[j].defaultSelected){return true;}}
			}
		}
		return false;
	},
	checkChange:function(m){
		var onBeforeCheck=m.onBeforeCheck||function(){
			var divs=Dom.selectNodes(document,'div','id','MarkAsChanged');for(var i=divs.length-1;i>-1;i--)divs[i].removeNode(true);
		};
		var onAfterCheck=m.onAfterCheck||function(o){
			var div=document.createElement('<div id="MarkAsChanged"/>'),p = Position.cumulativeOffset(o);
			div.style.cssText='color:red;position:absolute;z-Index:20;width:{0}px;left:{1}px;top:{2}px;'.format(o.offsetWidth,p[0],(p[1]+o.offsetHeight+1))
											 +'background-image:url("/styles/site/markAsChanged.gif");background-repeat:repeat-x;height:3px;';
			document.body.appendChild(div);
		};
		var isChanged=false,form=m.form;
		onBeforeCheck();
		for(var i=0;i<form.elements.length;i++){
			var o=form.elements[i],type=o.type;
			if(/^(text|hidden|textarea|button)$/.test(type) && o.value!=o.defaultValue){
				isChanged=true;onAfterCheck(o);
			}else if(/^(radio|checkbox)$/.test(type) && o.checked!=o.defaultChecked){
				isChanged=true; onAfterCheck(o);
			}else if(/^select\-/.test(type)){
				for(var j=1;j<o.options.length;j++){if(o.options[j].selected!=o.options[j].defaultSelected){isChanged=true;onAfterCheck(o);break;}}
			}
		}
		return isChanged;
	},
	protect:function(form){
		if(!form.serialized || form.serialized.constructor!=Boolean){
			form._serializeCount=form.elements.length; form._serializeData=Form.Methods.serialize(form);
			form.serialized = true;
			window.attachEvent("onbeforeunload",function(event){
				if((form._serializeCount!=form.elements.length||form._serializeData!=Form.Methods.serialize(form))&&!form.validated){
					event.returnValue= form.getAttribute("losttips")
						|| form.getAttribute("label")?("离开页面将无法保存对表单“{0}”的修改。".format(form.getAttribute("label"))):"离开页面将无法保存对表单的修改。";
				}
			});
		}
	},
	openMonitor:function(){
		var forms=Dom.selectNodes(document,"form","monitor","1");for(var i=0;i<forms.length;i++){ LogicForm.protect(forms[i]); }
	},
	beforeValidate:function(form){
		return true;
	},
	afterValidate:function(form){
		if(this.confirm(form)){
			var msg='<img src="/styles/site/wait.gif" width="23" height="23" align="absmiddle"/> 表单提交中，请稍候..';
			if(!form.target || form.target=="_self"){Page.mask(msg,false,100);}	return true;	}else{return false;}
	},
	confirm:function(form){
		var tips=form.getAttribute("confirm"); if(tips)tips=tips.replace(/\\r/g,"\r");
		return (!tips || tips&&window.confirm(tips));
	},
	validateOrder:["fieldsFilter"],
	validate:function(form,compare,isnLast){
		try{
			if(form.validated){window.alert("表单提交中，请耐心等待。"); return false;}
			if(!this.beforeValidate(form,compare)) return this.resumeFormat(form);
			var names = this.validateOrder;
			for(var i=names.length-1;i>-1;i--){
				var k=names[i];if(!this.filters[k](form,compare)){
					if(this.filters[k].tips)window.alert(this.filters[k].tips);
					return this.resumeFormat(form);
				}
			}
			if(!this.afterValidate(form,compare)) return this.resumeFormat(form);;
			this.cleanFormat(form); if(!isnLast) form.validated = true;	return true;
		}catch(e){window.alert(e.message); return this.resumeFormat(form);}
	},
	cleanFormat:function(form){
		if(this.customCleanFormat) return this.customCleanFormat(form);
		var fs=LogicForm.getNamedFields(form,function(node){return /^(currency|number)$/.test(node.getAttribute('className'))});
		for(var i=0;i<fs.length;i++){fs[i].value=fs[i].value.unFormatCurrency();}
	},
	resumeFormat:function(form){
		if(this.customResumeFormat){this.customResumeFormat(form);return false;}
		var fs=LogicForm.getNamedFields(form,function(node){return node.getAttribute('className')=="currency"});
		for(var i=0;i<fs.length;i++){fs[i].value=fs[i].value.formatCurrency();}
		return false;
	},
	getSelectorForm:function(o){
		return Dom.parentNode(o,"TABLE","id","selector");
	},
	getSelectorMap:function(form){
		var inputs = form.tagName?Dom.selectNodes(form,"*","selectorid",function(x){return x.getAttribute("selectorid");}):form;
		var map={}; inputs.each(function(input){map[input.getAttribute("selectorid")]= input.value });	return map;
	},
	bindOptions:function(targForm,srcForm){
		var compare = function(el){return /select/i.test(el.tagName)};
		var tOptions = LogicForm.getLogicFields(targForm,compare);
		var sOptions = LogicForm.getLogicFields(srcForm,compare);
		for(var k in tOptions){ if(sOptions[k]){tOptions[k].setValue(sOptions[k].getValue());}}
	},
	selectAll: function(o,n,f){
		var boxes=document.getElementsByName(n), checked=o.checked;
		var l=boxes.length; if(l==0) return false;
		if(f){for(var i=0;i<l;i++){ boxes[i].checked=checked;} boxes[0].fireEvent('onclick');
		}else{for(var i=0;i<l;i++){ boxes[i].checked=checked; boxes[i].fireEvent('onclick');}}
		return true;
	},
	generateXML:function(form,tableId){
		var f = Dom.selectSingleNode(form,"input","name","RowsXML");
		if(!f){
			if(isMoz){
				f = document.createElement('input');
				f.setAttribute("type","hidden");	f.setAttribute("id","RowsXML");	f.setAttribute("name","RowsXML");	f.setAttribute("value","");
			}else{
				f = document.createElement('<input type="hidden" id="RowsXML" name="RowsXML" value=""/>')
			}
			form.appendChild(f);
		}
		var doc = new ActiveXObject("MSXML2.DOMDocument.3.0");
		doc.appendChild(doc.createProcessingInstruction("xml","version='1.0'  encoding='UTF-8'")); //HEAD
		var beans = doc.createElement("table")
		beans.setAttribute("id",tableId);
		doc.appendChild(beans);
		var rows = Dom.selectSingleNode($(tableId),"tbody","className","tableBody").rows;
		for(var i=0;i<rows.length;i++){
			var bean = doc.createElement("row");
			var logicFields=LogicForm.getLogicFields(rows[i]);
			for(k in logicFields){
				bean.setAttribute(logicFields[k].name,logicFields[k].getValue());
			}
			beans.appendChild(bean);
		}
		f.value = beans.ownerDocument.xml;
	}
}

var SniperDialog={
	getDialogParam:function(){
		if(screen && screen.availWidth>1000) return	"dialogHeight:640px;dialogWidth:820px;resizable:yes;scroll:no;status:no;help:no;";
		else return	"dialogHeight:529px;dialogWidth:660px;resizable:yes;scroll:no;status:no;help:no;";
	},
	list:function(o,param,form,handlers){
		var logicForm = LogicForm.getSelectorForm(o); form=form||logicForm; form=[form,handlers,document];
		var action = "/selector.do?selectorURL="+encodeURIComponent(o.getAttribute("action"))+(o.getAttribute("multiple")?"&mult=1":"");
		try{window.showModalDialog(action,form,param || this.getDialogParam());}catch(e){window.alert(DIALOG_BLOCKED);}
	},
	tree:function(o,param,form,handlers){
		var logicForm = LogicForm.getSelectorForm(o); form=form||logicForm; form=[form,handlers,document];
		var action = "/treeSelector.do?selectorURL="+encodeURIComponent(o.getAttribute("action"))+(o.getAttribute("multiple")?"&mult=1":"");
		try{window.showModalDialog(action,form,param || this.getDialogParam());}catch(e){window.alert(DIALOG_BLOCKED);}
	},
	doChoose:function(input){
		var map=Dom.copyAttributes(input,"*","_"); parent.SelectorDialog.doSelect(map);
	},
	show: function(o,param,form,handlers){
		var logicForm = LogicForm.getSelectorForm(o); form=form||logicForm; form=[form,handlers,document];
		var action = "/commonDialog.do?selectorURL="+encodeURIComponent(o.getAttribute("action")+'&tstmp=' + new Date().getTime());
		try{window.showModalDialog(action,form,param || this.getDialogParam());}catch(e){window.alert(DIALOG_BLOCKED);}
	}
}

var TextBox={focus:function(o){}, blur:function(o){}}

var TextArea = {
	initFields:function(rect){
		rect = rect.tagName?rect:document;
		var compare = function(field){return field.getAttribute("maxlength");};
		var textAreas = Dom.selectNodes(rect,"TEXTAREA","maxlength", compare);
		for(var i=0;i<textAreas.length;i++){ TextArea.initField(textAreas[i]); }
	},
	initField:function(o){
		var mon;
		if(o.nextSibling && o.nextSibling.id=="maxLengthSpan"){ mon=o.nextSibling;
		}else{ mon=document.createElement("SPAN"); mon.setAttribute("id","maxLengthSpan"); }
		o.insertAdjacentElement("afterEnd",mon);
		var v = o.value, l = o.getAttribute("maxlength"); mon.innerHTML = v.length + "/" + l;
		var func = function(){ var v = o.value, l = o.getAttribute("maxlength");
			if(v.length>l) o.value = v.substr(0,l); mon.innerHTML = o.value.length + "/" + l;
		}
		o.attachEvent("onkeyup", func);	o.attachEvent("onchange", func);
	}
}
var SniperFCK={
	resetForm:function(form){
		var A=form.getAttribute("confirmReset")||"要重置表单吗？";if(A)A=A.replace(/\\r/g, "\r");if(A && !window.confirm(A))return false;
		var B=FCKeditorAPI.__Instances;for(var C in B){var field = Dom.selectSingleNode(form,"*","id",C);B[C].SetHTML(field.value);}return true;
	}
}
function fixLoader(){if(!top.$)return;var vf=top.$("voidFrame"); if(vf) vf.contentWindow.location.reload();}

var Layer={
	getLayer:function(){
		return this._layer||(this._layer=function(){ 
			return document.body.appendChild(document.createElement(
					'<span id="sniperLayer"style="position: absolute; z-index: 5; border: 1px solid gray;' 
				+ 'background-color: #FFFFFF; background-image: url(\'/styles/site/body.gif\'); background-repeat: repeat-x;'
				+ 'background-position: left top;padding: 5px; display: none;"></span>'))}());
	},
	hide:function(){
		var layer=this.getLayer();layer.style.display='none';Page.unMask();try{Layer.button.focus()}catch(e){};return layer;
	},
	show:function(m){
		var button=m.button,body=document.body,layer=Layer.getLayer();
		var cave={left:body.scrollLeft, top:body.scrollTop,width:body.offsetWidth,height:body.offsetHeight}
		var rect={
			width:m.width||parseInt(cave.width*.6),height:m.height||20,	display:'block',
			left:m.left||(parseInt(cave.left)+parseInt(cave.width*.2)),top:m.top||(parseInt(cave.top)+parseInt(cave.height*.2))
		}
		Page.mask('',false,2);Object.extend(layer.style,rect);
		layer.innerHTML=m.source||'<img src="/styles/site/wait.gif" align="absmiddle"/> 加载中，请稍候..';
		if(m.url)Layer.update(m);try{Layer.button=button;button.blur()}catch(e){};
		return layer;
	},
	update:function(m){
		var layer=Layer.getLayer();
		new Ajax.Updater(layer, m.url,{
			method     : 'post', 
			parameters : m.pars||'', 
			onFailure  : function(){window.alert('数据传输异常，请稍后重试。');Layer.hide();},
			onLoading  : function(){},
			onComplete : m.onComplete
		});
	},
	hint:function(m){
		var btn=m.button,p=Position.cumulativeOffset(btn); Object.extend(m,{left:p[0],top:p[1]+btn.offsetHeight}); Layer.show(m);
	},
	keydownHandler:function(event){if(event.keyCode==27)Layer.hide();}
}

function Mask(o){
	var p=Position.cumulativeOffset(o),m=this.layer=document.createElement('IFRAME');
	var cssText='position:absolute;z-index:2;border:none;filter:alpha(opacity=5);left:{0}px;top:{1}px;width:{2}px;height:{3}px;';
	var resize=function(){m.style.cssText=cssText.format(p[0],p[1],o.offsetWidth,o.offsetHeight)};
	document.body.appendChild(m); resize(); window.attachEvent('onresize',resize);m.focus();
	var doc= m.contentWindow.document;doc.open();doc.write('<body style="background-color:#FFFFFF;border:none;"></body>');doc.close();
	var cleanMe=function(){m=null;window.detachEvent('onresize',resize);window.detachEvent('onunload',cleanMe)};window.attachEvent('onunload',cleanMe);
	this.show=function(){m.style.display=''};
	this.hide=function(){m.style.display='none'};
}

function layMines(){for(var i=0;i<arguments.length;i++){window.attachEvent('onload',arguments[i]);}}
layMines(TextArea.initFields,Page.initPage,LogicForm.openMonitor,fixLoader);
