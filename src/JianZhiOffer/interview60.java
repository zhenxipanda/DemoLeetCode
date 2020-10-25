package JianZhiOffer;
/**
 * 剑指offer 60
 * 题意：把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。
 * 输入n，打印出s的所有可能的值出现的概率。
 * 你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。
 * 示例 1:
 * 输入: 1
 * 输出: [0.16667,0.16667,0.16667,0.16667,0.16667,0.16667]
 * 示例 2:
 * 输入: 2
 * 输出: [0.02778,0.05556,0.08333,0.11111,0.13889,0.16667,0.13889,0.11111,0.08333,0.05556,0.02778]
 * 限制：
 * 1 <= n <= 11
 * 思路：用动态规划统计n个骰子出现的点数和，最小n,最大6*n,
 *      dp[i][s]含义：i个骰子，和为s的情况数，
 *      i的取值为2-n，s的取值为i-6*i,
 *      dp[i][s] += dp[i-1][s-d],d的取值为1-6，前提s-d>=i-1，因为i-1个骰子和的最小值为i-1
 *      然后用dp[n][i]/pow(6,n)即为概率，i的取值为n-6*n
 *      100% , 18.51%
 */

import java.util.Arrays;

public class interview60 {
    public static void main(String[] args) {
        int n = 2;
        double[] res = twoSum(n);
        System.out.println(Arrays.toString(res));
    }
    public static double[] twoSum(int n){
        int[][] dp = new int[n+1][6*n+1];
        for(int i = 1; i <= 6; i ++){
            dp[1][i] = 1;
        }
        for(int i = 2; i <= n ; i ++){   // i <= n ,not i <= 6
            for(int s = i ; s <= 6 * i ; s ++){
                for(int d = 1 ; d <= 6 ; d ++){
                    if(s - d < i - 1){
                        break;
                    }
                    dp[i][s] += dp[i - 1][s - d];
                }
            }
        }
        double sum = Math.pow(6 , n);
        double[] res = new double[5 * n + 1];
        for(int i = n ; i <= 6 * n ; i ++){
            res[i - n] = dp[n][i] * 1.0 / sum;
        }
        return res;
    }
}
