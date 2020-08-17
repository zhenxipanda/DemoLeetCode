package LeetCode;

/**
 * LeetCode 617
 * 题意：
 * 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
 * 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，
 * 否则不为 NULL 的节点将直接作为新二叉树的节点。
 * 示例 1:
 * 输入:
 * 	Tree 1                     Tree 2
 *           1                         2
 *          / \                       / \
 *         3   2                     1   3
 *        /                           \   \
 *       5                             4   7
 * 输出:
 * 合并后的树:
 * 	     3
 * 	    / \
 * 	   4   5
 * 	  / \   \
 * 	 5   4   7
 * 注意: 合并必须从两个树的根节点开始。
 * 思路：递归，可以新创建一棵树，也可以将合并操作合并到给定的其中一棵树上
 *      如果两者有为空的，就返回另一个，另一个为null，也没有关系
 *      不为空，进行值的相加合并操作，然后递归左子树，右子树
 *      100% , 69.38%
 */
public class MergeTwoBinaryTrees617 {
    public static void main(String[] args) {

    }
    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null)
            return t2;
        if (t2 == null)
            return t1;
        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;

    }
}
