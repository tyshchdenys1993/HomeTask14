package com.lesson02hometask;

import java.util.HashMap;
import java.util.Map;

public class HashMapHomeTask {
    public static void main(String[] args) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("Test", 7);
        hashMap.put("Class",4.5);
        hashMap.put("Cat", true);
        hashMap.put("Dog", null);
        hashMap.put("Bird", "Cat");
        hashMap.put("Something", new Long(83));
        hashMap.put("Mail", new Character('8'));
        hashMap.put("Tab", '2');
        hashMap.put("Browser", 22222222222L);
        hashMap.put("IDE", (double)489);

        for (Map.Entry<String, Object> stringObjectEntry : hashMap.entrySet()) {
            System.out.println(("key: " + stringObjectEntry.getKey()) + " value: " + stringObjectEntry.getValue());
        }
    }
}
