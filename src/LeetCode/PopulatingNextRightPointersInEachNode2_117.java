package LeetCode;

/**
 * LeetCode 117
 * 题意：给定一个二叉树
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。
 * 如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 * 初始状态下，所有 next 指针都被设置为 NULL。
 * 进阶：
 * 你只能使用常量级额外空间。
 * 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
 * 提示：
 * 树中的节点数小于 6000
 * -100 <= node.val <= 100
 * 思路：不再是一棵完全二叉树了，所以每一行都要有空节点作为链表头，
 *      并且对每一个cur都要判断左右子树是否为空，
 *      100% , 35.88%
 */
public class PopulatingNextRightPointersInEachNode2_117 {
    public static void main(String[] args) {

    }
    public static Node connect(Node root){
        if(root == null){
            return root;
        }
        Node cur = root;
        while (cur != null){
            Node dummy = new Node();
            Node tail = dummy;
            while (cur != null){
                if(cur.left != null){
                    tail.next = cur.left;
                    tail = tail.next;
                }
                if(cur.right != null){
                    tail.next = cur.right;
                    tail = tail.next;
                }
                cur = cur.next;
            }
            cur = dummy.next;
        }
        return root;
    }
}
