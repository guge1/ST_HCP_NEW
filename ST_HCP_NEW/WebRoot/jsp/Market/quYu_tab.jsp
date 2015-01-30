<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
<head id="Head1">
    <title>业务表单 </title>
    <base target="_self" />
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
    <script language="javascript" type="text/javascript" src="js/WinOpen.js"></script>
    <link href="css/styleform.css" type="text/css" rel="stylesheet" />
    <link href="../../App_Themes/style_dark/styleform.css" type="text/css" rel="stylesheet" />
    <link href="../../App_Themes/style_dark/style.css" type="text/css" rel="stylesheet" />
    <link href="../../App_Themes/style_dark/StyleSheet.css" type="text/css" rel="stylesheet" />
</head>
<body style="margin-top: 0; padding-top: 0;">
    <form name="form1" method="post" action="SimplePage.aspx?PageID=1089&amp;setPageTemplateID=&amp;setPageTest=1"
    id="form1">
 
    <div id="divContent" style="width: 100%">
        <table style="width: 100%;">
            <tr>
                <td colspan="2" class="tdGroupGround">
            </tr>
            <!--Tab begin-->
            <tr>
                <td colspan="2" class="tdTabCollapseallTitle">
                    &nbsp;&nbsp; 投入目标
                </td>
            </tr>
            <tr id="100060" style="">
                <td colspan="2" class="tdGroupGround">
                    <div id="TabContent" style="width: 100%; height: auto;">
                        <table cellpadding="0" cellspacing="0" width="100%" style="margin-top: 5px;">
                            <tr>
                                <td id="001_0" title="" style="width: 100px; height: 22px; background-image: url(img_bg/tabbg_on0.gif);
                                    font-size: 12px; text-align: center; cursor: pointer;" onclick="__ChangeTab('001','0',6,'0','text','',0)">
                                    张海鑫
                                </td>
                                <td id="001_1" title="" style="width: 100px; height: 22px; background-image: url(img_bg/tabbg_off0.gif);
                                    font-size: 12px; text-align: center; cursor: pointer;" onclick="__ChangeTab('001','0',6,'1','text','',0)">
                                    王胜理
                                </td>
                                <td id="001_2" title="" style="width: 100px; height: 22px; background-image: url(img_bg/tabbg_off0.gif);
                                    font-size: 12px; text-align: center; cursor: pointer;" onclick="__ChangeTab('001','0',6,'2','text','',0)">
                                    刘文娟
                                </td>
                                <td id="001_3" title="" style="width: 100px; height: 22px; background-image: url(img_bg/tabbg_off0.gif);
                                    font-size: 12px; text-align: center; cursor: pointer;" onclick="__ChangeTab('001','0',6,'3','text','',0)">
                                    玄武区
                                </td>
                                <td id="001_4" title="刘瑞华" style="width: 100px; height: 22px; background-image: url(img_bg/tabbg_off0.gif);
                                    font-size: 12px; text-align: center; cursor: pointer;" onclick="__ChangeTab('001','1',6,'4','text','../../System/Portal/PortalList.aspx?a111=1&uewee0212=&uweefsd10123=0&vMenuId=2263',0)">
                                    刘瑞华
                                </td>
                                <td id="001_5" title="" style="width: 100px; height: 22px; background-image: url(img_bg/tabbg_off0.gif);
                                    font-size: 12px; text-align: center; cursor: pointer;" onclick="__ChangeTab('001','0',6,'5','text','',0)">
                                    何文琪
                                </td>
                                <td style="border-bottom: solid 1px #86CBF7; font-size: 12px; text-align: right;"
                                    width="*">
                                    &nbsp;
                                </td>
                            </tr>
                        </table>
                    </div>
                    <div id="Tab_001_0" style="width: 100%; height: auto; border-bottom-color: Red; display: none;
                        background-color: #fff; ">
                        <table class="tbDragTable" id="100061" style="width: 100%; margin-top: 0px; margin-left: 0px;
                            ">
                            <colgroup>
                                <col width="15%" />
                                <col width="35%" />
                                <col width="15%" />
                                <col width="35%" />
                            </colgroup>
                            <tr id="484" row_type="99999" class="trMoveRow">
                                <td id="C_SEX" class="tdFieldLable">
                                    性别
                                </td>
                                <td class="tdFieldInput" id="E_SEX" colspan="1" valign="top">
                                    <input type="text" name="SEX" id="SEX" style="padding-right: 1px; width: 126px;"
                                        caption="性别" mustinput="0" value="" />
                                </td>
                                <td id="C_A3" class="tdFieldLable">
                                    A3
                                </td>
                                <td class="tdFieldInput" id="E_A3" colspan="1" valign="top">
                                    <input type="text" name="A3" id="A3" style="padding-right: 1px; width: 126px;" caption="A3"
                                        mustinput="0" value="" />
                                </td>
                            </tr>
                        </table>
                    </div>
                    <div id="Tab_001_1" style="width: 100%; height: auto; border-bottom-color: Red; display: none;
                        background-color: #fff; display: none;">
                        <table class="tbDragTable" id="100062" style="width: 100%; margin-top: 0px; margin-left: 0px;
                            ">
                            <colgroup>
                                <col width="15%" />
                                <col width="35%" />
                                <col width="15%" />
                                <col width="35%" />
                            </colgroup>
                            <tr id="485" row_type="99999" class="trMoveRow">
                                <td id="C_INTRODUCE" class="tdFieldLable">
                                    详细介绍
                                </td>
                                <td class="tdFieldInput" id="E_INTRODUCE" colspan="1" valign="top">
                                    <input type="text" name="INTRODUCE" id="INTRODUCE" style="padding-right: 1px; width: 126px;"
                                        caption="详细介绍" mustinput="0" value="" />
                                </td>
                                <td id="C_A1" class="tdFieldLable">
                                    A1
                                </td>
                                <td class="tdFieldInput" id="E_A1" colspan="1" valign="top">
                                    <input type="text" name="A1" id="A1" style="padding-right: 1px; width: 126px;" caption="A1"
                                        mustinput="0" value="" />
                                </td>
                            </tr>
                        </table>
                    </div>
                    <div id="Tab_001_2" style="width: 100%; height: auto; border-bottom-color: Red; display: none;
                        background-color: #fff; display: none;">
                        <table class="tbDragTable" id="100063" style="width: 100%; margin-top: 0px; margin-left: 0px;
                            ">
                            <colgroup>
                                <col width="15%" />
                                <col width="35%" />
                                <col width="15%" />
                                <col width="35%" />
                            </colgroup>
                            <tr id="0001" row_type="99999" class="trMoveRow">
                                <td class="tdFieldLable">
                                </td>
                                <td class="tdFieldInput" colspan="1" valign="top">
                                </td>
                                <td class="tdFieldLable">
                                </td>
                                <td class="tdFieldInput" colspan="1" valign="top">
                                </td>
                            </tr>
                        </table>
                    </div>
                    <div id="Tab_001_3" style="width: 100%; height: auto; border-bottom-color: Red; display: none;
                        background-color: #fff; display: none;">
                        <table class="tbDragTable" id="100064" style="width: 100%; margin-top: 0px; margin-left: 0px;
                            ">
                            <colgroup>
                                <col width="15%" />
                                <col width="35%" />
                                <col width="15%" />
                                <col width="35%" />
                            </colgroup>
                            <tr id="487" row_type="99999" class="trMoveRow">
                                <td id="C_HISTORYDISCRIPTION" class="tdFieldLable">
                                    从业经验
                                </td>
                                <td class="tdFieldInput" id="E_HISTORYDISCRIPTION" colspan="1" valign="top">
                                    <input type="text" name="HISTORYDISCRIPTION" id="HISTORYDISCRIPTION" style="padding-right: 1px;
                                        width: 126px;" caption="从业经验" mustinput="0" value="" />
                                </td>
                                <td class="tdFieldLable">
                                </td>
                                <td class="tdFieldInput" colspan="1" valign="top">
                                </td>
                            </tr>
                        </table>
                    </div>
                    <div id="Tab_001_4" style="width: 100%; height: auto; border-bottom-color: Red; display: none;">
                        <iframe style="overflow: hidden; width: 100%; height: 300px; margin-top: 0px; margin-left: 0px;
                            margin-right: 0px;" src="../../System/Portal/PortalList.aspx?a111=1&uewee0212=&uweefsd10123=0&vMenuId=2263"
                            frameborder="0" id="__PageTab001_4" name="__PageTab001_4"></iframe>
                    </div>
                    <script type="text/javascript">                        var v001_4 = window.setInterval("__ResizeIframe('001','4')", 500);</script>
                    <div id="Tab_001_5" style="width: 100%; height: auto; border-bottom-color: Red; display: none;
                        background-color: #fff; display: none;">
                        <table class="tbDragTable" id="100066" style="width: 100%; margin-top: 0px; margin-left: 0px;
                            ">
                            <colgroup>
                                <col width="15%" />
                                <col width="35%" />
                                <col width="15%" />
                                <col width="35%" />
                            </colgroup>
                            <tr id="486" row_type="99999" class="trMoveRow">
                                <td id="C_NAME" class="tdFieldLable">
                                    代表名称
                                </td>
                                <td class="tdFieldInput" id="E_NAME" colspan="1" valign="top">
                                    <input type="text" name="NAME" id="NAME" style="padding-right: 1px; width: 126px;"
                                        caption="代表名称" mustinput="0" value="" />
                                </td>
                                <td class="tdFieldLable">
                                </td>
                                <td class="tdFieldInput" colspan="1" valign="top">
                                </td>
                            </tr>
                        </table>
                    </div>
                </td>
            </tr>
            <!--Tab End-->
            <!--Group begin-->
            <tr>
                <td colspan="2" class="tdGroupGround">
                    <table cellspacing="0" cellpadding="0" width="100%">
                        <tbody>
                            <tr>
                                <td colspan="2" class="tdBaseTitle">
                                    &nbsp;&nbsp;编号100048
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2">
                                    <table class="tbDragTable" id="100048" style="width: 100%; margin-top: 0px; margin-left: 0px;">
                                        <colgroup>
                                            <col width="15%" />
                                            <col width="35%" />
                                            <col width="15%" />
                                            <col width="35%" />
                                        </colgroup>
                                        <tr id="Tr1" row_type="99999" class="trMoveRow">
                                            <td class="tdFieldLable">
                                            </td>
                                            <td class="tdFieldInput" colspan="1" valign="top">
                                            </td>
                                            <td class="tdFieldLable">
                                            </td>
                                            <td class="tdFieldInput" colspan="1" valign="top">
                                            </td>
                                        </tr>
                                    </table>
                    </table>
                </td>
            </tr>
        </table>
    </div>
    </form>
</body>
</html>
