package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 187
 * 题意：所有 DNA 都由一系列缩写为 A，C，G 和 T 的核苷酸组成，例如：“ACGAATTCCG”。在研究 DNA 时，识别 DNA 中的重复序列有时会对研究非常有帮助。
 * 编写一个函数来查找目标子串，目标子串的长度为 10，且在 DNA 字符串 s 中出现次数超过一次。
 * 输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"  // 注意：第二段C是6个
 * 输出：["AAAAACCCCC", "CCCCCAAAAA"]
 * 思路：设定转换规则， A : 00 ; C : 01; G : 10 ; T : 11;
 *      用到二进制<< , | , & , >>
 *      主要思路就是滑动窗口扫描十个诗歌扫描，用int[]统计出现的次数，只有当次数==2时，加入队列
 *      将找到的符合条件的字符串(整数表示)，还原成字符串，&3,就能得到后两位， >>2，转换下个数
 *      98.79% , 100.00%
 */
public class RepeatedDnaSequences {
    public static void main(String[] args) {
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        List<String> res = findRepeatedDnaSequences(s);
        System.out.println(res);
    }
    public static List<String> findRepeatedDnaSequences(String s){
        if(s == null || s.length() <= 10){   // 注意：是<= 10, not == 0
            return new ArrayList<>();
        }
        char[] chars = s.toCharArray();
        int[] freq = new int[1 << 20];
        int num = 0 ;
        int task = (1 << 20) - 1;
        for(int i = 0;i < 10; i ++){
            num <<= 2;
            if(chars[i] == 'C'){
                num |= 1;
            }
            else if(chars[i] == 'G'){
                num |= 2;
            }
            else if(chars[i] == 'T'){
                num |= 3;
            }
        }
        freq[num] ++;
        List<Integer> list = new ArrayList<>();
        for(int i = 10;i < chars.length; i ++){
            num <<= 2;
            if(chars[i] == 'C'){
                num |= 1;
            }
            else if(chars[i] == 'G'){
                num |= 2;
            }
            else if(chars[i] == 'T'){
                num |= 3;
            }
            num &= task;
            freq[num] ++;
            if(freq[num] == 2){
                list.add(num);
            }
        }
        List<String> res = new ArrayList<>(list.size());
        for(Integer nums : list){
            char[] tmp = new char[10];
            for(int i = 9;i >= 0 ; i --){
                switch (nums & 3){
                    case 0:tmp[i] = 'A';break;
                    case 1:tmp[i] = 'C';break;
                    case 2:tmp[i] = 'G';break;
                    case 3:tmp[i] = 'T';break;
                }
                nums >>= 2;
            }
            res.add(new String(tmp));
        }
        return res;
    }
}
