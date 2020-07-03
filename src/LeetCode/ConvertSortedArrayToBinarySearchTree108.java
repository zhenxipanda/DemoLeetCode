package LeetCode;

/**
 * LeetCode 108
 * 题意：
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 * 示例:
 * 给定有序数组: [-10,-3,0,5,9],
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 * 思路：使用二分 + 递归的思想，
 *      二分就是传入数组的起始 和 终止， 计算出中间节点，即为 根
 *      根的左子树就是遍历数组的以根分割的左半部分，
 *      根的右子树就是遍历数组的以根分割的右半部分，
 *      递归结束的条件就是起始 > 终止
 *      100% , 8.70%
 */
public class ConvertSortedArrayToBinarySearchTree108 {
    public static void main(String[] args) {
        int[] nums = {-10,-3,0,5,9};
        TreeNode root = sortedArrayToBST(nums);
        System.out.println(root.val);
    }
    public  static TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0){
            return null;
        }
        return dfs(nums , 0 , nums.length - 1);
    }
    public static TreeNode dfs(int[] nums , int left , int right){
        if(left > right){
            return null;
        }
        int mid = (left + right) >> 1;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = dfs(nums , left , mid - 1);
        root.right = dfs(nums , mid + 1 , right);
        return root;
    }
}
