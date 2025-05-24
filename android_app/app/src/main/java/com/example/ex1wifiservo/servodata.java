package com.example.ex1wifiservo;

public class servodata {
    String min1;
    String hour1;
     String min2;
    String hour2;
     String min3;
    String hour3;
    String  min4;
    String  hour4;


    public String getMin1() {
        return min1;
    }

    public String getHour1() {
        return hour1;
    }

    public String getMin2() {
        return min2;
    }

    public String getHour2() {
        return hour2;
    }

    public String getMin3() {
        return min3;
    }

    public String getHour3() {
        return hour3;
    }

    public String getMin4() {
        return min4;
    }

    public String getHour4() {
        return hour4;
    }

    public servodata(String min1, String hour1, String min2, String hour2, String min3, String hour3, String min4, String hour4) {
        this.min1 =  min1;
        this.hour1 = hour1;
        this.min2 = min2;
        this.hour2 = hour2;
        this.min3 = min3;
        this.hour3 = hour3;
        this.min4 = min4;
        this.hour4 = hour4;
    }
}
