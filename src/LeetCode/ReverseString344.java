package LeetCode;

import java.util.Arrays;

/**
 * LeetCode 344
 * 题意：
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
 * 示例 1：
 * 输入：["h","e","l","l","o"]
 * 输出：["o","l","l","e","h"]
 * 示例 2：
 * 输入：["H","a","n","n","a","h"]
 * 输出：["h","a","n","n","a","H"]
 * 思路：比较简单，双指针，一个在左，一个再右，若不等，即交换
 *      99.91% , 75.89%
 */
public class ReverseString344 {
    public static void main(String[] args) {
        char[] s = {'a','p','p','l','e','!'};
        reverseString(s);
        System.out.println(Arrays.toString(s));
    }
    public static void reverseString(char[] s) {
        if(s == null || s.length == 0){
            return ;
        }
        int n = s.length;
        int mid = n / 2;
        int i = 0 , j = n - 1;
        while(i < mid){
            if(s[i] != s[j]){
                swap(s , i , j);
            }

            i ++;
            j --;
        }
    }
    public static void swap(char[] s , int x , int y){
        char z = s[x];
        s[x] = s[y];
        s[y] = z;
    }
}
