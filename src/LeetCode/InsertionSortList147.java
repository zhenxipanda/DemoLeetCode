package LeetCode;

/**
 * LeetCode 147
 * 题意：对链表进行插入排序。
 * 插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。
 * 每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。
 * 插入排序算法：
 * 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
 * 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
 * 重复直到所有输入数据插入完为止。
 * 示例 1：
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2：
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 * 思路：通过设定dummy ,每次都从dummy开始向后寻找到正确的插入位置，
 *      比较不好理的就是链表之间的连接，
 *      98.96% , 12.13%
 */
public class InsertionSortList147 {
    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(3);
        head.next = l1;
        l1.next = l2;
        l2.next = l3;
        ListNode res = insertionSortList(head);
        while (res != null){
            System.out.println(res.val);
            res = res.next;
        }
    }
    public static ListNode insertionSortList(ListNode head){
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode pre = dummy , tail = dummy;
        ListNode cur = head;
        while (cur != null){
            if(tail.val < cur.val){
                tail.next = cur;
                tail = cur;
                cur = cur.next;
            }
            else{
                ListNode tmp = cur.next;
                while (pre.next != null && pre.next.val < cur.val){
                    pre = pre.next;
                }
                tail.next = tmp;
                cur.next = pre.next;
                pre.next = cur;
                pre = dummy;
                cur = tmp;
            }
        }
        return dummy.next;
    }
}
