package LeetCode;

/***
 * LeetCode 326
 * 题意：给定一个整数，写一个函数来判断它是否是 3 的幂次方。
 * 示例 1:
 * 输入: 27
 * 输出: true
 * 示例 2:
 * 输入: 0
 * 输出: false
 * 示例 3:
 * 输入: 9
 * 输出: true
 * 示例 4:
 * 输入: 45
 * 输出: false
 * 进阶：
 * 你能不使用循环或者递归来完成本题吗？
 * 思路：方法一，不符合进阶要求，使用了循环
 *      如果是3的幂，一直除以3，判断余数是否为0，不为0肯定不是3的幂，最后判断 n == 1
 *      方法二，符合进阶要求，枚举法
 *      Int范围内，3的幂有20个，包括0次幂，把20个列举出来判断
 *      方法三，方法二的改进
 *      将int 范围内3的幂最大值 max拿出来
 *      如果某个数是3的幂，那么 max % x == 0
 *      96.30% ， 8.70%
 */
public class PowerOfThree326 {
    public static void main(String[] args) {
        int n = 45;
        boolean res = isPowerOfThree(n);
        System.out.println(res);
    }
    public static boolean isPowerOfThree(int n) {
        while(n / 3 >= 1){
            if(n % 3 != 0){
                return false;
            }
            n /= 3;
        }
        return n == 1;
    }
    // 枚举：int 范围内 是3的幂的只有20个，包括0次幂
    public static  boolean isPowerOfThree1(int n) {
        if (n == 1 || n == 3 || n == 9 || n == 27 || n == 81 || n == 243 || n == 729 ||
                n == 2187 || n == 6561 || n == 19683 || n == 59049 || n == 177147 ||
                n == 531441 || n == 1594323 || n == 4782969 || n == 14348907 ||
                n == 43046721 || n == 129140163 || n == 387420489 || n == 1162261467) {
            return true;
        } else {
            return false;
        }
    }
    // 在枚举基础上改进：
    public static boolean isPowerOfThree2(int n) {
        return (n > 0 && 1162261467 % n == 0) ? true : false;
    }
}
