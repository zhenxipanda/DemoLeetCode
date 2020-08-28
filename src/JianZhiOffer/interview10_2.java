package JianZhiOffer;

/**
 * 剑指offer 10-2/3
 * 题意：我们可以用 2*1 的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用 n 个 2*1 的小矩形无重叠地覆盖一个 2*n 的大矩形，总共有多少种方法？
 *
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * 示例 1：
 * 输入：n = 2
 * 输出：2
 * 示例 2：
 * 输入：n = 7
 * 输出：21
 * 示例 3：
 * 输入：n = 0
 * 输出：1
 * 提示：
 * 0 <= n <= 100
 * 与leetcode 70 同
 * 思路：都是递推，n=1,f(n)=1
 *              n=2,f(n)=2
 *              n>1,f(n)=f(n-1)+f(n-2)
 *      100% , 56.17%
 */
public class interview10_2 {
    public static void main(String[] args) {
        int n = 5;
        int res = numWays(n);
        System.out.println(res);
    }
    public static int numWays(int n) {
        if(n == 0){
            return 1;
        }
        if(n <= 2){
            return n;
        }
        int first = 1;
        int second = 2;
        int res = 0;
        for(int i = 3;i <= n; i ++){
            res = (first + second) % 1000000007;
            first = second;
            second = res;
        }
        return res;
    }
}
