package LeetCode;

import java.util.Arrays;

/**
 * LeetCode 324
 * 题意：
 * 给定一个无序的数组 nums，将它重新排列成 nums[0] < nums[1] > nums[2] < nums[3]... 的顺序。
 * 示例 1:
 * 输入: nums = [1, 5, 1, 1, 6, 4]
 * 输出: 一个可能的答案是 [1, 4, 1, 5, 1, 6]
 * 示例 2:
 * 输入: nums = [1, 3, 2, 2, 3, 1]
 * 输出: 一个可能的答案是 [2, 3, 1, 3, 1, 2]
 * 说明:
 * 你可以假设所有输入都会得到有效的结果。
 * 进阶:
 * 你能用 O(n) 时间复杂度和 / 或原地 O(1) 额外空间来实现吗？
 * 思路：没有做到进阶要求。
 *      先对数组排序，然后确定中位数，开辟新数组
 *      将中位数之前的 较小的数组逆序插入到 新数组奇数位置，
 *      将中位数之后的 较大的数组逆序插入到 新数组的偶数位置
 *      将传入数组复制为新数组
 *      99.39% , 16.67%
 */
public class WiggleSortii324 {
    public static void main(String[] args) {
        int[] nums = {1,5,1,1,6,4};
        wiggleSort(nums);
        System.out.println(Arrays.toString(nums));
    }
    public static void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int mid = 0;
        if((n & 1) == 0){
            mid = n / 2;
        }
        else{
            mid = n / 2 + 1;
        }
        int even = 0 , odd = 1;
        int left = mid - 1 , right = n - 1;
        int[] arr = new int[n];
        while(left >= 0){
            arr[even] = nums[left];
            left --;
            even += 2;
        }
        while(right >= mid){
            arr[odd] = nums[right];
            right --;
            odd += 2;
        }
        System.arraycopy(arr , 0 , nums , 0 , n);
        return ;
    }
}
