package LeetCode;

import java.util.Arrays;

/**
 * LeetCode 73
 * 题意：给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
 * 示例 1:
 * 输入:
 * [
 *   [1,1,1],
 *   [1,0,1],
 *   [1,1,1]
 * ]
 * 输出:
 * [
 *   [1,0,1],
 *   [0,0,0],
 *   [1,0,1]
 * ]
 * 示例 2:
 * 输入:
 * [
 *   [0,1,2,0],
 *   [3,4,5,2],
 *   [1,3,1,5]
 * ]
 * 输出:
 * [
 *   [0,0,0,0],
 *   [0,4,5,0],
 *   [0,3,1,0]
 * ]
 * 进阶:
 * 一个直接的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
 * 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
 * 你能想出一个常数空间的解决方案吗？
 * 思路：关键在于原地替换，
 *      先标记行是否有0，列是否有0，
 *      然后判断剩下的(m-1)*(n-1)，如果有0的，就把其对应的行和列标记为0，
 *      再判断第一行 i=1 ;i< n; i++，如果有0的，将这一列置为0，
 *      再判断第一列，j=1; j < m ; j ++ ，如果有0的，这一行置为0
 *      最后根据第一步判断的行是否有0，列是否有0，将第一行和第一列置为0
 *      1005 ， 75.49%
 */
public class SetMatrixZeroes73 {
    public static void main(String[] args) {
        int[][] matrix = {{1,1,0},{1,0,1},{1,1,1}};
        setZeroes(matrix);
        for(int[] nums : matrix){
            System.out.println(Arrays.toString(nums));
        }
    }
    public static void setZeroes(int[][] matrix){
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        boolean isRow = false , isCol = false;
        for(int i = 0; i < n ; i ++){
            if(matrix[0][i] == 0){
                isRow = true;
                break;
            }
        }
        for(int j = 0; j < m ; j ++){
            if(matrix[j][0] == 0){
                isCol = true;
                break;
            }
        }
        for(int i = 1; i < m ; i ++){
            for(int j = 1 ; j < n ; j ++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for(int i = 1;i < n ; i ++){
            if(matrix[0][i] == 0){
                for(int j = 1; j < m ; j ++){
                    matrix[j][i] = 0;
                }
            }
        }
        for(int j = 1; j < m ; j ++){
            if(matrix[j][0] == 0){
                for(int i = 1; i < n ; i ++){
                    matrix[j][i] = 0;
                }
            }
        }
        if(isRow){
            for(int i = 0 ; i < n ; i ++){
                matrix[0][i] = 0;
            }
        }
        if(isCol){
            for (int j = 0; j < m; j ++){
                matrix[j][0] = 0;
            }
        }
    }
}
