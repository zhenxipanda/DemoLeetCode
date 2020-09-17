package LeetCode;

/**
 * LeetCode 33
 * 题意：假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * 你可以假设数组中不存在重复的元素。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 示例 1:
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 示例 2:
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 * 思路：将中间元素与target对比，不匹配，按照nums[left]与nums[mid]的大小关系，进行细分
 *      每次二分，缩短长度
 *      100% , 51.33%
 */
public class SearchInRotatedSortedArray33 {
    public static void main(String[] args) {

    }
    public static int search(int[] nums, int target){
        if(nums == null || nums.length == 0){
            return -1;
        }
        int left = 0 ,right = nums.length - 1;
        while (left <= right){
            int mid = (left + right) >> 1;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[left] <= nums[mid]){   // <= ,not <
                if(nums[left] <= target && target < nums[mid]){
                    right = mid - 1;
                }
                else{
                    left = mid + 1;
                }
            }
            else{
                if(nums[mid] < target && target <= nums[right]){
                    left = mid + 1;
                }
                else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
