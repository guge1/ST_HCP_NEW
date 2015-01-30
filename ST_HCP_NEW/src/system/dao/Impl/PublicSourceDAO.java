package system.dao.Impl;

import javax.servlet.http.HttpServletRequest;

public class PublicSourceDAO
{
  private HttpServletRequest request = null;

  public static  String[] strLeftUrl = {  "queryQianLi_FenXi.action,Ǳ������ ", "queryJieGuo_FenXi.action,�����Է��� ", "queryYouXiaoXing_FenXi.action,����������� ", "queryChanChu_MuBiao.action,����Ŀ��  ", 
	    "queryTouRu_MuBiao.action,Ͷ��Ŀ��", "queryZiYuan_FenPei.action,��Դ����", "queryXingDong_JiHua.action,�ж��ƻ� ", "queryMonth_YuCe.action,Ԥ����� ", "queryYueFen_JianKong.action,���¼��  ", "queryNextYueFen_JianKong.action,���¼�� "};
	 // 
	  public static  String[] strLeftUrl_save = {  "saveQianLi_FenXi.action,Ǳ������ ", "saveJieGuo_FenXi.action,�����Է��� ", "saveYouXiaoXing_FenXi.action,����������� ", "saveChanChu_MuBiao.action,����Ŀ��  ", 
	    "saveTouRu_MuBiao.action,Ͷ��Ŀ��", "saveZiYuan_FenPei.action,��Դ����", "saveXingDong_JiHua.action,�ж��ƻ� ", "saveMonth_YuCe.action,Ԥ����� ", "saveYueFen_JianKong.action,���¼��  ", "saveNextYueFen_JianKong.action,���¼�� "};

  public String[] strMarketResource = { "XF", "KNH", "HD", "XSTGF", "SCBTGF",  "XF_LV", "KNH_LV", "HD_LV", "XSTGF_LV", "SCBTGF_LV"  };

  public String[] strMarketZhiBiao = { "ACH", "NTS", "XSZZ", "SCGM", "PFCS", "KNHCS", "TGHDCS", "ABFGL", "BFJH", "BFJH_T", "CPZS", "XSJQ" };
//��ʷ����
  public String[] strEditHistory =      {  "RESULT,���۽��" };
//��ʷ���� ����
  public String[] strEditHistory_Save = { "COMPANYKPI,ָ�����", "RESULT,���۽��","XSYC_NEXT,����Ԥ�����" };
  //�༭��׼ֵ
  public String[] strEditBiaoZhun = { "XF_BIAOZHUN,�ճ��ݷ�", "KNH_BIAOZHUN,���һ�", "HD_BIAOZHUN,Բ����", "XSTGF_BIAOZHUN,Ժ�ڻ�", "SCBTGF_BIAOZHUN,�ճ���������" };
  //�༭��׼ֵ
 // public String[] strMarketSize = {"QXX,������",  "HZGM,Ǳ��", "XSGN,��������"   };

  public String[] strZontTiFenxi = { "HZGM,Ǳ��","QXX,������",   "XSGN,��������" };

  public String[] strJieGuoFenxi = { "RESULTPOINT1,������Ҫ��1", "RESULTPOINT2,������Ҫ��2", "RESULTPOINT3,������Ҫ��3" };

  public String[] strQianLiFenxi = { "POTENTIALPOINT1,Ǳ��Ҫ��1", "POTENTIALPOINT2,Ǳ��Ҫ��2", "POTENTIALPOINT3,Ǳ��Ҫ��3" };

  public String[] strYouXiaoXingFenxi = { "VALIDITYPOINT1,��������Ҫ��1", "VALIDITYPOINT2,��������Ҫ��2", "VALIDITYPOINT3,��������Ҫ��3" };

