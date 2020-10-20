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
    public static Node copyRandomList(Node head) {
        copyNode(head);
        connectRandom(head);
        return reConnect(head);
    }
    public static void copyNode(Node head){
        if(head == null){
            return ;
        }
        Node node = head;
        while(node != null){
            Node p = new Node(node.val);
            //	p.val = node.val;
            p.next = node.next;
            node.next = p;
            node = p.next;
        }
    }
    public static void connectRandom(Node head){
        if(head == null){
            return ;
        }
        while(head != null){
            Node p = head.next;
            if(head.random != null){
                p.random = head.random.next;
            }
            head = p.next;
        }
    }
    public static Node reConnect(Node head){
        Node first = null;
        Node node = null;
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
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
