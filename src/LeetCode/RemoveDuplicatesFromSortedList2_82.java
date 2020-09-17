package LeetCode;

/**
 * LeetCode 82
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 * 示例 1:
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * 示例 2:
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 * 思路：小米面试的手撕代码
 *      关键是使用slow , fast两个指针
 *      93.29% , 51.61%
 */
public class RemoveDuplicatesFromSortedList2_82 {
    public static void main(String[] args) {

    }
    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;  // 这句别忘了
        ListNode slow = dummy;
        ListNode fast = head;
        while(fast != null){
            if((fast.next != null && (fast.val != fast.next.val) )|| fast.next == null){
                if(slow.next == fast){
                    slow = fast;
                }
                else{
                    slow.next = fast.next;
                }
            }
            fast = fast.next;
        }
        return dummy.next;
    }
}
