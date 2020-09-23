package LeetCode;
/**
 * LeetCode 113
 * 题意：给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 * 说明: 叶子节点是指没有子节点的节点。
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * 返回:
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 * 思路：递归 + 回溯，特别注意，res.add(new ArrayList<>(list))之后，不用return ，因为这种情况以及考虑完了，
 *      需要把最后一个remove掉
 *      100% , 15.31%
 */

import java.util.ArrayList;
import java.util.List;

public class PathSum2_113 {
    public static void main(String[] args) {

    }
    public static List<List<Integer>> pathSum(TreeNode root, int sum){
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        dfs(res , new ArrayList<>() , root , sum);
        return res;
    }

    private static void dfs(List<List<Integer>> res, ArrayList<Integer> list, TreeNode root, int sum) {
        if(root == null){
            return;
        }
        sum -= root.val;
        list.add(root.val);
        if(root.left == null && root.right == null && sum == 0){
            res.add(new ArrayList<>(list));
        }
        if(root.left != null){
            dfs(res , list, root.left , sum);
        }
        if(root.right != null){
            dfs(res , list , root.right , sum);
        }
        list.remove(list.size() - 1);
    }
}