  public String[] strYaoDianFenxi = {"POTENTIALPOINT1,Ǳ��Ҫ��1", "POTENTIALPOINT2,Ǳ��Ҫ��2", "POTENTIALPOINT3,Ǳ��Ҫ��3", "RESULTPOINT1,������Ҫ��1", "RESULTPOINT2,������Ҫ��2", "RESULTPOINT3,������Ҫ��3",  "VALIDITYPOINT1,��������Ҫ��1", "VALIDITYPOINT2,��������Ҫ��2", "VALIDITYPOINT3,��������Ҫ��3" };

  public String[] strChanChu_MuBiao = {"HZGM,Ǳ��",  "QXX,������",  "XSGN,��������", "COMPANYKPI,ָ�����", "XSYC,����Ԥ��","XSYG_TEST,����Ԥ��" };

  public String[] strChanChu_MuBiao_Save = { "COMPANYKPI", "XSYC","XSYG_TEST,����Ԥ��" };

  public String[] strTouRuMuBiao = { "DIVEINTOPOINT4,Ǳ��Ҫ��1", "DIVEINTOPOINT5,Ǳ��Ҫ��2", "DIVEINTOPOINT6,Ǳ��Ҫ��3", "DIVEINTOPOINT1,������Ҫ��1", "DIVEINTOPOINT2,������Ҫ��2", "DIVEINTOPOINT3,������Ҫ��3", "DIVEINTOPOINT7,��������Ҫ��1", "DIVEINTOPOINT8,��������Ҫ��2", "DIVEINTOPOINT9,��������Ҫ��3" };

  public String[] XingDong_JiHua = { "ACTIONPLAN4,�ж�Ǳ���ƻ�1", "ACTIONPLAN5,�ж�Ǳ���ƻ�2", "ACTIONPLAN6,�ж�Ǳ���ƻ�3", 
		  "ACTIONPLAN1,�ж�����ƻ�1", "ACTIONPLAN2,�ж�����ƻ�2", "ACTIONPLAN3,�ж�����ƻ�3", 
    
    "ACTIONPLAN7,�ж���Ч�Լƻ�1", "ACTIONPLAN8,�ж���Ч�Լƻ�2", "ACTIONPLAN9,�ж���Ч�Լƻ�3" };

  public String[] XingDong_JiHua_QiXian = { "ACTIONTERM1,�ж��������1", "ACTIONTERM2,�ж��������2", "ACTIONTERM3,�ж��������3", "ACTIONTERM4,�ж�Ǳ������1", "ACTIONTERM5,�ж�Ǳ������2", "ACTIONTERM6,�ж�Ǳ������3", 
    "ACTIONTERM7,�ж���Ч������1", "ACTIONTERM8,�ж���Ч������2", "ACTIONTERM9,�ж���Ч������3" };

  public String[] XingDong_JiHua_Save = {
		  
		    "ACTIONPLAN4,�ж�Ǳ���ƻ�1", "ACTIONPLAN5,�ж�Ǳ���ƻ�2", "ACTIONPLAN6,�ж�Ǳ���ƻ�3", 
		  "ACTIONPLAN1,�ж�����ƻ�1", "ACTIONPLAN2,�ж�����ƻ�2", "ACTIONPLAN3,�ж�����ƻ�3",
    "ACTIONPLAN7,�ж���Ч�Լƻ�1", "ACTIONPLAN8,�ж���Ч�Լƻ�2", "ACTIONPLAN9,�ж���Ч�Լƻ�3", 
    "ACTIONTERM1,�ж��������1", "ACTIONTERM2,�ж��������2", "ACTIONTERM3,�ж��������3", "ACTIONTERM4,�ж�Ǳ������1", "ACTIONTERM5,�ж�Ǳ������2", "ACTIONTERM6,�ж�Ǳ������3", 
    "ACTIONTERM7,�ж���Ч������1", "ACTIONTERM8,�ж���Ч������2", "ACTIONTERM9,�ж���Ч������3" };
  
 /**
  * ��Դ
  */
  public String[] strZiYuan= {"XF,�ճ��ݷ�",  "HD,Բ����","KNH,���һ�", "XSTGF,Ժ�ڻ�", "SCBTGF,�ճ���������"  };
  

