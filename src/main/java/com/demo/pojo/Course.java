package com.demo.pojo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Course {

    private String courseName;

    private String week;

    private String beginStage;

    private String endStage;

    private String teacher;

    private String address;

    private String studyWeek;

    public String[] toStringArray(){
        return new String[]{this.courseName,this.week,this.beginStage,this.endStage,this.teacher,this.address,this.studyWeek};
    }

}
