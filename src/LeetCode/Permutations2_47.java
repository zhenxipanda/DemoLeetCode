package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode 47
 * 题意：给定一个可包含重复数字的序列，返回所有不重复的全排列。
 * 示例:
 * 输入: [1,1,2]
 * 输出:
 * [
 *   [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 * ]
 * 思路：存在重复元素，先排序，
 *      boolean[]存储一个元素是否在list中，因为有重复元素，contains()不好使
 *      解集不能存在重复元素，所以对于相邻且值相等且没被访问的，跳过
 *      75.69% , 5.89%
 */
public class Permutations2_47 {
    public static void main(String[] args) {
        int[] nums = {1,2,1};
        List<List<Integer>> res = permuteUnique(nums);
        System.out.println(res);
    }
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return res;
        }
        Arrays.sort(nums);
        boolean[] flag = new boolean[nums.length];
        dfs(res , new ArrayList<>() , nums , flag);
        return res;
    }
    public static void dfs(List<List<Integer>> res , List<Integer> list , int[] nums , boolean[] flag){
        if(list.size() == nums.length){
            res.add(new ArrayList<>(list));
            return ;
        }
        for(int i = 0;i < nums.length; i ++){
            if(flag[i] == true){
                continue;
            }
            if(i > 0  && nums[i] == nums[i - 1] && !flag[i - 1]){
                continue;
            }
            flag[i] = true;
            list.add(nums[i]);
            dfs(res , list , nums , flag);
            flag[i] = false;
            list.remove(list.size() - 1);
        }
    }
}
