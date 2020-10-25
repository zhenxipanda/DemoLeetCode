package JianZhiOffer;
/**
 * 剑指offer 66
 * 题意：给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，
 * 其中 B 中的元素 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
 * 示例:
 * 输入: [1,2,3,4,5]
 * 输出: [120,60,40,30,24]
 * 提示：
 * 所有元素乘积之和不会溢出 32 位整数
 * a.length <= 100000
 * 思路：从左遍历，记录左侧元素们的乘积，
 *      从右遍历，记录右侧元素们的乘积，
 *      83.71% , 70.12%
 */

import java.util.Arrays;

public class interview66 {
    public static void main(String[] args) {
        int[] a = {2,3,4,5};
        int[] res = constructArr(a);
        System.out.println(Arrays.toString(res));
    }
    public static int[] constructArr(int[] a) {
        if(a == null || a.length == 0){
            return new int[0];
        }
        int[] res = new int[a.length];
        res[0] = 1;
        for(int i = 1;i < a.length; i ++){
            res[i] = res[i - 1] * a[i - 1];
        }
        int tmp = 1;
        for(int i = a.length - 2; i >= 0; i --){
            tmp *= a[i + 1];
            res[i] *= tmp;
        }
        return res;
    }
}
