package JianZhiOffer;

import LeetCode.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指offer 07
 * 题意：输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如，给出
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 限制：
 * 0 <= 节点个数 <= 5000
 * 思路：与leetcode 105 同
 *      递归构建二叉树，把中序用Map存储下标
 *      83.12% , 60.83%
 */
public class interview07 {
    public static void main(String[] args) {

    }

    private static Map<Integer, Integer> map = new HashMap<>();

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length) {
            return null;
        }
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return myBuild(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public static TreeNode myBuild(int[] preorder, int preStart, int preEnd, int[] inorder, int orStart, int orEnd) {
        if (preStart > preEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int index = map.get(preorder[preStart]);
        root.left = myBuild(preorder, preStart + 1, preStart + index - orStart, inorder, orStart, index - 1);
        root.right = myBuild(preorder, preStart + index - orStart + 1, preEnd, inorder, index + 1, orEnd);
        return root;
    }
}
