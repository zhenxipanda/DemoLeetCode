package LeetCode;

/**
 * LeetCode 654
 * 题意：
 * 给定一个不含重复元素的整数数组。一个以此数组构建的最大二叉树定义如下：
 * 二叉树的根是数组中的最大元素。
 * 左子树是通过数组中最大值左边部分构造出的最大二叉树。
 * 右子树是通过数组中最大值右边部分构造出的最大二叉树。
 * 通过给定的数组构建最大二叉树，并且输出这个树的根节点。
 * 示例 ：
 * 输入：[3,2,1,6,0,5]
 * 输出：返回下面这棵树的根节点：
 *       6
 *     /   \
 *    3     5
 *     \    /
 *      2  0
 *        \
 *         1
 *  思路：递归，在[0,nums.length - 1]范围内寻找最大值nums[index]，最大值位置为根，
 *        根据下标index可以把数组分为两部分，
 *        左子树的递归范围[0,index - 1],右子树的递归范围[index + 1 ,nums.length - 1]
 *        22.66% , 97.35%
 */
public class MaximumBinaryTree654 {
    public static void main(String[] args) {
        int[] nums = {3,2,1,6,0,5};
        TreeNode res = constructMaximumBinaryTree(nums);
        System.out.println(res.val);
    }
    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums == null || nums.length == 0){
            return null;
        }
        return dfs(nums , 0 , nums.length - 1);
    }
    public static TreeNode dfs(int[] nums , int start , int end){
        if(start > end){
            return null;
        }
        int index = find(nums , start , end);
        TreeNode root = new TreeNode(nums[index]);
        root.left = dfs(nums , start , index - 1);
        root.right = dfs(nums , index + 1 , end);
        return root;
    }
    public static int find(int[] nums , int s , int e){
        int res = 0 , max = Integer.MIN_VALUE;
        for(int i = s ; i <= e ; i ++){
            if(nums[i] > max){
                res = i;
                max = nums[i];
            }
        }
        return res;
    }
}
