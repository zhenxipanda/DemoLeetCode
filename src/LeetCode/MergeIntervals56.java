package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode 56
 * 题意：给出一个区间的集合，请合并所有重叠的区间。
 * 示例 1:
 * 输入: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 * 输入: intervals = [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * 注意：输入类型已于2019年4月15日更改。 请重置默认代码定义以获取新方法签名。
 * 提示：
 * intervals[i][0] <= intervals[i][1]
 * 思路：先对二维数组排序，
 *      判断起始端点大小关系，放入list<int[]>中
 *      63.04% , 18.63%
 */
public class MergeIntervals56 {
    public static void main(String[] args) {
        int[][] intervals = {{1,2},{2,6},{8,10}};
        int[][] res = merge(intervals);
        for(int[] arr : res){
            System.out.println(Arrays.toString(arr));
        }
    }
    public static int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length == 0 || intervals[0].length == 0){
            return new int[0][0];
        }
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals , (int[] a , int[] b )-> a[0] - b[0]);
        int start = intervals[0][0];
        int end = intervals[0][1];
        for(int i = 1; i < intervals.length; i ++){
            int[] arr = intervals[i];
            if(arr[1] < end){
                continue;
            }
            if(end < arr[0]){
                list.add(new int[]{start , end});
                start = arr[0];
                end = arr[1];
            }
            else{
                end = Math.max(end , arr[1]);
            }
        }
        list.add(new int[]{start , end});
        return list.toArray(new int[list.size()][2]);
    }
}
