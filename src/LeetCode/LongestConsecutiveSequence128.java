package LeetCode;

import java.util.Arrays;

public class LongestConsecutiveSequence128 {
    public static void main(String[] args) {
        int[] nums = {100,1,200,4,3,2};
        int res = longestConsecutive(nums);
        System.out.println(res);
    }
    public static int longestConsecutive(int[] nums){
        if(nums == null || nums.length == 0){
            return 0;
        }
        int[] dp = new int[nums.length];
        Arrays.sort(nums);
        for(int i = 0; i < nums.length ; i ++){
            dp[i] = 1;
        }
        int res = 0;
        for(int i = 1; i < nums.length ; i ++){
            if(nums[i] - nums[i - 1] == 1){
                dp[i] = dp[i - 1] + 1;
                res = Math.max(res , dp[i]);
            }
            else if(nums[i] == nums[i - 1]){
                dp[i] = dp[i - 1];
            }
        }
        return res;
    }
}
