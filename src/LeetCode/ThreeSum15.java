package LeetCode;
import java.util.*;
/**
 * LeetCode 15
 * 题意：给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 * 思路：Medium难度，
 *      1. 首先对数组进行排序
 *      2. 双层循环遍历，外围指针index 控制构成三数和为0的第一个元素，内层指针left ,right 构成三数的另外两个数
 *      3. 无论外层指针还是内层指针，在遇到相邻且相同的元素时，应该跳过。
 *
 */
public class ThreeSum15 {
    public static void main(String[] args) {   //快捷键：psvm
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> res = threeSum(nums);
        System.out.println(res);               //快捷键：sout
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return res ;
        }
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i ++){
            if(i > 0 && nums[i] == nums[i - 1]){
                continue ;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while(left < right){
                if(nums[i] + nums[left] + nums[right] < 0){
                    left ++ ;
                }
                else if(nums[i] + nums[left] + nums[right] > 0){
                    right -- ;
                }
                else{
                    res.add(Arrays.asList(nums[i] , nums[left] , nums[right]));
                    left ++;
                    while(left < right && nums[left] == nums[left - 1]){
                        left ++;
                    }
                }
            }
        }
        return res;
    }
}
