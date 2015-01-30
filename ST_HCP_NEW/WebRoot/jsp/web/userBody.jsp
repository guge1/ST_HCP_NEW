<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String strPrjName = "/ST_HCP_NEW";
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName();
	if (!"".equals(request.getServerPort())) {
		basePath += ":" + request.getServerPort();
	}
	if (strPrjName.equals(path)) {
		basePath += path + "/";
	} else {
		basePath += "/";
	}
%>
<html>
	<head>
		<base target="_self" />
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />

		<script language="javascript" type="text/javascript"
			src="<%=basePath%>jsp/Market/js/WinOpen.js">
</script>
		<link
			href="<%=request.getContextPath()%>/jsp/style_dark/styleform.css"
			rel="stylesheet" type="text/css" />
		<link
			href="<%=request.getContextPath()%>/jsp/style_dark/StyleSheet.css"
			rel="stylesheet" type="text/css" />


		<link href="<%=basePath%>jsp/web/web-HTML/style/base.css"
			rel="stylesheet" type="text/css" />
		<script type="text/javascript"
			src="<%=basePath%>jsp/web/web-HTML/Scripts/jquery-1.3.2.min.js"></script>
		<script type="text/javascript"
			src="<%=basePath%>jsp/web/web-HTML/Scripts/jquery.pngFix.pack.js"></script>
		<script type="text/javascript">
			$(document).ready(function(){
				 
				//$("#mask").fadeTo("slow", 0.3);
				//$("#cbox").show();
				 //$("#cbox").animate({"top": "-=890px"}, 2000,function() {$("#mask" ).fadeIn(1000)});
				 
			});
			
			function show_NeiFenMiKe()
			{
			 document.getElementById("neiFenMi_title").style.display="";
			    
			 document.getElementById("xinNeiKe_title").style.display="none";
			 document.getElementById("shengNeiKe_title").style.display="none";
			 document.getElementById("neiFenMi").className="neiFenMi";
			 $("#neiFenMi").show();
			// $("#backGroup").hide();
			}
			
			function show_XinNeiKe()
			{
				    
				    
			 
			 document.getElementById("neiFenMi_title").style.display="none";
			 document.getElementById("shengNeiKe_title").style.display="none";
				    
				    
			 document.getElementById("xinNeiKe_title").style.display="";
				 document.getElementById("neiFenMi").className="xinNeiKe";
				
				 $("#xinNeiKe").show();
			// $("#backGroup").hide();
			}
			
			
			
			function show_ShengNeiKe()
			{
				 
			     document.getElementById("neiFenMi_title").style.display="none";
				 document.getElementById("xinNeiKe_title").style.display="none";
				 document.getElementById("shengNeiKe_title").style.display="";   
				 document.getElementById("neiFenMi").className="shengNeiKe";
				
				 $("#xinNeiKe").show();
			// $("#backGroup").hide();
			}
			
			function closeAll()
			{
				 
			     document.getElementById("neiFenMi_title").style.display="none";
				 document.getElementById("xinNeiKe_title").style.display="none";
				 document.getElementById("shengNeiKe_title").style.display="none";   
				 document.getElementById("neiFenMi").className="defaut";
				 
			}
		</script>
		<style type="text/css">
.divInfo {
	text-align: left;
	margin-left: 110px;
	color: #81402e;
}

.myTable  tr {
	height: 14px;
	line-height: 14px;
}
</style>
	</head>
	<body style="margin: 0px; padding: 0px; width: 100%;">

		<div style="text-align: center; width: 100%; background: #FFFFFF;">
		 
