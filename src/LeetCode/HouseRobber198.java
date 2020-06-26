package LeetCode;

/**
 * LeetCode 198
 * 题意：你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 * 输入：[1,2,3,1]
 * 输出：4
 * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 * 输入：[2,7,9,3,1]
 * 输出：12
 * 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 * 提示：
 * 0 <= nums.length <= 100
 * 0 <= nums[i] <= 400
 * 思路：不能简单的，奇数位置元素求和与偶数元素求和，找最大值，因为可能最优解并不是相隔1，如[2,1,1,2]
 *      所以还是用动态规划，dp[i]表示前i天能获得的最大收益。
 *      dp[i] = Math.max ( dp[i-1](第i天不偷) , dp[i-2]+nums[i-1](第i天偷) )
 *      100% , 6.52%
 */
public class HouseRobber198 {
    public static void main(String[] args) {
        int[] nums = {2,1,1,2};
        int res = rob(nums);
        System.out.println(res);
    }
    public static int rob(int[] nums){
        if(nums == null || nums.length == 0){
            return 0;
        }
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for(int i = 2;i <= nums.length ; i ++){
            dp[i] = Math.max(dp[i - 1] , dp[i - 2] + nums[i - 1]);
        }
        return dp[nums.length];
    }
}
