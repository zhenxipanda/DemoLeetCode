package LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 560
 * 题意：
 * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 * 示例 1 :
 * 输入:nums = [1,1,1], k = 2
 * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
 * 说明 :
 * 数组的长度为 [1, 20,000]。
 * 数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。
 * 思路：数组无序，且可能有负数，还有可能数组中的单个元素的值就等于k的，
 *      能想到暴力解法，就是两层循环，即便满足了sum == k，也要继续向后找，因为可能有抵消的元素
 *      非暴力解法，前缀和+哈希，，计算前缀和-k在map中是否存在，存在的话，加到计数器中
 *      不太好想，是sum - k ，不是 k - sum
 *      78.93% , 81.77%
 */
public class SubarraySumEqualsK560 {
    public static void main(String[] args) {
        int[] nums = {1,1,-1,1,1};
        int k = 1;
        int res = subarraySum(nums , k);
        System.out.println(res);
    }
    public static int subarraySum(int[] nums, int k) {
        Map<Integer , Integer> map = new HashMap<>();
        int sum = 0;
        int count = 0;
        map.put(0 , 1);
        for(int num : nums){
            sum += num;
            if(map.containsKey(sum - k)){
                count += map.get(sum - k);
            }
            map.put(sum , map.getOrDefault(sum , 0) + 1);
        }
        return count ;
    }
}
