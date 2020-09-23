package LeetCode;

/**
 * LeetCode 111
 * 题意：给定一个二叉树，找出其最小深度。
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * 说明: 叶子节点是指没有子节点的节点。
 * 示例:
 * 给定二叉树 [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最小深度  2.
 * 思路： 与104 二叉树的最大深度不同，这里要用到Math.min()
 *       但是有个问题，如果[1,2]按照min应该是1，但是正确答案应该是2
 *       所以对于 root == null ，应该返回 Integer.MAX_VALUE
 *       100% , 13.61%
 */
public class MinimumDepthOfBinaryTree111 {
    public static void main(String[] args) {

    }
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        return depth(root);
    }
    public int depth(TreeNode root){
        if(root == null){
            return Integer.MAX_VALUE;  // 这一点是与 104 二叉树的最大深度 不同的点
            // return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        int left = depth(root.left);
        int right = depth(root.right);
        return Math.min(left, right) + 1;
    }
}
