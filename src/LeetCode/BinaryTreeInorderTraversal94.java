package LeetCode;
/**
 * LeetCode 94
 * 题意：给定一个二叉树，返回它的中序 遍历。
 * 示例:
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,3,2]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * 思路：迭代方法，设置一个辅助LinkedList，存放节点
 *      递归方法，需要一个无返回值的dfs(root , list)
 *      100% , 52.11%
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeInorderTraversal94 {
    public static void main(String[] args) {

    }
    public static List<Integer> inorderTraversal(TreeNode root){
        List<Integer> list = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        while (root != null || !queue.isEmpty()){
            if(root != null){
                queue.add(root);
                root = root.left;
            }
            else{
                root = queue.removeLast();
                list.add(root.val);
                root = root.right;
            }
        }
        return list;
    }
    public static List<Integer> inorderTraversal1(TreeNode root){
        List<Integer> list = new ArrayList<>();
        dfs(root , list);
        return list;
    }
    public static void dfs(TreeNode root , List<Integer> list){
        if(root == null){
            return ;
        }
        dfs(root.left , list);
        list.add(root.val);
        dfs(root.right , list);
    }
}
