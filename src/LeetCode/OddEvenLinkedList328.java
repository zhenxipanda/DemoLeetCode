package LeetCode;

/**
 * LeetCode 328
 * 题意：
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。
 * 请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 * 示例 1:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 1->3->5->2->4->NULL
 * 示例 2:
 * 输入: 2->1->3->5->6->4->7->NULL
 * 输出: 2->3->6->7->1->5->4->NULL
 * 说明:
 * 应当保持奇数节点和偶数节点的相对顺序。
 * 链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推。
 * 思路：遍历链表，同时操作两个下标，
 *      需要额外注意，取一个节点的下个节点时，要判断该节点是否为 null
 *      奇数个节点的链表 与 偶数个节点的链表 有差异
 *      100% , 8.70%
 */
public class OddEvenLinkedList328 {
    public static void main(String[] args) {
         ListNode head = new ListNode(1);
         ListNode l1 = new ListNode(2);
         ListNode l2 = new ListNode(3);
         ListNode l3 = new ListNode(4);
         head.next = l1;
         l1.next = l2;
         l2.next = l3;
         ListNode res = oddEvenList(head);
         while(res != null){
             System.out.println(res.val);
             res = res.next;
         }
    }
    public static ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode odd = head;
        ListNode newHead = head.next;
        ListNode even = newHead;
        while(even != null && even.next != null){
            odd.next = even.next;
            even.next = odd.next.next;
            odd = odd.next;
            even = even.next;
        }
        odd.next = newHead;
        return head;
    }
}
