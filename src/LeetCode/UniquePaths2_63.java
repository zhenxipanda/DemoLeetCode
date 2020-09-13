package LeetCode;

/**
 * LeetCode 63
 * 题意：一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 * 说明：m 和 n 的值均不超过 100。
 * 示例 1:
 * 输入:
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 * ]
 * 输出: 2
 * 解释:
 * 3x3 网格的正中间有一个障碍物。
 * 从左上角到右下角一共有 2 条不同的路径：
 * 1. 向右 -> 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右 -> 向右
 * 思路：关键在于对障碍物位置的处理，
 *      因为只能向下或者向右走，所以第一行如果dp[i-1]==0 || ob[0][i] == 1,dp[i]=0
 *      从第二行开始，如果dp[0]==0 || ob[i][0] == 1 ,dp[0] = 0
 *      从第二列开始，如果ob[i][j] == 1 , dp[j] = 0
 *                 否则，dp[j] = 1
 *      100% , 86.70%
 */
public class UniquePaths2_63 {
    public static void main(String[] args) {
        int[][] obstacleGrid = {{0,0,0},{0,1,0},{0,0,0}};
        int res = uniquePathsWithObstacles(obstacleGrid);
        System.out.println(res);
    }
    public static int uniquePathsWithObstacles(int[][] obstacleGrid){
        if(obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0){
            return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if(obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1){
            return 0;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        for(int i = 1 ; i < n ; i ++){
            if(dp[i - 1] == 0 || obstacleGrid[0][i] == 1){
                dp[i] = 0;
            }
            else{
                dp[i] = 1;
            }
        }
        for(int i = 1;i < m; i ++){
            if(dp[0] == 0 || obstacleGrid[i][0] == 1){
                dp[0] = 0;
            }
            for(int j = 1; j < n ; j ++){
                if(obstacleGrid[i][j] == 1){
                    dp[j] = 0;
                }
                else{
                    dp[j] = dp[j - 1] + dp[j];
                }
            }
        }
        return dp[n - 1];
    }
}
