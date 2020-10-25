package JianZhiOffer;

/**
 * 剑指offer 65
 * 题意：写一个函数，求两个整数之和，
 * 要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
 * 示例:
 * 输入: a = 1, b = 1
 * 输出: 2
 * 提示：
 * a, b 均可能是负数或 0
 * 结果不会溢出 32 位整数
 * 思路：利用异或，与，左移
 *      100% , 95.24%
 */
public class interview65 {
    public static void main(String[] args) {
        int a = 2 , b = 1;
        int res = add(a, b);
        System.out.println(res);
    }
    public static int add(int a, int b) {
        while(a != 0){
            int tmp = (a ^ b);
            a = (a & b) << 1;
            b = tmp;
        }
        return b;
    }
}
