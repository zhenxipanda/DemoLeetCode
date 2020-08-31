package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode 18
 * 题意：
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，
 * 判断 nums 中是否存在四个元素 a，b，c 和 d ，
 * 使得 a + b + c + d 的值与 target 相等？
 * 找出所有满足条件且不重复的四元组。
 * 注意：
 * 答案中不可以包含重复的四元组。
 * 示例：
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 * 满足要求的四元组集合为：
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 * 思路：与15三数之和相比思路大体一致，两层for循环，多了提前判断条件，
 *      相邻相等的，continue;
 *      计算min,min > target ,break;
 *      计算max,max < target , continue;
 *      指定内层，相邻相等，inmin,inmax,
 *      再while(l < r),
 *      sum == target , asList(),l ++ ;相邻且相等,l ++
 *      sum < target , l ++;
 *      else r --;
 *      92.68% , 76.00%
 */
public class _4sum18 {
    public static void main(String[] args) {
        int[] nums = {-1,0,2,1,0,-2};
        int target = 0;
        List<List<Integer>> res = fourSum(nums , target);
        System.out.println(res);
    }
    public static List<List<Integer>> fourSum(int[] nums, int target){
        List<List<Integer>> list = new ArrayList<>();
        if(nums == null || nums.length < 4){
            return list;
        }
        Arrays.sort(nums);
        int n = nums.length;
        for(int k = 0 ; k < n - 3; k ++){
            if(k > 0 && nums[k] == nums[k - 1]){
                continue;
            }
            int min = nums[k] + nums[k + 1] + nums[k + 2] + nums[k + 3];
            if(min > target){
                break;
            }
            int max = nums[k] + nums[n - 3] + nums[n - 2] + nums[n - 1];
            if(max < target){
                continue;
            }
            for(int i = k + 1 ; i < n - 2 ; i ++){
                if(i > k + 1 && nums[i] == nums[i - 1]){
                    continue;
                }
                int l = i + 1 , r = n - 1;
                int inermin = nums[k] + nums[i] + nums[l] + nums[l + 1];
                if(inermin > target){
                    break;
                }
                int inermax = nums[k] + nums[i] + nums[r - 1] + nums[r];
                if(inermax < target){
                    continue;
                }
                while (l < r){
                    int sum = nums[k] + nums[i] + nums[l] + nums[r];
                    if(sum == target){
                        list.add(Arrays.asList(nums[k] , nums[i] , nums[l] , nums[r]));
                        l ++ ;
                        while (l < r && nums[l] == nums[l - 1]){
                            l ++ ;
                        }
                    }
                    else if(sum > target){
                        r -- ;
                    }
                    else{
                        l ++ ;
                    }
                }
            }
        }
        return list;
    }
}
