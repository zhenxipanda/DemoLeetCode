package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 17
 * 题意：给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 * 思路：递归+回溯，特别注意的是，回溯删除的时候，删除sb的最后一个元素，
 *      使用的函数是sb.deleteCharAt(sb.length() - 1)
 *      递归结束的条件，index == digits.length()
 *      100% , 57.71%
 */
public class LetterCombinationsOfAPphoneNumber17 {
    public static void main(String[] args) {
         String dights = "23";
         List<String> res = letterCombinations(dights);
        System.out.println(res);
    }
    private static String[] strs = {"","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public static List<String> letterCombinations(String digits){
         List<String> res = new ArrayList<>();
         if(digits == null || digits.length() == 0){
             return res;
         }
         dfs(res , new StringBuffer() , digits , 0);
         return res;
    }

    private static void dfs(List<String> res, StringBuffer sb, String digits, int index) {
        if(index == digits.length()){    // not sb.length() == index
            res.add(sb.toString());
            return ;
        }
        String s = strs[digits.charAt(index) - '0' - 1];
        for(int i = 0; i < s.length(); i ++){
            sb.append(s.charAt(i));
            dfs(res , sb , digits , index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
