package LeetCode;

/**
 * LeetCode 221
 * 题意：
 * 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 * 示例:
 * 输入:
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 * 输出: 4
 * 思路：比较难的一道题，不太好像。
 *      求最大面积的正方形，正方形是长=宽，
 *      所以在代码中，除了记录左边和上边的信息外，还需要记录左上角的信息，
 *      肯定是要遍历二维矩阵，因为是用额外的一维空间，dp[j+1]表示当前行，以前i+1个元素构成的正方形的面积
 *      如果当前行，ch[j] == '1' ,那么dp[j+1] = (dp[j] , dp[j + 1], 左上角)三者中的最小值 + 1,
 *      同时更新最大边长,maxSide = max(maxSide , dp[j + 1])
 *      如果ch[j] == '0'，dp[j + 1] = 0
 *      还是要多刷几遍，增强记忆
 *      82.05% , 12.50%
 */
public class MaximalSquare221 {
    public static void main(String[] args) {
        char[][] matrix = {{'1','0','1','0','0'},
                           {'1','0','1','1','1'},
                           {'1','1','1','1','1'},
                           {'1','0','0','1','0'}};
        int res = maximalSquare(matrix);
        System.out.println(res);
    }
    public static int maximalSquare(char[][] matrix){
        if(matrix == null | matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[] dp = new int[n + 1];
        int northWeast = 0 , maxSide = 0;
        for(char[] ch : matrix){
            northWeast = 0;
            for(int j = 0;j < n; j ++){
                int nextNor = dp[j + 1];
                if(ch[j] == '1'){
                    dp[j + 1] = Math.min(Math.min(dp[j] , dp[j + 1]) , northWeast) + 1;
                    maxSide = Math.max(maxSide , dp[j + 1]);
                }
                else{
                    dp[j + 1] = 0;
                }
                northWeast = nextNor;
            }
        }
        return maxSide * maxSide;
    }
}

