package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 199
 * 题意：给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1, 3, 4]
 * 解释:
 *    1            <---
 *  /   \
 * 2     3         <---
 *  \     \
 *   5     4       <---
 * 思路：迭代不好实现，所以用递归，
 *      需要探究什么时机向list加入元素，可以借用一个辅助的参数level，记录当前扫描的二叉树层数，
 *      当level == list.size()时，向list.add(root.val);
 *      因为是右侧视角，所以先递归遍历右子树，再递归遍历左子树
 *      95.00% , 5.00%
 */
public class BinaryTreeRightSideView199 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode l1 = new TreeNode(2);
        TreeNode r1 = new TreeNode(3);
        TreeNode l11 = new TreeNode(5);
        TreeNode r11 = new TreeNode(4);
        root.left = l1;
        root.right = r1;
        l1.right = l11;
        r1.right = r11;
        List<Integer> res = rightSideView(root);
        System.out.println(res);
    }
    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        help(res , 0 , root);
        return res;
    }
    public static void help(List<Integer> res , int level , TreeNode root){
        if(root == null){
            return ;
        }
        if(level == res.size()){
            res.add(root.val);
        }
        help(res , level + 1 , root.right);
        help(res , level + 1 , root.left);
    }
}
