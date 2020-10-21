package JianZhiOffer;
/**
 * 剑指offer 38
 * 题意：输入一个字符串，打印出该字符串中字符的所有排列。
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 * 示例:
 * 输入：s = "abc"
 * 输出：["abc","acb","bac","bca","cab","cba"]
 * 限制：
 * 1 <= s 的长度 <= 8
 * 思路：因为是字符串形式，且最终结果也是字符串，所以将字符串转为char[]
 *      然后交换数组元素，字符串中可能存在重复元素，所以用set存储标记，
 *      90% , 45.13%
 */

import java.util.*;

public class interview38 {
    public static void main(String[] args) {
        String s = "abc";
        String[] res = permutation(s);
        System.out.println(Arrays.toString(res));
    }
    private static List<String> list ;
    private static char[] ch ;
    public static String[] permutation(String s){
        list = new LinkedList<>();
        ch = s.toCharArray();
        dfs(0);
        return list.toArray(new String[list.size()]);
    }
    public static void dfs(int index){
        if(index == ch.length - 1){
            list.add(String.valueOf(ch));
            return;
        }
        Set<Character> set = new HashSet<>();
        for(int i = index ; i < ch.length ; i ++){
            if(set.contains(ch[i])){
                continue;
            }
            set.add(ch[i]);
            swap(i , index);
            dfs(index + 1);   // index + 1 , not i + 1
            swap(i , index);
        }
    }

    private static void swap(int x, int y) {
        char c = ch[x];
        ch[x] = ch[y];
        ch[y] = c;
    }
}
