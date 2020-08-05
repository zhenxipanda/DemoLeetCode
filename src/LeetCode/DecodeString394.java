package LeetCode;

import java.util.LinkedList;

/**
 * LeetCode 394
 * 题意：
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。
 * 注意 k 保证为正整数。
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 * 示例 1：
 * 输入：s = "3[a]2[bc]"
 * 输出："aaabcbc"
 * 示例 2：
 * 输入：s = "3[a2[c]]"
 * 输出："accaccacc"
 * 示例 3：
 * 输入：s = "2[abc]3[cd]ef"
 * 输出："abcabccdcdcdef"
 * 示例 4：
 * 输入：s = "abc3[cd]xyz"
 * 输出："abccdcdcdxyz"
 * 思路：
 *      肯定用到栈，没想到用到两个栈，一个存数字，一个存字符串，
 *      遇到"["，更新前面的第一个数字，和字符串，
 *      遇到"]"，去除前面的额第一个数字 和字符串，做倍数的重复append()
 *      再与前面的结果连起来，一边下一次数字倍数操作
 *      谨防100[leetcode]，非一位数字
 *     27.75% , 81.69%
 */
public class DecodeString394 {
    public static void main(String[] args) {
        String s = "3[ba2[c]]xy";
        String res = decodeString(s);
        System.out.println(res);
    }
    public static String decodeString(String s) {
        StringBuffer res = new StringBuffer();
        LinkedList<Integer> stack_multi = new LinkedList<>();
        LinkedList<String> stack_res = new LinkedList<>();
        int multi = 0;
        for(char c : s.toCharArray()){
            if(c == '['){
                stack_multi.addLast(multi);
                stack_res.addLast(res.toString());
                multi = 0;
                res = new StringBuffer();
            }
            else if(c == ']'){
                StringBuffer tmp = new StringBuffer();
                int m = stack_multi.removeLast();
                for(int i = 0;i < m ; i ++){
                    tmp.append(res);
                }
                res = new StringBuffer(stack_res.removeLast() + tmp);
            }
            else if(c >= '0' && c <= '9'){
                multi = multi * 10 + Integer.parseInt(c + "");
            }
            else{
                res.append(c);
            }
        }
        return res.toString();
    }
}
