package JianZhiOffer;

/**
 * 剑指offer 16
 * 题意：实现函数double Power(double base, int exponent)，求base的exponent次方。
 * 不得使用库函数，同时不需要考虑大数问题。
 * 示例 1:
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * 示例 2:
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * 示例 3:
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2-2 = 1/22 = 1/4 = 0.25
 * 说明:
 * -100.0 < x < 100.0
 * n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
 * 思路：与leetcode 50 同
 *      二分递归，降低复杂度和运行时间，
 *      对特殊取值进行额外处理
 *      94.83% , 97.42%
 */
public class interview16 {
    public static void main(String[] args) {
        double x = 2.0;
        int n = 10;
        double res = myPow(x , n);
        System.out.println(res);
    }
    public static double myPow(double x, int n){
        if(x == 0.0 || x == 1.0 || n == 0){
            return 1.0;
        }
        if(n == 1){
            return x;
        }
        long p = Math.abs((long)n);
        if(n > 0){
            return dfs(x , p);
        }
        return 1 / dfs(x , p);
    }

    private static double dfs(double x, long p) {
        if(p == 0){
            return 1.0;
        }
        else if(p == 1){
            return x;
        }
        double res = dfs(x , p >> 1);
        res *= res;
        if((p & 1) == 1){
            res *= x;
        }
        return res;
    }
}
