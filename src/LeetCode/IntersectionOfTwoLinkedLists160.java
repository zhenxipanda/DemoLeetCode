package LeetCode;

/**
 * LeetCode 160
 * 题意：编写一个程序，找到两个单链表相交的起始节点。
 * 输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 * 输出：Reference of the node with value = 2
 * 输入解释：相交节点的值为 2 （注意，如果两个链表相交则不能为 0）。
 * 从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4]。
 * 在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
 * 注意：
 * 如果两个链表没有交点，返回 null.
 * 在返回结果后，两个链表仍须保持原有的结构。
 * 可假定整个链表结构中没有循环。
 * 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
 * 思路：先各自遍历，统计长度，长的先走diff步，
 *      使用三目运算符搞清楚就可以，
 *      99.99% , 15.93%
 */
public class IntersectionOfTwoLinkedLists160 {
    public static void main(String[] args) {

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
        ListNode head = counta > countb ? headA : headB ;
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
