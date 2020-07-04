package LeetCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * LeetCode 217
 * 题意：
 * 给定一个整数数组，判断是否存在重复元素。
 * 如果任意一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
 * 示例 1:
 * 输入: [1,2,3,1]
 * 输出: true
 * 示例 2:
 * 输入: [1,2,3,4]
 * 输出: false
 * 示例 3:
 * 输入: [1,1,1,3,3,4,3,2,4,2]
 * 输出: true
 * 思路：比较简单，有两种方法
 *      1. 排序，重复元素一定相邻 ，时间复杂度O(nlgn)，空间复杂度O(1)
 *      2. 哈希，使用HashSet,重复元素，时间复杂度O(N),空间复杂度O(N)
 */
public class ContainsDuplicate217 {
    public static void main(String[] args) {
        int[] nums = {1,2,1,2,3,1,4};
        boolean res = containsDuplicate(nums);
        System.out.println(res);
    }
    public static boolean containsDuplicate(int[] nums) {
        if(nums == null || nums.length == 0){
            return false;
        }
        Arrays.sort(nums);
        for(int i = 1;i < nums.length ; i ++){
            if(nums[i] == nums[i - 1]){
                return true;
            }
        }
        return false;
    }
    public static boolean containsDuplicate1(int[] nums) {
        if(nums == null || nums.length == 0){
            return false;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)){
                return true;
            }
            set.add(num);
        }
        return false;
    }
}

