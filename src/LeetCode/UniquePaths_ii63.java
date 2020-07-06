package LeetCode;

/**
 * LeetCode 63
 * 题意：
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
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
 * 思路：与62 不同路径 的区别在于多了障碍物，
 *      相同的，先判断左上角和右下角的起始点、终止点是否可达，不可达直接返回。
 *      所以除去第一行和第一列的矩形操作一致。
 *      先来考虑一下第一行，我们使用的是一维数组
 *      程序走到这一步，起始点一定是可达的，那从下标为1的开始判断，
 *      如果前一个格子不可达或当前格子有障碍物，那当前格子不可达，否则，就是可达的
 *      判断完第一行，我们接着判断其他行，外层循环控制行，那个第一列的元素，
 *      如果当前格子的上一个格子不可达，或者当前格子有障碍物，那么当前格子不可达，
 *      因为第一列的格子只能是从正上方走下来的，，否则，当前格子可达。
 *      对于每一行，在判断完列下标为0的之后，判断其他列，内层循环控制1~n-1列
 *      如果当前格子有障碍物，那么当前格子不可达，即dp[i][j] = 0
 *      否则，到达当前格子有两种选择，一种是从上方下来的，一种是从左方过来的，
 *      所以dp[j] = dp[j -i] + dp[j]，其中的dp[j]就是从上方下来的，dp[j - 1]就是从左方过来的
 *      100% , 59.26%
 */
public class UniquePaths_ii63 {
    public static void main(String[] args) {
        int[][] obstacleGrid = {{0,0,0,},{0,1,0},{0,0,0}};
        int res = uniquePathsWithObstacles(obstacleGrid);
        System.out.println(res);
    }
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if(obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1){
            return 0;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        for(int i = 1;i < n; i ++){
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
            else{
                dp[0] = 1;
            }
            for(int j = 1;j < n; j ++){
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
