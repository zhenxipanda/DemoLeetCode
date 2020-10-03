package LeetCode;

import java.util.Stack;

/**
 * LeetCode 150 
 * 题意：根据 逆波兰表示法，求表达式的值。
 * 有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 * 说明：
 * 整数除法只保留整数部分。
 * 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 * 示例 1：
 * 输入: ["2", "1", "+", "3", "*"]
 * 输出: 9
 * 解释: 该算式转化为常见的中缀算术表达式为：((2 + 1) * 3) = 9
 * 示例 2：
 * 输入: ["4", "13", "5", "/", "+"]
 * 输出: 6
 * 解释: 该算式转化为常见的中缀算术表达式为：(4 + (13 / 5)) = 6
 * 示例 3：
 * 输入: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
 * 输出: 22
 * 解释:
 * 该算式转化为常见的中缀算术表达式为：
 *   ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * = ((10 * (6 / (12 * -11))) + 17) + 5
 * = ((10 * (6 / -132)) + 17) + 5
 * = ((10 * 0) + 17) + 5
 * = (0 + 17) + 5
 * = 17 + 5
 * = 22
 * 思路：遇到操作符就将栈首的两个元素弹出，做运算，然后压入栈中，
 *      遇到非运算符，即为数字，就压入栈中
 *      特别注意：如果是字符串的比较运算，不能==,要用equals()
 *      90.10% , 79.76%
 */
public class EvaluateReversePolishNotation150 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String[] token = {"4", "13", "5", "/", "+"};
        int ans = evalRPN(token);
        System.out.println(ans);
    }

    public static int evalRPN(String[] token) {
        if (token == null || token.length == 0) {
            return 0;
        }
        Stack<Long> stack = new Stack();
        for (String s : token) {
            if (isOperator(s)) {
                long b = stack.pop();
                long a = stack.pop();
                stack.push(calculate(a, b, s));
            } else {
                stack.push(Long.parseLong(s));
            }
        }
        return stack.pop().intValue();
    }

    public static boolean isOperator(String s) {
        if (s.length() != 1) {
            return false;
        }
        char c = s.charAt(0);
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    public static long calculate(long a, long b, String s) {
        long rst = 0;
        switch (s) {
            case "+":
                rst = a + b;
                break;
            case "-":
                rst = a - b;
                break;
            case "*":
                rst = a * b;
                break;
            case "/":
                rst = a / b;
                break;
            default:
                rst = 0;
        }
        return rst;
    }
}
