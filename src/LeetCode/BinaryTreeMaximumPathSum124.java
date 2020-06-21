package LeetCode;

/**
 * LeetCode 124
 * 题意：
 * 给定一个非空二叉树，返回其最大路径和。
 * 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
 * 输入: [-10,9,20,null,null,15,7]
 *    -10
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 输出: 42
 * 思路：定义全局变量存储路径最大和，
 *      因为递归返回的结果肯定是 Math.max(left , right) + root.val
 *      tips:递归左子树和右子树时，如果递归结果为负数，可以舍弃，用0替代，left = Math.max(0 , dfs(root.left))
 *      99.55 %, 7.69%
 */
public class BinaryTreeMaximumPathSum124 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode l1 = new TreeNode(-2);
        TreeNode r1 = new TreeNode(3);
        root.left = l1;
        root.right = r1;
        int res = maxPathSum(root);
        System.out.println(res);
    }
    private static int max = Integer.MIN_VALUE;
    public static int maxPathSum(TreeNode root) {
        int res = dfs(root);
        return max ;
    }
    public static int dfs(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = Math.max(0 , dfs(root.left));
        int right = Math.max(0 , dfs(root.right));
        max = Math.max(max , left + right + root.val);
        return Math.max(left , right) + root.val;
    }
}
