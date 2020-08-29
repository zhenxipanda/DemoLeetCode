package JianZhiOffer;

/**
 * 剑指offer 18
 * 题意：给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 * 返回删除后的链表的头节点。
 * 注意：此题对比原题有改动
 * 示例 1:
 * 输入: head = [4,5,1,9], val = 5
 * 输出: [4,1,9]
 * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 * 示例 2:
 * 输入: head = [4,5,1,9], val = 1
 * 输出: [4,5,9]
 * 解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
 * 说明：
 * 题目保证链表中节点的值互不相同
 * 若使用 C 或 C++ 语言，你不需要 free 或 delete 被删除的节点
 * 思路：找到待删除元素的前一个head，head.next = node.next;node.next = null
 *      100% , 65.96%
 */
public class interview18 {
    public static void main(String[] args) {

    }
    public static ListNode deleteNode(ListNode head, int val){
        if(head.val == val){
            head = head.next;
            return head;
        }
        ListNode dummy = head;
        ListNode node = head.next;
        while(node != null){
            if(node.val == val){
                head.next = node.next;
                node.next = null;
                break;
            }
            head = head.next;
            node = node.next;
        }
        return dummy;
    }
}