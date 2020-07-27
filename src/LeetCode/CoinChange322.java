package LeetCode;

import java.util.*;

/**
 * LeetCode 322
 * 题意：
 * 给定不同面额的硬币 coins 和一个总金额 amount。
 * 编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
 * 如果没有任何一种硬币组合能组成总金额，返回 -1。
 * 示例 1:
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * 示例 2:
 * 输入: coins = [2], amount = 3
 * 输出: -1
 * 说明:
 * 你可以认为每种硬币的数量是无限的。
 * 思路：如果纯粹用贪心，对于测试用例[186,419,83,408],6249不能通过
 *      因为此时如果按照贪心尽量用大面值硬币，没有最优解，即amount != 0
 *      所以递归的思路是 for循环控制 大面值硬币数量 --, 如果有na == 0 ，说明此时能正好兑换，
 *      因为是从大面值硬币开始处理，所以此时应该是最优解。
 *      99.60% , 5.77%
 *
 *      动态规划：
 *      开辟amount +1的额外数组空间，
 *      不可避免双层循环，所以先循环coins ,再循环 ，i = coin , i<= amount
 *      这样比先循环 i = 1;i <= amount ; 再循环coins，循环次数少很多
 *      93.61% , 5.77%
 */
public class CoinChange322 {
    public static void main(String[] args) {
        int[] coins = {186,419,83,408};
        int amount = 6249;
        int res = coinChange(coins , amount);
        System.out.println(res);
    }
    // 递归 ，不用额外数组空间
    static int ans=Integer.MAX_VALUE;
    public static int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        dfs(coins,coins.length-1,amount,0);
        return ans==Integer.MAX_VALUE?-1:ans;
    }
    public static void dfs(int[] coins,int index,int amount,int cnt){
        if(index<0){
            return;
        }
        for(int c=amount/coins[index];c>=0;c--){
            int na=amount-c*coins[index];
            int ncnt=cnt+c;
            // 因为是从大数开始扫描处理，所以如果 na == 0,一定是最优解了
            if(na==0){
                ans=Math.min(ans,ncnt);
                break;//剪枝1 或者 return 也行
            }
            // 如果 na != 0 ，那么肯定还需要一枚硬币，所以是 ncnt + 1 ,若 >= ans，则一定不是最优解
            if(ncnt+1>=ans){
                break; //剪枝2 或者 return 也行
            }
            dfs(coins,index-1,na,ncnt);
        }
    }
    // 动态规划 ,需要amount+1长度的额外空间
    public static int coinChange_dy(int[] coins , int amount){
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for(int i = 1;i <= amount ; i ++){
            dp[i] = 0x3f3f3f; // Integer.MAX_VALUE
        }
        for(int coin : coins){
            for(int i = coin ; i <= amount ; i ++){
                dp[i] = Math.min(dp[i] , dp[i - coin] + 1);
            }
        }
        return dp[amount] == 0x3f3f3f ? -1 : dp[amount];
    }
}
