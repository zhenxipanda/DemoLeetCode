package JianZhiOffer;
/**
 * 剑指offer 32-2
 * 题意：从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 * 提示：
 * 节点总数 <= 1000
 * 思路：与 LeetCode 102 相同
 *      与32-1相比，多了内部list
 *      93.31% , 76.80%
 */

import LeetCode.TreeNode;
import java.util.*;
public class interview32_2 {
    public static void main(String[] args) {

    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(! queue.isEmpty()){
            int size = queue.size();
            List<Integer> li = new ArrayList<>();
            while(size != 0){
                TreeNode node = queue.poll();
                li.add(node.val);
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
                size --;
            }
            list.add(li);
        }
        return list;
    }
}
