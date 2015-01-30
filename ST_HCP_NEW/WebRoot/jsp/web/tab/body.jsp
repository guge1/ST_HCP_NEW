
<%@ page contentType="text/html; charset=GBK"%>
<%
	String strPrjName="/ST_HCP_NEW";
		String path = request.getContextPath();
		String basePath = request.getScheme() + "://" + request.getServerName()   ;
		if(!"".equals( request.getServerPort()))
		{
		   basePath+=  ":" + request.getServerPort() ;
		}
		if(strPrjName.equals(path))
		{
		   basePath+= path + "/";
		}else
		{
			 basePath+= "/";
		}
%>
<html>
	<head>

		<title>ST_HCP_NEW区域管理实战模拟实战系统</title>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />

		<base target="_self">
		<link rel="stylesheet" type="text/css" href="skin/css/base.css" />
		<link rel="stylesheet" type="text/css" href="skin/css/main.css" />
		<script src="<%=basePath%>jsp/Market/js/WinOpen.js" type="text/javascript">
		
</script>

<link rel="stylesheet" href="<%=basePath%>skins/yellow/css/style.css" type="text/css"></link>
	</head>
	<body style="margin-right:0px;padding:0px;width:100%;" >
	 
	 <div style="text-align:center;width:100%;background:#FFFFFF;">
       <div id="con_article_1" style="margin:0px auto;width:981px;text-align:center;background:#FFFFFF;" >
       <div class="cssz l">
         <div class="shezhi"><span class="canshu l">参数设置</span>
         <span class="list l"><a href="#"  onclick="javascript:g_OpenModalReturnWindow('<%=basePath%>getMarketInfo_1.action',800,560);">销售数据</a><a href="#" onclick="javascript:g_OpenModalReturnWindow('<%=basePath%>queryZhiBiaoInfo.action',840,500);">指标参数</a><a href="#" onclick="javascript:g_OpenModalReturnWindow('<%=basePath%>queryZiyuanInfo.action',780,320);">资源</a></span></div>
         <div class="xinxi" style="background:#FFFFFF;">
		     <p class="xinxi_title">公司简介</p>
		     <div class="xinxi_content" style="background:#FFFFFF;text-align:left;height: expression(document.body.clientHeight-133); overflow: auto;">
		     
		       
			  
<div class=Section1 style='layout-grid:18.0pt'>

<p class=Default style='margin-top:12.0pt;margin-right:0cm;margin-bottom:12.0pt;
margin-left:0cm;line-height:24.0pt;mso-line-height-rule:exactly'><span
style='font-size:11.5pt'>你所在的公司<span lang=EN-US>---</span></span><span
lang=EN-US style='font-size:11.5pt;font-family:"Calibri","sans-serif";
mso-ascii-font-family:微软雅黑'>“</span><span lang=EN-US style='font-size:11.5pt'>N</span><span
lang=EN-US style='font-size:11.5pt;font-family:"Calibri","sans-serif";
mso-ascii-font-family:微软雅黑'>”</span><span style='font-size:11.5pt'>制药公司，在制药业拥有一段辉煌的历史。公司的前身在十九世纪就已经开始了商业活动，并于上世纪初就已经进入中国市场。几经并购，公司已经在全球市场占据了相当的地位，位列世界<span
lang=EN-US>500</span>强。目前，在医药领域，处方药是该公司主要经营的业务。公司的总部在欧洲，同时在世界各地都有分支机构和业务活动。你的责任是销售核苷类抗病毒药：替<span
class=GramE>比夫定</span>，一个治疗慢乙肝的一个重要药物</span><span lang=EN-US style='font-size:
11.5pt;font-family:"Calibri","sans-serif";mso-ascii-font-family:微软雅黑'>——“</span><span
lang=EN-US style='font-size:11.5pt'>NG</span><span lang=EN-US style='font-size:
11.5pt;font-family:"Calibri","sans-serif";mso-ascii-font-family:微软雅黑'>”</span><span
style='font-size:11.5pt'>。市场部要求<span lang=EN-US>NG</span>今年的主要目标科室仍为传染科。<span
lang=EN-US> <o:p></o:p></span></span></p>

<p class=Default style='line-height:24.0pt;mso-line-height-rule:exactly'><span
style='font-size:11.5pt'>这种药通常在传染病医院及综合医院的传染科销售<span lang=EN-US>,</span>医院等级越高处方量越大<span
lang=EN-US>,</span>这是由病人量决定的。由于面对的人群非常集中<span lang=EN-US>,</span>相对其他药物而言<span
lang=EN-US>,</span>这一类药物总体价格敏感度不大<span lang=EN-US>,</span>虽然这一情况正在随着仿制药的出现而发生变化。总体而言<span
lang=EN-US>,</span>该类产品针对慢性疾病<span lang=EN-US>,</span>往往患者会长期服药。<span
lang=EN-US> <o:p></o:p></span></span></p>

<p class=Default style='margin-top:12.0pt'><b><span style='font-size:14.0pt'>区域介绍
</span></b><span lang=EN-US style='font-size:14.0pt'><o:p></o:p></span></p>

