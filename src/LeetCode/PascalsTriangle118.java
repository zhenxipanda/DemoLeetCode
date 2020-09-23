package LeetCode;
/**
 * LeetCode 118
 * 题意：给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * 示例:
 * 输入: 5
 * 输出:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 * 思路：首尾各为1，其他位置的数值由上一行的j-1和j算出，
 *      77.14% , 18.40%
 */

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle118 {
    public static void main(String[] args) {
        int numRows = 5;
        List<List<Integer>> res = generate(numRows);
        System.out.println(res);
    }
    public static List<List<Integer>> generate(int numRows){
        List<List<Integer>> res = new ArrayList<>();
        if(numRows == 0){
            return res;
        }
        List<Integer> list = new ArrayList<>();
        list.add(1);
        res.add(list);
        for(int i = 2; i <= numRows ; i ++){
            list = new ArrayList<>();
            for (int j = 0; j < i ;j ++){
                if(j == 0 || j == i - 1){
                    list.add(1);
                }
                else{
                    int tmp = res.get(i - 2).get(j - 1) + res.get(i - 2).get(j);
                    list.add(tmp);
                }
            }
            res.add(list);
        }
        return res;
    }
}
