package LeetCode;

/**
 * LeetCode 142
 * 题意：给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。
 * 说明：不允许修改给定的链表。
 * 示例 1：
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：tail connects to node index 1
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 * 示例 2：
 * 输入：head = [1,2], pos = 0
 * 输出：tail connects to node index 0
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 * 示例 3：
 * 输入：head = [1], pos = -1
 * 输出：no cycle
 * 解释：链表中没有环。
 * 思路：快慢指针，两者都指向head，所以循环条件为true，如果fast == null || fast.next == null ，无环，
 *      移动快慢指针，当两者相遇时，将快指针移到head，各走一步，再相遇即为环入口。
 *      100% , 51.12%
 */
public class LinkedListCycle2_142 {
    public static void main(String[] args) {

    }
    public static ListNode detectCycle(ListNode pHead){
        ListNode slow = pHead , fast = pHead;
        while (true){
            if(fast == null || fast.next == null){
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                break;
            }
        }
        fast = pHead;
        while (slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
