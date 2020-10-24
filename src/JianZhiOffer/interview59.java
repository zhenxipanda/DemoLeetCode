package JianZhiOffer;
/**
 * 剑指offer 59
 * 题意：给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 * 示例:
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
 * 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。
 * 思路：与 LeetCode 239 相同
 *      if(i - k + 1 >= 0) 将队首元素存入数组，并且判断是否将在窗口外，移除
 *      45.40% , 50.28%
 */

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class interview59 {
    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] res = maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(res));
    }
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return new int[0];
        }
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        for(int i = 0;i < nums.length; i ++){
            while(!deque.isEmpty() && deque.peekLast() < nums[i]){
                deque.pollLast();
            }
            deque.offer(nums[i]);
            if(i - k + 1 >= 0){     // >= 0 , not > 0
                res[i - k + 1] = deque.peekFirst();
                if(nums[i - k + 1] == deque.peekFirst()){
                    deque.removeFirst();
                }
            }
        }
        return res;
    }
}
