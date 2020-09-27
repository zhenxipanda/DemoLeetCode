package LeetCode;

/**
 * LeetCode 136
 * 题意：给定一个非空整数数组，除了某个元素只出现一次以外，
 * 其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 说明：
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * 示例 1:
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 * 输入: [4,1,2,1,2]
 * 输出: 4
 * 思路：将数组中的元素做异或，最终得到的就是出现一次的元素
 *      99.70% , 18.32%
 */
public class SingleNumber136 {
    public static void main(String[] args) {
        int[] nums = {4,1,4};
        int res = singleNumber(nums);
        System.out.println(res);
    }
    public static int singleNumber(int[] nums) {
        int res = nums[0];
        for(int i = 1;i < nums.length ; i ++){
            res ^= nums[i];
        }
        return res;
    }
}
