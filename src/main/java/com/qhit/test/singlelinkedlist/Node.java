package com.qhit.test.singlelinkedlist;

/**
 * Created by 94292 on 2019/4/28.
 */
public class Node {

     Node previous;//上一个节点
     Node itself;//本身节点
     Node next;//下一个节点


    public Node() {

    }

    public Node(Node previous, Node itself, Node next) {
        this.previous = previous;
        this.itself = itself;
        this.next = next;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    public Node getItself() {
        return itself;
    }

    public void setItself(Node itself) {
        this.itself = itself;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
