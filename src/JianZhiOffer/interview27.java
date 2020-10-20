package JianZhiOffer;
/**
 * 剑指offer 27
 * 题意：请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 * 例如输入：
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 镜像输出：
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 * 示例 1：
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 * 限制：
 * 0 <= 节点个数 <= 1000
 * 思路：与LeetCode 226相同
 *      递归，如果为null 或者 为叶子，直接返回，
 *      否则交换左右子树，如果左右子树不空，递归左右子树
 *      100% , 99.92%
 */

import LeetCode.TreeNode;

public class interview27 {
    public static void main(String[] args) {

    }
    public static TreeNode mirrorTree(TreeNode root){
        if(root == null){
            return null;
        }
        if(root.left == null && root.right == null){
            return root;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        if(root.left != null){
            mirrorTree(root.left);
        }
        if(root.right != null){
            mirrorTree(root.right);
        }
        return root;
    }
}
