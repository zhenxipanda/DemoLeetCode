package LeetCode;

/**
 * LeetCode 97
 * 题意：
 * 给定三个字符串 s1, s2, s3, 验证 s3 是否是由 s1 和 s2 交错组成的。
 * 示例 1:
 * 输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 * 输出: true
 * 示例 2:
 * 输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
 * 输出: false
 * 思路：动态规划
 *      但是比较难，用s2的长度+1创建动态规划数组，
 *      然后针对i== 0 || j == 0，单独处理，i == 0，只能j变化，从左侧变化而来，所以s2变
 *      j == 0，只能i变化，从上方变化而来，所以s1变
 *      其他位置i != 0 && j != 0，都受左侧和上方两个位置影响，将左侧结果 || 右侧结果
 *      90.96% , 14.29%
 */
public class InterleavingString97 {
    public static void main(String[] args) {
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";
        boolean res = isInterleave(s1 , s2 , s3);
        System.out.println(res);
    }
    public static boolean isInterleave(String s1, String s2, String s3) {
        if(s3.length() != s1.length() + s2.length()){
            return false;
        }
        int m = s1.length();
        int n = s2.length();
        // 建立动态规划数组
        boolean[] dp = new boolean[n + 1];
        for(int i = 0;i <= m ; i ++){
            for(int j = 0;j <= n; j ++){
                // i == 0 && j == 0单独处理
                if(i == 0 && j == 0){
                    dp[j] = true;
                }
                // 当i == 0，画图即为第一行时，动态规划只能从左侧一步步推算出来
                else if(i == 0){
                    dp[j] = dp[j - 1] && (s2.charAt(j - 1) == s3.charAt(i + j - 1));
                }
                // 当 j == 0 ，画图即为第一列时，动态规划只能从竖直的上方元素推算出来
                else if(j == 0){
                    dp[j] = dp[j] && (s1.charAt(i - 1) == s3.charAt(i + j - 1));
                }
                // i != 0 && j != 0 ,||左边是判断上方来的，因为上下相比，只是i变了，所以用s1比较，
                // ||右边是判断下方来的，左右相比，只是j变了，所以用s2比较
                else {
                    dp[j] = (dp[j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) ||
                            (dp[j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
                }
            }
        }
        return dp[n];
    }
}
