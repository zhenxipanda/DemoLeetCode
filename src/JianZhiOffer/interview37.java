package JianZhiOffer;
/**
 * 剑指offer 37
 * 题意：请实现两个函数，分别用来序列化和反序列化二叉树。
 * 示例: 
 * 你可以将以下二叉树：
 *     1
 *    / \
 *   2   3
 *      / \
 *     4   5
 * 序列化为 "[1,2,3,null,null,4,5]"
 * 思路：与 LeetCode 297 相同
 *      序列化，中序遍历，
 *      反序列化，依次弹出元素，
 *      87.58% , 85.52%
 */

import LeetCode.TreeNode;
import java.util.*;
public class interview37 {
    public static void main(String[] args) {

    }
    public static String serialize(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        buildString(root , sb);
        return sb.toString();
    }

    public static void buildString(TreeNode root , StringBuffer sb){
        if(root == null){
            sb.append("#").append("!");
            return ;
        }
        sb.append(root.val).append("!");
        buildString(root.left , sb);
        buildString(root.right , sb);
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split("!")));
        TreeNode root = buildTree(queue);
        return root;
    }
    public static TreeNode buildTree(Queue<String> queue){
        if(queue.isEmpty()){
            return null;
        }
        String s = queue.poll();
        if(s.equals("#")){
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(s));
        root.left = buildTree(queue);
        root.right = buildTree(queue);
        return root;
    }
}
