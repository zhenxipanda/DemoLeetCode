package JianZhiOffer;

/**
 * 剑指offer 50
 * 题意：在字符串 s 中找出第一个只出现一次的字符。
 * 如果没有，返回一个单空格。 s 只包含小写字母。
 * 示例:
 * s = "abaccdeff"
 * 返回 "b"
 * s = ""
 * 返回 " "
 * 限制：
 * 0 <= s 的长度 <= 50000
 * 思路：统计出现次数，再次遍历字符串，找到第一个次数为1的
 *      89.28% , 97.62%
 */
public class interview50 {
    public static void main(String[] args) {
        String s = "leetcode";
        char c = firstUniqChar(s);
        System.out.println(c);
    }
    public static char firstUniqChar(String s) {
        if(s == null || s.length() == 0){
            return ' ';
        }
        char[] ch = s.toCharArray();
        int[] count = new int[128];
        for(int i = 0;i < ch.length; i ++){
            count[ch[i]] ++;
        }
        for(int i = 0;i < ch.length; i ++){
            if(count[ch[i]] == 1){
                return ch[i];
            }
        }
        return ' ';
    }
}
