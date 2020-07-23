package LeetCode;

/**
 * LeetCode 64
 * 题意：
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 说明：每次只能向下或者向右移动一步。
 * 示例:
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 * 思路：动态规划，可以只有O(N)的额外空间
 *      98.20% , 24.24%
 */
public class MinimumPathSum64 {
    public static void main(String[] args) {
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        int res = minPathSum(grid);
        System.out.println(res);
    }
    public static int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[] dp = new int[n];
        dp[0] = grid[0][0];
        for(int i = 1;i < n ; i ++){
            dp[i] = dp[i - 1] + grid[0][i];
        }
        for(int j = 1;j < m; j ++){
            dp[0] = dp[0] + grid[j][0];
            for(int i = 1;i < n; i ++){
                dp[i] = Math.min(dp[i] , dp[i - 1]) + grid[j][i];
            }
        }
        return dp[n - 1];
    }
}
