package JianZhiOffer;

/**
 * 剑指offer 05
 * 题意：请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * 示例 1：
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 * 限制：
 * 0 <= s 的长度 <= 10000
 * 思路：较简单，遍历字符串，遇到空格append("%20"),
 *      100% , 39.71%
 */
public class interview05 {
    public static void main(String[] args) {
        String s = "where is my offer?";
        String res = replaceSpace(s);
        System.out.println(res);
    }
    public static String replaceSpace(String s) {
        if(s == null || s.length() == 0){
            return s;
        }
        char[] ch = s.toCharArray();
        StringBuffer sb = new StringBuffer();
        for(int i = 0;i < ch.length; i ++){
            if(ch[i] == ' '){
                sb.append("%20");
            }
            else{
                sb.append(ch[i]);
            }
        }
        return sb.toString();
    }
}
