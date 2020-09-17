package LeetCode;
/**
 * LeetCode 90
 * 题意：给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集。
 * 示例:
 * 输入: [1,2,2]
 * 输出:
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 * 思路：与 子集78 相似，只不过有重复元素了，
 *      所以先排序，然后递归，比78 多了一个判断，if(i > start && nums[i] == nums[i-1]) continue;
 *      必须是 i > start 不能是 i > 0
 *      99.94% , 74.68%
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets2_90 {
    public static void main(String[] args) {
       int[] nums = {2,1,2};
        List<List<Integer>> res = subsetsWithDup(nums);
        System.out.println(res);
    }
    public static List<List<Integer>> subsetsWithDup(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return res;
        }
        Arrays.sort(nums);
        dfs(res , new ArrayList<>() , nums , 0);
        return res;
    }

    private static void dfs(List<List<Integer>> res, ArrayList<Integer> list, int[] nums, int start) {
        res.add(new ArrayList<>(list));
        for(int i = start ; i < nums.length ; i ++){
            if(i > start && nums[i] == nums[i - 1]){
                continue;
            }
            list.add(nums[i]);
            dfs(res , list , nums , i + 1);
            list.remove(list.size() - 1);
        }
    }
}
