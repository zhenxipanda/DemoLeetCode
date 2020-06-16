package LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 166
 * 题意：给定两个整数，分别表示分数的分子 numerator 和分母 denominator，以字符串形式返回小数。
 * 如果小数部分为循环小数，则将循环的部分括在括号内。
 * 输入: numerator = 1, denominator = 2
 * 输出: "0.5"
 * 输入: numerator = 2, denominator = 1
 * 输出: "2"
 * 输入: numerator = 2, denominator = 3
 * 输出: "0.(6)"
 * 思路：1. 先对特殊情况进行处理，分子==0，分母==0
 *      2. 将int型的分子和分母转换为long型，防止-2147483648 / -1 溢出
 *      3. 判断分子分母是否同号
 *      4. 判断是否整除，若整除，结束程序
 *      5. 不整除的话，将除数和小数点加入stringbuffer
 *      6. 计算小数点后面的数字，记录分子分母的商，如果是循环小数，就要加(),
 *      7. 根据这一特性，用Map存储是否重复出现，如果有，计算位置，插入"(",append(")")
 *      100% , 100%
 */
public class FractionToRecurringDecimal166 {
    public static void main(String[] args) {
        int numerator = -1 ;
        int denominator = 3;
        String res = fractionToDecimal(numerator , denominator);
        System.out.println(res);
    }
    public static String fractionToDecimal(int numerator, int denominator) {
        if (denominator == 0) {
            return "";
        }

        if (numerator == 0) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        if ((numerator ^ denominator) < 0) {
            sb.append('-');
        }

        long numeratorL = Math.abs((long) numerator);
        long denominatorL = Math.abs((long) denominator);

        long mod = numeratorL % denominatorL;
        if (mod == 0) {
            return sb.append(numeratorL / denominatorL).toString();
        }

        sb.append(numeratorL / denominatorL).append(".");
        Map<Long, Integer> cachedMap = new HashMap<>();

        int modIndex = 0;
        while (mod != 0) {
            if (cachedMap.containsKey(mod)) {  //判断上次出现的余数位置，方便插入括号
                sb.insert(sb.length() - (modIndex - cachedMap.get(mod)), '(');
                sb.append(')');
                break;
            } else {
                cachedMap.put(mod, modIndex++); //记录余数和位置
            }
            mod *= 10;
            sb.append(mod / denominatorL);
            mod = mod % denominatorL;
        }

        return sb.toString();
    }
}
