package cn.zhumouren.leetcode;

/**
 * @author mourenZhu
 * @version 1.0
 * @description todo
 * @date 2022/7/16 19:38
 **/
public class AddTwoNumbers2 {
    public static void main(String[] args) {
        AddTwoNumbers2 x = new AddTwoNumbers2();

    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {


        int isAdd = 0;
        ListNode lStart = null;
        ListNode last = null;


        while (l1 != null || l2 != null) {
            ListNode temp = new ListNode(getSumVal(l1, l2, isAdd));
            if (lStart == null) {
                lStart = temp;
            }
            isAdd = isAdd(l1, l2, isAdd);
            if (last == null) {
                last = lStart;
            } else {
                last.next = temp;
                last = last.next;
            }

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (isAdd == 1) {
            last.next = new ListNode(1);
        }
        return lStart;
    }

    public int getSumVal(ListNode l1, ListNode l2, int isAdd) {
        int i1 = 0;
        int i2 = 0;
        if (l1 != null) {
            i1 = l1.val;
        }
        if (l2 != null) {
            i2 = l2.val;
        }
        return (i1 + i2 + isAdd) % 10;
    }

    public int isAdd(ListNode l1, ListNode l2, int isAdd) {
        if (l1 != null && l2 != null) {
            if (l1.val + l2.val + isAdd >= 10){
                return 1;
            }
        }
        if (l1 != null) {
            if (l1.val + isAdd >= 10) {
                return 1;
            }
        }
        if (l2 != null) {
            if (l2.val + isAdd >= 10) {
                return 1;
            }
        }
        return 0;
    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}

