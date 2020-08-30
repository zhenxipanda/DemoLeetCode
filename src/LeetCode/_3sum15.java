package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode 15
 * 题意：
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
 * 使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * 示例：
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 * 思路：先排序，三个元素，三个指针，外层循环控制最左指针，
 *      内层循环控制，另外两个指针，因为有序，所以二分，
 *      遇到重复的，忽略
 *      59.69% , 83.94%
 */
public class _3sum15 {
    public static void main(String[] args) {
        int[] nums = {-1,0,-1,2,-4};
        List<List<Integer>> list = threeSum(nums);
        System.out.println(list);
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return list;
        }
        Arrays.sort(nums);
        for(int i = 0 ; i < nums.length - 2; i ++){
            if(i > 0 && nums[i] == nums[i - 1]){
                continue ;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while(left < right){
                if(nums[i] + nums[left] + nums[right] > 0){
                    right -- ;
                }
                else if(nums[i] + nums[left] + nums[right] < 0){
                    left ++ ;
                }
                else{
                    list.add(Arrays.asList(nums[i] , nums[left] , nums[right]));
                    left ++;
                    while(left < right && nums[left] == nums[left - 1]){
                        left ++ ;
                    }
                }
            }
        }
        return list;
    }
}
