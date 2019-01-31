package com.lesson03hometask;

public class Runner {
    public static void main(String[] args) {

        PrintClass printClass = new PrintClass();

        System.out.println(printClass.returnDayNameByNum(1));
        System.out.println(printClass.returnDayNumByName("Monday"));
        printClass.printPhrase();

        MonthClass monthClass = new MonthClass(12);

        System.out.println(monthClass.getMonthNameByNum());
        monthClass.printPhrase();
    }
}
