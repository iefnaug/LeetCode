package com.gf.primary.linkedlist;

/*
 * Author guanfei
 * Date 2018/9/5
 * Coding Forever
 *
    复制带随机指针的链表
    给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
    要求返回这个链表的深度拷贝。
 *
 */
public class CopyRandomList {

    class RandomListNode {
        int label;
        RandomListNode next, random;
        RandomListNode(int x) { this.label = x; }
    }

    /**
     * 超出时间限制
     * @param head
     * @return
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) return head;
        RandomListNode retainHead = head;
        RandomListNode retainHead2 = head;

        //1.先复制整个链表，再考虑随机指针
        RandomListNode newList = new RandomListNode(0);
        RandomListNode newList2 = newList;
        while(head != null){
            newList.next =  new RandomListNode(head.label);
            newList = newList.next;
            head = head.next;
        }
        RandomListNode retainNewList = newList2.next;
        RandomListNode retainNewList2 = newList2.next;

        //2.添加随机指针
        while(retainNewList != null){
            if(retainHead.random != null){
                RandomListNode temp = retainHead2;
                int step = 0;
                while(temp != null){//查找第几个节点是当前节点随机指针指向的节点
                    step++;
                    if(temp == retainHead.random) break;
                }

                temp = retainNewList2;
                for(int i=1; i<step; i++){
                    temp = temp.next;
                }
                retainNewList.random = temp;
            }
            retainHead = retainHead.next;
            retainNewList = retainNewList.next;
        }
        return retainNewList2;
    }


    /**
     * 将新链表交替插入老链表
     * @param head
     * @return
     */
    public RandomListNode copyRandomList2(RandomListNode head) {
        if(head == null) return null;
        RandomListNode retainHead = head;
        RandomListNode retainHead2 = head;
        //1.将复制的链表交替插入原链表: 12121212....
        while(head != null){
            RandomListNode randomListNode = new RandomListNode(head.label);
            RandomListNode headNext = head.next;
            head.next = randomListNode;
            randomListNode.next = headNext;
            head = headNext;
        }

        //2.遍历链表为random指针赋值
        while(retainHead != null){
            retainHead.next.random = retainHead.random == null ? null : retainHead.random.next;
            retainHead = retainHead.next.next;
        }

        //3.断开链表，重新组合新链表
        RandomListNode newList = retainHead2.next;
        RandomListNode newList2 = retainHead2.next;
        while(newList != null){
            if(newList.next != null){
                newList.next = newList.next.next;
                newList = newList.next;
            }
        }
        return newList2;
    }




}
