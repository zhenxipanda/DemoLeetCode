package LeetCode;

/**
 * LeetCode 35
 * 题意：
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
 * 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 你可以假设数组中无重复元素。
 * 示例 1:
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 示例 3:
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 示例 4:
 * 输入: [1,3,5,6], 0
 * 输出: 0
 * 思路：
 *     二分查找，
 *     如果能找到输出位置下标，
 *     如果找不到，就输出其插入位置
 *     100% , 5.55%
 */
public class SearchInsertPosition35 {
    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int target = 4;
        int res = searchInsert(nums , target);
        System.out.println(res);
    }
    public static int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        // 二分查找条件
        while(left <= right){
            int mid = (left + right) >> 1;
            // 找到，即返回
            if(nums[mid] == target){
                return mid;
            }
            else if(nums[mid] < target){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        // left 即为要插入target 位置下标
        return left;
    }
}
