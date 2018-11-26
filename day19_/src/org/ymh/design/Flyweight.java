package org.ymh.design;

public class Flyweight {
    public static void main(String[] args) {
        Integer integer = new Integer(10);
        Integer integer1 = new Integer(100);
        Integer integer2 = new Integer(129);
        System.out.println(integer == integer1);
        System.out.println(integer == integer2);
    }
}
