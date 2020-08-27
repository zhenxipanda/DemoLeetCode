package LeetCode;

/**
 * LeetCode 7
 * 题意：
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * 示例 1:
 * 输入: 123
 * 输出: 321
 * 示例 2:
 * 输入: -123
 * 输出: -321
 * 示例 3:
 * 输入: 120
 * 输出: 21
 * 注意:
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。
 * 请根据这个假设，如果反转后整数溢出那么就返回 0。
 * 思路：从后开始取得一位位，*10+，比较巧妙的一点，无论正负这样操作都可以，
 *      -123 % 10 = -3， -123 / 10 = -12，不用额外操作
 *      100% , 37.60%
 */
public class ReverseInteger7 {
    public static void main(String[] args) {
        int x = -321;
        int res = reverse(x);
        System.out.println(res);
    }
    public static int reverse(int x) {
        if(x == 0){
            return 0;
        }
        long res = 0;
        while(x != 0){
            int tmp = x % 10;
            x /= 10;
         //   System.out.println(tmp + "," + x);
            res = res * 10 + tmp;
            if( res > Integer.MAX_VALUE || res < Integer.MIN_VALUE){
                return 0;
            }
        }
        return (int)( res);
    }
}
