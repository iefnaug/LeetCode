package com.gf.primary.linkedlist;

/*
 * Author guanfei
 * Date 2018/8/20
 * Coding Forever
 *
 * 删除链表中的节点
删除链表中等于给定值 val 的所有节点。

示例:

输入: 1->2->6->3->4->5->6, val = 6
输出: 1->2->3->4->5
 *
 */
public class RemoveElements {

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    public ListNode removeElements(ListNode head, int val) {
        if(head == null) return null;
        while(head != null && head.val == val){
            head = head.next;
        }
        ListNode prev = head;
        ListNode cur = head.next;
        while(cur != null){
            if(cur.val == val){
                ListNode temp = cur;
                prev.next = cur.next;
                cur = prev.next;
                temp.next = null;
            }else{
                prev = cur;
                cur = cur.next;
            }
        }
        return head;
    }

    /**
     * 递归实现
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements2(ListNode head, int val) {
        if(head == null) return null;
        head.next = removeElements2(head.next, val);
        return head.val == val ? head.next : head ;
    }
}
