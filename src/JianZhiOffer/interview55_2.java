package JianZhiOffer;
/**
 * 剑指offer 55-2
 * 题意：输入一棵二叉树的根节点，判断该树是不是平衡二叉树。
 * 如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 * 示例 1:
 * 给定二叉树 [3,9,20,null,null,15,7]
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回 true 。
 * 示例 2:
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 * 返回 false 。
 * 限制：
 * 1 <= 树的结点个数 <= 10000
 * 思路：与 LeetCode 110 相同
 *      可以设定提前停止条件，发现不满足平衡条件，返回值为-1
 *      99.99% , 96.74%
 */

import LeetCode.TreeNode;

public class interview55_2 {
    public static void main(String[] args) {

    }
    public static boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }
    public static int height(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftH = height(root.left);
        if(leftH == -1){
            return -1;
        }
        int rightH = height(root.right);
        if(rightH == -1){
            return -1;
        }
        return Math.abs(rightH - leftH) < 2 ? Math.max(leftH, rightH) + 1: -1;
    }
}
