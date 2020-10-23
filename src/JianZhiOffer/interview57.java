package JianZhiOffer;

import java.util.Arrays;

/**
 * 剑指offer 57
 * 题意：输入一个递增排序的数组和一个数字s，
 * 在数组中查找两个数，使得它们的和正好是s。
 * 如果有多对数字的和等于s，则输出任意一对即可。
 * 示例 1：
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[2,7] 或者 [7,2]
 * 示例 2：
 * 输入：nums = [10,26,30,31,47,60], target = 40
 * 输出：[10,30] 或者 [30,10]
 * 限制：
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^6
 * 思路：因为递增，所以两个指针扫描
 *      98.51% , 92.89%
 */
public class interview57 {
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        int[] res = twoSum(nums, target);
        System.out.println(Arrays.toString(res));
    }
    public static int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        int left = 0, right = nums.length - 1;
        while(left < right){
            if(nums[left] + nums[right] == target){
                res[0] = nums[left];
                res[1] = nums[right];
                return res;
            }
            else if(nums[left] + nums[right] < target){
                left ++;
            }
            else{
                right --;
            }
        }
        return res;
    }
}
