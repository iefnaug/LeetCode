package com.gf.primary.linkedlist;

/*
 * Author guanfei
 * Date 2018/8/14
 * Coding Forever
 *
 *
 *  给定一个链表，判断链表中是否有环。

    进阶：
    你能否不使用额外空间解决此题？
 *
 */
public class HasCycle {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
          val = x;
          next = null;
        }

        ListNode addNext(int val){
            this.next = new ListNode(val);
            return this;
        }
    }

    /**
     * 使用快慢指针
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) return false;

        ListNode slow = head;
        ListNode fast = head.next;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);


        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode2;

        HasCycle hasCycle = new HasCycle();
        boolean result = hasCycle.hasCycle(listNode1);
        System.out.println(result);
    }

}
