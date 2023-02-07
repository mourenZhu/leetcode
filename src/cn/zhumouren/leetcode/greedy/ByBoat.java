package cn.zhumouren.leetcode.greedy;

import java.util.Arrays;

/**
 * 乘船问题：有N个人，第I个人重量为wi，每艘船的载重上限为C，且最多乘2人。用最少的船装载所有人，求需最少的船数量？
 */
public class ByBoat {

    /**
     * @param c 船的承重
     * @param w 每个人的重量
     * @return 最少需要多少个船
     */
    public static int minBoatNums(int c, int[] w) {
        Arrays.sort(w);
        int lightIndex = 0;
        int heavyIndex = w.length - 1;
        int boatNums = 0;
        // 最轻的人的索引只要小于等于最重的人的索引，就说明还有人没有坐上船
        while (lightIndex <= heavyIndex) {
            // 最轻的和最胖的总量小于等于船的承重，则两个人一条船
            if (w[lightIndex] + w[heavyIndex] <= c) {
                lightIndex++;
            }
            // 无论哪种情况，最重的人也是要坐船的，所以减一
            heavyIndex--;
            boatNums++;
        }
        return boatNums;
    }

    public static void main(String[] args) {
        int[] w = {4, 2, 1, 3, 5, 6, 7, 8, 10, 9};
        int c = 10;
        int minBoatNums = minBoatNums(c, w);
        System.out.println(Arrays.toString(w));
        System.out.printf("最少需要%d条船\n", minBoatNums);
    }

}
