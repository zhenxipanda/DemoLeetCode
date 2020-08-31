package LeetCode;

/**
 * LeetCode 19
 * 题意：
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * 示例：
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 * 给定的 n 保证是有效的。
 * 进阶：
 * 你能尝试使用一趟扫描实现吗？
 * 思路：先走n步，如果链表长度为n，删除的是第一个节点，
 *      否则，同步走，找到待删除节点的前一个节点，越过它
 *      100% , 89.57%
 */
public class RemoveNthNodeFromEndOfList19 {
    public static void main(String[] args) {

    }
    public static ListNode removeNthFromEnd(ListNode head, int n){
        if(head == null){
            return head;
        }
        ListNode behind = head;
        while(n != 0){
            behind = behind.next;
            n -- ;
        }
        if(behind == null){
            ListNode newHead = head.next;
            head.next = null;
            return newHead;
        }
        ListNode remove = head;
        while (behind.next != null){
            remove = remove.next;
            behind = behind.next;
        }
        ListNode node = remove.next;
        remove.next = node.next;
        node.next = null;
        return head;
    }
}
