package LeetCode;

import java.util.Stack;

/**
 * LeetCode 150 逆波兰表达式求值
 * 思路：利用栈，每次遇到数字就入栈，遇到操作符就出栈计算，把结果压入栈
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
