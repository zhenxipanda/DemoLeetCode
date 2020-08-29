package JianZhiOffer;

/**
 * 剑指offer 14-2
 * 题意：给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为 k[0],k[1]...k[m - 1] 。请问 k[0]*k[1]*...*k[m - 1] 可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * 示例 1：
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1
 * 示例 2:
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
 * 提示：
 * 2 <= n <= 1000
 * 思路：与14-1的区别只在于n的取值范围变大了，需要对结果 % 1E9+7
 *      既然n取值大了，就不能直接pow(),利用二分思想n = 120 , n / 3 = 40
 *      a = n / 3 - 1 = 39, 3^39 = (3 * 3^19 * 3^19) % 1e9+7
 *      并且在计算3^19时，也x = (x * x)% 1e9+7，只要计算时刻记住%
 *      注意点：res , x -> long
 *      for(a = n/3-1 ; a >0 ; a/= 2) ,不能a>=0，
 *      return (int)(res * 3 % p),%p要放到括号内
 *      100% , 62.44%
 */
public class interview14_2 {
    public static void main(String[] args) {
        int n = 10;
        int res = cuttingRope(n);
        System.out.println(res);
    }
    public static int cuttingRope(int n){
        if(n <= 3){
            return n - 1;
        }
        int b = n % 3;
        int p = 1000000007;
        long res = 1 ,  x = 3;  // 必须是long类型
        for(int a = n / 3 - 1 ; a > 0; a /= 2){ // 不能 a >= 0 ,否则死循环
            if((a & 1) == 1){
                res = (res * x) % p;
            }
            x = (x * x) % p;
        }
        if(b == 0){
            return (int)(res * 3 % p);  // )必须在p后面，否则WA
        }
        else if(b == 1){
            return (int) (res * 4 % p);
        }
        return (int) (res * 6 % p);
    }
}
