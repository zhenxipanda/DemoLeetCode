package JianZhiOffer;

/**
 * 剑指offer 17
 * 题意：输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。
 * 比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 * 示例 1:
 * 输入: n = 1
 * 输出: [1,2,3,4,5,6,7,8,9]
 * 说明：
 * 用返回一个整数列表来代替打印
 * n 为正整数
 * 思路：对于n较小的情况可以
 *      99.98% , 39.32%
 */
public class interview17 {
    public static void main(String[] args) {
       int n = 2;
       int[] res = printNumbers(n);
        System.out.println(res);
    }
    public static int[] printNumbers(int n) {
        int nums = 1;
        while(n != 0){
            nums *= 10;
            n --;
        }
        int[] res = new int[nums - 1];
        for(int i = 0;i < nums - 1; i ++){
            res[i] = i + 1;
        }
        return res;
    }
}
