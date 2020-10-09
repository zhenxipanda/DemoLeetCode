package LeetCode;
/**
 * LeetCode 226
 * 题意：翻转一棵二叉树。
 * 示例：
 * 输入：
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 输出：
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 * 备注:
 * 这个问题是受到 Max Howell 的 原问题 启发的 ：
 * 谷歌：我们90％的工程师使用您编写的软件(Homebrew)，
 * 但是您却无法在面试时在白板上写出翻转二叉树这道题，这太糟糕了。
 * 思路：递归 + 迭代
 *      关键在于交换两个子树，然后递归 或 迭代，将不空的左右子树加入队列
 *      100% , 56%
 */

import java.util.LinkedList;

public class InvertBinaryTree226 {
    public static void main(String[] args) {

    }

    //    递归
    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    //    迭代 100% , 85.21%
    public static TreeNode invertTree1(TreeNode root) {
        if (root == null) {
            return root;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return root;
    }
}
