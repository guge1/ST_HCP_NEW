
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

		<title>ST_HCP_NEW�������ʵսģ��ʵսϵͳ</title>
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
						<span style="font-weight: bold; font-size: 16px; color: #FE8802;">��������</span>
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
										<a href='#'><u>ҽԺ��������</u> </a>
									</div>
								</div>
								<div class='icoitem'
									onclick="javascript:g_OpenModalReturnWindow('<%=basePath%>queryZhiBiaoInfo.action',840,500);">
									<div class='ico'>
										<img src='skin/images/frame/menuarrow.gif' width='16'
											height='16' />
									</div>
									<div class='txt'>
										<a href='#'><u>ָ�����</u> </a>
									</div>
								</div>
								<div class='icoitem'
									onclick="javascript:g_OpenModalReturnWindow('<%=basePath%>queryZiyuanInfo.action',680,320);">
									<div class='ico'>
										<img src='skin/images/frame/manage1.gif' width='16'
											height='16' />
									</div>
									<div class='txt'>
										<a href='#'><u>��Դ</u> </a>
									</div>
								</div>

								<div style="display: none;">
									<div class='icoitem'>
										<div class='ico'>
											<img src='skin/images/frame/file_dir.gif' width='16'
												height='16' />
										</div>
										<div class='txt'>
											<a href=''><u>��Ŀ����</u> </a>
										</div>
									</div>
									<div class='icoitem'>
										<div class='ico'>
											<img src='skin/images/frame/part-index.gif' width='16'
												height='16' />
										</div>
										<div class='txt'>
											<a href=''><u>����ϵͳ����</u> </a>
										</div>
									</div>
									<div class='icoitem'>
										<div class='ico'>
											<img src='skin/images/frame/manage1.gif' width='16'
												height='16' />
										</div>
										<div class='txt'>
											<a href=''><u>�޸�ϵͳ����</u> </a>
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
					<span style="font-weight: bold; font-size: 16px; color: #FE8802;">������״��Ϣ</span>
				</td>
			</tr>
			<tr bgcolor="#FFFFFF">
				<td>
					<div id="setDivHeight"
						style="height: expression(document.body.clientHeight-133); overflow: auto;">

						<div class=WordSection1>

							<p class=MsoNormal>
								<a name="_Toc320184195"><b><span
										style='font-family: ����; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>��˾���</span>
								</b>
								</a><b><span lang=EN-US><o:p></o:p>
								</span>
								</b>
							</p>

							<p class=MsoNormal>
								<span
									style='font-family: ����; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>�����ڵĹ�˾</span><span
									lang=EN-US>---��N��</span><span
									style='font-family: ����; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>��ҩ��˾������ҩҵӵ��һ�λԻ͵���ʷ����˾��ǰ����ʮ�����;��Ѿ���ʼ����ҵ������������ͳ����Ѿ������й��г���������������˾�Ѿ���ȫ���г�ռ�����൱�ĵ�λ��λ������</span><span
									lang=EN-US>500</span><span
									style='font-family: ����; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>ǿ��Ŀǰ����ҽҩ���򣬴���ҩ�Ǹù�˾��Ҫ��Ӫ��ҵ�񡣹�˾���ܲ���ŷ�ޣ�ͬʱ��������ض��з�֧������ҵ�����������������������Ѫ����ҩ���һ����Ҫ��Ʒ</span><span
									lang=EN-US>������ND��</span><span
									style='font-family: ����; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>��</span>
							</p>

							<p class=MsoNormal>
								<span
									style='font-family: ����; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>�г���Ҫ��</span><span
									lang=EN-US>ND</span><span
									style='font-family: ����; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>�������Ҫ����Ϊ���ڡ����ڼ��ڷ��ڿơ�</span>
							</p>

							<p class=MsoNormal>
								<span lang=EN-US></span><span
									style='font-family: ����; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>��Ѫ��ҩ��Ĵ������ܴ�ҽԺ�ȼ�Խ�ߴ�����Խ�������ɲ����������ġ��ڻ���ҽ�Ƶ�λҲ���൱��ʹ������������Ե���Ⱥ�ǳ��Ӵ��������ҩ����ԣ���һ��ҩ������۸����жȲ�����Ȼ��һ����������ŷ���ҩ�ĳ��ֶ������仯��������ԣ���Ѫ����ҩ���������ȺԽ��Խ�࣬����ҩ�������������������</span>
								<span
									style='font-family: ����; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>�������Ʒͨ��������Լ������������߻������ҩ��</span>
							</p>

							<p class=MsoNormal>
								<a name="_Toc320184196"><b><span
										style='font-family: ����; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>������</span>
								</b>
								</a><b><span lang=EN-US><o:p></o:p>
								</span>
								</b>
							</p>

							<p class=MsoNormal>
								<span
									style='font-family: ����; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>�������ֵ�ҽԺ��һ�Ҵ��͵������ۺ�ҽԺ���ͻ������ࡢ������Ʒ�ࡣ���Ŀ����������ڿơ����ڿƼ��ڷ��ڿƣ�ÿ�����Ҹ����ص㡣���깫˾����</span><span
									lang=EN-US>ND</span><span
									style='font-family: ����; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>��Ʒ�����������ָ���������Ϊ</span><span
									lang=EN-US>25%</span><span
									style='font-family: ����; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>��ͬʱ����ϰ����������������ģ��������������ŶӴ��Ŀ��ǳ��ؼ���������ֻ�ܳɹ�����ʧ��</span>
							</p>

							<p class=MsoNormal>
								<a name="_Toc320184197"><b><span
										style='font-family: ����; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>������Ʒ����</span>
								</b>
								</a><b><span lang=EN-US><o:p></o:p>
								</span>
								</b>
							</p>

							<p class=MsoNormal>
								<span
									style='font-family: ����; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma; mso-bidi-font-weight: bold'>����������Ҫ��������</span><span
									lang=EN-US style='mso-bidi-font-weight: bold'>:</span>
							</p>

							<p class=MsoNormal>
								<span lang=EN-US style='mso-bidi-font-weight: bold'>��P��˾��</span>
							</p>

							<p class=MsoNormal>
								<span
									style='font-family: ����; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>��ҹ�˾��һ��������ҵ����ȫ��ҽҩ��ҵ����λ��ǰ�������ǵĲ�Ʒ</span><span
									lang=EN-US>��PL��</span><span
									style='font-family: ����; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>��ͬ���Ʒ���������е�ҩ��ò�Ʒ�����кܳ�һ��ʱ�䴦���г����ȵ�λ����ʱ��˾�൱������۶���Դ����һ��Ʒ����˾ÿ���������Ʒ��Ͷ��޴�Ȼ������</span><span
									lang=EN-US>��ND��</span><span
									style='font-family: ����; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>����</span>
								<span
									style='font-family: ����; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>��������һ��Ʒ����Ч��������</span><span
									lang=EN-US>��PL��, ��PL��</span><span
									style='font-family: ����; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>���г����ۿ�ʼ�ܵ�Ӱ�졣ͬʱ��ͬ���Ʒ��ʼ�������У�</span><span
									lang=EN-US>��PL��</span><span
									style='font-family: ����; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>��ʼ��ʧȥ�г��ݶ����������״������������ת��Ϊ������ʱ����ٴ���֤�����õ��ٴ�ʹ�þ��顣</span>
								<span
									style='font-family: ����; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>ͬʱ����˾��Ȼ��ǿ���ƹ�</span><span
									lang=EN-US>��PL��,</span><span
									style='font-family: ����; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>�Ͼ�����г������൱�޴�ġ�����</span><span
									lang=EN-US>,P</span><span
									style='font-family: ����; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>��˾����һ�������ε����顪����</span><span
									lang=EN-US>PL��</span><span
									style='font-family: ����; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>��ר����һ��ǰ���ڡ�����ʱ�𣬴�������Ʒ�����г����۸�ܵͣ���һ�����������۶��½���</span>
							</p>

							<p class=MsoNormal>
								<span lang=EN-US style='mso-bidi-font-weight: bold'>��E��˾��</span>
							</p>

							<p class=MsoNormal>
								<span lang=EN-US>E</span><span
									style='font-family: ����; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>��˾��һ���Թ����������ҳ����Ʒ���������г����۵�Ӫ����˾����ҹ�˾�кܺõ���������ͺܺõ��ٴ��������顣���ǵĲ�Ʒ</span><span
									lang=EN-US>��EH��</span><span
									style='font-family: ����; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>���г���������һ��ʱ���ˣ����൱���г�ռ���ʣ�Ŀǰ�����ۺ���</span><span
									lang=EN-US>��ND��</span><span
									style='font-family: ����; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>��</span>
							</p>

							<p class=MsoNormal>
								<span lang=EN-US style='mso-bidi-font-weight: bold'>��L��˾��</span>
							</p>

							<p class=MsoNormal>
								<span lang=EN-US>L</span><span
									style='font-family: ����; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>��˾��һ����������ҩ������������ҵ���������������</span><span
									lang=EN-US>��LH��</span><span
									style='font-family: ����; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>����</span><span
									lang=EN-US>��PL��</span><span
									style='font-family: ����; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>�ķ���Ʒ�������г��������ң�Ŀǰ��ҹ�˾�����۴����𲽽׶Σ����۴��ںܴ�ĵ������졣</span>
							</p>

							<p class=MsoNormal>
								<span lang=EN-US>��EH��</span><span
									style='font-family: ����; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>��</span><span
									lang=EN-US>��ND��</span><span
									style='font-family: ����; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>����Ϊ�ǵڶ�����Ѫ�ܲ�Ʒ����Ե�һ����Ʒ��</span><span
									lang=EN-US>PL��</span><span
									style='font-family: ����; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>���ԣ������ֲ�Ʒ�ڰ�ȫ�Ժ���Ч�϶�Ҫ�õöࡣ����</span><span
									lang=EN-US>��ND��</span><span
									style='font-family: ����; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>����ʱ��</span><span
									lang=EN-US>P</span><span
									style='font-family: ����; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>��˾��˾��Ϊ��һ��Ʒֻ��</span><span
									lang=EN-US>��PL��</span><span
									style='font-family: ����; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>��������Ʒ�������ǵ��г�����λ��һ��Ʒ��һ��ͻ�ƣ������ǵ�һ���־õ������˸߰�ȫ�ȣ�������Ч��������ʹ�õ���λһ��������ҩ�ͬʱ������Ϊ��һ��ƷͶ���˴�������Դ��ʵ��֤��������һ���ܳɹ���ս�ԣ�</span><span
									lang=EN-US>��ND��</span><span
									style='font-family: ����; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>������������������������Ѫ�����Ʒ��Ȼ������Ҳ�����������г���������Ʒ��ǿ��ѹ����Ŀǰ�ٴ��������������ķ�����</span><span
									lang=EN-US>��ND��</span><span
									style='font-family: ����; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>�ļ۸�Ƚϸߣ�������ͬ���Ʒ�߳�</span><span
									lang=EN-US>30%</span><span
									style='font-family: ����; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>�����߽�����һ���Ѷȡ�</span><span
									lang=EN-US>&nbsp;</span>
							</p>

							<b><span lang=EN-US
								style='font-size: 11.0pt; font-family: Tahoma; mso-fareast-font-family: ����; mso-bidi-font-family: "Times New Roman"; mso-ansi-language: EN-US; mso-fareast-language: ZH-CN; mso-bidi-language: AR-SA'><br
										clear=all style='page-break-before: always'> </span>
							</b>

							<p class=MsoNormal>
								<a name="_Toc320184198"><b><span
										style='font-family: ����; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>�������</span>
								</b>
								</a><b><span lang=EN-US><o:p></o:p>
								</span>
								</b>
							</p>

							<p class=MsoNormal>
								<span
									style='font-family: ����; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>��������������ǳ�ȡ������</span><span
									lang=EN-US>12</span><span
									style='font-family: ����; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>��Ŀ��ҽ�����������ڿ�</span><span
									lang=EN-US>5</span><span
									style='font-family: ����; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>�������ڿ�</span><span
									lang=EN-US>4</span><span
									style='font-family: ����; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>�����ڷ��ڿ�</span><span
									lang=EN-US>3</span><span
									style='font-family: ����; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>�������Ǵ󲿷������</span><span
									lang=EN-US>ST</span><span
									style='font-family: ����; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>��</span><span
									lang=EN-US>T1</span><span
									style='font-family: ����; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>�ͻ��������ָ����ɷǳ���Ҫ�����������ʹ��</span><span
									lang=EN-US>12</span><span
									style='font-family: ����; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>λҽ���Ĵ���������</span><span
									lang=EN-US>20%,</span><span
									style='font-family: ����; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>����ɹ�˾��ָ�ꡣ����ɼ����Ǹ�����</span><span
									lang=EN-US>12</span><span
									style='font-family: ����; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>��ҽ����״���Ʋ����ȥ��</span><span
									lang=EN-US>12</span><span
									style='font-family: ����; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>����������</span><span
									lang=EN-US>12</span><span
									style='font-family: ����; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>��ҽ����ص��������ݣ��Լ�������һ���ȵ�����ָ�ꡣ����Ҳο���</span>
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
									style='font-family: ����; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>���</span><span
									lang=EN-US>1-3</span><span
									style='font-family: ����; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>��ָ����ͬ</span><span
									lang=EN-US>,</span><span
									style='font-family: ����; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>����ÿ��</span><span
									lang=EN-US>290581</span><span
									style='font-family: ����; mso-ascii-font-family: Tahoma; mso-hansi-font-family: Tahoma'>Ԫ</span>
							</p>

							<b><span lang=EN-US
								style='font-size: 11.0pt; font-family: Tahoma; mso-fareast-font-family: ����; mso-bidi-font-family: "Times New Roman"; mso-ansi-language: EN-US; mso-fareast-language: ZH-CN; mso-bidi-language: AR-SA'><br
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
