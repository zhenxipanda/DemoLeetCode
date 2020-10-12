package LeetCode;

/**
 * LeetCode 313
 * 题意：编写一段程序来查找第 n 个超级丑数。
 * 超级丑数是指其所有质因数都是长度为 k 的质数列表 primes 中的正整数。
 * 示例:
 * 输入: n = 12, primes = [2,7,13,19]
 * 输出: 32
 * 解释: 给定长度为 4 的质数列表 primes = [2,7,13,19]，前 12 个超级丑数序列为：[1,2,4,7,8,13,14,16,19,26,28,32] 。
 * 说明:
 * 1 是任何给定 primes 的超级丑数。
 *  给定 primes 中的数字以升序排列。
 * 0 < k ≤ 100, 0 < n ≤ 106, 0 < primes[i] < 1000 。
 * 第 n 个超级丑数确保在 32 位有符整数范围内。
 * 思路：动态规划，设置了质因数的取值，每个质因数一个指针p,因为是数字形式，所以定义指针数组index[]
 *
 */
public class SuperUglyNumber313 {
    public static void main(String[] args) {
        int n = 12;
        int[] primes = {2,7,13,19};
        int res = nthSuperUglyNumber(n , primes);
        System.out.println(res);
    }
    public static int nthSuperUglyNumber(int n, int[] primes){
        int[] dp = new int[n];
        dp[0] = 1;
        int k = primes.length;
        int[] index = new int[k];
        for(int i = 1; i < n ; i ++){
            int min = Integer.MAX_VALUE;
            for(int j = 0; j < k ; j ++){
                if(min > dp[index[j]] * primes[j]){
                    min = dp[index[j]] * primes[j];
                }
            }
            dp[i] = min;
            for(int j = 0; j < k ; j ++){
                if(min == dp[index[j]] * primes[j]){
                    index[j] ++ ;
                }
            }
        }
        return dp[n - 1];
    }
}
