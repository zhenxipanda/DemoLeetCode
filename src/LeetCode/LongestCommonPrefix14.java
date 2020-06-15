package LeetCode;

/**
 * LeetCode 14
 * 题意：编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 * 示例 1:
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 * 所有输入只包含小写字母 a-z 。
 * 思路：利用到了String的indexOf(),查找目标字符串在待查找字符串中第一次出现的位置，
 *      如果位置不为0，就从头截取prefix，每次长度-1
 *      直到位置为0，再去遍历在下一个字符串中查找，
 *      返回prefix，可能为"",也可能不为""
 *      100% , 29.17%
 */
public class LongestCommonPrefix14 {
    public static void main(String[] args) {
        String[] strs = {"flow" , "flower" , "flight"};
        String res = longestCommonPrefix(strs);
        System.out.println(res);
    }
    public static String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0){
            return "";
        }
        String prefix = strs[0];
        for(int i = 1; i < strs.length ; i ++){
            while(strs[i].indexOf(prefix) != 0){
                prefix = prefix.substring(0 , prefix.length() - 1);
            }
        }
        return prefix;
    }
}
