package LeetCode;

import java.util.Arrays;

/**
 * LeetCode 34
 * 题意：给定一个按照升序排列的整数数组 nums，和一个目标值 target。
 * 找出给定目标值在数组中的开始位置和结束位置。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 如果数组中不存在目标值，返回 [-1, -1]。
 * 示例 1:
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 * 思路：第一个位置和最后一个位置，不能找到就停止，
 *      find()查找该元素的插入位置，
 *      注意，如果left大于nums.length || nums[left] != target，说明不存在
 *      关键在于nums[mid]==target时的不同处理，处理isFirst == true，right=mid-1
 *      isFirst == false , left = mid + 1
 *      找最后一个位置，相当于找的是第一个大于该元素的位置
 *      100% , 61.85%
 */
public class FindFirstAndLastPositionOfElementInSortedArray34 {
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        int[] res = searchRange(nums , target);
        System.out.println(Arrays.toString(res));
    }
    public static int[] searchRange(int[] nums, int target) {
        int[] res = {-1 , -1};
        if(nums == null || nums.length == 0){
            return res;
        }
        boolean isFirst = true;
        int left = find(nums , target , isFirst);
        if(left >= nums.length || nums[left] != target){
            return res;
        }
        res[0] = left;
        int right = find(nums , target , !isFirst) - 1;
        res[1] = right;
        return res;
    }
    public static int find(int[] nums , int target , boolean isFirst){
        int left = 0 , right = nums.length - 1;
        while(left <= right){
            int mid = (left + right) >> 1;
            if(nums[mid] < target){
                left = mid + 1;
            }
            else if(nums[mid] > target){   // 这种情况必须有
                right = mid - 1;
            }
            else if(nums[mid] >= target && isFirst){
                right = mid - 1;
            }
            else if(nums[mid] >= target && !isFirst){
                left = mid + 1;
            }
        }
        return left;
    }
}
