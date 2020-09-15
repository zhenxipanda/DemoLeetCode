package LeetCode;

/**
 * LeetCode 72
 * 题意：给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
 * 你可以对一个单词进行如下三种操作：
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 * 示例 1：
 * 输入：word1 = "horse", word2 = "ros"
 * 输出：3
 * 解释：
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 * 示例 2：
 * 输入：word1 = "intention", word2 = "execution"
 * 输出：5
 * 解释：
 * intention -> inention (删除 't')
 * inention -> enention (将 'i' 替换为 'e')
 * enention -> exention (将 'n' 替换为 'x')
 * exention -> exection (将 'n' 替换为 'c')
 * exection -> execution (插入 'u')
 * 思路：动态规划，dp[i][j]表示word1的前i个和word2的前j个匹配，需要的转换次数
 *      替换，就是左上角，增加，就是对上方操作，减少，就是对左方操作
 *      88.24% , 81.07%
 */
public class EditDistance72 {
    public static void main(String[] args) {
        String word1 = "horse";
        String word2 = "ros";
        int res = minDistance(word1, word2);
        System.out.println(res);
    }
    public static int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for(int i = 1; i <= n ; i ++){
            dp[0][i] = dp[0][i - 1] + 1;
        }
        for(int j = 1; j <= m; j ++){
            dp[j][0] = dp[j - 1][0] + 1;
        }
        for(int i = 1;i <= m; i ++){
            for(int j = 1; j <= n; j ++){
                if(word1.charAt(i - 1) == word2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1];
                }
                else{
                    dp[i][j] = Math.min(dp[i - 1][j - 1] , Math.min(dp[i][j - 1] , dp[i - 1][j])) + 1;
                }
            }
        }
        return dp[m][n];
    }
}
