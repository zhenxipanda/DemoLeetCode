package LeetCode;
/**
 * LeetCode 144
 * 题意：给定一个二叉树，返回它的 前序 遍历。
 * 示例:
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * 输出: [1,2,3]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * 思路：关键在于节点的值如List的时机，
 *      100% , 60.58%
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreePreorderTraversal144 {
    public static void main(String[] args) {

    }
//  迭代
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        while (root != null || !queue.isEmpty()) {
            if (root != null) {
                queue.offer(root);
                res.add(root.val);
                root = root.left;
            } else {
                TreeNode node = queue.removeLast();
                root = node.right;
            }
        }
        return res;
    }

    //    递归
    public static List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root , res);
        return res;
    }
    public static void dfs(TreeNode root , List<Integer> res){
        if(root == null){
            return ;
        }
        res.add(root.val);
        dfs(root.left , res);
        dfs(root.right , res);
    }
}
