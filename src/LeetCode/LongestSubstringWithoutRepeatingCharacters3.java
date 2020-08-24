package LeetCode;

/**
 * LeetCode 3
 * 题意：
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 示例 1:
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * 思路：滑动窗口，start,end维护窗口，用boolean[256]数组判断一个字符是否出现过，
 *      89.80% , 71.74%
 */
public class LongestSubstringWithoutRepeatingCharacters3 {
    public static void main(String[] args) {
        String s = "PWKKEWqa";
        int res = lengthOfLongestSubstring(s);
        System.out.println(res);
    }
    public static int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int start = 0 , end = 0 , len = s.length() , res = 0;
        char[] ch = s.toCharArray();
        boolean[] flag = new boolean[256];
        while(end < len){
            if(flag[ch[end]] == false){
                flag[ch[end]] = true;
                end ++;
                res = Math.max(res , end - start);
            }
            else{
                flag[ch[start]] = false;
                start ++;
            }
        }
        return res;
    }
}
