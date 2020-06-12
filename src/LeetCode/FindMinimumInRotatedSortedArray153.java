package LeetCode;

/**
 * LeetCode 153
 * 题意：假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 请找出其中最小的元素。
 * 你可以假设数组中不存在重复元素。
 * 输入: [3,4,5,1,2]
 * 输出: 1
 * 输入: [4,5,6,7,0,1,2]
 * 输出: 0
 * 思路：因为没有重复元素，所以比较简单。
 *      1. 采用二分的思想，但是要对特殊情况进行处理，即nums[0] < nums[nums.length - 1] ,数组升序
 *      2. 二分结束的条件，left + 1 = right，只有两个元素的时候，最小值一定在两个元素之间产生
 *      3. 如果 nums[left] < nums[mid] , 说明left--mid这个区间是升序的，left = mid
 *      4. 如果 nums[left] > nums[mid] , 说明mid --right这个区间升序，right = mid ,不能为mid - 1，因为mid 可能为最小值
 *      100% , 5.55%
 */
public class FindMinimumInRotatedSortedArray153 {
    public static void main(String[] args) {
        int[] nums = {3,0,1,2};
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
            int mid = (right + left) >> 1 ;
            if(nums[left] < nums[mid]){
                left = mid ;
            }
            else{
                right = mid ;
            }
        }
        return nums[left] < nums[right] ? nums[left] : nums[right];
    }
}
