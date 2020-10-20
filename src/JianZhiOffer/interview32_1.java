package JianZhiOffer;
/**
 * 剑指offer 32-1
 * 题意：从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回：
 * [3,9,20,15,7]
 * 提示：
 * 节点总数 <= 1000
 * 思路：一个队列存放节点，层序遍历，每行从左到右，
 *      99.77% , 98.43%
 */

import LeetCode.TreeNode;
import java.util.*;
public class interview32_1 {
    public static void main(String[] args) {

    }
    public static int[] levelOrder(TreeNode root) {
        if(root == null){
            return new int[0];
        }
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        queue.offer(root);
        while(! queue.isEmpty()){
            int size = queue.size();
            while(size != 0){
                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
                size --;   //这句不能丢
            }
        }
        int[] res = new int[list.size()];
        for(int i = 0;i < res.length; i ++){
            res[i] = list.get(i);
        }
        return res;
    }
}
