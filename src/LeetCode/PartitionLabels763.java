package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 763
 * 题意：
 * 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，
 * 同一个字母只会出现在其中的一个片段。返回一个表示每个字符串片段的长度的列表。
 * 示例 1：
 * 输入：S = "ababcbacadefegdehijhklij"
 * 输出：[9,7,8]
 * 解释：
 * 划分结果为 "ababcbaca", "defegde", "hijhklij"。
 * 每个字母最多出现在一个片段中。
 * 像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
 * 提示：
 * S的长度在[1, 500]之间。
 * S只包含小写字母 'a' 到 'z' 。
 * 思路：记录一个字母最后一次出现的位置，如果首尾区间内的元素都出现在这个区间，这就是一个结果，
 *      比较巧妙，循环i控制外围扫描，扫描到的元素记录此区间的元素最后一此出现的位置，取最大，扩展区间，
 *      当i==j，此区间结束，加入List
 *      78.61% , 87.62%
 */
public class PartitionLabels763 {
    public static void main(String[] args) {
        String s = "ababcbabeddefem";
        List<Integer> list = partitionLabels(s);
        System.out.println(list);
    }
    public static List<Integer> partitionLabels(String S) {
        int[] count = new int[26];
        for(int i = 0; i < S.length(); i ++){
            count[S.charAt(i) - 'a'] = i;
        }
        List<Integer> list = new ArrayList<>();
        int j = 0 , start = 0;
        for(int i = 0;i < S.length() ; i ++){
            j = Math.max(j , count[S.charAt(i) - 'a']);
            if(i == j){
                list.add(i - start + 1);
                start = i + 1;
            }
        }
        return list;
    }
}
