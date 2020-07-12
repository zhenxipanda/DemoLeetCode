package LeetCode;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * LeetCode 239
 * 题意：
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
 * 你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * 返回滑动窗口中的最大值。
 * 进阶：
 * 你能在线性时间复杂度内解决此题吗？
 * 示例:
 *
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 *   滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 * 提示：
 * 1 <= nums.length <= 10^5
 * -10^4 <= nums[i] <= 10^4
 * 1 <= k <= nums.length
 * 思路：利用双端队列，LinkedList，
 *      遍历数组，当扫描到的元素比队列尾部的元素大时，将前面小于它的删除，找到它的合适位置，
 *      因为当出现大数时，最大值肯定是大数，前面的小数没有存在的必要，
 *      当滑动窗口要移走时，将马上要失效的元素从队列头部删除
 *      77.82% , 6.67%
 */
public class SlidingWindowMaximum239 {
    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] res = maxSlidingWindow(nums , k);
        System.out.println(Arrays.toString(res));
    }
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        LinkedList<Integer> list = new LinkedList<>();
        for(int i = 0;i < n; i ++){
            add(list , nums[i]);
            if(i - k + 1 >= 0){
                res[i - k + 1] = list.peekFirst();
                // 马上就要失效的元素，从队列头部删除
                if(nums[i - k + 1] == list.peekFirst()){
                    list.removeFirst();
                }
            }
        }
        return res;
    }
    public static void add(LinkedList<Integer> list , int x){
        // 当队列不空，且队列尾部元素小于 当前元素 时，删除，直到找到它合适的位置
        while(list.size() > 0 && list.peekLast() < x){
            list.removeLast();
        }
        // 将其放入队列
        list.offer(x);
    }
}
