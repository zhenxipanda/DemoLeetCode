package LeetCode;
/**
 * LeetCode 88
 * 题意：给你两个有序整数数组 nums1 和 nums2，
 * 请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 * 说明:
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * 示例:
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * 输出: [1,2,2,3,5,6]
 * 思路：可以 && 也可以 ||
 *      分三种情况考虑，如果nums1先结束，要考虑nums2，如果nums2先结束，不用考虑nums1
 *      100% , 5.26%
 */
import java.util.Arrays;

public class MergeSortedArray88 {
    public static void main(String[] args) {
        int[] nums1 = {3,4,5,0,0,0};
        int[] nums2 = {1,2,6};
        merge(nums1 , 3 , nums2 , 3);
        System.out.println(Arrays.toString(nums1));
    }
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while(i >= 0 || j >= 0){
            if(i >= 0 && j >= 0){
                nums1[k] = (nums1[i] > nums2[j] ? nums1[i --] : nums2[j --]);
                k --;
            }
            else if(i >= 0){
                nums1[k] = nums1[i];
                break;
            }
            else{
                nums1[k --] = nums2[j --];
            }
        }
    }
}
