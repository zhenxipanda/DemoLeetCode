package LeetCode;

/**
 * LeetCode 538
 * 题意：
 * 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，
 * 使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
 * 例如：
 * 输入: 原始二叉搜索树:
 *               5
 *             /   \
 *            2     13
 * 输出: 转换为累加树:
 *              18
 *             /   \
 *           20     13
 * 思路：注意这是二叉搜索树，大于某节点的元素一定在它的右侧部分
 *      反序中序遍历，先遍历右子树，然后本节点的值变化，再遍历左子树，
 *      用全局变量share存储一路遍历来的和
 *      98.40% , 27.38%
 */
public class ConvertBstToGreaterTree538 {
    public static void main(String[] args) {
       TreeNode root = new TreeNode(5);
       TreeNode l1 = new TreeNode(2);
       TreeNode r1 = new TreeNode(13);
       root.left = l1;
       root.right = r1;
       TreeNode res = convertBST(root);
        System.out.println(res.val);
        System.out.println(res.left.val);
        System.out.println(res.right.val);
    }
    private static int share = 0;
    public static TreeNode convertBST(TreeNode root) {
        if(root == null){
            return root;
        }
        mirror(root);
        return root;
    }
    public static void mirror(TreeNode root){
        if(root == null){
            return ;
        }
        mirror(root.right);
        root.val = root.val + share;
        share = root.val;
        mirror(root.left);
    }
}
