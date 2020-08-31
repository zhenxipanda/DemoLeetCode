package JianZhiOffer;

/**
 * 剑指offer 22
 * 题意：输入一个链表，输出该链表中倒数第k个节点。
 * 为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 * 例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。
 * 这个链表的倒数第3个节点是值为4的节点。
 * 示例：
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 * 返回链表 4->5.
 * 思路：不是删除，是找到并返回倒数第k个节点及之后的元素，
 *      仍然先走k步，然后与头节点同时后移
 *      100% , 6.38%
 */
public class interview22 {
    public static void main(String[] args) {

    }
    public static ListNode getKthFromEnd(ListNode head, int k) {
        if(head == null || k == 0){
            return null;
        }
        ListNode slow = head;
        while(k != 0){
            if(slow == null){
                return null;
            }
            slow = slow.next;
            k --;
        }
        ListNode fast = head;
        while(slow != null){
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }
}
