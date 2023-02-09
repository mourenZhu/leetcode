package cn.zhumouren.leetcode.swordoffer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Offer6 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        System.out.println(Arrays.toString(reversePrint(null)));
        System.out.println(Arrays.toString(reversePrint2(listNode)));
    }

    /**
     * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
     */
    public static int[] reversePrint(ListNode head) {
        LinkedList<Integer> list = new LinkedList<>();
        ListNode now = head;
        while (now != null) {
            list.offerFirst(now.val);
            now = now.next;
        }
        return list.stream().mapToInt(i -> i).toArray();
    }

    public static int[] reversePrint2(ListNode head) {
        int numLength = 0;
        ListNode now = head;
        while (now != null) {
            numLength++;
            now = now.next;
        }
        int[] nums = new int[numLength];
        now = head;
        for (int i = numLength - 1; i >= 0; i--) {
            nums[i] = now.val;
            now = now.next;
        }
        return nums;
    }



    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


}

