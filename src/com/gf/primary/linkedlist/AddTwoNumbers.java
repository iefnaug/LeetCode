package com.gf.primary.linkedlist;

/*
 * Author guanfei
 * Date 2018/8/26
 * Coding Forever
 *
 *
 *
 * 两数相加
给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表。

你可以假设除了数字 0 之外，这两个数字都不会以零开头。

示例：

输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8
原因：342 + 465 = 807
 */
public class AddTwoNumbers {

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode newNodeList = null;
        ListNode newNodeListBegin = null;
        int addition = 0;
        for(;;){
            int value1 = 0;
            int value2 = 0;
            if(l1 != null){
                value1 = l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                value2 = l2.val;
                l2 = l2.next;
            }

            int position_num = value1 + value2 + addition;
            addition = position_num > 9 ? 1 : 0;
            position_num = addition > 0 ? (position_num - 10) : position_num;

            ListNode node = new ListNode(position_num);
            if(newNodeList == null){ //保留第一个节点引用
                newNodeList = node;
                newNodeListBegin = newNodeList;
            }else{
                newNodeList.next = node;
                newNodeList = node;
            }

            if(l1 == null && l2 == null){
                if(addition == 1){
                    node = new ListNode(addition);
                    newNodeList.next = node;
                }
                break;
            }

        }
        return newNodeListBegin;
    }
}
