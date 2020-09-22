package LeetCode;
/**
 * LeetCode 106
 * 题意：根据一棵树的中序遍历与后序遍历构造二叉树。
 * 注意:
 * 你可以假设树中没有重复的元素。
 * 例如，给出
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 返回如下的二叉树：
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 思路：仍然将中序遍历的元素与下标对应关系存到map中，
 *      加上inS == inE 的判断，可以减少递归的次数，提高时间效率。
 *      97.33% ， 51.09%
 */

import java.util.*;
public class ConstructBinaryTreeFromInorderAndPostorderTraversal106 {
    public static void main(String[] args) {

    }
    private static Map<Integer , Integer> map = new HashMap<>();
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length != postorder.length){
            return null;
        }
        for(int i = 0;i < inorder.length; i ++){
            map.put(inorder[i] , i);
        }
        return myBuild(inorder , 0 , inorder.length - 1 , postorder , 0 , postorder.length - 1);
    }
    public static TreeNode myBuild(int[] inorder , int inStart , int inEnd , int[] postorder , int poStart , int poEnd){
        if(inStart > inEnd){
            return null;
        }
        TreeNode root = new TreeNode(postorder[poEnd]);
        if(inStart == inEnd){
            root.left = null;
            root.right = null;
        }
        else{
            int index = map.get(postorder[poEnd]);
            root.left = myBuild(inorder , inStart , index - 1 , postorder , poStart , poStart + index - inStart - 1 );
            root.right = myBuild(inorder , index + 1 , inEnd , postorder , poStart + index - inStart , poEnd - 1);
        }
        return root;
    }
}
