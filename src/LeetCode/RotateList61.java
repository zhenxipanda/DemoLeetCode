package LeetCode;

/**
 * LeetCode 61
 * 题意：
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 * 示例 1:
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 * 示例 2:
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 * 思路：先遍历链表统计节点个数，首尾相连形成环
 *      向右移动k步，也就是倒数第k个节点是新头节点，
 *      那么倒数第k+1个节点.next = null
 *      所以从头开始走n - k % n - 1步，走到的节点为新尾，其下一个为新头
 *      1005 ， 33.05%
 */
public class RotateList61 {
    public static void main(String[] args) {

    }
    public static ListNode rotateRight(ListNode head, int k){
        if(head == null || head.next == null){
            return head;
        }
        int count = 1;
        ListNode node = head;
        while (node.next != null){
            node = node.next;
            count ++ ;
        }
        node.next = head;
        ListNode fast = head;
        int m = count - k % count - 1;
        while (m != 0){
            fast = fast.next;
            m -- ;
        }
        ListNode newHead = fast.next;
        fast.next = null ;
        return newHead;
    }
}
