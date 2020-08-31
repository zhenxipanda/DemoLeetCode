package JianZhiOffer;

import java.util.Arrays;

/**
 * 剑指offer 21
 * 题意：输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 * 示例：
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 * 提示：
 * 1 <= nums.length <= 50000
 * 1 <= nums[i] <= 10000
 * 思路：没有要求元素的相对顺序不变，可以左右遍历，遇到符合条件的交换，
 *      99.72% , 91.52%
 */
public class interview21 {
    public static void main(String[] args) {
        int[] nums = {3, 1, 4, 2, 5};
        int[] res = exchange(nums);
        System.out.println(Arrays.toString(res));
    }

    public static int[] exchange(int[] nums) {
        int start = 0, end = nums.length - 1;
        while (start < end) {
            while (start < end && ((nums[start] & 1) == 1)) {
                start++;
            }
            while (start < end && ((nums[end] & 1) == 0)) {
                end--;
            }

            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;

        }
        return nums;
    }
}
