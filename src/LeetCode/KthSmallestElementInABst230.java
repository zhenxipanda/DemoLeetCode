package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * LeetCode 230
 * 题意：
 * 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
 * 说明：
 * 你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
 * 示例 1:
 * 输入: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * 输出: 1
 * 示例 2:
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *   /
 *  1
 * 输出: 3
 * 进阶：
 * 如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化 kthSmallest 函数？
 * 思路：有两个方法，递归和迭代。
 *      递归的效率不高，因为要遍历整棵树，复杂度分析
 *      时间复杂度：O(N)，遍历了整个树。
 *      空间复杂度：O(N)，用了一个数组存储中序序列。
 *      迭代：迭代比递归要好，因为迭代在找到第k个最小元素是可停止
 *      时间复杂度：O(H + k)，其中 H指的是树的高度，由于我们开始遍历之前，要先向下达到叶，平衡树时：复杂度为 O(logN+k)。
 *      当不平衡树时：复杂度为 O(N+k)，此时所有的节点都在左子树。
 *      空间复杂度：O(H + k)。当平衡树时：O(logN+k)。当非平衡树时：O(N+k)。
 *      100% , 8.70%
 */
public class KthSmallestElementInABst230 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode l1 = new TreeNode(1);
        TreeNode r1 = new TreeNode(4);
        TreeNode l12 = new TreeNode(2);
        root.left = l1;
        root.right = r1;
        l1.right = l12;
        int k = 1;
        int res = kthSmallest(root , k);
        int ans = kthSmallest1(root , k);
        System.out.println(res);
        System.out.println(ans);
    }
    public  static int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        dfs(root , list , k);
        return list.get(k - 1);
    }
    public static void dfs(TreeNode root , List<Integer> list , int k){
        if(root == null){
            return ;
        }
        dfs(root.left , list , k);
        list.add(root.val);
        if(list.size() == k){
            return ;
        }
        dfs(root.right , list , k);
        return ;
    }
    public static int kthSmallest1(TreeNode root, int k) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        while(true){
            while(root != null){
                stack.offer(root);
                root = root.left;
            }
            root = stack.removeLast();
            if(--k == 0){
                return root.val;
            }
            root = root.right;
        }
    }

}
