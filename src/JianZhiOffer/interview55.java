package JianZhiOffer;
/**
 * 剑指offer 55
 * 题意：输入一棵二叉树的根节点，求该树的深度。
 * 从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 * 提示：
 * 节点总数 <= 10000
 * 思路：与 LeetCode 104 相同
 *      递归
 *      100% , 88.06%
 */

import LeetCode.TreeNode;

public class interview55 {
    public static void main(String[] args) {

    }
    public static int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
