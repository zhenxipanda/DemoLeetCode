package LeetCode;

/**
 * LeetCode 138
 * 题意：给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
 * 要求返回这个链表的 深拷贝。 
 * 我们用一个由 n 个节点组成的链表来表示输入/输出中的链表。每个节点用一个 [val, random_index] 表示：
 * val：一个表示 Node.val 的整数。
 * random_index：随机指针指向的节点索引（范围从 0 到 n-1）；如果不指向任何节点，则为  null 。
 * 思路：先复制节点，再连接random指针，再连接next指针
 *      100% , 23.29%
 */
public class CopyListWithRandomPointer138 {
    public static void main(String[] args) {

    }
    public RandomNode copyRandomList(RandomNode head) {
        if(head == null){
            return null;
        }
        copyNode(head);
        connectRandom(head);
        return reconnectNext(head);
    }
    public void copyNode(RandomNode head){
        RandomNode pre = head;
        while(pre != null){
            RandomNode next = pre.next;
            RandomNode node = new RandomNode(pre.val);
            node.next = pre.next;
            pre.next = node;
            pre = next;
        }
    }
    public void connectRandom(RandomNode head){
        RandomNode pre = head;
        while(pre != null){
            RandomNode node = pre.next;
            if(pre.random != null){
                node.random = pre.random.next;
            }
            pre = node.next;
        }
    }
    public RandomNode reconnectNext(RandomNode head){
        RandomNode first = head.next;
        RandomNode pre = head.next;
        while(head != null){
            head.next = pre.next;
            head = head.next;
            if(head != null){
                pre.next = head.next;
            }
            pre = pre.next;
        }
        return first;
    }
}
class RandomNode {
    int val;
    RandomNode next;
    RandomNode random;

    public RandomNode(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
