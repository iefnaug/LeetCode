package com.gf.primary.linkedlist;

/*
 * Author guanfei
 * Date 2018/8/13
 * Coding Forever
 */
public class MyLinkedListDouble {

    class Node{
        int val;
        Node next, pre;
        Node(int val){
            this.val = val;
        }
    }

    private Node head;
    private int size;

    /** Initialize your data structure here. */
    public MyLinkedListDouble() {
        head = null;
        size = 0;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index >= size){
            return -1;
        }
        int seq = 0;
        Node cur = head;
        for(;;){
            if(index == seq){
                return cur.val;
            }
            seq++;
            cur = cur.next;
        }
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index > size){
            return;
        }

        if(index == 0){
            Node node = new Node(val);
            if(head != null)
                head.pre = node;
            node.next = head;
            node.pre = null;
            head = node;
        }else{
            Node cur = head;
            for(int i=0; i<index-1; i++){
                cur = cur.next;
            }
            Node node = new Node(val);
            if(cur.next != null)
                cur.next.pre = node;
            node.next = cur.next;
            cur.next = node;
            node.pre = cur;
        }
        size++;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index){

        if(index >= size){
            return;
        }

        if(index == 0){
            Node temp = head.next;
            head.next = null;
            head = temp;
            head.pre = null;
        }else{
            Node cur = head;
            for(int i=0; i<index-1; i++){
                cur = cur.next;
            }
            Node temp = cur.next;
            cur.next = temp.next;
            if(temp.next != null)
                temp.next.pre = cur;
        }
        size--;
    }

    public static void main(String[] args) {
        MyLinkedListDouble obj = new MyLinkedListDouble();
        int param_1 = obj.get(1);
        System.out.println(param_1);
        obj.addAtHead(1);
        obj.addAtTail(2);
        obj.addAtIndex(2,1);
        obj.deleteAtIndex(1);
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
