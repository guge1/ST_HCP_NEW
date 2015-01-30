function Ajax(option)
{  
	option={
		//http请求类型
		type:option.type||"post",
		//请求的URL
		url:option.url||"",
		//请求超时的时间
		timeout:option.timeout||5000,
		//请求失败 成功或完成时调用的函数
		onSucess:option.onSucess||function(httpData){},
		onError:option.onError||function(){alert(xml.status);alert(xml.responseText)},
		onComplete:option.onComplete||function(){},
		//服务器返回的数据类型,并做相应动作
		data:option.data||""
	}
	
	//创建xmlhttp对象
	function getXmlHttp()
	{
		var xmlhttp=null;
		if (window.XMLHttpRequest)
		{// code for all new browsers
			xmlhttp=new XMLHttpRequest();
		}
	    else if (window.ActiveXObject)
		{// code for IE5 and IE6
			xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
		}
		return xmlhttp;
	}
	
	var xml=getXmlHttp();
	xml.open(option.type,option.url,true);
	//xml.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
	var timeoutLength=option.timeout;
	var requestDone=false;
	//如果超时的话取消请求
	window.setTimeout(function(){requestDone=true;},timeoutLength);
	xml.onreadystatechange=function()
	{
		window.status=xml.readyState;
		if(xml.readyState==4)
		{
			//判断请求是否成功
			if(httpSucess(xml)&&!requestDone)
			{
				//以服务器返回的数据位参数调用成功回调函数
				option.onSucess(httpData(xml,option.data))
			}
			//否则就发生错误调用错误回调函数
			else
			{
				option.onError();
			}	
			//调用完成回调函数
			option.onComplete();
			
			//清理文档防止内存泄露
			xml=null;
		}
	}
	
	//建立连接并发送数据
	xml.send();
	
	
	//检测是否成功
	function httpSucess(r)
	{
		try
		{
			var sucess=(!r.status&&window.location.protocol=="file:")
			sucess=sucess||(r.status>=200&&r.status<300);	
			sucess=sucess||(r.status==304);
			sucess=sucess||(window.navigator.userAgent.indexOf("Safari")>=0&&typeof(r.status)=="undefined");
			return sucess;
		}
		catch(e)
		{	
		  alert("检测成功发生异常！");
		}
		return sucess;	
	}
	
	//获取http数据
	function httpData(r,type)
	{
		var ct=r.getResponseHeader("content-type");
		//若没有提供默认的数据类型 检测相应的是不是xml类型的
		var data=!type&&ct&&ct.indexOf("xml")>0;
		data=(type=="xml"||data)?r.responseXML:r.responseText;
		if(type=="script")
		{
			eval.call(window,data);
		}
		return data;
	}
	
	//串行化字符串
	function serialize(a)
	{
		var s=new Array();
		if(a.constructor==Array)
		{
			for(var i=0;i<a.length;i++)
			{
				s.push(a[i].name+"="+encodeURIComponent(a[i].value));
			}
		}else
		{
			for(var p in a)
			{
				s.push(p+"="+encodeURIComponent(a[p]));
			}
		}
		
		return s.join("&");
		
	}
	
}

	//串行化字符串
	function serialize(a)
	{
		var s=new Array();
		if(a.constructor==Array)
		{
			for(var i=0;i<a.length;i++)
			{
				s.push(a[i].name+"="+encodeURIComponent(a[i].value));
			}
		}else
		{
			for(var p in a)
			{
				s.push(p+"="+encodeURIComponent(a[p]));
			}
		}
		
		return s.join("&");
		
	}