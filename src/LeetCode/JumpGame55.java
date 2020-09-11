package LeetCode;

/**
 * LeetCode 55
 * 题意：给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个位置。
 * 示例 1:
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
 * 示例 2:
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 * 思路：思路一，从后向前判断，更新能到达的最右端
 *      思路二，从前向后遍历，判断能到达的最远边界
 *      99.97% , 44.75%
 */
public class JumpGame55 {
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(canJump(nums));
        System.out.println(canJump1(nums));
    }
//    思路一
    public static boolean canJump(int[] nums) {
        int end = nums.length - 1;
        for(int i = nums.length - 2;i >= 0; i --){
            if(nums[i] >= end - i){
                end = i;
            }
        }
        return end == 0;

    }
//    思路二
    public static boolean canJump1(int[] nums){
         int maxPosition = 0;
         for(int i = 0;i < nums.length; i ++){
             if(i > maxPosition){
                 return false;
             }
             maxPosition = Math.max(maxPosition , nums[i] + i);
         }
         return true;
    }
}