<p class=MsoNormal style='margin-top:12.0pt;line-height:24.0pt;mso-line-height-rule:
exactly'><span style='font-size:11.5pt;font-family:"微软雅黑","sans-serif";
mso-ascii-font-family:Tahoma;mso-hansi-font-family:Tahoma'>你所接手的医院是一家大型的传染病医院，你负责部分科室的销售。客户数量多、竞争产品多。你的目标科室主要是传染科，其他科室包括高干科、肿瘤内科及消化科。每个医生各有特点。今年公司对于</span><span
lang=EN-US style='font-size:11.5pt'>NG</span><span style='font-size:11.5pt;
font-family:"微软雅黑","sans-serif";mso-ascii-font-family:Tahoma;mso-hansi-font-family:
Tahoma'>产品寄予厚望，<span class=GramE>年指标</span>的增长率为</span><span lang=EN-US
style='font-size:11.5pt'>25%</span><span style='font-size:11.5pt;font-family:
"微软雅黑","sans-serif";mso-ascii-font-family:Tahoma;mso-hansi-font-family:Tahoma'>。同时你的老板对你充满期望和信心，你的区域对整个团队达成目标非常关键，所以你只能成功不能失败。</span></p>

<p class=MsoNormal><span lang=EN-US><o:p>&nbsp;</o:p></span></p>

<p class=MsoNormal><span lang=EN-US><o:p>&nbsp;</o:p></span></p>

<p class=MsoNormal><span lang=EN-US><o:p>&nbsp;</o:p></span></p>

<p class=MsoNormal><span lang=EN-US><o:p>&nbsp;</o:p></span></p>

<p class=Default><b><span style='font-size:16.0pt'>竞争产品介绍： </span></b><span
lang=EN-US style='font-size:16.0pt'><o:p></o:p></span></p>

<p class=Default><span style='font-size:11.5pt'>你有三个主要竞争对手<span lang=EN-US>: <o:p></o:p></span></span></p>

<p class=Default><span lang=EN-US style='font-size:11.5pt'>- </span><span
lang=EN-US style='font-size:11.5pt;font-family:"Calibri","sans-serif";
mso-ascii-font-family:微软雅黑'>“</span><span lang=EN-US style='font-size:11.5pt'>G
</span><span style='font-size:11.5pt'>公司</span><span lang=EN-US
style='font-size:11.5pt;font-family:"Calibri","sans-serif";mso-ascii-font-family:
微软雅黑'>”</span><span lang=EN-US style='font-size:11.5pt'> <o:p></o:p></span></p>

<p class=Default style='line-height:24.0pt;mso-line-height-rule:exactly'><span
style='font-size:11.5pt'>这家公司是一家美国企业<span lang=EN-US>,</span>在全球医药企业排名位列前十，特别是在本世纪初，他们与另外一家制药企业合并后，实力非常强大。他们公司治疗慢乙肝的产品</span><span
lang=EN-US style='font-size:11.5pt;font-family:"Calibri","sans-serif";
mso-ascii-font-family:微软雅黑'>“</span><span lang=EN-US style='font-size:11.5pt'>GL</span><span
lang=EN-US style='font-size:11.5pt;font-family:"Calibri","sans-serif";
mso-ascii-font-family:微软雅黑'>”</span><span style='font-size:11.5pt'>（拉米夫定）是首先上市的药物。该产品曾经有很长一段时间处于市场领先地位<span
lang=EN-US>,</span>公司每年在这个产品上投入巨大。然而<span lang=EN-US>,</span>当</span><span
lang=EN-US style='font-size:11.5pt;font-family:"Calibri","sans-serif";
mso-ascii-font-family:微软雅黑'>“</span><span lang=EN-US style='font-size:11.5pt'>NG</span><span
lang=EN-US style='font-size:11.5pt;font-family:"Calibri","sans-serif";
mso-ascii-font-family:微软雅黑'>”</span><span style='font-size:11.5pt'>等产品上市后<span
lang=EN-US>,</span></span><span lang=EN-US style='font-size:11.5pt;font-family:
"Calibri","sans-serif";mso-ascii-font-family:微软雅黑'>“</span><span lang=EN-US
style='font-size:11.5pt'>GL</span><span lang=EN-US style='font-size:11.5pt;
font-family:"Calibri","sans-serif";mso-ascii-font-family:微软雅黑'>”</span><span
style='font-size:11.5pt'>的市场销售开始受到影响。特别是这两年该产品的耐药性明显升高，使其市场份额下降明显。基于这种现状<span
lang=EN-US>,</span>其主打卖点转向为：更长时间的临床验证<span lang=EN-US>,</span>更好的临床使用经验。 同时<span
lang=EN-US>,</span>公司仍然在推广</span><span lang=EN-US style='font-size:11.5pt;
font-family:"Calibri","sans-serif";mso-ascii-font-family:微软雅黑'>“</span><span
lang=EN-US style='font-size:11.5pt'>GL</span><span lang=EN-US style='font-size:
11.5pt;font-family:"Calibri","sans-serif";mso-ascii-font-family:微软雅黑'>”</span><span
style='font-size:11.5pt'>。另外，这家公司在近两年又推出了一个新产品</span><span class=GramE><span
lang=EN-US style='font-size:11.5pt;font-family:"Calibri","sans-serif";
mso-ascii-font-family:微软雅黑'>”</span></span><span lang=EN-US style='font-size:
11.5pt'>GD</span><span class=GramE><span lang=EN-US style='font-size:11.5pt;
font-family:"Calibri","sans-serif";mso-ascii-font-family:微软雅黑'>”</span></span><span
style='font-size:11.5pt'>（阿德福韦<span class=GramE>酯</span>），公司正在大力推广两个产品的联合用药，来降低耐药性和提高病毒抑制。<span
lang=EN-US> <o:p></o:p></span></span></p>

