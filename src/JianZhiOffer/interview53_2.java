package JianZhiOffer;

/**
 * 剑指offer 53-2
 * 题意：一个长度为n-1的递增排序数组中的所有数字都是唯一的，
 * 并且每个数字都在范围0～n-1之内。
 * 在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 * 示例 1:
 * 输入: [0,1,3]
 * 输出: 2
 * 示例 2:
 * 输入: [0,1,2,3,4,5,6,7,9]
 * 输出: 8
 * 限制：
 * 1 <= 数组长度 <= 10000
 * 思路：因为数组升序，所以可以二分，充分利用升序的特点，
 *      如果nums[mid] == mid , 说明左半部分是正常的，缺失的数字在右半部分，
 *      否则，如果mid == 0 || 前一个元素值等于下标，说明当前元素是缺失的，未在正确位置上，return mid
 *      100% , 94.38%
 */
public class interview53_2 {
    public static void main(String[] args) {
        int[] nums = {0,1,2,3,4,5,6,7,9};
        int res = missingNumber(nums);
        System.out.println(res);
    }
    public static int missingNumber(int[] nums){
        int left = 0 , right = nums.length - 1 ;
        while(left <= right){
            int mid = (left + right) >> 1;
            if(nums[mid] == mid){
                left = mid + 1;
            }
            else{
                if(mid == 0 || nums[mid - 1] == mid - 1){
                    return mid;
                }
                right = mid - 1;
            }
        }
        return left;
    }
}
