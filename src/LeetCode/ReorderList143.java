package LeetCode;

/**
 * LeetCode 143
 * 题意：给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 示例 1:
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 * 示例 2:
 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 * 思路：三步走：找到中间节点，分为两部分；
 *      翻转后半部分；
 *      将两部分进行合并
 *      79.32% , 59.66%
 */
public class ReorderList143 {
    public static void main(String[] args) {

    }
    public static void reorderList(ListNode head) {
        if(head == null){
            return ;
        }
        ListNode mid = findMid(head);
        ListNode restart = mid.next ;
        mid.next = null;
        ListNode another = reverse(restart);
        merge(head , another);
    }
    public static ListNode findMid(ListNode head){
        ListNode slow = head ;
        ListNode fast = head ;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next ;
            fast = fast.next.next ;
        }
        return slow ;
    }
    public static ListNode reverse(ListNode restart){
        ListNode dummy = new ListNode(-1);
        ListNode node = restart ;
        while(node != null){
            ListNode next = node.next ;
            node.next = dummy.next ;
            dummy.next = node ;
            node = next ;
        }
        return dummy.next;
    }
    public static void merge(ListNode head , ListNode another){
        ListNode l1 = head;
        while(l1 != null  && another != null){
            ListNode n1 = l1.next ;
            ListNode n2 = another.next ;
            another.next = l1.next ;
            l1.next = another ;
            l1 = n1 ;
            another = n2;
        }
    }
}
