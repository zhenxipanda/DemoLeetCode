package LeetCode;
/**
 * LeetCode 87
 * 题意：给定一个字符串 s1，我们可以把它递归地分割成两个非空子字符串，从而将其表示为二叉树。
 * 下图是字符串 s1 = "great" 的一种可能的表示形式。
 *     great
 *    /    \
 *   gr    eat
 *  / \    /  \
 * g   r  e   at
 *            / \
 *           a   t
 * 在扰乱这个字符串的过程中，我们可以挑选任何一个非叶节点，然后交换它的两个子节点。
 * 例如，如果我们挑选非叶节点 "gr" ，交换它的两个子节点，将会产生扰乱字符串 "rgeat" 。
 *     rgeat
 *    /    \
 *   rg    eat
 *  / \    /  \
 * r   g  e   at
 *            / \
 *           a   t
 * 我们将 "rgeat” 称作 "great" 的一个扰乱字符串。
 * 同样地，如果我们继续交换节点 "eat" 和 "at" 的子节点，将会产生另一个新的扰乱字符串 "rgtae" 。
 *     rgtae
 *    /    \
 *   rg    tae
 *  / \    /  \
 * r   g  ta  e
 *        / \
 *       t   a
 * 我们将 "rgtae” 称作 "great" 的一个扰乱字符串。
 * 给出两个长度相等的字符串 s1 和 s2，判断 s2 是否是 s1 的扰乱字符串。
 * 示例 1:
 * 输入: s1 = "great", s2 = "rgeat"
 * 输出: true
 * 示例 2:
 * 输入: s1 = "abcde", s2 = "caebd"
 * 输出: false
 * 思路：递归，主要通过匹配，字符种类和个数是否一致判断是否true
 *      flag 分为两部分，一部分s1.substring(0,i),s2.substring(0,1)&& s1.substring(i),s2.substring(i)
 *      另一部分是s1.substring(0,i),s2.substring(s2.length()-i) && s1.substring(i),s2.subtring(0,s2.length()-i)
 *      57.24% , 47.26%
 */

import java.util.*;

public class ScrambleString87 {
    public static void main(String[] args) {
        String s1 = "great";
        String s2 = "rgtae";
        boolean res = isScramble(s1, s2);
        System.out.println(res);
    }

    public static boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        if(s1.equals(s2)){
            return true;
        }
        Map<Character , Integer> map = new HashMap<>();
        for(int i = 0; i < s1.length() ; i ++){
            map.put(s1.charAt(i) , map.getOrDefault(s1.charAt(i) , 0) + 1);
            map.put(s2.charAt(i) , map.getOrDefault(s2.charAt(i) , 0) - 1);
        }
        for(char c : map.keySet()){
            if(map.get(c) != 0){
                return false;
            }
        }
//        i = 1 , not i = 0
        for(int i = 1; i < s1.length() ; i ++){
            boolean flag = (isScramble(s1.substring(0 , i) , s2.substring(0 , i)) &&
                            isScramble(s1.substring(i) , s2.substring(i))) ||
                    (isScramble(s1.substring(0 , i) , s2.substring(s2.length() - i)) &&
                            isScramble(s1.substring(i) , s2.substring(0 ,s2.length() - i)));
            if(flag){
                return true;
            }
        }
        return false;
    }
}
