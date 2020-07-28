package LeetCode;

/**
 * LeetCode 104
 * 题意：
 * 给定一个二叉树，找出其最大深度。
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * 说明: 叶子节点是指没有子节点的节点。
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 * 思路：比较简单，递归方法，
 *      先确定递归出口，root == null ，return 0
 *      然后递归左子树，右子树，取两者最大值  +1（当前节点）
 *      100% , 5.75%
 */
public class MaximumDepthOfBinaryTree104 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode l1 = new TreeNode(2);
        TreeNode l12 = new TreeNode(3);
        root.left = l1;
        l1.right = l12;
        int res = maxDepth(root);
        System.out.println(res);
    }
    public static int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        return Math.max(maxDepth(root.left) , maxDepth(root.right)) + 1;
    }
}
