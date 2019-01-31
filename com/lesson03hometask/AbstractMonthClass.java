package com.lesson03hometask;

public abstract class AbstractMonthClass {


    private int numOfMonth;

    AbstractMonthClass(int numOfMonth){
        this.numOfMonth = numOfMonth;
    }

    abstract void printPhrase();

    public enum Month {
        JANUARY,
        FEBRUARY,
        MARCH,
        APRIL,
        MAY,
        JUNE,
        JULY,
        AUGUST,
        SEPTEMBER,
        OCTOBER,
        NOVEMBER,
        DECEMBER;
    }

    private Month getMonthName;
    public Month getMonthNameByNum (){
        switch (numOfMonth) {
            case 1:
                getMonthName = Month.JANUARY;
            break;
            case 2:
                getMonthName = Month.FEBRUARY;
            break;
            case 3:
                getMonthName = Month.MARCH;
            break;
            case 4:
                getMonthName = Month.APRIL;
            break;
            case 5:
                getMonthName = Month.MAY;
            break;
            case 6:
                getMonthName = Month.JUNE;
            break;
            case 7:
                getMonthName = Month.JULY;
            break;
            case 8:
                getMonthName = Month.AUGUST;
            break;
            case 9:
                getMonthName = Month.SEPTEMBER;
            break;
            case 10:
                getMonthName = Month.OCTOBER;
            break;
            case 11:
                getMonthName = Month.NOVEMBER;
            break;
            case 12:
                getMonthName = Month.DECEMBER;
            break;
            default:
                System.out.println("Enter number from 1 to 12 during object's creation");
        }
        return getMonthName;
    }
}
