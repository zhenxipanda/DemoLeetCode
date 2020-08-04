package LeetCode;

/**
 * LeetCode 371
 * 题意：
 * 不使用运算符 + 和 - ​​​​​​​，计算两整数 ​​​​​​​a 、b ​​​​​​​之和。
 * 示例 1:
 * 输入: a = 1, b = 2
 * 输出: 3
 * 示例 2:
 * 输入: a = -2, b = 3
 * 输出: 1
 * 思路：不使用+，-，就只能使用二进制的位运算 ^ , & ,|
 *      ^ ：留下两者不同的，
 *      & ：留下两个相同的，且重点看1，不为0，左移一位，
 *      再与 ^ 的结果 计算  ^ , &
 *      直到 & 的结果为0，
 *      注意：使用a,b存储，防止计算过程中改变引起结果错误
 *      100% , 41.03%
 */
public class SumOfTwoIntegers371 {
    public static void main(String[] args) {
        int a = 3;
        int b = 3;
        int res = getSum(a , b);
        System.out.println(res);
    }
    public static int getSum(int a, int b) {
        int yihuo = a ^ b;
        int yu = a & b;
        while(yu != 0){
            yu = yu << 1;
            a = yihuo ;
            b = yu;
            yihuo = a ^ b;
            yu = a & b;
        }
        return yihuo;
    }
}
