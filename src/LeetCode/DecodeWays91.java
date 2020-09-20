package LeetCode;

/**
 * LeetCode 91
 * 题意：一条包含字母 A-Z 的消息通过以下方式进行了编码：
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 * 示例 1:
 * 输入: "12"
 * 输出: 2
 * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
 * 示例 2:
 * 输入: "226"
 * 输出: 3
 * 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 * 思路：动态规划，dp[n]代表前n个字符串的解码方案个数，
 *      先判断，如果s.charAt(0) == '0',return 0，不存在解码方式，
 *      dp[0] = 1 , dp[1] = 1，这是初始设定，
 *      然后从i = 2; i <= n; i ++，
 *      判断s.charAt(i-1)是否>0 && <= 9 ,可以构成单独的一个数字，如果是,dp[i]+=dp[i-1]
 *      再判断，s.charAt(i-2)与s.charAt(i-1)构成的数字是否 >= 10 && <= 26，如果是,dp[i]+=dp[i-2]
 *      特别注意s.charAt(0)==‘0’，以0开头的数字，直接返回0
 *      43.10% ， 64.56%
 */
public class DecodeWays91 {
    public static void main(String[] args) {
        String s = "226";
        int res = numDecodings(s);
        System.out.println(res);
    }
    public static int numDecodings(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        if(s.charAt(0) == '0'){
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; i ++){
            int oneDigit = s.charAt(i - 1) - '0';
            if(oneDigit > 0 && oneDigit <= 9){
                dp[i] += dp[i - 1];
            }
            int twoDigit = ( s.charAt(i - 2) - '0') * 10 + s.charAt(i - 1) - '0';
            if(twoDigit >= 10 && twoDigit <= 26){
                dp[i] += dp[i - 2];
           }
        }
        return dp[n];
    }
}
