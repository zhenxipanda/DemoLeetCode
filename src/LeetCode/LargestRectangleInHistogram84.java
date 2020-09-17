package LeetCode;

/**
 * LeetCode 84
 * 题意：给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 * 输入: [2,1,5,6,2,3]
 * 输出: 10
 * 思路：维护两个数组，一个是右侧比自己小的元素下标，一个是左侧比自己小的元素下标
 *      两个差 - 1，即为以此元素为高的矩形的宽
 *      99.73% , 8.74%
 */
public class LargestRectangleInHistogram84 {
    public static void main(String[] args) {
        int[] heights = {2,1,5,6,2,3};
        int res = largestRectangleArea(heights);
        System.out.println(res);
    }
    public static int largestRectangleArea(int[] heights) {
        if(heights == null || heights.length == 0){
            return 0;
        }
        int[] rightmin = new int[heights.length];
        int[] leftmin = new int[heights.length];
        int max = 0;
        rightmin[heights.length - 1] = heights.length;
        for(int i = heights.length - 2; i >= 0; i --){
            int j = i + 1;
            while(j != heights.length && heights[j] >= heights[i]){
                j = rightmin[j];
            }
            rightmin[i] = j;
        }
        leftmin[0] = -1;
        for(int i = 1;i < heights.length; i ++){
            int j = i - 1;
            while(j != -1 && heights[j] >= heights[i]){
                j = leftmin[j];
            }
            leftmin[i] = j;
        }
        for(int i = 0;i < heights.length; i ++){
            max = Math.max(max , heights[i] * (rightmin[i] - leftmin[i] - 1));
        }
        return max;
    }
}
