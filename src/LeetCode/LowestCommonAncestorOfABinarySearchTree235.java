package LeetCode;

/**
 * LeetCode 235
 * 题意：给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，
 * 最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * 例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
 * 思路：既然是二叉搜索树，那就充分利用节点值的大小关系，
 *      99.89% , 83.33%
 */
public class LowestCommonAncestorOfABinarySearchTree235 {
    public static void main(String[] args) {

    }
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null ;
        }
        if(p.val < root.val && q.val < root.val){
            return lowestCommonAncestor(root.left , p , q);
        }
        else if(p.val > root.val && q.val > root.val){
            return lowestCommonAncestor(root.right , p , q);
        }
        return root;
    }
}
