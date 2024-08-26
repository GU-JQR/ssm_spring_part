package com.squ.entity;

/**
 * 学生类  (学号  姓名  年龄  性别)
 */
public class Student {
    private String stuno;
    private String stuname;
    private Integer stuage;
    private String gender;

    public void study(){
        System.out.println("好好学习,天天敲代码");

    }

    public Student() {
    }

    public Student(String stuno, String stuname, Integer stuage, String gender) {
        this.stuno = stuno;
        this.stuname = stuname;
        this.stuage = stuage;
        this.gender = gender;
    }

    public String getStuno() {
        return stuno;
    }

    public void setStuno(String stuno) {
        this.stuno = stuno;
    }

    public String getStuname() {
        return stuname;
    }

    public void setStuname(String stuname) {
        this.stuname = stuname;
    }


    public Integer getStuage() {
        return stuage;
    }

    public void setStuage(Integer stuage) {
        this.stuage = stuage;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuno='" + stuno + '\'' +
                ", stuname='" + stuname + '\'' +
                ", stuage='" + stuage + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
