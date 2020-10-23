package JianZhiOffer;
/**
 * 剑指offer 57-2
 * 题意：输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 * 示例 1：
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 * 示例 2：
 * 输入：target = 15
 * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 * 限制：
 * 1 <= target <= 10^5
 * 思路：small=1,big=2从头开始计算，如果curr < target , big ++ ,curr += big
 *      如果 curr > target , curr -= small , small ++
 *      如果 curr == target , 将small-big之间的数字以数组形式放入list中，curr -= small , small ++
 *      都是先 -= small ， 再 small ++
 *      85.86% , 95.22%
 */

import java.util.*;

public class interview57_2 {
    public static void main(String[] args) {
        int target = 9;
        int[][] res = findContinuousSequence(target);
        for(int[] nums : res){
            System.out.println(Arrays.toString(nums));
        }
    }
    public static int[][] findContinuousSequence(int target){
        List<int[]> list = new ArrayList<>();
        int small = 1 , big = 2;
        int mid = (1 + target) >> 1 , curr = small + big;
        while (small < target){
            if(curr < target){
                big ++ ;
                curr += big;
            }
            else if(curr > target){
                curr -= small;
                small ++ ;
            }
            else{
                put(list , small , big);
                curr -= small;
                small ++ ;
            }
        }
        return list.toArray(new int[list.size()][2]);
    }

    private static void put(List<int[]> list, int small, int big) {
        int[] nums = new int[big - small + 1];
        for(int k = 0; k < nums.length ; k ++){
            nums[k] = small ;
            small ++ ;
        }
        list.add(nums);
    }
}
