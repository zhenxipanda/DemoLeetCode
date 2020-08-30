package JianZhiOffer;

/**
 * 剑指offer 18-2
 * 题意：给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 * 示例 1:
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * 示例 2:
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 * 思路：与leetcode 82 同
 *      两个指针，slow ,fast，slow记录值不同的元素，fast负责遍历，
 *      每次将fast 与 fast.next 比较
 *      93.74% ， 28.13%
 */
public class interview18_2 {
    public static void main(String[] args) {

    }
    public static ListNode deleteDuplicates(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = head;
        while(fast != null){
            if((fast.next != null && (fast.val != fast.next.val) )|| fast.next == null){
                if(slow.next == fast){
                    slow = fast;
                }
                else{
                    slow.next = fast.next;
                }
            }
            fast = fast.next;
        }
        return dummy.next;
    }
}
