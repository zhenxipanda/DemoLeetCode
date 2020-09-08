package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode 40
 * 题意：给定一个数组 candidates 和一个目标数 target ，
 * 找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的每个数字在每个组合中只能使用一次。
 * 说明：
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 * 示例 2:
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 * 思路：与39类似，递归+回溯，
 *      不同点：解集不含重复元素，相邻且相等，continue
 *      一个数字在一个解集中只能用一次，所以递归参数 i + 1
 *      99.94% , 53.99%
 */
public class CombinationSum2_40 {
    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        List<List<Integer>> res = combinationSum2(candidates, target);
        System.out.println(res);
    }
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        int len = candidates.length;
        dfs(candidates ,len ,  target , 0 , new ArrayList<>() , res);
        return res;
    }
    public static void dfs(int[] candidates ,int len , int target , int start , List<Integer> path , List<List<Integer>> res){
        if(target == 0){
            res.add(new ArrayList<>(path));
            return ;
        }
        for(int i = start; i < len;i ++){
            if(target - candidates[i] < 0){
                break;
            }
            if( i > start && candidates[i] == candidates[i - 1]){
                continue;
            }
            path.add(candidates[i]);
            dfs(candidates , len , target - candidates[i] , i + 1, path , res);
            path.remove(path.size() - 1);
        }
    }
}
