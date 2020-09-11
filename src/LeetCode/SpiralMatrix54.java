package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 54
 * 题意：给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 * 示例 1:
 * 输入:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 * 示例 2:
 * 输入:
 * [
 *   [1, 2, 3, 4],
 *   [5, 6, 7, 8],
 *   [9,10,11,12]
 * ]
 * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 * 思路：外层循环条件控制好，
 *      向右走，向下走，
 *      判断top < bottom && left < right 向左走，向上走
 *      100% , 63.72%
 */
public class SpiralMatrix54 {
    public static void main(String[] args) {
        int[][] nums = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15}};
        print(nums);
        List<Integer> res = spiralOrder(nums);
        System.out.println(res);
    }
//    字节面试
    public static void print(int[][] nums){
        if(nums == null || nums.length == 0 || nums[0].length == 0){
            return ;
        }
        int up = 0 , down = nums.length - 1;
        int left = 0 , right = nums[0].length - 1;
        int k = 0 , sum = (down + 1) * (right + 1);
        while(k < sum){
            for(int i = left ; i <= right ; i ++){
                System.out.print(nums[up][i] + ", ");
                k ++;
            }
            for(int j = up + 1 ; j <= down; j ++){
                System.out.print(nums[j][right] + ", ");
                k ++;
            }
            if(up < down){
                for(int i = right - 1; i >= left ; i --){
                    System.out.print(nums[down][i] + ", ");
                    k ++;
                }
                if(left < right){
                    for(int j = down - 1; j > up ; j --){
                        System.out.print(nums[j][left] + ", ");
                        k ++;
                    }
                }

            }
            up ++;
            down --;
            left ++ ;
            right --;
//            竟然智障把k++ 写到了这里！！
        }
    }
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return list;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int top = 0 , bottom = m - 1 , left = 0 , right = n - 1;
        while(top <= bottom && left <= right){
            for(int j = left ; j <= right ; j ++){
                list.add(matrix[top][j]);
            }
            for(int i = top + 1 ;i <= bottom; i ++){
                list.add(matrix[i][right]);
            }
            if(top < bottom && left < right){
                for(int j = right - 1; j >= left; j --){
                    list.add(matrix[bottom][j]);
                }
                for(int i = bottom - 1;i > top; i --){
                    //     System.out.println(i + ", " + left);
                    list.add(matrix[i][left]);
                }
            }
            top ++;
            left ++;
            bottom -- ;
            right --;
        }
        return list;
    }
}
