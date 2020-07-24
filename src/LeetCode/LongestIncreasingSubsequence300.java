package LeetCode;

/**
 * LeetCode 300
 * 题意：
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 * 示例:
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * 说明:
 * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 * 你算法的时间复杂度应该为 O(n^2) 。
 * 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
 * 思路： O(n log n)的话，就要考虑二分，
 *       维护一个升序数组，遍历int[] nums的时候，将元素升序放入辅助数组，
 *       还是比较难的
 *       89.83% , 14.28%
 */
public class LongestIncreasingSubsequence300 {
    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,112,18};
        int res = lengthOfLIS(nums);
        System.out.println(res);
    }
    public static int lengthOfLIS(int[] nums) {
        // 辅助数组
        int[] count = new int[nums.length];
        int res = 0;
        // 遍历原数组
        for(int num : nums){
            // 二分的左右边界
            int i = 0 , j = res;
            // 二分的循环条件
            while(i < j){
                // 二分位置，中间位置
                int mid = (i + j) >> 1;
                if(count[mid] < num){
                    i = mid + 1;
                }
                else{
                    j = mid;
                }
            }
            // 位置i即为num 的正确位置
            count[i] = num;
            if(j == res){
                res ++;
            }
        }
        return res;
    }
}
