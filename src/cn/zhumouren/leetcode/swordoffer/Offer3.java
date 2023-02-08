package cn.zhumouren.leetcode.swordoffer;

import java.util.Arrays;

public class Offer3 {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 0, 2, 5, 3};
        System.out.println(findRepeatNumber(nums));
        System.out.println(findRepeatNumberNotRevise(new int[]{2, 3, 5, 4, 3, 2, 6, 7}));
    }

    /**
     * 题目 一 ：找出数组中重复的数字。
     * 在一个长度为 n 的数组里的所有数字都在 O ~n....:1 的范围内。数组中某
     * 些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了
     * 几次。请找出数组中任意一个重复的数字。例如，如果输入长度为 7 的数
     * 组 {2, 3, 1., 0, 2, 5, 3}, 那么对应的输出是重复的数字 2 或者 3 。
     *
     * @param nums
     * @return
     */
    public static int findRepeatNumber(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int num = nums[i];
            if (num != i) {
                if (num == nums[num]) {
                    return num;
                } else {
                    int temp = nums[num];
                    nums[num] = num;
                    nums[i] = temp;
                }
            } else {
                i++;
            }
        }
        return -1;
    }

    /**
     * 题目二：不修改数组找出重复的数字。
     * 在一个长度为 n+l 的数组里的所有数字都在 1,.....,n 的范围内，所以数组
     * 中至少有一个数字是重复的。请找出数组中任意一个重复的数字，但不能
     * 修改输入的数组 。 例如，如果输入长度为 8 的数组 {2, 3, 5, 4, 3, 2, 6, 7}, 那
     * 么对应的输出是重复的数字 2 或者 3 。
     *
     * @param nums
     * @return
     */
    public static int findRepeatNumberNotRevise(int[] nums) {
        int start = 1;
        int end = nums.length - 1;
        while (start <= end) {
            // 取中间值
            int mid = (end - start) / 2 + start;
            int count = countRange(nums, start, mid);
//            System.out.println("start: " + start + " end: " + end + " mid: " + mid + "  count: " + count);
            if (start == end) {
                if (count > 1) {
                    return start;
                } else {
                    break;
                }
            }
            // 判断是否比两个值之间的数字多
            if (count > mid - start + 1) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 统计范围内有多少数
     *
     * @param nums
     * @param start
     * @param end
     * @return
     */
    private static int countRange(int[] nums, int start, int end) {
        int count = 0;
        for (int num : nums) {
            if (num >= start && num <= end) {
                count++;
            }
        }
        return count;
    }


}
