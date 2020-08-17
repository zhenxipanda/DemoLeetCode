package LeetCode;

/**
 * LeetCode 110
 * 题意：
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * 本题中，一棵高度平衡二叉树定义为：
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
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
 * 思路：在递归的过程中设置停止标记，
 *      当发现左右子树差 >= 2时，说明这棵树一定不是平衡二叉树，
 *      设置深度为-1，递归之后判断，若深度为-1，直接返回-1
 *      最后判断深度函数返回的是否为-1，-1，不是平衡树，不是-1，即为树的最大深度
 *      99.76% , 50.64%
 */
public class BalancedBinaryTree110 {
    public static void main(String[] args) {

    }
    public static boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        return depth(root) != -1;
    }
    public static int depth(TreeNode root){
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        int left = depth(root.left);
        if(left == -1){
            return -1;
        }
        int right = depth(root.right);
        if(right == -1){
            return -1;
        }
        return Math.abs(right - left) < 2 ? Math.max(left , right) + 1 : -1;
    }
}
