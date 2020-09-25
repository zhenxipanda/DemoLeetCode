package LeetCode;

/**
 * LeetCode 132
 * 题意：给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 * 返回符合要求的最少分割次数。
 * 示例:
 * 输入: "aab"
 * 输出: 1
 * 解释: 进行一次分割就可将 s 分割成 ["aa","b"] 这样两个回文子串。
 * 思路：与131相比，计算最少的分割次数，用int[n] min代表前n个子串分割为回文的最少次数，
 *      用boolean dp[n][n]存储子串n-n是否为回文，
 *      如果为回文，计算一次min[i]，
 *      60.36% , 16.08%
 */
public class PalindromePartitioning2_132 {
    public static void main(String[] args) {
        String s = "aab";
        int res = minCut(s);
        System.out.println(res);
    }
    public static int minCut(String s){
        if(s == null || s.length() == 0){
            return 0;
        }
        int n = s.length();
        int[] min = new int[n];
        boolean[][] dp = new boolean[n][n];
        for(int i = 0; i < n ; i ++){
            min[i] = i;
            for(int j = 0; j <= i ; j ++){
                if(s.charAt(i) == s.charAt(j) && (i - j < 2 || dp[j + 1][i - 1])){  //必须加上 && 后面，
                    dp[j][i] = true;
                    min[i] = j == 0 ? 0 : Math.min(min[i] , min[j - 1] + 1);
                }
            }
        }
        return min[n - 1];
    }
}
