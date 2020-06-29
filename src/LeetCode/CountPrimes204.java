package LeetCode;

import java.util.Arrays;

/**
 * LeetCode 204
 * 题意：
 * 统计所有小于非负整数 n 的质数的数量。
 * 示例:
 * 输入: 10
 * 输出: 4
 * 解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 * 思路：统计小于n 的质数个数，怎么也得从2开始判断，但是有个技巧
 *      就是不用判断到n ，判断到 sqrt(n)就可以，因为因子是对称的，12 = 2 * 6 , 12 = 6 * 2
 *      以空间换时间，如果某个数i为质数，那么它的倍数一定不为质数，为避免重复，内层的记录倍数，从 i * i 开始
 *      最后遍历数组，统计质数个数
 *      空间复杂度O(N)，时间复杂度计算较复杂
 *      81.17% , 8.57%
 */
public class CountPrimes204 {
    public static void main(String[] args) {
        int n = 10;
        int res = countPrimes(n);
        System.out.println(res);
    }
    public static int countPrimes(int n){
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime , true);
        for(int i = 2;i * i < n; i ++){
            if(isPrime[i]){
                for(int j = i * i; j < n; j += i){
                    isPrime[j] = false;
                }
            }
        }
        int count = 0;
        for(int i = 2;i < n; i ++){
            if(isPrime[i]){
                count ++;
            }
        }
        return  count;
    }
}
