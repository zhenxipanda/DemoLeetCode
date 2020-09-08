package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode 39
 * 题意：给定一个无重复元素的数组 candidates 和一个目标数 target ，
 * 找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的数字可以无限制重复被选取。
 * 说明：
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1：
 * 输入：candidates = [2,3,6,7], target = 7,
 * 所求解集为：
 * [
 *   [7],
 *   [2,2,3]
 * ]
 * 示例 2：
 * 输入：candidates = [2,3,5], target = 8,
 * 所求解集为：
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 * 提示：
 * 1 <= candidates.length <= 30
 * 1 <= candidates[i] <= 200
 * candidate 中的每个元素都是独一无二的。
 * 1 <= target <= 500
 * 思路：先排序！
 *      然后递归+回溯，因为可以重复使用，所以递归参数认为i
 *      99.92% ， 92.20%
 */
public class CombinationSum39 {
    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        int target = 7;
        List<List<Integer>> res = combinationSum(candidates , target);
        System.out.println(res);
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target){
        List<List<Integer>> res = new ArrayList<>();
        int len = candidates.length;
        Arrays.sort(candidates);
        dfs(candidates , len , target , 0 , new ArrayList<>() , res);
        return res;
    }

    private static void dfs(int[] candidates, int len, int target, int start, ArrayList<Integer> path, List<List<Integer>> res) {
        if(target == 0){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = start ; i < len ; i ++){
            if(target - candidates[i] < 0){
                break;
            }
            path.add(candidates[i]);
            dfs(candidates , len , target - candidates[i] , i , path, res);
            path.remove(path.size() - 1);
        }
    }
}
