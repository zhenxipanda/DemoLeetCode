package LeetCode;

/**
 * LeetCode 86
 * 题意：给定一个链表和一个特定值 x，对链表进行分隔，
 * 使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 * 你应当保留两个分区中每个节点的初始相对位置。
 * 示例:
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 * 思路：遍历链表，以x的值为分水岭，将小于x的元素放到一个链表中，
 *      将>= x 的元素放到另一个链表中，然后相连，
 *      注意：>=x 的链表尾 .next = null ,防止成环
 *      100% ， 21.08%
 */
public class PartitionList86 {
    public static void main(String[] args) {

    }
    public static ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode lessHead = new ListNode(0);
        ListNode less = lessHead;
        ListNode moreHead = new ListNode(0);
        ListNode more = moreHead;
        while(head != null){
            if(head.val < x){
                less.next = head;
                less = less.next;
            }
            else{
                more.next = head;
                more = more.next;
            }
            head = head.next;
        }
        more.next = null;   // must have
        less.next = moreHead.next;
        moreHead.next = null;
        return lessHead.next;
    }
}
