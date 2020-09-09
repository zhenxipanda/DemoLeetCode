package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 46
 * 题意：给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * 示例:
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 * 思路：因为没有重复，所以可以不设定index/start
 *      从0开始遍历，如果list中包含nums[1],continue
 *      否则，正常list.add(),dfs(),list.remove(list.size() - 1)
 *      46.74% , 72.69%
 */
public class Permutations46 {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> res = permute(nums);
        System.out.println(res);
    }
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return res;
        }
        dfs(res , new ArrayList<>() , nums);
        return res;
    }
    public static void dfs(List<List<Integer>> res , List<Integer> list,int[] nums){
        if(list.size() == nums.length){
            res.add(new ArrayList<>(list));
            return ;
        }
        for(int i = 0;i < nums.length; i ++){
            if(list.contains(nums[i])){
                continue;
            }
            list.add(nums[i]);
            dfs(res , list, nums);
            list.remove(list.size() - 1);
        }
    }
}
