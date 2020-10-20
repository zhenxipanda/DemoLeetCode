package JianZhiOffer;
/**
 * 剑指offer 34
 * 题意：输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。
 * 从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
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
 * 提示：
 * 节点总数 <= 10000
 * 思路：与 LeetCode 113 相同
 *      找到满足条件的路径之后，list.add(new ArrayList<>(li)),不用return
 *      遍历完左右子树之后，再remove(li.size() - 1);
 *      100% , 99.21%
 */

import LeetCode.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class interview34 {
    public static void main(String[] args) {

    }
    public static List<List<Integer>> pathSum(TreeNode root, int sum){
        List<List<Integer>> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        dfs(list , new ArrayList<>() , root , sum);
        return list;
    }
    public static void dfs(List<List<Integer>> list , List<Integer> li , TreeNode root , int sum){
        if(root == null){
            return ;
        }
        sum -= root.val;
        li.add(root.val);
        if(root.left == null && root.right == null && sum == 0){
            list.add(new ArrayList<>(li));
        }
        if(root.left != null){
            dfs(list , li , root.left , sum);
        }
        if(root.right != null){
            dfs(list , li , root.right , sum);
        }
        li.remove(li.size() - 1);
    }
}
