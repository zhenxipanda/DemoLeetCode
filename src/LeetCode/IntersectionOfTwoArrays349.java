package LeetCode;

import java.util.Arrays;
import java.util.HashSet;

/**
 * LeetCode 349
 * 题意：
 * 给定两个数组，编写一个函数来计算它们的交集。
 * 示例 1：
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 * 示例 2：
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 * 说明：
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 * 思路：可以使用set自带的 set1.retainAll(set2)
 *      set1，set2是两个集合，计算结果set1就是他们的交集
 *      也可以不使用set自带的方法，
 *      对数组排序，两个指针遍历两个数组，不相等的，小方移动
 *      相等的，放入集合中（因为集合去重），350是不去重，可用List存
 *      97.36% ， 82.11%
 */
public class IntersectionOfTwoArrays349 {
    public static void main(String[] args) {
         int[] nums1 = {1,2,1,2};
         int[] nums2 = {2,2};
         int[] res = intersection(nums1 , nums2);
        System.out.println(Arrays.toString(res));
    }
    public static int[] intersection(int[] nums1, int[] nums2){
        HashSet<Integer> set1 = new HashSet<>();
        for(int num : nums1){
            set1.add(num);
        }
        HashSet<Integer> set2 = new HashSet<>();
        for(int num : nums2){
            set2.add(num);
        }
        set1.retainAll(set2);
        int[] res = new int[set1.size()];
        int k = 0;
        for(int num : set1){
            res[k ++] = num;
        }
        return res;
    }
}
