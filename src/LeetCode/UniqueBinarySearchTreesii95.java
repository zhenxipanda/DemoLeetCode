package LeetCode;

import java.util.LinkedList;
import java.util.List;

/**
 * LeetCode 95
 * 题意：
 * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的 二叉搜索树 。
 * 示例：
 * 输入：3
 * 输出：
 * [
 *   [1,null,3,2],
 *   [3,2,null,1],
 *   [3,1,null,null,2],
 *   [2,1,3],
 *   [1,null,2,null,3]
 * ]
 * 解释：
 * 以上的输出对应以下 5 种不同结构的二叉搜索树：
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 * 提示：
 * 0 <= n <= 8
 * 思路：
 *      二叉搜索树的个数是卡特兰数，
 *      可以分别算出以i为根的左子树有几种情况，右子树有几种情况，
 *      然后二维遍历，但需要注意的是，根的创建也要在内层循环，
 *      否则，会因为根的地址不变，导致后来的结果，覆盖了新结果
 *      35.80% , 14.29%
 */
public class UniqueBinarySearchTreesii95 {
    public static void main(String[] args) {
        int n = 3;
        List<TreeNode> res = generateTrees(n);
        System.out.println(res);
    }

    public static List<TreeNode> generateTrees(int n) {
        if(n == 0){
            return new LinkedList<TreeNode>();
        }
        return gene(1 , n);
    }
    public static List<TreeNode> gene(int start , int end){
        List<TreeNode> list = new LinkedList<>();
        if(start > end){
            list.add(null);
            return list;
        }
        for(int i = start ; i <= end ; i ++){
            List<TreeNode> left = gene(start , i - 1);
            List<TreeNode> right = gene(i + 1 , end);
            for(TreeNode l1 : left){
                for(TreeNode r1 : right){
                    TreeNode root = new TreeNode(i);  // must be in the inner
                    root.left = l1;
                    root.right = r1;
                    list.add(root);
                }
            }
        }
        return list;
    }
}
