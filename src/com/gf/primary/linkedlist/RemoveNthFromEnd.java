package com.gf.primary.linkedlist;

/*
 * Author guanfei
 * Date 2018/8/19
 * Coding Forever
 *

 * 删除链表的倒数第N个节点
给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。

示例：

给定一个链表: 1->2->3->4->5, 和 n = 2.

当删除了倒数第二个节点后，链表变为 1->2->3->5.
说明：

给定的 n 保证是有效的。

进阶：

你能尝试使用一趟扫描实现吗？
 */
public class RemoveNthFromEnd {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return null;

        int length = 0;
        ListNode cur = head;
        while(cur != null){
            cur = cur.next;
            length++;
        }
        if(n > length || n <= 0) return null;

        cur = head;
        int fromHead = length - n;
        for(int i=1; i<fromHead; i++){
            cur = cur.next;
        }
        ListNode deleted = cur.next;
        cur.next = deleted.next;
        deleted.next = null;
        return head;
    }

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        if(head == null || n <= 0) return null;
        int length = 0;
        ListNode position = null;
        ListNode fromHead = head;
        ListNode cur = head;
        while(cur != null){
            length++;
            cur = cur.next;
            if(length > n){
                position = fromHead;
                fromHead = fromHead.next;
            }
        }
        if(n == length){
            head = head.next;
            return head;
        }
        if(position == null) return null;
        ListNode deleted = position.next;
        position.next = deleted.next;
        deleted.next = null;
        return head;
    }



    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);

        listNode.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;

        RemoveNthFromEnd removeNthFromEnd = new RemoveNthFromEnd();
        ListNode head = removeNthFromEnd.removeNthFromEnd2(listNode, 5);
        System.out.println();
    }
}
