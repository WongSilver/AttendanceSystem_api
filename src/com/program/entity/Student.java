package com.program.entity;

public class Student {
    public static String SEXNAN = "男";
    public static String SEXNV = "女";
    public static String SEX = "未填写";
    private int id;
    private int calss_id;
    private int sex;
    private String uNum;
    private String uName;
    private String password;
    private String phone;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCalss_id() {
        return calss_id;
    }

    public void setCalss_id(int calss_id) {
        this.calss_id = calss_id;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getuNum() {
        return uNum;
    }

    public void setuNum(String uNum) {
        this.uNum = uNum;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
