package LeetCode;

/**
 * LeetCode 287
 * 题意：
 * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），
 * 可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
 * 示例 1:
 * 输入: [1,3,4,2,2]
 * 输出: 2
 * 示例 2:
 * 输入: [3,1,3,4,2]
 * 输出: 3
 * 说明：
 * 不能更改原数组（假设数组是只读的）。
 * 只能使用额外的 O(1) 的空间。
 * 时间复杂度小于 O(n2) 。
 * 数组中只有一个重复的数字，但它可能不止重复出现一次。
 * 思路：不能更改数组，也就不能把元素放到其对应位置上，
 *      只能使用O(1)的空间，不能开辟一个新数组，
 *      那只能另行别的办法，
 *      如果按照f=nums[x]来看，会发现是一套有环的链表，
 *      相当于找链表的入口是哪个节点，
 *      设置快慢指针，两者相遇后，快指针移到头，两者同时走一步，
 *      直到相遇，即为环的入口，也就是重复元素
 *      100% , 6.67%
 */
public class FindTheDuplicateNumber287 {
    public static void main(String[] args) {
        int[] nums = {3,1,3,4,2};
        int res = findDuplicate(nums);
        System.out.println(res);
    }
    public static int findDuplicate(int[] nums) {
        // 慢指针，先从0走一步
        int slow = nums[0];
        // 快指针，先从0走两步
        int fast = nums[nums[0]];
        // 快慢指针，等待相遇
        while(slow != fast){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        // 相遇之后，快指针移到头
        fast = 0;
        // 再同时都走一步，直到相遇
        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
