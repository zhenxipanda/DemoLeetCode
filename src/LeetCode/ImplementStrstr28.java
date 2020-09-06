package LeetCode;

/**
 * LeetCode 28
 * 题意：实现 strStr() 函数。
 * 给定一个 haystack 字符串和一个 needle 字符串，
 * 在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。
 * 如果不存在，则返回  -1。
 * 示例 1:
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * 说明:
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。
 * 这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 * 思路：从头遍历，判断首是否相同，相同再判断，substring(i,i+n)是否相等
 *      100% , 50.03%
 */
public class ImplementStrstr28 {
    public static void main(String[] args) {
        String haystack = "hello";
        String needle = "ll";
        int res = strStr(haystack , needle);
        System.out.println(res);
    }
    public static int strStr(String haystack, String needle) {
        if(needle == null || needle.length() == 0){
            return 0;
        }
        if(haystack == null || haystack.length() == 0){
            return -1;
        }
        int m = haystack.length() , n = needle.length();
        for(int i = 0 ; i <= m - n; i ++){
            if(haystack.charAt(i) == needle.charAt(0)){
                if(haystack.substring(i , i + n).equals(needle)){
                    return i;
                }
            }
        }
        return -1;
    }
}
