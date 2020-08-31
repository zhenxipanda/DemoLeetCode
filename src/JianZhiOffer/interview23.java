package JianZhiOffer;

/**
 * 剑指offer 23
 * 题意：一个链表中包含环，请找出该链表的环的入口结点。要求不能使用额外的空间。
 * 思路：与leetcode 142 同
 *      快慢指针，因为初始fast = head.next.next，所以除了先判断链表==null || head.next == null,
 *      还有判断head.next.next == null,return false;
 *      否则fast == null ，不可能有fast.next 了
 *      100% , 23.56%s
 */
public class interview23 {
    public static void main(String[] args) {

    }
    public static ListNode EntryNodeOfLoop(ListNode pHead){
        if(pHead == null || pHead.next == null || pHead.next.next == null){
            return null;
        }
        ListNode slow = pHead.next , fast = pHead.next.next;
        while(slow != fast){
            if(fast.next == null || fast.next.next == null){
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = pHead;
        while (slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
