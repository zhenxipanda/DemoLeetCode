package JianZhiOffer;

/**
 * 剑指offer 43
 * 题意：输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
 * 例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。
 * 示例 1：
 * 输入：n = 12
 * 输出：5
 * 示例 2：
 * 输入：n = 13
 * 输出：6
 * 限制：
 * 1 <= n < 2^31
 * 思路：递归，
 *      n = 1234, high = 1 , pow = 1000 , last = 234
 *      f(n) = f(pow - 1) + last + 1 + f(last)
 *      n = 3234, high = 3 , pow = 3000 , last = 234
 *      f(n) = pow + high * f(pow - 1) + f(last)
 *      100% , 66.95%
 */
public class interview43 {
    public static void main(String[] args) {
        int n = 12;
        int res = countDigitOne(n);
        System.out.println(res);
    }
    public static int countDigitOne(int n){
        return f(n);
    }

    private static int f(int n) {
        if(n <= 0){
            return 0;
        }
        String s = String.valueOf(n);
        int high = s.charAt(0) - '0';
        int pow = (int)Math.pow(10 , s.length() - 1);
        int last = n - high * pow;
        if(high == 1){
            return f(pow - 1) + last + 1 + f(last);
        }
        else{
            return pow + high * f(pow - 1) + f(last);
        }
    }
}