  public String[] strZiYuan_FenPei = { "XF,�ճ��ݷ�",  "KNH,���һ�", "HD,Բ����", "XSTGF,Ժ�ڻ�", "SCBTGF,�ճ���������" };

  public String[] strZiYuan_FenPei_Save = { "XF,�ճ��ݷ�", "KNH,���һ�", "HD,Բ����", "XSTGF,Ժ�ڻ�", "SCBTGF,�ճ���������", "XF_LV,�ճ��ݷ�", "KNH_LV,���һ�", "HD_LV,Բ����", "XSTGF_LV,Ժ�ڻ�", "SCBTGF_LV,�ճ���������"   ,  "LASTRESULT,���յ�", "USERORDER,����","COMPANYKPI,ָ����� ","PXHD,�������ٷֱ�" };
// ���²����
  public String[] strMonth_YuCe = { "COMPANYKPI,ָ����� ", "XSYC,����Ԥ��", "RESULT,���۽��","DACL,�����" };

  public String[] strYue_JianKong = {  "XF,�ճ��ݷ�", "KNH,���һ�", "HD,Բ����", "XSTGF,Ժ�ڻ�", "SCBTGF,�ճ���������" };

  public String[] strYue_JianKong_save = { "USERORDER,����", "XF,�ճ��ݷ�", "KNH,���һ�", "HD,Բ����", "XSTGF,Ժ�ڻ�",  "XF_LV,Э������", "KNH_LV,���һ����", "HD_LV,�г������", "XSTGF_LV,�������������ƹ����","SCBTGF_LV,�ճ���������", "SCBTGF,�ճ���������", "ORDER1", "ORDER2", "ORDER3", "ORDER4", "ORDER5", "RESULT" ,"LASTRESULT","COMPANYKPI","PXHD,�������ٷֱ�"};

  public String[] strYue_YuCe = { "XF,�ճ��ݷ�", "KNH,���һ�", "HD,Բ����", "XSTGF,Ժ�ڻ�", "SCBTGF,�ճ���������" };//, "LASTRESULT,���յ�"

  public String[] strYue_YuCe_save = { "XSYC_NEXT,����Ԥ��", "XF,�ճ��ݷ�", "KNH,���һ�", "HD,Բ����", "XSTGF,Ժ�ڻ�", "SCBTGF,�ճ���������", "XSYC,����Ԥ��", "COMPANYKPI,ָ�����","LASTRESULT,���յ�","PXHD,�������ٷֱ�"};

  public String[] strYue_YuCe_1 = { "XSYC_NEXT,����Ԥ��", "COMPANYKPI,ָ�����", "DACL,�����" };

  public String[] strMarketInfo = { "NAME,��������", "INTRODUCE,��ϸ����", "PINGLUN,����", "SHIJIAN,�¼�", "RENKOUSHU,�˿���", "SUI0,0��25��%", "SUI25,25-60��%", "SUI60,+60��%", "COUNTYIYUAN,Ŀ��ҽԺ��", "JI3,3��", "JI2,2��", "COUNTMENZENG,��������", "COUNTJINER,�ܹ�ҩ���", "INTRODUCE_MY,����", "TARGET,����Ŀ��", "REQUIREMENT,����", "YEJI,ҵ������", "JIHUA,Ŀ�����", "SELF,��������", "RJSR,�˾�����" };

  public String[] youXiaoXing_person = {"XSGN,��������" };

  public String[] strYouXiaoXing = { "XSJQ,���ۼ���", "CPZS,��Ʒ֪ʶ", "XSGN,��������", "ABFGL,Ŀ��ͻ�������", "TGHDCS,�ƹ�����(4/month)", "BFJH,�ݷüƻ�" };

  public String[] strMarketVeryfy = { "", "" };

  public void setServletRequest(HttpServletRequest request)
  {
    this.request = request;
  }
}