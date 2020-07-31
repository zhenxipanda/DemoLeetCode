package LeetCode;

import java.util.Arrays;

/**
 * LeetCode 338
 * 题意:
 * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，
 * 计算其二进制数中的 1 的数目并将它们作为数组返回。
 * 示例 1:
 * 输入: 2
 * 输出: [0,1,1]
 * 示例 2:
 * 输入: 5
 * 输出: [0,1,1,2,1,2]
 * 进阶:
 * 给出时间复杂度为O(n*sizeof(integer))的解答非常容易。但你可以在线性时间O(n)内用一趟扫描做到吗？
 * 要求算法的空间复杂度为O(n)。
 * 你能进一步完善解法吗？要求在C++或任何其他语言中不使用任何内置函数（如 C++ 中的 __builtin_popcount）来执行此操作。
 * 思路：题目中要求返回数组，
 *      就要对每个元素都判断，可以考虑动态规划，
 *      转移方程是，如果 i 是2的倍数，那么dp[i] = do[i/2]，dp[3]=2,dp[6]=2
 *      如果不是2的倍数，那么就是dp[i] = dp[i-1] + 1 ,dp[2] = 1,dp[3] =2
 *      75.63% , 84.67%
 */
public class CountingBits338 {
    public static void main(String[] args) {
        int n = 6;
        int[] res = countBits(n);
        System.out.println(Arrays.toString(res));
    }
    public static int[] countBits(int num) {
        if(num == 0){
            return new int[1];
        }
        int[] nums = new int[num + 1];
        nums[0] = 0;
        nums[1] = 1;
        for(int i = 2;i <= num ; i ++){
            if((i & 1 ) == 0){
                nums[i] = nums[i / 2];
            }
            else{
                nums[i] = nums[i - 1] + 1;
            }
        }
        return nums;
    }
}
