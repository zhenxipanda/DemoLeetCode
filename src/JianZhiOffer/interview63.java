package JianZhiOffer;

/**
 * 剑指offer 63
 * 题意：假设把某股票的价格按照时间先后顺序存储在数组中，
 * 请问买卖该股票一次可能获得的最大利润是多少？
 * 示例 1:
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 * 示例 2:
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 * 限制：
 * 0 <= 数组长度 <= 10^5
 * 思路：与 LeetCode 121 相同
 *      遍历过程中记录最小值 min , 记录res = Math.max(res , n[i] - min)
 *      98.93% , 99.92%
 */
public class interview63 {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        int res = maxProfit(prices);
        System.out.println(res);
    }
    public static int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0){
            return 0;
        }
        int min = prices[0];
        int res = 0;
        for(int i = 1;i < prices.length; i ++){
            if(min > prices[i]){
                min = prices[i];
            }
            res = Math.max(res, prices[i] - min);
        }
        return res;
    }
}
