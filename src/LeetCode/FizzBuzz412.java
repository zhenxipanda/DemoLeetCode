package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 412
 * 题意：
 * 写一个程序，输出从 1 到 n 数字的字符串表示。
 * 1. 如果 n 是3的倍数，输出“Fizz”；
 * 2. 如果 n 是5的倍数，输出“Buzz”；
 * 3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”。
 * 示例：
 * n = 15,
 * 返回:
 * [
 *     "1",
 *     "2",
 *     "Fizz",
 *     "4",
 *     "Buzz",
 *     "Fizz",
 *     "7",
 *     "8",
 *     "Fizz",
 *     "Buzz",
 *     "11",
 *     "Fizz",
 *     "13",
 *     "14",
 *     "FizzBuzz"
 * ]
 * 思路：不用每个数都去% 15, % 5 , % 3，因为做了很多多余的运算
 *      一个数 % 3, % 5就可以了
 *      0b1，表示二进制的1，0b10，表示二进制的2
 *      62.82% , 80.67%
 */
public class FizzBuzz412 {
    public static void main(String[] args) {
        int n = 15;
        List<String> list = fizzBuzz(n);
        System.out.println(list);
    }
    public static List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>();
        for(int i = 1; i <= n ; i ++){
            int res = 0;
            res += i % 3 == 0 ? 0b1 : 0;
            res += i % 5 == 0 ? 0b10 : 0;
            if(res == 0b1){
                list.add("Fizz");
            }
            else if(res == 0b10){
                list.add("Buzz");
            }
            else if(res == 0b11){
                list.add("FizzBuzz");
            }
            else{
                list.add(String.valueOf(i));
            }
        }
        return list;
    }
}
