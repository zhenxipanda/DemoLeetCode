package LeetCode;

/**
 * LeetCode 96
 * 题意：
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 * 示例:
 * 输入: 3
 * 输出: 5
 * 解释:
 * 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 * 思路：
 *      二叉搜索树的个数是卡特兰数，
 *      使用动态规划，外层循环表示i个数构成的二叉搜索树，
 *      内层循环选定根为j时，记录二叉搜索树的个数
 *      dp[i] += dp[j - 1] * dp[i - j], j-1构成左子树的节点数，
 *      i - j是构成右子树的节点数
 *      100% , 7.69%
 */
public class UniqueBinarySearchTrees96 {
    public static void main(String[] args) {
        int n = 3;
        int res = numTrees(n);
        System.out.println(res);
    }
    public static int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2;i <= n; i ++){
            for(int j = 1;j <= i ; j ++){   // 分别为 j 做根节点时二叉搜索树的个数
                dp[i] += (dp[j - 1] * dp[i - j]); // dp[j-1]是左子树，dp[i-j]是右子树
            }
        }
        return dp[n];
    }
}
