package LeetCode;

/**
 * LeetCode 109
 * 题意：
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 * 示例:
 * 给定的有序链表： [-10, -3, 0, 5, 9],
 * 一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 * 思路：递归，找到中间位置，即为根，如果中间位置mid == head，说明只有一个元素，递归终止
 *      左子树递归head，右子树递归mid.next
 *      66.07% , 51.15%
 */
public class ConvertSortedListToBinarySearchTree109 {
    public static void main(String[] args) {

    }
    public static TreeNode sortedListToBST(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode mid = findMin(head);
        TreeNode root = new TreeNode(mid.val);
        if(head == mid){
            return root;
        }
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(mid.next);
        return root;
    }
    public static ListNode findMin(ListNode head){
        ListNode pre = null , slow = head , fast = head;
        while(fast != null && fast.next != null){
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if(pre != null){
            pre.next = null;
        }
        return slow;
    }
}
