package cn.zhumouren.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author mourenZhu
 * @version 1.0
 * @description todo
 * @date 2022/8/11 18:02
 **/
public class LengthOfLongestSubstring3 {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abccbsa"));
    }

    public static int lengthOfLongestSubstring(String s) {
        Set<Character> occ = new HashSet<>();

        int n = s.length();

        int rk = -1, ans = 0;

        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk+1))) {
                occ.add(s.charAt(rk+1));
                rk++;
            }
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }

}
