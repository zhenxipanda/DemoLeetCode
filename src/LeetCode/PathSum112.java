package LeetCode;

/**
 * LeetCode 112
 * 题意：
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，
 * 这条路径上所有节点值相加等于目标和。
 * 说明: 叶子节点是指没有子节点的节点。
 * 示例: 
 * 给定如下二叉树，以及目标和 sum = 22，
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \      \
 *         7    2      1
 * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
 * 思路：比较简单的一道题，用递归来做，
 *      首先判断边界条件，root == null ，return false;
 *      root != null , root.val一定存在，
 *      所以 sum -= root.val,
 *      考虑递归结束条件，也就是root是叶子节点时，判断sum == 0，
 *      如果sum == 0 , 说明存在，返回true，sum != 0，说明当前路径不符合要求，返回false
 *      然后如果root不是叶子，就递归其左子树，右子树，有一者为true，即可，
 *      所以 return hasPathSum(root.left , sum) | hasPathSum(root.right , sum)
 *      100% , 6.52%
 */
public class PathSum112 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode l1 = new TreeNode(4);
        TreeNode r1 = new TreeNode(8);
        root.left = l1;
        root.right = r1;
        int sum = 13;
        boolean res = hasPathSum(root , sum);
        System.out.println(res);
    }
    public static boolean hasPathSum(TreeNode root, int sum) {
        if(root == null){
            return false;
        }
        sum -= root.val;
        if(root.left == null && root.right == null){
            return sum == 0;
        }
        return hasPathSum(root.left , sum) || hasPathSum(root.right , sum );
    }
}
