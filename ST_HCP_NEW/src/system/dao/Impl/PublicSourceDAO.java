package system.dao.Impl;

import javax.servlet.http.HttpServletRequest;

public class PublicSourceDAO
{
  private HttpServletRequest request = null;

  public static  String[] strLeftUrl = {  "queryQianLi_FenXi.action,潜力分析 ", "queryJieGuo_FenXi.action,倾向性分析 ", "queryYouXiaoXing_FenXi.action,处方观念分析 ", "queryChanChu_MuBiao.action,产出目标  ", 
	    "queryTouRu_MuBiao.action,投入目标", "queryZiYuan_FenPei.action,资源分配", "queryXingDong_JiHua.action,行动计划 ", "queryMonth_YuCe.action,预测对照 ", "queryYueFen_JianKong.action,下月监控  ", "queryNextYueFen_JianKong.action,后月监控 "};
	 // 
	  public static  String[] strLeftUrl_save = {  "saveQianLi_FenXi.action,潜力分析 ", "saveJieGuo_FenXi.action,倾向性分析 ", "saveYouXiaoXing_FenXi.action,处方观念分析 ", "saveChanChu_MuBiao.action,产出目标  ", 
	    "saveTouRu_MuBiao.action,投入目标", "saveZiYuan_FenPei.action,资源分配", "saveXingDong_JiHua.action,行动计划 ", "saveMonth_YuCe.action,预测对照 ", "saveYueFen_JianKong.action,下月监控  ", "saveNextYueFen_JianKong.action,后月监控 "};

  public String[] strMarketResource = { "XF", "KNH", "HD", "XSTGF", "SCBTGF",  "XF_LV", "KNH_LV", "HD_LV", "XSTGF_LV", "SCBTGF_LV"  };

  public String[] strMarketZhiBiao = { "ACH", "NTS", "XSZZ", "SCGM", "PFCS", "KNHCS", "TGHDCS", "ABFGL", "BFJH", "BFJH_T", "CPZS", "XSJQ" };
//历史数据
  public String[] strEditHistory =      {  "RESULT,销售结果" };
//历史数据 保存
  public String[] strEditHistory_Save = { "COMPANYKPI,指标分配", "RESULT,销售结果","XSYC_NEXT,销售预估结果" };
  //编辑标准值
  public String[] strEditBiaoZhun = { "XF_BIAOZHUN,日常拜访", "KNH_BIAOZHUN,科室会", "HD_BIAOZHUN,圆桌会", "XSTGF_BIAOZHUN,院内会", "SCBTGF_BIAOZHUN,日常促销费用" };
  //编辑标准值
 // public String[] strMarketSize = {"QXX,倾向性",  "HZGM,潜力", "XSGN,处方观念"   };

  public String[] strZontTiFenxi = { "HZGM,潜力","QXX,倾向性",   "XSGN,处方观念" };

  public String[] strJieGuoFenxi = { "RESULTPOINT1,倾向性要点1", "RESULTPOINT2,倾向性要点2", "RESULTPOINT3,倾向性要点3" };

  public String[] strQianLiFenxi = { "POTENTIALPOINT1,潜力要点1", "POTENTIALPOINT2,潜力要点2", "POTENTIALPOINT3,潜力要点3" };

  public String[] strYouXiaoXingFenxi = { "VALIDITYPOINT1,处方观念要点1", "VALIDITYPOINT2,处方观念要点2", "VALIDITYPOINT3,处方观念要点3" };

  public String[] strYaoDianFenxi = {"POTENTIALPOINT1,潜力要点1", "POTENTIALPOINT2,潜力要点2", "POTENTIALPOINT3,潜力要点3", "RESULTPOINT1,倾向性要点1", "RESULTPOINT2,倾向性要点2", "RESULTPOINT3,倾向性要点3",  "VALIDITYPOINT1,处方观念要点1", "VALIDITYPOINT2,处方观念要点2", "VALIDITYPOINT3,处方观念要点3" };

  public String[] strChanChu_MuBiao = {"HZGM,潜力",  "QXX,倾向性",  "XSGN,处方观念", "COMPANYKPI,指标分配", "XSYC,销售预测","XSYG_TEST,销售预估" };

  public String[] strChanChu_MuBiao_Save = { "COMPANYKPI", "XSYC","XSYG_TEST,销售预估" };

  public String[] strTouRuMuBiao = { "DIVEINTOPOINT4,潜力要点1", "DIVEINTOPOINT5,潜力要点2", "DIVEINTOPOINT6,潜力要点3", "DIVEINTOPOINT1,倾向性要点1", "DIVEINTOPOINT2,倾向性要点2", "DIVEINTOPOINT3,倾向性要点3", "DIVEINTOPOINT7,处方观念要点1", "DIVEINTOPOINT8,处方观念要点2", "DIVEINTOPOINT9,处方观念要点3" };

  public String[] XingDong_JiHua = { "ACTIONPLAN4,行动潜力计划1", "ACTIONPLAN5,行动潜力计划2", "ACTIONPLAN6,行动潜力计划3", 
		  "ACTIONPLAN1,行动结果计划1", "ACTIONPLAN2,行动结果计划2", "ACTIONPLAN3,行动结果计划3", 
    
    "ACTIONPLAN7,行动有效性计划1", "ACTIONPLAN8,行动有效性计划2", "ACTIONPLAN9,行动有效性计划3" };

