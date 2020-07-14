package LeetCode;

/**
 * LeetCode 268
 * 题意：
 * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
 * 示例 1:
 * 输入: [3,0,1]
 * 输出: 2
 * 示例 2:
 * 输入: [9,6,4,2,3,5,7,0,1]
 * 输出: 8
 * 说明:
 * 你的算法应具有线性时间复杂度。你能否仅使用额外常数空间来实现?
 * 思路：比较简单的一道题，题目中明确说使用常数空间，
 *      所以不能额外开辟数组，换个思路，因为是连续的n个数，可以计算不缺失数字的总和，
 *      减去缺失数字后的数组总和，即为缺失元素
 *      100% , 6.67%
 */
public class MissingNumber268 {
    public static void main(String[] args) {
        int[] nums = {0,2,3,1};
        int res = missingNumber(nums);
        System.out.println(res);
    }
    public static int missingNumber(int[] nums) {
        int n = nums.length;
        int ans = 0, sum = 0;
        for(int i = 0;i < n; i ++){
            ans += i;
            sum += nums[i];
        }
        ans += n;
        return ans - sum;
    }
}
