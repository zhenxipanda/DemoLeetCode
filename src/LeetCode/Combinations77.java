package LeetCode;
/**
 * LeetCode 77
 * 题意：给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * 示例:
 * 输入: n = 4, k = 2
 * 输出:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 * 思路：递归+回溯，
 *      dfs()除了res , list , n , k 还需要有开始下标start
 *      递归结束条件就是list.size() == k,res.add(new ArrayList<>(list); return ;)
 *      从 i = start ; i <= n - (k - list.size()) + 1; 这里的剪枝条件很重要，k=2时，i最大为3
 *      剩下就是回溯了
 *      97.41% , 47.37%
 */

import java.util.ArrayList;
import java.util.List;

public class Combinations77 {
    public static void main(String[] args) {
        int n = 4 ;
        int k = 2;
        List<List<Integer>> res = combine(n, k);
        System.out.println(res);
    }
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if(n == 0){
            return res;
        }
        dfs(res , new ArrayList<>() , n , k ,1);
        return res;
    }
    public static void dfs(List<List<Integer>> res , List<Integer> list , int n , int k , int start){
        if(list.size() == k){
            res.add(new ArrayList<>(list));
            return ;
        }
        for(int i = start ; i <= n - (k - list.size()) + 1 ; i ++){
            list.add(i);
            dfs(res , list , n , k , i + 1);
            list.remove(list.size() - 1);
        }
    }
}
