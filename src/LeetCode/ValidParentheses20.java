package LeetCode;

import java.util.Stack;

/**
 * LeetCode 20
 * 题意：
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * 示例 1:
 * 输入: "()"
 * 输出: true
 * 示例 2:
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 * 输入: "{[]}"
 * 输出: true
 * 思路：用栈，左括号门入栈，遇到右括号，判断栈是否为空，-> false
 *      不为空，判断栈首是否与自己匹配，-> pop()
 *      不匹配，可以返回false
 *      遍历完数组，最后判断栈是否为空，不空，如(((,false
 *      为空，true
 *      79.37% , 13.28%
 */
public class ValidParentheses20 {
    public static void main(String[] args) {
        String s = "(){}[)";
        boolean res = isValid(s);
        System.out.println(res);
    }
    public static boolean isValid(String s) {
        if(s == null || s.length() == 0){
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == '(' || c == '[' || c == '{'){
                stack.push(c);
            }
            else{
                if(c == ')' || c ==']' || c == '}'){
                    if(stack.isEmpty()){
                        return false;
                    }
                }
                if(c == ')' && stack.peek() == '('){
                    stack.pop();
                    continue;
                }
                if(c == ']' && stack.peek() == '['){
                    stack.pop();
                    continue;
                }
                if(c == '}' && stack.peek() == '{'){
                    stack.pop();
                    continue;
                }
                return false;
            }
        }
        return stack.isEmpty();
    }
}
