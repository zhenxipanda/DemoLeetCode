package LeetCode;

/**
 * LeetCode 416
 * 题意：
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * 注意:
 * 每个数组中的元素不会超过 100
 * 数组的大小不会超过 200
 * 示例 1:
 * 输入: [1, 5, 11, 5]
 * 输出: true
 * 解释: 数组可以分割成 [1, 5, 5] 和 [11].
 * 示例 2:
 * 输入: [1, 2, 3, 5]
 * 输出: false
 * 解释: 数组不能分割成两个元素和相等的子集.
 * 思路：
 *      背包问题，能想到的是，计算数组和，寻找数组中哪些元素能构成和的一半，
 *      如果和是奇数，肯定不存在，
 *      偶数的话，动态规划，不用排序，降序计算是否可达
 *      动态规划的含义是，每个元素使用一次，能否有元素构成这个和
 *      不太好像，因为构成和一半的元素可能不只一个或两个，而是多个
 *      89.50% , 90.95%
 */
public class PartitionEqualSubsetSum416 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        boolean res = canPartition(nums);
        System.out.println(res);
    }
    public static boolean canPartition(int[] nums) {
        int n = nums.length;
        if(n == 0){
            return false;
        }
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        if((sum & 1) == 1){
            return false;
        }
        int target = sum >> 1;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        if(nums[0] <= target){   //必须加上条件判断，避免[100]
            dp[nums[0]] = true;
        }
        for(int i = 1;i < n; i ++){
            for(int j = target ; j >= nums[i] ; j --){
                if(dp[target]){
                    return true;
                }
                dp[j] = dp[j] || dp[j - nums[i]];
            }
        }
        return dp[target];
    }
}
