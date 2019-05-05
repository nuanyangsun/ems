package com.qhit.test;

import java.util.Arrays;

/**
 * Created by 94292 on 2019/4/27.
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr={9};
//        insertSort(arr);
        System.out.println(Arrays.toString(insertSort(arr)));
    }

    private static int[] insertSort(int[] arr) {
        if (arr==null || arr.length<=1){
            return arr;
        }
        for (int i=1;i<=arr.length-1;i++){

        }
        return arr;
    }
}
