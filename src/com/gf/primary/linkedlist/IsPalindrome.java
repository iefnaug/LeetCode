package com.gf.primary.linkedlist;

/*
 * Author guanfei
 * Date 2018/8/9
 * Coding Forever
 *
 * 请判断一个链表是否为回文链表。

    示例 1:

    输入: 1->2
    输出: false
    示例 2:

    输入: 1->2->2->1
    输出: true
    进阶：
    你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 */
public class IsPalindrome {

    public static class ListNode {
        int val;
        ListNode next;
        public ListNode(int x) { val = x; }

        ListNode addNext(int  value){
            this.next = new ListNode(value);
            return this.next;
        }
    }

    /**
     *方案一: 将链表数据放入数组，对数组进行回文判断， 时间复杂度O(n)
     * @param head
     * @return
     */
    static boolean isPalindrome(ListNode head) {
        int length = 0;
        ListNode forLength = head;
        while(forLength != null){ //寻找链表长度
            length++;
            forLength = forLength.next;
        }
        int value[] = new int[length];

        for(int i=0; i<length; i++){ //将链表的值copy到数组
            value[i] = head.val;
            head = head.next;
        }

        for(int i=0; i<length/2; i++){
            if(value[i] != value[length - 1 -i]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.addNext(2)
                .addNext(3)
                .addNext(4)
                .addNext(5)
                .addNext(4)
                .addNext(3)
                .addNext(2)
                .addNext(1);

        System.out.println(isPalindrome(head));
    }
}
