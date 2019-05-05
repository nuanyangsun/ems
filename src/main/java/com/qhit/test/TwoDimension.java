package com.qhit.test;

/**
 * Created by 94292 on 2019/4/27.
 */
public class TwoDimension {
    public static void main(String[] args) {
        int[][] arr={{1,2,3,4,5,6,7,8,9},
                    {1,2,3,4,5,6,7,8,9},
                    {1,2,3,4,5,6,7,8,9},
                    {1,2,3,4,5,6,7,8,9}
                };
        int num=42;
        find(arr,num);

    }

    private static void find(int[][] arr, int num) {
        for (int i=0;i<arr.length;i++){
            for (int j=0;j<arr[i].length;j++){
                if (arr[i][j]==num){
                    System.out.println(num+"出现在第"+(i+1)+"行，"+"第"+(j+1)+"列");
                }
            }
        }
    }
}
