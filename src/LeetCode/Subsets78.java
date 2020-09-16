package LeetCode;
/**
 * LeetCode 78
 * 题意：给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集。
 * 示例:
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 * 思路：递归 + 回溯
 *      没有递归结束条件，每次都要把list 加入到 res中
 *      需要设置标记位，i = start ; i < nums.length ; i ++
 *      加入，回溯
 *      99.37% , 55.24%
 */

import java.util.ArrayList;
import java.util.List;

public class Subsets78 {
    public static void main(String[] args) {
         int[] nums = {1,2,3};
        List<List<Integer>> res = subsets(nums);
        System.out.println(res);
    }
    public static List<List<Integer>> subsets(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return res;
        }
        dfs(res , new ArrayList<>() , nums , 0);
        return res;
    }

    private static void dfs(List<List<Integer>> res, ArrayList<Integer> list, int[] nums, int start) {
        res.add(new ArrayList<>(list));
        for(int i = start ; i < nums.length ; i ++){
            list.add(nums[i]);
            dfs(res , list , nums , i + 1);
            list.remove(list.size() - 1);
        }
    }
}
