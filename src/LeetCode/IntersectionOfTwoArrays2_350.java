package LeetCode;
/**
 * LeetCode 350
 * 题意：给定两个数组，编写一个函数来计算它们的交集。
 * 示例 1：
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 * 示例 2:
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[4,9]
 * 说明：
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
 * 我们可以不考虑输出结果的顺序。
 * 进阶：
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 * 思路：与349的区别在于最终的数组中可以存在重复元素，所以使用List,不再使用set
 *      99.56% , 99.43%
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionOfTwoArrays2_350 {
    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        int[] res = intersect(nums1, nums2);
        System.out.println(Arrays.toString(res));
    }
    public static int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> res = new ArrayList<>();
        for(int i = 0,j = 0;i < nums1.length && j < nums2.length;){
            if(nums1[i] == nums2[j]){
                res.add(nums1[i]);
                i ++;
                j ++;
            }
            else if(nums1[i] < nums2[j]){
                i ++;
            }
            else{
                j ++;
            }

        }
        int[] ans = new int[res.size()];
        for(int i = 0;i < res.size(); i ++){
            ans[i] = res.get(i);
        }
        return ans;
    }
}
