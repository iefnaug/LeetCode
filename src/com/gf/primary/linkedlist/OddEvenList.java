package com.gf.primary.linkedlist;

/*
 * Author guanfei
 * Date 2018/8/26
 * Coding Forever
 *
 *
 *奇偶链表
给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。

请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。

示例 1:

输入: 1->2->3->4->5->NULL
输出: 1->3->5->2->4->NULL
示例 2:

输入: 2->1->3->5->6->4->7->NULL
输出: 2->3->6->7->1->5->4->NULL
说明:

应当保持奇数节点和偶数节点的相对顺序。
链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推。
 *
 */
public class OddEvenList {
    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    public ListNode oddEvenList(ListNode head) {
        if(head == null) return null;
        ListNode odd = new ListNode(-1);
        ListNode even = new ListNode(-1);
        ListNode odd_begin = odd;
        ListNode odd_end = null;
        ListNode even_begin = even;
        int i=1;
        while(head != null){
            if(i % 2 == 1){
               odd.next = head;
               odd_end = head;
               odd = odd.next;
            }else{
                even.next = head;
                even = even.next;
            }
            head = head.next;
            i++;
        }

        head = odd_begin.next;
        odd_end.next = even_begin.next;

        return head;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(6);
        ListNode listNode7 = new ListNode(7);

        listNode.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        listNode6.next = listNode7;

        OddEvenList oddEvenList = new OddEvenList();
        ListNode head = oddEvenList.oddEvenList(listNode);
        System.out.println(head);
    }
}
