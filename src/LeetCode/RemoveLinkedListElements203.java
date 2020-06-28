package LeetCode;

/**
 * LeetCode 203
 * 题意：
 * 删除链表中等于给定值 val 的所有节点。
 * 示例:
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 * 思路：比较简单，思想：遍历链表，找到链表节点值不为val，
 *      进行连接，连接的过程，需要记录一个dummy，防止链表头被移除，
 *      99.85% , 6.25%
 */
public class RemoveLinkedListElements203 {
    public static void main(String[] args) {
        ListNode head = new ListNode(6);
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(3);
        ListNode l3 = new ListNode(6);
        head.next = l1;
        l1.next = l2;
        l2.next = l3;
        int val = 6;
        ListNode res = removeElements(head , val);
        while(res != null){
            System.out.println(res.val);
            res = res.next;
        }
    }
    public static ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        ListNode newHead = dummy;
        while(head != null){
            while(head != null && head.val == val){
                head = head.next ;
            }
            dummy.next = head;
            dummy = head;
            if(head != null){
                head = head.next;
            }
        }
        return newHead.next;
    }
}
