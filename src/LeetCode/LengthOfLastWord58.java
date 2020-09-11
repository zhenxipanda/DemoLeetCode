package LeetCode;

/**
 * LeetCode 58
 * 题意：给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。
 * 如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。
 * 如果不存在最后一个单词，请返回 0 。
 * 说明：一个单词是指仅由字母组成、不包含任何空格字符的 最大子字符串。
 * 示例:
 * 输入: "Hello World"
 * 输出: 5
 * 思路：从后向前遍历，忽略空格，记录第一个非空格位置下标，
 *      if(end < 0)说明全是空格，return 0
 *      从end开始向前找，找第一个空格start
 *      end - start
 *      100% , 47.32%
 */
public class LengthOfLastWord58 {
    public static void main(String[] args) {
        String s = "hello world  ";
        int len = lengthOfLastWord(s);
        System.out.println(len);
    }
    public static int lengthOfLastWord(String s) {
        int end = s.length() - 1;
        while (end >= 0 && s.charAt(end) == ' ') {
            end--;
        }
        if (end < 0) {
            return 0;
        }
        int start = end;
        while (start >= 0 && s.charAt(start) != ' ') {
            start--;
        }
        return end - start;
    }
}
