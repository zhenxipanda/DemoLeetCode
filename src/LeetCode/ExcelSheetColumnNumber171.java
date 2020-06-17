package LeetCode;

/**
 * LeetCode 171
 * 题意：
 * 给定一个Excel表格中的列名称，返回其相应的列序号。
 * 例如，
 *     A -> 1
 *     B -> 2
 *     C -> 3
 *     ...
 *     Z -> 26
 *     AA -> 27
 *     AB -> 28
 *     ...
 * 输入: "ZY"
 * 输出: 701
 * 思路：168的相反操作
 *      因为26进制没有0，所以需要+1
 *      模拟10进制，利用jinzhi记录26的0次幂，26的1次幂......
 *      100% , 5.55%
 */
public class ExcelSheetColumnNumber171 {
    public static void main(String[] args) {
        String s = "ZY";
        int res = titleToNumber(s);
        System.out.println(res);
    }
    public static int titleToNumber(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        char[] ch = s.toCharArray();   //也可以不额外开辟空间，直接对s字符串操作，s.charAt()
        int ans = 0;
        int jinzhi = 1;
        for(int i = ch.length - 1; i >= 0; i --){
            int tmp = ch[i] - 'A' + 1;
            ans += jinzhi * tmp ;
            jinzhi *= 26;
        }
        return ans ;
    }
}
