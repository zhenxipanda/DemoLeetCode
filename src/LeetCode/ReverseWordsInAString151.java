package LeetCode;

/**
 * LeetCode 151
 * 题目：给定一个字符串，逐个翻转字符串中的每个单词。
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 输入: "a good   example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 * 说明：
 * 无空格字符构成一个单词。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 * 思路：虽然是Medium标签，但是整体思想比较简单。
 *      有一些点需要额外注意：
 *      1.先s.trim(),再进行以空格的split(" ")分割，
 *      2.用StringBuffer存储中间结果，从后向前遍历单词数组，只有最后一个，即i == 0，不在后面append(" ")。
 *      99.99% , 5.26%
 */
public class ReverseWordsInAString151 {
    public static void main(String[] args){
        String s = " hello  world!  ";
        String res = reverseWords(s);
        System.out.println(res);
    }
    public static String reverseWords(String s) {
        if(s == null || s.length() == 0){
            return s;
        }
        String[] str = s.trim().split(" ");
        StringBuffer sb = new StringBuffer();
        for(int i = str.length - 1 ; i >= 0; i --){
            if(str[i].equals("")){
                continue ;
            }
            else{
                sb.append(str[i]);
                if(i != 0){
                    sb.append(" ");
                }
            }
        }
        return sb.toString();
    }
}
