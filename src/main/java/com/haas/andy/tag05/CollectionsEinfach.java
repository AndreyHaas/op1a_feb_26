package com.haas.andy.tag05;

import java.util.*;

public class CollectionsEinfach {
    public static void main(String[] args) {

        // List
        List<String> strings = new ArrayList<>();
        strings.add("Markus");
        strings.add("Jemand");
        strings.add("Andreas");

        Collections.sort(strings);
        System.out.println("Sorted Kollektion: " + strings);

        System.out.println(strings.contains("Joscha"));

        System.out.println("Erste kettenzeichen im Kollektion: " + strings.getFirst());
        System.out.println("Letzte kettenzeichen im Kollektion: " + strings.getLast());
        System.out.println("Kollektion groese: " + strings.size());

        // Set
        Set<String> stringSet = new HashSet<>();
        stringSet.add("Markus");
        stringSet.add("Jemand");
        stringSet.add("Andreas");
        stringSet.add("Markus");
        stringSet.add("Jemand");
        stringSet.add("Andreas");
        System.out.println("Werte in Set: " + stringSet);

        List<String> listFromSet = new ArrayList<>(stringSet.stream().toList());
        Collections.sort(listFromSet);
        System.out.println(listFromSet);


    }
}