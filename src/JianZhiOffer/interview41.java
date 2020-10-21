package JianZhiOffer;
/**
 * 剑指offer 41
 * 题意：如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，
 * 那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * 例如，
 * [2,3,4] 的中位数是 3
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 * 设计一个支持以下两种操作的数据结构：
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 * 示例 1：
 * 输入：
 * ["MedianFinder","addNum","addNum","findMedian","addNum","findMedian"]
 * [[],[1],[2],[],[3],[]]
 * 输出：[null,null,null,1.50000,null,2.00000]
 * 示例 2：
 * 输入：
 * ["MedianFinder","addNum","findMedian","addNum","findMedian"]
 * [[],[2],[],[3],[]]
 * 输出：[null,null,2.00000,null,2.50000]
 * 限制：
 * 最多会对 addNum、findMedian 进行 50000 次调用。
 * 思路：与 LeetCode 295 相同
 *      最大堆的构造方法值得学习，Comparator.reverseOrder()
 *      31.81% , 62.81%
 */

import java.util.Comparator;
import java.util.PriorityQueue;

public class interview41 {
    public static void main(String[] args) {

    }
    private PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>( Comparator.reverseOrder());
    /** initialize your data structure here. */
    public void addNum(int num) {
        maxHeap.offer(num);
        if(!maxHeap.isEmpty() && !minHeap.isEmpty()){
            if(maxHeap.peek() > minHeap.peek()){
                minHeap.offer(maxHeap.poll());
            }
        }
        if(maxHeap.size() > minHeap.size() + 1){
            minHeap.offer(maxHeap.poll());
        }
        if(maxHeap.size() < minHeap.size()){
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        if(maxHeap.size() == minHeap.size()){
            return (double)((maxHeap.peek() + minHeap.peek()) / 2.0);
        }
        return (double)maxHeap.peek();
    }
}
