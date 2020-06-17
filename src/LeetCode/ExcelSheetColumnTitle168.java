package LeetCode;

/**
 * LeetCode 168
 * 题意：给定一个正整数，返回它在 Excel 表中相对应的列名称。
 * 例如，
 *     1 -> A
 *     2 -> B
 *     3 -> C
 *     ...
 *     26 -> Z
 *     27 -> AA
 *     28 -> AB
 *     ...
 * 输入: 28
 * 输出: "AB"
 * 输入: 701
 * 输出: "ZY"
 * 思路：虽然是26进制，但是是从1开始的，不是0，所以需要对操作数-1，再/26,%26
 *      100% , 14.29%
 */
public class ExcelSheetColumnTitle168 {
    public static void main(String[] args) {
        int n = 703;
        String res = convertToTitle(n);
        System.out.println(res);
    }
    public static String convertToTitle(int n) {
        StringBuffer sb = new StringBuffer();
        int m = 0 , yushu = 0;
        while(n != 0){
            m = (n - 1) / 26;
            yushu = (n - 1) % 26;
            n = m;
            char c = (char)('A' + yushu) ;
            sb.insert(0 , c);
        }
        return sb.toString();
    }
}
