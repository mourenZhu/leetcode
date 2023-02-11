package cn.zhumouren.leetcode.swordoffer;

import java.util.Arrays;

public class Offer11 {
    public static void main(String[] args) {
        System.out.println(minArray(new int[]{3, 4, 5, 1, 2}));
        System.out.println(minArray(new int[]{2, 2, 2, 0, 1}));
        System.out.println(minArray(new int[]{1, 0, 1, 1, 1}));
        System.out.println(minArray(new int[]{1, 1, 1, 0, 1}));
    }

    /**
     * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
     * <p>
     * 给你一个可能存在 重复 元素值的数组 numbers ，它原来是一个升序排列的数组，并按上述情形进行了一次旋转。请返回旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一次旋转，该数组的最小值为 1。
     * <p>
     * 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
     *
     * @param numbers
     * @return
     */
    public static int minArray(int[] numbers) {
        int pre = 0;
        int end = numbers.length - 1;
        int mid = pre;
        while (numbers[pre] >= numbers[end]) {
            if (end - pre == 1) {
                mid = end;
                break;
            }
            mid = (end + pre) / 2;
            if (numbers[pre] == numbers[end] && numbers[pre] == numbers[mid]) {
                return Arrays.stream(numbers).min().getAsInt();
            }
            if (numbers[mid] >= numbers[pre]) {
                pre = mid;
            } else if (numbers[mid] <= numbers[end]) {
                end = mid;
            }
        }
        return numbers[mid];
    }
}
