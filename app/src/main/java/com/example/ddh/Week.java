package com.example.ddh;

import com.example.ddh.Day;

public class Week {

    private Day day1;
    private Day day2;
    private Day day3;
    private Day day4;
    private Day day5;
    private Day day6;
    private Day day7;

    public Week(Day day1, Day day2, Day day3, Day day4, Day day5, Day day6, Day day7) {
        this.day1 = day1;
        this.day2 = day2;
        this.day3 = day3;
        this.day4 = day4;
        this.day5 = day5;
        this.day6 = day6;
        this.day7 = day7;
    }

    public Day getDay1() {
        return day1;
    }

    public void setDay1(Day day1) {
        this.day1 = day1;
    }

    public Day getDay2() {
        return day2;
    }

    public void setDay2(Day day2) {
        this.day2 = day2;
    }

    public Day getDay3() {
        return day3;
    }

    public void setDay3(Day day3) {
        this.day3 = day3;
    }

    public Day getDay4() {
        return day4;
    }

    public void setDay4(Day day4) {
        this.day4 = day4;
    }

    public Day getDay5() {
        return day5;
    }

    public void setDay5(Day day5) {
        this.day5 = day5;
    }

    public Day getDay6() {
        return day6;
    }

    public void setDay6(Day day6) {
        this.day6 = day6;
    }

    public Day getDay7() {
        return day7;
    }

    public void setDay7(Day day7) {
        this.day7 = day7;
    }
}
