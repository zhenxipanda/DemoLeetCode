package JianZhiOffer;

/**
 * 剑指offer 03
 * 题意：找出数组中重复的数字。
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
 * 请找出数组中任意一个重复的数字。
 * 示例 1：
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 * 思路：遍历数组，将每个数字通过交换放到其正确位置上，如果存在重复的,nums[i] == nums[nums[i]]
 *      91.47% , 51.64%
 */
public class interview03 {
    public static void main(String[] args) {
        int[] nums = {2,3,1,0,2,4};
        int res = findRepeatNumber(nums);
        System.out.println(res);
    }
    public static int findRepeatNumber(int[] nums) {
        for(int i = 0 ; i < nums.length ; i ++){
            if(i != nums[i]){
                if(nums[i] == nums[nums[i]]){
                    return nums[i];
                }
                int tmp = nums[i];
                nums[i] = nums[tmp];
                nums[tmp] = tmp;
            }
        }
        return -1;
    }
}
