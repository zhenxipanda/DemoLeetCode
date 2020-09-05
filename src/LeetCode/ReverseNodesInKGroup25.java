package LeetCode;

/**
 * LeetCode 25
 * 题意：给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * 示例：
 * 给你这个链表：1->2->3->4->5
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 * 说明
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 * 思路：k个一组，关键在于数出k个来，且这k个节点都有值，不为空，
 *      end指向k个一组的最后一个元素，若end == null，即不够k个，break
 *      pre指向k个一组的第一个节点的前一个节点，即上个组的最后一个节点，
 *      start = pre.next，即为当前组的第一个节点，
 *      next = end.next，为下一组的第一个节点，
 *      end = null ,当前组与后面断掉，
 *      pre.next = reverse(start) 翻转当前组，
 *      start.next = next，翻转后当前组的尾与下一组头连接，
 *      pre = start , end = pre
 *      100% , 21.04%
 */
public class ReverseNodesInKGroup25 {
    public static void main(String[] args) {

    }
    public static ListNode reverseKGroup(ListNode head, int k){
        if(head == null || head.next == null || k == 1){
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy , end = dummy;
        while (end.next != null){
            for(int i = 0; i < k && end != null; i ++){
                end = end.next;
            }
            if(end == null){
                break;
            }
            ListNode next = end.next;
            end.next = null;
            ListNode start = pre.next;
            pre.next = reverse(start);
            start.next = next;
            pre = start;
            end = pre;
        }
        return dummy.next;
    }

    private static ListNode reverse(ListNode start) {
        ListNode dummy = new ListNode(-1);
        ListNode node = dummy;
        while(start != null){
            ListNode next = start.next;
            start.next = node.next;
            node.next = start;
            start = next;
        }
        return dummy.next;
    }
}
