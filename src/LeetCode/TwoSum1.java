package LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
/**
 * LeetCode 1
 * 题意：
 * 给定一个整数数组 nums 和一个目标值 target，
 * 请你在该数组中找出和为目标值的那 两个 整数，
 * 并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * 思路：不保证有序，不能用二分，用map存储，判断差额是否存在
 *      57.99% , 42.91%
 */
public class TwoSum1 {
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        int[] res = twoSum(nums, target);
        System.out.println(Arrays.toString(res));
    }
    public static int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return new int[0];
        }
        int[] ans = new int[2];
        Map<Integer , Integer> map = new HashMap<>();
        for(int i = 0 ; i < nums.length ; i ++){
            int another = target - nums[i];
            if(map.containsKey(another)){
                ans[0] = map.get(another);
                ans[1] = i;
            }
            map.put(nums[i] , i);
        }
        return ans;
    }
}
