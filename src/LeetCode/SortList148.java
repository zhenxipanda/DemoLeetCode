package LeetCode;

/**
 * LeetCode 148
 * 题意：在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 * 示例 1:
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2:
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 * 思路：递归排序，先找中间，再合并
 *      27.34% , 5.02%
 */
public class SortList148 {
    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(3);
        ListNode l3 = new ListNode(2);
        head.next = l1;
        l1.next = l2;
        l2.next = l3;
        ListNode res = sortList(head);
        while (res != null){
            System.out.println(res.val);
            res = res.next;
        }
    }
    public static ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode mid = findMid(head);
        ListNode pHead = mid.next;
        mid.next = null;
        return mergeSort(sortList(head) , sortList(pHead));
    }

    private static ListNode mergeSort(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        if(l1.val < l2.val){
            l1.next = mergeSort(l1.next , l2);
            return l1;
        }
        else{
            l2.next = mergeSort(l1 , l2.next);
            return l2;
        }
    }

    public static ListNode findMid(ListNode head){
        ListNode slow = head , fast = head;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

}
