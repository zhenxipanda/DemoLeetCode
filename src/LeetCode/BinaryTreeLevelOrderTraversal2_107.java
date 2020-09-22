package LeetCode;
/**
 * LeetCode 107
 * 题意：给定一个二叉树，返回其节点值自底向上的层次遍历。
 * （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其自底向上的层次遍历为：
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 * 思路：仍然是从根开始遍历，但是可以买次都将一行的遍历结果addFirst()到res中
 *      98.24% , 98.20%
 */

import java.util.*;
public class BinaryTreeLevelOrderTraversal2_107 {
    public static void main(String[] args) {

    }
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        if(root == null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            while(size != 0){
                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
                size --;
            }
            res.addFirst(list);
        }
        return res;
    }
}
