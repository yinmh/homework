package org.ymh.design;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Strategy {
    public static void main(String[] args) {
        Integer[] arr ={5,4,3,54,48,41,56};
        Arrays.sort(arr, (Integer o1, Integer o2) ->
            -(o1 -o2)
        );
        System.out.println(Arrays.toString(arr));
    }
}
