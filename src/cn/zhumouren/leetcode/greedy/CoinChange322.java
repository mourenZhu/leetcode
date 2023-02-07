package cn.zhumouren.leetcode.greedy;

import java.util.Arrays;

public class CoinChange322 {

    public static int coinChange(int[] coins, int amount) {
        // 先升序排序，用于从大到小找钱的索引
        Arrays.sort(coins);
        // 现在用到哪种面额的钱的索引
        int coinsIndex = coins.length - 1;
        // 用于记录用到了几张钱
        int coinNums = 0;
        // 从大到小匹配各种面值的钱，索引到-1就说明不能找齐钱
        while (coinsIndex >= 0) {
            // c = 剩下要找的钱 / 该面值的钱 即该面值的钱最多能用几张
            int c = amount / coins[coinsIndex];
            // 如果张数大于0，则说明该面值的钱能用
            if (c > 0) {
                // 剩下要找的钱等于 c(看上文的解释) 乘 当前的面值
                amount -= c * coins[coinsIndex];
                // 增加纸币张数
                coinNums += c;
            }
            // 该种面值的纸币不能再用，该用更小的
            coinsIndex--;
            // amount 等于0则说明已经已经找完了
            if (amount == 0) {
                return coinNums;
            }
        }
        // 找不齐钱
        return -1;
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5, 10, 20, 50, 100};
        int amount = 59;
        int nums = coinChange(coins, amount);
        System.out.printf("%d共需要%d张纸币", amount, nums);
    }
}
