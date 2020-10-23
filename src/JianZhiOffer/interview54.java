package JianZhiOffer;
/**
 * 剑指offer 54
 * 题意：给定一棵二叉搜索树，请找出其中第k大的节点。
 * 示例 1:
 * 输入: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * 输出: 4
 * 示例 2:
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *   /
 *  1
 * 输出: 4
 * 限制：
 * 1 ≤ k ≤ 二叉搜索树元素个数
 * 思路：中序遍历，只不过先右子树，根，再左子树，
 *      找到count == 1的之后，记得一定要count -- ,否则res值会被覆盖掉
 *      100% , 96.56%
 */

import LeetCode.TreeNode;

public class interview54 {
    public static void main(String[] args) {

    }
    private static int count = 0;
    private static int res = -1;
    public static int kthLargest(TreeNode root, int k){
        count = k;
        dfs(root);
        return res;
    }
    public static void dfs(TreeNode root){
        if(root == null){
            return;
        }
        dfs(root.right);
        if(count == 1){
            res = root.val;
            count --; // must have
            return;
        }
        count --;
        dfs(root.left);
    }
}
