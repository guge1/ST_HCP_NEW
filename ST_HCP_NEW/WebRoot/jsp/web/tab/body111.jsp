
<%@ page contentType="text/html; charset=GBK"%>
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

		<title>ST_HCP_NEW区域管理实战模拟实战系统</title>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />

		<base target="_self">
		<link rel="stylesheet" type="text/css" href="skin/css/base.css" />
		<link rel="stylesheet" type="text/css" href="skin/css/main.css" />
		<script src="<%=basePath%>jsp/Market/js/WinOpen.js"
			type="text/javascript">
</script>
	</head>
	<body leftmargin="8" topmargin='8'>
		<table width="100%" align="center" border="0" cellpadding="4"
			cellspacing="1" bgcolor="#CBD8AC" style="margin-bottom: 8px">
			<tr>
				<td colspan="2" background="skin/images/frame/wbg.gif"
					bgcolor="#EEF4EA" class='title'>
					<div style='float: left'>
						<span style="font-weight: bold; font-size: 16px; color: #FE8802;">参数设置</span>
					</div>
					<div style='float: right; padding-right: 10px;'>
					</div>
				</td>
			</tr>
			<tr bgcolor="#FFFFFF">
				<td height="30" colspan="2" align="center" valign="bottom">
					<table width="100%" border="0" cellspacing="1" cellpadding="1">
						<tr>
							<td width="30px" height="31" align="center">
								<img src="skin/images/frame/qc.gif" width="90" height="30" />
							</td>
							<td width="*" valign="bottom">
								<div class='icoitem'
									onclick="javascript:g_OpenModalReturnWindow('<%=basePath%>getMarketInfo_1.action',800,560);">
									<div class='ico'>
										<img src='skin/images/frame/addnews.gif' width='16'
											height='16' />
									</div>
									<div class='txt'>
										<a href='#'><u>医院销售趋势</u> </a>
									</div>
								</div>
								<div class='icoitem'
									onclick="javascript:g_OpenModalReturnWindow('<%=basePath%>queryZhiBiaoInfo.action',840,500);">
									<div class='ico'>
										<img src='skin/images/frame/menuarrow.gif' width='16'
											height='16' />
									</div>
									<div class='txt'>
										<a href='#'><u>指标参数</u> </a>
									</div>
								</div>
								<div class='icoitem'
									onclick="javascript:g_OpenModalReturnWindow('<%=basePath%>queryZiyuanInfo.action',680,320);">
									<div class='ico'>
										<img src='skin/images/frame/manage1.gif' width='16'
											height='16' />
									</div>
									<div class='txt'>
										<a href='#'><u>资源</u> </a>
									</div>
								</div>

								<div style="display: none;">
									<div class='icoitem'>
										<div class='ico'>
											<img src='skin/images/frame/file_dir.gif' width='16'
												height='16' />
										</div>
										<div class='txt'>
											<a href=''><u>栏目管理</u> </a>
										</div>
									</div>
									<div class='icoitem'>
										<div class='ico'>
											<img src='skin/images/frame/part-index.gif' width='16'
												height='16' />
										</div>
										<div class='txt'>
											<a href=''><u>更新系统缓存</u> </a>
										</div>
									</div>
									<div class='icoitem'>
										<div class='ico'>
											<img src='skin/images/frame/manage1.gif' width='16'
												height='16' />
										</div>
										<div class='txt'>
											<a href=''><u>修改系统参数</u> </a>
										</div>
									</div>
								</div>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
		<table width="100%" align="center" border="0" cellpadding="3"
			cellspacing="1" bgcolor="#CBD8AC"
			style="margin-bottom: 8px; margin-top: 8px;">
			<tr>
				<td background="skin/images/frame/wbg.gif" bgcolor="#EEF4EA"
					class='title'>
					<span style="font-weight: bold; font-size: 16px; color: #FE8802;">代表现状信息</span>
				</td>
			</tr>
			<tr bgcolor="#FFFFFF">
				<td>
					<div id="setDivHeight"
						style="height: expression(document.body.clientHeight-133); overflow: auto;">

						<div class=WordSection1>

							<p class=MsoNormal>
								<a name="_Toc320184195"><b><span
										style='font-family: 宋体; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>公司简介</span>
								</b>
								</a><b><span lang=EN-US><o:p></o:p>
								</span>
								</b>
							</p>

							<p class=MsoNormal>
								<span
									style='font-family: 宋体; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>你所在的公司</span><span
									lang=EN-US>---“N”</span><span
									style='font-family: 宋体; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>制药公司，在制药业拥有一段辉煌的历史。公司的前身在十九世纪就已经开始了商业活动，并于上世纪初就已经进入中国市场。几经并购，公司已经在全球市场占据了相当的地位，位列世界</span><span
									lang=EN-US>500</span><span
									style='font-family: 宋体; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>强。目前，在医药领域，处方药是该公司主要经营的业务。公司的总部在欧洲，同时在世界各地都有分支机构和业务活动。你的责任是销售治疗心血管类药物的一个重要产品</span><span
									lang=EN-US>——“ND”</span><span
									style='font-family: 宋体; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>。</span>
							</p>

							<p class=MsoNormal>
								<span
									style='font-family: 宋体; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>市场部要求</span><span
									lang=EN-US>ND</span><span
									style='font-family: 宋体; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>今年的主要科室为心内、肾内及内分泌科。</span>
							</p>

							<p class=MsoNormal>
								<span lang=EN-US></span><span
									style='font-family: 宋体; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>心血管药物的处方量很大，医院等级越高处方量越大，这是由病人量决定的。在基层医疗单位也有相当的使用量。由于面对的人群非常庞大，相对其他药物而言，这一类药物总体价格敏感度不大，虽然这一情况正在随着仿制药的出现而发生变化。总体而言，心血管类药物的治疗人群越来越多，这类药物的总销量呈增长趋势</span>
								<span
									style='font-family: 宋体; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>。该类产品通常针对慢性疾病，往往患者会终身服药。</span>
							</p>

							<p class=MsoNormal>
								<a name="_Toc320184196"><b><span
										style='font-family: 宋体; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>区域简介</span>
								</b>
								</a><b><span lang=EN-US><o:p></o:p>
								</span>
								</b>
							</p>

							<p class=MsoNormal>
								<span
									style='font-family: 宋体; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>你所接手的医院是一家大型的三甲综合医院，客户数量多、竞争产品多。你的目标科室是心内科、肾内科及内分泌科，每个科室各有特点。今年公司对于</span><span
									lang=EN-US>ND</span><span
									style='font-family: 宋体; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>产品寄予厚望，年指标的增长率为</span><span
									lang=EN-US>25%</span><span
									style='font-family: 宋体; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>。同时你的老板对你充满期望和信心，你的区域对整个团队达成目标非常关键，所以你只能成功不能失败</span>
							</p>

							<p class=MsoNormal>
								<a name="_Toc320184197"><b><span
										style='font-family: 宋体; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>竞争产品介绍</span>
								</b>
								</a><b><span lang=EN-US><o:p></o:p>
								</span>
								</b>
							</p>

							<p class=MsoNormal>
								<span
									style='font-family: 宋体; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma; mso-bidi-font-weight: bold'>你有三个主要竞争对手</span><span
									lang=EN-US style='mso-bidi-font-weight: bold'>:</span>
							</p>

							<p class=MsoNormal>
								<span lang=EN-US style='mso-bidi-font-weight: bold'>“P公司”</span>
							</p>

							<p class=MsoNormal>
								<span
									style='font-family: 宋体; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>这家公司是一家美国企业，在全球医药企业排名位列前三。他们的产品</span><span
									lang=EN-US>“PL”</span><span
									style='font-family: 宋体; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>是同类产品中首先上市的药物。该产品曾经有很长一段时间处于市场领先地位，当时公司相当大的销售都来源于这一产品，公司每年在这个产品上投入巨大。然而，当</span><span
									lang=EN-US>“ND”</span><span
									style='font-family: 宋体; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>上市</span>
								<span
									style='font-family: 宋体; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>后，由于这一产品的疗效明显优于</span><span
									lang=EN-US>“PL”, “PL”</span><span
									style='font-family: 宋体; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>的市场销售开始受到影响。同时，同类产品开始大量上市，</span><span
									lang=EN-US>“PL”</span><span
									style='font-family: 宋体; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>开始逐渐失去市场份额。基于这种现状，其主打卖点转向为：更长时间的临床验证，更好的临床使用经验。</span>
								<span
									style='font-family: 宋体; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>同时，公司仍然在强劲推广</span><span
									lang=EN-US>“PL”,</span><span
									style='font-family: 宋体; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>毕竟这个市场还是相当巨大的。但是</span><span
									lang=EN-US>,P</span><span
									style='font-family: 宋体; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>公司面临一件很尴尬的事情——“</span><span
									lang=EN-US>PL”</span><span
									style='font-family: 宋体; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>的专利期一年前到期。从那时起，大量仿制品进入市场，价格很低，进一步导致其销售额下降。</span>
							</p>

							<p class=MsoNormal>
								<span lang=EN-US style='mso-bidi-font-weight: bold'>“E公司”</span>
							</p>

							<p class=MsoNormal>
								<span lang=EN-US>E</span><span
									style='font-family: 宋体; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>公司是一家以购买其他厂家成熟产品进行整合市场销售的营销公司。这家公司有很好的销售网络和很好的临床促销队伍。他们的产品</span><span
									lang=EN-US>“EH”</span><span
									style='font-family: 宋体; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>在市场上销售了一段时间了，有相当的市场占有率，目前总销售好于</span><span
									lang=EN-US>“ND”</span><span
									style='font-family: 宋体; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>。</span>
							</p>

							<p class=MsoNormal>
								<span lang=EN-US style='mso-bidi-font-weight: bold'>“L公司”</span>
							</p>

							<p class=MsoNormal>
								<span lang=EN-US>L</span><span
									style='font-family: 宋体; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>公司是一家生产仿制药的生产销售企业。他们最近上市了</span><span
									lang=EN-US>“LH”</span><span
									style='font-family: 宋体; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>，即</span><span
									lang=EN-US>“PL”</span><span
									style='font-family: 宋体; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>的仿制品。由于市场竞争激烈，目前这家公司的销售处于起步阶段，销售存在很大的地区差异。</span>
							</p>

							<p class=MsoNormal>
								<span lang=EN-US>“EH”</span><span
									style='font-family: 宋体; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>和</span><span
									lang=EN-US>“ND”</span><span
									style='font-family: 宋体; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>被认为是第二代心血管产品。相对第一代产品“</span><span
									lang=EN-US>PL”</span><span
									style='font-family: 宋体; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>而言，这两种产品在安全性和疗效上都要好得多。但当</span><span
									lang=EN-US>“ND”</span><span
									style='font-family: 宋体; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>上市时，</span><span
									lang=EN-US>P</span><span
									style='font-family: 宋体; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>公司公司认为这一产品只是</span><span
									lang=EN-US>“PL”</span><span
									style='font-family: 宋体; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>的衍生产品。但我们的市场部定位这一产品是一种突破：即它是第一个持久地体现了高安全度，更好疗效，更方便使用的三位一体特征的药物。同时，我们为这一产品投入了大量的资源。实践证明，这是一条很成功的战略，</span><span
									lang=EN-US>“ND”</span><span
									style='font-family: 宋体; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>是最近两年该领域上升最快的心血管类产品。然而，它也承受了来自市场和其他产品的强大压力。目前临床工作中遇到最多的反馈是</span><span
									lang=EN-US>“ND”</span><span
									style='font-family: 宋体; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>的价格比较高，比其它同类产品高出</span><span
									lang=EN-US>30%</span><span
									style='font-family: 宋体; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>，患者接受有一定难度。</span><span
									lang=EN-US>&nbsp;</span>
							</p>

							<b><span lang=EN-US
								style='font-size: 11.0pt; font-family: Tahoma; mso-fareast-font-family: 宋体; mso-bidi-font-family: "Times New Roman"; mso-ansi-language: EN-US; mso-fareast-language: ZH-CN; mso-bidi-language: AR-SA'><br
										clear=all style='page-break-before: always'> </span>
							</b>

							<p class=MsoNormal>
								<a name="_Toc320184198"><b><span
										style='font-family: 宋体; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>你的任务</span>
								</b>
								</a><b><span lang=EN-US><o:p></o:p>
								</span>
								</b>
							</p>

							<p class=MsoNormal>
								<span
									style='font-family: 宋体; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>在这个案例里我们抽取了其中</span><span
									lang=EN-US>12</span><span
									style='font-family: 宋体; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>名目标医生：其中心内科</span><span
									lang=EN-US>5</span><span
									style='font-family: 宋体; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>名、肾内科</span><span
									lang=EN-US>4</span><span
									style='font-family: 宋体; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>名、内分泌科</span><span
									lang=EN-US>3</span><span
									style='font-family: 宋体; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>名。他们大部分是你的</span><span
									lang=EN-US>ST</span><span
									style='font-family: 宋体; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>及</span><span
									lang=EN-US>T1</span><span
									style='font-family: 宋体; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>客户，对你的指标完成非常重要。你的任务是使这</span><span
									lang=EN-US>12</span><span
									style='font-family: 宋体; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>位医生的处方量增长</span><span
									lang=EN-US>20%,</span><span
									style='font-family: 宋体; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>即完成公司的指标。下面采集的是根据这</span><span
									lang=EN-US>12</span><span
									style='font-family: 宋体; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>名医生的状况推测出的去年</span><span
									lang=EN-US>12</span><span
									style='font-family: 宋体; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>个月里与这</span><span
									lang=EN-US>12</span><span
									style='font-family: 宋体; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>名医生相关的销售数据，以及你今年第一季度的销售指标。供大家参考。</span>
							</p>

							<table class=MsoNormalTable border=1 cellspacing=0 cellpadding=0
								width=756 style='width: 567.2pt;'>
								<tr style='height: 15.0pt'>
									<td>
										1
									</td>
									<td>
										2
									</td>
									<td>
										3
									</td>
									<td>
										4
									</td>
									<td>
										5
									</td>
									<td>
										6
									</td>
									<td>
										7
									</td>
									<td>
										8
									</td>
									<td>
										9
									</td>
									<td>
										10
									</td>
									<td>
										11
									</td>
									<td>
										12
									</td>
								</tr>
								<tr
									style='mso-yfti-irow: 1; mso-yfti-lastrow: yes; height: 16.0pt'>
									<td>
										132883 											
										
									</td>
									<td>
										109428
									</td>
									<td>
										148545
									</td>
									<td>
										130956
									</td>
									<td>
										143428
									</td>
									<td>
										137192
									</td>
									<td>
										151815
									</td>
									<td>
										153125
									</td>
									<td>
										168216
									</td>
									<td>
										161982
									</td>
									<td>
										168683
									</td>
									<td>
										184056
									</td>
								</tr>
							</table>

							<p class=MsoNormal>
								<span lang=EN-US><o:p>&nbsp;</o:p>
								</span>
							</p>

							<p class=MsoNormal>
								<span lang=EN-US>2012</span><span
									style='font-family: 宋体; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>年的</span><span
									lang=EN-US>1-3</span><span
									style='font-family: 宋体; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>月指标相同</span><span
									lang=EN-US>,</span><span
									style='font-family: 宋体; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>都是每月</span><span
									lang=EN-US>290581</span><span
									style='font-family: 宋体; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>元</span>
							</p>

							<b><span lang=EN-US
								style='font-size: 11.0pt; font-family: Tahoma; mso-fareast-font-family: 宋体; mso-bidi-font-family: "Times New Roman"; mso-ansi-language: EN-US; mso-fareast-language: ZH-CN; mso-bidi-language: AR-SA'><br
										clear=all style='page-break-before: always'> </span>
							</b>


						</div>

					</div>
				</td>
			</tr>
		</table>

	</body>
</html>
<script type="text/javascript">
	document.getElementById("setDivHeight").style.height = document.body.clientHeight - 133;
	//-->
</script>
