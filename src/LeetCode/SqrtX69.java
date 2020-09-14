package LeetCode;

/**
 * LeetCode 69
 * 题意：
 * 实现 int sqrt(int x) 函数。
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * 示例 1:
 * 输入: 4
 * 输出: 2
 * 示例 2:
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去。
 * 思路：二分，确实巧妙
 *      start , end , mid 都声明为 long，
 *      while(start + 1 < end), 后续，start = mid , end = mid，not +1
 *      最后的结果就在start , end 之中一个,先判断end*end <= mid ? (int)end
 *      100% , 27.23%
 */
public class SqrtX69 {
    public static void main(String[] args) {
        int x = 8;
        int res = mySqrt(x);
        System.out.println(res);
    }
    public static int mySqrt(int x) {
        long start = 0;
        long end = x;
        while(start + 1 < end){
            long mid = (start + end) >> 1;
            if(mid * mid < x){
                start = mid ;
            }
            else if(mid * mid > x){
                end = mid;
            }
            else{
                return (int)mid;
            }
        }
        if(end * end <= x){
            return (int)end;
        }
        return (int)start;
    }
}
