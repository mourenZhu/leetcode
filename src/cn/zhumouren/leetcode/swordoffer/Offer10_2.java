package cn.zhumouren.leetcode.swordoffer;

public class Offer10_2 {
    public static void main(String[] args) {
        System.out.println(numWays(7));
    }

    /**
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
     * <p>
     * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
     *
     * @param n
     * @return
     */
    public static int numWays(int n) {
        if (n < 2) {
            return 1;
        }
        int n1 = 1;
        int n2 = 1;
        int f = 0;
        for (int i = 2; i <= n; i++) {
            f = (n1 + n2) % 1000000007;
            n2 = n1;
            n1 = f;
        }
        return f;
    }
}
