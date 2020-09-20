package LeetCode;

/**
 * LeetCode 98
 * 题意：给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * 假设一个二叉搜索树具有如下特征：
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 * 示例 2:
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 * 思路：在验证的过程中，设定最大值最小值
 *      特别注意，if(root == null) return true , not false
 *      100% , 71.76%
 */
public class ValidateBinarySearchTree98 {
    public static void main(String[] args) {

    }
    public static boolean isValidBST(TreeNode root) {
        if(root == null){
            return true; // not false !
        }
        return dfs(root , Long.MIN_VALUE , Long.MAX_VALUE);
    }

    private static boolean dfs(TreeNode root, long minValue, long maxValue) {
        if(root == null){
            return true;
        }
        if(!(root.val > minValue && root.val < maxValue)){
            return false;
        }
        return dfs(root.left , minValue , root.val) && dfs(root.right , root.val , maxValue);
    }
}
