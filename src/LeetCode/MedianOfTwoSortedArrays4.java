package LeetCode;

/**
 * LeetCode 4
 * 题意：
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
 * 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * 示例 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 * 则中位数是 2.0
 * 示例 2:
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * 则中位数是 (2 + 3)/2 = 2.5
 * 思路：递归+二分，将两个数组看做一个有序数组，寻找整个数组中的中位数
 *      需要注意一些特殊条件，如边界问题，k==1问题
 *      100% , 52.96%
 */
public class MedianOfTwoSortedArrays4 {
    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {-1, 3};
        double res = findMedianSortedArrays(nums1, nums2);
        System.out.println(res);
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int len = m + n;
        if ((len & 1) == 1) {
            return (double) dfs(nums1, 0, nums2, 0, len / 2 + 1);
        }
        return (dfs(nums1, 0, nums2, 0, len / 2) + dfs(nums1, 0, nums2, 0, len / 2 + 1)) / 2.0;
    }

    public static int dfs(int[] nums1, int s1, int[] nums2, int s2, int k) {
        if (s1 >= nums1.length) {
            return nums2[s2 + k - 1];
        }
        if (s2 >= nums2.length) {
            return nums1[s1 + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[s1], nums2[s2]);
        }
        int halfA = s1 + k / 2 - 1 >= nums1.length ? Integer.MAX_VALUE : nums1[s1 + k / 2 - 1];
        int halfB = s2 + k / 2 - 1 >= nums2.length ? Integer.MAX_VALUE : nums2[s2 + k / 2 - 1];
        if (halfA < halfB) {
            return dfs(nums1, s1 + k / 2, nums2, s2, k - k / 2);
        }
        return dfs(nums1, s1, nums2, s2 + k / 2, k - k / 2);
    }
}
