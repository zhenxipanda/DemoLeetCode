package LeetCode;

/**
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 示例 1:
 * 输入:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 3
 * 输出: true
 * 示例 2:
 * 输入:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 13
 * 输出: false
 * 思路：因为是每行严格递增，且下一行比上一行都大，所以可以看做一维数组，
 *      用二分，进行查找
 *      100% , 71.46%
 */
public class SearchA2dMatrix74 {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        int target = 7;
        boolean res = searchMatrix(matrix, target);
        System.out.println(res);
    }
    public static boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0 , right = m * n - 1;
        while(left <= right){
            int mid = (left + right) >> 1;
            if(matrix[mid / n][mid % n] == target){
                return true;
            }
            else if(matrix[mid / n][mid % n] > target){
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        return false;
    }
}
