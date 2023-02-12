package cn.zhumouren.leetcode.swordoffer;

public class Offer14_1 {
    public static void main(String[] args) {
        System.out.println(cuttingRope(2));
        System.out.println(cuttingRope(10));
        System.out.println(cuttingRope(58));
        System.out.println(cuttingRope(120));
    }

    /**
     * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。
     * 请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
     * 这个是动态规划算法
     *
     * @param n
     * @return
     */
    public static int cuttingRope(int n) {
        if (n < 2) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        int[] products = new int[n + 1];
        products[0] = 0;
        products[1] = 1;
        products[2] = 2;
        products[3] = 3;
        int max = 0;
        for (int i = 4; i <= n; i++) {
            max = 0;
            for (int j = 1; j <= i / 2; j++) {
                int product = products[j] * products[i - j];
                if (max < product) {
                    max = product;
                }
                products[i] = max;
            }
        }
        max = products[n];
        return max;
    }
}
