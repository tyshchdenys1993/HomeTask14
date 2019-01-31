package com.lesson03hometask;

public class MonthClass extends AbstractMonthClass {

    MonthClass(int numOfMonth) {
        super(numOfMonth);
    }

    @Override
    void printPhrase() {
        System.out.println("Some Phrase 02");
    }
}
