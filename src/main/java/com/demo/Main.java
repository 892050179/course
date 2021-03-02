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
        JSONObject relData = readData().getJSONObject("datas").getJSONObject("xsjxrwcx");
        JSONArray dataList = relData.getJSONArray("rows");
        File file = FileUtil.file("C:\\Users\\Administrator\\Desktop\\course.csv");
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
        System.out.println("ok.");
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

    private static JSONObject readData(){
        String data = "***";
        return JSON.parseObject(data);
    }

}
