package LeetCode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * LeetCode 295
 * 题意：
 * 中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
 * 例如，
 * [2,3,4] 的中位数是 3
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 * 设计一个支持以下两种操作的数据结构：
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 * 示例：
 * addNum(1)
 * addNum(2)
 * findMedian() -> 1.5
 * addNum(3)
 * findMedian() -> 2
 * 进阶:
 * 如果数据流中所有整数都在 0 到 100 范围内，你将如何优化你的算法？
 * 如果数据流中 99% 的整数都在 0 到 100 范围内，你将如何优化你的算法？
 * 思路：设置最大堆 和 最小堆，
 *      最小堆里存放的是数值大的那部分元素，
 *      最大堆里存放的是数值小的那部分元素，
 *      这样，就能保证最大堆的堆顶和最小堆的堆顶是数组排序后，中间位置的数
 *      在入堆得过程中，保证最大堆的大小 是 最小堆大小 +1 ，或等于最小堆，
 *      奇数个元素求中间数，就是最大堆的堆顶，
 *      偶数个元素求中间数，就是最大堆 和 最小堆 堆顶的平均值
 *      79.84% , 100.00%
 */
public class FindMedianFromDataStream295 {
    public static void main(String[] args) {

    }

}
class MedianFinder {
    private PriorityQueue<Integer> minHeap ;
    private PriorityQueue<Integer> maxHeap ;
    /** initialize your data structure here. */
    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        // 最大堆，设置倒序比较规则
        maxHeap = new PriorityQueue<>(new Comparator<Integer>(){
            public int compare(Integer a , Integer b){
                return b.compareTo(a);
            }
        });
    }

    public void addNum(int num) {
        // 先向最小堆里加
        minHeap.offer(num);
        // 当最小堆中的元素比最大堆小时，将小的元素弹出，入最大堆，保证最大堆里存放的是数值小的元素，最小堆里是数值大的元素
        if(maxHeap.size() != 0 && minHeap.size() != 0 ){
            if(minHeap.peek() < maxHeap.peek()){
                maxHeap.offer(minHeap.poll());
            }
        }
        // 保证最大堆的大小等于最小堆或 等于最小堆 + 1
        if(maxHeap.size() > minHeap.size() + 1){
            minHeap.offer(maxHeap.poll());
        }
        if(maxHeap.size() < minHeap.size()){
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        // 如果最大堆的大小 是 最小堆大小 + 1 ，那么最大堆堆顶就是中间值
        if(maxHeap.size() > minHeap.size()){
            return 1.0 * maxHeap.peek();
        }
        // 否则，偶数个元素，取两者堆顶，计算平均值
        else{
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
    }
}
