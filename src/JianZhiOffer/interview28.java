package JianZhiOffer;
/**
 * 剑指offer 28
 * 题意：请实现一个函数，用来判断一棵二叉树是不是对称的。
 * 如果一棵二叉树和它的镜像一样，那么它是对称的。
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 * 示例 1：
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 * 示例 2：
 * 输入：root = [1,2,2,null,3,null,3]
 * 输出：false
 * 限制：
 * 0 <= 节点个数 <= 1000
 * 思路：与LeetCode 101 相同
 *      100% , 99.15%
 */

import LeetCode.TreeNode;

public class interview28 {
    public static void main(String[] args) {

    }
    public static boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return isSym(root.left , root.right);
    }
    public static boolean isSym(TreeNode nodel , TreeNode noder){
        if(nodel == null && noder == null){
            return true;
        }
        if(nodel == null || noder == null){
            return false;
        }
        if(nodel.val != noder.val){
            return false;
        }
        return isSym(nodel.left , noder.right) && isSym(nodel.right , noder.left);
    }
}
