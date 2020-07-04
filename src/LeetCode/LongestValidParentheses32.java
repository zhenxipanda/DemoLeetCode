package LeetCode;

/**
 * LeetCode 32
 * 题意：
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 * 示例 1:
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 * 示例 2:
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 * 思路：很巧妙的方法，左右各遍历一次，从左遍历时，为了防止出现")("，
 *      当right > left时，两者清零
 *      从右遍历时，为了防止出现")("，当left > right ,两者清零
 *      正因为如此，两次遍历当left == right 时，都需要记录最大值
 *      81.03% , 9.52%
 */
public class LongestValidParentheses32 {
    public static void main(String[] args) {
        String s = "(()";
        int res = longestValidParentheses(s);
        System.out.println(res);
    }
    public static int longestValidParentheses(String s) {
        int left = 0 , right = 0 , maxLen = 0;
        for(int i = 0;i < s.length(); i ++){
            if(s.charAt(i) == '('){
                left ++ ;
            }
            else{
                right ++;
            }
            if(left == right){
                maxLen = Math.max(maxLen , 2 * left);
            }
            if(right > left){
                left = 0 ;
                right = 0;
            }
        }
        left = 0;
        right = 0;
        for(int i = s.length() - 1; i >= 0; i --){
            if(s.charAt(i) == '('){
                left ++;
            }
            else{
                right ++;
            }
            if(left == right){
                maxLen = Math.max(maxLen , 2 * left);
            }
            if(left > right){
                left = 0;
                right = 0;
            }
        }
        return maxLen;
    }
}
