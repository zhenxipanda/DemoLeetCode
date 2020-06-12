package LeetCode;

/**
 * LeetCode 154
 * 题意：假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 请找出其中最小的元素。
 * 注意数组中可能存在重复的元素
 * 输入: [2,2,2,0,1]
 * 输出: 0
 * 说明：
 * 这道题是 寻找旋转排序数组中的最小值 的延伸题目。
 * 允许重复会影响算法的时间复杂度吗？会如何影响，为什么？
 * 思路：因为可能存在重复元素，所以有很多情况需要讨论
 *      1. 先讨论特殊情况，nums[0] < nums[nums.length - 1],说明数组升序
 *      2. 仍然是二分，二分结束条件是 left + 1 == right
 *      3. 如果 nums[right] > nums[mid],说明mid-- right这区间升序，right = mid
 *      4. 如果 nums[right] < nums[mid], 说明left -- mid这区间升序,left = mid
 *      5. 如果 nums[right] == nums[mid] ， right = right - 1;
 *      这里就不再关注 nums[left]了。
 *      100% , 60.00%
 */
public class FindMinimumInRotatedSortedArray2_154 {
    public static void main(String[] args) {
      //  int[] nums = {1,1,1,1,1,0,1};
        int[] nums = {1,0,1,1,1,1,1};
        int res = findMin(nums);
        System.out.println(res);
    }
    public static int findMin(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int left = 0 , right = nums.length - 1;
        if(nums[left] < nums[right]){
            return nums[left];
        }
        while(left + 1 < right){
            int mid = (left + right) >> 1 ;
            if(nums[mid] < nums[right]){
                right = mid ;
            }
            else if(nums[mid] > nums[right]){
                left = mid ;
            }
            else{
                right = right - 1;
            }
        }
        return nums[left] < nums[right] ? nums[left] : nums[right];
    }
}
