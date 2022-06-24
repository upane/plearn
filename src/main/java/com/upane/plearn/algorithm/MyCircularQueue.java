package com.upane.plearn.algorithm;

/**
 * Description: 先进先出循环队列 设计
 * 自己写不来 只能看答案  结合动图算是理解
 * 感觉这设计就很灵活  牛的
 * <p>
 * FIFO first in first out
 *
 * @Author:pan
 * @Date:2022/6/16
 */
public class MyCircularQueue {

    private int[] queue;
    private int headIndex;
    private int count;
    private int capacity;


    public MyCircularQueue(int k) {
        this.capacity = k;
        this.queue = new int[k];
        this.headIndex = 0;
        this.count = 0;
    }

    public boolean enQueue(int value) {
        if (this.count == this.capacity) return false;
        this.queue[(this.headIndex + this.count) % this.capacity] = value;
        this.count += 1;
        return true;
    }

    public boolean deQueue() {
        if (this.count == 0) {
            return false;
        }
        // 好像就是头指针  移动了位置
        // oo 这是先进先出的队列所以 头指针移动
        this.headIndex = (this.headIndex + 1) % this.capacity;
        this.count -= 1;
        return true;

    }

    public int Front() {
        // 别忘记对0的判断
        if (this.count == 0) {
            return -1;
        }
        return this.queue[this.headIndex];
    }

    public int Rear() {
        if (this.count == 0) {
            return -1;
        }
        return this.queue[(this.headIndex + this.count - 1) % this.capacity];
    }

    public boolean isEmpty() {
        return (this.count == 0);

    }

    public boolean isFull() {
        return (this.count == this.capacity);

    }
}
