package JianZhiOffer;
/**
 * 剑指offer 29
 * 题意：输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 * 示例 1：
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 示例 2：
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 * 限制：
 * 0 <= matrix.length <= 100
 * 0 <= matrix[i].length <= 100
 * 思路：与LeetCode 54 相同
 *      设定四周边界，一圈一圈打印
 *      96.72% , 100%
 */

import java.util.Arrays;

public class interview29 {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6}};
        int[] res = spiralOrder(matrix);
        System.out.println(Arrays.toString(res));
    }
    public static int[] spiralOrder(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return new int[0];
        }
        int m = matrix.length , n = matrix[0].length ;
        int[] res = new int[m * n];
        int top = 0 , bottom = m - 1 , left = 0 , right = n - 1 , k = 0;
        while(k < m * n){
            for(int i = left ; i <= right ; i ++){
                res[k ++] = matrix[top][i] ;
            }
            for(int j = top + 1; j <= bottom ; j ++){
                res[k ++] = matrix[j][right] ;
            }
            if(left < right && top < bottom){
                for(int i = right - 1; i >= left ; i --){
                    res[k ++] = matrix[bottom][i];
                }
                for(int j = bottom - 1; j > top ; j --){
                    res[k ++] = matrix[j][left];
                }
            }
            top ++;
            bottom --;
            left ++;
            right --;
        }
        return res;
    }
}
