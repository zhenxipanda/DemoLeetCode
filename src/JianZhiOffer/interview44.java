package JianZhiOffer;

/**
 * 剑指offer 44
 * 题意：数字以0123456789101112131415…的格式序列化到一个字符序列中。
 * 在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。
 * 请写一个函数，求任意第n位对应的数字。
 * 示例 1：
 * 输入：n = 3
 * 输出：3
 * 示例 2：
 * 输入：n = 11
 * 输出：0
 * 限制：
 * 0 <= n < 2^31
 * 思路：计算出下标指向的是几位数字，
 *      然后计算分组，计算组内偏移，
 *      100% , 86.54%
 */
public class interview44 {
    public static void main(String[] args) {
        int n = 15;
        int res = findNthDigit(n);
        System.out.println(res);
    }
    public static int findNthDigit(int n){
        if(n <= 9){
            return n;
        }
        int len = 1;
        int start = (int)(Math.pow(10 , len - 1) * len * 9);
        while (n >= start){
            n -= start;
            len ++ ;
            start = (int)(Math.pow(10 , len - 1) * len * 9);
        }
        int number = n / len;
        int mod = n % len;
        if(mod == 0){
            return (int)(Math.pow(10 , len - 1) + number - 1 ) % 10;
        }
        else{
            int target = (int)(Math.pow(10 , len - 1) + number);
            String s = String.valueOf(target);
            char c = s.charAt(mod - 1);
            return c - '0';
        }
    }
}
