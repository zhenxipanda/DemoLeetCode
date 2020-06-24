package LeetCode;

/**
 * LeetCode 188
 * 题意：给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
 * 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 输入: [2,4,1], k = 2
 * 输出: 2
 * 解释: 在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。
 * 输入: [3,2,6,5,0,3], k = 2
 * 输出: 7
 * 解释: 在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
 *      随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 。
 * 思路：动态规划，需要判断是否k >= n / 2，如果是的话，就转换为了允许操作无限次，如果不是，比较麻烦
 *      dp[i][j]:最多交易i次时在第j天能获得的最大利润。
 *      maxDiff:最多交易i-1次时，从第0天到第j-1天，最大利润-当前价格 的最大值
 *      参考 https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/solution/er-wei-bei-bao-zui-you-zui-jian-jie-fa-by-coldme-2/
 *      96.68% ， 12.00%
 */
public class BestTimeToBuyAndSellStock4_188 {
    public static void main(String[] args) {
         int[] prices = {3,2,6,5,0,3};
         int k = 2;
         int res = maxProfit(k , prices);
        System.out.println(res);
    }
    public static int maxProfit(int k, int[] prices){
        int n = prices.length;
        if(n == 0 || k == 0){
            return 0;
        }
        if(k >= n / 2){
            int res = 0;
            for(int i = 1;i < n; i ++){
                res += Math.max(0 , prices[i] - prices[i - 1]);
            }
            return res;
        }
        int[][] dp = new int[k + 1][n];
        for(int i = 1;i < k + 1; i ++){
            int maxDiff = -prices[0];
            for(int j = 1;j < n; j ++){
                maxDiff = Math.max(maxDiff , dp[i - 1][j - 1] - prices[j]);
                dp[i][j] = Math.max(dp[i][j - 1] , prices[j] + maxDiff);
            }
        }
        return dp[k][n - 1];
    }
}
