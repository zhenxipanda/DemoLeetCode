package LeetCode;

/**
 * LeetCode 129
 * 题意：给定一个二叉树，它的每个结点都存放一个 0-9 的数字，
 * 每条从根到叶子节点的路径都代表一个数字。
 * 例如，从根到叶子节点路径 1->2->3 代表数字 123。
 * 计算从根到叶子节点生成的所有数字之和。
 * 说明: 叶子节点是指没有子节点的节点。
 * 示例 1:
 * 输入: [1,2,3]
 *     1
 *    / \
 *   2   3
 * 输出: 25
 * 解释:
 * 从根到叶子节点路径 1->2 代表数字 12.
 * 从根到叶子节点路径 1->3 代表数字 13.
 * 因此，数字总和 = 12 + 13 = 25.
 * 示例 2:
 * 输入: [4,9,0,5,1]
 *     4
 *    / \
 *   9   0
 *  / \
 * 5   1
 * 输出: 1026
 * 解释:
 * 从根到叶子节点路径 4->9->5 代表数字 495.
 * 从根到叶子节点路径 4->9->1 代表数字 491.
 * 从根到叶子节点路径 4->0 代表数字 40.
 * 因此，数字总和 = 495 + 491 + 40 = 1026.
 * 思路：递归参数要有从根到父节点的计算和father
 *      如果遍历到了叶子节点，直接返回计算完的结果res
 *      100% , 9.52%
 */
public class SumRootToLeafNumbers129 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode l1 = new TreeNode(2);
        TreeNode r1 = new TreeNode(5);
        root.left = l1;
        root.right = r1;
        int res = sumNumbers(root);
        System.out.println(res);
    }
    public static int sumNumbers(TreeNode root){
        if(root == null){
            return 0;
        }
        return dfs(root , 0);
    }

    private static int dfs(TreeNode root, int father) {
        if(root == null){
            return 0;
        }
        int cur = father * 10 + root.val;
        if(root.left == null && root.right == null){
            return cur;
        }
        int left = dfs(root.left , cur);
        int right = dfs(root.right , cur);
        return left + right;
    }
}