package LeetCode;

/**
 * LeetCode 125
 * 题意：给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 输入: "race a car"
 * 输出: false
 * 思路：因为只对字母和数字进行判断，所以对于非字母、非数字，跳过不管就好，
 *      对应的操作就是创建一个方法，判断扫描到的字符是否是字母和数字
 *      如果两个下标指向的都是字母和数字，对他们进行比较
 *      比较的方法：(wrong),判断 a == b || Math.abs(a - b) == 32， 0，P，也差32
 *      (right)，使用Character.toLowerCase(),将两者都转换为小写，如果相等，i++,j--，继续判断
 *      不等，不是回文串，return false;
 *      93.04% , 7.14%
 */
public class ValidPalindrome125 {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        boolean res = isPalindrome(s);
        System.out.println(res);
    }
    public static boolean isPalindrome(String s) {
        if(s == null || s.length() == 0){
            return true ;
        }
        int i = 0 , j = s.length() - 1;
        while(i < j){
            if(! isDigOrChar(s.charAt(i))){
                i ++;
                continue;
            }
            if(! isDigOrChar(s.charAt(j))){
                j -- ;
                continue ;
            }
            if(Character.toLowerCase(s.charAt(i)) == Character.toLowerCase(s.charAt(j))){
                i ++;
                j --;
                continue ;
            }
            else{
                return false;
            }
        }
        return true;
    }
    public static boolean isDigOrChar(char c){
        if((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9')){
            return true ;
        }
        return false ;
    }
}
