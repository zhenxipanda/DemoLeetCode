package JianZhiOffer;

/**
 * 剑指offer 53
 * 题意：统计一个数字在排序数组中出现的次数。
 * 示例 1:
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 * 示例 2:
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: 0
 * 限制：
 * 0 <= 数组长度 <= 50000
 * 思路：与 LeetCode 34 相同，只返回值不同，关键在于找第一个位置和最后一个位置的操作不同
 *      100% , 86.97%
 */
public class interview53_1 {
    public static void main(String[] args) {
        int[] nums = {5,6,6,8,8,10};
        int target = 8;
        int res = search(nums, target);
        System.out.println(res);
    }
    public static int search(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        boolean isLeft = true;
        int first = binary(nums , 0 , nums.length - 1, target , isLeft);
        int last = binary(nums , 0 , nums.length - 1 , target , !isLeft) - 1;
        return last - first + 1;
    }
    public static int binary(int[] nums , int start , int end , int target , boolean isLeft){
        int mid = 0;
        while(start <= end){
            mid = (start + end) >> 1;
            if(isLeft && nums[mid] >= target){
                end = mid - 1;
            }
            else if(isLeft && nums[mid] < target){
                start = mid + 1;
            }
            else if(nums[mid] <= target){
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }
        return start;
    }
}
