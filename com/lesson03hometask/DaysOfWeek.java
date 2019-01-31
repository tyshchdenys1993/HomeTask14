package com.lesson03hometask;

public enum DaysOfWeek {

    MONDAY("Monday",1),
    TUESDAY("Tuesday",2),
    WEDNESDAY("Wednesday",3),
    THURSDAY("Thursday", 4),
    FRIDAY("Friday", 5),
    SATURDAY("Saturday",6),
    SUNDAY("Sunday",7);

    private String name;
    private int indexNumber;

    DaysOfWeek(String name, int indexNumber){
        this.name = name;
        this.indexNumber = indexNumber;
    }

    public String getName() {
        return name;
    }

    public int getIndexNumber() {
        return indexNumber;
    }
}
