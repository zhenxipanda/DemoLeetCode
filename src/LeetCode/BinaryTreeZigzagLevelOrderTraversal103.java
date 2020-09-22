package LeetCode;
/**
 * LeetCode 103
 * 题意：给定一个二叉树，返回其节点值的锯齿形层次遍历。
 * （即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回锯齿形层次遍历如下：
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 * 思路：仍然是使用队列，与102相比，记录了层数layer，当layer % 2 == 0 时，Collections.reverse(list);
 *      98.30% , 63.94%
 */

import java.util.*;
public class BinaryTreeZigzagLevelOrderTraversal103 {
    public static void main(String[] args) {

    }
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int layer = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            ArrayList<Integer> list = new ArrayList<>();
            while(size != 0){
                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
                size --;
            }
            if(layer % 2 == 0){
                //  list.Reverse();
                Collections.reverse(list);
            }
            res.add(list);
            layer ++;
        }
        return res;
    }
}
