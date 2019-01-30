package com.lesson02hometask;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListHomeTask {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("First");
        list.add("Second");
        list.add("Third");
        list.add("Fourth");

        Collections.reverse(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
