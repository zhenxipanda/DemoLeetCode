package LeetCode;

/**
 * LeetCode 543
 * 题意：
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。
 * 这条路径可能穿过也可能不穿过根结点。
 * 示例 :
 * 给定二叉树
 *
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 * 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
 * 注意：两结点之间的路径长度是以它们之间边的数目表示。
 * 思路：二叉树的操作，一般可用递归，
 *      定义全局变量记录最大值，递归返回的是二叉树的最大深度
 *      100% , 54.08%
 */
public class DiameterOfBinaryTree543 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode l1 = new TreeNode(2);
        TreeNode r1 = new TreeNode(3);
        TreeNode l11 = new TreeNode(4);
        root.left = l1;
        root.right = r1;
        l1.left = l11;
        int res = diameterOfBinaryTree(root);
        System.out.println(res);
    }
    private static int dima = 0;
    public static int diameterOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        int res = dfs(root);
        return dima;
    }
    public static int dfs(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        dima = Math.max(dima , left + right);
        return Math.max(left , right) + 1;
    }
}
