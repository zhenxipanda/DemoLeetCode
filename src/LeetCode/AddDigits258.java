package LeetCode;

/**
 * LeetCode 258
 * 题意：给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。
 * 示例:
 * 输入: 38
 * 输出: 2
 * 解释: 各位相加的过程为：3 + 8 = 11, 1 + 1 = 2。 由于 2 是一位数，所以返回 2。
 * 进阶:
 * 你可以不使用循环或者递归，且在 O(1) 时间复杂度内解决这个问题吗？
 * 思路：x * 100 + y * 10 + z = x * 99 + y * 9 + x + y + z
 *      所以 (num - 1) % 9 + 1
 *      100% , 63.86%
 */
public class AddDigits258 {
    public static void main(String[] args) {
        int num = 38;
        int ans = addDigits(num);
        System.out.println(ans);
    }
    public static int addDigits(int num) {
        return (num - 1) % 9 + 1;
    }
}
