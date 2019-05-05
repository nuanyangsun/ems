package com.qhit.test;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;

/**
 * Created by 94292 on 2019/4/28.
 */
public class List {
    public static void main(String[] args) {
        LinkedList linkedList=new LinkedList();
        Date date=new Date();
        long startTime = date.getTime();
        for (int i=1;i<1000;i++){
            linkedList.add(i);
        }
        System.out.println("长度："+linkedList.size());
        long endTime = date.getTime();
        System.out.println("时长："+startTime+endTime);

    }
}