<p class=Default><span lang=EN-US style='font-size:11.5pt'>- </span><span
lang=EN-US style='font-size:11.5pt;font-family:"Calibri","sans-serif";
mso-ascii-font-family:微软雅黑'>“</span><span lang=EN-US style='font-size:11.5pt'>S
</span><span style='font-size:11.5pt'>公司</span><span lang=EN-US
style='font-size:11.5pt;font-family:"Calibri","sans-serif";mso-ascii-font-family:
微软雅黑'>”</span><span lang=EN-US style='font-size:11.5pt'> <o:p></o:p></span></p>

<p class=Default style='line-height:24.0pt;mso-line-height-rule:exactly'><span
lang=EN-US style='font-size:11.5pt'>S</span><span style='font-size:11.5pt'>公司也是位于世界<span
lang=EN-US>500</span>强的公司。这家公司有很好的销售网络和很好的临床促销队伍。他们的产品</span><span lang=EN-US
style='font-size:11.5pt;font-family:"Calibri","sans-serif";mso-ascii-font-family:
微软雅黑'>“</span><span lang=EN-US style='font-size:11.5pt'>SH</span><span
lang=EN-US style='font-size:11.5pt;font-family:"Calibri","sans-serif";
mso-ascii-font-family:微软雅黑'>”</span><span style='font-size:11.5pt'>（恩<span
class=GramE>替卡韦</span>）在市场上销售了一段时间了公司的投资是巨大的<span lang=EN-US>, </span>虽然其血清学转换率不如</span><span
lang=EN-US style='font-size:11.5pt;font-family:"Calibri","sans-serif";
mso-ascii-font-family:微软雅黑'>“</span><span lang=EN-US style='font-size:11.5pt'>NG</span><span
lang=EN-US style='font-size:11.5pt;font-family:"Calibri","sans-serif";
mso-ascii-font-family:微软雅黑'>”</span><span style='font-size:11.5pt'>，但是目前是市场的领跑者<span
lang=EN-US>,</span>目前总销售好于</span><span lang=EN-US style='font-size:11.5pt;
font-family:"Calibri","sans-serif";mso-ascii-font-family:微软雅黑'>“</span><span
lang=EN-US style='font-size:11.5pt'>NG</span><span lang=EN-US style='font-size:
11.5pt;font-family:"Calibri","sans-serif";mso-ascii-font-family:微软雅黑'>”</span><span
style='font-size:11.5pt'>。<span lang=EN-US> <o:p></o:p></span></span></p>

<p class=Default><span lang=EN-US style='font-size:11.5pt'>- </span><span
lang=EN-US style='font-size:11.5pt;font-family:"Calibri","sans-serif";
mso-ascii-font-family:微软雅黑'>“</span><span lang=EN-US style='font-size:11.5pt'>L
</span><span style='font-size:11.5pt'>公司</span><span lang=EN-US
style='font-size:11.5pt;font-family:"Calibri","sans-serif";mso-ascii-font-family:
微软雅黑'>”</span><span lang=EN-US style='font-size:11.5pt'> <o:p></o:p></span></p>

<p class=Default style='line-height:24.0pt;mso-line-height-rule:exactly'><span
lang=EN-US style='font-size:11.5pt'>L</span><span style='font-size:11.5pt'>公司是一家生产仿制药的生产销售企业。他们上市了</span><span
lang=EN-US style='font-size:11.5pt;font-family:"Calibri","sans-serif";
mso-ascii-font-family:微软雅黑'>“</span><span lang=EN-US style='font-size:11.5pt'>LH</span><span
lang=EN-US style='font-size:11.5pt;font-family:"Calibri","sans-serif";
mso-ascii-font-family:微软雅黑'>”</span><span lang=EN-US style='font-size:11.5pt'>,</span><span
style='font-size:11.5pt'>即</span><span lang=EN-US style='font-size:11.5pt;
font-family:"Calibri","sans-serif";mso-ascii-font-family:微软雅黑'>“</span><span
lang=EN-US style='font-size:11.5pt'>SH</span><span lang=EN-US style='font-size:
11.5pt;font-family:"Calibri","sans-serif";mso-ascii-font-family:微软雅黑'>”</span><span
style='font-size:11.5pt'>的仿制品。由于市场竞争激烈<span lang=EN-US>,</span>目前这个产品的销售处于起步阶段<span
lang=EN-US>, </span>销售存在很大的地区差异。但是他们的市场份额增长迅速<span lang=EN-US> <o:p></o:p></span></span></p>

