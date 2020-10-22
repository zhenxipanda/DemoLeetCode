package JianZhiOffer;

/**
 * 剑指offer 52
 * 题意：输入两个链表，找出它们的第一个公共节点。
 * 注意：
 * 如果两个链表没有交点，返回 null.
 * 在返回结果后，两个链表仍须保持原有的结构。
 * 可假定整个链表结构中没有循环。
 * 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
 * 思路：与 LeetCode 160 相同
 *      100% , 97.68%
 */
public class interview52 {
    public static void main(String[] args) {

    }
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        ListNode nodea = headA;
        ListNode nodeb = headB;
        int counta = 0 , countb = 0;
        while(nodea != null){
            counta ++;
            nodea = nodea.next;
        }
        while(nodeb != null){
            countb ++;
            nodeb = nodeb.next;
        }
        int diff = Math.abs(counta - countb);
        ListNode head = counta > countb ? headA : headB;
        while(diff != 0){
            head = head.next;
            diff --;
        }
        nodea = (counta > countb)?head :headA;
        nodeb = (counta > countb)?headB : head;
        while(nodea != null && nodeb != null){
            if(nodea == nodeb){
                return nodea;
            }
            nodea = nodea.next;
            nodeb = nodeb.next;
        }
        return null;
    }
}
