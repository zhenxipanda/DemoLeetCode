package LeetCode;

/**
 * LeetCode 343
 * 题意：给定一个正整数 n，将其拆分为至少两个正整数的和，
 * 并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 * 示例 1:
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1。
 * 示例 2:
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
 * 说明: 你可以假设 n 不小于 2 且不大于 58。
 * 思路：给定了n的范围，所以不用考虑大数情况，
 *      尽可能分割出多个3，如果%3 == 1，这种情况 拿出一个3，构成4 的乘积更大一些
 *      100% , 99.06%
 */
public class IntegerBreak343 {
    public static void main(String[] args) {
        int n = 10;
        int res = integerBreak(n);
        System.out.println(res);
    }
    public static int integerBreak(int n) {
        if(n <= 3){
            return n - 1;
        }
        int a = n / 3;
        int b = n % 3;
        if(b == 0){
            return (int)Math.pow(3 , a);
        }
        else if(b == 1){
            return (int)Math.pow(3 , a - 1) * 4;
        }
        return (int)Math.pow(3 , a) * 2 ;
    }
}
