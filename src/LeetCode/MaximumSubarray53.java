package LeetCode;

/**
 * LeetCode 53
 * 题意：给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 示例:
 * 输入: [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 * 思路：因为是连续子序和，所以动态规划，
 *      dp[i] = Math.max(dp[i-1] + nums[i] , nums[i])
 *      res = Math.max(dp[i] , res)
 *      96.01% , 35.09%
 */
public class MaximumSubarray53 {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int res = maxSubArray(nums);
        System.out.println(res);
    }
    public static int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int max = nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for(int i = 1;i < nums.length; i ++){
            dp[i] = Math.max(dp[i - 1] + nums[i] , nums[i]);
            max = Math.max(max , dp[i]);
        }
        return max;
    }
}
