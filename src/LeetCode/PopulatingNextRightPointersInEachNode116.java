package LeetCode;

/**
 * LeetCode 116
 * 题意：给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。
 * 如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 * 初始状态下，所有 next 指针都被设置为 NULL。
 * 提示：
 * 你只能使用常量级额外空间。
 * 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
 * 思路：start代表每一行第一个节点，cur代表遍历这一行的节点，
 *      以cur的视角操作其左右孩子，当start.left == null 时，循环结束
 *      100% , 28.04%
 */
public class PopulatingNextRightPointersInEachNode116 {
    public static void main(String[] args) {

    }
    public static Node connect(Node root) {
        if(root == null || (root.left == null && root.right == null)){
            return root;
        }
        Node start = root , cur = root;
        while (start.left != null){
            while (cur != null){
                cur.left.next = cur.right;
                if(cur.next != null){
                    cur.right.next = cur.next.left;
                }
                cur = cur.next;
            }
            start = start.left;
            cur = start;
        }
        return root;
    }
}
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
