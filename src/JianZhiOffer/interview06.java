package JianZhiOffer;

import LeetCode.ListNode;

/**
 * 剑指offer 06
 * 题意：输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * 示例 1：
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 * 限制：
 * 0 <= 链表长度 <= 10000
 * 思路：链表反转
 *      100% , 33.61%
 */
public class interview06 {
    public static void main(String[] args) {

    }
    public static int[] reversePrint(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode node = dummy;
        int count = 0;
        while(head != null){
            ListNode next = head.next;
            head.next = node.next;
            node.next = head;
            head = next;
            count ++ ;
        }
        int[] res = new int[count];
        int k = 0;
        node = dummy.next;
        while(node != null){
            res[k ++] = node.val;
            node = node.next;
        }
        return res;
    }
}
