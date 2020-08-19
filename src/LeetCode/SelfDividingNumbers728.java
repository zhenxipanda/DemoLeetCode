package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 728
 * 题意：
 * 自除数 是指可以被它包含的每一位数除尽的数。
 * 例如，128 是一个自除数，因为 128 % 1 == 0，128 % 2 == 0，128 % 8 == 0。
 * 还有，自除数不允许包含 0 。
 * 给定上边界和下边界数字，输出一个列表，列表的元素是边界（含边界）内所有的自除数。
 * 示例 1：
 * 输入：
 * 上边界left = 1, 下边界right = 22
 * 输出： [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
 * 注意：
 * 每个输入参数的边界满足 1 <= left <= right <= 10000。
 * 思路：暴力解法，包含0的不是，取余大于0的不是
 *      26.99% , 25.52%
 */
public class SelfDividingNumbers728 {
    public static void main(String[] args) {
        int left = 1 , right = 22;
        List<Integer> res = selfDividingNumbers(left , right);
        System.out.println(res);
    }
    public static List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<>();
        for(int i = left ; i <= right ; i ++){
            if(divide(i)){
                res.add(i);
            }
        }
        return res;
    }
    public static boolean divide(int n){
        for(char c : String.valueOf(n).toCharArray()){
            if(c == '0' || n % (c - '0') > 0){
                return false;
            }
        }
        return true;
    }
}
