package LeetCode;
/**
 * LeetCode 105
 * 题意：根据一棵树的前序遍历与中序遍历构造二叉树。
 * 注意:
 * 你可以假设树中没有重复的元素。
 * 例如，给出
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 思路：递归，关键将中序遍历的元素与下标对应关系存到map中，
 *      然后对数组进行递归，
 *      97.90% , 49.10%
 */

import java.util.*;
public class ConstructBinaryTreeFromPreorderAndInorderTraversal105 {
    public static void main(String[] args) {

    }
    private static Map<Integer , Integer> map = new HashMap<>();
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length != inorder.length){
            return null;
        }
        for(int i = 0;i < inorder.length; i ++){
            map.put(inorder[i] , i);
        }
        return myBuild(preorder , 0 , preorder.length - 1 , inorder , 0 , inorder.length - 1);
    }
    public static TreeNode myBuild(int[] preorder , int preStart , int preEnd , int[] inorder , int inStart , int inEnd){
        if(preStart > preEnd){
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int index = map.get(preorder[preStart]);
        root.left = myBuild(preorder , preStart + 1 , preStart + index - inStart , inorder , inStart , index - 1);
        root.right = myBuild(preorder , preStart + index - inStart + 1 , preEnd , inorder , index + 1 , inEnd);
        return root;
    }
}