<div
				style="border:1px solid #F8C069;padding:auto;margin:0px auto;width:981px;text-align:center;height: expression(document.body.clientHeight);overflow: auto;overflow-x:hidden;margin:auto;">

		   <table  width="200px" border="0" cellspacing="0" cellpadding="0" style="height:30px;">
			
					<tr  >
					<td width="*" ></td>
						<td  width="200px"   style="text-align: center;width:200px">
							<input type="button" value="下月销售预估" onclick="javascript:window.location.href='<%=basePath%>queryYue_YuCe.action';"
									class="pt_Long_button"  />
										<!--<input type="button" value="全部关闭" onclick="javascript:closeAll()"
									class="pt_Long_button"  />
						--></td>
					<td  width="*" ></td>
					</tr>
			
			</table>
				<div class="main">
					<!--头部内容开始 -->  
					
        <div class="defaut" id="backGroup"  style="border:0px solid red  ;padding-top:0px;margin-top:0px;border:solid #ffb15e 2px; height:748px;display:none; "  >
           <div  id="neiFenMi_content"  onclick="changeClass()"
					  
					   style="  position:fixed;float:left;border:1px solid red  ;top:1px; margin-top:520px;margin-left:480px; width:200px;height:100px;"></div>
				
						</div>
        </div>
					
					
					
        <div class="defaut" id="neiFenMi"  style="border:0px solid red  ;padding-top:0px;margin-top:0px;border:solid #ffb15e 2px; height:748px; "  >
					 
					 
						       <div  id="shengNeiKe_content"  onclick="show_ShengNeiKe()" onmousemove="show_ShengNeiKe()"
					  
					               style="  position:absolute;top:1px; margin-top:280px;margin-left:-260px; width:400px;height:250px;"></div>
				
					   <div  id="neiFenMi_content"  onclick="show_NeiFenMiKe()"  onmousemove="show_NeiFenMiKe()"
					  
					               style="  position:absolute;top:1px; margin-top:520px;margin-left:-0px; width:200px;height:100px;"></div>
				
						    
						       <div  id="xinNeiKe_content"  onclick="show_XinNeiKe()" onmousemove="show_XinNeiKe()"
					  
					               style="  position:absolute;top:1px; margin-top:380px;margin-left:150px; width:220px;height:140px;">
					               </div>
				
						      
						     </div>
						     
						      <div id="neiFenMi_title" class="neiFenMi_title"
						       style="  position:absolute;top:1px; margin-top:200px;margin-left:-160px; width:320px;height:334px;">
						         
						          
								<div class="picbox" style="padding-top:84px;padding-left:30px;">
									<ul  onclick="javascript:g_OpenModalReturnWindow('<%=basePath%>getMarketInfo.action?PKID=10010&userName=陈老师',810,460);"   style=" ">
										<li>
											<div  style="background: url(<%=basePath%>jsp/web/images/cheng.jpg) 0px 0px ;width:60px;
													height:60px ;line-height:60px ;" >
													
											</div>
											<div style="margin-top:-15px;margin-right:0px;text-align:center;">
											 陈老师
											</div>
										</li>
										
									 
										
									</ul>
									<ul  onclick="javascript:g_OpenModalReturnWindow('<%=basePath%>getMarketInfo.action?PKID=10003&userName=孙老师',810,460);"   style=" ">
										<li>
											<div  style="background: url(<%=basePath%>jsp/web/images/sun.jpg) 0px 0px ;width:60px;
													height:60px ;line-height:60px ;" >
											</div><div style="margin-top:-15px;margin-right:0px;text-align:center;">
											 孙老师
											 
											</div>
										</li> 
									</ul>
									
									
									<ul  onclick="javascript:g_OpenModalReturnWindow('<%=basePath%>getMarketInfo.action?PKID=10004&userName=李老师',810,460);"   style=" ">
										<li>
											<div  style="background: url(<%=basePath%>jsp/web/images/li.jpg) 0px 0px ;width:60px;
													height:60px ;line-height:60px ;" >
											</div><div style="margin-top:-15px;margin-right:0px;text-align:center;">
											 李老师
											 
											</div>
										</li> 
									</ul>
									
									
									<!--<ul  onclick="javascript:g_OpenModalReturnWindow('<%=basePath%>getMarketInfo.action?PKID=10011&userName=楚老师',810,460);"   style=" ">
										<li>
											<div  style="background: url(<%=basePath%>jsp/web/images/chu.jpg) 0px 0px ;width:60px;
													height:60px ;line-height:60px ;" >
												 
											</div>
											
											<div style="margin-top:-0px;margin-right:0px;text-align:center;">
											 楚老师
											 
											</div>
										</li>
										 
									</ul>
									

								--></div>

							</div> 
						    
					 
					    <div id="xinNeiKe_title" class="xinNeiKe_title"  
						       style="  position:absolute;top:1px; margin-top:150px;margin-left:-60px; width:320px;height:334px;">
						         
						          
								<div class="picbox" style="padding-top:72px;padding-left:30px;">
								
								 
									<ul  onclick="javascript:g_OpenModalReturnWindow('<%=basePath%>getMarketInfo.action?PKID=10012&userName=魏老师',810,460);"   style=" ">
										<li>
											<div  style="background: url(<%=basePath%>jsp/web/images/wei.jpg) 0px 0px ;width:80px;
													height:70px ;line-height:70px ;" >
											</div>
											
											<div style="margin-top:-0px;margin-right:0px;text-align:center;">
											 魏老师
											 
											</div>
										</li> 
									</ul>
									
								</div>

							</div>
							
					    <div id="shengNeiKe_title" class="shengNeiKe_title"  
						       style="  position:absolute;top:1px; margin-top:30px;margin-left:-340px; width:357px;height:364px;">
						         
						          
								<div class="picbox" style="padding-top:94px;padding-left:33px;">
									 <ul    onclick="javascript:g_OpenModalReturnWindow('<%=basePath%>getMarketInfo.action?PKID=10006&userName=吴老师',810,460);"   style=" ">
										<li>
											<div  style="background: url(<%=basePath%>jsp/web/images/wu.jpg) 0px 0px ;width:70px;
													height:60px ;line-height:60px ;" >
											</div>
											<div style="margin-top:-15px;margin-right:-15px;text-align:center;">
											 吴老师
											 
											</div>
										</li> 
									</ul>
									
										<ul style="margin-left:-15px;"  onclick="javascript:g_OpenModalReturnWindow('<%=basePath%>getMarketInfo.action?PKID=10001&userName=赵老师',810,460);"   style=" ">
										<li > 
											<div  style="background: url(<%=basePath%>jsp/web/images/zhao.jpg) 0px 0px ;width:70px;
													height:60px ;line-height:60px ;" >
											</div><div style="margin-top:-15px;margin-right:-15px;text-align:center;">
											 赵老师
											 
											</div>
										</li> 
									</ul>
									<ul style="margin-left:-15px;"   onclick="javascript:g_OpenModalReturnWindow('<%=basePath%>getMarketInfo.action?PKID=10002&userName=钱老师',810,460);"   style=" ">
									
										<li>
											<div  style="background: url(<%=basePath%>jsp/web/images/qian.jpg) 0px 0px ;width:60px;
													height:60px ;line-height:60px ;" >
											</div><div style="margin-top:-15px;margin-right:-15px;text-align:center;">
											 钱老师
											 
											</div>
										</li> 
									</ul>
									<ul style="margin-left:-15px;"   onclick="javascript:g_OpenModalReturnWindow('<%=basePath%>getMarketInfo.action?PKID=10011&userName=楚老师',810,460);"   style=" ">
										<li>
											<div  style="background: url(<%=basePath%>jsp/web/images/chu.jpg) 0px 0px ;width:60px;
													height:60px ;line-height:60px ;" >
												 
											</div>
											
											<div style="margin-top:-15px;margin-right:-15px;text-align:center;">
											 楚老师
											 
											</div>
										</li>
										 
									</ul>
									<ul onclick="javascript:g_OpenModalReturnWindow('<%=basePath%>getMarketInfo.action?PKID=10005&userName=周老师',810,460);"   style=" ">
										<li >
											<div  style="background: url(<%=basePath%>jsp/web/images/zhou.jpg) 0px 0px ;width:60px;
													height:60px ;line-height:60px ;" >
											</div>
											<div style="margin-right:-15px;text-align:center;">
											 周老师
											 
											</div>
										</li> 
									</ul>
									
									<ul  style="margin-left:-15px;"  onclick="javascript:g_OpenModalReturnWindow('<%=basePath%>getMarketInfo.action?PKID=10007&userName=郑老师',810,460);"   style=" ">
										<li>
											<div  style="background: url(<%=basePath%>jsp/web/images/zheng.jpg) 0px 0px ;width:60px;
													height:60px ;line-height:60px ;" >
											</div>
											<div style="margin-right:-15px;text-align:center;">
											 郑老师
											 
											</div>
										</li> 
									</ul>
									<ul   style="margin-left:-15px;"   onclick="javascript:g_OpenModalReturnWindow('<%=basePath%>getMarketInfo.action?PKID=10008&userName=王老师',810,460);"   style=" ">
										<li>
											<div  style="background: url(<%=basePath%>jsp/web/images/wang.jpg) 0px 0px ;width:60px;
													height:60px ;line-height:60px ;" >
											</div>
											<div style="margin-right:-15px;text-align:center;">
											 王老师
											 
											</div>
										</li> 
									</ul>
									<ul style="margin-left:-15px;"     onclick="javascript:g_OpenModalReturnWindow('<%=basePath%>getMarketInfo.action?PKID=10009&userName=冯老师',810,460);"   style=" ">
										<li>
											<div  style="background: url(<%=basePath%>jsp/web/images/feng.jpg) 0px 0px ;width:60px;
													height:60px ;line-height:60px ;" >
											</div>
											<div style="margin-right:-15px;text-align:center;">
											 冯老师
											 
											</div>
										</li> 
									</ul>
								</div>

							</div>
						     
						     
						     </div>
					    </div>
					
					
					</div>
				 
	</body>
	<script type="text/javascript">
	closeAll();
	</script>
</html>

