package LeetCode;
/**
 * LeetCode 119
 * 题意：给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * 示例:
 * 输入: 3
 * 输出: [1,3,3,1]
 * 进阶：
 * 你可以优化你的算法到 O(k) 空间复杂度吗？
 * 思路：可以直接计算，比较巧妙，
 *      注意rowIndex == 0 , return {1}，所以无需对 rowIndex == 0单独判断
 *      84.53% , 50.84%
 */

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle2_119 {
    public static void main(String[] args) {
        int rowIndex = 4;
        List<Integer> res = getRow(rowIndex);
        System.out.println(res);
    }
    public static List<Integer> getRow(int rowIndex){
        List<Integer> list = new ArrayList<>();
//        if(rowIndex == 0){   rowIndex = 0 , return {1};
//            return list;
//        }
        long num = 1;
        list.add((int)num);
        for(int i = 0 ; i < rowIndex ; i ++){
            num = num * (rowIndex - i) / (i + 1);
            list.add((int)num);
        }
        return list;
    }
}
