package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * LeetCode 173
 * 题意：
 * 实现一个二叉搜索树迭代器。你将使用二叉搜索树的根节点初始化迭代器。
 * 调用 next() 将返回二叉搜索树中的下一个最小的数。
 * 提示：
 * next() 和 hasNext() 操作的时间复杂度是 O(1)，并使用 O(h) 内存，其中 h 是树的高度。
 * 你可以假设 next() 调用总是有效的，也就是说，当调用 next() 时，BST 中至少存在一个下一个最小的数。
 * 思路：可以看到调用next()返回的数据顺序是树的中序遍历，中序遍历可以使用递归，迭代，数据结构可以是队列、栈
 *      这里提供了两种方法
 *      1. 迭代，栈    74.09% , 100%  在next()方法中中序遍历，取到一个值，就break;
 *      2. 递归，队列  95.50% , 100%  在构造函数中定义中序遍历函数
 */
public class BinarySearchTreeIterator173 {
    public static void main(String[] args) {

    }
    static List<Integer> list ;
    static int index ;
    public BinarySearchTreeIterator173(TreeNode root){
        list = new ArrayList<>();
        index = -1;
        inorder(root);
    }
    public  static void inorder(TreeNode root){
        if(root == null){
            return ;
        }
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }
    public static  int next(){
        return list.get(++ index);
    }
    public static boolean hasNext(){
        return index + 1 < list.size();
    }
    /**  迭代、栈
    static Stack<TreeNode> stack = new Stack<>();
    static TreeNode cur = null ;
    public BinarySearchTreeIterator173(TreeNode root) {
        cur = root ;
    }
    public static int next() {
        int res = -1;
        while(cur != null || !stack.isEmpty()){
            while(cur != null){
                stack.push(cur);
                cur = cur.left ;
            }
            cur = stack.pop();
            res = cur.val ;
            cur = cur.right ;
            break;
        }
        return res ;
    }

    public static boolean hasNext() {
        return cur != null || !stack.isEmpty();
    }
    */
}
