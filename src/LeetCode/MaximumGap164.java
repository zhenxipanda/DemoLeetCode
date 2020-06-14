package LeetCode;

/**
 * LeetCode 164
 * 题意：给定一个无序的数组，找出数组在排序之后，相邻元素之间最大的差值。
 * 如果数组元素个数小于 2，则返回 0。
 * 输入: [3,6,9,1]
 * 输出: 3
 * 解释: 排序后的数组是 [1,3,6,9], 其中相邻元素 (3,6) 和 (6,9) 之间都存在最大差值 3。
 * 输入: [10]
 * 输出: 0
 * 解释: 数组元素个数小于 2，因此返回 0。
 * 说明:
 * 你可以假设数组中所有元素都是非负整数，且数值在 32 位有符号整数范围内。
 * 请尝试在线性时间复杂度和空间复杂度的条件下解决此问题。
 * 思路：要求是线性时间复杂度，所以一般的排序不行，桶排序的时间复杂度是O(K+N),
 *      https://leetcode-cn.com/problems/maximum-gap/solution/mei-xiang-dao-wo-men-zhi-jian-de-zui-da-jian-ju-ji/
 *      这个讲得很清晰，桶排序要确定的就是桶的个数和桶存放数据的区间长度buckSize
 *      遍历桶，需要记录桶内的最大差值，还要记录桶间的最大差值
 *      45.99% , 14.29%
 */
public class MaximumGap164 {
    public static void main(String[] args) {
        int[] nums = {2,999};
        int res = maximumGap(nums);
        System.out.println(res);
    }
    public static int maximumGap(int[] nums) {
        if(nums == null || nums.length < 2){
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int num : nums){
            max = Math.max(max , num);
            min = Math.min(min , num);
        }
        int buckSize = Math.max(1 , (max - min) / (nums.length - 1));  //防止数组中的元素全相等，所以至少桶的长度为1
        Bucket[] buck = new Bucket[(max - min) / buckSize + 1];
        for(int i = 0 ; i < nums.length ; i ++){
            int loc = (nums[i] - min) / buckSize ;
            if(buck[loc] == null){
                buck[loc] = new Bucket();
            }
            buck[loc].min = Math.min(buck[loc].min , nums[i]);
            buck[loc].max = Math.max(buck[loc].max , nums[i]);
        }
        int previousMax = Integer.MAX_VALUE ;
        int maxGap = Integer.MIN_VALUE ;
        for(int i = 0 ;i < buck.length ; i ++){
            if(buck[i] != null && previousMax != Integer.MAX_VALUE){
                maxGap = Math.max(maxGap , buck[i].min - previousMax);
            }
            if(buck[i] != null){
                previousMax = buck[i].max;
                maxGap = Math.max(maxGap , buck[i].max - buck[i].min);
            }
        }
        return maxGap;
    }
    static class Bucket{
        int max = Integer.MIN_VALUE ;
        int min = Integer.MAX_VALUE ;
    }
}
