package LeetCode;

/**
 * LeetCode 160
 * 题意：编写一个程序，找到两个单链表相交的起始节点
 * 如果两个链表没有交点，返回 null.
 * 在返回结果后，两个链表仍须保持原有的结构。
 * 可假定整个链表结构中没有循环。
 * 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
 * 思路：1. 因为两个链表的长度不确定，所以不可避免需要遍历两个链表，统计长度
 *      2. 为了找到相交的节点，需要两个指针指向的链表长度相等，同时移动，才能同时到达相交点
 *      3. 为了长度相等，需要较长的链表先走 diff步，diff即为两个链表长度差值
 *      99.97% , 78.57%
 */
public class IntersectionOfTwoLinkedList160 {
    public static void main(String[] args) {
        ListNode headA = new ListNode(4);
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(6);
        ListNode headB = new ListNode(5);
        headA.next = l1;
        l1.next = l2;
        headB.next = l2;
        ListNode res = getIntersectionNode(headA , headB);
        System.out.println(res.val);
    }
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        int counta = 0 , countb = 0;
        ListNode nodea = headA , nodeb = headB;
        while(nodea != null){
            counta ++;
            nodea = nodea.next ;
        }
        while(nodeb != null){
            countb ++;
            nodeb = nodeb.next ;
        }
        ListNode head = counta > countb ? headA : headB ;  // is headA , not nodea
        int diff = Math.abs(counta - countb);
        while(diff != 0){
            head = head.next ;
            diff --;
        }
        nodea = counta > countb ? head : headA;
        nodeb = counta > countb ? headB : head;
        while(nodea != nodeb){
            nodea = nodea.next ;
            nodeb = nodeb.next ;
        }
        return nodea;
    }
}
