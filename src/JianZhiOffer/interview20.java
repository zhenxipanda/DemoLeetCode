package JianZhiOffer;

/**
 * 剑指offer 20
 * 题意：请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"-1E-16"、"0123"都表示数值，
 * 但"12e"、"1a3.14"、"1.2.3"、"+-5"及"12e+5.4"都不是。
 * 思路：自定义规则，与leetcode 一题相同，题目号不记得了
 *      e前面必有数字
 *      +/-如果不是第0个元素，需要判断前面是否为e/E,&&
 *      98.64% , 14.64%
 */
public class interview20 {
    public static void main(String[] args) {
        String s = "-1.5e-8";
        boolean res = isNumber(s);
        System.out.println(res);
    }
    public static boolean isNumber(String s){
        if(s == null || s.length() == 0){
            return false;
        }
        boolean numSeen = false , notSeen = false, eSeen = false;
        char[] ch = s.trim().toCharArray();
        for(int i = 0;i < ch.length; i ++){
            if(ch[i] >= '0' && ch[i] <= '9'){
                numSeen = true;
            }
            else if(ch[i] == '.'){
                if(notSeen || eSeen){
                    return false;
                }
                notSeen = true;
            }
            else if(ch[i] == 'e' || ch[i] == 'E'){
                if(!numSeen || eSeen){   // e前面必须有数字
                    return false;
                }
                eSeen = true;
                numSeen = false;
            }
            else if(ch[i] == '+' || ch[i] == '-'){
                if(i > 0 && (ch[i - 1] != 'e' && ch[i - 1] != 'E')){ // 三个 &&
                    return false;
                }
            }
            else{
                return false;
            }
        }
        return numSeen;
    }
}
