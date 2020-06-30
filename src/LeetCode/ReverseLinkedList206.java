package LeetCode;

/**
 * LeetCode 206
 * 题意：
 * 反转一个单链表。
 * 示例:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 * 思路：迭代比较简单，遍历链表，将每个节点放到dummy后面，
 *      注意：dummy不后移
 *      100% , 5.06%
 */
public class ReverseLinkedList206 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(3);
        ListNode l3 = new ListNode(4);
        head.next = l1;
        l1.next = l2;
        l2.next = l3;
        ListNode res = reverseList(head);
        while(res != null){
            System.out.println(res.val);
            res = res.next;
        }
    }
    public static ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head ;
        }
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy ;
        while(head != null){
            ListNode next = head.next ;
            head.next = pre.next;
            pre.next = head ;
            head = next ;
        }
        return dummy.next ;
    }
}
