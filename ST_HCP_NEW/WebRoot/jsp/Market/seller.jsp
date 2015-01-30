<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="html"%>
<%
	response.setHeader("Pragma", "No-Cache");
	response.setHeader("Cache-Control", "No-Cache");
	response.setDateHeader("Expires", 0);
	String struserName = request.getParameter("userName") == null
			? ""
			: request.getParameter("userName").toString();
	String strPKID = request.getParameter("PKID") == null
			? ""
			: request.getParameter("PKID").toString();
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
	String strTouXiang = basePath + "jsp/web/images/newtoux1.png";
	if ("10002".equals(strPKID)) {
		strTouXiang = basePath + "jsp/web/images/newtoux2.png";

	}
	if ("10003".equals(strPKID)) {
		strTouXiang = basePath + "jsp/web/images/newtoux3.png";

	}
	if ("10004".equals(strPKID)) {
		strTouXiang = basePath + "jsp/web/images/newtoux4.png";

	}
	if ("10005".equals(strPKID)) {
		strTouXiang = basePath + "jsp/web/images/newtoux5.png";

	}
	if ("10006".equals(strPKID)) {
		strTouXiang = basePath + "jsp/web/images/newtoux6.png";

	} 
%>
<html>
	<head>
		<title>医院<%=struserName%></title>
		<base target="_self">
		<META HTTP-EQUIV='pragma' CONTENT='no-cache'>
		<META HTTP-EQUIV='Cache-Control' CONTENT='no-cache, must-revalidate'>
		<META HTTP-EQUIV='expires' CONTENT='0'>
		<link rel="stylesheet" type="text/css" href="skin/css/base.css" />
		<link rel="stylesheet" type="text/css" href="skin/css/main.css" />
		<base target="_self">
		<%
			response.addHeader("Pragma", "no-cache");
			response.addHeader("Cache-Control", "no-store");
		%>

		<script language="javascript" type="text/javascript"
			src="<%=basePath%>jsp/Market/js/WinOpen.js"></script>

	</head>
	<body leftmargin="8" topmargin='8'>
		<div
			style="height: expression(document.body.clientHeight); overflow-y: auto; width: 100%;">
			<table width="620" align="center" border="0" cellpadding="3"
				cellspacing="1" bgcolor="#CBD8AC"
				style="margin-top: 8px; margin-bottom: 8px">
				<tr>
					<td background="skin/images/frame/wbg.gif" bgcolor="#EEF4EA"
						class='title' width="600">
						<span style="font-weight: bold; font-size: 16px; color: #FE8802">医生介绍</span>
					</td>
					<!--<td background="skin/images/frame/wbg.gif" bgcolor="#EEF4EA"
						class='title' width="200">
						 
					</td>
				-->
				</tr>
				<tr bgcolor="#FFFFFF">
					<td valign="top">
						<table>
							<tr>
								<td>


									<!--
									
									<p>
										<b><font color="#CC6600"><u><%=struserName%>：</u> </font>
										</b>
										<br>
									 
									</p>
									<p>
										<b><font color="#CC6600"><u>客户状况：</u> </font>
										</b>
										<br>
										&nbsp;&nbsp;
										<label id="INTRODUCE"></label>
									</p>
								 
								 
									<p>
								 
										<b><font color="#CC6600">综合状况：</font> </b>
										<br>
										&nbsp;&nbsp;
										<label id="PINGLUN"></label>
									</p>
									 
									<p>
										<b><font color="#CC6600">事件：</font> </b>
										<br>
										&nbsp;&nbsp;
										<label id="SHIJIAN"></label>
									</p>
								-->
								</td>
							</tr>
							<!--<tr>
								<td valign="top">

									<table>
										<tr>
											<td>
											<input type="hidden"  id="TOUXIANG"> 
												<div id="divTouXiang" style="background: url(<%=strTouXiang%>) no-repeat; width: 130px;height:200px;  "></div>
											</td>
											<td valign="top">
												<p>
													<b><font color="#CC6600"><%=struserName%>：</font> </b>
													<br>
													&nbsp;&nbsp;
													<label id="INTRODUCE_MY"></label>
												</p>
											</td>
										</tr>
										<tr>
											<td colspan="2">
												<p>
													<b><font color="#CC6600">整体评价：</font> </b>
													<br>
													&nbsp;&nbsp;
													<label id="WHOLE"></label>
												</p>
											</td>
										</tr>
										<tr>
											<td colspan="2">
												<p>
													<b><font color="#CC6600">代表自我评价：</font> </b>
													<br>
													&nbsp;&nbsp;
													<label id="SELF"></label>
												</p>
											</td>
										</tr>
										<tr>
											<td colspan="2">
												<p>
													<b><font color="#CC6600">目标：</font> </b>
													&nbsp;&nbsp;
													<label id="JIHUA"></label>
											 
												&nbsp;&nbsp;	<b><font color="#CC6600">需求：</font> </b>
													&nbsp;&nbsp;
													<label id="REQUIREMENT"></label>
												</p>
											</td>
										</tr>
									</table>
								</td>
							</tr>
