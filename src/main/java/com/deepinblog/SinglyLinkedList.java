package com.deepinblog;


/**
 * Created by louisyuu on 2021/7/7 2:35 下午
 */
public class SinglyLinkedList<T> {


    private int capacity;


    private Node head;


    public SinglyLinkedList(int capacity) {
        this.capacity = capacity;
    }


    public T getFirst() {
        T data = head.data;
        head.data = null;
        head = head.next;
        return data;
    }

    public T getLast() {

        Node tail = head;

        if (tail.next == null) {
            T data = tail.data;
            tail.data = null;
            return data;
        } else {
            Node pre = null;
            while (tail.next != null) {
                pre = tail;
                tail = tail.next;
            }

            T data = tail.data;
            tail.data = null;
            pre.next = null;
            return data;
        }
    }

    public void addFirst(T t) {
        Node newNode = new Node(t, null);
        newNode.next = head;
        head = newNode;
    }

    public void addLast(T t) {
        Node newNode = new Node(t, null);
        if (head == null) {
            //空链表，可以插入新节点作为head，也可以不操作
            head = newNode;
        } else {
            Node tail = head;
            while (tail.next != null) {
                tail = tail.next;
            }
            tail.next = newNode;
        }
    }


    private class Node {
        T data;
        Node next;

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }


    public static void main(String[] args) {

        SinglyLinkedList<String> list = new SinglyLinkedList<>(1);
        list.addLast("1");
        list.addLast("2");
        list.addLast("3");

        list.addFirst("First");
        list.addFirst("First First");

        System.out.println("First = " + list.getFirst());
        System.out.println("Last = " + list.getLast());
        System.out.println("Last = " + list.getLast());
        System.out.println("Last = " + list.getLast());
        System.out.println("Last = " + list.getLast());

    }


}
