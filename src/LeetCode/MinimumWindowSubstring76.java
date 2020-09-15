package LeetCode;

/**
 * LeetCode 76
 * 题意：给你一个字符串 S、一个字符串 T 。请你设计一种算法，可以在 O(n) 的时间复杂度内，
 * 从字符串 S 里面找出：包含 T 所有字符的最小子串。
 * 示例：
 * 输入：S = "ADOBECODEBANC", T = "ABC"
 * 输出："BANC"
 * 提示：
 * 如果 S 中不存这样的子串，则返回空字符串 ""。
 * 如果 S 中存在这样的子串，我们保证它是唯一的答案。
 * 思路：用int[]map存储t字母出现的次数，count记录t的长度
 *      begin存储最短串开始的位置，len存储最短串的长度，
 *      遍历s，left , right滑动窗口，便利到right，map[rc]--
 *      如果map[rc]>=0，说明rc在t中出现，count --
 *      当count == 0时，窗口内的字符串符合要求，进行长度判断，找到窗口内符合要求的最短子串
 *      92.19% , 71.95%
 */
public class MinimumWindowSubstring76 {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String res = minWindow(s, t);
        System.out.println(res);
    }
    public static String minWindow(String s, String t){
        if(s == null || s.length() == 0 || t == null || t.length() == 0){
            return "";
        }
        int begin = 0 , len = Integer.MAX_VALUE , count = t.length();
        int left = 0 , right = 0;
        int[] map = new int[128];
        for(char c : t.toCharArray()){
            map[c] ++ ;
        }
        for(; right < s.length() ; right ++){
            char rc = s.charAt(right);
            map[rc] --;
            if(map[rc] >= 0){
                count --;
            }
            while (count == 0){
                char c = s.charAt(left);
                map[c] ++ ;
                if(map[c] > 0){
                    if(len > right  - left + 1){
                        begin = left;
                        len = right - left + 1;
                    }
                    count ++ ;
                }
                left ++ ;
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(begin , begin + len);
    }
}
