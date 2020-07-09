package LeetCode;

/**
 * LeetCode 236
 * 题意：
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，
 * 最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
 * 示例 1:
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出: 3
 * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 * 示例 2:
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出: 5
 * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
 * 说明:
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉树中。
 * 思路：给定的树是一棵普通的二叉树，不是二叉搜索树，
 *      大的方向肯定是递归，考虑递归出口，
 *      首先是 root == null ，return null；
 *      然后是 root.val == p.val || root.val == q.val，
 *      p，q中有一者是父，则直接return root。
 *      然后就是p,q位于两棵子树上，向左遍历，向右遍历，
 *      如果左右都不为空，即定位到了，说明当前root是他们的公共父节点，
 *      如果左右有一者为空，不为空的那个即为公共父节点。
 *      99.91% , 5.71%
 */
public class LowestCommonAncestorOfABinaryTree236 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode l1 = new TreeNode(5);
        TreeNode r1 = new TreeNode(1);
        TreeNode l12 = new TreeNode(2);
        TreeNode r11 = new TreeNode(4);
        root.left = l1;
        root.right = r1;
        l1.right = l12;
        r1.left = r11;
        TreeNode p = new TreeNode(5);
        TreeNode q = new TreeNode(2);
        TreeNode ans = lowestCommonAncestor(root , p , q);
        System.out.println(ans.val);
    }
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }
        if(root.val == p.val || root.val == q.val){
            return root;
        }
        TreeNode lchild = lowestCommonAncestor(root.left , p , q);
        TreeNode rchild = lowestCommonAncestor(root.right , p , q);
        if(lchild != null && rchild != null){
            return root ;
        }
        if(lchild != null){
            return lchild;
        }
        return rchild;
    }
}
