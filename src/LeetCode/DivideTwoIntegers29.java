package LeetCode;

/**
 * LeetCode 29
 * 题意：给定两个整数，被除数 dividend 和除数 divisor。
 * 将两数相除，要求不使用乘法、除法和 mod 运算符。
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 * 整数除法的结果应当截去（truncate）其小数部分，
 * 例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
 * 示例 1:
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 * 解释: 10/3 = truncate(3.33333..) = truncate(3) = 3
 * 示例 2:
 * 输入: dividend = 7, divisor = -3
 * 输出: -2
 * 解释: 7/-3 = truncate(-2.33333..) = -2
 * 提示：
 * 被除数和除数均为 32 位有符号整数。
 * 除数不为 0。
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−2^31,  2^31 − 1]。
 * 本题中，如果除法结果溢出，则返回 2^31 − 1。
 * 思路：因为不能使用乘法除法，所以使用位运算左移和减法
 *      注意转为long型
 *      100% , 95.89%
 */
public class DivideTwoIntegers29 {
    public static void main(String[] args) {
         int dividend = 10;
         int divisor = -3;
         int res = divide(dividend , divisor);
        System.out.println(res);
    }
    public static int divide(int dividend, int divisor){
        if(divisor == 0 || (dividend == Integer.MIN_VALUE && divisor == -1)){
            return Integer.MAX_VALUE;
        }
        long m = Math.abs((long)dividend);
        long n = Math.abs((long)divisor);
        int sign = (dividend < 0) ^ (divisor < 0) ? -1 : 1;
        if(n == 1){
            return sign == -1 ? (int)-m : (int)m;
        }
        int res = 0;
        while (m >= n){
            long t = n;
            int p = 1;
            while (m >= (t << 1)){
                p<<= 1;
                t<<= 1;
            }
            res += p;
            m -= t;
        }
        return sign == -1 ? -res : res;
    }
}
