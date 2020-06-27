package LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * LeetCode 202
 * 题意：
 * 编写一个算法来判断一个数 n 是不是快乐数。
 * 「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。如果 可以变为  1，那么这个数就是快乐数。
 * 如果 n 是快乐数就返回 True ；不是，则返回 False 。
 * 示例：
 * 输入：19
 * 输出：true
 * 解释：
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 * 思路：比较简单，去模拟这个计算过程，如果是快乐数，和=1，如果不是的话
 *      根据题意，应该会有重复的元素，所以由此想到用HashSet存储过程中的值，只要出现了重复元素，
 *      就说明不是快乐数
 *      99.96% , 8.33%
 */
public class HappyNumber202 {
    public static void main(String[] args) {
        int n = 19;
        boolean res = isHappy(n);
        System.out.println(res);
    }
    public static boolean isHappy(int n) {
        int tmp = 0 , res = 0;
        Set<Integer> set = new HashSet<>();
        while(true){
            res = 0;
            while(n != 0){
                tmp = n % 10 ;
                n = n / 10;
                res += tmp * tmp ;
            }
            if(res == 1){
                return true ;
            }
            if(set.contains(res)){
                break;
            }
            set.add(res);
            n = res;
        }
        return false;
    }
}
