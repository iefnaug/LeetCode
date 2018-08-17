package com.gf.primary.linkedlist;

/*
 * Author guanfei
 * Date 2018/8/14
 * Coding Forever
 *
 *
 *
给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。

说明：不允许修改给定的链表。

进阶：
你是否可以不用额外空间解决此题？
 */
public class DetectCycle {

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
     *2 * slow = fast
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) return null;

        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) break;
        }
        if(fast == null || fast.next == null)
            return null;

        slow = head;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
     }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        ListNode cur = head;
        ListNode cur90 = null;
        for(int i=2; i<100; i++){
            head.next = new ListNode(i);
            head = head.next;
            if(i==90){
                cur90 = head;
            }
        }
        ListNode cur100 = new ListNode(100);
        head.next = cur100;
        cur100.next = cur90;

        DetectCycle detectCycle = new DetectCycle();
        ListNode listNode = detectCycle.detectCycle(cur);
        System.out.println(listNode.val);
    }
}
