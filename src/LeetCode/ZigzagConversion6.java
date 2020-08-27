package LeetCode;

/**
 * LeetCode 6
 * 题意：
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 * 请你实现这个将字符串进行指定行数变换的函数：
 * string convert(string s, int numRows);
 * 示例 1:
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * 示例 2:
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 * 思路：对特殊情况进行判断，s为空，nr==1,s长度比nr小，
 *      进行分组，遍历每行，第一个元素append，
 *      第一行和最后一行，append一个元素，
 *      其他行需要判断左侧的是否append，本身是否append
 *      87.48% , 78.26%
 */
public class ZigzagConversion6 {
    public static void main(String[] args) {
        String s = "LEETCODE";
        int numRows = 3;
        String res = convert(s , numRows);
        System.out.println(res);
    }
    public static String convert(String s, int numRows) {
        if(s == null || s.length() == 0 || numRows == 1 || s.length() < numRows){
            return s;
        }
        int len = s.length() , cir = 2 * numRows - 2 , d = 0;
        StringBuffer sb;
        sb = new StringBuffer();
        for(int k = 0 ; k < numRows; k ++){
            int i = k;
            sb.append(s.charAt(i));
            while(i < len){
                i += cir;
                if(k == 0 || k == numRows - 1){
                    if(i < len){
                        sb.append(s.charAt(i));
                    }

                }
                else{
                    if(i - d > 0 && i - d < len){
                        sb.append(s.charAt(i - d));
                    }
                    if(i < len){
                        sb.append(s.charAt(i));
                    }

                }

            }
            d += 2;
        }
        return sb.toString();
    }
}
