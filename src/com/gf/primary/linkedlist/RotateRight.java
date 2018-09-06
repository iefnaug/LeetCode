package com.gf.primary.linkedlist;

/*
 * Author guanfei
 * Date 2018/9/6
 * Coding Forever
 *
 * 旋转链表
给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。

示例 1:

输入: 1->2->3->4->5->NULL, k = 2
输出: 4->5->1->2->3->NULL
解释:
向右旋转 1 步: 5->1->2->3->4->NULL
向右旋转 2 步: 4->5->1->2->3->NULL
示例 2:

输入: 0->1->2->NULL, k = 4
输出: 2->0->1->NULL
解释:
向右旋转 1 步: 2->0->1->NULL
向右旋转 2 步: 1->2->0->NULL
向右旋转 3 步: 0->1->2->NULL
向右旋转 4 步: 2->0->1->NULL
 */
public class RotateRight {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return null;
        if(k == 0) return head;
        //1.获取链表的长度, 获取最后一个节点的引用
        ListNode temp = head;
        ListNode temp2 = head;
        ListNode temp3 = head;
        int length = 0;
        ListNode lastNode = null;
        while(temp != null){
            length++;
            if(temp.next != null){
                temp = temp.next;
            }else{
                lastNode = temp;
                break;
            }
        }

        //2.获取右移的位置k, 重构链表
        k = k % length;
        if(k==0) return head;
        for(int i=1; i<length-k; i++){//循环结束，temp2指向新链表的尾节点
            temp2 = temp2.next;
        }

        ListNode newHead = temp2.next;
        temp2.next = null;
        lastNode.next = temp3;

        return newHead;
    }
}
