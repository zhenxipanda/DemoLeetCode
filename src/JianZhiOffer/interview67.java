package JianZhiOffer;

/**
 * 剑指offer 67
 * 题意：写一个函数 StrToInt，实现把字符串转换成整数这个功能。
 * 不能使用 atoi 或者其他类似的库函数。
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
 * 示例 1:
 * 输入: "42"
 * 输出: 42
 * 示例 2:
 * 输入: "   -42"
 * 输出: -42
 * 解释: 第一个非空白字符为 '-', 它是一个负号。
 *      我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
 * 示例 3:
 * 输入: "4193 with words"
 * 输出: 4193
 * 解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
 * 示例 4:
 * 输入: "words and 987"
 * 输出: 0
 * 解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
 *      因此无法执行有效的转换。
 * 示例 5:
 * 输入: "-91283472332"
 * 输出: -2147483648
 * 解释: 数字 "-91283472332" 超过 32 位有符号整数范围。
 *      因此返回 INT_MIN (−231) 。
 * 思路：先略过空格，然后判断第一个元素是否为+/-，是的话，index ++,是否为非数字，直接无效，return 0
 *      然后判断数字，注意是否越界
 *      31.52% , 65.18%
 */
public class interview67 {
    public static void main(String[] args) {
        String str = "   -42";
        int res = strToInt(str);
        System.out.println(res);
    }
    private static boolean isValid = true;
    public static int strToInt(String str) {
        if(str == null || str.length() == 0){
            return 0;
        }
        int index = 0 , len = str.length();
        int res = 0;
        boolean sign = true;
        while(index < len && str.charAt(index) == ' '){
            index ++;
        }
        if(index  == len){
            return 0;
        }
        if(str.charAt(index) == '+'){
            sign = true;
            index ++;
        }
        else if(str.charAt(index) == '-'){
            sign = false;
            index ++;
        }
        else if(!(str.charAt(index) >= '0' && str.charAt(index) <= '9')){
            isValid = false;
            return 0;
        }
        if(index < len){
            res = myAoti(str , index , sign);
        }
        return res;
    }
    public static int myAoti(String str , int index, boolean sign){
        long res = 0;
        for(int i = index; i < str.length(); i ++){
            if(str.charAt(i) >= '0' && str.charAt(i) <= '9'){
                res = res * 10 + str.charAt(i) - '0';
                if(sign && res >= Integer.MAX_VALUE){
                    return Integer.MAX_VALUE;
                }
                if(!sign && -res <= Integer.MIN_VALUE){
                    return Integer.MIN_VALUE;
                }
            }
            else{
                break;
            }
        }
        if(sign){
            return (int)res;
        }
        else{
            return (int)-res;
        }
    }
}
