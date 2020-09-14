package LeetCode;

/**
 * LeetCode 67
 * 题意：给你两个二进制字符串，返回它们的和（用二进制表示）。
 * 输入为 非空 字符串且只包含数字 1 和 0。
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 * 提示：
 * 每个字符串仅由字符 '0' 或 '1' 组成。
 * 1 <= a.length, b.length <= 10^4
 * 字符串如果不是 "0" ，就都不含前导零。
 * 思路：字符串表示的二进制，可以从尾部相加，模拟二进制加法的过程，
 *      将结果放入StringBuffer中，一个难点就是最后要判断是否有进位，
 *      有的话，sb.append(carry)，没有的话，可以sb.append(""),可用三目运算符实现
 *      最后，将sb翻转，return sb.reverse().toString().
 *      61.57% , 43.13%
 */
public class AddBinary67 {
    public static void main(String[] args) {
        String a = "11";
        String b = "1";
        String res = addBinary(a , b);
        System.out.println(res);
    }
    public static String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        int sum = 0 , carry = 0;
        StringBuffer sb = new StringBuffer();
        while(i >= 0 || j >= 0){
            sum = carry;
            sum += (i >= 0)? a.charAt(i) - '0' : 0;
            i --;
            sum += (j >= 0)? b.charAt(j) - '0' : 0;
            j --;
            carry = sum / 2;
            sb.append(sum % 2);
        }
        sb.append(carry != 0 ? carry : "");
        return sb.reverse().toString();
    }
}
