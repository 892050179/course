package com.demo;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.text.csv.CsvUtil;
import cn.hutool.core.text.csv.CsvWriter;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.demo.pojo.Course;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 用于生成西电课表csv
 */
public class Main {

    public static void main(String[] args) {
        JSONArray dataList = JSON.parseArray("[{\"BY6\":null,\"BY5\":null,\"XDFSDM\":\"0\",\"BY4\":null,\"RKJS\":\"李长安\",\"BY3\":null,\"WID\":\"55aa109c050b4cc9bdde45628b146f83\",\"BY2\":null,\"SKXS_DISPLAY\":\"\",\"BY1\":null,\"XKRS\":\"36\",\"KKDW\":\"009\",\"SKFSDM_DISPLAY\":\"讲授课程\",\"XH\":\"20071212623\",\"ORDERFILTER\":null,\"PKDD\":\"南校区C415\",\"KCFLDM\":\"1\",\"KCMC\":\"专业英语（一）\",\"SKFSDM\":\"01\",\"SKXS\":null,\"XQDM_DISPLAY\":\"南校区\",\"XQDM\":\"01\",\"XNXQDM\":\"20201\",\"XKBZ\":null,\"KCXZDM\":\"2\",\"XNXQDM_DISPLAY\":\"2020秋\",\"YXYWMC\":null,\"XNXQYWMC\":null,\"PKSJDD\":\"4-15周 星期二[1-2节]南校区C415;4,6-8周 星期五[1-2节]南校区C415\",\"KKDW_DISPLAY\":\"外国语学院\",\"RZLBDM\":null,\"BJDM\":\"20201-009-X1FL0002-1594281968609\",\"KCMCYW\":\"English for Science and Technology (I)\",\"BJMC\":\"专业英语（一）19\",\"PKSJ\":\"4-15周 星期二[1-2节];4,6-8周 星期五[1-2节]\",\"BY7\":null,\"BY8\":null,\"BY9\":null,\"KCDM\":\"X1FL0002\",\"BY10\":null,\"SCSKRQ\":\"2020-09-22\"},{\"BY6\":null,\"BY5\":null,\"XDFSDM\":\"0\",\"BY4\":null,\"RKJS\":\"赵水静\",\"BY3\":null,\"WID\":\"14a893cc369547ef82d549a1c8543478\",\"BY2\":null,\"SKXS_DISPLAY\":\"\",\"BY1\":null,\"XKRS\":\"110\",\"KKDW\":\"008\",\"SKFSDM_DISPLAY\":\"讲授课程\",\"XH\":\"20071212623\",\"ORDERFILTER\":null,\"PKDD\":\"南校区A-106\",\"KCFLDM\":\"1\",\"KCMC\":\"科学精神与人文精神专题\",\"SKFSDM\":\"01\",\"SKXS\":null,\"XQDM_DISPLAY\":\"南校区\",\"XQDM\":\"01\",\"XNXQDM\":\"20201\",\"XKBZ\":null,\"KCXZDM\":\"2\",\"XNXQDM_DISPLAY\":\"2020秋\",\"YXYWMC\":null,\"XNXQYWMC\":null,\"PKSJDD\":\"4-11周 星期三[7-8节]南校区A-106\",\"KKDW_DISPLAY\":\"人文学院\",\"RZLBDM\":null,\"BJDM\":\"20201-008-X1HA0002-1592987825047\",\"KCMCYW\":null,\"BJMC\":\"科学精神与人文精神专题09\",\"PKSJ\":\"4-11周 星期三[7-8节]\",\"BY7\":null,\"BY8\":null,\"BY9\":null,\"KCDM\":\"X1HA0002\",\"BY10\":null,\"SCSKRQ\":\"2020-09-23\"},{\"BY6\":null,\"BY5\":null,\"XDFSDM\":\"0\",\"BY4\":null,\"RKJS\":\"陈鹏联\",\"BY3\":null,\"WID\":\"28f9eecf3c6e4842a00e82facfb0ccb1\",\"BY2\":null,\"SKXS_DISPLAY\":\"\",\"BY1\":null,\"XKRS\":\"252\",\"KKDW\":\"016\",\"SKFSDM_DISPLAY\":\"讲授课程\",\"XH\":\"20071212623\",\"ORDERFILTER\":null,\"PKDD\":\"南校区B433\",\"KCFLDM\":\"1\",\"KCMC\":\"中国特色社会主义理论与实践研究\",\"SKFSDM\":\"01\",\"SKXS\":null,\"XQDM_DISPLAY\":\"南校区\",\"XQDM\":\"01\",\"XNXQDM\":\"20201\",\"XKBZ\":null,\"KCXZDM\":\"2\",\"XNXQDM_DISPLAY\":\"2020秋\",\"YXYWMC\":null,\"XNXQYWMC\":null,\"PKSJDD\":\"4,6-15周 星期五[9-10节]南校区B433;4,6-14周 星期五[11-11节]南校区B433\",\"KKDW_DISPLAY\":\"马克思主义学院\",\"RZLBDM\":null,\"BJDM\":\"20201-016-X1MX0001-1593478982274\",\"KCMCYW\":\"Research on the Theory and Practice of Socialism with Chinese Characteristics\",\"BJMC\":\"中国特色社会主义理论与实践研究09\",\"PKSJ\":\"4,6-15周 星期五[9-10节];4,6-14周 星期五[11-11节]\",\"BY7\":null,\"BY8\":null,\"BY9\":null,\"KCDM\":\"X1MX0001\",\"BY10\":null,\"SCSKRQ\":\"2020-09-25\"},{\"BY6\":null,\"BY5\":null,\"XDFSDM\":\"0\",\"BY4\":null,\"RKJS\":null,\"BY3\":null,\"WID\":\"b2dbe3041af0446e93512af31442c0fe\",\"BY2\":null,\"SKXS_DISPLAY\":\"\",\"BY1\":null,\"XKRS\":\"4524\",\"KKDW\":\"100\",\"SKFSDM_DISPLAY\":\"讲授课程\",\"XH\":\"20071212623\",\"ORDERFILTER\":null,\"PKDD\":null,\"KCFLDM\":\"1\",\"KCMC\":\"学术规范与论文写作\",\"SKFSDM\":\"01\",\"SKXS\":null,\"XQDM_DISPLAY\":\"北校区\",\"XQDM\":\"02\",\"XNXQDM\":\"20201\",\"XKBZ\":null,\"KCXZDM\":\"2\",\"XNXQDM_DISPLAY\":\"2020秋\",\"YXYWMC\":null,\"XNXQYWMC\":null,\"PKSJDD\":null,\"KKDW_DISPLAY\":\"研究生院\",\"RZLBDM\":null,\"BJDM\":\"20201-100-X2GR2014-1599029267714\",\"KCMCYW\":null,\"BJMC\":\"学术规范与论文写作01\",\"PKSJ\":null,\"BY7\":null,\"BY8\":null,\"BY9\":null,\"KCDM\":\"X2GR2014\",\"BY10\":null,\"SCSKRQ\":null},{\"BY6\":null,\"BY5\":null,\"XDFSDM\":\"0\",\"BY4\":null,\"RKJS\":\"吴事良\",\"BY3\":null,\"WID\":\"c9d96dfb6f35495488531c00561255fc\",\"BY2\":null,\"SKXS_DISPLAY\":\"\",\"BY1\":null,\"XKRS\":\"57\",\"KKDW\":\"007\",\"SKFSDM_DISPLAY\":\"讲授课程\",\"XH\":\"20071212623\",\"ORDERFILTER\":null,\"PKDD\":\"南校区A-105\",\"KCFLDM\":\"1\",\"KCMC\":\"线性与非线性泛函\",\"SKFSDM\":\"01\",\"SKXS\":null,\"XQDM_DISPLAY\":\"南校区\",\"XQDM\":\"01\",\"XNXQDM\":\"20201\",\"XKBZ\":null,\"KCXZDM\":\"1\",\"XNXQDM_DISPLAY\":\"2020秋\",\"YXYWMC\":null,\"XNXQYWMC\":null,\"PKSJDD\":\"4,6-17周 星期四[9-11节]南校区A-105;12-18周 星期日[9-11节]南校区A-105\",\"KKDW_DISPLAY\":\"数学与统计学院\",\"RZLBDM\":null,\"BJDM\":\"20201-007-X2MS1011-1597912995608\",\"KCMCYW\":\"Functional Analysis\",\"BJMC\":\"线性与非线性泛函01\",\"PKSJ\":\"4,6-17周 星期四[9-11节];12-18周 星期日[9-11节]\",\"BY7\":null,\"BY8\":null,\"BY9\":null,\"KCDM\":\"X2MS1011\",\"BY10\":null,\"SCSKRQ\":\"2020-09-24\"},{\"BY6\":null,\"BY5\":null,\"XDFSDM\":\"0\",\"BY4\":null,\"RKJS\":\"尹小艳\",\"BY3\":null,\"WID\":\"db73701a482144b889aa70e57371bdab\",\"BY2\":null,\"SKXS_DISPLAY\":\"\",\"BY1\":null,\"XKRS\":\"66\",\"KKDW\":\"007\",\"SKFSDM_DISPLAY\":\"讲授课程\",\"XH\":\"20071212623\",\"ORDERFILTER\":null,\"PKDD\":\"南校区A-110\",\"KCFLDM\":\"1\",\"KCMC\":\"矩阵分析与计算\",\"SKFSDM\":\"01\",\"SKXS\":null,\"XQDM_DISPLAY\":\"南校区\",\"XQDM\":\"01\",\"XNXQDM\":\"20201\",\"XKBZ\":null,\"KCXZDM\":\"1\",\"XNXQDM_DISPLAY\":\"2020秋\",\"YXYWMC\":null,\"XNXQYWMC\":null,\"PKSJDD\":\"4-17周 星期一[5-6节]南校区A-110;4-17周 星期三[5-6节]南校区A-110;17-18周 星期四[5-6节]南校区A-110\",\"KKDW_DISPLAY\":\"数学与统计学院\",\"RZLBDM\":null,\"BJDM\":\"20201-007-X2MS1012-1597912995976\",\"KCMCYW\":\"Matrix Analysis and Computation\",\"BJMC\":\"矩阵分析与计算01\",\"PKSJ\":\"4-17周 星期一[5-6节];4-17周 星期三[5-6节];17-18周 星期四[5-6节]\",\"BY7\":null,\"BY8\":null,\"BY9\":null,\"KCDM\":\"X2MS1012\",\"BY10\":null,\"SCSKRQ\":\"2020-09-21\"},{\"BY6\":null,\"BY5\":null,\"XDFSDM\":\"0\",\"BY4\":null,\"RKJS\":\"周水生\",\"BY3\":null,\"WID\":\"bd5df617e080451684cabbd2e1441731\",\"BY2\":null,\"SKXS_DISPLAY\":\"\",\"BY1\":null,\"XKRS\":\"21\",\"KKDW\":\"007\",\"SKFSDM_DISPLAY\":\"讲授课程\",\"XH\":\"20071212623\",\"ORDERFILTER\":null,\"PKDD\":\"南校区C504\",\"KCFLDM\":\"1\",\"KCMC\":\"数据挖掘中的数学方法\",\"SKFSDM\":\"01\",\"SKXS\":null,\"XQDM_DISPLAY\":\"南校区\",\"XQDM\":\"01\",\"XNXQDM\":\"20201\",\"XKBZ\":null,\"KCXZDM\":\"1\",\"XNXQDM_DISPLAY\":\"2020秋\",\"YXYWMC\":null,\"XNXQYWMC\":null,\"PKSJDD\":\"4-13周 星期二[9-11节]南校区C504;4,6-13周 星期五[7-8节]南校区C504\",\"KKDW_DISPLAY\":\"数学与统计学院\",\"RZLBDM\":null,\"BJDM\":\"20201-007-X2MS1033-1597912996039\",\"KCMCYW\":\"Mathematical methods in data mining\",\"BJMC\":\"数据挖掘中的数学方法01\",\"PKSJ\":\"4-13周 星期二[9-11节];4,6-13周 星期五[7-8节]\",\"BY7\":null,\"BY8\":null,\"BY9\":null,\"KCDM\":\"X2MS1033\",\"BY10\":null,\"SCSKRQ\":\"2020-09-22\"},{\"BY6\":null,\"BY5\":null,\"XDFSDM\":\"0\",\"BY4\":null,\"RKJS\":\"冯象初\",\"BY3\":null,\"WID\":\"d9565f15acf74ad1865f1152c52af7b4\",\"BY2\":null,\"SKXS_DISPLAY\":\"\",\"BY1\":null,\"XKRS\":\"14\",\"KKDW\":\"007\",\"SKFSDM_DISPLAY\":\"讲授课程\",\"XH\":\"20071212623\",\"ORDERFILTER\":null,\"PKDD\":\"南校区A-106\",\"KCFLDM\":\"1\",\"KCMC\":\"多尺度分析与估计\",\"SKFSDM\":\"01\",\"SKXS\":null,\"XQDM_DISPLAY\":\"南校区\",\"XQDM\":\"01\",\"XNXQDM\":\"20201\",\"XKBZ\":null,\"KCXZDM\":\"1\",\"XNXQDM_DISPLAY\":\"2020秋\",\"YXYWMC\":null,\"XNXQYWMC\":null,\"PKSJDD\":\"4-15周 星期二[7-8节]南校区A-106;4,6-16周 星期五[3-4节]南校区A-106\",\"KKDW_DISPLAY\":\"数学与统计学院\",\"RZLBDM\":null,\"BJDM\":\"20201-007-X2MS1052-1597974974899\",\"KCMCYW\":\"Multiresolution Analysis and Estimation\",\"BJMC\":\"多尺度分析与估计01\",\"PKSJ\":\"4-15周 星期二[7-8节];4,6-16周 星期五[3-4节]\",\"BY7\":null,\"BY8\":null,\"BY9\":null,\"KCDM\":\"X2MS1052\",\"BY10\":null,\"SCSKRQ\":\"2020-09-22\"}]");
        File file = FileUtil.file("./course.csv");
        CsvWriter writer = CsvUtil.getWriter(file, CharsetUtil.CHARSET_UTF_8);
        List<String[]> writeData = new ArrayList<>();
        Course title = Course.builder().courseName("课程名称").week("星期").beginStage("开始节数").
                endStage("结束节数").teacher("老师").address("地点").studyWeek("周数").build();
        writeData.add(title.toStringArray());

        dataList.forEach(tmp -> {
            JSONObject data = (JSONObject) tmp;
            if(data.get("PKSJDD") != null){
                //4,6-15周 星期五[9-10节]南校区B433;4,6-14周 星期五[11-11节]南校区B433
                for (String PKSJDD : data.getString("PKSJDD").split(";")) {
                    Course course = Course.builder().courseName(data.getString("KCMC")).teacher(data.getString("RKJS")).build();
                    course.setAddress(PKSJDD.split("]")[1]);
                    course.setStudyWeek(StrUtil.removeSuffix(PKSJDD.split(" ")[0],"周").replace(',','、'));
                    course.setWeek(caseConversion(PKSJDD.split("星期")[1].charAt(0)));
                    String stage = PKSJDD.split("\\[")[1].split("节")[0];
                    course.setBeginStage(stage.split("-")[0]);
                    course.setEndStage(stage.split("-")[1]);
                    writeData.add(course.toStringArray());
                }
            }
        });
        writer.write(writeData);
    }

    public static String caseConversion(char week){
        String result = "0";
        switch (week){
            case '一':
                result = "1";
                break;
            case '二':
                result = "2";
                break;
            case '三':
                result = "3";
                break;
            case '四':
                result = "4";
                break;
            case '五':
                result = "5";
                break;
            case '六':
                result = "6";
                break;
            case '日':
                result = "7";
                break;
            default:
                result = "0";
        }
        return result;
    }

}