-->
							<%
								if ("10001".equals(strPKID)) {
							%>

							<tr>
								<td valign="top">


									<p class=MsoNormal>
										<span style='mso-bookmark: _Toc320184200'><b><span
												style='font-family: 微软雅黑; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>赵老师：</span>
										</b> </span><b><span lang=EN-US><o:p></o:p> </span> </b>
									</p>

									<p class=MsoNormal>
										<span
											style='font-family: 微软雅黑; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>男，传染科主任医师，50岁，一周有三个半天的门诊。作为行政主任的他，对于科室的影响力是很大的。日常工作也很忙，经常会主持和列席一些大型学术会议。<font color="red">在抗病毒的治疗中他一直倾向于使用恩替卡韦治疗e抗原阳性的慢乙肝患者，认为其病毒抑制效果好于替比夫定。同时，在治疗慢乙肝的的时候，不光注意短期的治疗目标，也同样关注到治疗的长期目标。</font>鉴于你经常的拜访，还有一定的处方，处方量比较小。</span>
									</p>

									<table class=MsoNormalTable border=0 cellspacing=0
										cellpadding=0 width=520
										style='width: 390.0pt; margin-left: 4.65pt; border-collapse: collapse; mso-yfti-tbllook: 1184; mso-padding-alt: 0cm 5.4pt 0cm 5.4pt'>
										<tr
											style='mso-yfti-irow: 0; mso-yfti-firstrow: yes; height: 20.0pt'>
											<td width=87 nowrap
												style='width: 65.0pt; border: solid windowtext 1.0pt; mso-border-top-alt: 1.0pt; mso-border-left-alt: 1.0pt; mso-border-bottom-alt: .5pt; mso-border-right-alt: .5pt; mso-border-color-alt: windowtext; mso-border-style-alt: solid; padding: 0cm 5.4pt 0cm 5.4pt; height: 20.0pt'>
												<p class=MsoNormal>
													<span
														style='font-family: 微软雅黑; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>姓名</span>
												</p>
											</td>
											<td width=87 nowrap
												style='width: 65.0pt; border: solid windowtext 1.0pt; border-left: none; mso-border-top-alt: solid windowtext 1.0pt; mso-border-bottom-alt: solid windowtext .5pt; mso-border-right-alt: solid windowtext .5pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 20.0pt'>
												<p class=MsoNormal>
													<span
														style='font-family: 微软雅黑; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>科室</span>
												</p>
											</td>
											<td width=87 nowrap
												style='width: 65.0pt; border: solid windowtext 1.0pt; border-left: none; mso-border-top-alt: solid windowtext 1.0pt; mso-border-bottom-alt: solid windowtext .5pt; mso-border-right-alt: solid windowtext .5pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 20.0pt'>
												<p class=MsoNormal>
													<span
														style='font-family: 微软雅黑; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>职称</span>
												</p>
											</td>
											<td width=87 nowrap
												style='width: 65.0pt; border: solid windowtext 1.0pt; border-left: none; mso-border-top-alt: solid windowtext 1.0pt; mso-border-bottom-alt: solid windowtext .5pt; mso-border-right-alt: solid windowtext .5pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 20.0pt'>
												<p class=MsoNormal>
													<span
														style='font-family: 微软雅黑; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>分级</span>
												</p>
											</td>
											<td width=87 nowrap
												style='width: 65.0pt; border: solid windowtext 1.0pt; border-left: none; mso-border-top-alt: solid windowtext 1.0pt; mso-border-bottom-alt: solid windowtext .5pt; mso-border-right-alt: solid windowtext .5pt; background: #EEECE1; padding: 0cm 5.4pt 0cm 5.4pt; height: 20.0pt'>
												<p class=MsoNormal>
													<span lang=EN-US>倾向性</span>
												</p>
											</td>
											<td width=87 nowrap
												style='width: 65.0pt; border: solid windowtext 1.0pt; border-left: none; mso-border-top-alt: solid windowtext 1.0pt; mso-border-bottom-alt: solid windowtext .5pt; mso-border-right-alt: solid windowtext 1.0pt; background: #EEECE1; padding: 0cm 5.4pt 0cm 5.4pt; height: 20.0pt'>
												<p class=MsoNormal>
													<span lang=EN-US>潜力</span>
												</p>
											</td>
									 
										</tr>
										<tr
											style='mso-yfti-irow: 1; mso-yfti-lastrow: yes; height: 20.0pt'>
											<td width=87 nowrap valign=bottom
												style='width: 65.0pt; border: solid windowtext 1.0pt; border-top: none; mso-border-left-alt: solid windowtext 1.0pt; mso-border-bottom-alt: solid windowtext 1.0pt; mso-border-right-alt: solid windowtext .5pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 20.0pt'>
												<p class=MsoNormal>
													<span
														style='font-family: 微软雅黑; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>赵老师</span>
												</p>
											</td>
											<td width=87 nowrap
												style='width: 65.0pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; mso-border-bottom-alt: solid windowtext 1.0pt; mso-border-right-alt: solid windowtext .5pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 20.0pt'>
												<p class=MsoNormal>
													<span
														style='font-family: 微软雅黑; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>传染科</span>
												</p>
											</td>
											<td width=87 nowrap
												style='width: 65.0pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; mso-border-bottom-alt: solid windowtext 1.0pt; mso-border-right-alt: solid windowtext .5pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 20.0pt'>
												<p class=MsoNormal>
													<span
														style='font-family: 微软雅黑; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>主任医生</span>
												</p>
											</td>
											<td width=87 nowrap
												style='width: 65.0pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; mso-border-bottom-alt: solid windowtext 1.0pt; mso-border-right-alt: solid windowtext .5pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 20.0pt'>
												<p class=MsoNormal>
													<span lang=EN-US>T1</span>
												</p>
											</td>
											<td width=87 nowrap
												style='width: 65.0pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; mso-border-bottom-alt: solid windowtext 1.0pt; mso-border-right-alt: solid windowtext .5pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 20.0pt'>
												<p class=MsoNormal>
													<span lang=EN-US>0.07</span>
												</p>
											</td>
											<td width=87 nowrap
												style='width: 65.0pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 20.0pt'>
												<p class=MsoNormal>
													<span lang=EN-US>188.4</span>
												</p>
											</td>
										 
											 
										</tr>
									</table>

									<p class=MsoNormal>
										<span
											style='font-family: 微软雅黑; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>（注：表格中Potential为潜力值计算方式请参考诺华的定义；Propensity为倾向性表示每百名患者中处方我产品的人数比例）</span>
									</p>

								</td>
							</tr>


							<%
								}
							%>

							<%
								if ("10002".equals(strPKID)) {
							%>

							<tr>
								<td valign="top">

									<p class=MsoNormal>
										<a name="_Toc320184201"><b><span
												style='font-family: 微软雅黑; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>钱老师</span>
										</b>
										</a><span style='mso-bookmark: _Toc320184201'></span><span
											style='font-family: 微软雅黑; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>：</span>
									</p>

									<p class=MsoNormal>
										<span
											style='font-family: 微软雅黑; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>女， 传染科副主任医师，45岁，门诊量很大，一周有三天半门诊。她的临床经验非常丰富，对专业非常用心，虽然经常参加各种学术活动，对新的知识和治疗进展很感兴趣，也会做治疗尝试，一旦认同就会应用。在使用抗病毒治疗方案时，<font color="red">她非常认同高血清学转换以及高病毒抑制的治疗观念，特别是双达标对于长期治疗目标的影响。</font>  所以，一直也在处方我们的产品。但是，她一直也在尝试其他产品。钱老师为人亲切，很多厂家的代表都愿意拜访她。</span>
									</p>

									<table class=MsoNormalTable border=0 cellspacing=0
										cellpadding=0 width=520
										style='width: 390.0pt; margin-left: 4.65pt; border-collapse: collapse; mso-yfti-tbllook: 1184; mso-padding-alt: 0cm 5.4pt 0cm 5.4pt'>
										<tr
											style='mso-yfti-irow: 0; mso-yfti-firstrow: yes; height: 15.0pt'>
											<td width=87 nowrap
												style='width: 65.0pt; border: solid windowtext 1.0pt; mso-border-top-alt: 1.0pt; mso-border-left-alt: 1.0pt; mso-border-bottom-alt: .5pt; mso-border-right-alt: .5pt; mso-border-color-alt: windowtext; mso-border-style-alt: solid; padding: 0cm 5.4pt 0cm 5.4pt; height: 15.0pt'>
												<p class=MsoNormal>
													<span
														style='font-family: 微软雅黑; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>姓名</span>
												</p>
											</td>
											<td width=87 nowrap
												style='width: 65.0pt; border: solid windowtext 1.0pt; border-left: none; mso-border-top-alt: solid windowtext 1.0pt; mso-border-bottom-alt: solid windowtext .5pt; mso-border-right-alt: solid windowtext .5pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 15.0pt'>
												<p class=MsoNormal>
													<span
														style='font-family: 微软雅黑; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>科室</span>
												</p>
											</td>
											<td width=87 nowrap
												style='width: 65.0pt; border: solid windowtext 1.0pt; border-left: none; mso-border-top-alt: solid windowtext 1.0pt; mso-border-bottom-alt: solid windowtext .5pt; mso-border-right-alt: solid windowtext .5pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 15.0pt'>
												<p class=MsoNormal>
													<span
														style='font-family: 微软雅黑; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>职称</span>
												</p>
											</td>
											<td width=87 nowrap
												style='width: 65.0pt; border: solid windowtext 1.0pt; border-left: none; mso-border-top-alt: solid windowtext 1.0pt; mso-border-bottom-alt: solid windowtext .5pt; mso-border-right-alt: solid windowtext .5pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 15.0pt'>
												<p class=MsoNormal>
													<span
														style='font-family: 微软雅黑; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>分级</span>
												</p>
											</td>
											<td width=87 nowrap
												style='width: 65.0pt; border: solid windowtext 1.0pt; border-left: none; mso-border-top-alt: solid windowtext 1.0pt; mso-border-bottom-alt: solid windowtext .5pt; mso-border-right-alt: solid windowtext .5pt; background: #EEECE1; padding: 0cm 5.4pt 0cm 5.4pt; height: 15.0pt'>
												<p class=MsoNormal>
													<span lang=EN-US>倾向性</span>
												</p>
											</td>
											<td width=87 nowrap
												style='width: 65.0pt; border: solid windowtext 1.0pt; border-left: none; mso-border-top-alt: solid windowtext 1.0pt; mso-border-bottom-alt: solid windowtext .5pt; mso-border-right-alt: solid windowtext 1.0pt; background: #EEECE1; padding: 0cm 5.4pt 0cm 5.4pt; height: 15.0pt'>
												<p class=MsoNormal>
													<span lang=EN-US>潜力</span>
												</p>
											</td>
											 
											 
										</tr>
										<tr
											style='mso-yfti-irow: 1; mso-yfti-lastrow: yes; height: 16.0pt'>
											<td width=87 nowrap
												style='width: 65.0pt; border: solid windowtext 1.0pt; border-top: none; mso-border-left-alt: solid windowtext 1.0pt; mso-border-bottom-alt: solid windowtext 1.0pt; mso-border-right-alt: solid windowtext .5pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 16.0pt'>
												<p class=MsoNormal>
													<span
														style='font-family: 微软雅黑; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>钱老师</span>
												</p>
											</td>
											<td width=87 nowrap
												style='width: 65.0pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; mso-border-bottom-alt: solid windowtext 1.0pt; mso-border-right-alt: solid windowtext .5pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 16.0pt'>
												<p class=MsoNormal>
													<span
														style='font-family: 微软雅黑; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>传染科</span>
												</p>
											</td>
											<td width=87 nowrap
												style='width: 65.0pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; mso-border-bottom-alt: solid windowtext 1.0pt; mso-border-right-alt: solid windowtext .5pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 16.0pt'>
												<p class=MsoNormal>
													<span
														style='font-family: 微软雅黑; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>副主任医生</span>
												</p>
											</td>
											<td width=87 nowrap
												style='width: 65.0pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; mso-border-bottom-alt: solid windowtext 1.0pt; mso-border-right-alt: solid windowtext .5pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 16.0pt'>
												<p class=MsoNormal>
													<span lang=EN-US>T1</span>
												</p>
											</td>
											<td width=87 nowrap
												style='width: 65.0pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; mso-border-bottom-alt: solid windowtext 1.0pt; mso-border-right-alt: solid windowtext .5pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 16.0pt'>
												<p class=MsoNormal>
													<span lang=EN-US>0.1</span>
												</p>
											</td>
											<td width=87 nowrap
												style='width: 65.0pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 16.0pt'>
												<p class=MsoNormal>
													<span lang=EN-US>388.8</span>
												</p>
											</td>
											 
											 
										</tr>
									</table>

								</td>
							</tr>

							<%
								}
							%>


							<%
								if ("10003".equals(strPKID)) {
							%>

							<tr>
								<td valign="top">

									<p class=MsoNormal>
										<a name="_Toc320184202"><b><span
												style='font-family: 微软雅黑; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>孙老师</span>
										</b>
										</a><span style='mso-bookmark: _Toc320184202'></span><span
											style='font-family: 微软雅黑; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>：</span>
									</p>

									<p class=MsoNormal>
										<span
											style='font-family: 微软雅黑; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>女，传染科主任医生，49岁。她有着相对固定的病人群，在病房和门诊都是中坚力量。非常愿意和别人分享她的的用药经验，所以科里的年轻医生愿意和她交流。<font color="red">她对e抗原阳性患者的采用抗病毒治疗时，喜欢使用替比夫定类的核苷类似物治疗，并且对我们的产品是比较信赖的。所以，在治疗中她的大部分患者都会使用我们的产品。</font></span>
									</p>

									<table class=MsoNormalTable border=0 cellspacing=0
										cellpadding=0 width=520
										style='width: 390.0pt; margin-left: 4.65pt; border-collapse: collapse; mso-yfti-tbllook: 1184; mso-padding-alt: 0cm 5.4pt 0cm 5.4pt'>
										<tr
											style='mso-yfti-irow: 0; mso-yfti-firstrow: yes; height: 20.0pt'>
											<td width=87 nowrap
												style='width: 65.0pt; border: solid windowtext 1.0pt; mso-border-top-alt: 1.0pt; mso-border-left-alt: 1.0pt; mso-border-bottom-alt: .5pt; mso-border-right-alt: .5pt; mso-border-color-alt: windowtext; mso-border-style-alt: solid; padding: 0cm 5.4pt 0cm 5.4pt; height: 20.0pt'>
												<p class=MsoNormal>
													<span
														style='font-family: 微软雅黑; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>姓名</span>
												</p>
											</td>
											<td width=87 nowrap
												style='width: 65.0pt; border: solid windowtext 1.0pt; border-left: none; mso-border-top-alt: solid windowtext 1.0pt; mso-border-bottom-alt: solid windowtext .5pt; mso-border-right-alt: solid windowtext .5pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 20.0pt'>
												<p class=MsoNormal>
													<span
														style='font-family: 微软雅黑; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>科室</span>
												</p>
											</td>
											<td width=87 nowrap
												style='width: 65.0pt; border: solid windowtext 1.0pt; border-left: none; mso-border-top-alt: solid windowtext 1.0pt; mso-border-bottom-alt: solid windowtext .5pt; mso-border-right-alt: solid windowtext .5pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 20.0pt'>
												<p class=MsoNormal>
													<span
														style='font-family: 微软雅黑; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>职称</span>
												</p>
											</td>
											<td width=87 nowrap
												style='width: 65.0pt; border: solid windowtext 1.0pt; border-left: none; mso-border-top-alt: solid windowtext 1.0pt; mso-border-bottom-alt: solid windowtext .5pt; mso-border-right-alt: solid windowtext .5pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 20.0pt'>
												<p class=MsoNormal>
													<span
														style='font-family: 微软雅黑; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>分级</span>
												</p>
											</td>
											<td width=87 nowrap
												style='width: 65.0pt; border: solid windowtext 1.0pt; border-left: none; mso-border-top-alt: solid windowtext 1.0pt; mso-border-bottom-alt: solid windowtext .5pt; mso-border-right-alt: solid windowtext .5pt; background: #EEECE1; padding: 0cm 5.4pt 0cm 5.4pt; height: 20.0pt'>
												<p class=MsoNormal>
													<span lang=EN-US>倾向性</span>
												</p>
											</td>
											<td width=87 nowrap
												style='width: 65.0pt; border: solid windowtext 1.0pt; border-left: none; mso-border-top-alt: solid windowtext 1.0pt; mso-border-bottom-alt: solid windowtext .5pt; mso-border-right-alt: solid windowtext 1.0pt; background: #EEECE1; padding: 0cm 5.4pt 0cm 5.4pt; height: 20.0pt'>
												<p class=MsoNormal>
													<span lang=EN-US>潜力</span>
												</p>
											</td>
											 
											 
										</tr>
										<tr
											style='mso-yfti-irow: 1; mso-yfti-lastrow: yes; height: 20.0pt'>
											<td width=87 nowrap
												style='width: 65.0pt; border: solid windowtext 1.0pt; border-top: none; mso-border-left-alt: solid windowtext 1.0pt; mso-border-bottom-alt: solid windowtext 1.0pt; mso-border-right-alt: solid windowtext .5pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 20.0pt'>
												<p class=MsoNormal>
													<span
														style='font-family: 微软雅黑; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>孙老师</span>
												</p>
											</td>
											<td width=87 nowrap
												style='width: 65.0pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; mso-border-bottom-alt: solid windowtext 1.0pt; mso-border-right-alt: solid windowtext .5pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 20.0pt'>
												<p class=MsoNormal>
													<span
														style='font-family: 微软雅黑; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>高干科</span>
												</p>
											</td>
											<td width=87 nowrap
												style='width: 65.0pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; mso-border-bottom-alt: solid windowtext 1.0pt; mso-border-right-alt: solid windowtext .5pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 20.0pt'>
												<p class=MsoNormal>
													<span
														style='font-family: 微软雅黑; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>主治医师</span>
												</p>
											</td>
											<td width=87 nowrap
												style='width: 65.0pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; mso-border-bottom-alt: solid windowtext 1.0pt; mso-border-right-alt: solid windowtext .5pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 20.0pt'>
												<p class=MsoNormal>
													<span lang=EN-US>ST</span>
												</p>
											</td>
											<td width=87 nowrap
												style='width: 65.0pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; mso-border-bottom-alt: solid windowtext 1.0pt; mso-border-right-alt: solid windowtext .5pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 20.0pt'>
												<p class=MsoNormal>
													<span lang=EN-US>0.5</span>
												</p>
											</td>
											<td width=87 nowrap
												style='width: 65.0pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 20.0pt'>
												<p class=MsoNormal>
													<span lang=EN-US>140.8</span>
												</p>
											</td>
											 
											 
										</tr>
									</table>

								</td>
							</tr>

							<%
								}
							%>

							<%
								if ("10004".equals(strPKID)) {
							%>

							<tr>
								<td valign="top">


									<p class=MsoNormal>
										<a name="_Toc320184203"><b><span
												style='font-family: 微软雅黑; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>李老师</span>
										</b>
										</a><span style='mso-bookmark: _Toc320184203'></span><span
											style='font-family: 微软雅黑; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>：</span>
									</p>

									<p class=MsoNormal>
										<span
											style='font-family: 微软雅黑; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>男，高干科副主任医师，55岁。他现在每周三个半天的门诊，对于学术问题不是很关心，他总是使用习惯使用的几种产品。很少参加学术会议，他觉得人太多没什么意思；也很少去尝试新的产品或治疗方法。他总是说，<font color="red">对于慢乙肝患者的治疗方案，最佳的还是使用干扰素，能够快速的降低转氨酶。他只是偶尔有病人找他开药时，他才会处方一些抗病毒的产品。</font></span>
									</p>

									<table class=MsoNormalTable border=0 cellspacing=0
										cellpadding=0 width=520
										style='width: 390.0pt; margin-left: 4.65pt; border-collapse: collapse; mso-yfti-tbllook: 1184; mso-padding-alt: 0cm 5.4pt 0cm 5.4pt'>
										<tr
											style='mso-yfti-irow: 0; mso-yfti-firstrow: yes; height: 20.0pt'>
											<td width=87 nowrap
												style='width: 65.0pt; border: solid windowtext 1.0pt; mso-border-top-alt: 1.0pt; mso-border-left-alt: 1.0pt; mso-border-bottom-alt: .5pt; mso-border-right-alt: .5pt; mso-border-color-alt: windowtext; mso-border-style-alt: solid; padding: 0cm 5.4pt 0cm 5.4pt; height: 20.0pt'>
												<p class=MsoNormal>
													<span
														style='font-family: 微软雅黑; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>姓名</span>
												</p>
											</td>
											<td width=87 nowrap
												style='width: 65.0pt; border: solid windowtext 1.0pt; border-left: none; mso-border-top-alt: solid windowtext 1.0pt; mso-border-bottom-alt: solid windowtext .5pt; mso-border-right-alt: solid windowtext .5pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 20.0pt'>
												<p class=MsoNormal>
													<span
														style='font-family: 微软雅黑; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>科室</span>
												</p>
											</td>
											<td width=87 nowrap
												style='width: 65.0pt; border: solid windowtext 1.0pt; border-left: none; mso-border-top-alt: solid windowtext 1.0pt; mso-border-bottom-alt: solid windowtext .5pt; mso-border-right-alt: solid windowtext .5pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 20.0pt'>
												<p class=MsoNormal>
													<span
														style='font-family: 微软雅黑; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>职称</span>
												</p>
											</td>
											<td width=87 nowrap
												style='width: 65.0pt; border: solid windowtext 1.0pt; border-left: none; mso-border-top-alt: solid windowtext 1.0pt; mso-border-bottom-alt: solid windowtext .5pt; mso-border-right-alt: solid windowtext .5pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 20.0pt'>
												<p class=MsoNormal>
													<span
														style='font-family: 微软雅黑; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>分级</span>
												</p>
											</td>
											<td width=87 nowrap
												style='width: 65.0pt; border: solid windowtext 1.0pt; border-left: none; mso-border-top-alt: solid windowtext 1.0pt; mso-border-bottom-alt: solid windowtext .5pt; mso-border-right-alt: solid windowtext .5pt; background: #EEECE1; padding: 0cm 5.4pt 0cm 5.4pt; height: 20.0pt'>
												<p class=MsoNormal>
													<span lang=EN-US>倾向性</span>
												</p>
											</td>
											<td width=87 nowrap
												style='width: 65.0pt; border: solid windowtext 1.0pt; border-left: none; mso-border-top-alt: solid windowtext 1.0pt; mso-border-bottom-alt: solid windowtext .5pt; mso-border-right-alt: solid windowtext 1.0pt; background: #EEECE1; padding: 0cm 5.4pt 0cm 5.4pt; height: 20.0pt'>
												<p class=MsoNormal>
													<span lang=EN-US>潜力</span>
												</p>
											</td>
											 
											 
										</tr>
										<tr
											style='mso-yfti-irow: 1; mso-yfti-lastrow: yes; height: 20.0pt'>
											<td width=87 nowrap
												style='width: 65.0pt; border: solid windowtext 1.0pt; border-top: none; mso-border-left-alt: solid windowtext 1.0pt; mso-border-bottom-alt: solid windowtext 1.0pt; mso-border-right-alt: solid windowtext .5pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 20.0pt'>
												<p class=MsoNormal>
													<span
														style='font-family: 微软雅黑; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>李老师</span>
												</p>
											</td>
											<td width=87 nowrap
												style='width: 65.0pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; mso-border-bottom-alt: solid windowtext 1.0pt; mso-border-right-alt: solid windowtext .5pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 20.0pt'>
												<p class=MsoNormal>
													<span
														style='font-family: 微软雅黑; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>高干科</span>
												</p>
											</td>
											<td width=87 nowrap
												style='width: 65.0pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; mso-border-bottom-alt: solid windowtext 1.0pt; mso-border-right-alt: solid windowtext .5pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 20.0pt'>
												<p class=MsoNormal>
													<span
														style='font-family: 微软雅黑; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>副主任医生</span>
												</p>
											</td>
											<td width=87 nowrap
												style='width: 65.0pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; mso-border-bottom-alt: solid windowtext 1.0pt; mso-border-right-alt: solid windowtext .5pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 20.0pt'>
												<p class=MsoNormal>
													<span lang=EN-US>T1</span>
												</p>
											</td>
											<td width=87 nowrap
												style='width: 65.0pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; mso-border-bottom-alt: solid windowtext 1.0pt; mso-border-right-alt: solid windowtext .5pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 20.0pt'>
												<p class=MsoNormal>
													<span lang=EN-US>0.01</span>
												</p>
											</td>
											<td width=87 nowrap
												style='width: 65.0pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 20.0pt'>
												<p class=MsoNormal>
													<span lang=EN-US>120.7</span>
												</p>
											</td>
											 
											 
										</tr>
									</table>
								</td>
							</tr>

							<%
								}
							%>

							<%
								if ("10005".equals(strPKID)) {
							%>

							<tr>
								<td valign="top">


									<p class=MsoNormal>
										<a name="_Toc320184204"><b><span
												style='font-family: 微软雅黑; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>周老师</span>
										</b>
										</a><span style='mso-bookmark: _Toc320184204'></span><span
											style='font-family: 微软雅黑; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>：</span>
									</p>

									<p class=MsoNormal>
										<span
											style='font-family: 微软雅黑; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>女，传染科主治医师，34岁。在工作之余攻读博士学位。时间对她来说一直都不够用，要照顾家里的小孩（2岁），还要做实验等等。什么时候见她都是风风火火的。<font color="red">对于疾病治疗发展，她很清楚，也非常认同对于慢乙肝的病人使用抗病毒治疗的效果。但是她几乎不使用我们的产品，原因很简单，因为竞争产品在做带金销售。她曾经很明确的表示，现在要多挣点钱，生活所迫。</font></span>
									</p>

									<table class=MsoNormalTable border=0 cellspacing=0
										cellpadding=0 width=520
										style='width: 390.0pt; margin-left: 4.65pt; border-collapse: collapse; mso-yfti-tbllook: 1184; mso-padding-alt: 0cm 5.4pt 0cm 5.4pt'>
										<tr
											style='mso-yfti-irow: 0; mso-yfti-firstrow: yes; height: 20.0pt'>
											<td width=87 nowrap
												style='width: 65.0pt; border: solid windowtext 1.0pt; mso-border-top-alt: 1.0pt; mso-border-left-alt: 1.0pt; mso-border-bottom-alt: .5pt; mso-border-right-alt: .5pt; mso-border-color-alt: windowtext; mso-border-style-alt: solid; padding: 0cm 5.4pt 0cm 5.4pt; height: 20.0pt'>
												<p class=MsoNormal>
													<span
														style='font-family: 微软雅黑; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>姓名</span>
												</p>
											</td>
											<td width=87 nowrap
												style='width: 65.0pt; border: solid windowtext 1.0pt; border-left: none; mso-border-top-alt: solid windowtext 1.0pt; mso-border-bottom-alt: solid windowtext .5pt; mso-border-right-alt: solid windowtext .5pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 20.0pt'>
												<p class=MsoNormal>
													<span
														style='font-family: 微软雅黑; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>科室</span>
												</p>
											</td>
											<td width=87 nowrap
												style='width: 65.0pt; border: solid windowtext 1.0pt; border-left: none; mso-border-top-alt: solid windowtext 1.0pt; mso-border-bottom-alt: solid windowtext .5pt; mso-border-right-alt: solid windowtext .5pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 20.0pt'>
												<p class=MsoNormal>
													<span
														style='font-family: 微软雅黑; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>职称</span>
												</p>
											</td>
											<td width=87 nowrap
												style='width: 65.0pt; border: solid windowtext 1.0pt; border-left: none; mso-border-top-alt: solid windowtext 1.0pt; mso-border-bottom-alt: solid windowtext .5pt; mso-border-right-alt: solid windowtext .5pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 20.0pt'>
												<p class=MsoNormal>
													<span
														style='font-family: 微软雅黑; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>分级</span>
												</p>
											</td>
											<td width=87 nowrap
												style='width: 65.0pt; border: solid windowtext 1.0pt; border-left: none; mso-border-top-alt: solid windowtext 1.0pt; mso-border-bottom-alt: solid windowtext .5pt; mso-border-right-alt: solid windowtext .5pt; background: #EEECE1; padding: 0cm 5.4pt 0cm 5.4pt; height: 20.0pt'>
												<p class=MsoNormal>
													<span lang=EN-US>倾向性</span>
												</p>
											</td>
											<td width=87 nowrap
												style='width: 65.0pt; border: solid windowtext 1.0pt; border-left: none; mso-border-top-alt: solid windowtext 1.0pt; mso-border-bottom-alt: solid windowtext .5pt; mso-border-right-alt: solid windowtext 1.0pt; background: #EEECE1; padding: 0cm 5.4pt 0cm 5.4pt; height: 20.0pt'>
												<p class=MsoNormal>
													<span lang=EN-US>潜力</span>
												</p>
											</td>
										 
											 
										</tr>
										<tr
											style='mso-yfti-irow: 1; mso-yfti-lastrow: yes; height: 20.0pt'>
											<td width=87 nowrap
												style='width: 65.0pt; border: solid windowtext 1.0pt; border-top: none; mso-border-left-alt: solid windowtext 1.0pt; mso-border-bottom-alt: solid windowtext 1.0pt; mso-border-right-alt: solid windowtext .5pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 20.0pt'>
												<p class=MsoNormal>
													<span
														style='font-family: 微软雅黑; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>周老师</span>
												</p>
											</td>
											<td width=87 nowrap
												style='width: 65.0pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; mso-border-bottom-alt: solid windowtext 1.0pt; mso-border-right-alt: solid windowtext .5pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 20.0pt'>
												<p class=MsoNormal>
													<span
														style='font-family: 微软雅黑; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>传染科</span>
												</p>
											</td>
											<td width=87 nowrap
												style='width: 65.0pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; mso-border-bottom-alt: solid windowtext 1.0pt; mso-border-right-alt: solid windowtext .5pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 20.0pt'>
												<p class=MsoNormal>
													<span
														style='font-family: 微软雅黑; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>主治医师</span>
												</p>
											</td>
											<td width=87 nowrap
												style='width: 65.0pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; mso-border-bottom-alt: solid windowtext 1.0pt; mso-border-right-alt: solid windowtext .5pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 20.0pt'>
												<p class=MsoNormal>
													<span lang=EN-US>T1</span>
												</p>
											</td>
											<td width=87 nowrap
												style='width: 65.0pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; mso-border-bottom-alt: solid windowtext 1.0pt; mso-border-right-alt: solid windowtext .5pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 20.0pt'>
												<p class=MsoNormal>
													<span lang=EN-US>0.1</span>
												</p>
											</td>
											<td width=87 nowrap
												style='width: 65.0pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 20.0pt'>
												<p class=MsoNormal>
													<span lang=EN-US>95.2</span>
												</p>
											</td>
											 
											 
										</tr>
									</table>

								</td>
							</tr>

							<%
								}
							%>

							<%
								if ("10006".equals(strPKID)) {
							%>

							<tr>
								<td valign="top">

									<p class=MsoNormal>
										<a name="_Toc320184205"><b><span
												style='font-family: 微软雅黑; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>吴老师</span>
										</b>
										</a><span style='mso-bookmark: _Toc320184205'></span><span
											style='font-family: 微软雅黑; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>：</span>
									</p>

									<p class=MsoNormal>
										<span
											style='font-family: 微软雅黑; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>男，传染科副主任，43岁。作为副主任医师，吴老师对专业领域是有相当的建树的。对于相关疾病的治疗进展，他也非常关心，经常会查阅资料，对你所提供的专业资料也很感兴趣。<font color="red">对于e抗原阳性的患者会处方我们的产品，对于e 抗原阴性的患者，更信任恩替卡韦。</font></span>
									</p>

									<table class=MsoNormalTable border=0 cellspacing=0
										cellpadding=0 width=520
										style='width: 390.0pt; margin-left: 4.65pt; border-collapse: collapse; mso-yfti-tbllook: 1184; mso-padding-alt: 0cm 5.4pt 0cm 5.4pt'>
										<tr
											style='mso-yfti-irow: 0; mso-yfti-firstrow: yes; height: 20.0pt'>
											<td width=87 nowrap
												style='width: 65.0pt; border: solid windowtext 1.0pt; mso-border-top-alt: 1.0pt; mso-border-left-alt: 1.0pt; mso-border-bottom-alt: .5pt; mso-border-right-alt: .5pt; mso-border-color-alt: windowtext; mso-border-style-alt: solid; padding: 0cm 5.4pt 0cm 5.4pt; height: 20.0pt'>
												<p class=MsoNormal>
													<span
														style='font-family: 微软雅黑; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>姓名</span>
												</p>
											</td>
											<td width=87 nowrap
												style='width: 65.0pt; border: solid windowtext 1.0pt; border-left: none; mso-border-top-alt: solid windowtext 1.0pt; mso-border-bottom-alt: solid windowtext .5pt; mso-border-right-alt: solid windowtext .5pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 20.0pt'>
												<p class=MsoNormal>
													<span
														style='font-family: 微软雅黑; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>科室</span>
												</p>
											</td>
											<td width=87 nowrap
												style='width: 65.0pt; border: solid windowtext 1.0pt; border-left: none; mso-border-top-alt: solid windowtext 1.0pt; mso-border-bottom-alt: solid windowtext .5pt; mso-border-right-alt: solid windowtext .5pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 20.0pt'>
												<p class=MsoNormal>
													<span
														style='font-family: 微软雅黑; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>职称</span>
												</p>
											</td>
											<td width=87 nowrap
												style='width: 65.0pt; border: solid windowtext 1.0pt; border-left: none; mso-border-top-alt: solid windowtext 1.0pt; mso-border-bottom-alt: solid windowtext .5pt; mso-border-right-alt: solid windowtext .5pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 20.0pt'>
												<p class=MsoNormal>
													<span
														style='font-family: 微软雅黑; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>分级</span>
												</p>
											</td>
											<td width=87 nowrap
												style='width: 65.0pt; border: solid windowtext 1.0pt; border-left: none; mso-border-top-alt: solid windowtext 1.0pt; mso-border-bottom-alt: solid windowtext .5pt; mso-border-right-alt: solid windowtext .5pt; background: #EEECE1; padding: 0cm 5.4pt 0cm 5.4pt; height: 20.0pt'>
												<p class=MsoNormal>
													<span lang=EN-US>倾向性</span>
												</p>
											</td>
											<td width=87 nowrap
												style='width: 65.0pt; border: solid windowtext 1.0pt; border-left: none; mso-border-top-alt: solid windowtext 1.0pt; mso-border-bottom-alt: solid windowtext .5pt; mso-border-right-alt: solid windowtext 1.0pt; background: #EEECE1; padding: 0cm 5.4pt 0cm 5.4pt; height: 20.0pt'>
												<p class=MsoNormal>
													<span lang=EN-US>潜力</span>
												</p>
											</td>
											 
											 
										</tr>
										<tr
											style='mso-yfti-irow: 1; mso-yfti-lastrow: yes; height: 20.0pt'>
											<td width=87 nowrap
												style='width: 65.0pt; border: solid windowtext 1.0pt; border-top: none; mso-border-left-alt: solid windowtext 1.0pt; mso-border-bottom-alt: solid windowtext 1.0pt; mso-border-right-alt: solid windowtext .5pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 20.0pt'>
												<p class=MsoNormal>
													<span
														style='font-family: 微软雅黑; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>吴老师</span>
												</p>
											</td>
											<td width=87 nowrap
												style='width: 65.0pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; mso-border-bottom-alt: solid windowtext 1.0pt; mso-border-right-alt: solid windowtext .5pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 20.0pt'>
												<p class=MsoNormal>
													<span
														style='font-family: 微软雅黑; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>传染科</span>
												</p>
											</td>
											<td width=87 nowrap
												style='width: 65.0pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; mso-border-bottom-alt: solid windowtext 1.0pt; mso-border-right-alt: solid windowtext .5pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 20.0pt'>
												<p class=MsoNormal>
													<span
														style='font-family: 微软雅黑; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>副主任医生</span>
												</p>
											</td>
											<td width=87 nowrap
												style='width: 65.0pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; mso-border-bottom-alt: solid windowtext 1.0pt; mso-border-right-alt: solid windowtext .5pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 20.0pt'>
												<p class=MsoNormal>
													<span lang=EN-US>T1</span>
												</p>
											</td>
											<td width=87 nowrap
												style='width: 65.0pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; mso-border-bottom-alt: solid windowtext 1.0pt; mso-border-right-alt: solid windowtext .5pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 20.0pt'>
												<p class=MsoNormal>
													<span lang=EN-US>0.15</span>
												</p>
											</td>
											<td width=87 nowrap
												style='width: 65.0pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 20.0pt'>
												<p class=MsoNormal>
													<span lang=EN-US>85</span>
												</p>
											</td>
											 
											 
										</tr>
									</table>
								</td>
							</tr>

							<%
								}
							%>

							<%
								if ("10007".equals(strPKID)) {
							%>

							<tr>
								<td valign="top">

									<p class=MsoNormal>
										<a name="_Toc320184206"><b><span
												style='font-family: 微软雅黑; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>郑老师</span>
										</b>
										</a><span style='mso-bookmark: _Toc320184206'></span><span
											style='font-family: 微软雅黑; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>：</span>
									</p>

									<p class=MsoNormal>
										<span
											style='font-family: 微软雅黑; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>男，主任医师，62岁。郑老师是传染科老主任，现在返聘在门诊工作。他对临床疾病的发展认知还是很清楚的，只是在用药上，比较关注之前的老关系。认为拉米夫定的效果还是不错的，只要用药方法恰当，是可以减少其耐药性的。</span>
									</p>

									<table class=MsoNormalTable border=0 cellspacing=0
										cellpadding=0 width=520
										style='width: 390.0pt; margin-left: 4.65pt; border-collapse: collapse; mso-yfti-tbllook: 1184; mso-padding-alt: 0cm 5.4pt 0cm 5.4pt'>
										<tr
											style='mso-yfti-irow: 0; mso-yfti-firstrow: yes; height: 20.0pt'>
											<td width=87 nowrap
												style='width: 65.0pt; border: solid windowtext 1.0pt; mso-border-top-alt: 1.0pt; mso-border-left-alt: 1.0pt; mso-border-bottom-alt: .5pt; mso-border-right-alt: .5pt; mso-border-color-alt: windowtext; mso-border-style-alt: solid; padding: 0cm 5.4pt 0cm 5.4pt; height: 20.0pt'>
												<p class=MsoNormal>
													<span
														style='font-family: 微软雅黑; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>姓名</span>
												</p>
											</td>
											<td width=87 nowrap
												style='width: 65.0pt; border: solid windowtext 1.0pt; border-left: none; mso-border-top-alt: solid windowtext 1.0pt; mso-border-bottom-alt: solid windowtext .5pt; mso-border-right-alt: solid windowtext .5pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 20.0pt'>
												<p class=MsoNormal>
													<span
														style='font-family: 微软雅黑; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>科室</span>
												</p>
											</td>
											<td width=87 nowrap
												style='width: 65.0pt; border: solid windowtext 1.0pt; border-left: none; mso-border-top-alt: solid windowtext 1.0pt; mso-border-bottom-alt: solid windowtext .5pt; mso-border-right-alt: solid windowtext .5pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 20.0pt'>
												<p class=MsoNormal>
													<span
														style='font-family: 微软雅黑; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>职称</span>
												</p>
											</td>
											<td width=87 nowrap
												style='width: 65.0pt; border: solid windowtext 1.0pt; border-left: none; mso-border-top-alt: solid windowtext 1.0pt; mso-border-bottom-alt: solid windowtext .5pt; mso-border-right-alt: solid windowtext .5pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 20.0pt'>
												<p class=MsoNormal>
													<span
														style='font-family: 微软雅黑; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>分级</span>
												</p>
											</td>
											<td width=87 nowrap
												style='width: 65.0pt; border: solid windowtext 1.0pt; border-left: none; mso-border-top-alt: solid windowtext 1.0pt; mso-border-bottom-alt: solid windowtext .5pt; mso-border-right-alt: solid windowtext .5pt; background: #EEECE1; padding: 0cm 5.4pt 0cm 5.4pt; height: 20.0pt'>
												<p class=MsoNormal>
													<span lang=EN-US>倾向性</span>
												</p>
											</td>
											<td width=87 nowrap
												style='width: 65.0pt; border: solid windowtext 1.0pt; border-left: none; mso-border-top-alt: solid windowtext 1.0pt; mso-border-bottom-alt: solid windowtext .5pt; mso-border-right-alt: solid windowtext 1.0pt; background: #EEECE1; padding: 0cm 5.4pt 0cm 5.4pt; height: 20.0pt'>
												<p class=MsoNormal>
													<span lang=EN-US>潜力</span>
												</p>
											</td>
											 
											 
										</tr>
										<tr
											style='mso-yfti-irow: 1; mso-yfti-lastrow: yes; height: 20.0pt'>
											<td width=87 nowrap
												style='width: 65.0pt; border: solid windowtext 1.0pt; border-top: none; mso-border-left-alt: solid windowtext 1.0pt; mso-border-bottom-alt: solid windowtext 1.0pt; mso-border-right-alt: solid windowtext .5pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 20.0pt'>
												<p class=MsoNormal>
													<span
														style='font-family: 微软雅黑; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>郑老师</span>
												</p>
											</td>
											<td width=87 nowrap
												style='width: 65.0pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; mso-border-bottom-alt: solid windowtext 1.0pt; mso-border-right-alt: solid windowtext .5pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 20.0pt'>
												<p class=MsoNormal>
													<span
														style='font-family: 微软雅黑; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>传染科</span>
												</p>
											</td>
											<td width=87 nowrap
												style='width: 65.0pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; mso-border-bottom-alt: solid windowtext 1.0pt; mso-border-right-alt: solid windowtext .5pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 20.0pt'>
												<p class=MsoNormal>
													<span
														style='font-family: 微软雅黑; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>主任医生</span>
												</p>
											</td>
											<td width=87 nowrap
												style='width: 65.0pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; mso-border-bottom-alt: solid windowtext 1.0pt; mso-border-right-alt: solid windowtext .5pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 20.0pt'>
												<p class=MsoNormal>
													<span lang=EN-US>T1</span>
												</p>
											</td>
											<td width=87 nowrap
												style='width: 65.0pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; mso-border-bottom-alt: solid windowtext 1.0pt; mso-border-right-alt: solid windowtext .5pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 20.0pt'>
												<p class=MsoNormal>
													<span lang=EN-US>0.03</span>
												</p>
											</td>
											<td width=87 nowrap
												style='width: 65.0pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 20.0pt'>
												<p class=MsoNormal>
													<span lang=EN-US>79</span>
												</p>
											</td>
											 
											 
										</tr>
									</table>
								</td>
							</tr>

							<%
								}
							%>

							<%
								if ("10008".equals(strPKID)) {
							%>

							<tr>
								<td valign="top">

									<p class=MsoNormal>
										<a name="_Toc320184207"><b><span
												style='font-family: 微软雅黑; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>王老师</span>
										</b>
										</a><span style='mso-bookmark: _Toc320184207'></span><span
											style='font-family: 微软雅黑; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>：</span>
									</p>

									<p class=MsoNormal>
										<span
											style='font-family: 微软雅黑; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>女，主治医师，38岁。王老师为人很好，很受患者欢迎。她与我公司合作关系也很好，参加过几次我公司主办的大型学术会议后，对于我们的产品和相关适应症的应用有了很清楚的认知。<font color="red">对于e抗原阳性的患者使用抗病毒治疗时，大部分会处方我们的产品。对于经济有困难的患者，会选择拉米夫定和国产的抗病毒产品。</font></span>
									</p>

									<table class=MsoNormalTable border=0 cellspacing=0
										cellpadding=0 width=520
										style='width: 390.0pt; margin-left: 4.65pt; border-collapse: collapse; mso-yfti-tbllook: 1184; mso-padding-alt: 0cm 5.4pt 0cm 5.4pt'>
										<tr
											style='mso-yfti-irow: 0; mso-yfti-firstrow: yes; height: 20.0pt'>
											<td width=87 nowrap
												style='width: 65.0pt; border: solid windowtext 1.0pt; mso-border-top-alt: 1.0pt; mso-border-left-alt: 1.0pt; mso-border-bottom-alt: .5pt; mso-border-right-alt: .5pt; mso-border-color-alt: windowtext; mso-border-style-alt: solid; padding: 0cm 5.4pt 0cm 5.4pt; height: 20.0pt'>
												<p class=MsoNormal>
													<span
														style='font-family: 微软雅黑; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>姓名</span>
												</p>
											</td>
											<td width=87 nowrap
												style='width: 65.0pt; border: solid windowtext 1.0pt; border-left: none; mso-border-top-alt: solid windowtext 1.0pt; mso-border-bottom-alt: solid windowtext .5pt; mso-border-right-alt: solid windowtext .5pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 20.0pt'>
												<p class=MsoNormal>
													<span
														style='font-family: 微软雅黑; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>科室</span>
												</p>
											</td>
											<td width=87 nowrap
												style='width: 65.0pt; border: solid windowtext 1.0pt; border-left: none; mso-border-top-alt: solid windowtext 1.0pt; mso-border-bottom-alt: solid windowtext .5pt; mso-border-right-alt: solid windowtext .5pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 20.0pt'>
												<p class=MsoNormal>
													<span
														style='font-family: 微软雅黑; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>职称</span>
												</p>
											</td>
											<td width=87 nowrap
												style='width: 65.0pt; border: solid windowtext 1.0pt; border-left: none; mso-border-top-alt: solid windowtext 1.0pt; mso-border-bottom-alt: solid windowtext .5pt; mso-border-right-alt: solid windowtext .5pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 20.0pt'>
												<p class=MsoNormal>
													<span
														style='font-family: 微软雅黑; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>分级</span>
												</p>
											</td>
											<td width=87 nowrap
												style='width: 65.0pt; border: solid windowtext 1.0pt; border-left: none; mso-border-top-alt: solid windowtext 1.0pt; mso-border-bottom-alt: solid windowtext .5pt; mso-border-right-alt: solid windowtext .5pt; background: #EEECE1; padding: 0cm 5.4pt 0cm 5.4pt; height: 20.0pt'>
												<p class=MsoNormal>
													<span lang=EN-US>倾向性</span>
												</p>
											</td>
											<td width=87 nowrap
												style='width: 65.0pt; border: solid windowtext 1.0pt; border-left: none; mso-border-top-alt: solid windowtext 1.0pt; mso-border-bottom-alt: solid windowtext .5pt; mso-border-right-alt: solid windowtext 1.0pt; background: #EEECE1; padding: 0cm 5.4pt 0cm 5.4pt; height: 20.0pt'>
												<p class=MsoNormal>
													<span lang=EN-US>潜力</span>
												</p>
											</td>
										 
											 
										</tr>
										<tr
											style='mso-yfti-irow: 1; mso-yfti-lastrow: yes; height: 20.0pt'>
											<td width=87 nowrap
												style='width: 65.0pt; border: solid windowtext 1.0pt; border-top: none; mso-border-left-alt: solid windowtext 1.0pt; mso-border-bottom-alt: solid windowtext 1.0pt; mso-border-right-alt: solid windowtext .5pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 20.0pt'>
												<p class=MsoNormal>
													<span
														style='font-family: 微软雅黑; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>王老师</span>
												</p>
											</td>
											<td width=87 nowrap
												style='width: 65.0pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; mso-border-bottom-alt: solid windowtext 1.0pt; mso-border-right-alt: solid windowtext .5pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 20.0pt'>
												<p class=MsoNormal>
													<span
														style='font-family: 微软雅黑; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>传染科</span>
												</p>
											</td>
											<td width=87 nowrap
												style='width: 65.0pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; mso-border-bottom-alt: solid windowtext 1.0pt; mso-border-right-alt: solid windowtext .5pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 20.0pt'>
												<p class=MsoNormal>
													<span
														style='font-family: 微软雅黑; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>主治医师</span>
												</p>
											</td>
											<td width=87 nowrap
												style='width: 65.0pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; mso-border-bottom-alt: solid windowtext 1.0pt; mso-border-right-alt: solid windowtext .5pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 20.0pt'>
												<p class=MsoNormal>
													<span lang=EN-US>ST</span>
												</p>
											</td>
											<td width=87 nowrap
												style='width: 65.0pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; mso-border-bottom-alt: solid windowtext 1.0pt; mso-border-right-alt: solid windowtext .5pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 20.0pt'>
												<p class=MsoNormal>
													<span lang=EN-US>0.5</span>
												</p>
											</td>
											<td width=87 nowrap
												style='width: 65.0pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 20.0pt'>
												<p class=MsoNormal>
													<span lang=EN-US>75.6</span>
												</p>
											</td>
											 
											 
										</tr>
									</table>
								</td>
							</tr>

							<%
								}
							%>

							<%
								if ("10009".equals(strPKID)) {
							%>

							<tr>
								<td valign="top">

									<p class=MsoNormal>
										<a name="_Toc320184208"><b><span
												style='font-family: 微软雅黑; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>冯老师</span>
										</b>
										</a><span style='mso-bookmark: _Toc320184208'></span><span
											style='font-family: 微软雅黑; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>：</span>
									</p>

									<p class=MsoNormal>
										<span
											style='font-family: 微软雅黑; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>男，主治医师，36岁。冯老师是你刚刚开始接触的医生，跟你比较投缘。你们有相同的爱好：打羽毛球。冯老师非常喜欢专业的医药代表，你的专业呈现恰巧打动了他。通过你的介绍和会议的跟进，冯老师对于我们的产品和在临床的应用非常了解，他的处方观念在一点点的发生着转变。</span>
									</p>

									<table class=MsoNormalTable border=0 cellspacing=0
										cellpadding=0 width=520
										style='width: 390.0pt; margin-left: 4.65pt; border-collapse: collapse; mso-yfti-tbllook: 1184; mso-padding-alt: 0cm 5.4pt 0cm 5.4pt'>
										<tr
											style='mso-yfti-irow: 0; mso-yfti-firstrow: yes; height: 20.0pt'>
											<td width=87 nowrap
												style='width: 65.0pt; border: solid windowtext 1.0pt; mso-border-top-alt: 1.0pt; mso-border-left-alt: 1.0pt; mso-border-bottom-alt: .5pt; mso-border-right-alt: .5pt; mso-border-color-alt: windowtext; mso-border-style-alt: solid; padding: 0cm 5.4pt 0cm 5.4pt; height: 20.0pt'>
												<p class=MsoNormal>
													<span
														style='font-family: 微软雅黑; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>姓名</span>
												</p>
											</td>
											<td width=87 nowrap
												style='width: 65.0pt; border: solid windowtext 1.0pt; border-left: none; mso-border-top-alt: solid windowtext 1.0pt; mso-border-bottom-alt: solid windowtext .5pt; mso-border-right-alt: solid windowtext .5pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 20.0pt'>
												<p class=MsoNormal>
													<span
														style='font-family: 微软雅黑; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>科室</span>
												</p>
											</td>
											<td width=87 nowrap
												style='width: 65.0pt; border: solid windowtext 1.0pt; border-left: none; mso-border-top-alt: solid windowtext 1.0pt; mso-border-bottom-alt: solid windowtext .5pt; mso-border-right-alt: solid windowtext .5pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 20.0pt'>
												<p class=MsoNormal>
													<span
														style='font-family: 微软雅黑; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>职称</span>
												</p>
											</td>
											<td width=87 nowrap
												style='width: 65.0pt; border: solid windowtext 1.0pt; border-left: none; mso-border-top-alt: solid windowtext 1.0pt; mso-border-bottom-alt: solid windowtext .5pt; mso-border-right-alt: solid windowtext .5pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 20.0pt'>
												<p class=MsoNormal>
													<span
														style='font-family: 微软雅黑; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>分级</span>
												</p>
											</td>
											<td width=87 nowrap
												style='width: 65.0pt; border: solid windowtext 1.0pt; border-left: none; mso-border-top-alt: solid windowtext 1.0pt; mso-border-bottom-alt: solid windowtext .5pt; mso-border-right-alt: solid windowtext .5pt; background: #EEECE1; padding: 0cm 5.4pt 0cm 5.4pt; height: 20.0pt'>
												<p class=MsoNormal>
													<span lang=EN-US>倾向性</span>
												</p>
											</td>
											<td width=87 nowrap
												style='width: 65.0pt; border: solid windowtext 1.0pt; border-left: none; mso-border-top-alt: solid windowtext 1.0pt; mso-border-bottom-alt: solid windowtext .5pt; mso-border-right-alt: solid windowtext 1.0pt; background: #EEECE1; padding: 0cm 5.4pt 0cm 5.4pt; height: 20.0pt'>
												<p class=MsoNormal>
													<span lang=EN-US>潜力</span>
												</p>
											</td>
											 
											 
										</tr>
										<tr
											style='mso-yfti-irow: 1; mso-yfti-lastrow: yes; height: 20.0pt'>
											<td width=87 nowrap
												style='width: 65.0pt; border: solid windowtext 1.0pt; border-top: none; mso-border-left-alt: solid windowtext 1.0pt; mso-border-bottom-alt: solid windowtext 1.0pt; mso-border-right-alt: solid windowtext .5pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 20.0pt'>
												<p class=MsoNormal>
													<span
														style='font-family: 微软雅黑; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>冯老师</span>
												</p>
											</td>
											<td width=87 nowrap
												style='width: 65.0pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; mso-border-bottom-alt: solid windowtext 1.0pt; mso-border-right-alt: solid windowtext .5pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 20.0pt'>
												<p class=MsoNormal>
													<span
														style='font-family: 微软雅黑; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>传染科</span>
												</p>
											</td>
											<td width=87 nowrap
												style='width: 65.0pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; mso-border-bottom-alt: solid windowtext 1.0pt; mso-border-right-alt: solid windowtext .5pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 20.0pt'>
												<p class=MsoNormal>
													<span
														style='font-family: 微软雅黑; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>主治医师</span>
												</p>
											</td>
											<td width=87 nowrap
												style='width: 65.0pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; mso-border-bottom-alt: solid windowtext 1.0pt; mso-border-right-alt: solid windowtext .5pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 20.0pt'>
												<p class=MsoNormal>
													<span lang=EN-US>ST</span>
												</p>
											</td>
											<td width=87 nowrap
												style='width: 65.0pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; mso-border-bottom-alt: solid windowtext 1.0pt; mso-border-right-alt: solid windowtext .5pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 20.0pt'>
												<p class=MsoNormal>
													<span lang=EN-US>0.2</span>
												</p>
											</td>
											<td width=87 nowrap
												style='width: 65.0pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 20.0pt'>
												<p class=MsoNormal>
													<span lang=EN-US>85</span>
												</p>
											</td>
											 
											 
										</tr>
									</table>
								</td>
							</tr>

							<%
								}
							%>

							<%
								if ("10010".equals(strPKID)) {
							%>

							<tr>
								<td valign="top">

									<p class=MsoNormal>
										<a name="_Toc320184209"><b><span
												style='font-family: 微软雅黑; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>陈老师</span>
										</b>
										</a><span style='mso-bookmark: _Toc320184209'></span><span
											style='font-family: 微软雅黑; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>：</span>
									</p>

									<p class=MsoNormal>
										<span
											style='font-family: 微软雅黑; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>女，主治医师，35岁，你与陈老师接触了半年多的时间。开始的时候，陈老师总是跟你说，对于慢乙肝的病人还是干扰素的效果最明显，很多新的产品和治疗方案都要经过验证才能应用。经过你的不懈的努力，程老师终于逐渐接受了我们产品在这个适应症上的优势。尤其是在一次会议上，听了协和医院史教授的报告后，陈老师开始尝试处方我们的产品了。</span>
									</p>

									<table class=MsoNormalTable border=0 cellspacing=0
										cellpadding=0 width=520
										style='width: 390.0pt; margin-left: 4.65pt; border-collapse: collapse; mso-yfti-tbllook: 1184; mso-padding-alt: 0cm 5.4pt 0cm 5.4pt'>
										<tr
											style='mso-yfti-irow: 0; mso-yfti-firstrow: yes; height: 20.0pt'>
											<td width=87 nowrap
												style='width: 65.0pt; border: solid windowtext 1.0pt; mso-border-top-alt: 1.0pt; mso-border-left-alt: 1.0pt; mso-border-bottom-alt: .5pt; mso-border-right-alt: .5pt; mso-border-color-alt: windowtext; mso-border-style-alt: solid; padding: 0cm 5.4pt 0cm 5.4pt; height: 20.0pt'>
												<p class=MsoNormal>
													<span
														style='font-family: 微软雅黑; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>姓名</span>
												</p>
											</td>
											<td width=87 nowrap
												style='width: 65.0pt; border: solid windowtext 1.0pt; border-left: none; mso-border-top-alt: solid windowtext 1.0pt; mso-border-bottom-alt: solid windowtext .5pt; mso-border-right-alt: solid windowtext .5pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 20.0pt'>
												<p class=MsoNormal>
													<span
														style='font-family: 微软雅黑; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>科室</span>
												</p>
											</td>
											<td width=87 nowrap
												style='width: 65.0pt; border: solid windowtext 1.0pt; border-left: none; mso-border-top-alt: solid windowtext 1.0pt; mso-border-bottom-alt: solid windowtext .5pt; mso-border-right-alt: solid windowtext .5pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 20.0pt'>
												<p class=MsoNormal>
													<span
														style='font-family: 微软雅黑; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>职称</span>
												</p>
											</td>
											<td width=87 nowrap
												style='width: 65.0pt; border: solid windowtext 1.0pt; border-left: none; mso-border-top-alt: solid windowtext 1.0pt; mso-border-bottom-alt: solid windowtext .5pt; mso-border-right-alt: solid windowtext .5pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 20.0pt'>
												<p class=MsoNormal>
													<span
														style='font-family: 微软雅黑; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>分级</span>
												</p>
											</td>
											<td width=87 nowrap
												style='width: 65.0pt; border: solid windowtext 1.0pt; border-left: none; mso-border-top-alt: solid windowtext 1.0pt; mso-border-bottom-alt: solid windowtext .5pt; mso-border-right-alt: solid windowtext .5pt; background: #EEECE1; padding: 0cm 5.4pt 0cm 5.4pt; height: 20.0pt'>
												<p class=MsoNormal>
													<span lang=EN-US>倾向性</span>
												</p>
											</td>
											<td width=87 nowrap
												style='width: 65.0pt; border: solid windowtext 1.0pt; border-left: none; mso-border-top-alt: solid windowtext 1.0pt; mso-border-bottom-alt: solid windowtext .5pt; mso-border-right-alt: solid windowtext 1.0pt; background: #EEECE1; padding: 0cm 5.4pt 0cm 5.4pt; height: 20.0pt'>
												<p class=MsoNormal>
													<span lang=EN-US>潜力</span>
												</p>
											</td>
											 
											 
										</tr>
										<tr
											style='mso-yfti-irow: 1; mso-yfti-lastrow: yes; height: 20.0pt'>
											<td width=87 nowrap
												style='width: 65.0pt; border: solid windowtext 1.0pt; border-top: none; mso-border-left-alt: solid windowtext 1.0pt; mso-border-bottom-alt: solid windowtext 1.0pt; mso-border-right-alt: solid windowtext .5pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 20.0pt'>
												<p class=MsoNormal>
													<span
														style='font-family: 微软雅黑; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>陈老师</span>
												</p>
											</td>
											<td width=87 nowrap
												style='width: 65.0pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; mso-border-bottom-alt: solid windowtext 1.0pt; mso-border-right-alt: solid windowtext .5pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 20.0pt'>
												<p class=MsoNormal>
													<span
														style='font-family: 微软雅黑; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>高干科</span>
												</p>
											</td>
											<td width=87 nowrap
												style='width: 65.0pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; mso-border-bottom-alt: solid windowtext 1.0pt; mso-border-right-alt: solid windowtext .5pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 20.0pt'>
												<p class=MsoNormal>
													<span
														style='font-family: 微软雅黑; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>主任医生</span>
												</p>
											</td>
											<td width=87 nowrap
												style='width: 65.0pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; mso-border-bottom-alt: solid windowtext 1.0pt; mso-border-right-alt: solid windowtext .5pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 20.0pt'>
												<p class=MsoNormal>
													<span lang=EN-US>T2</span>
												</p>
											</td>
											<td width=87 nowrap
												style='width: 65.0pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; mso-border-bottom-alt: solid windowtext 1.0pt; mso-border-right-alt: solid windowtext .5pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 20.0pt'>
												<p class=MsoNormal>
													<span lang=EN-US>0.08</span>
												</p>
											</td>
											<td width=87 nowrap
												style='width: 65.0pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 20.0pt'>
												<p class=MsoNormal>
													<span lang=EN-US>42</span>
												</p>
											</td>
											 
											 
										</tr>
									</table>
								</td>
							</tr>

							<%
								}
							%>

							<%
								if ("10011".equals(strPKID)) {
							%>

							<tr>
								<td valign="top">

									<p class=MsoNormal>
										<a name="_Toc320184210"><b><span
												style='font-family: 微软雅黑; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>楚老师</span>
										</b>
										</a><span style='mso-bookmark: _Toc320184210'></span><span
											style='font-family: 微软雅黑; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>：</span>
									</p>

									<p class=MsoNormal>
										<span
											style='font-family: 微软雅黑; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>男，主治医师，40岁。楚老师是从外院刚刚调入本院传染科的，他一直比较认同干扰素的治疗效果。他喜欢参加各种学术会议，也在忙着写文章准备职称晋升。因为在他写文章时，你帮了很大的忙，所以最近他处方了一些你的产品。在用药的选择上，他非常关注产品的安全性，对于我们产品的安全性也一直存在顾虑。所以，在产品选择上是比较慎重的。</span>
									</p>

									<table class=MsoNormalTable border=0 cellspacing=0
										cellpadding=0 width=520
										style='width: 390.0pt; margin-left: 4.65pt; border-collapse: collapse; mso-yfti-tbllook: 1184; mso-padding-alt: 0cm 5.4pt 0cm 5.4pt'>
										<tr
											style='mso-yfti-irow: 0; mso-yfti-firstrow: yes; height: 20.0pt'>
											<td width=87 nowrap
												style='width: 65.0pt; border: solid windowtext 1.0pt; mso-border-top-alt: 1.0pt; mso-border-left-alt: 1.0pt; mso-border-bottom-alt: .5pt; mso-border-right-alt: .5pt; mso-border-color-alt: windowtext; mso-border-style-alt: solid; padding: 0cm 5.4pt 0cm 5.4pt; height: 20.0pt'>
												<p class=MsoNormal>
													<span
														style='font-family: 微软雅黑; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>姓名</span>
												</p>
											</td>
											<td width=87 nowrap
												style='width: 65.0pt; border: solid windowtext 1.0pt; border-left: none; mso-border-top-alt: solid windowtext 1.0pt; mso-border-bottom-alt: solid windowtext .5pt; mso-border-right-alt: solid windowtext .5pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 20.0pt'>
												<p class=MsoNormal>
													<span
														style='font-family: 微软雅黑; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>科室</span>
												</p>
											</td>
											<td width=87 nowrap
												style='width: 65.0pt; border: solid windowtext 1.0pt; border-left: none; mso-border-top-alt: solid windowtext 1.0pt; mso-border-bottom-alt: solid windowtext .5pt; mso-border-right-alt: solid windowtext .5pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 20.0pt'>
												<p class=MsoNormal>
													<span
														style='font-family: 微软雅黑; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>职称</span>
												</p>
											</td>
											<td width=87 nowrap
												style='width: 65.0pt; border: solid windowtext 1.0pt; border-left: none; mso-border-top-alt: solid windowtext 1.0pt; mso-border-bottom-alt: solid windowtext .5pt; mso-border-right-alt: solid windowtext .5pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 20.0pt'>
												<p class=MsoNormal>
													<span
														style='font-family: 微软雅黑; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>分级</span>
												</p>
											</td>
											<td width=87 nowrap
												style='width: 65.0pt; border: solid windowtext 1.0pt; border-left: none; mso-border-top-alt: solid windowtext 1.0pt; mso-border-bottom-alt: solid windowtext .5pt; mso-border-right-alt: solid windowtext .5pt; background: #EEECE1; padding: 0cm 5.4pt 0cm 5.4pt; height: 20.0pt'>
												<p class=MsoNormal>
													<span lang=EN-US>倾向性</span>
												</p>
											</td>
											<td width=87 nowrap
												style='width: 65.0pt; border: solid windowtext 1.0pt; border-left: none; mso-border-top-alt: solid windowtext 1.0pt; mso-border-bottom-alt: solid windowtext .5pt; mso-border-right-alt: solid windowtext 1.0pt; background: #EEECE1; padding: 0cm 5.4pt 0cm 5.4pt; height: 20.0pt'>
												<p class=MsoNormal>
													<span lang=EN-US>潜力</span>
												</p>
											</td>
											 
											 
										</tr>
										<tr
											style='mso-yfti-irow: 1; mso-yfti-lastrow: yes; height: 20.0pt'>
											<td width=87 nowrap
												style='width: 65.0pt; border: solid windowtext 1.0pt; border-top: none; mso-border-left-alt: solid windowtext 1.0pt; mso-border-bottom-alt: solid windowtext 1.0pt; mso-border-right-alt: solid windowtext .5pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 20.0pt'>
												<p class=MsoNormal>
													<span
														style='font-family: 微软雅黑; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>楚老师</span>
												</p>
											</td>
											<td width=87 nowrap
												style='width: 65.0pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; mso-border-bottom-alt: solid windowtext 1.0pt; mso-border-right-alt: solid windowtext .5pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 20.0pt'>
												<p class=MsoNormal>
													<span
														style='font-family: 微软雅黑; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>传染科</span>
												</p>
											</td>
											<td width=87 nowrap
												style='width: 65.0pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; mso-border-bottom-alt: solid windowtext 1.0pt; mso-border-right-alt: solid windowtext .5pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 20.0pt'>
												<p class=MsoNormal>
													<span
														style='font-family: 微软雅黑; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>主治医师</span>
												</p>
											</td>
											<td width=87 nowrap
												style='width: 65.0pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; mso-border-bottom-alt: solid windowtext 1.0pt; mso-border-right-alt: solid windowtext .5pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 20.0pt'>
												<p class=MsoNormal>
													<span lang=EN-US>T2</span>
												</p>
											</td>
											<td width=87 nowrap
												style='width: 65.0pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; mso-border-bottom-alt: solid windowtext 1.0pt; mso-border-right-alt: solid windowtext .5pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 20.0pt'>
												<p class=MsoNormal>
													<span lang=EN-US>0.4</span>
												</p>
											</td>
											<td width=87 nowrap
												style='width: 65.0pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 20.0pt'>
												<p class=MsoNormal>
													<span lang=EN-US>36.8</span>
												</p>
											</td>
											 
											 
										</tr>
									</table>
								</td>
							</tr>

							<%
								}
							%>

							<%
								if ("10012".equals(strPKID)) {
							%>

							<tr>
								<td valign="top">

									<p class=MsoNormal>
										<a name="_Toc320184211"><b><span
												style='font-family: 微软雅黑; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>魏老师</span>
										</b>
										</a><span style='mso-bookmark: _Toc320184211'></span><span
											style='font-family: 微软雅黑; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>：</span>
									</p>

									<p class=MsoNormal>
										<span
											style='font-family: 微软雅黑; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>女，住院医师，25岁。魏老师刚从大学毕业不久，是你的师妹。对疾病发展和治疗方案进展有很强烈的学习意愿。每次你所呈现的专业资料，她都会详细研读，并能提出很多她所关注的问题。经过你的工作后，她对我们的产品及应用非常了解，在临床使用上也是首选我们的产品。</span>
									</p>

									<table class=MsoNormalTable border=0 cellspacing=0
										cellpadding=0 width=520
										style='width: 390.0pt; margin-left: 4.65pt; border-collapse: collapse; mso-yfti-tbllook: 1184; mso-padding-alt: 0cm 5.4pt 0cm 5.4pt'>
										<tr
											style='mso-yfti-irow: 0; mso-yfti-firstrow: yes; height: 20.0pt'>
											<td width=87 nowrap
												style='width: 65.0pt; border: solid windowtext 1.0pt; mso-border-top-alt: 1.0pt; mso-border-left-alt: 1.0pt; mso-border-bottom-alt: .5pt; mso-border-right-alt: .5pt; mso-border-color-alt: windowtext; mso-border-style-alt: solid; padding: 0cm 5.4pt 0cm 5.4pt; height: 20.0pt'>
												<p class=MsoNormal>
													<span
														style='font-family: 微软雅黑; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>姓名</span>
												</p>
											</td>
											<td width=87 nowrap
												style='width: 65.0pt; border: solid windowtext 1.0pt; border-left: none; mso-border-top-alt: solid windowtext 1.0pt; mso-border-bottom-alt: solid windowtext .5pt; mso-border-right-alt: solid windowtext .5pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 20.0pt'>
												<p class=MsoNormal>
													<span
														style='font-family: 微软雅黑; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>科室</span>
												</p>
											</td>
											<td width=87 nowrap
												style='width: 65.0pt; border: solid windowtext 1.0pt; border-left: none; mso-border-top-alt: solid windowtext 1.0pt; mso-border-bottom-alt: solid windowtext .5pt; mso-border-right-alt: solid windowtext .5pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 20.0pt'>
												<p class=MsoNormal>
													<span
														style='font-family: 微软雅黑; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>职称</span>
												</p>
											</td>
											<td width=87 nowrap
												style='width: 65.0pt; border: solid windowtext 1.0pt; border-left: none; mso-border-top-alt: solid windowtext 1.0pt; mso-border-bottom-alt: solid windowtext .5pt; mso-border-right-alt: solid windowtext .5pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 20.0pt'>
												<p class=MsoNormal>
													<span
														style='font-family: 微软雅黑; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>分级</span>
												</p>
											</td>
											<td width=87 nowrap
												style='width: 65.0pt; border: solid windowtext 1.0pt; border-left: none; mso-border-top-alt: solid windowtext 1.0pt; mso-border-bottom-alt: solid windowtext .5pt; mso-border-right-alt: solid windowtext .5pt; background: #EEECE1; padding: 0cm 5.4pt 0cm 5.4pt; height: 20.0pt'>
												<p class=MsoNormal>
													<span lang=EN-US>倾向性</span>
												</p>
											</td>
											<td width=87 nowrap
												style='width: 65.0pt; border: solid windowtext 1.0pt; border-left: none; mso-border-top-alt: solid windowtext 1.0pt; mso-border-bottom-alt: solid windowtext .5pt; mso-border-right-alt: solid windowtext 1.0pt; background: #EEECE1; padding: 0cm 5.4pt 0cm 5.4pt; height: 20.0pt'>
												<p class=MsoNormal>
													<span lang=EN-US>潜力</span>
												</p>
											</td>
											 
											 
										</tr>
										<tr
											style='mso-yfti-irow: 1; mso-yfti-lastrow: yes; height: 20.0pt'>
											<td width=87 nowrap
												style='width: 65.0pt; border: solid windowtext 1.0pt; border-top: none; mso-border-left-alt: solid windowtext 1.0pt; mso-border-bottom-alt: solid windowtext 1.0pt; mso-border-right-alt: solid windowtext .5pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 20.0pt'>
												<p class=MsoNormal>
													<span
														style='font-family: 微软雅黑; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>魏老师</span>
												</p>
											</td>
											<td width=87 nowrap
												style='width: 65.0pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; mso-border-bottom-alt: solid windowtext 1.0pt; mso-border-right-alt: solid windowtext .5pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 20.0pt'>
												<p class=MsoNormal>
													<span
														style='font-family: 微软雅黑; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>肿瘤内科</span>
												</p>
											</td>
											<td width=87 nowrap
												style='width: 65.0pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; mso-border-bottom-alt: solid windowtext 1.0pt; mso-border-right-alt: solid windowtext .5pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 20.0pt'>
												<p class=MsoNormal>
													<span
														style='font-family: 微软雅黑; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>住院医师</span>
												</p>
											</td>
											<td width=87 nowrap
												style='width: 65.0pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; mso-border-bottom-alt: solid windowtext 1.0pt; mso-border-right-alt: solid windowtext .5pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 20.0pt'>
												<p class=MsoNormal>
													<span lang=EN-US>T3</span>
												</p>
											</td>
											<td width=87 nowrap
												style='width: 65.0pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; mso-border-bottom-alt: solid windowtext 1.0pt; mso-border-right-alt: solid windowtext .5pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 20.0pt'>
												<p class=MsoNormal>
													<span lang=EN-US>0.8</span>
												</p>
											</td>
											<td width=87 nowrap
												style='width: 65.0pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 20.0pt'>
												<p class=MsoNormal>
													<span lang=EN-US>4.05</span>
												</p>
											</td>
											 
											 
										</tr>
									</table>
								</td>
							</tr>

							<%
								}
							%>

						</table>

					</td>
					<!--
					<td width="200" valign="top" align="left">
						<table border="1" cellpadding="3" cellspacing="1"
							bgcolor="#FBD8AC" width="100%" style="display:none;">
							<tr>
								<td width="23px" style="text-align: center;">
									人口状况
								</td>
								<td>
									人口数量：<label id="RENKOUSHU"></label>
									<br>
									0-25岁： <label id="SUI0"></label>
									<br>
									25-60岁：<label id="SUI25"></label>
									<br>
									+60岁：<label id="SUI60"></label>
									<br>
									人均收入： <label id="RJSR"></label>
								</td>
							</tr>
							<tr>
								<td width="23px" style="text-align: center;">
									医药经济环境
								</td>
								<td>
									目标医院数：<label id="COUNTYIYUAN"></label>
									<br>
									3级： <label id="JI3"></label>
									<br>
									2级：<label id="JI2"></label>
									<br>
									心血管相关疾病门诊量： <label id="COUNTMENZENG"></label>人次／年 
									<br>
									心血管相关疾病购药金额： <label id="COUNTJINER"></label>万元/年
								</td>
							</tr>
						</table>
						
						<table>
							<tr>
								<td width="23px" style="text-align: center;">

								</td>
								<td valign="bottom">
									<br>
									<br>
									<br>
									<br>
									<input type="button" value="销售数据"
										onclick="javascript:g_OpenModalReturnWindow('<%=basePath%>getMarketInfo_1.action?PKID=<%=strPKID%>&userName=<%=struserName%>',800,560);" />
									<br>
									 <input type="button" value=" 有效性 " onclick="javascript:g_OpenModalReturnWindow('<%=basePath%>youXiaoXing_person.action?PKID=<%=strPKID%>&userName=<%=struserName%>',660,340);" />
									<br>  
									 <input style="width: 80px; height: auto" type="button" value="总体有效性图"
							               onclick="javascript:g_OpenModalReturnWindow('<%=basePath%>jsp/static/youXiaoXing_char.jsp?PKID=<%=strPKID%>&userName=<%=struserName%>',826,600);" /><br>
								</td>
							</tr>
						</table>
					</td>
				-->
				</tr>
			</table>
		</div>
	</body>
</html>
 
 