package JianZhiOffer;

/**
 * 剑指offer 64
 * 题意：求 1+2+...+n ，要求不能使用乘除法、
 * for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * 示例 1：
 * 输入: n = 3
 * 输出: 6
 * 示例 2：
 * 输入: n = 9
 * 输出: 45
 * 限制：
 * 1 <= n <= 10000
 * 思路：(n+1)*n/2, /2 == >> 1,
 *      n = n13 * 2^13 + n12 * 2^12 + n11 * 2^11 + ... + n0 * 2^0
 *      (n >>> 13) & 1 : 判断第14位是否为1，如果为1 ，(n+1)&-1 = (n+1)
 *      如果是0，(n+1)&0 = 0，
 *      100% , 99.89%
 */
public class interview64 {
    public static void main(String[] args) {
        int n = 9;
        int res = sumNums(n);
        System.out.println(res);
    }
    public static int sumNums(int n) {
        int n13 = ((n + 1) & (0 - ((n >>> 13) & 1))) << 13;
        int n12 = ((n + 1) & (0 - ((n >>> 12) & 1))) << 12;
        int n11 = ((n + 1) & (0 - ((n >>> 11) & 1))) << 11;
        int n10 = ((n + 1) & (0 - ((n >>> 10) & 1))) << 10;
        int n9 = ((n + 1) & (0 - ((n >>> 9) & 1))) << 9;
        int n8 = ((n + 1) & (0 - ((n >>> 8) & 1))) << 8;
        int n7 = ((n + 1) & (0 - ((n >>> 7) & 1))) << 7;
        int n6 = ((n + 1) & (0 - ((n >>> 6) & 1))) << 6;
        int n5 = ((n + 1) & (0 - ((n >>> 5) & 1))) << 5;
        int n4 = ((n + 1) & (0 - ((n >>> 4) & 1))) << 4;
        int n3 = ((n + 1) & (0 - ((n >>> 3) & 1))) << 3;
        int n2 = ((n + 1) & (0 - ((n >>> 2) & 1))) << 2;
        int n1 = ((n + 1) & (0 - ((n >>> 1) & 1))) << 1;
        int n0 = (n + 1) & (0 - (n & 1));
        return (n13 + n12 + n11 + n10 + n9 + n8 + n7 + n6 + n5 + n4 + n3 + n2 + n1 + n0)>>1;
    }
}
