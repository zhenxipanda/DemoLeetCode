package LeetCode;

import java.util.Arrays;

/**
 * LeetCode 209
 * 题意：给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组，
 * 并返回其长度。如果不存在符合条件的连续子数组，返回 0。
 * 示例: 
 * 输入: s = 7, nums = [2,3,1,2,4,3]
 * 输出: 2
 * 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
 * 进阶:
 * 如果你已经完成了O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。
 * 思路：O(N)时间复杂度的话,空间复杂度O(1)：滑动窗口，两个指针固定窗口，
 *      窗口内的和一旦>= s ，就记录下窗口长度，并保存最小长度，
 *      然后在从左缩短窗口长度。  99.85% , 6.67%
 *      O(NlgN)时间复杂度的话,空间复杂度O(N)，使用前缀和和二分查找，
 *      因为原数组是无序的，所以需要额外创建一个数组，sum[i]:前i个元素的和。
 *     target = s + sum[i - 1], bound = binarySearch(target)
 *     num[bound] - num[i-1] >= s，长度为bound - (i - 1)
 *     前提是数组元素都为正数，bound <= nums.length
 */
public class MinimumSizeSubarraySum209 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        int s = 11;
        int res = minSubArrayLen(s , nums);
        int min = minSubArrayLen1(s , nums);
        System.out.println(min);
    }
    //时间复杂度O(N) 99.85% ， 6.67%
    public static int minSubArrayLen(int s, int[] nums) {
        int left = 0 , right = 0 , min = Integer.MAX_VALUE, sum = 0;
        while(right < nums.length){
            sum += nums[right ++];
            while(sum >= s){
                min = Math.min(min , right - left);
                sum -= nums[left ++];
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min ;
    }
    //时间复杂度O(NlgN)
    public static int minSubArrayLen1(int s, int[] nums) {
        int min = Integer.MAX_VALUE;
        int[] sum = new int[nums.length + 1];
        for(int i = 1;i <= nums.length ; i ++){
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        for(int i = 1;i <= nums.length ; i ++){
            int target = s + sum[i - 1];
            int bound = Arrays.binarySearch(sum , target);
            if(bound < 0){    //对于binarySearch(),如果没有找到目标元素，return -(low + 1)，low为第一个>目标值的元素
                bound = -1 * bound - 1;
            }
            if(bound <= nums.length){
                min = Math.min(min , bound - (i - 1));
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min ;

    }
}
