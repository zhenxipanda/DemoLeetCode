package LeetCode;

import java.util.Arrays;

/**
 * LeetCode 238
 * 题意：
 * 给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，
 * 其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 * 示例:
 * 输入: [1,2,3,4]
 * 输出: [24,12,8,6]
 * 提示：题目数据保证数组之中任意元素的全部前缀元素和后缀（甚至是整个数组）的乘积都在 32 位整数范围内。
 * 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 * 进阶：
 * 你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
 * 思路：除了自身以外，其他所有元素的乘积，
 *      那就从左向右扫描一遍，记录除了自己以外，自己的左边元素构成的乘积，
 *      再从右向左扫描一遍，记录除了自己以外，自己的右边元素构成的乘积，两个结果相乘，即为最终乘积
 *      100% , 11.76%
 */
public class ProductOfArrayExceptSelf238 {
    public static void main(String[] args) {
        int[] nums = {4,3,2,5};
        int[] res = productExceptSelf(nums);
        System.out.println(Arrays.toString(res));
    }
    public static int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        ans[0] = 1;
        int tmp = nums[0];
        for(int i = 1;i < nums.length; i ++){
            ans[i] = tmp;
            tmp *= nums[i];
        }
        tmp = nums[nums.length - 1];
        for(int i = nums.length - 2;i >= 0; i --){
            ans[i] *= tmp;
            tmp *= nums[i];
        }
        return ans;
    }
}
