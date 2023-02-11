package cn.zhumouren.leetcode.swordoffer;

import java.util.ArrayDeque;
import java.util.Deque;

public class Offer9 {
    public static void main(String[] args) {
        CQueue cQueue = new CQueue();
        System.out.println(cQueue.deleteHead());
        cQueue.appendTail(1);
        cQueue.appendTail(2);
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
    }

    /**
     * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
     * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
     */
    static class CQueue {

        // 加入的元素放入d1
        private Deque<Integer> d1 = new ArrayDeque<>();
        // 删除的元素从d2出去
        private Deque<Integer> d2 = new ArrayDeque<>();

        public CQueue() {

        }

        public void appendTail(int value) {
            d1.offerFirst(value);
        }

        public int deleteHead() {
            if (d2.isEmpty()) {
                while (!d1.isEmpty()) {
                    d2.offerFirst(d1.pollLast());
                }
            }
            if (d2.isEmpty()) {
                return -1;
            }
            return d2.pollLast();
        }
    }
}
