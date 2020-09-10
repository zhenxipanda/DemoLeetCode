package LeetCode;

/**
 * LeetCode 50
 * 题意：实现 pow(x, n) ，即计算 x 的 n 次幂函数。
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
 * 思路：分而治之，降低时间复杂度，
 *
 */
public class PowX_N50 {
    public static void main(String[] args) {
        double x = 2.0 ;
        int n = -2;
        double res = myPow(x , n);
        System.out.println(res);
    }
    public static double myPow(double x, int n) {
        if(x == 0.0){
            return 0.0;
        }
        else if(x == 1.0){
            return 1.0;
        }
        if(n == 0){
            return 1.0;
        }
        else if(n == 1){
            return x;
        }
        long m = Math.abs((long)n);
        if(n > 0){
            return pow(x , m);
        }
        else{
            return 1 / pow(x , m);
        }
    }
    public static double pow(double x, long m){
        if(m == 0){
            return 1.0;
        }
        else if(m == 1){
            return x;
        }
        double res = pow(x , m >> 1);
        if((m & 1) == 0){
            return res * res;
        }
        else{
            return res * res * x;
        }
    }
}
