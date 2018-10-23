package com.gf.leetcode.queue;

/*
 * Author guanfei
 * Date 2018/10/23
 */


public class MyCircularQueue {

    private int[] elements;
    private int size;
    private int head;
    private int tail;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        if(k < 0){
            throw new RuntimeException("size can not less than zero");
        }
        elements = new int[k];
        size = 0;
        head = -1;
        tail = -1;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if(isFull()){
            return false;
        }
        tail = (tail+1) % elements.length;
        elements[tail] = value;
        size++;
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if(isEmpty()){
            return false;
        }
        head = (head+1) % elements.length;
        size--;
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        if(isEmpty()){
            return -1;
        }
        return elements[(head+1)%elements.length];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if(isEmpty()){
            return -1;
        }
        return elements[tail];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return size == elements.length;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */