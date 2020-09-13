package LeetCode;

/**
 * LeetCode 62
 * 题意：一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 问总共有多少条不同的路径？
 * 输入: m = 3, n = 2
 * 输出: 3
 * 解释:
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向右 -> 向下
 * 2. 向右 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向右
 * 示例 2:
 * 输入: m = 7, n = 3
 * 输出: 28
 * 提示：
 * 1 <= m, n <= 100
 * 题目数据保证答案小于等于 2 * 10 ^ 9
 * 思路：动态规划，一位数组,初始全为1，
 *      for(int i = 1 ; i < m ; i ++)
 *        for(int j = 1 ; j < n; j ++)
 *          dp[j] = dp[j - 1] + dp[j]
 *      100% , 97.35%
 */
public class UniquePaths62 {
    public static void main(String[] args) {
        int m = 3 ;
        int n = 2 ;
        int res = uniquePaths(m , n);
        System.out.println(res);
    }
    public static int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        for(int i = 0; i < n; i ++){
            dp[i] = 1;
        }
        for(int i = 1; i < m ; i ++){
            for(int j = 1; j < n ; j ++){
                dp[j] = dp[j - 1] + dp[j];
            }
        }
        return dp[n - 1];
    }
}
