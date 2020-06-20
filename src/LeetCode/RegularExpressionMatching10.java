package LeetCode;

/**
 * LeetCode 10
 * 题意：
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 * 说明:
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 * s = "ab"
 * p = ".*"
 * 输出: true
 * 解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 * 思路：动态规划，dp[i][j]：s的前i个字符和p的前j个字符是否能匹配上
 *      举个例子，画个二维动态规划表格，再总结规律就可以了
 *      99.68% , 38.23%
 */
public class RegularExpressionMatching10 {
    public static void main(String[] args) {
        String s = "ab";
        String p = "a*";
        boolean res = isMatch(s , p);
        System.out.println(res);
    }
    public static boolean isMatch(String s, String p) {
        if(s == null || p == null ){
            return false;
        }
        char[] ss = s.toCharArray();
        char[] pp = p.toCharArray();
        int s1 = s.length(), p1 = p.length();
        boolean[][] dp = new boolean[s1 + 1][p1 + 1];
        for(int i = 0;i <= s1; i ++){
            for(int j = 0;j <= p1; j ++){
                if(i == 0 && j == 0){
                    dp[i][j] = true;
                    continue;
                }
                if(j == 0){
                    dp[i][j] = false;
                    continue;
                }
                if(pp[j - 1] != '*'){
                    if(i >= 1 && (ss[i - 1] == pp[j - 1] || pp[j - 1] == '.')){
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
                else{
                    if(j >= 2){
                        dp[i][j] = dp[i][j - 2];
                    }
                    if(i >= 1 && (ss[i - 1] == pp[j - 2] || pp[j - 2] == '.')){
                        dp[i][j] |= dp[i - 1][j];     // is |= , not  =
                    }
                }
            }
        }
        return dp[s1][p1];
    }
}
