package LeetCode;

/**
 * LeetCode 24
 * 题意：给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 示例:
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 * 思路：两个一组进行翻转，然后头向后移动两步
 *      100% , 80.78%
 */
public class SwapNodesInPairs24 {
    public static void main(String[] args) {

    }
    public static ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode(-1);
        ListNode node = dummy;
        int count = 1;
        while(head != null){
            ListNode next = head.next;
            head.next = node.next;
            node.next = head;
            count ++ ;
            head = next;
            if(count % 2 == 1){
                node = node.next.next;
            }
        }
        return dummy.next;
    }
}
