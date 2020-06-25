package LeetCode;

import java.util.Arrays;

/**
 * LeetCode 189
 * 题意：给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * 说明:
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 要求使用空间复杂度为 O(1) 的 原地 算法。
 * 思路：比较简单，如果是O(1)的空间复杂度，就写一个翻转函数，
 *      将数组分为三部分进行翻转。
 *      100% , 7.14%
 */
public class RotateArray189 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        int k = 4;
        rotate(nums , k);
        System.out.println(Arrays.toString(nums));
    }
    public static void rotate(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return ;
        }
        if(k % (nums.length) == 0){
            return ;
        }
        reverse(nums , nums.length - (k % nums.length) , nums.length - 1);
        reverse(nums , 0 , nums.length - (k % nums.length) - 1);
        reverse(nums , 0 , nums.length - 1);
    }
    public static void reverse(int[] nums , int start , int end){
        while(start < end){
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start ++;
            end --;
        }
    }
}
