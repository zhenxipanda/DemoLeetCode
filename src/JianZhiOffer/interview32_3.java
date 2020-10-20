package JianZhiOffer;
/**
 * 剑指offer 32-3
 * 题意：请实现一个函数按照之字形顺序打印二叉树，
 * 即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，
 * 第三行再按照从左到右的顺序打印，其他行以此类推。
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
 *   [20,9],
 *   [15,7]
 * ]
 * 提示：
 * 节点总数 <= 1000
 * 思路：偶数层反转，利用Collections.reverse(li);
 *      再list.add(li);
 *      99.84% , 95.67%
 */

import LeetCode.TreeNode;
import java.util.*;
public class interview32_3 {
    public static void main(String[] args) {

    }
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int layer = 0;
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
            layer ++ ;
            if(layer % 2 == 0){
                Collections.reverse(li);
            }
            list.add(li);
        }
        return list;
    }
}
