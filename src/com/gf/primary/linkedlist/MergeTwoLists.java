package com.gf.primary.linkedlist;
/*
 * Author guanfei
 * Date 2018/7/31
 * Coding Forever
 */

import java.io.*;


public class MergeTwoLists {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }

        ListNode addNext(int val){
            this.next = new ListNode(val);
            return this.next;
        }
    }

    /**
     * @param l1
     * @param l2
     * @return
     */
    static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        //保证l1的起始值总是小于等于l2的起始值
        ListNode start = l1;
        if(l1.val > l2.val){
            ListNode temp = l1;
            l1 = l2;
            l2 = temp;
            start = l1;
        }

        ListNode l1_pre = null;
        while (l2 != null){
            while(l1.val <= l2.val){
                l1_pre = l1;
                l1 = l1.next;
                if(l1 == null){
                    l1_pre.next = l2;
                    return start;
                }
            }
            ListNode next_l2 = l2.next;
            l1_pre.next = l2;
            l2.next = l1;
            l1_pre = l2;
            l2 = next_l2;
        }
        return start;
    }

    /**
     * 递归
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode head = null;
        if (l1.val <= l2.val){
            head = l1;
            head.next = mergeTwoLists(l1.next, l2);
        } else {
            head = l2;
            head.next = mergeTwoLists(l1, l2.next);
        }
        return head;
    }



    public static void main(String[] args) throws IOException {
        ListNode from = new ListNode(1);
        from.addNext(2).addNext(4);

        ListNode to = new ListNode(1);
        to.addNext(3).addNext(4);

        ListNode mergeList = mergeTwoLists2(from, to);
        System.out.println(mergeList);

    }
}
