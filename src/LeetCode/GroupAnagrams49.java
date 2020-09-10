package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * LeetCode 49
 * 题意：给定一个字符串数组，将字母异位词组合在一起。
 * 字母异位词指字母相同，但排列不同的字符串。
 * 示例:
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * 说明：
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 * 思路：本质是统计字母出现的次数，因为都是小写字母，可以用int[26]数组统计出现的次数，
 *      转为string，作为map的key，value是异构词组成的list
 *      与之前不同之处：用特殊字符隔开，否则某些情况出现错误
 *      13.40% , 8.45%
 */
public class GroupAnagrams49 {
    public static void main(String[] args) {
      //  String[] strs = {"eat","tea","tan","ate","nat","bat"};
        String[] strs = {"bdddddddddd","bbbbbbbbbbc"};
        List<List<String>> res = groupAnagrams(strs);
        System.out.println(res);
    }
    public static List<List<String>> groupAnagrams(String[] strs){
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for(int i = 0 ; i < strs.length; i ++){
            String num = getNum(strs[i]);
            System.out.println(strs[i] + ", " + num);
            if(map.containsKey(num)){
                map.get(num).add(strs[i]);
            }
            else{
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                map.put(num , list);
            }
        }
        for(Map.Entry<String , List<String>> entry : map.entrySet()){
            res.add(entry.getValue());
        }
        return res;
    }

    private static String getNum(String str) {
        int[] arr = new int[26];
        for(int i = 0 ; i < str.length(); i ++){
            arr[str.charAt(i) - 'a'] ++ ;
        }
        StringBuffer sb = new StringBuffer();
        for(int i = 0 ; i < 26; i ++){     // b 10,c1 , and b 1,c 0,d 10一致，所以需添加特殊字符隔开
            sb.append(arr[i]).append(",");
        }
        return sb.toString();
    }
}
