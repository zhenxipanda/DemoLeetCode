package LeetCode;

/**
 * LeetCode 415
 * 题意：
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 * 注意：
 * num1 和num2 的长度都小于 5100.
 * num1 和num2 都只包含数字 0-9.
 * num1 和num2 都不包含任何前导零。
 * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。
 * 思路：双指针模拟数字相加
 *      用StringBuffer存储，因为不确定最终的字符串长度是多少，
 *      所以将结果反转，尾部计算出的结果放在头部，然后依次向后放
 *      最后需要判断进位是否不为0，如果不为0，需要append(carry)
 *      最后反转 sb.reverse().append();
 *      79.86% , 80.26%
 */
public class AddStrings415 {
    public static void main(String[] args) {
        String num1 = "125";
        String num2 = "75";
        String res = addStrings(num1 , num2);
        System.out.println(res);
    }
    public static String addStrings(String num1, String num2) {
        StringBuffer sb = new StringBuffer();
        int carry = 0 , ans = 0;
        int i = num1.length() - 1 , j = num2.length() - 1;
        while(i >= 0 || j >= 0){
            int a = i >= 0 ? num1.charAt(i) - '0' : 0 ;
            int b = j >= 0 ? num2.charAt(j) - '0' : 0 ;
            int tmp = ans + a + b;
            ans = tmp% 10;
            carry = tmp / 10;
            sb.append(ans);
            ans = carry;
            i --;
            j --;
        }
        if(carry != 0){
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}
