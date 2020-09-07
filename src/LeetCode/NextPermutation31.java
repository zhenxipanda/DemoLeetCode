package LeetCode;

import java.util.Arrays;

/**
 * LeetCode 31
 * 题意：实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * 必须原地修改，只允许使用额外常数空间。
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 * 思路：下一个排列，就是从右向左找，找到第一个下降的相邻位置，
 *      如果i>=0，再从右向左找第一个大于它的数，两个位置交换
 *      reverse(nums , i + 1)
 *      99.74% , 52.18%
 */
public class NextPermutation31 {
    public static void main(String[] args) {
        int[] nums = {2,1,3,2};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
    public static void nextPermutation(int[] nums) {
        if(nums == null || nums.length == 0){
            return ;
        }
        int i = nums.length - 2;
        while(i >= 0 && nums[i] >= nums[i + 1]){
            i -- ;
        }
        if(i >= 0){
            int j = nums.length - 1;
            while(j >= 0 && nums[j] <= nums[i]){
                j -- ;
            }
            swap(nums , i , j);
        }
        reverse(nums , i + 1);
    }
    public static void swap(int[] nums , int i , int j){
        int k = nums[i];
        nums[i] = nums[j];
        nums[j] = k;
    }
    public void reverse(int[] nums , int start){
        int end = nums.length - 1;
        while(start < end){
            swap(nums , start , end);
            start ++;
            end -- ;
        }
    }
}
