package LeetCode;

/**
 * LeetCode 169
 * 题意：给定一个大小为 n 的数组，找到其中的多数元素。
 * 多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * 示例 1:
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 * 思路：O(N)的时间复杂度就能完成，相邻元素做比较，如果相等，time ++
 *      否则,time -- ，如果 time == 0 , major = nums[i], time ++ ;
 */
public class MajorityElement169 {
    public static void main(String[] args) {
        int[] nums = {3,2,2,3,2,3,3};
        int res = majorityElement(nums);
        System.out.println(res);
    }
    public static int majorityElement(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0 ;
        }
        int major = nums[0];
        int time = 1;
        for(int i = 1;i < nums.length ; i ++){
            if(nums[i] == major){
                time ++;
            }
            else{
                time --;
                if(time == 0){
                    major = nums[i];
                    time ++;
                }
            }
        }
        return major ;
    }
}
