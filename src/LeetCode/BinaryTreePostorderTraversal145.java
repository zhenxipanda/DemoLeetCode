package LeetCode;
/**
 * LeetCode 145
 * 题意：给定一个二叉树，返回它的 后序 遍历。
 * 示例:
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 * 输出: [3,2,1]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * 思路：没有用ArrayList，因为每次都是addFirst(),
 *      还是很巧妙的，每次addFirst()，所以要先遍历右子树，再遍历左子树
 *      58.02% , 23.65%
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreePostorderTraversal145 {
    public static void main(String[] args) {

    }

    //    迭代
    public static List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> output = new LinkedList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()){
            if(root != null){
                stack.offer(root);
                output.addFirst(root.val);
                root = root.right;
            }
            else{
                root = stack.removeLast();
                root = root.left;
            }
        }
        return output;
    }

    //    递归
    public static List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root , res);
        return res;
    }
    private static void dfs(TreeNode root, List<Integer> res) {
        if(root == null){
            return;
        }
        dfs(root.left , res);
        dfs(root.right , res);
        res.add(root.val);
    }
}