<p class=MsoNormal style='line-height:24.0pt;mso-line-height-rule:exactly'><span
lang=EN-US style='font-size:11.5pt'>“NG”</span><span style='font-size:11.5pt;
font-family:"微软雅黑","sans-serif";mso-ascii-font-family:Tahoma;mso-hansi-font-family:
Tahoma'>相对于第一代产品</span><span lang=EN-US style='font-size:11.5pt'>“GL”</span><span
style='font-size:11.5pt;font-family:"微软雅黑","sans-serif";mso-ascii-font-family:
Tahoma;mso-hansi-font-family:Tahoma'>而言</span><span lang=EN-US
style='font-size:11.5pt'>,</span><span style='font-size:11.5pt;font-family:
"微软雅黑","sans-serif";mso-ascii-font-family:Tahoma;mso-hansi-font-family:Tahoma'>在耐药上和疗效上都要好得多。你们的市场部定位这一产品是一种突破：即它是高血清学转换</span><span
lang=EN-US style='font-size:11.5pt'>,</span><span style='font-size:11.5pt;
font-family:"微软雅黑","sans-serif";mso-ascii-font-family:Tahoma;mso-hansi-font-family:
Tahoma'>高病毒抑制的药物。同时</span><span lang=EN-US style='font-size:11.5pt'>,</span><span
style='font-size:11.5pt;font-family:"微软雅黑","sans-serif";mso-ascii-font-family:
Tahoma;mso-hansi-font-family:Tahoma'>你们为这一产品投入了大量的资源。实践证明</span><span
lang=EN-US style='font-size:11.5pt'>,</span><span style='font-size:11.5pt;
font-family:"微软雅黑","sans-serif";mso-ascii-font-family:Tahoma;mso-hansi-font-family:
Tahoma'>这是一条很成功的战略</span><span lang=EN-US style='font-size:11.5pt'>,“NG”</span><span
style='font-size:11.5pt;font-family:"微软雅黑","sans-serif";mso-ascii-font-family:
Tahoma;mso-hansi-font-family:Tahoma'>是最近两年该领域平稳上升的产品。然而</span><span lang=EN-US
style='font-size:11.5pt'>,</span><span style='font-size:11.5pt;font-family:
"微软雅黑","sans-serif";mso-ascii-font-family:Tahoma;mso-hansi-font-family:Tahoma'>它也承受了来自市场和其他产品的强大压力。目前临床工作中遇到最多的反馈是</span><span
lang=EN-US style='font-size:11.5pt'>“NG”</span><span style='font-size:11.5pt;
font-family:"微软雅黑","sans-serif";mso-ascii-font-family:Tahoma;mso-hansi-font-family:
Tahoma'>的安全性及耐药问题。</span></p>

<p class=MsoNormal><span lang=EN-US><o:p>&nbsp;</o:p></span></p>

<p class=Default style='margin-top:12.0pt;margin-right:0cm;margin-bottom:12.0pt;
margin-left:0cm'><b><span style='font-size:16.0pt'>你的任务 </span></b><span
lang=EN-US style='font-size:16.0pt'><o:p></o:p></span></p>

<p class=Default style='margin-top:12.0pt;margin-right:0cm;margin-bottom:12.0pt;
margin-left:0cm;line-height:24.0pt;mso-line-height-rule:exactly'><span
style='font-size:11.5pt'>在这个案例里我们抽取了其中<span lang=EN-US>12</span>名目标医生：这些医生全部集中在传染科。他们大部分是你的<span
lang=EN-US>ST</span>及<span lang=EN-US>T1</span>客户，占你销量的<span lang=EN-US>80%</span>左右，对你的指标完成非常重要。你的任务是使这<span
lang=EN-US>12</span>位医生的处方量增长<span lang=EN-US>25%</span>，即完成公司的指标。下面采集的是这<span
lang=EN-US>12</span>名医生在去年<span lang=EN-US>12</span>个月里销售数据，以及你今年第一季度的销售指标。供大家参考。
<span lang=EN-US><o:p></o:p></span></span></p>

<p class=Default style='margin-top:12.0pt;margin-right:0cm;margin-bottom:12.0pt;
margin-left:0cm;line-height:24.0pt;mso-line-height-rule:exactly'><!--[if gte vml 1]><v:rect
 id="_x0000_s1026" style='position:absolute;margin-left:-8.25pt;margin-top:12.2pt;
 width:435.75pt;height:2.85pt;flip:y;z-index:1' fillcolor="#1f497d"
 strokecolor="#1f497d"/><![endif]--><![if !vml]><span style='mso-ignore:vglayout;
position:relative;z-index:1;left:-12px;top:15px;width:583px;height:21px'><img
width=583 height=6 src="你所在的公司.files/image001.gif" v:shapes="_x0000_s1026"></span><![endif]><span
lang=EN-US style='font-size:11.5pt'><o:p>&nbsp;</o:p></span></p>

<br style='mso-ignore:vglayout' clear=ALL>

<p class=Default style='margin-top:12.0pt;margin-right:0cm;margin-bottom:12.0pt;
margin-left:0cm;line-height:24.0pt;mso-line-height-rule:exactly'><span
style='font-size:11.5pt'>去年<span lang=EN-US>1-12</span>月<span lang=EN-US>12</span>位医生的销售情况：<span
lang=EN-US><o:p></o:p></span></span></p>

