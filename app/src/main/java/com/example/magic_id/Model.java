package com.example.magic_id;

public class Model {

    private String year;
    private String month;
    private String day;
    private String gender;

    public Model(){

    }

    public Model(String year, String month, String day, String gender) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }
}
