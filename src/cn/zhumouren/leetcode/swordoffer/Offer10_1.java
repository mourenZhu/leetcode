package cn.zhumouren.leetcode.swordoffer;

import java.util.Arrays;
import java.util.stream.Stream;

public class Offer10_1 {
    public static void main(String[] args) {
        System.out.println(fib(2));
    }

    /**
     * 斐波那契数列
     * leetcode 需要对最后的答案取模
     *
     * @param n
     * @return
     */
    public static int fib(int n) {
        if (n < 2) {
            return n;
        }
        int n1 = 1;
        int n2 = 0;
        int f = 0;
        for (int i = 2; i <= n; i++) {
            f = (n1 + n2) % 1000000007;
            n2 = n1;
            n1 = f;
        }
        return f;
    }
}
