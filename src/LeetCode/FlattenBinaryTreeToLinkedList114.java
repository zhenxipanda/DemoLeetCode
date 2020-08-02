package LeetCode;

/**
 * LeetCode 114
 * 题意：
 * 给定一个二叉树，原地将它展开为一个单链表。
 * 例如，给定二叉树
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * 将其展开为：
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 * 思路：不用额外的数据结构，
 *      如果左子树不为空，就找到左子树的最右节点，与根的右子树连接起来
 *      再将右子树指针指向左子树，左子树为空，根右移
 *      100% , 31.70%
 */
public class FlattenBinaryTreeToLinkedList114 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode l1 = new TreeNode(2);
        TreeNode r1 = new TreeNode(4);
        TreeNode l12 = new TreeNode(3);
        root.left = l1;
        root.right = r1;
        l1.right = l12;
        flatten(root);
    }
    public static void flatten(TreeNode root){
        if(root == null){
            return ;
        }
        while(root != null){
            if(root.left == null){
                root = root.right;
            }
            else{
                TreeNode pre = root.left;
                while(pre.right != null){
                    pre = pre.right;
                }
                pre.right = root.right;
                root.right = root.left;
                root.left = null;
                root = root.right;
            }
        }
    }
}
