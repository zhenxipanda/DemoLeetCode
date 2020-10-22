package JianZhiOffer;

/**
 * 剑指offer 47
 * 题意：在一个 m*n 的棋盘的每一格都放有一个礼物，
 * 每个礼物都有一定的价值（价值大于 0）。
 * 你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、
 * 直到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 * 示例 1:
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 12
 * 解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物
 * 提示：
 * 0 < grid.length <= 200
 * 0 < grid[0].length <= 200
 * 思路：与 LeetCode 64 相似，一个是求最大和，一个是求最小和
 *      82.48% , 88.30%
 */
public class interview47 {
    public static void main(String[] args) {
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        int res = maxValue(grid);
        System.out.println(res);
    }
    public static int maxValue(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] dp = new int[n];
        dp[0] = grid[0][0];
        for(int i = 1;i < n; i ++){
            dp[i] = dp[i - 1] + grid[0][i];
        }
        for(int i = 1;i < m; i ++){
            dp[0] = dp[0] + grid[i][0];
            for(int j = 1;j < n; j ++){
                dp[j] = Math.max(dp[j - 1], dp[j]) + grid[i][j];
            }
        }
        return dp[n - 1];
    }
}
