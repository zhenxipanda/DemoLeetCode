package LeetCode;

/**
 * LeetCode 81
 * 题意：假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。
 * 编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。
 * 示例 1:
 * 输入: nums = [2,5,6,0,0,1,2], target = 0
 * 输出: true
 * 示例 2:
 * 输入: nums = [2,5,6,0,0,1,2], target = 3
 * 输出: false
 * 进阶:
 * 这是 搜索旋转排序数组33 的延伸题目，本题中的 nums  可能包含重复元素。
 * 这会影响到程序的时间复杂度吗？会有怎样的影响，为什么？
 * 思路：二分，只不过有了重复元素，需要对nums[mid]和nums[right]比较，
 *      也就是单独把 == 的情况拿出来了，其他就和 leetcode 33 相似了
 *      68.58% , 26.64%
 */
public class SearchInRotatedSortedArray2_81 {
    public static void main(String[] args) {
        int[] nums = {2,5,5,0,0,1,2};
        int target = 3;
        boolean res = search(nums, target);
        System.out.println(res);
    }
    public static boolean search(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return false;
        }
        int left = 0 , right = nums.length - 1;
        while(left <= right){
            int mid = (left + right) >> 1;
            if(nums[mid] == target){
                return true;
            }
            if(nums[right] == nums[mid]){
                right --;
            }
            else if(nums[mid] < nums[right]){
                if(nums[mid] < target && target <= nums[right]){
                    left = mid + 1;
                }
                else{
                    right = mid - 1;
                }
            }
            else{
                if(nums[left] <= target && target < nums[mid]){
                    right = mid - 1;
                }
                else{
                    left = mid + 1;
                }
            }
        }
        return false;
    }
}
