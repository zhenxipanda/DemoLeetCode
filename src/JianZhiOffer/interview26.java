package JianZhiOffer;
/**
 * LeetCode 26
 * 题意：输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 * 例如:
 * 给定的树 A:
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 * 给定的树 B：
 *    4 
 *   /
 *  1
 * 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
 * 示例 1：
 * 输入：A = [1,2,3], B = [3,1]
 * 输出：false
 * 示例 2：
 * 输入：A = [3,4,5,1,2], B = [4,1]
 * 输出：true
 * 限制：
 * 0 <= 节点个数 <= 10000
 * 思路：先找到A的某个节点与B的根节点val相等的，
 *      然后再各自比较左子树，右子树是否相同。
 *      也可能存在重复的节点，所以比较完根之后，如果flag仍为false，继续判断左子树，右子树
 *      100% , 97.98%
 */

import LeetCode.TreeNode;

public class interview26 {
    public static void main(String[] args) {

    }
    public static boolean isSubStructure(TreeNode A, TreeNode B) {
        if(A == null || B == null){
            return false;
        }
        boolean flag = false;
        if(A.val == B.val){
            flag = isContain(A , B);
        }
        if(!flag){
            flag = isSubStructure(A.left , B);
        }
        if(!flag){
            flag = isSubStructure(A.right , B);
        }
        return flag;
    }
    public static boolean isContain(TreeNode nodea , TreeNode nodeb){
        if(nodeb == null){
            return true;
        }
        if(nodea == null){
            return false;
        }
        if(nodea.val != nodeb.val){
            return false;
        }
        return isContain(nodea.left , nodeb.left) && isContain(nodea.right , nodeb.right);
    }
}
