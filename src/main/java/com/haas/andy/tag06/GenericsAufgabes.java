package com.haas.andy.tag06;

import java.util.*;

public class GenericsAufgabes {
    public static void main(String[] args) {
       List<String> namen = new ArrayList<>();
       namen.add("Forest");
       namen.add("Fridrich");
       namen.add("Folker");

        Set<Integer> integers =new HashSet<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        integers.add(5);

        Map<String, Double> map = new HashMap<>();
        map.put("Apfel", 2.99);
    }
}
