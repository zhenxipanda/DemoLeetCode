package LeetCode;

/**
 * LeetCode 647
 * 题意：
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。
 * 示例 1:
 * 输入: "abc"
 * 输出: 3
 * 解释: 三个回文子串: "a", "b", "c".
 * 示例 2:
 * 输入: "aaa"
 * 输出: 6
 * 说明: 6个回文子串: "a", "a", "a", "aa", "aa", "aaa".
 * 思路：dp好想，马拉车不好想
 *      98.85% ， 56.27%
 */
public class PalindromicSubstrings647 {
    public static void main(String[] args) {
        String s = "abb";
        int res = countSubstrings(s);
        System.out.println(res);
        int ans = countSubstrings1(s);
        System.out.println(ans);
    }
    // 马拉车算法，Z[i]表示以i为中心长度至少为1的回文串的个数，然后v + 1，就是加上了单字符本身，
    // /2是因为回文串的长度是原长度的一半
    // 98.85% , 56.27%
    public static int countSubstrings(String s) {
        char[] A = new char[2 * s.length() + 3];
        A[0] = '@';
        A[1] = '#';
        A[A.length - 1] = '$';
        int t = 2;
        for (char c: s.toCharArray()) {
            A[t++] = c;
            A[t++] = '#';
        }

        int[] Z = new int[A.length];
        int center = 0, right = 0;
        for (int i = 1; i < Z.length - 1; ++i) {
//            i < right，找到关于center的对称点
            if (i < right)
                Z[i] = Math.min(right - i, Z[2 * center - i]);
//            i为中心，Z[i]步长进行左右比较
            while (A[i + Z[i] + 1] == A[i - Z[i] - 1])
                Z[i]++;
//            更新中心和右边界
            if (i + Z[i] > right) {
                center = i;
                right = i + Z[i];
            }
        }
        int ans = 0;
        for (int v: Z) ans += (v + 1) / 2;
        return ans;
    }
    // 动态规划 ,从右下角向上遍历，当前位置受左下角影响
    public static int countSubstrings1(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int n = s.length() ;
        boolean[][] dp = new boolean[n][n];
        for(int i = 0; i < n ; i ++){
            dp[i][i] = true;
        }
        int res = n;
        for(int i = n - 1; i >= 0 ; i --){
            for(int j = i + 1; j < n; j ++){
                if(s.charAt(i) == s.charAt(j)){
//                    如果下标只差1，如bb，一定是回文串
                    if(j - i == 1){
                        dp[i][j] = true;
                    }
                    else{
//                        否则，受左下角影响
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                else{
                    dp[i][j] = false;
                }
                if(dp[i][j]){
                    res ++;
                }
            }
        }
        return res;
    }
}
