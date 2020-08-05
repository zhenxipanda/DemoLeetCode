package LeetCode;

/**
 * LeetCode 378
 * 题意：
 * 给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
 * 请注意，它是排序后的第 k 小元素，而不是第 k 个不同的元素。
 * 示例：
 * matrix = [
 *    [ 1,  5,  9],
 *    [10, 11, 13],
 *    [12, 13, 15]
 * ],
 * k = 8,
 * 返回 13。
 * 提示：
 * 你可以假设 k 的值永远是有效的，1 ≤ k ≤ n2 。
 * 思路：类似于二分，将区分有序的矩阵，看成一个一维数组
 *      只不过这里的二分，不是以下标计算，而是以元素值计算，
 *      额外写一个函数，统计矩阵中 <= 目标值 的元素个数 count
 *      当 count < k 时，start = mid + 1,因为mid 不会是最终结果
 *      当 count >= k 时，end = mid，因为mid 可能是最终结果
 *      当 start == end 时，就是最终结果，且这个元素一定在矩阵中。
 *      100% , 7.69%
 */
public class KthSmallestElementInASortedMatrix378 {
    public static void main(String[] args) {
        int[][] matrix = {{1,5,9},{10,11,13},{12,13,15}};
        int k = 6;
        int res = kthSmallest(matrix , k);
        System.out.println(res);
    }
    public static int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int start = matrix[0][0];
        int end = matrix[m - 1][n - 1];
        int count = 0;
        while(start < end){ //一定是< ,不是 <=
            int mid = (start + end) / 2;
            count = countLess(matrix , mid);
            if(count < k){
                start = mid + 1;
            }
            else{
                end = mid ;
            }
        }
        return start ;
    }
    public static int countLess(int[][] matrix , int index){
        int m = matrix.length;
        int n = matrix[0].length;
        int row = 0 , col = n - 1;
        int res = 0;
        while(row < m && col >= 0){
            if(matrix[row][col] > index){
                col --;
            }
            else{
                res += col + 1;
                row ++;
            }
        }
        return res;
    }
}
