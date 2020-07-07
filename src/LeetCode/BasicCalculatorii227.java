package LeetCode;

import java.util.Stack;

/**
 * LeetCode 227
 * 题意：
 * 实现一个基本的计算器来计算一个简单的字符串表达式的值。
 * 字符串表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格  。 整数除法仅保留整数部分。
 * 示例 1:
 * 输入: "3+2*2"
 * 输出: 7
 * 示例 2:
 * 输入: " 3/2 "
 * 输出: 1
 * 示例 3:
 * 输入: " 3+5 / 2 "
 * 输出: 5
 * 说明：
 * 你可以假设所给定的表达式都是有效的。
 * 请不要使用内置的库函数 eval。
 * 思路：对空格，跳过，
 *      对于数字，可能不是一位数字，所以需要用while来处理，
 *      只对数字入栈，对于操作符，用last字符表示，初始last = '+',
 *      如果last == '+'，数字入栈，
 *      如果last == '-'，-1 * 数字入栈，
 *      如果last == '*'或'/'，计算结果再入栈，
 *      最后，对栈中的元素累加求和
 *      89.33% , 33.33%
 */
public class BasicCalculatorii227 {
    public static void main(String[] args) {
        String s = "  3 + 2 * 2 - 1";
        int ans = calculate(s);
        System.out.println(ans);
    }
    public static int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        char last = '+';
        char[] ch = s.toCharArray();
        for(int i = 0;i < ch.length; i ++){
            if(ch[i] == ' '){
                continue;
            }
            else{
                if(Character.isDigit(ch[i])){
                    int tmp = ch[i] - '0';
                    while(i + 1 < ch.length && Character.isDigit(ch[i + 1])){
                        tmp = tmp * 10 + ch[i + 1] - '0';
                        i ++;
                    }
                    if(last == '+'){
                        stack.push(tmp);
                    }
                    else if(last == '-'){
                        stack.push(-1 * tmp);
                    }
                    else{
                        stack.push(res(last , stack.pop() , tmp));
                    }
                }
                else{
                    last = ch[i];
                }
            }
        }
        int sum = 0;
        while(!stack.isEmpty()){
            sum += stack.pop();
        }
        return sum ;
    }
    public static int res(char last , int x , int y){
        if(last == '*'){
            return x * y;
        }
        else if(last == '/'){
            return x / y;
        }
        else if(last == '+'){
            return x + y;
        }
        else{
            return x - y;
        }
    }
}
