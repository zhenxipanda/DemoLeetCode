package JianZhiOffer;

/**
 * 剑指offer 19
 * 题意：请实现一个函数用来匹配包含'. '和'*'的正则表达式。模式中的字符'.'表示任意一个字符，
 * 而'*'表示它前面的字符可以出现任意次（含0次）。在本题中，匹配是指字符串的所有字符匹配整个模式。
 * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但与"aa.a"和"ab*a"均不匹配。
 * 示例 1:
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 * 示例 2:
 * 输入:
 * s = "aa"
 * p = "a*"
 * 输出: true
 * 解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。
 * 因此，字符串 "aa" 可被视为 'a' 重复了一次。
 * 示例 3:
 * 输入:
 * s = "ab"
 * p = ".*"
 * 输出: true
 * 解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 * 示例 4:
 * 输入:
 * s = "aab"
 * p = "c*a*b"
 * 输出: true
 * 解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
 * 示例 5:
 * 输入:
 * s = "mississippi"
 * p = "mis*is*p*."
 * 输出: false
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母以及字符 . 和 *，无连续的 '*'。
 * 思路：与leetcode 10 同
 *      99.94% , 20.47%
 */
public class interview19 {
    public static void main(String[] args) {
        String s = "ab";
        String p = ".*";
        boolean res = isMatch(s , p);
    }
    public static boolean isMatch(String s, String p) {
        if(s == null || p == null){
            return false;
        }
        char[] ss = s.toCharArray();
        char[] pp = p.toCharArray();
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        for(int i = 0 ; i <= m ; i ++){
            for(int j = 0; j <= n; j ++){
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
                        dp[i][j] |= dp[i - 1][j];
                    }
                }
            }
        }
        return dp[m][n];
    }
}
