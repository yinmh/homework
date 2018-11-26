package org.ymh.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class IteratorDemo {
    public static void main(String[] args) {
        //List集合遍历
        ArrayList<String> list = new ArrayList<String>();
        list.add("张三");
        list.add("李四");
        list.add("王五");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            System.out.println(next);
        }
        //Set集合遍历
        HashSet<String> set = new HashSet<>();
        Iterator<String> iterator1 = set.iterator();
        while (iterator.hasNext()) {
            String next = iterator1.next();
            System.out.println(next);
        }

    }
}
