package LeetCode;

/**
 * LeetCode 99
 * 题意：二叉搜索树中的两个节点被错误地交换。
 * 请在不改变其结构的情况下，恢复这棵树。
 * 示例 1:
 * 输入: [1,3,null,null,2]
 *    1
 *   /
 *  3
 *   \
 *    2
 * 输出: [3,1,null,null,2]
 *    3
 *   /
 *  1
 *   \
 *    2
 * 示例 2:
 * 输入: [3,1,4,null,null,2]
 *   3
 *  / \
 * 1   4
 *    /
 *   2
 * 输出: [2,1,4,null,null,3]
 *   2
 *  / \
 * 1   4
 *    /
 *   3
 * 进阶:
 * 使用 O(n) 空间复杂度的解法很容易实现。
 * 你能想出一个只使用常数空间的解决方案吗？
 * 思路：pre 指向的是前序遍历的前一个节点，
 *      比较巧妙，还是背下来吧。
 *      99.99% , 28.18%
 */

public class RecoverBinarySearchTree99 {
    public static void main(String[] args) {

    }
    private static TreeNode x = null , y = null , pre = null;
    public static void recoverTree(TreeNode root){
        findTwoNode(root);
        swap(x , y);
    }

    private static void findTwoNode(TreeNode root) {
        if(root == null){
            return ;
        }
        findTwoNode(root.left);
        if(pre != null && root.val < pre.val){
            y = root;
            if(x == null){
                x = pre;
            }
            else{
                return;
            }
        }
        pre = root;
        findTwoNode(root.right);
    }
    public static void swap(TreeNode x , TreeNode y){
        int z = x.val;
        x.val = y.val;
        y.val = z;
    }
}
