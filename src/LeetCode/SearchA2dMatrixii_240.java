package LeetCode;

/**
 * LeetCode 240
 * 题意：
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 * 示例:
 * 现有矩阵 matrix 如下：
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 * 给定 target = 20，返回 false。
 * 思路：刷过《剑指offer》的朋友对这道题不会陌生，
 *      这是《剑指offer》的第一道题，
 *      主要思路是从右上角或左下角开始扫描数组，
 *      因为每行是升序，每列也是升序，所以右上角是此行最大的元素，
 *      如果此行最大的元素都比目标值小，说明这一行都比目标值小，
 *      所以进入行数 +1 ，进入下一行，如果下一行的此位置比目标值大，那就向左遍历，
 *      移动的方向一直都是向下或向左，不会向上或向右移动
 *      99.74% , 17.86%
 */
public class SearchA2dMatrixii_240 {
    public static void main(String[] args) {
        int[][] matrix = {{1,4,7},{2,5,8},{3,6,9}};
        int target = 6;
        boolean res = searchMatrix(matrix , target);
        System.out.println(res);
    }
    public static boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int row = 0 , col = n - 1;
        while(row < m && col >= 0){
            if(matrix[row][col] > target){
                col --;
            }
            else if(matrix[row][col] < target){
                row ++;
            }
            else{
                return true;
            }
        }
        return false;
    }
}
