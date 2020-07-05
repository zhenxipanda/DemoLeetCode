package LeetCode;

/**
 * LeetCode 44
 * 题意：
 * 给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
 * '?' 可以匹配任何单个字符。
 * '*' 可以匹配任意字符串（包括空字符串）。
 * 两个字符串完全匹配才算匹配成功。
 * 说明:
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。
 * 示例 1:
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 * 示例 2:
 * 输入:
 * s = "aa"
 * p = "*"
 * 输出: true
 * 解释: '*' 可以匹配任意字符串。
 * 示例 3:
 * 输入:
 * s = "cb"
 * p = "?a"
 * 输出: false
 * 解释: '?' 可以匹配 'c', 但第二个 'a' 无法匹配 'b'。
 * 示例 4:
* 输入:
 * s = "adceb"
 * p = "*a*b"
 * 输出: true
 * 解释: 第一个 '*' 可以匹配空字符串, 第二个 '*' 可以匹配字符串 "dce".
 * 示例 5:
 * 输入:
 * s = "acdcb"
 * p = "a*c?b"
 * 输出: false
 * 思路：动态规划，用dp[i][j]表示字符串s的前i个和字符串p的前j个是否能匹配
 *      递推公式：if(pp[j-1] != '*'),再看如果 i >= 1，并且 ss[i-1] == pp[j-1] || pp[j-1]=='*',
 *      也就是s的第i-1个字符和p的第j-1个字符能匹配上，dp[i][j] = dp[i - 1][j - 1]
 *      如果(pp[j-1] == '*')，如果 j >= 1，dp[i][j] = dp[i][j - 1]
 *      如果i >= 1，dp[i][j] = dp[i][j] | dp[i -][j]
 *      也就是说此时的dp[i][j]受dp[i][j-1]和dp[i-1][j]共同影响
 *      画一下二维动态规划表就比较清晰明了了。
 *      69.53% , 46.43%
 */
public class WildcardMatching44 {
    public static void main(String[] args) {
        String s = "adceb";
        String p = "*a*b";
        boolean res = isMatch(s , p);
        System.out.println(res);
    }
    public static boolean isMatch(String s, String p) {
        if(s == null || p == null){
            return false;
        }
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        char[] ss = s.toCharArray();
        char[] pp = p.toCharArray();
        for(int i = 0;i <= m ; i ++){
            for(int j = 0;j <= n; j ++){
                if(i == 0 && j == 0){
                    dp[i][j] = true;
                    continue;
                }
                if(j == 0){
                    dp[i][j] = false;
                    continue;
                }
                if(pp[j - 1] != '*'){
                    if(i >= 1 && (ss[i - 1] == pp[j - 1] || pp[j - 1] == '?')){
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
                else{
                    if(j >= 1){
                        dp[i][j] = dp[i][j - 1];
                    }
                    if(i >= 1 && j >= 1){
                        dp[i][j] |= dp[i - 1][j];
                    }
                }
            }
        }
        return dp[m][n];
    }
}
