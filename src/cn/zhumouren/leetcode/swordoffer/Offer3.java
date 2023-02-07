package cn.zhumouren.leetcode.swordoffer;

public class Offer3 {
    public static void main(String[] args) {
        System.out.println(findRepeatNumber(new int[]{2, 3, 1, 0, 2, 5, 3}));
    }

    public static int findRepeatNumber(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int num = nums[i];
            if (num != i) {
                if (num == nums[num]) {
                    return num;
                }
                else {
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
}
