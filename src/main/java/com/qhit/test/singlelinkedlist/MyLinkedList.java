package com.qhit.test.singlelinkedlist;

/**
 * Created by 94292 on 2019/4/28.
 */
public class MyLinkedList {


    private Node first;//链表的第一个节点
    private Node last;//链表的最后一个节点
    private int size=0;//集合

    //增加
    public void add(Node itself){
        Node node=new Node();
        if (first==null){
            node.setPrevious(null);
            node.setItself(itself);
            node.setNext(null);

            first=node;
            last=node;
        }
    }
}
