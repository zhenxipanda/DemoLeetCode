package JianZhiOffer;

/**
 * 剑指offer 46
 * 题意：给定一个数字，我们按照如下规则把它翻译为字符串：
 * 0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。
 * 一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 * 示例 1:
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 * 提示：
 * 0 <= num < 2^31
 * 思路：动态规划，与LeetCode 91 相似，一个从0开始，一个从1开始
 *      100% , 96.68%
 */
public class interview46 {
    public static void main(String[] args) {
        int num = 12258;
        int res = translateNum(num);
        System.out.println(res);
    }
    public static int translateNum(int num) {
        String s = String.valueOf(num);
        int len = s.length();
        int[] dp = new int[len + 1];
        dp[0] = 1;
        for(int i = 1; i <= len ; i ++){
            dp[i] = dp[i - 1];
            if(i > 1){
                int two = ( s.charAt(i - 2) - '0' ) * 10 + (s.charAt(i - 1) - '0');
                if(two >= 10 && two <= 25){
                    dp[i] += dp[i - 2];
                }
            }
        }
        return dp[len];
    }
}
