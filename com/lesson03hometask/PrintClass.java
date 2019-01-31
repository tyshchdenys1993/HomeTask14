package com.lesson03hometask;

public class PrintClass implements InterfacePrint {

    @Override
    public void printPhrase() {
        System.out.println("Some phrase 01");
    }

    private int numOfDay;
    private String name;

    @Override
    public String returnDayNameByNum(int numOfDay) {
        this.numOfDay = numOfDay;
        switch (numOfDay) {
            case 1:
                name = DaysOfWeek.MONDAY.getName();
                break;
            case 2:
                name = DaysOfWeek.TUESDAY.getName();
                break;
            case 3:
                name = DaysOfWeek.WEDNESDAY.getName();
                break;
            case 4:
                name = DaysOfWeek.THURSDAY.getName();
                break;
            case 5:
                name = DaysOfWeek.FRIDAY.getName();
                break;
            case 6:
                name = DaysOfWeek.SATURDAY.getName();
                break;
            case 7:
                name = DaysOfWeek.SUNDAY.getName();
                break;
                default: name = "Enter day from 1 to 7";
                break;
        }
        return name;
    }

    @Override
    public int returnDayNumByName(String name) {
        this.name = name;
        switch (name){
            case "Monday":
                numOfDay = DaysOfWeek.MONDAY.getIndexNumber();
                break;
            case "Tuesday":
                numOfDay = DaysOfWeek.TUESDAY.getIndexNumber();
                break;
            case "Wednesday":
                numOfDay = DaysOfWeek.WEDNESDAY.getIndexNumber();
                break;
            case "Thursday":
                numOfDay = DaysOfWeek.THURSDAY.getIndexNumber();
                break;
            case "Friday":
                numOfDay = DaysOfWeek.FRIDAY.getIndexNumber();
                break;
            case "Saturday":
                numOfDay = DaysOfWeek.SATURDAY.getIndexNumber();
                break;
            case "Sunday":
                numOfDay = DaysOfWeek.SUNDAY.getIndexNumber();
                break;
            default:
                System.out.println("Enter correct day name");
                break;
        }
        return numOfDay;
    }
}
