package LeetCode;

/**
 * LeetCode 242
 * 题意：
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 示例 1:
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 * 思路：比较简单，同构词，也就是具有相同的字母和字母个数，并且长度相等，
 *      所以先判断长度不等，肯定不是同构词，
 *      因为题目中说明，只包含小写字母，所以创建int[26]统计每个字母出现的次数，
 *      遍历一次字符串，这一次便利中，对字符串s中的字母个数 +1，
 *      对字符串 t 中的字母个数 -1，
 *      如果是同构词，字母出现次数一致，int[]数组，因为全为0，
 *      不为0，肯定存在字母个数不同，return false;
 *      若遍历完int[]，全为0，那就是同构词，return true;
 *      64.34% , 5.66%
 */
public class ValidAnagram242 {
    public static void main(String[] args) {
        String s = "cat";
        String t = "eat";
        boolean res = isAnagram(s , t);
        System.out.println(res);
    }
    public static boolean isAnagram(String s, String t) {
        if(s == null || t == null || s.length() != t.length()){
            return false;
        }
        int[] count = new int[26];
        int n = s.length();
        for(int i = 0; i < n; i ++){
            count[s.charAt(i) - 'a'] ++;
            count[t.charAt(i) - 'a'] --;
        }
        for(int i = 0;i < n;i ++){
            if(count[s.charAt(i) - 'a'] != 0){
                return false;
            }
        }
        return true;
    }
}
