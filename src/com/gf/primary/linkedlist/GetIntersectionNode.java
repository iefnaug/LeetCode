package com.gf.primary.linkedlist;

/*
 * Author guanfei
 * Date 2018/8/17
 * Coding Forever
 *
 *
 * 相交链表
编写一个程序，找到两个单链表相交的起始节点。



例如，下面的两个链表：

A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗
B:     b1 → b2 → b3
在节点 c1 开始相交。



注意：

如果两个链表没有交点，返回 null.
在返回结果后，两个链表仍须保持原有的结构。
可假定整个链表结构中没有循环。
程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
 */
public class GetIntersectionNode {


    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * 获取链表的相交节点
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;

        if(headA == headB)
            return headA;

        ListNode A = headA;
        ListNode B = headB;

        int lengthA = 0; //链表A的节点数
        while(headA != null){
            lengthA++;
            headA = headA.next;
        }

        int lengthB = 0; //链表B的节点数
        while(headB != null){
            lengthB++;
            headB = headB.next;
        }

        if(headA != headB) return null; //如果末尾节点不同，一定没有相交

        ListNode start = null;
        ListNode end = null;
        int length = 0;

        if(lengthA >= lengthB){
            start = A;
            end = B;
            length = lengthA - lengthB;
        }else{
            start = B;
            end = A;
            length = lengthB - lengthA;
        }

        for(int i=0; i<length; i++){
            start = start.next;
        }
        while (start != null){
            if(start == end) return start;
            start = start.next;
            end = end.next;
        }
        return null;
    }


    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(2);
        ListNode d = new ListNode(6);
        ListNode e = new ListNode(2);
        ListNode f = new ListNode(2);
        ListNode g = new ListNode(2);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        f.next = g;
        g.next = d;

        GetIntersectionNode getIntersectionNode = new GetIntersectionNode();
        ListNode node = getIntersectionNode.getIntersectionNode(a, f);
        System.out.println(node == null ? -1 : node.val);

    }

}
