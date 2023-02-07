package cn.zhumouren.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author mourenZhu
 * @version 1.0
 * @description todo
 * @date 2022/8/13 14:54
 **/
public class FindMedianSortedArrays {

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> list = Arrays.stream(nums1).boxed().collect(Collectors.toList());
        list.addAll(Arrays.stream(nums2).boxed().collect(Collectors.toList()));
        Collections.sort(list);
        int size = list.size();
        if (size % 2 == 0) {
            return (list.get(size / 2) + list.get(size / 2 - 1)) / 2.0;
        }
        return list.get(size / 2);
    }
}
