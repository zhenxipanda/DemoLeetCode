package LeetCode;

/**
 * LeetCode 476
 * 题意：
 * 给定一个正整数，输出它的补数。补数是对该数的二进制表示取反。
 * 示例 1:
 * 输入: 5
 * 输出: 2
 * 解释: 5 的二进制表示为 101（没有前导零位），其补数为 010。所以你需要输出 2 。
 * 示例 2:
 * 输入: 1
 * 输出: 0
 * 解释: 1 的二进制表示为 1（没有前导零位），其补数为 0。所以你需要输出 0 。
 * 注意:
 * 给定的整数保证在 32 位带符号整数的范围内。
 * 你可以假定二进制数不包含前导零位。
 * 思路：补数其实就是输入的数在每一位都为1，然后减去输入的数，
 *      所以先求第一个大于输入的数的2的幂，再-1，如5，就是8-1=7，8，就是16-1=15
 *      这个数再减去输入数就是补数
 *      100% , 52.78%
 */
public class NumberComplement476 {
    public static void main(String[] args) {
         int num = 8;
         int res = findComplement(num);
        System.out.println(res);
        int ans = findComplement1(num);
        System.out.println(ans);
    }
//    找到第一个大于num的2的幂，然后幂-1-num即为补数
    public static int findComplement(int num) {
         if(num == 0 || num == 1){
             return num == 0 ? 1 : 0;
         }
         long n = 1; // long 类型，防止 num = Integer.MAX_VALUE
         while(n <= num){
             n *= 2;
         }
         return (int)(n - 1 - num);
    }
//    统计num的个数，然后1<< cnt就是第一个大于num的2的幂
    public static int findComplement1(int num){
        int n = num , cnt = 0;
        while(n != 0){
            cnt ++;
            n >>= 1;
        }
        return (int)(num ^ ((long)(1 << cnt) - 1));
    }
}
