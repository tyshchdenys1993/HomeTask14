package com.hometaskaqacourses;

public class ParseVariables {
    public static void main(String[] args) {

        int varInt = 23;
        double varDouble;
        String varString;

        varString = String.valueOf(varInt);
        varDouble = Double.parseDouble(varString);
        varInt = (int)varDouble;

        System.out.println(varString);
        System.out.println(varDouble);
        System.out.println(varInt);
    }
}
