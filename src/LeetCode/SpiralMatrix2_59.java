package LeetCode;

import java.util.Arrays;

/**
 * LeetCode 59
 * 题意：给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 给定 n 和 k，返回第 k 个排列。
 * 说明：
 * 给定 n 的范围是 [1, 9]。
 * 给定 k 的范围是[1,  n!]。
 * 示例 1:
 * 输入: n = 3, k = 3
 * 输出: "213"
 * 示例 2:
 * 输入: n = 4, k = 9
 * 输出: "2314"
 * 思路：因为是n*n矩阵，一定存在完整的顺时针圈，
 *      所以无需向左和向上走时判断top < bottom && left < right
 *      100% , 88.94%
 */
public class SpiralMatrix2_59 {
    public static void main(String[] args) {
        int n = 3;
        int[][] res = generateMatrix(n);
        for(int[] arr : res){
            System.out.println(Arrays.toString(arr));
        }
    }
    public static int[][] generateMatrix(int n) {
        int num = 1;
        int top = 0 , bottom = n - 1 , left = 0 , right = n - 1;
        int[][] ans = new int[n][n];
        while(num <= n * n){
            for(int j = left; j <= right; j ++){
                ans[top][j] = num ++;
            }
            for(int i = top + 1;i <= bottom; i ++){
                ans[i][right] = num ++;
            }
            for(int j = right - 1;j >= left ; j --){
                ans[bottom][j] = num ++;
            }
            for(int i = bottom - 1;i > top; i --){
                ans[i][left] = num ++;
            }
            top ++;
            bottom --;
            left ++;
            right -- ;
        }
        return ans;
    }
}
