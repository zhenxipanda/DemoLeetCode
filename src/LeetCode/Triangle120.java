package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode 120
 * 题意：
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 * 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 * 例如，给定三角形：
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 * 说明：
 * 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 * 思路：动态规划，从底向上遍历triangle，
 *      dp[i]表示从下向上过程中，第i个位置取得的最小和，
 *      dp[j] = li.get(j) + Math.min(dp[j] , dp[j + 1])
 *      96.02% , 8.70%
 */
public class Triangle120 {
    public static void main(String[] args) {
       List<List<Integer>> triangle = new ArrayList<>();
       List<Integer> r1 = Arrays.asList(2);   // r1 = new ArrayList<>(2),size也是0
       List<Integer> r2 = Arrays.asList(3, 4);
       List<Integer> r3 = Arrays.asList(6,5,7);
       List<Integer> r4 = Arrays.asList(4,1,8,3);
       triangle.add(0 , r1);
       triangle.add(1, r2);
       triangle.add(2 , r3);
       triangle.add(3 , r4);
       int res = minimumTotal(triangle);
       System.out.println(res);
    }
    public static int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        int[] dp = new int[size + 1];
        for(int i = triangle.size() - 1; i >= 0;i --){
            List<Integer> li = triangle.get(i);
         //   System.out.println(li);
            for(int j = 0;j < li.size() ; j ++){
                dp[j] = li.get(j) + Math.min(dp[j] , dp[j + 1]);
            }
        }
        return dp[0];
    }
}
