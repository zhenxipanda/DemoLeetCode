package JianZhiOffer;

/**
 * 剑指offer 24
 * 题意：定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 * 示例:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 限制：
 * 0 <= 节点个数 <= 5000
 * 思路：与 leetcode 206同
 *      遍历并插入
 *      100% , 36.46%
 */
public class interview24 {
    public static void main(String[] args) {

    }
    public static ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode(-1);
        ListNode node = dummy;
        while(head != null){
            ListNode next = head.next;
            head.next = node.next;
            node.next = head;
            head = next;
        }
        return dummy.next;
    }
}
