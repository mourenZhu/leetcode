package cn.zhumouren.leetcode.swordoffer;

public class Offer5 {
    public static void main(String[] args) {
        System.out.println(replaceSpace("We are happy."));
    }

    /**
     * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
     * 在java中操作String还是用库函数吧
     *
     * @param s
     * @return
     */
    public static String replaceSpace(String s) {
        return s.replace(" ", "%20");
    }
}
