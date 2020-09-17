package LeetCode;

/**
 * LeetCode 83
 * 题意：给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * 示例 1:
 * 输入: 1->1->2
 * 输出: 1->2
 * 示例 2:
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 * 思路：两个指针，slow , fast ,保留重复的元素，所以不用辅助节点，
 *      特别注意：slow.next = null
 *      73.99% , 48.58%
 */
public class RemoveDuplicatesFromSortedList83 {
    public static void main(String[] args) {

    }
    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null){
            if(slow.val != fast.val){
                slow.next = fast;
                slow = slow.next;
            }
            fast = fast.next;
        }
        slow.next = null ;
        return head;
    }
}
