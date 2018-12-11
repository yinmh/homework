package org.ymh.demo;

import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Demo {
    public static void main(String[] args) {
        //求最大值
        System.out.println(IntStream.of(45,32,65,95,7,85).max());
        //求最小值
        System.out.println(IntStream.of(45,32,65,95,7,85).min());
        //求平均值
        System.out.println(IntStream.of(45,32,65,95,7,85).average());
        //求和
        System.out.println(IntStream.of(45,32,65,95,7,85).sum());
    }
}

