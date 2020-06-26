package LeetCode;

/**
 * 题意：给定两个非空的链表，代表两个非空的整数，数字是按照反序排列的，并且每一个都是单个位的数字
 * 将两个数加和，并作为链表返回。
 * 注意：可以假设没有领先的0，但是数字中可以有0
 * 思路：因为是反序，所以比较简单，循环的条件就是两者有一者不为空就行
 *      每个对应位的两个数字相加，判断和是否超过10，创建余数节点，进位保留
 *      进位参与下一位的运算，最后还要判断一次进位是否存在
 *      100% ， 85.89%
 *      81.53% , 85.58% ,二刷,OK
 */
public class AddTwoNumbers2 {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ListNode l1 = new ListNode(2);
        ListNode l12 = new ListNode(4);
        ListNode l13 = new ListNode(3);
        ListNode l2 = new ListNode(5);
        ListNode l22 = new ListNode(6);
        ListNode l23 = new ListNode(4);
        l1.next = l12;
        l12.next = l13;
        l2.next = l22;
        l22.next = l23;
        ListNode ans = addTwoNumbers(l1,l2);
        while(ans != null){
            System.out.println(ans.val);
            ans = ans.next;
        }
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2){
        if(l1 == null || l2 == null){
            return l1 == null ? l2 : l1;
        }
        ListNode node = new ListNode(-1);
        ListNode head = node;
        int carry = 0,sum = 0;
        while(l1 != null || l2 != null){
            sum = carry;
            if(l1 != null){
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                sum += l2.val;
                l2 = l2.next;
            }
            carry = sum / 10;
            sum = sum % 10;
            node.next = new ListNode(sum);
            node = node.next;
        }
        if(carry != 0){
            node.next = new ListNode(carry);
        }
        return head.next;
    }
}
