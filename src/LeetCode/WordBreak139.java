package LeetCode;
import java.util.*;

/**
 * LeetCode 139
 * 题意：给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 * 说明：
 * 拆分时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
 *      注意你可以重复使用字典中的单词。
 * 思路：比较常规的想法，dp[i]，表示前i个字符构成的单词是否在wordDict中出现(包含)
 *      双层循环，外层的i表示滑动窗口的右侧，内层j表示滑动窗口的左侧，因为List的操作代价高，(使用contains方法查询元素是否存在HashSet要比ArrayList快的多。)
 *      将其转换为set，dp[j] && set.contains(s.substring(j , i)),才把dp[i] = true;break;
 *      最后return dp[s.length()]
 *      59.97% , 8.00%
 *      PS : list.contains(),调用indexOf(),遍历整个list
 *           set.contains(),内部使用的是hashtable，根据散列值查找，所以快
 */
public class WordBreak139 {
    public static void main(String[] args) {
        String s = "catsanddog";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("cats");
        wordDict.add("cat");
        wordDict.add("sand");
        wordDict.add("and");
        wordDict.add("dog");
        boolean res = wordBreak(s , wordDict);
        System.out.println(res);
    }
    public static boolean wordBreak(String s, List<String> wordDict){
        Set<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for(int i = 1;i < s.length() + 1 ; i ++){
            for(int j = 0;j < i; j ++){
                if(dp[j] && set.contains(s.substring(j , i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
