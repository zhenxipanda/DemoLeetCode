package LeetCode;

/**
 * LeetCode 234
 * 题意：
 * 请判断一个链表是否为回文链表。
 * 示例 1:
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 * 思路：比较经典的一道题，涉及了很多链表的常规操作，
 *      直接考虑进阶，O(n)时间复杂和O(1)空间复杂度，
 *      也就是说不能使用额外的O(n)数组空间存储，
 *      只能对链表做一些原地操作，进行比较。
 *      三步走：
 *      1. 找到链表中间节点，快慢指针
 *      2. 翻转链表后半部分，迭代 或 递归
 *      3. 将链表前半部分 和 2.的结果进行逐节点比较，只要发现val值不同的，就返回false
 *      99.71% , 13.51%
 */
public class PalindromeLinkedList234 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(1);
        head.next = l1;
        l1.next = l2;
        l2.next = l3;
        boolean res = isPalindrome(head);
        System.out.println(res);
    }
    public static boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }
        ListNode mid = findMid(head);
        ListNode newHead = mid.next;
        mid.next = null;
        newHead = reverse(newHead);
        while(head != null && newHead != null){
            if(head.val != newHead.val){
                return false;
            }
            head = head.next;
            newHead = newHead.next;
        }
        return true;
    }
    public static ListNode findMid(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public static ListNode reverse(ListNode head){
        ListNode dummy = new ListNode(-1);
        while(head != null){
            ListNode next = head.next;
            head.next = dummy.next;
            dummy.next = head;
            head = next;
        }
        return dummy.next;
    }
}