  public String[] XingDong_JiHua_QiXian = { "ACTIONTERM1,行动结果期限1", "ACTIONTERM2,行动结果期限2", "ACTIONTERM3,行动结果期限3", "ACTIONTERM4,行动潜力期限1", "ACTIONTERM5,行动潜力期限2", "ACTIONTERM6,行动潜力期限3", 
    "ACTIONTERM7,行动有效性期限1", "ACTIONTERM8,行动有效性期限2", "ACTIONTERM9,行动有效性期限3" };

  public String[] XingDong_JiHua_Save = {
		  
		    "ACTIONPLAN4,行动潜力计划1", "ACTIONPLAN5,行动潜力计划2", "ACTIONPLAN6,行动潜力计划3", 
		  "ACTIONPLAN1,行动结果计划1", "ACTIONPLAN2,行动结果计划2", "ACTIONPLAN3,行动结果计划3",
    "ACTIONPLAN7,行动有效性计划1", "ACTIONPLAN8,行动有效性计划2", "ACTIONPLAN9,行动有效性计划3", 
    "ACTIONTERM1,行动结果期限1", "ACTIONTERM2,行动结果期限2", "ACTIONTERM3,行动结果期限3", "ACTIONTERM4,行动潜力期限1", "ACTIONTERM5,行动潜力期限2", "ACTIONTERM6,行动潜力期限3", 
    "ACTIONTERM7,行动有效性期限1", "ACTIONTERM8,行动有效性期限2", "ACTIONTERM9,行动有效性期限3" };
  
 /**
  * 资源
  */
  public String[] strZiYuan= {"XF,日常拜访",  "HD,圆桌会","KNH,科室会", "XSTGF,院内会", "SCBTGF,日常促销费用"  };
  

  public String[] strZiYuan_FenPei = { "XF,日常拜访",  "KNH,科室会", "HD,圆桌会", "XSTGF,院内会", "SCBTGF,日常促销费用" };

  public String[] strZiYuan_FenPei_Save = { "XF,日常拜访", "KNH,科室会", "HD,圆桌会", "XSTGF,院内会", "SCBTGF,日常促销费用", "XF_LV,日常拜访", "KNH_LV,科室会", "HD_LV,圆桌会", "XSTGF_LV,院内会", "SCBTGF_LV,日常促销费用"   ,  "LASTRESULT,最终的", "USERORDER,排序","COMPANYKPI,指标分配 ","PXHD,分配结果百分比" };
// 月月测对照
  public String[] strMonth_YuCe = { "COMPANYKPI,指标分配 ", "XSYC,销售预估", "RESULT,销售结果","DACL,达成率" };

  public String[] strYue_JianKong = {  "XF,日常拜访", "KNH,科室会", "HD,圆桌会", "XSTGF,院内会", "SCBTGF,日常促销费用" };

  public String[] strYue_JianKong_save = { "USERORDER,排序", "XF,日常拜访", "KNH,科室会", "HD,圆桌会", "XSTGF,院内会",  "XF_LV,协访天数", "KNH_LV,科室会次数", "HD_LV,市场活动次数", "XSTGF_LV,地区经理销售推广费用","SCBTGF_LV,日常促销费用", "SCBTGF,日常促销费用", "ORDER1", "ORDER2", "ORDER3", "ORDER4", "ORDER5", "RESULT" ,"LASTRESULT","COMPANYKPI","PXHD,分配结果百分比"};

  public String[] strYue_YuCe = { "XF,日常拜访", "KNH,科室会", "HD,圆桌会", "XSTGF,院内会", "SCBTGF,日常促销费用" };//, "LASTRESULT,最终的"

  public String[] strYue_YuCe_save = { "XSYC_NEXT,销售预估", "XF,日常拜访", "KNH,科室会", "HD,圆桌会", "XSTGF,院内会", "SCBTGF,日常促销费用", "XSYC,销售预估", "COMPANYKPI,指标分配","LASTRESULT,最终的","PXHD,分配结果百分比"};

  public String[] strYue_YuCe_1 = { "XSYC_NEXT,销售预估", "COMPANYKPI,指标分配", "DACL,达成率" };

  public String[] strMarketInfo = { "NAME,代表姓名", "INTRODUCE,详细介绍", "PINGLUN,评论", "SHIJIAN,事件", "RENKOUSHU,人口数", "SUI0,0·25岁%", "SUI25,25-60岁%", "SUI60,+60岁%", "COUNTYIYUAN,目标医院数", "JI3,3级", "JI2,2级", "COUNTMENZENG,总门诊数", "COUNTJINER,总够药金额", "INTRODUCE_MY,介绍", "TARGET,销售目标", "REQUIREMENT,需求", "YEJI,业绩评估", "JIHUA,目标打算", "SELF,自我评价", "RJSR,人均收入" };

  public String[] youXiaoXing_person = {"XSGN,处方观念" };

  public String[] strYouXiaoXing = { "XSJQ,销售技巧", "CPZS,产品知识", "XSGN,处方观念", "ABFGL,目标客户覆盖率", "TGHDCS,推广活动次数(4/month)", "BFJH,拜访计划" };

  public String[] strMarketVeryfy = { "", "" };

  public void setServletRequest(HttpServletRequest request)
  {
    this.request = request;
  }
}