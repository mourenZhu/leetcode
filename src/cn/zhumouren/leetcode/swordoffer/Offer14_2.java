package cn.zhumouren.leetcode.swordoffer;

public class Offer14_2 {
    public static void main(String[] args) {
        System.out.println(cuttingRope(2));
        System.out.println(cuttingRope(10));
        System.out.println(cuttingRope(58));
        System.out.println(cuttingRope(120));
    }

    /**
     * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。
     * 请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
     * 这个是贪心算法
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
        // 尽可 能 多地剪去长度为 3 的绳子段
        int timesOf3 = n / 3;
        // 当绳子最后剩下的长度为 4 的时候 ， 不能再剪去长度为 3 的 绳子段
        // 此时 更好的方法是把绳子 剪成长度力 2 的两 段 ， 因为 2 x 2 > 3x1
        if (n - timesOf3 * 3 == 1) {
            timesOf3 -= 1;
        }
        int timesOf2 = (n - timesOf3 * 3) / 2;
        return (int) Math.pow(3, timesOf3) * (int) Math.pow(2, timesOf2);
    }
}
