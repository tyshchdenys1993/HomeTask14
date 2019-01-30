package com.lesson02hometask;

import java.util.*;

public class HashSetCompareLinkedList {
    public static void main(String[] args) {
        Set<String> hashSet = new HashSet<>();
        hashSet.add("pineapple");
        hashSet.add("watermelon");
        hashSet.add("apple");
        hashSet.add("pear");
        hashSet.add("quince");
        hashSet.add("lemon");
        hashSet.add("kiwi");

        List<String> linkedList = new LinkedList<>();
        linkedList.add("plum");
        linkedList.add("nut");
        linkedList.add("apple");
        linkedList.add("grape");
        linkedList.add("peach");
        linkedList.add("pear");
        linkedList.add("cherry");
        linkedList.add("orange");
        linkedList.add("watermelon");
        linkedList.add("apricot");
        linkedList.add("pineapple");

        Iterator beforeIterator = hashSet.iterator();
        System.err.println("Set before manipulation: ");
        while(beforeIterator.hasNext()){
            System.out.println(beforeIterator.next());
        }

        System.err.println("LinkedList: ");
        for (String s : linkedList) {
            System.out.println(s);
        }

        for (String s : linkedList) {
            if(hashSet.contains(s)){
                hashSet.retainAll(linkedList);
            }
        }

        Iterator afterIterator = hashSet.iterator();
        System.err.println("Set after manipulation: ");
        while(afterIterator.hasNext()){
            System.out.println(afterIterator.next());
        }
    }
}
