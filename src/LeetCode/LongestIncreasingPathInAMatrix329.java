package LeetCode;

/**
 * LeetCode 329
 * 题意：
 * 给定一个整数矩阵，找出最长递增路径的长度。
 * 对于每个单元格，你可以往上，下，左，右四个方向移动。 你不能在对角线方向上移动或移动到边界外（即不允许环绕）。
 * 示例 1:
 * 输入: nums =
 * [
 *   [9,9,4],
 *   [6,6,8],
 *   [2,1,1]
 * ]
 * 输出: 4
 * 解释: 最长递增路径为 [1, 2, 6, 9]。
 * 示例 2:
 * 输入: nums =
 * [
 *   [3,4,5],
 *   [3,2,6],
 *   [2,2,1]
 * ]
 * 输出: 4
 * 解释: 最长递增路径是 [3, 4, 5, 6]。注意不允许在对角线方向上移动。
 * 思路：递归，特殊之处在于维护一个相同规模的数组，表示
 *      以此位置结束的最长递增路径的长度
 *      90.51% ， 39.31%
 */
public class LongestIncreasingPathInAMatrix329 {
    public static void main(String[] args) {
        int[][] matrix = {{9,9,6},{6,6,7},{2,1,1}};
        int res = longestIncreasingPath(matrix);
        System.out.println(res);
    }
    public static int longestIncreasingPath(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        int max = 1;
        int m = matrix.length ;
        int n = matrix[0].length;
        int[][] memo = new int[m][n];
        for(int i = 0;i < m ; i ++){
            for(int j = 0;j < n; j ++){
                memo[i][j] = -1;
            }
        }
        for(int i = 0;i < m ; i ++){
            for(int j = 0; j < n ; j ++){
                max = Math.max(max , dfs(matrix , i , j , Integer.MIN_VALUE , memo));
            }
        }
        return max;
    }
    public static int dfs(int[][] matrix , int x , int y , int num , int[][] memo){
        if(x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length || matrix[x][y] <= num){
            return 0;
        }
        if(memo[x][y] != -1){
            return memo[x][y];
        }
        else{
            memo[x][y] = Math.max(1 + dfs(matrix , x - 1 , y , matrix[x][y] , memo) , Math.max(1 + dfs(matrix , x + 1 , y , matrix[x][y] , memo) , Math.max(1 + dfs(matrix , x, y - 1  , matrix[x][y] , memo) , 1 + dfs(matrix , x , y  + 1, matrix[x][y] , memo))));
            return memo[x][y];
        }
    }
}
