package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 22
 * 题意：数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * 示例：
 * 输入：n = 3
 * 输出：[
 *        "((()))",
 *        "(()())",
 *        "(())()",
 *        "()(())",
 *        "()()()"
 *      ]
 * 思路：递归，先连接"("，可以选择继续连接"("，也可以连接")"
 *      不用StringBuffer ， 用String ，不用回溯
 *      96.94% , 5.82%
 */
public class GenerateParentheses22 {
    public static void main(String[] args) {
        int n = 3;
        List<String> res = generateParenthesis(n);
        System.out.println(res);
    }
    private static String left = "(";
    private static String right = ")";
    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if(n == 0){
            return res;
        }
        dfs(res , "" , n , n);
        return res;
    }
    public static void dfs(List<String> res , String s , int nleft , int nright){
        if(nleft == 0 && nright == 0){
            res.add(s);
            return ;
        }
        if(nleft != 0){
            dfs(res , s + left , nleft - 1 , nright);
        }
        if(nright > nleft){
            dfs(res , s + right , nleft , nright - 1);
        }
    }
}
