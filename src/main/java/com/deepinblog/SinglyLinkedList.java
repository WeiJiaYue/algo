package com.deepinblog;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by louisyuu on 2021/7/7 2:35 下午
 */
public class SinglyLinkedList<T> {


    private int capacity;

    private int idx;

    private Node head;

    private Node cur;

    public SinglyLinkedList(int capacity) {
        this.capacity = capacity;
    }

    public T getTail() {
        T data = cur.data;

        Node temp = head;
        while (temp != null) {
            if (temp.next == null) {
                cur = temp;
            }
            temp = temp.next;
        }

        return data;
    }


    public int add(T t) {
        if (head == null) {
            head = new Node(t, null);
            cur = head;
        } else {
            cur.next = new Node(t, null);
            cur = cur.next;
        }
        idx++;
        return 1;
    }


    public static void main(String[] args) {
//        SinglyLinkedList<Object> list = new SinglyLinkedList<>(1);
//
//        list.add("1");
//        list.add("2");
////        list.add("3");
//
//
//        System.out.println(list.getTail());
//        System.out.println(list.getTail());
//        System.out.println(list.getTail());


        int o = 1 << 4;

        int ss = 1 >>> 4;


        System.out.println(ss);

        System.out.println("2^3运算的结果是 :" + (2 ^ 3));
    }


    private class Node {
        T data;
        Node next;

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }


    }


}
