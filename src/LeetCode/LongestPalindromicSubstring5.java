package LeetCode;

/**
 * LeetCode 5
 * 题意：
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * 示例 1：
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * 输入: "cbbd"
 * 输出: "bb"
 * 思路：马拉车算法，关于中心对称的，可以利用对称特性先获取一个值，
 *      再以其为中心向两侧扩展，最后计算以其为中心的回文子串的半径，即为最长回文串的长度，
 *      并且在此时记录最长回文串开始的起点start
 *      97.42% , 66.50%
 */
public class LongestPalindromicSubstring5 {
    public static void main(String[] args) {
        String s = "ababd";
        String res = longestPalindrome(s);
        System.out.println(res);
    }
    public static String longestPalindrome(String s) {
        if(s == null || s.length() == 0){
            return "";
        }
        int n = s.length();
        char[] ch = new char[2 * n + 3];
        ch[0] = '@';
        ch[1] = '#';
        ch[ch.length - 1] = '$';
        int t = 2;
        for(char c : s.toCharArray()){
            ch[t ++] = c;
            ch[t ++] = '#';
        }
        int[] z = new int[2 * n + 3];
        int start = 0 ,maxlen = 1 , center = 0 , right = 0;
        for(int i = 1; i < ch.length - 1 ; i ++){
            if(i < right){
                z[i] = Math.min(right - i , z[2 * center - i]);
            }
            while(ch[i + z[i] + 1] == ch[i - z[i] - 1]){
                z[i] ++;
            }
            if(i + z[i] > right){
                center = i;
                right = center + z[i];
            }
            if(z[i] > maxlen){
                maxlen = z[i];
                start = (i - maxlen) / 2;
            }
        }
        return s.substring(start , start + maxlen);
    }
}
