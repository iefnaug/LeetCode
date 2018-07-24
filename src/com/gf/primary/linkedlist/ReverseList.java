package com.gf.primary.linkedlist;

/*
 * Author guanfei
 * Date 2018/7/24
 * Coding Forever
 */

public class ReverseList {

    public ListNode head = null;

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }


    static ListNode reverseList(ListNode head){
        if(head == null) return null;

        ListNode separateNode = null;
        while(head != null){
            ListNode temp = head.next;
            head.next = separateNode;
            separateNode = head;
            head = temp;
        }
        return separateNode;
    }

    public static void main(String[] args) {
        ReverseList reverseList = new ReverseList();
        ListNode current = null;
        for(int i=0; i<10; i++){
            if(reverseList.head == null){
                reverseList.head = new ListNode(i);
                current = reverseList.head;
            }else{
                current.next = new ListNode(i);
                current = current.next;
            }
        }

        ListNode iter = reverseList.head;

        iter = reverseList(iter);
        while(iter != null){
            System.out.print(iter.val + ",");
            iter = iter.next;
        }
    }

}
