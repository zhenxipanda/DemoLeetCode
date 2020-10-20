package JianZhiOffer;

/**
 * 剑指offer 35
 * 题意：请实现 copyRandomList 函数，复制一个复杂链表。
 * 在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，
 * 还有一个 random 指针指向链表中的任意节点或者 null。
 * 提示：
 * -10000 <= Node.val <= 10000
 * Node.random 为空（null）或指向链表中的节点。
 * 节点数目不超过 1000 。
 * 思路：与 LeetCode 138 相同
 *      复制节点，连random,连next
 *      100% , 99.84%
 */
public class interview35 {
    public static void main(String[] args) {

    }
    public static RNode copyRandomList(RNode head) {
        copyNode(head);
        connectRandom(head);
        return reConnect(head);
    }
    public static void copyNode(RNode head){
        if(head == null){
            return ;
        }
        RNode node = head;
        while(node != null){
            RNode p = new RNode(node.val);
            //	p.val = node.val;
            p.next = node.next;
            node.next = p;
            node = p.next;
        }
    }
    public static void connectRandom(RNode head){
        if(head == null){
            return ;
        }
        while(head != null){
            RNode p = head.next;
            if(head.random != null){
                p.random = head.random.next;
            }
            head = p.next;
        }
    }
    public static RNode reConnect(RNode head){
        RNode first = null;
        RNode node = null;
        if(head != null){
            first = head.next;
            node = first;
            head.next = node.next;
            head = node.next;
        }
        while(head != null){
            node.next = head.next;
            node = node.next;
            head.next = node.next;
            head = head.next;
        }
        return first;

    }
}
class RNode {
    int val;
    RNode next;
    RNode random;

    public RNode(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
