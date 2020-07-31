package LeetCode;

/**
 * LeetCode 337
 * 题意：
 * 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。
 * 这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。
 * 一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。
 * 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
 * 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
 * 示例 1:
 * 输入: [3,2,3,null,3,null,1]
 *      3
 *     / \
 *    2   3
 *     \   \
 *      3   1
 * 输出: 7
 * 解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7.
 * 示例 2:
 * 输入: [3,4,5,1,3,null,1]
 *
 *      3
 *     / \
 *    4   5
 *   / \   \
 *  1   3   1
 * 输出: 9
 * 解释: 小偷一晚能够盗取的最高金额 = 4 + 5 = 9.
 * 思路：每个节点都有两个选择，偷 或 不偷 ，用result[0]代表不偷的最大价值，
 *      result[1]代表偷的最大价值，
 *      不偷的话，最大价值应该是左子树的最大价值（无论偷不偷） + 右子树的最大价值（无论偷不偷）
 *      偷的话，最大价值是 左子树不偷的价值 + 右子树不偷的价值 + 此节点值
 *      两种情况中取最大者
 *      100% , 24.51%
 */
public class HouseRobberiii337 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode l1 = new TreeNode(4);
        TreeNode r1 = new TreeNode(9);
        TreeNode l11 = new TreeNode(10);
        TreeNode r12 = new TreeNode(5);
        root.left = l1;
        root.right = r1;
        l1.left = l11;
        r1.right = r12;
        int res = rob(root);
        System.out.println(res);
    }
    public static int rob(TreeNode root) {
        int[] result = myRob(root);
        return Math.max(result[0] , result[1]);
    }
    public static int[] myRob(TreeNode root){
        if(root == null){
            return new int[2];
        }
        int[] result = new int[2];
        int[] left = myRob(root.left);
        int[] right = myRob(root.right);
        // 不偷
        result[0] = Math.max(left[0] , left[1]) + Math.max(right[0] , right[1]);
        // 偷
        result[1] = left[0] + right[0] + root.val;
        return  result;
    }
}
