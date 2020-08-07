package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * LeetCode 406
 * 题意：
 * 假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，
 * 其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。
 * 编写一个算法来重建这个队列。
 * 注意：
 * 总人数少于1100人。
 * 示例
 * 输入:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 * 输出:
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 * 思路：关键是排序，先按照高度降序排序，同样高度的升序排序
 *      下一个关键是以 大于等于此人的数 作为下标，插入到list中
 *      先插高个，因为对于高个来说，矮的人是没有影响的
 *      所以高的人后移就行，所以用list.add()
 *      学习到了，比较巧妙
 *      75.36% , 73.83%
 */
public class QueueReconstructionByHeight406 {
    public static void main(String[] args) {
        int[][] people = {{7,0},{6,1},{5,0},{7,1},{4,4},{5,2}};
        int[][] res = reconstructQueue(people);
        for(int[] ans : res){
            System.out.println(Arrays.toString(ans));
        }
    }
    public static int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people , new Comparator<int[]>(){
                    public int compare(int[] o1 , int[] o2){
                        return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
                    }
                }
        );
        List<int[]> list = new ArrayList<>();
        for(int[] p : people){
            list.add(p[1] , p);
        }
        return list.toArray(new int[list.size()][2]);
    }
}
