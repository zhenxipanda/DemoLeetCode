package LeetCode;
/**
 * LeetCode 131
 * 题意：给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 * 返回 s 所有可能的分割方案。
 * 示例:
 * 输入: "aab"
 * 输出:
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 * 思路：用二维数组存储i-j是否为回文子串，
 *      然后回溯 + 递归 将回文串加入到 list 中， list 加入到res 中
 *      100% , 55.15%
 */

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning131 {
    public static void main(String[] args) {
        String s = "aab";
        List<List<String>> res = partition(s);
        System.out.println(res);
    }
    private static boolean[][] isPali ;
    private static String str ;
    public static List<List<String>> partition(String s){
        List<List<String>> res = new ArrayList<>();
        str = s;
        isPali = deter(s);
        dfs(res , new ArrayList<>() , 0);
        return res;
    }

    private static void dfs(List<List<String>> res, ArrayList<String> list, int start) {
        if(start == str.length()){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = start + 1; i <= str.length(); i ++){
            if(isPali[start][i-1]){
                list.add(str.substring(start , i));
                dfs(res , list , i);
                list.remove(list.size() - 1);
            }

        }
    }

    private static boolean[][] deter(String s) {
        int i = 0 , j = 0;
        isPali = new boolean[s.length()][s.length()];
        for(int mid = 0; mid < s.length() ; mid ++){
            i = mid;
            j = mid;
            while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)){
                isPali[i][j] = true;
                i --;
                j ++;
            }
            i = mid;
            j = mid + 1;
            while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)){
                isPali[i][j] = true;
                i --;
                j ++;
            }
        }
        return isPali;
    }
}
