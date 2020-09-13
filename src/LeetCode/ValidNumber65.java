package LeetCode;

/**
 * LeetCode 65
 * 题意：验证给定的字符串是否可以解释为十进制数字。
 * 例如:
 * "0" => true
 * " 0.1 " => true
 * "abc" => false
 * "1 a" => false
 * "2e10" => true
 * " -90e3   " => true
 * " 1e" => false
 * "e3" => false
 * " 6e-1" => true
 * " 99e2.5 " => false
 * "53.5e93" => true
 * " --6 " => false
 * "-+3" => false
 * "95a54e53" => false
 * 说明: 我们有意将问题陈述地比较模糊。在实现代码之前，你应当事先思考所有可能的情况。
 * 这里给出一份可能存在于有效十进制数字中的字符列表：
 * 数字 0-9
 * 指数 - "e"
 * 正/负号 - "+"/"-"
 * 小数点 - "."
 * 当然，在输入中，这些字符的上下文也很重要。
 * 思路：与《剑指offer》20题同，
 *      对于+/-情况，把不符合条件的排除掉，即i > 0 && ch[i-1] != 'e' && ch[i-1] != 'E' return false;
 *      还有就是在转为数组之前，先把字符串前后的空格去掉，因为内部不包含空格
 *      60.97% , 18.76%
 */
public class ValidNumber65 {
    public static void main(String[] args) {
         String s = "  .5e2.5";
         boolean res = isNumber(s);
        System.out.println(res);
    }
    public static boolean isNumber(String s){
        if(s == null || s.length() == 0){
            return false;
        }
        boolean numSeen = false , notSeen = false , eSeen = false;
        char[] ch = s.trim().toCharArray();
        for(int i = 0 ; i < ch.length ; i ++){
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
                if(eSeen || !numSeen){
                    return false;
                }
                eSeen = true;
                numSeen = false;
            }
            else if(ch[i] == '+' || ch[i] == '-'){
                if(i > 0 && ch[i- 1] != 'e' && ch[i - 1] != 'E'){
                    return false;
                }
            }
            else {
                return false;
            }
        }
        return numSeen;
    }
}
