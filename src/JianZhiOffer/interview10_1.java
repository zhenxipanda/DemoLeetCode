package JianZhiOffer;

/**
 * 剑指offer 10-1
 * 题意：写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项。斐波那契数列的定义如下：
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * 示例 1：
 * 输入：n = 2
 * 输出：1
 * 示例 2：
 * 输入：n = 5
 * 输出：5
 * 提示：
 * 0 <= n <= 100
 * 思路：与lc 509 同，
 *      用递推 not 递归
 *      100% , 18.64%
 */
public class interview10_1 {
    public static void main(String[] args) {
        int n = 5;
        int res = fib(n);
        System.out.println(res);
    }
    public static int fib(int n) {
        if(n < 2){
            return n;
        }
        int first = 0;
        int second = 1;
        int res = 0;
        for(int i = 2;i <= n; i ++){
            res = (first + second) % 1000000007;
            first = second;
            second = res;
        }
        return res;

    }
}
