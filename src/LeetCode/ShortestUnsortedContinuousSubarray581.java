package LeetCode;

/**
 * LeetCode 581
 * 题意：
 * 给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 * 你找到的子数组应是最短的，请输出它的长度。
 * 示例 1:
 * 输入: [2, 6, 4, 8, 10, 9, 15]
 * 输出: 5
 * 解释: 你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
 * 说明 :
 * 输入的数组长度范围在 [1, 10,000]。
 * 输入的数组可能包含重复元素 ，所以升序的意思是<=。
 * 思路：最短的子数组长度，这个区间左边的元素小于此区间的最小元素，
 *      这个区间右边的元素大于此区间的最大元素，前提是有左侧，有右侧
 *      从左遍历数组，找到第一个下降的拐点，这是此区间的最小值，接着向后遍历，记录最小值
 *      从右遍历数组，找到第一个上升的拐点，这是此区间的最大值，接着向左遍历，记录最大值
 *      然后不能直接两个边界相减，如{1,3,2,2,2},结果就不对
 *      正确的做法是，再从左遍历，找到第一个大于最小值的元素，从右遍历找到第一个小于最大值的元素
 *      两个边界相减做有效判断，<0 ? 0 : right - left + 1
 *      79.31% , 32.43%
 */
public class ShortestUnsortedContinuousSubarray581 {
    public static void main(String[] args) {
        int[] nums = {2,6,4,8,10,9,15};
        int res = findUnsortedSubarray(nums);
        System.out.println(res);
    }
    public static int findUnsortedSubarray(int[] nums) {
        int min = Integer.MAX_VALUE , max = Integer.MIN_VALUE;
        boolean flag = false;
        for(int i = 1;i < nums.length ; i ++){
            if(nums[i] < nums[i - 1]){
                flag = true;
            }
            if(flag){
                min = Math.min(min , nums[i]);
            }
        }
        flag = false;
        for(int i = nums.length - 2; i >= 0; i --){
            if(nums[i] > nums[i + 1]){
                flag = true;
            }
            if(flag){
                max = Math.max(max , nums[i]);
            }
        }
        int left = 0 , right = nums.length - 1;
        for(;left < nums.length; left ++){
            if(nums[left] > min){
                break;
            }
        }
        for(; right >= 0; right --){
            if(nums[right] < max){
                break;
            }
        }
        return right - left < 0 ? 0 : right - left + 1;
    }
}
