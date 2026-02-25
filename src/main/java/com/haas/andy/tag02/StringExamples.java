package com.haas.andy.tag02;

public class StringExamples {
    static void main() {
        String a = "Hallo";
        String b = "nicht Hallo";
        String c = "post@post.com";
        System.out.println(a.equals(b));
        System.out.println(a.toLowerCase());
        System.out.println(a.toUpperCase());
        System.out.println(a.charAt(0));
        System.out.println(a.contains("ll"));
        System.out.println(a.contains("ll"));
        System.out.println(a.endsWith("h"));
        System.out.println(a.endsWith("o"));
        System.out.println(a.isBlank());
        System.out.println(c.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$"));
        System.lineSeparator();
    }
}