<table class=MsoNormalTable border=1 cellspacing=0 cellpadding=0 width=671
 style='width:503.6pt;margin-left:6.5pt;border-collapse:collapse;border:none;
 mso-border-alt:solid black .5pt;mso-yfti-tbllook:1184;mso-padding-alt:0cm 5.4pt 0cm 5.4pt;
 mso-border-insideh:.5pt solid black;mso-border-insidev:.5pt solid black'>
 <tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes;height:18.85pt'>
  <td width=52 valign=top style='width:38.7pt;border:solid black 1.0pt;
  mso-border-alt:solid black .5pt;padding:0cm 5.4pt 0cm 5.4pt;height:18.85pt'>
  <p class=Default align=center style='margin-top:12.0pt;margin-right:0cm;
  margin-bottom:12.0pt;margin-left:0cm;text-align:center;line-height:5.0pt;
  mso-line-height-rule:exactly'><span lang=EN-US style='font-size:11.0pt;
  font-family:"Calibri","sans-serif";mso-bidi-font-family:Calibri'>Jan</span><span
  lang=EN-US style='font-size:8.0pt'></span></p>
  </td>
  <td width=52 valign=top style='width:38.7pt;border:solid black 1.0pt;
  border-left:none;mso-border-left-alt:solid black .5pt;mso-border-alt:solid black .5pt;
  padding:0cm 5.4pt 0cm 5.4pt;height:18.85pt'>
  <p class=Default align=center style='margin-top:12.0pt;margin-right:0cm;
  margin-bottom:12.0pt;margin-left:0cm;text-align:center;line-height:5.0pt;
  mso-line-height-rule:exactly'><span lang=EN-US style='font-size:11.0pt;
  font-family:"Calibri","sans-serif";mso-bidi-font-family:Calibri'>Feb</span><span
  lang=EN-US style='font-size:8.0pt'><o:p></o:p></span></p>
  </td>
  <td width=52 valign=top style='width:38.7pt;border:solid black 1.0pt;
  border-left:none;mso-border-left-alt:solid black .5pt;mso-border-alt:solid black .5pt;
  padding:0cm 5.4pt 0cm 5.4pt;height:18.85pt'>
  <p class=Default align=center style='margin-top:12.0pt;margin-right:0cm;
  margin-bottom:12.0pt;margin-left:0cm;text-align:center;line-height:5.0pt;
  mso-line-height-rule:exactly'><span lang=EN-US style='font-size:11.0pt;
  font-family:"Calibri","sans-serif";mso-bidi-font-family:Calibri'>Mar</span><span
  lang=EN-US style='font-size:8.0pt'><o:p></o:p></span></p>
  </td>
  <td width=59 valign=top style='width:44.3pt;border:solid black 1.0pt;
  border-left:none;mso-border-left-alt:solid black .5pt;mso-border-alt:solid black .5pt;
  padding:0cm 5.4pt 0cm 5.4pt;height:18.85pt'>
  <p class=Default align=center style='margin-top:12.0pt;margin-right:0cm;
  margin-bottom:12.0pt;margin-left:0cm;text-align:center;line-height:5.0pt;
  mso-line-height-rule:exactly'><span lang=EN-US style='font-size:11.0pt;
  font-family:"Calibri","sans-serif";mso-bidi-font-family:Calibri'>Apr</span><span
  lang=EN-US style='font-size:8.0pt'><o:p></o:p></span></p>
  </td>
  <td width=59 valign=top style='width:44.3pt;border:solid black 1.0pt;
  border-left:none;mso-border-left-alt:solid black .5pt;mso-border-alt:solid black .5pt;
  padding:0cm 5.4pt 0cm 5.4pt;height:18.85pt'>
  <p class=Default align=center style='margin-top:12.0pt;margin-right:0cm;
  margin-bottom:12.0pt;margin-left:0cm;text-align:center;line-height:5.0pt;
  mso-line-height-rule:exactly'><span lang=EN-US style='font-size:11.0pt;
  font-family:"Calibri","sans-serif";mso-bidi-font-family:Calibri'>May</span><span
  lang=EN-US style='font-size:8.0pt'><o:p></o:p></span></p>
  </td>
  <td width=52 valign=top style='width:38.7pt;border:solid black 1.0pt;
  border-left:none;mso-border-left-alt:solid black .5pt;mso-border-alt:solid black .5pt;
  padding:0cm 5.4pt 0cm 5.4pt;height:18.85pt'>
  <p class=Default align=center style='margin-top:12.0pt;margin-right:0cm;
  margin-bottom:12.0pt;margin-left:0cm;text-align:center;line-height:5.0pt;
  mso-line-height-rule:exactly'><span lang=EN-US style='font-size:11.0pt;
  font-family:"Calibri","sans-serif";mso-bidi-font-family:Calibri'>Jun</span><span
  lang=EN-US style='font-size:8.0pt'><o:p></o:p></span></p>
  </td>
  <td width=52 valign=top style='width:38.7pt;border:solid black 1.0pt;
  border-left:none;mso-border-left-alt:solid black .5pt;mso-border-alt:solid black .5pt;
  padding:0cm 5.4pt 0cm 5.4pt;height:18.85pt'>
  <p class=Default align=center style='margin-top:12.0pt;margin-right:0cm;
  margin-bottom:12.0pt;margin-left:0cm;text-align:center;line-height:5.0pt;
  mso-line-height-rule:exactly'><span lang=EN-US style='font-size:11.0pt;
  font-family:"Calibri","sans-serif";mso-bidi-font-family:Calibri'>Jul</span><span
  lang=EN-US style='font-size:8.0pt'><o:p></o:p></span></p>
  </td>
  <td width=59 valign=top style='width:44.3pt;border:solid black 1.0pt;
  border-left:none;mso-border-left-alt:solid black .5pt;mso-border-alt:solid black .5pt;
  padding:0cm 5.4pt 0cm 5.4pt;height:18.85pt'>
  <p class=Default align=center style='margin-top:12.0pt;margin-right:0cm;
  margin-bottom:12.0pt;margin-left:0cm;text-align:center;line-height:5.0pt;
  mso-line-height-rule:exactly'><span lang=EN-US style='font-size:11.0pt;
  font-family:"Calibri","sans-serif";mso-bidi-font-family:Calibri'>Aug</span><span
  lang=EN-US style='font-size:8.0pt'><o:p></o:p></span></p>
  </td>
  <td width=59 valign=top style='width:49.3pt;border:solid black 1.0pt;
  border-left:none;mso-border-left-alt:solid black .5pt;mso-border-alt:solid black .5pt;
  padding:0cm 5.4pt 0cm 5.4pt;height:18.85pt'>
  <p class=Default align=center style='margin-top:12.0pt;margin-right:0cm;
  margin-bottom:12.0pt;margin-left:0cm;text-align:center;line-height:5.0pt;
  mso-line-height-rule:exactly'><span lang=EN-US style='font-size:11.0pt;
  font-family:"Calibri","sans-serif";mso-bidi-font-family:Calibri'>Sep</span><span
  lang=EN-US style='font-size:8.0pt'><o:p></o:p></span></p>
  </td>
  <td width=59 valign=top style='width:44.3pt;border:solid black 1.0pt;
  border-left:none;mso-border-left-alt:solid black .5pt;mso-border-alt:solid black .5pt;
  padding:0cm 5.4pt 0cm 5.4pt;height:18.85pt'>
  <p class=Default align=center style='margin-top:12.0pt;margin-right:0cm;
  margin-bottom:12.0pt;margin-left:0cm;text-align:center;line-height:5.0pt;
  mso-line-height-rule:exactly'><span lang=EN-US style='font-size:11.0pt;
  font-family:"Calibri","sans-serif";mso-bidi-font-family:Calibri'>Oct</span><span
  lang=EN-US style='font-size:8.0pt'><o:p></o:p></span></p>
  </td>
  <td width=59 valign=top style='width:44.3pt;border:solid black 1.0pt;
  border-left:none;mso-border-left-alt:solid black .5pt;mso-border-alt:solid black .5pt;
  padding:0cm 5.4pt 0cm 5.4pt;height:18.85pt'>
  <p class=Default align=center style='margin-top:12.0pt;margin-right:0cm;
  margin-bottom:12.0pt;margin-left:0cm;text-align:center;line-height:5.0pt;
  mso-line-height-rule:exactly'><span lang=EN-US style='font-size:11.0pt;
  font-family:"Calibri","sans-serif";mso-bidi-font-family:Calibri'>Nov</span><span
  lang=EN-US style='font-size:8.0pt'><o:p></o:p></span></p>
  </td>
  <td width=59 valign=top style='width:44.3pt;border:solid black 1.0pt;
  border-left:none;mso-border-left-alt:solid black .5pt;mso-border-alt:solid black .5pt;
  padding:0cm 5.4pt 0cm 5.4pt;height:18.85pt'>
  <p class=Default align=center style='margin-top:12.0pt;margin-right:0cm;
  margin-bottom:12.0pt;margin-left:0cm;text-align:center;line-height:5.0pt;
  mso-line-height-rule:exactly'><span lang=EN-US style='font-size:11.0pt;
  font-family:"Calibri","sans-serif";mso-bidi-font-family:Calibri'>Dec</span><span
  lang=EN-US style='font-size:8.0pt'><o:p></o:p></span></p>
  </td>
 </tr>
 <tr style='mso-yfti-irow:1;mso-yfti-lastrow:yes;height:27.05pt'>
  <td width=52 valign=top style='width:38.7pt;border:solid black 1.0pt;
  border-top:none;mso-border-top-alt:solid black .5pt;mso-border-alt:solid black .5pt;
  padding:0cm 5.4pt 0cm 5.4pt;height:27.05pt'>
  <p class=Default align=center style='margin-top:12.0pt;margin-right:0cm;
  margin-bottom:12.0pt;margin-left:0cm;text-align:center;line-height:5.0pt;
  mso-line-height-rule:exactly'><span lang=EN-US style='font-size:11.0pt;
  font-family:"Calibri","sans-serif";mso-bidi-font-family:Calibri'>89774</span><span
  lang=EN-US style='font-size:8.0pt'><o:p></o:p></span></p>
  </td>
  <td width=52 valign=top style='width:38.7pt;border-top:none;border-left:none;
  border-bottom:solid black 1.0pt;border-right:solid black 1.0pt;mso-border-top-alt:
  solid black .5pt;mso-border-left-alt:solid black .5pt;mso-border-alt:solid black .5pt;
  padding:0cm 5.4pt 0cm 5.4pt;height:27.05pt'>
  <p class=Default align=center style='margin-top:12.0pt;margin-right:0cm;
  margin-bottom:12.0pt;margin-left:0cm;text-align:center;line-height:5.0pt;
  mso-line-height-rule:exactly'><span lang=EN-US style='font-size:11.0pt;
  font-family:"Calibri","sans-serif";mso-bidi-font-family:Calibri'>89774</span><span
  lang=EN-US style='font-size:8.0pt'><o:p></o:p></span></p>
  </td>
  <td width=52 valign=top style='width:38.7pt;border-top:none;border-left:none;
  border-bottom:solid black 1.0pt;border-right:solid black 1.0pt;mso-border-top-alt:
  solid black .5pt;mso-border-left-alt:solid black .5pt;mso-border-alt:solid black .5pt;
  padding:0cm 5.4pt 0cm 5.4pt;height:27.05pt'>
  <p class=Default align=center style='margin-top:12.0pt;margin-right:0cm;
  margin-bottom:12.0pt;margin-left:0cm;text-align:center;line-height:5.0pt;
  mso-line-height-rule:exactly'><span lang=EN-US style='font-size:11.0pt;
  font-family:"Calibri","sans-serif";mso-bidi-font-family:Calibri'>95583</span><span
  lang=EN-US style='font-size:8.0pt'><o:p></o:p></span></p>
  </td>
  <td width=59 valign=top style='width:44.3pt;border-top:none;border-left:none;
  border-bottom:solid black 1.0pt;border-right:solid black 1.0pt;mso-border-top-alt:
  solid black .5pt;mso-border-left-alt:solid black .5pt;mso-border-alt:solid black .5pt;
  padding:0cm 5.4pt 0cm 5.4pt;height:27.05pt'>
  <p class=Default align=center style='margin-top:12.0pt;margin-right:0cm;
  margin-bottom:12.0pt;margin-left:0cm;text-align:center;line-height:5.0pt;
  mso-line-height-rule:exactly'><span lang=EN-US style='font-size:11.0pt;
  font-family:"Calibri","sans-serif";mso-bidi-font-family:Calibri'>100588</span><span
  lang=EN-US style='font-size:8.0pt'><o:p></o:p></span></p>
  </td>
  <td width=59 valign=top style='width:44.3pt;border-top:none;border-left:none;
  border-bottom:solid black 1.0pt;border-right:solid black 1.0pt;mso-border-top-alt:
  solid black .5pt;mso-border-left-alt:solid black .5pt;mso-border-alt:solid black .5pt;
  padding:0cm 5.4pt 0cm 5.4pt;height:27.05pt'>
  <p class=Default align=center style='margin-top:12.0pt;margin-right:0cm;
  margin-bottom:12.0pt;margin-left:0cm;text-align:center;line-height:5.0pt;
  mso-line-height-rule:exactly'><span lang=EN-US style='font-size:11.0pt;
  font-family:"Calibri","sans-serif";mso-bidi-font-family:Calibri'>100588</span><span
  lang=EN-US style='font-size:8.0pt'><o:p></o:p></span></p>
  </td>
  <td width=52 valign=top style='width:38.7pt;border-top:none;border-left:none;
  border-bottom:solid black 1.0pt;border-right:solid black 1.0pt;mso-border-top-alt:
  solid black .5pt;mso-border-left-alt:solid black .5pt;mso-border-alt:solid black .5pt;
  padding:0cm 5.4pt 0cm 5.4pt;height:27.05pt'>
  <p class=Default align=center style='margin-top:12.0pt;margin-right:0cm;
  margin-bottom:12.0pt;margin-left:0cm;text-align:center;line-height:5.0pt;
  mso-line-height-rule:exactly'><span lang=EN-US style='font-size:11.0pt;
  font-family:"Calibri","sans-serif";mso-bidi-font-family:Calibri'>13466</span><b
  style='mso-bidi-font-weight:normal'><span lang=EN-US style='font-size:8.0pt'><o:p></o:p></span></b></p>
  </td>
  <td width=52 valign=top style='width:38.7pt;border-top:none;border-left:none;
  border-bottom:solid black 1.0pt;border-right:solid black 1.0pt;mso-border-top-alt:
  solid black .5pt;mso-border-left-alt:solid black .5pt;mso-border-alt:solid black .5pt;
  padding:0cm 5.4pt 0cm 5.4pt;height:27.05pt'>
  <p class=Default align=center style='margin-top:12.0pt;margin-right:0cm;
  margin-bottom:12.0pt;margin-left:0cm;text-align:center;line-height:5.0pt;
  mso-line-height-rule:exactly'><span lang=EN-US style='font-size:11.0pt;
  font-family:"Calibri","sans-serif";mso-bidi-font-family:Calibri'>89774</span><span
  lang=EN-US style='font-size:8.0pt'><o:p></o:p></span></p>
  </td>
  <td width=59 valign=top style='width:44.3pt;border-top:none;border-left:none;
  border-bottom:solid black 1.0pt;border-right:solid black 1.0pt;mso-border-top-alt:
  solid black .5pt;mso-border-left-alt:solid black .5pt;mso-border-alt:solid black .5pt;
  padding:0cm 5.4pt 0cm 5.4pt;height:27.05pt'>
  <p class=Default align=center style='margin-top:12.0pt;margin-right:0cm;
  margin-bottom:12.0pt;margin-left:0cm;text-align:center;line-height:5.0pt;
  mso-line-height-rule:exactly'><span lang=EN-US style='font-size:11.0pt;
  font-family:"Calibri","sans-serif";mso-bidi-font-family:Calibri'>120066</span><span
  lang=EN-US style='font-size:8.0pt'><o:p></o:p></span></p>
  </td>
  <td width=59 valign=top style='width:49.3pt;border-top:none;border-left:none;
  border-bottom:solid black 1.0pt;border-right:solid black 1.0pt;mso-border-top-alt:
  solid black .5pt;mso-border-left-alt:solid black .5pt;mso-border-alt:solid black .5pt;
  padding:0cm 5.4pt 0cm 5.4pt;height:27.05pt'>
  <p class=Default align=center style='margin-top:12.0pt;margin-right:0cm;
  margin-bottom:12.0pt;margin-left:0cm;text-align:center;line-height:5.0pt;
  mso-line-height-rule:exactly'><span lang=EN-US style='font-size:11.0pt;
  font-family:"Calibri","sans-serif";mso-bidi-font-family:Calibri'>148326</span><span
  lang=EN-US style='font-size:8.0pt'><o:p></o:p></span></p>
  </td>
  <td width=59 valign=top style='width:44.3pt;border-top:none;border-left:none;
  border-bottom:solid black 1.0pt;border-right:solid black 1.0pt;mso-border-top-alt:
  solid black .5pt;mso-border-left-alt:solid black .5pt;mso-border-alt:solid black .5pt;
  padding:0cm 5.4pt 0cm 5.4pt;height:27.05pt'>
  <p class=Default align=center style='margin-top:12.0pt;margin-right:0cm;
  margin-bottom:12.0pt;margin-left:0cm;text-align:center;line-height:5.0pt;
  mso-line-height-rule:exactly'><span lang=EN-US style='font-size:11.0pt;
  font-family:"Calibri","sans-serif";mso-bidi-font-family:Calibri'>100588</span><span
  lang=EN-US style='font-size:8.0pt'><o:p></o:p></span></p>
  </td>
  <td width=59 valign=top style='width:44.3pt;border-top:none;border-left:none;
  border-bottom:solid black 1.0pt;border-right:solid black 1.0pt;mso-border-top-alt:
  solid black .5pt;mso-border-left-alt:solid black .5pt;mso-border-alt:solid black .5pt;
  padding:0cm 5.4pt 0cm 5.4pt;height:27.05pt'>
  <p class=Default align=center style='margin-top:12.0pt;margin-right:0cm;
  margin-bottom:12.0pt;margin-left:0cm;text-align:center;line-height:5.0pt;
  mso-line-height-rule:exactly'><span lang=EN-US style='font-size:11.0pt;
  font-family:"Calibri","sans-serif";mso-bidi-font-family:Calibri'>134661</span><span
  lang=EN-US style='font-size:8.0pt'><o:p></o:p></span></p>
  </td>
  <td width=59 valign=top style='width:44.3pt;border-top:none;border-left:none;
  border-bottom:solid black 1.0pt;border-right:solid black 1.0pt;mso-border-top-alt:
  solid black .5pt;mso-border-left-alt:solid black .5pt;mso-border-alt:solid black .5pt;
  padding:0cm 5.4pt 0cm 5.4pt;height:27.05pt'>
  <p class=Default align=center style='margin-top:12.0pt;margin-right:0cm;
  margin-bottom:12.0pt;margin-left:0cm;text-align:center;line-height:5.0pt;
  mso-line-height-rule:exactly'><span lang=EN-US style='font-size:11.0pt;
  font-family:"Calibri","sans-serif";mso-bidi-font-family:Calibri'>134661</span><span
  lang=EN-US style='font-size:8.0pt'><o:p></o:p></span></p>
  </td>
 </tr>
</table>

<p class=Default style='margin-top:12.0pt;margin-right:0cm;margin-bottom:12.0pt;
margin-left:0cm;line-height:24.0pt;mso-line-height-rule:exactly'><b
style='mso-bidi-font-weight:normal'><span style='font-size:11.5pt'>今年</span></b><span
lang=EN-US style='font-size:11.5pt'>1-3</span><span style='font-size:11.5pt'>月份的指标<span
lang=EN-US>,</span>每月相同为<span lang=EN-US>:210,408</span>元<span lang=EN-US><o:p></o:p></span></span></p>

<p class=MsoNormal><span lang=EN-US><o:p>&nbsp;</o:p></span></p>

</div>

			
			 </div>  
		 </div>
      </div>
      <div class="quyu l">
	      
      </div>
      <div class="c"></div>
   </div>
  
	
	 
   </div> 
 </body>
</html>
<script type="text/javascript">
<!--
 //document.getElementById("setDivHeight").style.height=document.body.clientHeight-133;
//-->
</script>
