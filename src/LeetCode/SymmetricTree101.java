package LeetCode;

/**
 * LeetCode 101
 * 题意：给定一个二叉树，检查它是否是镜像对称的。
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 * 进阶：
 * 你可以运用递归和迭代两种方法解决这个问题吗？
 * 思路：递归好想，迭代或许要同时对两棵树进行某种遍历？
 *      100% , 96.93%
 */
public class SymmetricTree101 {
    public static void main(String[] args) {

    }
    public static boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return check(root.left , root.right);
    }
    public static boolean check(TreeNode nodea , TreeNode nodeb){
        if(nodea == null && nodeb == null){
            return true;
        }
        if(nodea == null || nodeb == null){
            return false;
        }
        if(nodea.val != nodeb.val){
            return false;
        }
        return check(nodea.left , nodeb.right) && check(nodea.right , nodeb.left);
    }
}
