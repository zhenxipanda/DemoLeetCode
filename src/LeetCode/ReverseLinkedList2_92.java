package LeetCode;

/**
 * LeetCode 92
 * 题意：反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 * 示例:
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 * 思路：遍历链表的同时计数，如果在反转范围内，pre不动，且count == n 时，pre一次性移动n-m+1次
 *      不在反转范围内，pre每次后移
 *      100% , 58.78%
 */
public class ReverseLinkedList2_92 {
    public static void main(String[] args) {

    }
    public static ListNode reverseBetween(ListNode head, int m, int n){
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        int count = 1;
        while (head != null){
            ListNode next = head.next;
            head.next = pre.next;
            pre.next = head;
            if(! (count >= m && count <= n)){
                pre = pre.next;
            }
            else{
                if(count == n){
                    int offset = n - m + 1;
                    while (offset != 0){
                        pre = pre.next;
                        offset --;
                    }
                }
            }
            count ++ ;
            head = next;
        }
        return dummy.next;
    }
}
