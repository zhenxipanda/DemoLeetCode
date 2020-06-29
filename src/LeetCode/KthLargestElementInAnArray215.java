package LeetCode;

import java.util.PriorityQueue;

/**
 * LeetCode 215
 * 题意：在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * 示例 1:
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * 说明:
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 * 思路：虽然也可以将数组进行排序，根据下标直接找到第k大的元素，但是排序的时间复杂度是O(NlgN)
 *      我们会想，有没有更好的方法呢，比如扫描一遍数组就能得到完成任务？
 *      那扫描一遍，用什么数据结构来存储数据呢？
 *      答案是堆，这里用的是最小堆，最小堆是完全二叉树的形状结构，
 *      特点是父节点的值小于左右子节点的值，那么堆顶就是最小的元素
 *      可以通过设定堆得大小来得到第K大的元素，
 *      当然也可以每遍历到一个元素，就入堆，堆大小>k，再删除堆顶
 *      也可以只有当堆得尺度<k || 堆顶元素 < 数组元素时，才入堆。
 *      时间复杂度O(N),空间复杂度O(K)
 *      64.07% ， 6.12%
 */
public class KthLargestElementInAnArray215 {
    public static void main(String[] args) {
        int[] nums = {3,2,3,1,2,4,5,5,6};
        int k = 4;
        int res = findKthLargest(nums , k);
        System.out.println(res);
    }
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int i = 0;i < nums.length; i ++){
            if(i < k || heap.peek() < nums[i]){
                heap.offer(nums[i]);
            }
            if(heap.size() > k){
                heap.poll();
            }
        }
        return heap.peek();
    }
}
