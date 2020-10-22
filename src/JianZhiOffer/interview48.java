package JianZhiOffer;

/**
 * 剑指offer 48
 * 题意：请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
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
 * 提示：
 * s.length <= 40000
 * 思路：与 LeetCode 3 相同
 *      boolean 数组存储是否重复
 *      93.35% , 99.06%
 */
public class interview48 {
    public static void main(String[] args) {
        String s = "abcabcbb";
        int res = lengthOfLongestSubstring(s);
        System.out.println(res);
    }
    public static int lengthOfLongestSubstring(String s){
        if(s == null || s.length() == 0){
            return 0;
        }
        boolean[] flag = new boolean[256];
        int left = 0 , right = 0 , max = 0 , len = s.length();
        while (right < len){
            if(flag[s.charAt(right)] == false){
                flag[s.charAt(right)] = true;
                right ++ ;
                max = Math.max(right - left , max);
            }
            else{
                flag[s.charAt(left)] = false;
                left ++ ;
            }
        }
        return max;
    }
}
