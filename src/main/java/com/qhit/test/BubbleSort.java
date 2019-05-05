package com.qhit.test;

import com.sun.org.apache.xpath.internal.SourceTree;

/**
 * Created by 94292 on 2019/4/27.
 */
public class BubbleSort {
    public static void main(String[] args) {
//        int[] arr=new int[]{9,3,6,2,4,5,7,8};
//        for (int i=0;i<arr.length-1;i++){ //外层循环下标从0开始,共n-2次，即：小于arr.length-1
//            for (int j=0;j<=i;j++){//内层循环下标从0开始,共n-2次，即：小于等于i
//                if (arr[j]>arr[j+1]){
//                    int temp=arr[j+1];
//                    arr[j+1]=arr[j];
//                    arr[j]=temp;
//                }
//            }
//        }
//       for (int i:arr){
//           System.out.print(i);
//       }

        int[] arr=new int[]{9,3,6,2,4,5,7,8};
        bubbleSort(arr);
        bubbleSort1(arr);
    }

    private static void bubbleSort1(int[] arr) {
        for (int i=0;i<arr.length;i++){
          for (int j=1;j<=arr.length-1;j++){
              if (arr[i]>arr[j]){
                  int temp=arr[i];
                  arr[i]=arr[j];
                  arr[j]=temp;
              }
          }

        }
        for(int i:arr){
            System.out.println(i);
        }
    }
    private static void bubbleSort(int[] arr) {
        for (int i=1;i<arr.length;i++){
            for (int j=1;j<=i;j++){
                if(arr[j-1]>arr[j]){
                    int temp=arr[j];
                    arr[j]=arr[j-1];
                    arr[j-1]=temp;
                }
            }
        }
//        for(int i:arr){
//            System.out.println(i);
//        }
    }

}
