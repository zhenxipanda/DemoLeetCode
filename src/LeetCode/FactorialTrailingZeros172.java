package LeetCode;

/**
 * LeetCode 172
 * 题意：给定一个整数 n，返回 n! 结果尾数中零的数量。
 * 示例 1:
 * 输入: 3
 * 输出: 0
 * 解释: 3! = 6, 尾数中没有零。
 * 输入: 5
 * 输出: 1
 * 解释: 5! = 120, 尾数中有 1 个零.
 * 思路：统计尾数中0的个数，10 = 2 * 5
 *      就是对n!进行因式分解，看看有多少个2，多少个5，
 *      因为2的个数一定比5多，所以只统计5的个数就行
 *      n / 5即为5的个数，但是对于25,75，。。。包含2个5，所以n / 25，统计25的个数
 *      n / 125统计125的个数，25已结在n / 5的时候统计过1个5了，所以res = n / 5 + n / 25 + n / 125 ...
 *      99.65% , 5.55%
 */
public class FactorialTrailingZeros172 {
    public static void main(String[] args) {
        int n = 11;
        int res = trailingZeroes(n);
        System.out.println(res);
    }
    public static int trailingZeroes(int n) {
        int count = 0;
        while(n != 0){
            n /= 5 ;
            count += n;
        }
        return count ;
    }
}
