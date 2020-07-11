package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 315
 * 题意：
 * 给定一个整数数组 nums，按要求返回一个新数组 counts。数组 counts 有该性质： counts[i] 的值是  nums[i] 右侧小于 nums[i] 的元素的数量。
 * 示例:
 * 输入: [5,2,6,1]
 * 输出: [2,1,1,0]
 * 解释:
 * 5 的右侧有 2 个更小的元素 (2 和 1).
 * 2 的右侧仅有 1 个更小的元素 (1).
 * 6 的右侧有 1 个更小的元素 (1).
 * 1 的右侧有 0 个更小的元素.
 * 思路：这题也太难了吧，
 *      归并排序，在归并排序中，统计当前比较范围内，右侧比自己小的元素个数
 *      70.69% , 16.67%
 *      遇到这么难的题，还是背下来吧
 */
public class CountOfSmallerNumbersAfterSelf315 {
    public static void main(String[] args) {
        int[] nums = {5,2,6,1};
        List<Integer> res = countSmaller(nums);
        System.out.println(res);
    }
    private static int[] index; //按照降序，记录当前范围内数组元素下标
    private static int[] helper; //按照降序，辅助记录当前范围内元素下标
    private static int[] count;  //count[i]表示在当前范围内，右侧比自己小的有几个

    public static List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>(nums.length);
        //完成数组初始化
        index = new int[nums.length];
        helper = new int[nums.length];
        count = new int[nums.length];
        //index数组赋初始值
        for (int i = 0; i < index.length; i++) {
            index[i] = i;
        }

        merge(nums, 0, nums.length - 1);

        for (int i = 0; i < count.length; i++) {
            res.add(i, count[i]);
        }
        return res;
    }

    private static void merge(int[] nums, int s, int e) {
        if (s == e || s > e) return;
        int mid = (s + e) >> 1;

        if (s < mid) {
            merge(nums, s, mid);
        }

        if (mid + 1 < e) {
            merge(nums, mid + 1, e);
        }
        int i = s, j = mid + 1;
        int hi = s;
        while (i <= mid && j <= e) {
            if (nums[index[i]] <= nums[index[j]]) {
                // 降序排序，所以右侧先出
                helper[hi++] = index[j++];
            } else {
                // 降序排序，左侧大，左侧先出，并且计数
                count[index[i]] += e - j + 1;
                helper[hi++] = index[i++];
            }
        }

        while (i <= mid) {
            //左侧还有元素，左侧继续出
            helper[hi++] = index[i++];
        }

        while (j <= e) {
            // 右侧还有元素，右侧继续出
            helper[hi++] = index[j++];
        }

        for (int k = s; k <= e; k++) {
            // 更新当前范围内，降序排序的元素下标
            index[k] = helper[k];
        }
    }
}
