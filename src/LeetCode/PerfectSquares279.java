package LeetCode;

/**
 * LeetCode 279
 * 题意：
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。
 * 你需要让组成和的完全平方数的个数最少。
 * 示例 1:
 * 输入: n = 12
 * 输出: 3
 * 解释: 12 = 4 + 4 + 4.
 * 示例 2:
 * 输入: n = 13
 * 输出: 2
 * 解释: 13 = 4 + 9.
 * 思路：
 *     仍然是动态规划，dp[i]表示构成该数所需的完全平方数的个数，
 *     最坏的情况就是dp[i] = i，全为1，构成
 *     然后从1开始遍历，如n = 12，
 *     dp[n] = dp[1] + dp[11]
 *     dp[n] = dp[4] + dp[8],
 *     其中，dp[1],dp[4] 都为1，
 *     所以内层遍历构成完全平方数的数字
 *     77.31% , 10.53%
 */
public class PerfectSquares279 {
    public static void main(String[] args) {
         int n = 12;
         int res = numSquares(n);
        System.out.println(res);
    }
    public static int numSquares(int n) {
        int[] dp = new int[n + 1];
        for(int i = 1;i <= n; i ++){
            dp[i] = i;
            for(int j = 1; i - j * j >= 0 ; j ++){
                dp[i] = Math.min(dp[i] , dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}
