package LeetCode;
/**
 * LeetCode 75
 * 题意：给定一个包含红色、白色和蓝色，一共 n 个元素的数组，
 * 原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * 注意:
 * 不能使用代码库中的排序函数来解决这道题。
 * 示例:
 * 输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]
 * 进阶：
 * 一个直观的解决方案是使用计数排序的两趟扫描算法。
 * 首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
 * 你能想出一个仅使用常数空间的一趟扫描算法吗？
 * 思路：一遍扫描，那就只能对数字进行交换，
 *      遇到 2 ，将其与右边元素交换，right --, i -- ，保证2都在右侧
 *      遇到 0 ， 将其与左边left 元素交换，left ++，保证0都在左侧，
 *      遇到 1 ，忽略
 *      100% , 97.32%
 */

import java.util.Arrays;

public class SortColors75 {
    public static void main(String[] args) {
        int[] nums = {2,0,2,1,2,1,0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
    public static void sortColors(int[] nums) {
        if(nums == null || nums.length == 0){
            return ;
        }
        int left = 0 , right = nums.length - 1;
        for(int i = 0; i <= right; i ++){
            if(nums[i] == 2){
                swap(nums , i , right);
                i --;
                right --;
            }
            else if(nums[i] == 0){
                swap(nums , i , left);
                left ++ ;
            }
        }
    }
    public static void swap(int[] nums , int x , int y){
        int z = nums[x];
        nums[x] = nums[y];
        nums[y] = z;
    }
}
