package LeetCode;

/**
 * LeetCode 45
 * 题意：给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * 示例:
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * 说明:
 * 假设你总是可以到达数组的最后一个位置。
 * 思路：遍历数组，记录最远边界，当i == end，更新最远边界，步数 ++
 *      还是不太好想的
 *      93.81% ， 86.26%
 */
public class JumpGame2_45 {
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        int res = jump(nums);
        System.out.println(res);
    }
    public static int jump(int[] nums) {
        int end  = 0;
        int maxPosition = 0;
        int step = 0;
        for(int i = 0;i < nums.length - 1; i ++){
            maxPosition = Math.max(maxPosition , nums[i] + i);
            if(i == end){
                end = maxPosition;
                step ++;
            }
        }
        return step;
    }
}
