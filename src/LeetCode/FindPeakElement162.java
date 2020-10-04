package LeetCode;

/**
 * LeetCode 162
 * 峰值元素是指其值大于左右相邻值的元素。
 * 给定一个输入数组 nums，其中 nums[i] ≠ nums[i+1]，找到峰值元素并返回其索引。
 * 数组可能包含多个峰值，在这种情况下，返回任何一个峰值所在位置即可。
 * 你可以假设 nums[-1] = nums[n] = -∞。
 * 输入: nums = [1,2,3,1]
 * 输出: 2
 * 解释: 3 是峰值元素，你的函数应该返回其索引 2。
 * 输入: nums = [1,2,1,3,5,6,4]
 * 输出: 1 或 5
 * 解释: 你的函数可以返回索引 1，其峰值元素为 2；
 *      或者返回索引 5， 其峰值元素为 6。
 * 说明: 你的解法应该是 O(logN) 时间复杂度的。
 * 思路：如果是O(N)复杂度，那很简单，但是要求是O(lgN),说明要二分
 *      之前二分操作的都是有序数组，但是这里可以在局部有序的前提下二分，
 *      局部有序，就是把 mid 与 mid + 1 的元素值比较
 *      如果nums[mid] > nums[mid + 1] , right = mid , 不能是 mid - 1，因为 mid 可能是峰值
 *      如果nums[mid] < nums[mid + 1] , left = mid + 1 ,不能是 mid ，因为 mid 不可能是峰值(nums[mid+1]>nums[mid])
 *      结束的条件是left == right，left即为峰值
 *      100% , 43.26%
 */
public class FindPeakElement162 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        int res = findPeakElement(nums);
        System.out.println(res);
    }
    public static int findPeakElement(int[] nums) {
        int left = 0 , right = nums.length - 1 ;
        while(left < right){
            int mid = (left + right) >> 1 ;
            if(nums[mid] > nums[mid + 1]){
                right = mid ;
            }
            else{
                left = mid + 1;
            }
        }
        return left ;
    }
}
