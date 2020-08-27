package LeetCode;

/**
 * LeetCode 9
 * 题意：
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * 示例 1:
 * 输入: 121
 * 输出: true
 * 示例 2:
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * 进阶:
 * 你能不将整数转为字符串来解决这个问题吗？
 * 思路：先对负数 和 非零且末位是0的进行判断排除
 *      然后从后开始遍历，便利到一半长度就可以停止，循环条件是 x > y
 *      最后判断 x == y || x == y / 10
 *      65.47% , 29.64%
 */
public class PalindromeNumber9 {
    public static void main(String[] args) {
        int x = 121;
        boolean res = isPalindrome(x);
        System.out.println(res);
    }
    public static boolean isPalindrome(int x) {
        if(x < 0 || (x != 0 && x % 10 == 0)){
            return false;
        }
        int y = 0;
        while(x > y){
            int tmp = x % 10;
            y = y * 10 + tmp;
            x /= 10;
        }
        return (x == y) || (x == y / 10);
    }
}
