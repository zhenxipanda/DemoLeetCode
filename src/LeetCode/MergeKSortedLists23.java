package LeetCode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * LeetCode 23
 * 题意：给你一个链表数组，每个链表都已经按升序排列。
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * 示例 1：
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 * 示例 2：
 * 输入：lists = []
 * 输出：[]
 * 示例 3：
 * 输入：lists = [[]]
 * 输出：[]
 * 提示：
 * k == lists.length
 * 0 <= k <= 10^4
 * 0 <= lists[i].length <= 500
 * -10^4 <= lists[i][j] <= 10^4
 * lists[i] 按 升序 排列
 * lists[i].length 的总和不超过 10^4
 * 思路：两种方法，归并排序 + 最小堆
 *      归并排序因为是对链表操作，所以属于原地排序，
 *      最小堆开辟了堆空间，
 *      还是归并排序技高一筹
 *
 */
public class MergeKSortedLists23 {
    public static void main(String[] args) {

    }
//    方法一：递归+归并，原地排序 94.73% , 5.00%
    public static ListNode mergeKLists(ListNode[] lists){
        if(lists == null || lists.length == 0){
            return null;
        }
        return merge(lists , 0 , lists.length - 1);
    }

    private static ListNode merge(ListNode[] lists, int left, int right) {
        if(left == right){
            return lists[left];
        }
        int mid = (left + right) >> 1;
        ListNode l1 = merge(lists , left , mid);
        ListNode l2 = merge(lists , mid + 1 , right);
        return mergeSort(l1 , l2);
    }

    private static ListNode mergeSort(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        if(l1.val < l2.val){
            l1.next = mergeSort(l1.next , l2);
            return l1;
        }
        else{
            l2.next = mergeSort(l1 , l2.next);
            return l2;
        }
    }
//  方法二，优先级队列 66.81% , 31.51%
    public static ListNode mergeKLists1(ListNode[] lists){
         if(lists == null || lists.length == 0){
             return null;
         }
        PriorityQueue<ListNode> heap = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
         for(ListNode li : lists){
             if(li != null){
                 heap.add(li);
             }
         }
         ListNode dummy = new ListNode(-1);
         ListNode node = dummy;
         while(!heap.isEmpty()){
             node.next = heap.poll();
             node = node.next;
             if(node.next != null){
                 heap.add(node.next);
             }
         }
         return dummy.next;
    }
}
